package zxjt.inte.protobuf;

import org.apache.log4j.Logger;

import zxjt.inte.util.ParamConstant;

public class ProtobufDate {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	public static void available_date(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.available_date available_date = stockDetailsData.getAd();
		System.out.println("date:"+available_date.getDate());
		System.out.println("day_of_week:"+available_date.getDayOfWeek());
		System.out.println("****************");
    	System.out.println("****************");
	}
}
