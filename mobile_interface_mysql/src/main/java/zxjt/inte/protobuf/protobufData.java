package zxjt.inte.protobuf;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

public class protobufData {
	static Logger log = Logger.getLogger(ParamConstant.LOGGER);

	public static void stock_tradeClassify_data(

			Protobuf.stock_tradeClassify_data_repeated stock_tradeClassify_data_repeated) {
		List<Protobuf.stock_tradeClassify_data> stock_tradeClassify_data = stock_tradeClassify_data_repeated
				.getTradeClassifyDataList();
		for (Protobuf.stock_tradeClassify_data data : stock_tradeClassify_data) {
			System.out.println("nBjg:" + data.getNBjg());
			System.out.println("nBsl:" + data.getNBsl());
			System.out.println("nSjg:" + data.getNSjg());
			System.out.println("nSsl:" + data.getNSsl());

			System.out.println("****************");
			System.out.println("****************");
		}
	}

	public static void hgt_cv_data(Protobuf.stock_details_data stockDetailsData) {
		Protobuf.hgt_cv_data hgt_cv_data = stockDetailsData.getHcd();
		System.out.println("startTime:" + hgt_cv_data.getStartTime());
		System.out.println("endTime:" + hgt_cv_data.getEndTime());
		System.out.println("vcm_refPrice:" + hgt_cv_data.getVcmRefPrice());
		System.out.println("vcm_lowPrice:" + hgt_cv_data.getVcmLowPrice());
		System.out.println("vcm_upPrice:" + hgt_cv_data.getVcmUpPrice());
		System.out.println("cas_refPrice:" + hgt_cv_data.getCasRefPrice());
		System.out.println("cas_lowPrice:" + hgt_cv_data.getCasLowPrice());
		System.out.println("cas_upPrice:" + hgt_cv_data.getCasUpPrice());
		System.out.println("direction:" + hgt_cv_data.getDirection());
		System.out.println("qty:" + hgt_cv_data.getQty());
		System.out.println("****************");
		System.out.println("****************");
	}

