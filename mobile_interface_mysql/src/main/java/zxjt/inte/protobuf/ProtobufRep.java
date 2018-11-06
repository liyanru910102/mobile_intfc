package zxjt.inte.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

public class ProtobufRep {
	static Logger log = Logger.getLogger(ParamConstant.LOGGER);

	/**
	 * 唯一的响应体
	 * 
	 * @param stream
	 *            响应流
	 */
	public static void multi_selectedStocks_rep(InputStream stream, Map<String, String> regexMap) {
		try {
			Protobuf.multi_selectedStocks_rep response = Protobuf.multi_selectedStocks_rep.parseFrom(stream);
			selectedStocks_rep(response, regexMap);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JsonAssertUtil.throwAssertError();
		}
	}

	public static void multi_blockRank_rep(InputStream stream, Map<String, String> regexMap) {
		try {
			Protobuf.multi_blockRank_rep response = Protobuf.multi_blockRank_rep.parseFrom(stream);
			blockRank_rep(response, regexMap);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JsonAssertUtil.throwAssertError();
		}
	}

	public static void selectedStocks_rep(Protobuf.multi_selectedStocks_rep response, Map<String, String> regexMap) {
		List<Protobuf.selectedStocks_rep> listres = response.getRepsList();
		for (Protobuf.selectedStocks_rep selectedStocksRep : listres) {
			multiStocks_rep(selectedStocksRep, regexMap);
		}
	}

