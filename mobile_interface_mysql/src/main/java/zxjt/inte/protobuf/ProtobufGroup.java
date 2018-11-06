package zxjt.inte.protobuf;

import org.apache.log4j.Logger;

import zxjt.inte.util.ParamConstant;

public class ProtobufGroup {
	Logger log = Logger.getLogger(ParamConstant.LOGGER);
	public static void gz_type_group(Protobuf.stock_details_data stockDetailsData)
	{
		Protobuf.gz_type_group gz_type_group = stockDetailsData.getGzTypes();
		System.out.println("gqzr_type:"+gz_type_group.getGqzrType());
		System.out.println("lwts_type:"+gz_type_group.getLwtsType());
		System.out.println("gzfc_type:"+gz_type_group.getGzfcType());
		System.out.println("yxg_type:"+gz_type_group.getYxgType());
		System.out.println("****************");
    	System.out.println("****************");
	}

}
