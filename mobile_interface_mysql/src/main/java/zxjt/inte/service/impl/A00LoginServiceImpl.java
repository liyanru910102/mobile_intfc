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
import zxjt.inte.service.A00LoginService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.GetConfigProperties;
import zxjt.inte.util.HttpUtil_All;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class A00LoginServiceImpl implements A00LoginService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonJYDao loginDao;
	 public Object[][] getParamsInfo() {
		 
		// 登录参数操作，从config文件中取出值
		List<CommonInfo> lisag = GetConfigProperties.getConfigProToCommon();
		Map<String, String> commonParam = CommonToolsUtil.getCommonParam(lisag);

		// 从数据库中取出登录的数据
		List<CommonJY> lis = loginDao.getParamsInfo(ParamConstant.PTJYLOGIN_ID);
		// 拼接成测试数据
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

		// 发请求
		System.out.println(param.toString());
		System.out.println(map.toString());
		log.info(param.toString());
		log.info(map.toString());
//		map.remove("fjrsjxh");// TODO:等待字段的值确定下来
		System.out.println(map.toString());
		String response = HttpUtil_All.doPostSSL(param.get("url"), map);
		System.out.println(response.toString());
		log.info(response.toString());

		// 拼接
		Map<String, String> valMap = new HashMap<>();
		valMap.put("message", JsonAssertUtil.getMsgRex(param.get("expectMsg")));

		// 校验
		JsonAssertUtil.checkResponse(param, valMap, ParamConstant.A00_SCHEMA, ParamConstant.PTYW, response);
	}
}