	public static void stock_details_data(Protobuf.multiStocks_rep multiStocksRep, Map<String, String> regexMap) {
		List<Protobuf.stock_details_data> listStockData = multiStocksRep.getDataArrList();
		for (Protobuf.stock_details_data stockDetailsData : listStockData) {
			if (regexMap.keySet().contains(ParamConstant.STOCK_CODE)) {
				log.info("stock_code:" + stockDetailsData.getStockCode());// 证券代码（默认下发）
				JsonAssertUtil.assertRegex(ParamConstant.STOCK_CODE, stockDetailsData.getStockCode(),
						regexMap.get(ParamConstant.STOCK_CODE));
			}
			if (regexMap.keySet().contains(ParamConstant.STOCK_NAME)) {
				log.info("stock_name:" + stockDetailsData.getStockName());// 证券名称（默认下发）
				JsonAssertUtil.assertRegex(ParamConstant.STOCK_NAME, stockDetailsData.getStockName(),
						regexMap.get(ParamConstant.STOCK_NAME));
			}
			if (regexMap.keySet().contains(ParamConstant.MARKETID)) {
				log.info("marketID:" + stockDetailsData.getMarketID());// 市场代码（默认下发）
				JsonAssertUtil.assertRegex(ParamConstant.MARKETID, String.valueOf(stockDetailsData.getMarketID()),
						regexMap.get(ParamConstant.MARKETID));
			}
			if (regexMap.keySet().contains(ParamConstant.PSZMARK)) {
				log.info("pszMark:" + stockDetailsData.getPszMark());// 特殊股票表示：港股:HK, 沪港通:HGT, 融资融券:R（默认下发）
				JsonAssertUtil.assertRegex(ParamConstant.PSZMARK, stockDetailsData.getPszMark(),
						regexMap.get(ParamConstant.PSZMARK));
			}

			if (regexMap.keySet().contains(ParamConstant.NZRSP)) {
				log.info("nZrsp:" + stockDetailsData.getNZrsp());
				JsonAssertUtil.assertRegex(ParamConstant.NZRSP, String.valueOf(stockDetailsData.getNZrsp()),
						regexMap.get(ParamConstant.NZRSP));
			}
			if (regexMap.keySet().contains(ParamConstant.DATAARR_WTYPE)) {
				log.info("dataArr_wType:" + stockDetailsData.getWType());
				JsonAssertUtil.assertRegex(ParamConstant.DATAARR_WTYPE, String.valueOf(stockDetailsData.getWType()),
						regexMap.get(ParamConstant.DATAARR_WTYPE));
			}

			if (regexMap.keySet().contains(ParamConstant.NJRKP)) {
				log.info("nJrkp:" + stockDetailsData.getNJrkp());
				JsonAssertUtil.assertRegex(ParamConstant.NJRKP, String.valueOf(stockDetailsData.getNJrkp()),
						regexMap.get(ParamConstant.NJRKP));
			}
			if (regexMap.keySet().contains(ParamConstant.NZJCJ)) {
				log.info("nZjcj:" + stockDetailsData.getNZjcj());
				JsonAssertUtil.assertRegex(ParamConstant.NZJCJ, String.valueOf(stockDetailsData.getNZjcj()),
						regexMap.get(ParamConstant.NZJCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NZD)) {
				log.info("nZd:" + stockDetailsData.getNZd());
				JsonAssertUtil.assertRegex(ParamConstant.NZD, String.valueOf(stockDetailsData.getNZd()),
						regexMap.get(ParamConstant.NZD));
			}
			if (regexMap.keySet().contains(ParamConstant.NZDF)) {
				log.info("nZdf:" + stockDetailsData.getNZdf());
				JsonAssertUtil.assertRegex(ParamConstant.NZDF, String.valueOf(stockDetailsData.getNZdf()),
						regexMap.get(ParamConstant.NZDF));
			}
			if (regexMap.keySet().contains(ParamConstant.BSUSPENDED)) {
				log.info("bSuspended:" + stockDetailsData.getBSuspended());
				JsonAssertUtil.assertRegex(ParamConstant.BSUSPENDED, String.valueOf(stockDetailsData.getBSuspended()),
						regexMap.get(ParamConstant.BSUSPENDED));
			}
			if (regexMap.keySet().contains(ParamConstant.NRQSJ)) {
				log.info("nRqSj:" + stockDetailsData.getNRqSj());
				JsonAssertUtil.assertRegex(ParamConstant.NRQSJ, String.valueOf(stockDetailsData.getNRqSj()),
						regexMap.get(ParamConstant.NRQSJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NLIMUP)) {
				log.info("nLimUp:" + stockDetailsData.getNLimUp());
				JsonAssertUtil.assertRegex(ParamConstant.NLIMUP, String.valueOf(stockDetailsData.getNLimUp()),
						regexMap.get(ParamConstant.NLIMUP));
			}
			if (regexMap.keySet().contains(ParamConstant.NLIMDOWN)) {
				log.info("nLimDown:" + stockDetailsData.getNLimDown());
				JsonAssertUtil.assertRegex(ParamConstant.NLIMDOWN, String.valueOf(stockDetailsData.getNLimDown()),
						regexMap.get(ParamConstant.NLIMDOWN));
			}
			if (regexMap.keySet().contains(ParamConstant.BLOCKID)) {
				log.info("blockID:" + stockDetailsData.getBlockID());
				JsonAssertUtil.assertRegex(ParamConstant.BLOCKID, String.valueOf(stockDetailsData.getBlockID()),
						regexMap.get(ParamConstant.BLOCKID));
			}
			if (regexMap.keySet().contains(ParamConstant.BLOCKNAME)) {
				log.info("blockName:" + stockDetailsData.getBlockName());
				JsonAssertUtil.assertRegex(ParamConstant.BLOCKNAME, stockDetailsData.getBlockName(),
						regexMap.get(ParamConstant.BLOCKNAME));
			}
			if (regexMap.keySet().contains(ParamConstant.IS_GGT_OBJECT)) {
				log.info("is_ggt_object:" + stockDetailsData.getIsGgtObject());
				JsonAssertUtil.assertRegex(ParamConstant.IS_GGT_OBJECT,
						String.valueOf(stockDetailsData.getIsGgtObject()), regexMap.get(ParamConstant.IS_GGT_OBJECT));
			}
			if (regexMap.keySet().contains(ParamConstant.NZGCJ)) {
				log.info("nZgcj:" + stockDetailsData.getNZgcj());
				JsonAssertUtil.assertRegex(ParamConstant.NZGCJ, String.valueOf(stockDetailsData.getNZgcj()),
						regexMap.get(ParamConstant.NZGCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NZDCJ)) {
				log.info("nZdcj:" + stockDetailsData.getNZdcj());
				JsonAssertUtil.assertRegex(ParamConstant.NZDCJ, String.valueOf(stockDetailsData.getNZdcj()),
						regexMap.get(ParamConstant.NZDCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NCJSS)) {
				log.info("nCjss:" + stockDetailsData.getNCjss());
				JsonAssertUtil.assertRegex(ParamConstant.NCJSS, String.valueOf(stockDetailsData.getNCjss()),
						regexMap.get(ParamConstant.NCJSS));
			}
			if (regexMap.keySet().contains(ParamConstant.NZF)) {
				log.info("nZf:" + stockDetailsData.getNZf());
				JsonAssertUtil.assertRegex(ParamConstant.NZF, String.valueOf(stockDetailsData.getNZf()),
						regexMap.get(ParamConstant.NZF));
			}
			if (regexMap.keySet().contains(ParamConstant.NCJJE)) {
				log.info("nCjje:" + stockDetailsData.getNCjje());
				JsonAssertUtil.assertRegex(ParamConstant.NCJJE, String.valueOf(stockDetailsData.getNCjje()),
						regexMap.get(ParamConstant.NCJJE));
			}
			if (regexMap.keySet().contains(ParamConstant.NLB)) {
				log.info("nLb:" + stockDetailsData.getNLb());
				JsonAssertUtil.assertRegex(ParamConstant.NLB, String.valueOf(stockDetailsData.getNLb()),
						regexMap.get(ParamConstant.NLB));
			}
			if (regexMap.keySet().contains(ParamConstant.N5MIN)) {
				log.info("n5Min:" + stockDetailsData.getN5Min());
				JsonAssertUtil.assertRegex(ParamConstant.N5MIN, String.valueOf(stockDetailsData.getN5Min()),
						regexMap.get(ParamConstant.N5MIN));
			}
			if (regexMap.keySet().contains(ParamConstant.NHSL)) {
				log.info("nHsl:" + stockDetailsData.getNHsl());
				JsonAssertUtil.assertRegex(ParamConstant.NHSL, String.valueOf(stockDetailsData.getNHsl()),
						regexMap.get(ParamConstant.NHSL));
			}
			if (regexMap.keySet().contains(ParamConstant.NSYL)) {
				log.info("nSyl:" + stockDetailsData.getNSyl());
				JsonAssertUtil.assertRegex(ParamConstant.NSYL, String.valueOf(stockDetailsData.getNSyl()),
						regexMap.get(ParamConstant.NSYL));
			}

			log.info("****************");
			log.info("****************");

			/** 以下是目前暂未用到的，预留需要时添加 */
			// log.info("nZgcj:" + stockDetailsData.getNZgcj());
			// log.info("nBjg1:" + stockDetailsData.getNBjg1());
			// log.info("nSjg1:" + stockDetailsData.getNSjg1());
			// log.info("nBsl1:" + stockDetailsData.getNBsl1());
			// log.info("nSsl1:" + stockDetailsData.getNSsl1());
			// log.info("new_name:" + stockDetailsData.getNewName());
			// log.info("wStockStatus:" + stockDetailsData.getWStockStatus());
			// log.info("wZjs:" + stockDetailsData.getWZjs());
			// log.info("wDjs:" + stockDetailsData.getWDjs());
			// log.info("wPjs:" + stockDetailsData.getWPjs());
			// log.info("nLTP:" + stockDetailsData.getNLTP());
			// log.info("nZSZ:" + stockDetailsData.getNZSZ());
			// log.info("ExercisePrice:" + stockDetailsData.getExercisePrice());
			// log.info("TotalLongPosition:" + stockDetailsData.getTotalLongPosition());
			// log.info("cangCha:" + stockDetailsData.getCangCha());
			// log.info("ContractMultiplierUnit:" +
			// stockDetailsData.getContractMultiplierUnit());
			// log.info("SurplusDays:" + stockDetailsData.getSurplusDays());
			// log.info("option_flag:" + stockDetailsData.getOptionFlag());
			// log.info("wCYDZS:" + stockDetailsData.getWCYDZS());
			// log.info("stock_tradeClassify_data_repeated tradeClassify_data_arr::::::");
			// ProtobufRepeated.stock_tradeClassify_data_repeated(stockDetailsData);
			// log.info("blockZDF:" + stockDetailsData.getBlockZDF());
			// log.info("hgt_cv_data hcd:::::::");
			// protobufData.hgt_cv_data(stockDetailsData);
			// log.info("gz_type_group gz_types::::::");
			// ProtobufGroup.gz_type_group(stockDetailsData);
			// log.info("week_num:" + stockDetailsData.getWeekNum());
			// log.info("repurchase_name:" + stockDetailsData.getRepurchaseName());
			// log.info("APY:" + stockDetailsData.getAPY());
			// log.info("earnings:" + stockDetailsData.getEarnings());
			// log.info("available_date ad:::::");
			// ProtobufDate.available_date(stockDetailsData);
			// log.info("extend_details ext_d ::::");
			// ProtobufDetail.extend_details(stockDetailsData);
		}
	}

	public static void stock_details_data(Protobuf.stock_united_rep stockUnitedRep, Map<String, String> regexMap) {
		Protobuf.stock_details_data stockDetailsData = stockUnitedRep.getDetailsData();

		if (regexMap.keySet().contains(ParamConstant.STOCK_CODE)) {
			log.info("stock_code:" + stockDetailsData.getStockCode());// 证券代码（默认下发）
			JsonAssertUtil.assertRegex(ParamConstant.STOCK_CODE, stockDetailsData.getStockCode(),
					regexMap.get(ParamConstant.STOCK_CODE));
		}
		if (regexMap.keySet().contains(ParamConstant.STOCK_NAME)) {
			log.info("stock_name:" + stockDetailsData.getStockName());// 证券名称（默认下发）
			JsonAssertUtil.assertRegex(ParamConstant.STOCK_NAME, stockDetailsData.getStockName(),
					regexMap.get(ParamConstant.STOCK_NAME));
		}
		if (regexMap.keySet().contains(ParamConstant.MARKETID)) {
			log.info("marketID:" + stockDetailsData.getMarketID());// 市场代码（默认下发）
			JsonAssertUtil.assertRegex(ParamConstant.MARKETID, String.valueOf(stockDetailsData.getMarketID()),
					regexMap.get(ParamConstant.MARKETID));
		}
		if (regexMap.keySet().contains(ParamConstant.PSZMARK)) {
			log.info("pszMark:" + stockDetailsData.getPszMark());// 特殊股票表示：港股:HK, 沪港通:HGT, 融资融券:R（默认下发）
			JsonAssertUtil.assertRegex(ParamConstant.PSZMARK, stockDetailsData.getPszMark(),
					regexMap.get(ParamConstant.PSZMARK));
		}
		if (regexMap.keySet().contains(ParamConstant.WTYPE)) {
			log.info("wType:" + stockDetailsData.getWType());
			JsonAssertUtil.assertRegex(ParamConstant.WTYPE, String.valueOf(stockDetailsData.getWType()),
					regexMap.get(ParamConstant.WTYPE));
		}
		if (regexMap.keySet().contains(ParamConstant.NZJCJ)) {
			log.info("nZjcj:" + stockDetailsData.getNZjcj());
			JsonAssertUtil.assertRegex(ParamConstant.NZJCJ, String.valueOf(stockDetailsData.getNZjcj()),
					regexMap.get(ParamConstant.NZJCJ));
		}
		if (regexMap.keySet().contains(ParamConstant.NZDF)) {
			log.info("nZdf:" + stockDetailsData.getNZdf());
			JsonAssertUtil.assertRegex(ParamConstant.NZDF, String.valueOf(stockDetailsData.getNZdf()),
					regexMap.get(ParamConstant.NZDF));
		}
		if (regexMap.keySet().contains(ParamConstant.BSUSPENDED)) {
			log.info("bSuspended:" + stockDetailsData.getBSuspended());
			JsonAssertUtil.assertRegex(ParamConstant.BSUSPENDED, String.valueOf(stockDetailsData.getBSuspended()),
					regexMap.get(ParamConstant.BSUSPENDED));
		}
		if (regexMap.keySet().contains(ParamConstant.NRQSJ)) {
			log.info("nRqSj:" + stockDetailsData.getNRqSj());
			JsonAssertUtil.assertRegex(ParamConstant.NRQSJ, String.valueOf(stockDetailsData.getNRqSj()),
					regexMap.get(ParamConstant.NRQSJ));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKID)) {
			log.info("blockID:" + stockDetailsData.getBlockID());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKID, String.valueOf(stockDetailsData.getBlockID()),
					regexMap.get(ParamConstant.BLOCKID));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKNAME)) {
			log.info("blockName:" + stockDetailsData.getBlockName());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKNAME, stockDetailsData.getBlockName(),
					regexMap.get(ParamConstant.BLOCKNAME));
		}
		if (regexMap.keySet().contains(ParamConstant.IS_GGT_OBJECT)) {
			log.info("is_ggt_object:" + stockDetailsData.getIsGgtObject());
			JsonAssertUtil.assertRegex(ParamConstant.IS_GGT_OBJECT, String.valueOf(stockDetailsData.getIsGgtObject()),
					regexMap.get(ParamConstant.IS_GGT_OBJECT));
		}
		if (regexMap.keySet().contains(ParamConstant.BLOCKZDF)) {
			log.info("blockZDF:" + stockDetailsData.getBlockZDF());
			JsonAssertUtil.assertRegex(ParamConstant.BLOCKZDF, String.valueOf(stockDetailsData.getBlockZDF()),
					regexMap.get(ParamConstant.BLOCKZDF));
		}
		log.info("extend_details ext_d ::::");
		ProtobufDetail.extend_details(stockDetailsData, regexMap);

		log.info("****************");
		log.info("****************");
		/** 以下是目前暂未用到的，预留需要时添加 */
		// log.info("nZrsp:" + stockDetailsData.getNZrsp());
		// log.info("nJrkp:" + stockDetailsData.getNJrkp());
		// log.info("nZgcj:" + stockDetailsData.getNZgcj());
		// log.info("nZdcj:" + stockDetailsData.getNZdcj());
		// log.info("nCjss:" + stockDetailsData.getNCjss());
		// log.info("nZf:" + stockDetailsData.getNZf());
		// log.info("nCjje:" + stockDetailsData.getNCjje());
		// log.info("nBjg1:" + stockDetailsData.getNBjg1());
		// log.info("nSjg1:" + stockDetailsData.getNSjg1());
		// log.info("nBsl1:" + stockDetailsData.getNBsl1());
		// log.info("nSsl1:" + stockDetailsData.getNSsl1());
		// log.info("nZd:" + stockDetailsData.getNZd());
		// log.info("nLb:" + stockDetailsData.getNLb());
		// log.info("n5Min:" + stockDetailsData.getN5Min());
		// log.info("nHsl:" + stockDetailsData.getNHsl());
		// log.info("nSyl:" + stockDetailsData.getNSyl());
		// log.info("new_name:" + stockDetailsData.getNewName());
		// log.info("wStockStatus:" + stockDetailsData.getWStockStatus());
		// log.info("wZjs:" + stockDetailsData.getWZjs());
		// log.info("wDjs:" + stockDetailsData.getWDjs());
		// log.info("wPjs:" + stockDetailsData.getWPjs());
		// log.info("nLTP:" + stockDetailsData.getNLTP());
		// log.info("nZSZ:" + stockDetailsData.getNZSZ());
		// log.info("ExercisePrice:" + stockDetailsData.getExercisePrice());
		// log.info("TotalLongPosition:" + stockDetailsData.getTotalLongPosition());
		// log.info("cangCha:" + stockDetailsData.getCangCha());
		// log.info("ContractMultiplierUnit:" +
		// stockDetailsData.getContractMultiplierUnit());
		// log.info("SurplusDays:" + stockDetailsData.getSurplusDays());
		// log.info("option_flag:" + stockDetailsData.getOptionFlag());
		// log.info("nLimUp:" + stockDetailsData.getNLimUp());
		// log.info("nLimDown:" + stockDetailsData.getNLimDown());
		// log.info("wCYDZS:" + stockDetailsData.getWCYDZS());
		// log.info("stock_tradeClassify_data_repeated tradeClassify_data_arr::::::");
		// ProtobufRepeated.stock_tradeClassify_data_repeated(stockDetailsData);
		// log.info("hgt_cv_data hcd:::::::");
		// protobufData.hgt_cv_data(stockDetailsData);
		// log.info("gz_type_group gz_types::::::");
		// ProtobufGroup.gz_type_group(stockDetailsData);
		// log.info("week_num:" + stockDetailsData.getWeekNum());
		// log.info("repurchase_name:" + stockDetailsData.getRepurchaseName());
		// log.info("APY:" + stockDetailsData.getAPY());
		// log.info("earnings:" + stockDetailsData.getEarnings());
		// log.info("available_date ad:::::");
		// ProtobufDate.available_date(stockDetailsData);
	}

