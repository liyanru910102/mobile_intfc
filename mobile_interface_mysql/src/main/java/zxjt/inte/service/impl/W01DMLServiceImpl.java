package zxjt.inte.service.impl;

import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.CommonWWDao;
import zxjt.inte.protobuf.ProtobufHttp;
import zxjt.inte.protobuf.ProtobufRep;
import zxjt.inte.protobuf.ProtobufReq;
import zxjt.inte.service.W01DMLService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

/**
 * 代码链查询
 * 
 * @author Administrator
 *
 */
@Service
public class W01DMLServiceImpl implements W01DMLService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonWWDao wwDao;

	public Object[][] getParamsInfo() {
		try {
			Object[][] obj = CommonToolsUtil.getWWservice(wwDao, ParamConstant.DML_ID);
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
			byte[] postdata = ProtobufReq.codeList_req(map);
			InputStream stream = ProtobufHttp.post(postdata, param.get("url"));

			// 添加动态校验正则表达式
			Map<String, String> regexMap = JsonAssertUtil.getRegex(null, ParamConstant.WW,
					ParamConstant.W01_SCHEMA + ParamConstant.SCHEMA_ZL);
			ProtobufRep.codeList_rep(stream, regexMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
