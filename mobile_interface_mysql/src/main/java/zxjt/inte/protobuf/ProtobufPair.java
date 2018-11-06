package zxjt.inte.protobuf;

import java.util.List;

import org.apache.log4j.Logger;

import zxjt.inte.util.ParamConstant;

public class ProtobufPair {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	public static void price_volume_pair(Protobuf.stock_tradeClassify_data_repeated stock_tradeClassify_data_repeated) {
		List<Protobuf.price_volume_pair> buypair = stock_tradeClassify_data_repeated.getBuyPairList();
		List<Protobuf.price_volume_pair> sellpair = stock_tradeClassify_data_repeated.getSellPairList();

		for (Protobuf.price_volume_pair price_volume_pair : buypair) {

			System.out.println("price:" + price_volume_pair.getPrice());
			System.out.println("volume:" + price_volume_pair.getVolume());
			System.out.println("pos:" + price_volume_pair.getPos());

			System.out.println("*****buypair******");
			System.out.println("****************");
		}
		for (Protobuf.price_volume_pair price_volume_pair : sellpair) {

			System.out.println("price:" + price_volume_pair.getPrice());
			System.out.println("volume:" + price_volume_pair.getVolume());
			System.out.println("pos:" + price_volume_pair.getPos());

			System.out.println("*****sellpair*******");
			System.out.println("****************");
		}
	}

}
