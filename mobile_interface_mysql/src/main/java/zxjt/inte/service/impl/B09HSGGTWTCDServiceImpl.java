package zxjt.inte.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.CommonJYDao;
import zxjt.inte.entity.CommonInfo;
import zxjt.inte.entity.CommonJY;
import zxjt.inte.service.B09HSGGTWTCDService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.GetConfigProperties;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;
import zxjt.inte.util.WTXHBean;

@Service
public class B09HSGGTWTCDServiceImpl implements B09HSGGTWTCDService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonJYDao hsggtDao;

	public Object[][] getParamsInfo() {

		// 公共参数操作
		List<CommonInfo> lisag = GetConfigProperties.getConfigProToCommon();
		Map<String, String> commonParam = CommonToolsUtil.getCommonParam(lisag);

		// 股票买卖数据操作
		List<CommonJY> lis = hsggtDao.getParamsInfo(ParamConstant.HSGGT_WTCD_ID);
		List<Map<String, String>> lisTemp = CommonToolsUtil.getDependencyParamsInfo(lis, commonParam);

		// 根据委托下单时保存的序号，将相关数据拼到入参中
		List<Map<String, String>> lisParam = new ArrayList<>();
		for (Object o : WTXHBean.ConkeySet()) {
			for (int j = 0; j < lisTemp.size(); j++) {
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.putAll(lisTemp.get(j));
				String[] key = ((String) o).split("_");
				if (ParamConstant.GGTMM_KEY.equals(key[0])
						&& paramMap.get(ParamConstant.JYSDM).equals(key[key.length - 1])) {

					Map<String, String> wtxhMap = WTXHBean.getMap((String) o);
					paramMap.put(ParamConstant.GDDM, wtxhMap.get(ParamConstant.GDDM));
					paramMap.put(ParamConstant.WTXH, wtxhMap.get(ParamConstant.WTXH));
					lisParam.add(paramMap);
					break;
				}
			}
		}

		Object[][] obj = new Object[lisParam.size()][1];
		for (int i = 0; i < obj.length; i++) {
			obj[i][0] = lisParam.get(i);
		}
		return obj;
	}

	/**
	 * 发送请求并校验返回结果
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public void test(Map<String, String> param) {

		Map<String, String> map = CommonToolsUtil.getRParam(param);

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());

		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());

		// 校验
		JsonAssertUtil.checkResponse(param, null, ParamConstant.B09_SCHEMA, ParamConstant.PTYW, response);
	}
}
