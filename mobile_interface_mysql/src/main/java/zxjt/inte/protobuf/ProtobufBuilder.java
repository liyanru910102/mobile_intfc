package zxjt.inte.protobuf;

import java.util.Map;

import org.apache.log4j.Logger;

import zxjt.inte.util.ParamConstant;

public class ProtobufBuilder {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);

	public static Protobuf.selectedStocks_req.Builder selectedStocks_req(Map<String, String> map) {

		Protobuf.selectedStocks_req.Builder selectedStocksBuilder = Protobuf.selectedStocks_req.newBuilder();
		selectedStocksBuilder.setPszCodes(map.get(ParamConstant.PSZCODES));// 代码链必须
		selectedStocksBuilder.setMarketList(map.get(ParamConstant.MARKETLIST));// 市场链必须
		selectedStocksBuilder.setOptions(rank_option(map));// 结构体必须
		return selectedStocksBuilder;
	}

	public static Protobuf.rank_option.Builder rank_option(Map<String, String> map) {
		Protobuf.rank_option.Builder rankOptionBuilder = Protobuf.rank_option.newBuilder();
		rankOptionBuilder.setWType(Integer.valueOf(map.get(ParamConstant.WTYPE)));// 必须排序类型//板块排行时表示板块类别ID，传0时由服务器配置决定所下发的版块排行
		rankOptionBuilder.setBSort(Integer.valueOf(map.get(ParamConstant.BSORT)));// 必须排序字段
		rankOptionBuilder.setBDirect(Boolean.valueOf(map.get(ParamConstant.BDIRECT)));// 必须0升序，1降序
		rankOptionBuilder.setWFrom(Integer.valueOf(map.get(ParamConstant.WFROM)));// 必须起始位置
		rankOptionBuilder.setWCount(Integer.valueOf(map.get(ParamConstant.WCOUNT)));// 必须请求数量
		rankOptionBuilder.setFieldsBitMap(Long.valueOf(map.get(ParamConstant.FIELDSBITMAP)));// 必须需要字段的位图
		if (null != map.get(ParamConstant.WTOTALCOUNT) && !"".equals(map.get(ParamConstant.WTOTALCOUNT))) {
			rankOptionBuilder.setWTotalCount(Integer.valueOf(map.get(ParamConstant.WTOTALCOUNT)));
		}
		if (null != map.get(ParamConstant.BLOCKCLASSNAME) && !"".equals(map.get(ParamConstant.BLOCKCLASSNAME))) {
			rankOptionBuilder.setBlockClassName(map.get(ParamConstant.BLOCKCLASSNAME));
		}
		return rankOptionBuilder;
	}

	public static Protobuf.blockRank_req.Builder blockRank_req(Map<String, String> map) {
		Protobuf.blockRank_req.Builder blockRankBuilder = Protobuf.blockRank_req.newBuilder();
		blockRankBuilder.setOptions(rank_option(map));// 必须
		return blockRankBuilder;
	}

	public static Protobuf.stockRank_req.Builder stockRank_req(Map<String, String> map) {
		Protobuf.stockRank_req.Builder stockRankBuilder = Protobuf.stockRank_req.newBuilder();
		stockRankBuilder.setOptions(rank_option(map));// 必须
		stockRankBuilder.setWMarketID(Integer.valueOf(map.get(ParamConstant.WMARKETID)));// 必须
		stockRankBuilder.setSBKCode(map.get(ParamConstant.SBKCODE));// 必须
		return stockRankBuilder;
	}

	public static Protobuf.stock_united_req.Builder stock_united_req(Map<String, String> map, Boolean isUseKlineReq,
			Boolean isUsetimeDivisionReq, Boolean isUseTradeDetailReq) {
		Protobuf.stock_united_req.Builder stockUnitedReqBuilder = Protobuf.stock_united_req.newBuilder();
		stockUnitedReqBuilder.setWMarketID(Integer.valueOf(map.get(ParamConstant.WMARKETID)));// 必须
		stockUnitedReqBuilder.setSPszCode(map.get(ParamConstant.SPSZCODE));// 必须
		stockUnitedReqBuilder.setWType(Integer.valueOf(map.get(ParamConstant.WTYPE)));// 必须
		if (null != map.get(ParamConstant.FIELDSBITMAP)) {
			stockUnitedReqBuilder.setFieldsBitMap(Long.valueOf(map.get(ParamConstant.FIELDSBITMAP)));
		}
		if (isUseKlineReq) {
			stockUnitedReqBuilder.setKlineReq(stock_kline_req(map));
		}
		if (isUsetimeDivisionReq) {
			stockUnitedReqBuilder.setTimeDivisionReq(stock_timeDivision_req(map));
		}
		if (isUseTradeDetailReq) {
			stockUnitedReqBuilder.setTradeDetailReq(stock_tradeDetail_req(map));
		}
		return stockUnitedReqBuilder;
	}

	public static Protobuf.stock_kline_req.Builder stock_kline_req(Map<String, String> map) {
		Protobuf.stock_kline_req.Builder stockKlineReqBuilder = Protobuf.stock_kline_req.newBuilder();

		if (null == map.get(ParamConstant.WKXTYPE) || "".equals(map.get(ParamConstant.WKXTYPE))) {
			throw new RuntimeException("stock_kline_req中必输项WKXTYPE无值，请确认后再执行！");
		}
		if (null == map.get(ParamConstant.DWKXDATE) || "".equals(map.get(ParamConstant.DWKXDATE))) {
			throw new RuntimeException("stock_kline_req中必输项DWKXDATE无值，请确认后再执行！");
		}
		if (null == map.get(ParamConstant.DWKXTIME) || "".equals(map.get(ParamConstant.DWKXTIME))) {
			throw new RuntimeException("stock_kline_req中必输项DWKXTIME无值，请确认后再执行！");
		}
		if (null == map.get(ParamConstant.WKXCOUNT) || "".equals(map.get(ParamConstant.WKXCOUNT))) {
			throw new RuntimeException("stock_kline_req中必输项WKXCOUNT无值，请确认后再执行！");
		}
		if (null == map.get(ParamConstant.WFQTYPE) || "".equals(map.get(ParamConstant.WFQTYPE))) {
			throw new RuntimeException("stock_kline_req中必输项WFQTYPE无值，请确认后再执行！");
		}

		stockKlineReqBuilder.setWKXType(Integer.valueOf(map.get(ParamConstant.WKXTYPE)));
		stockKlineReqBuilder.setDwKXDate(Integer.valueOf(map.get(ParamConstant.DWKXDATE)));
		stockKlineReqBuilder.setDwKXTime(Integer.valueOf(map.get(ParamConstant.DWKXTIME)));
		stockKlineReqBuilder.setWKXCount(Integer.valueOf(map.get(ParamConstant.WKXCOUNT)));
		stockKlineReqBuilder.setWFQType(Integer.valueOf(map.get(ParamConstant.WFQTYPE)));
		if (null != map.get(ParamConstant.REQNEWKLINES) && !"".equals(map.get(ParamConstant.REQNEWKLINES))) {
			stockKlineReqBuilder.setReqNewKlines(Boolean.valueOf(map.get(ParamConstant.REQNEWKLINES)));
		}

		return stockKlineReqBuilder;
	}

	public static Protobuf.stock_timeDivision_req.Builder stock_timeDivision_req(Map<String, String> map) {
		Protobuf.stock_timeDivision_req.Builder stockTimeDivisionReqBuilder = Protobuf.stock_timeDivision_req
				.newBuilder();
		stockTimeDivisionReqBuilder.setDwFSDate(Integer.valueOf(map.get(ParamConstant.DWFSDATE)));
		stockTimeDivisionReqBuilder.setDwFSTime(Integer.valueOf(map.get(ParamConstant.DWFSTIME)));
		return stockTimeDivisionReqBuilder;
	}

	public static Protobuf.stock_tradeDetail_req.Builder stock_tradeDetail_req(Map<String, String> map) {
		Protobuf.stock_tradeDetail_req.Builder stockTradeDetailReqBuilder = Protobuf.stock_tradeDetail_req.newBuilder();
		stockTradeDetailReqBuilder.setCount(Integer.valueOf(map.get(ParamConstant.COUNT)));
		return stockTradeDetailReqBuilder;
	}
}
