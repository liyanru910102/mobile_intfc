package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.CommonJYDao;
import zxjt.inte.entity.CommonInfo;
import zxjt.inte.entity.CommonJY;
import zxjt.inte.service.A01GPMMService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.GetConfigProperties;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class A01GPMMServiceImpl implements A01GPMMService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonJYDao gpmmDao;

	public Object[][] getParamsInfo() {

		// 公共参数操作
		List<CommonInfo> lisag = GetConfigProperties.getConfigProToCommon();
		Map<String, String> commonParam = CommonToolsUtil.getCommonParam(lisag);

		// 股票买卖数据操作
		List<CommonJY> lis = gpmmDao.getParamsInfo(ParamConstant.GPMM_ID);
		List<Map<String, String>> lisTemp = CommonToolsUtil.getDependencyParamsInfo(lis, commonParam);

		// 限价可买卖信息查询数据操作
		List<CommonJY> listA01 = gpmmDao.getParamsInfo(ParamConstant.KMMXXCX_ID);
		Map<String, String> MapDepenParam = CommonToolsUtil.getDependencyParamInfo(listA01, commonParam);

		// 市价可买卖信息查询数据操作
		List<CommonJY> listA02 = gpmmDao.getParamsInfo(ParamConstant.SJKMMXXCX_ID);
		Map<String, String> MapDepenSjParam = CommonToolsUtil.getDependencyParamInfo(listA02, commonParam);

		Object[][] obj = new Object[lisTemp.size()][2];
		for (int j = 0; j < obj.length; j++) {

			obj[j][0] = lisTemp.get(j);
			Map<String, String> mps = new HashMap<String, String>();
			if ("0".equals(lisTemp.get(j).get("wtlx"))) {

				mps.putAll(MapDepenParam);

			} else {
				mps.putAll(MapDepenSjParam);
			}
			obj[j][1] = mps;
		}
		return obj;
	}

	/**
	 * 发送请求并校验返回结果
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public void test(Map<String, String> param, Map<String, String> DependenceParam) {

		Map<String, String> map = CommonToolsUtil.getRParam(param);

		// 处理依赖接口发送请求、取得参数等操作
		if ("0".equals(map.get("wtlx"))) {
			DependenceParam.put("zqdm", map.get("zqdm"));

		} else {
			DependenceParam.put("zqdm", map.get("zqdm"));
			DependenceParam.put("wtlx", map.get("wtlx"));
		}
		
		//发请求
		System.out.println(DependenceParam.toString());
		log.info(DependenceParam.toString());
		Map<String, String> Depmap = CommonToolsUtil.getRParam(DependenceParam);
		String cxResponse = HttpUtil_All.doPostSSL(DependenceParam.get("url"), Depmap);
//		String cxResponse = CommonToolsUtil.getResponseInfo(DependenceParam);
		System.out.println(cxResponse.toString());
		log.info(cxResponse.toString());

		// 根据买卖类别判断校验内容
		Map<String, String> mapRegex = new HashMap<String, String>();
		if ("B".equals(map.get("mmlb"))) {
			mapRegex.put("kmmxx_kmsl", "^[0-9]+$");
		}
		if ("S".equals(map.get("mmlb"))) {
			mapRegex.put("kmmxx_gfkys", "^[0-9]+$");
		}

		// 根据类型校验响应
		if ("0".equals(map.get("wtlx"))) {
			JsonAssertUtil.checkResponse(DependenceParam, mapRegex, ParamConstant.A01_1_SCHEMA, ParamConstant.PTYW, cxResponse);
		} else {
			JsonAssertUtil.checkResponse(DependenceParam, mapRegex, ParamConstant.A01_2_SCHEMA, ParamConstant.PTYW, cxResponse);
		}

		// 从查询接口获取下单需要的数据
		String price = CommonToolsUtil.getPrice(map.get("wtjg"), cxResponse);
		String wtsl = CommonToolsUtil.getOverBSQty(map.get("mmlb"), map.get("wtsl"), cxResponse);
		String jysdm = JsonAssertUtil.getValue(cxResponse, "$.kmmxx[0].jysdm");
		String gddm = JsonAssertUtil.getValue(cxResponse, "$.kmmxx[0].gddm");

		// 处理接口的入参赋值、发送请求、返回值校验操作
		map.put("wtjg", price);
		map.put("wtsl", wtsl);
		map.put("jysdm", jysdm);
		map.put("gddm", gddm);

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());
		String response = HttpUtil_All.doPostSSL(param.get("url"), map);
		System.out.println(response.toString());
		log.info(response.toString());

		//添加动态校验正则表达式
		Map<String, String> valMap = new HashMap<>();
		valMap.put("message", JsonAssertUtil.getMsgRex(param.get("expectMsg")));
		
		//校验响应字符串
		JsonAssertUtil.checkResponse(param, valMap, ParamConstant.A01_SCHEMA,ParamConstant.PTYW, response);

	}

}
