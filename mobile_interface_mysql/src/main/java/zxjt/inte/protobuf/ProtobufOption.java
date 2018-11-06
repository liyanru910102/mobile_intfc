package zxjt.inte.protobuf;

import java.util.Map;

import org.apache.log4j.Logger;

import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

public class ProtobufOption {
	static Logger log = Logger.getLogger(ParamConstant.LOGGER);

	public static void rank_option(Protobuf.multiStocks_rep multiStocksRep, Map<String, String> regexMap) {
		Protobuf.rank_option rankOption = multiStocksRep.getOptions();
		log.info("wType: " + rankOption.getWType());
		JsonAssertUtil.assertRegex(ParamConstant.WTYPE, String.valueOf(rankOption.getWType()),
				regexMap.get(ParamConstant.WTYPE));
		log.info("bSort:" + rankOption.getBSort());
		JsonAssertUtil.assertRegex(ParamConstant.BSORT, String.valueOf(rankOption.getBSort()),
				regexMap.get(ParamConstant.BSORT));
		log.info("bDirect:" + rankOption.getBDirect());
		JsonAssertUtil.assertRegex(ParamConstant.BDIRECT, String.valueOf(rankOption.getBDirect()),
				regexMap.get(ParamConstant.BDIRECT));
		log.info("wFrom:" + rankOption.getWFrom());
		JsonAssertUtil.assertRegex(ParamConstant.WFROM, String.valueOf(rankOption.getWFrom()),
				regexMap.get(ParamConstant.WFROM));
		log.info("wCount:" + rankOption.getWCount());
		JsonAssertUtil.assertRegex(ParamConstant.WCOUNT, String.valueOf(rankOption.getWCount()),
				regexMap.get(ParamConstant.WCOUNT));
		log.info("fields_bitMap:" + rankOption.getFieldsBitMap());
		JsonAssertUtil.assertRegex(ParamConstant.FIELDSBITMAP, String.valueOf(rankOption.getFieldsBitMap()),
				regexMap.get(ParamConstant.FIELDSBITMAP));
		if (regexMap.keySet().contains(ParamConstant.WTOTALCOUNT)) {
			log.info("wTotalCount:" + rankOption.getWTotalCount());
			JsonAssertUtil.assertRegex(ParamConstant.WTOTALCOUNT, String.valueOf(rankOption.getWTotalCount()),
					regexMap.get(ParamConstant.WTOTALCOUNT));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKCLASSNAME)) {
			log.info("blockClassName:" + rankOption.getBlockClassName());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKCLASSNAME, rankOption.getBlockClassName(),
					regexMap.get(ParamConstant.BLOCKCLASSNAME));
		}
		log.info("****************");
		log.info("****************");
	}

	public static void rank_option(Protobuf.blockRank_rep blockRankRep, Map<String, String> regexMap) {
		Protobuf.rank_option rankOption = blockRankRep.getOptions();
		log.info("wType: " + rankOption.getWType());
		JsonAssertUtil.assertRegex(ParamConstant.WTYPE, String.valueOf(rankOption.getWType()),
				regexMap.get(ParamConstant.WTYPE));
		log.info("bSort:" + rankOption.getBSort());
		JsonAssertUtil.assertRegex(ParamConstant.BSORT, String.valueOf(rankOption.getBSort()),
				regexMap.get(ParamConstant.BSORT));
		log.info("bDirect:" + rankOption.getBDirect());
		JsonAssertUtil.assertRegex(ParamConstant.BDIRECT, String.valueOf(rankOption.getBDirect()),
				regexMap.get(ParamConstant.BDIRECT));
		log.info("wFrom:" + rankOption.getWFrom());
		JsonAssertUtil.assertRegex(ParamConstant.WFROM, String.valueOf(rankOption.getWFrom()),
				regexMap.get(ParamConstant.WFROM));
		log.info("wCount:" + rankOption.getWCount());
		JsonAssertUtil.assertRegex(ParamConstant.WCOUNT, String.valueOf(rankOption.getWCount()),
				regexMap.get(ParamConstant.WCOUNT));
		log.info("fields_bitMap:" + rankOption.getFieldsBitMap());
		JsonAssertUtil.assertRegex(ParamConstant.FIELDSBITMAP, String.valueOf(rankOption.getFieldsBitMap()),
				regexMap.get(ParamConstant.FIELDSBITMAP));
		if (regexMap.keySet().contains(ParamConstant.WTOTALCOUNT)) {
			log.info("wTotalCount:" + rankOption.getWTotalCount());
			JsonAssertUtil.assertRegex(ParamConstant.WTOTALCOUNT, String.valueOf(rankOption.getWTotalCount()),
					regexMap.get(ParamConstant.WTOTALCOUNT));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKCLASSNAME)) {
			log.info("blockClassName:" + rankOption.getBlockClassName());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKCLASSNAME, rankOption.getBlockClassName(),
					regexMap.get(ParamConstant.BLOCKCLASSNAME));
		}
		log.info("****************");
		log.info("****************");
	}
}