	public static void stock_kline_data(Protobuf.stock_kline_rep stockKlineRep) {
		List<Protobuf.stock_kline_data> stockKlineDataList = stockKlineRep.getKlineDataArrList();
		for (Protobuf.stock_kline_data stockKlineData : stockKlineDataList) {
			System.out.println("nDate:" + stockKlineData.getNDate());
			System.out.println("nTime:" + stockKlineData.getNTime());
			System.out.println("nYClose:" + stockKlineData.getNYClose());
			System.out.println("nOpen:" + stockKlineData.getNOpen());
			System.out.println("nZgcj:" + stockKlineData.getNZgcj());
			System.out.println("nZdcj:" + stockKlineData.getNZdcj());
			System.out.println("nClose:" + stockKlineData.getNClose());
			System.out.println("nZdf:" + stockKlineData.getNZdf());
			System.out.println("nCjje:" + stockKlineData.getNCjje());
			System.out.println("nCjss:" + stockKlineData.getNCjss());
			System.out.println("nCcl:" + stockKlineData.getNCcl());
			System.out.println("nZd:" + stockKlineData.getNZd());

			List<Integer> nMAList = stockKlineData.getNMAList();
			for (int i : nMAList) {
				System.out.println("nMA:" + i);
			}
			System.out.println("nTech:" + stockKlineData.getNTechList());
			System.out.println("nHsl:" + stockKlineData.getNHsl());
			System.out.println("nZf:" + stockKlineData.getNZf());

			System.out.println("****************");
			System.out.println("****************");
		}
	}

