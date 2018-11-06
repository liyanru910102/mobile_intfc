package zxjt.inte.protobuf;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

public class ProtobufRepeated {
	static Logger log = Logger.getLogger(ParamConstant.LOGGER);

	public static void stock_tradeClassify_data_repeated(Protobuf.stock_details_data stockDetailsData) {
		Protobuf.stock_tradeClassify_data_repeated stock_tradeClassify_data_repeated = stockDetailsData
				.getTradeClassifyDataArr();
		protobufData.stock_tradeClassify_data(stock_tradeClassify_data_repeated);
		ProtobufPair.price_volume_pair(stock_tradeClassify_data_repeated);
	}

	public static void codeList_add_repeated(Protobuf.codeList_rep codeListRep, Map<String, String> regexMap) {
		List<Protobuf.codeList_add_repeated> codeListAddRepeated = codeListRep.getAddArrList();
		for (Protobuf.codeList_add_repeated codeList : codeListAddRepeated) {

			if (regexMap.keySet().contains(ParamConstant.CODELIST_ADD_REPEATED_CODE)) {
				log.info("code:" + codeList.getCode());
				JsonAssertUtil.assertRegex(ParamConstant.CODELIST_ADD_REPEATED_CODE, codeList.getCode(),
						regexMap.get(ParamConstant.CODELIST_ADD_REPEATED_CODE));
			}
			if (regexMap.keySet().contains(ParamConstant.NAME)) {
				log.info("name:" + codeList.getName());
				JsonAssertUtil.assertRegex(ParamConstant.NAME, codeList.getName(), regexMap.get(ParamConstant.NAME));
			}
			if (regexMap.keySet().contains(ParamConstant.MARKET_ID)) {
				log.info("market_id:" + codeList.getMarketId());
				JsonAssertUtil.assertRegex(ParamConstant.MARKET_ID, String.valueOf(codeList.getMarketId()),
						regexMap.get(ParamConstant.MARKET_ID));
			}
			if (regexMap.keySet().contains(ParamConstant.CODE_TYPE)) {
				log.info("code_type:" + codeList.getCodeType());
				JsonAssertUtil.assertRegex(ParamConstant.CODE_TYPE, String.valueOf(codeList.getCodeType()),
						regexMap.get(ParamConstant.CODE_TYPE));
			}
			if (regexMap.keySet().contains(ParamConstant.PINYIN)) {
				log.info("pinyin:" + codeList.getPinyin());
				JsonAssertUtil.assertRegex(ParamConstant.PINYIN, codeList.getPinyin(),
						regexMap.get(ParamConstant.PINYIN));
			}
			if (regexMap.keySet().contains(ParamConstant.PSZMARK)) {
				log.info("pszMark:" + codeList.getPszMark());
				JsonAssertUtil.assertRegex(ParamConstant.PSZMARK, codeList.getPszMark(),
						regexMap.get(ParamConstant.PSZMARK));
			}
			log.info("**********************");
			log.info("**********************");
		}
	}

	public static void codeList_del_repeated(Protobuf.codeList_rep codeListRep, Map<String, String> regexMap) {
		List<Protobuf.codeList_del_repeated> codeListDelRepeated = codeListRep.getDelArrList();
		for (Protobuf.codeList_del_repeated codeList : codeListDelRepeated) {

			if (regexMap.keySet().contains(ParamConstant.CODELIST_DEL_REPEATED_CODE)) {
				log.info("code:" + codeList.getCode());
				JsonAssertUtil.assertRegex(ParamConstant.CODELIST_DEL_REPEATED_CODE, codeList.getCode(),
						regexMap.get(ParamConstant.CODELIST_DEL_REPEATED_CODE));
			}
			if (regexMap.keySet().contains(ParamConstant.MARKET_ID)) {
				log.info("market_id:" + codeList.getMarketId());
				JsonAssertUtil.assertRegex(ParamConstant.MARKET_ID, String.valueOf(codeList.getMarketId()),
						regexMap.get(ParamConstant.MARKET_ID));
			}
			log.info("**********************");
			log.info("**********************");
		}
	}

	public static void blockRank_repeated(Protobuf.blockRank_rep blockRankRep, Map<String, String> regexMap) {

		List<Protobuf.blockRank_repeated> blockRankRepeatedList = blockRankRep.getDataArrList();
		for (Protobuf.blockRank_repeated blockRankRepeated : blockRankRepeatedList) {

			if (regexMap.keySet().contains(ParamConstant.SSTOCKCODE)) {
				log.info("sStockCode:" + blockRankRepeated.getSStockCode());
				JsonAssertUtil.assertRegex(ParamConstant.SSTOCKCODE, blockRankRepeated.getSStockCode(),
						regexMap.get(ParamConstant.SSTOCKCODE));
			}
			if (regexMap.keySet().contains(ParamConstant.PSZSTOCKNAME)) {
				log.info("pszStockName:" + blockRankRepeated.getPszStockName());
				JsonAssertUtil.assertRegex(ParamConstant.PSZSTOCKNAME, blockRankRepeated.getPszStockName(),
						regexMap.get(ParamConstant.PSZSTOCKNAME));
			}
			if (regexMap.keySet().contains(ParamConstant.SCODE)) {
				log.info("sCode:" + blockRankRepeated.getSCode());
				JsonAssertUtil.assertRegex(ParamConstant.SCODE, blockRankRepeated.getSCode(),
						regexMap.get(ParamConstant.SCODE));
			}
			if (regexMap.keySet().contains(ParamConstant.PSZBKNAME)) {
				log.info("pszBkName:" + blockRankRepeated.getPszBkName());
				JsonAssertUtil.assertRegex(ParamConstant.PSZBKNAME, blockRankRepeated.getPszBkName(),
						regexMap.get(ParamConstant.PSZBKNAME));
			}
			if (regexMap.keySet().contains(ParamConstant.FZDF)) {
				log.info("fZdf:" + blockRankRepeated.getFZdf());
				JsonAssertUtil.assertRegex(ParamConstant.FZDF, String.valueOf(blockRankRepeated.getFZdf()),
						regexMap.get(ParamConstant.FZDF));
			}
			if (regexMap.keySet().contains(ParamConstant.FIRST_ZDF)) {
				log.info("first_zdf:" + blockRankRepeated.getFirstZdf());
				JsonAssertUtil.assertRegex(ParamConstant.FIRST_ZDF, String.valueOf(blockRankRepeated.getFirstZdf()),
						regexMap.get(ParamConstant.FIRST_ZDF));
			}
			if (regexMap.keySet().contains(ParamConstant.FIRST_PRICE)) {
				log.info("first_price:" + blockRankRepeated.getFirstPrice());
				JsonAssertUtil.assertRegex(ParamConstant.FIRST_PRICE, String.valueOf(blockRankRepeated.getFirstPrice()),
						regexMap.get(ParamConstant.FIRST_PRICE));
			}

			log.info("**********************");
			log.info("**********************");
		}
	}
}