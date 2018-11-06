package zxjt.inte.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.CommonWWDao;
import zxjt.inte.service.W06YCXService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class W06YCXServiceImpl implements W06YCXService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonWWDao wwDao;

	public Object[][] getParamsInfo() {
		try {
			Object[][] obj = CommonToolsUtil.getWWservice(wwDao, ParamConstant.YCX_ID);
			return obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 发送请求并校验返回结果
	 * 
	 * @param 入参
	 * @DependenceParam 依赖接口的入参
	 */
	public void test(Map<String, String> param) {
		try {
			Map<String, String> map = CommonToolsUtil.getRParam(param);
			System.out.println(param.toString());
			System.out.println(map.toString());
			log.info(param.toString());
			log.info(map.toString());

			// 发请求
			String response = HttpUtil_All.doGet(param.get("url"));
			System.out.println(response);
			log.info(response.toString());
			
			// 拼接
			Map<String, String> valMap = new HashMap<>();
			valMap.put("stock_code", "^000001$");

			// 校验
			JsonAssertUtil.checkResponse(param, valMap, ParamConstant.W06_SCHEMA, ParamConstant.WW, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}