	public static void stock_timeDivision_data(Protobuf.stock_timeDivision_rep stockTimeDivisionRep,
			Map<String, String> regexMap) {
		List<Protobuf.stock_timeDivision_data> stockTimeDivisionDataList = stockTimeDivisionRep.getDataArrList();
		for (Protobuf.stock_timeDivision_data stockTimeDivisionData : stockTimeDivisionDataList) {
			if (regexMap.keySet().contains(ParamConstant.NTIME)) {
				log.info("nTime:" + stockTimeDivisionData.getNTime());
				JsonAssertUtil.assertRegex(ParamConstant.NTIME, String.valueOf(stockTimeDivisionData.getNTime()),
						regexMap.get(ParamConstant.NTIME));
			}
			if (regexMap.keySet().contains(ParamConstant.TIMEDIVISION_NZJCJ)) {
				log.info("timeDivision_nZjcj:" + stockTimeDivisionData.getNZjcj());
				JsonAssertUtil.assertRegex(ParamConstant.TIMEDIVISION_NZJCJ,
						String.valueOf(stockTimeDivisionData.getNZjcj()),
						regexMap.get(ParamConstant.TIMEDIVISION_NZJCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.TIMEDIVISION_NZDF)) {
				log.info("timeDivision_nZdf:" + stockTimeDivisionData.getNZdf());
				JsonAssertUtil.assertRegex(ParamConstant.TIMEDIVISION_NZDF,
						String.valueOf(stockTimeDivisionData.getNZdf()), regexMap.get(ParamConstant.TIMEDIVISION_NZDF));
			}
			if (regexMap.keySet().contains(ParamConstant.NCJSS)) {
				log.info("nCjss:" + stockTimeDivisionData.getNCjss());
				JsonAssertUtil.assertRegex(ParamConstant.NCJSS, String.valueOf(stockTimeDivisionData.getNCjss()),
						regexMap.get(ParamConstant.NCJSS));
			}

			if (regexMap.keySet().contains(ParamConstant.NCJJE)) {
				log.info("nCjje:" + stockTimeDivisionData.getNCjje());
				JsonAssertUtil.assertRegex(ParamConstant.NCJJE, String.valueOf(stockTimeDivisionData.getNCjje()),
						regexMap.get(ParamConstant.NCJJE));
			}
			if (regexMap.keySet().contains(ParamConstant.NCJJJ)) {
				log.info("nCjjj:" + stockTimeDivisionData.getNCjjj());
				JsonAssertUtil.assertRegex(ParamConstant.NCJJJ, String.valueOf(stockTimeDivisionData.getNCjjj()),
						regexMap.get(ParamConstant.NCJJJ));
			}
			if (regexMap.keySet().contains(ParamConstant.NDATE)) {
				log.info("nDate:" + stockTimeDivisionData.getNDate());
				JsonAssertUtil.assertRegex(ParamConstant.NDATE, String.valueOf(stockTimeDivisionData.getNDate()),
						regexMap.get(ParamConstant.NDATE));
			}
			if (regexMap.keySet().contains(ParamConstant.NZD)) {
				log.info("nZd:" + stockTimeDivisionData.getNZd());
				JsonAssertUtil.assertRegex(ParamConstant.NZD, String.valueOf(stockTimeDivisionData.getNZd()),
						regexMap.get(ParamConstant.NZD));
			}
			log.info("****************");
			log.info("****************");
			/** 以下是目前暂未用到的，预留需要时添加 */
			// if (regexMap.keySet().contains(ParamConstant.NPOS)) {
			// log.info("nPos:" + stockTimeDivisionData.getNPos());
			// JsonAssertUtil.assertRegex(ParamConstant.NPOS,
			// String.valueOf(stockTimeDivisionData.getNPos()),
			// regexMap.get(ParamConstant.NPOS));
			// }
		}
	}

	public static void stock_tradeDetail_data(Protobuf.stock_tradeDetail_rep stockTradeDetailRep,
			Map<String, String> regexMap) {
		List<Protobuf.stock_tradeDetail_data> stockTradeDetailDataList = stockTradeDetailRep.getDataArrList();
		for (Protobuf.stock_tradeDetail_data stockTradeDetailData : stockTradeDetailDataList) {
			if (regexMap.keySet().contains(ParamConstant.DWTIME)) {
				log.info("dwTime:" + stockTradeDetailData.getDwTime());
				JsonAssertUtil.assertRegex(ParamConstant.DWTIME, String.valueOf(stockTradeDetailData.getDwTime()),
						regexMap.get(ParamConstant.DWTIME));
			}
			if (regexMap.keySet().contains(ParamConstant.BCJLB)) {
				log.info("bCjlb:" + stockTradeDetailData.getBCjlb());
				JsonAssertUtil.assertRegex(ParamConstant.BCJLB, stockTradeDetailData.getBCjlb(),
						regexMap.get(ParamConstant.BCJLB));
			}
			if (regexMap.keySet().contains(ParamConstant.TRADEDETAIL_NZJCJ)) {
				log.info("tradeDetail_nZjcj:" + stockTradeDetailData.getNZjcj());
				JsonAssertUtil.assertRegex(ParamConstant.TRADEDETAIL_NZJCJ,
						String.valueOf(stockTradeDetailData.getNZjcj()), regexMap.get(ParamConstant.TRADEDETAIL_NZJCJ));
			}
			if (regexMap.keySet().contains(ParamConstant.TRADEDETAIL_NCJSS)) {
				log.info("tradeDetail_nCjss:" + stockTradeDetailData.getNCjss());
				JsonAssertUtil.assertRegex(ParamConstant.TRADEDETAIL_NCJSS,
						String.valueOf(stockTradeDetailData.getNCjss()), regexMap.get(ParamConstant.TRADEDETAIL_NCJSS));
			}
			log.info("****************");
			log.info("****************");
			/** 以下是目前暂未用到的，预留需要时添加 */
			// log.info("nCjje:" + stockTradeDetailData.getNCjje());
		}
	}
}