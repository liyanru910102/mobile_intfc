package zxjt.inte.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.CommonJYDao;
import zxjt.inte.entity.CommonInfo;
import zxjt.inte.entity.CommonJY;
import zxjt.inte.service.B07HSGGTLSCJCXService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.GetConfigProperties;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class B07HSGGTLSCJCXServiceImpl implements  B07HSGGTLSCJCXService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonJYDao hsggtDao;

	public Object[][] getParamsInfo() {

		// 公共参数操作
		List<CommonInfo> lisag = GetConfigProperties.getConfigProToCommon();
		Map<String, String> commonParam = CommonToolsUtil.getCommonParam(lisag);

		// 股票买卖数据操作
		List<CommonJY> lis = hsggtDao.getParamsInfo(ParamConstant.HSGGT_LSCJCX_ID);
		List<Map<String, String>> lisTemp = CommonToolsUtil.getDependencyParamsInfo(lis, commonParam);

		Object[][] obj = new Object[lisTemp.size()][1];
		for (int j = 0; j < obj.length; j++) {

			obj[j][0] = lisTemp.get(j);
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

		CommonToolsUtil.getcxrqInfo(map);
		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());

		log.info(param.toString());
		log.info(map.toString());

		String response = HttpUtil_All.doPostSSL(param.get(ParamConstant.URL), map);
		System.out.println(response.toString());
		log.info(response.toString());

		// 校验
		JsonAssertUtil.checkResponse(param, null, ParamConstant.B07_SCHEMA, ParamConstant.PTYW, response);
		JsonAssertUtil.checkDateIsBetweenIn(response, ParamConstant.CJRQ, map);
	}
}
