package zxjt.inte.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

import zxjt.inte.dao.CommonJYDao;
import zxjt.inte.entity.CommonInfo;
import zxjt.inte.entity.CommonJY;
import zxjt.inte.service.B02HSGGTKMMSLCXService;
import zxjt.inte.service.B08HSGGTWTXDService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.GetConfigProperties;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;
import zxjt.inte.util.WTXHBean;

@Service
public class B08HSGGTWTXDServiceImpl implements B08HSGGTWTXDService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonJYDao hsggtDao;

	public Object[][] getParamsInfo() {

		// 公共参数操作
		List<CommonInfo> lisag = GetConfigProperties.getConfigProToCommon();
		Map<String, String> commonParam = CommonToolsUtil.getCommonParam(lisag);

		// 股票买卖数据操作
		List<CommonJY> lis = hsggtDao.getParamsInfo(ParamConstant.HSGGT_WTXD_ID);
		List<Map<String, String>> lisTemp = CommonToolsUtil.getDependencyParamsInfo(lis, commonParam);

		// 股票买卖数据操作
		List<CommonJY> lisKmmsl = hsggtDao.getParamsInfo(ParamConstant.HSGGT_KMMSLCX_ID);
		Map<String, String> tempKmmsl = CommonToolsUtil.getDependencyParamInfo(lisKmmsl, commonParam);

		Object[][] obj = new Object[lisTemp.size()][2];
		for (int j = 0; j < obj.length; j++) {

			obj[j][0] = lisTemp.get(j);
			obj[j][1] = tempKmmsl;
		}
		return obj;
	}

	/**
	 * 发送请求并校验返回结果
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public void test(Map<String, String> param, Map<String, String> tempKmmsl, B02HSGGTKMMSLCXService kmmslcxService) {

		// 获取可买卖数量查询接口响应值
		String kmmslResponse = getKmmslResponse(param, tempKmmsl, kmmslcxService);

		// 获取委托下单所需要的map
		Map<String, String> map = CommonToolsUtil.getRParam(getWtxdParamMap(kmmslResponse, param));

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());

		// 判断当前时间是否属于不可下单时间,如果属于，替换msg
		checkTime(param);

		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());

		// 添加动态校验正则表达式
		Map<String, String> valMap = new HashMap<>();
		valMap.put(ParamConstant.MESSAGE, JsonAssertUtil.getMsgRex(param.get(ParamConstant.EXPECTMSG)));

		// 校验
		JsonAssertUtil.checkResponse(param, valMap, ParamConstant.B08_SCHEMA, ParamConstant.PTYW, response);

		if (ParamConstant.ZL.equalsIgnoreCase(param.get(ParamConstant.TYPE))) {
			// 获取撤单信息
			String wtxh = JsonPath.read(response, "$.htxx[0].htxh", new Predicate[0]);
			String gddm = map.get(ParamConstant.GDDM);
			String jysdm = map.get(ParamConstant.JYSDM);
			Map<String, String> cdxx = new HashMap<>();
			cdxx.put(ParamConstant.WTXH, wtxh);
			cdxx.put(ParamConstant.GDDM, gddm);
			cdxx.put(ParamConstant.JYSDM, jysdm);
			/** 在此处以“key_类别_类型_交易市场”的格式拼接，这样保证每个类型都可以撤一个；在撤单时，根据key的
			 * 头和尾部的值去判断并合成撤单的入参
			 */
			String key = ParamConstant.GGTMM_KEY +"_" +param.get(ParamConstant.MMLB) 
					+  "_" +param.get(ParamConstant.WTLX)+ "_" +param.get(ParamConstant.JYSDM);
			WTXHBean.putMap(key, cdxx);
		}
	}

	/**
	 * 获取可买卖数量查询接口响应值
	 * 
	 * @param param
	 * @param tempKmmsl
	 * @param kmmslcxService
	 * @return
	 */
	private String getKmmslResponse(Map<String, String> param, Map<String, String> tempKmmsl,
			B02HSGGTKMMSLCXService kmmslcxService) {
		// 获取可买卖数量相关信息
		Map<String, String> ggtMap = new HashMap<>();
		ggtMap.putAll(tempKmmsl);
		ggtMap.put(ParamConstant.JYSDM, param.get(ParamConstant.JYSDM));
		ggtMap.put(ParamConstant.GDDM, param.get(ParamConstant.GDDM));
		ggtMap.put(ParamConstant.ZQDM, param.get(ParamConstant.ZQDM));
		ggtMap.put(ParamConstant.WTJG, "");
		ggtMap.put(ParamConstant.MMLB, param.get(ParamConstant.MMLB));
		ggtMap.put(ParamConstant.WTLX, param.get(ParamConstant.WTLX));
		ggtMap.put(ParamConstant.WTSX, param.get(ParamConstant.WTSX));

		String kmmslResponse = kmmslcxService.dependentDest(ggtMap);
		return kmmslResponse;
	}

	/**
	 * 获取委托下单所需要的map
	 * 
	 * @param kmmslResponse
	 * @param param
	 * @return
	 */
	private Map<String, String> getWtxdParamMap(String kmmslResponse, Map<String, String> param) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.putAll(param);
		String kmsl;
		String mrzxdw;
		String gfkys;
		String mczxdw;
		String jysdm;
		String gddm;
		String wtjg;
		String wtsl;

		try {
			kmsl = JsonPath.read(kmmslResponse, "$.kmmxx[0].kmsl", new Predicate[0]);
			mrzxdw = JsonPath.read(kmmslResponse, "$.kmmxx[0].mrzxdw", new Predicate[0]);
			gfkys = JsonPath.read(kmmslResponse, "$.kmmxx[0].gfkys", new Predicate[0]);
			mczxdw = JsonPath.read(kmmslResponse, "$.kmmxx[0].mczxdw", new Predicate[0]);
			jysdm = JsonPath.read(kmmslResponse, "$.kmmxx[0].jysdm", new Predicate[0]);
			gddm = JsonPath.read(kmmslResponse, "$.kmmxx[0].gddm", new Predicate[0]);
			wtjg = CommonToolsUtil.getPrice(param.get(ParamConstant.WTJG), kmmslResponse);
		} catch (Exception e) {
			throw new RuntimeException("获取港股通可买卖数量查询信息失败");
		}

		// 对委托数量根据买入单位进行处理
		String parWtsl = param.get(ParamConstant.WTSL);
		if (ParamConstant.B.equals(param.get(ParamConstant.MMLB))) {
			wtsl = CommonToolsUtil.getWtsl(mrzxdw, kmsl, parWtsl, 10000);
		} else {
			wtsl = CommonToolsUtil.getWtsl(mczxdw, gfkys, parWtsl, 10000);
		}

		paramMap.put(ParamConstant.WTSL, wtsl);
		paramMap.put(ParamConstant.WTJG, wtjg);
		paramMap.put(ParamConstant.JYSDM, jysdm);
		paramMap.put(ParamConstant.GDDM, gddm);

		return paramMap;
	}

	/**
	 * 判断当前时间给出相应提示
	 * 
	 * @param param
	 */
	private void checkTime(Map<String, String> param) {
		// 判断当前时间给出相应提示
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat df = new SimpleDateFormat("HH:mm");
		String time = df.format(date);
		String[] s = time.split(":");

		/**
		 * 根据现有需求，指定时间段内不能交易，所以将msg修改为不能交易的信息，这样不管是否下单成功，都会失败，在报告中可以看到预期与实际的对比
		 * 1、当测试数据属于正例时，若实际是下单成功，那么接口错误；若实际是不能交易，则接口对于此种情况的判断正确，但此条下单数据未执行，需要再次执行
		 * 2、若测试数据属于反例时，若提示下单失败，那么接口错误；若提示不能交易，则接口对于此种情况的判断正确，但此案例并未真正通过，需要再次执行
		 * 所以只要时间不符合，就会报错，测试人员需根据报告中的预期与实际对比来进行验证操作 目前通过以上方式来保证程序对于这种特殊场合的正确覆盖
		 */
		if ("09".equals(s[0]) && Integer.valueOf(s[1]) >= 15 && Integer.valueOf(s[1]) <= 25
				&& "7".equals(param.get(ParamConstant.WTLX))) {
			param.put(ParamConstant.EXPECTMSG, "当前时间异常-当前交易时间禁止委托该买卖类别");
		}
	}
}