	public static void multiStocks_rep(Protobuf.selectedStocks_rep selectedStocksRep, Map<String, String> regexMap) {
		try {
			Protobuf.multiStocks_rep multiStocksRep = selectedStocksRep.getRep();
			ProtobufOption.rank_option(multiStocksRep, regexMap);
			protobufData.stock_details_data(multiStocksRep, regexMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void multiStocks_rep(Protobuf.stockRank_rep stockRankRep, Map<String, String> regexMap) {
		Protobuf.multiStocks_rep multiStocksRep = stockRankRep.getRep();
		ProtobufOption.rank_option(multiStocksRep,regexMap);
		protobufData.stock_details_data(multiStocksRep,regexMap);
	}

	public static void blockRank_rep(Protobuf.multi_blockRank_rep multiBlockRankRep, Map<String, String> regexMap) {

		List<Protobuf.blockRank_rep> blockRankRepList = multiBlockRankRep.getRepsList();
		for (Protobuf.blockRank_rep blockRankRep : blockRankRepList) {
			ProtobufOption.rank_option(blockRankRep, regexMap);
			ProtobufRepeated.blockRank_repeated(blockRankRep, regexMap);
		}
	}

	public static void codeList_rep(InputStream stream, Map<String, String> regexMap) {

		try {
			Protobuf.codeList_rep response = Protobuf.codeList_rep.parseFrom(stream);

			if (regexMap.keySet().contains(ParamConstant.VERSION)) {
				log.info("version:" + response.getVersion());
				JsonAssertUtil.assertRegex(ParamConstant.VERSION, String.valueOf(response.getVersion()),
						regexMap.get(ParamConstant.VERSION));
			}
			log.info("codeList_add_repeated add_arr *****:");
			ProtobufRepeated.codeList_add_repeated(response, regexMap);
			log.info("codeList_del_repeated del_arr *****:");
			ProtobufRepeated.codeList_del_repeated(response, regexMap);
			/**以下是目前暂未用到的，预留需要时添加*/
//			log.info("uuid_version:" + response.getUuidVersion());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JsonAssertUtil.throwAssertError();
		}
	}

	public static void multi_stockRank_rep(InputStream stream, Map<String, String> regexMap) {

		try {
			Protobuf.multi_stockRank_rep response = Protobuf.multi_stockRank_rep.parseFrom(stream);
			stockRank_rep(response,regexMap);
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JsonAssertUtil.throwAssertError();
		}

	}

	public static void multi_stock_united_rep(InputStream stream, Map<String, String> regexMap) {

		try {
			Protobuf.multi_stock_united_rep response = Protobuf.multi_stock_united_rep.parseFrom(stream);
			stock_united_rep(response,regexMap);
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JsonAssertUtil.throwAssertError();
		}

	}

	public static void stockRank_rep(Protobuf.multi_stockRank_rep multiStockRankRep, Map<String, String> regexMap) {

		List<Protobuf.stockRank_rep> stockRankRepList = multiStockRankRep.getRepsList();
		for (Protobuf.stockRank_rep stockRankRep : stockRankRepList) {
			multiStocks_rep(stockRankRep,regexMap);
		}
	}

	public static void stock_united_rep(Protobuf.multi_stock_united_rep multiStockUnitedRep, Map<String, String> regexMap) {

		List<Protobuf.stock_united_rep> stockUnitedRepList = multiStockUnitedRep.getRepsList();
		for (Protobuf.stock_united_rep stockUnitedRep : stockUnitedRepList) {
			protobufData.stock_details_data(stockUnitedRep,regexMap);
			stock_timeDivision_rep(stockUnitedRep, regexMap);
			stock_tradeDetail_rep(stockUnitedRep, regexMap);
			
			/**以下是目前暂未用到的，预留需要时添加*/
//			stock_kline_rep(stockUnitedRep);
//			System.out.println("wMarketID:" + stockUnitedRep.getWMarketID());
//			System.out.println("sPszCode:" + stockUnitedRep.getSPszCode());
//			System.out.println("***************************");
//			System.out.println("***************************");
		}
	}

	public static void stock_kline_rep(Protobuf.stock_united_rep stockUnitedRep) {
		Protobuf.stock_kline_rep stockKlineRep = stockUnitedRep.getKlineData();
		System.out.println("wKXType:" + stockKlineRep.getWKXType());
		System.out.println("needFQ:" + stockKlineRep.getNeedFQ());
		System.out.println("kline_data_arr:::::::");
		protobufData.stock_kline_data(stockKlineRep);
	}

	public static void stock_timeDivision_rep(Protobuf.stock_united_rep stockUnitedRep, Map<String, String> regexMap) {
		Protobuf.stock_timeDivision_rep stockTimeDivisionRep = stockUnitedRep.getTimeDivisionData();
		if (regexMap.keySet().contains(ParamConstant.NMAXVOL)) {
			log.info("nMaxVol:" + stockTimeDivisionRep.getNMaxVol());
			JsonAssertUtil.assertRegex(ParamConstant.NMAXVOL, String.valueOf(stockTimeDivisionRep.getNMaxVol()),
					regexMap.get(ParamConstant.NMAXVOL));
		}
		
		protobufData.stock_timeDivision_data(stockTimeDivisionRep, regexMap);
	}

	public static void stock_tradeDetail_rep(Protobuf.stock_united_rep stockUnitedRep, Map<String, String> regexMap) {
		Protobuf.stock_tradeDetail_rep stockTradeDetailRep = stockUnitedRep.getTradeDetailData();
		if (regexMap.keySet().contains(ParamConstant.NBUYP)) {
			log.info("nBuyp:" + stockTradeDetailRep.getNBuyp());
			JsonAssertUtil.assertRegex(ParamConstant.NBUYP, String.valueOf(stockTradeDetailRep.getNBuyp()),
					regexMap.get(ParamConstant.NBUYP));
		}
		if (regexMap.keySet().contains(ParamConstant.NSELP)) {
			log.info("nSelp:" + stockTradeDetailRep.getNSelp());
			JsonAssertUtil.assertRegex(ParamConstant.NSELP, String.valueOf(stockTradeDetailRep.getNSelp()),
					regexMap.get(ParamConstant.NSELP));
		}
		log.info("stock_tradeDetail_data data_arr::::");
		protobufData.stock_tradeDetail_data(stockTradeDetailRep,regexMap);
	}
}