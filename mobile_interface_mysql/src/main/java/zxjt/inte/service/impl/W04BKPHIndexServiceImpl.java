package zxjt.inte.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import zxjt.inte.dao.CommonWWDao;
import zxjt.inte.protobuf.ProtobufHttp;
import zxjt.inte.protobuf.ProtobufRep;
import zxjt.inte.protobuf.ProtobufReq;
import zxjt.inte.service.W04BKPHIndexService;
import zxjt.inte.util.CommonToolsUtil;
import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

@Service
public class W04BKPHIndexServiceImpl implements W04BKPHIndexService {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	@Resource
	private CommonWWDao wwDao;

	public Object[][] getParamsInfo() {
		try {
			Object[][] obj = CommonToolsUtil.getWWservice(wwDao, ParamConstant.BKPHINDEX_ID);
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
			byte[] postdata = ProtobufReq.blockRankIndex_req(map);
			InputStream stream = ProtobufHttp.post(postdata, param.get("url"));
			
			//添加动态校验正则表达式
			Map<String, String> valMap = new HashMap<>();
			valMap.put(ParamConstant.BSORT, ParamConstant.REGEXBEGIN+param.get(ParamConstant.BSORT)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.BDIRECT, ParamConstant.REGEXBEGIN+param.get(ParamConstant.BDIRECT)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.WFROM, ParamConstant.REGEXBEGIN+param.get(ParamConstant.WFROM)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.WCOUNT, ParamConstant.REGEXBEGIN+param.get(ParamConstant.WCOUNT)+ParamConstant.REGEXEND);
			valMap.put(ParamConstant.FIELDSBITMAP, ParamConstant.REGEXBEGIN+param.get(ParamConstant.FIELDSBITMAP)+ParamConstant.REGEXEND);
			
			Map<String, String> regexMap =JsonAssertUtil.getRegex(valMap, ParamConstant.WW, ParamConstant.W04_SCHEMA+ParamConstant.SCHEMA_ZL);
			
			ProtobufRep.multi_blockRank_rep(stream,regexMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
