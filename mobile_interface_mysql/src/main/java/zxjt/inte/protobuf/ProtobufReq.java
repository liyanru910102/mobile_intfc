package zxjt.inte.protobuf;

import java.util.Map;

import org.apache.log4j.Logger;

import zxjt.inte.util.ParamConstant;

public class ProtobufReq {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);

	/**
	 * 唯一的请求名称
	 * 
	 * @param map
	 *            要拼接的入参
	 * @return 入参流
	 */
	public static byte[] multi_selectedStocks_req(Map<String, String> map) {
		Protobuf.multi_selectedStocks_req.Builder multiSelectedStocksBuilder = Protobuf.multi_selectedStocks_req
				.newBuilder();
		multiSelectedStocksBuilder.addReqs(ProtobufBuilder.selectedStocks_req(map));
		Protobuf.multi_selectedStocks_req request = multiSelectedStocksBuilder.build();
		return request.toByteArray();
	}

	public static byte[] codeList_req(Map<String, String> map) {
		Protobuf.codeList_req.Builder codeListBuilder = Protobuf.codeList_req.newBuilder();
		codeListBuilder.setVersion(Integer.valueOf(map.get(ParamConstant.VERSION)));

		Protobuf.codeList_req request = codeListBuilder.build();
		return request.toByteArray();
	}

	public static byte[] multi_blockRank_req(Map<String, String> map) {
		Protobuf.multi_blockRank_req.Builder multiBlockRankBuilder = Protobuf.multi_blockRank_req.newBuilder();
		multiBlockRankBuilder.addReqs(ProtobufBuilder.blockRank_req(map));
		Protobuf.multi_blockRank_req request = multiBlockRankBuilder.build();
		return request.toByteArray();
	}

	public static byte[] multi_stockRank_req(Map<String, String> map) {
		Protobuf.multi_stockRank_req.Builder multiStockRankBuilder = Protobuf.multi_stockRank_req.newBuilder();
		multiStockRankBuilder.addReqs(ProtobufBuilder.stockRank_req(map));
		Protobuf.multi_stockRank_req request = multiStockRankBuilder.build();
		return request.toByteArray();
	}

	public static byte[] blockRankIndex_req(Map<String, String> map) {
		Protobuf.blockRankIndex_req.Builder blockRankIndexBuilder = Protobuf.blockRankIndex_req.newBuilder();
		blockRankIndexBuilder.setOptions(ProtobufBuilder.rank_option(map));
		Protobuf.blockRankIndex_req request = blockRankIndexBuilder.build();
		return request.toByteArray();
	}

	public static byte[] multi_stock_united_req(Map<String, String> map, Boolean isUseKlineReq,
			Boolean isUsetimeDivisionReq, Boolean isUseTradeDetailReq) {
		Protobuf.multi_stock_united_req.Builder multiStockUnitedBuilder = Protobuf.multi_stock_united_req.newBuilder();
		multiStockUnitedBuilder.addReqs(
				ProtobufBuilder.stock_united_req(map, isUseKlineReq, isUsetimeDivisionReq, isUseTradeDetailReq));
		Protobuf.multi_stock_united_req request = multiStockUnitedBuilder.build();
		return request.toByteArray();
	}
}