package zxjt.inte.protobuf;

import java.util.Map;

import org.apache.log4j.Logger;

import zxjt.inte.util.JsonAssertUtil;
import zxjt.inte.util.ParamConstant;

public class ProtobufDetail {
	static Logger log = Logger.getLogger(ParamConstant.LOGGER);
	public static void extend_details(Protobuf.stock_details_data stockDetailsData, Map<String, String> regexMap)
	{
		Protobuf.extend_details extend_details = stockDetailsData.getExtD();
		if (regexMap.keySet().contains(ParamConstant.MA_PRICE)) {
			log.info("ma_price:"+extend_details.getMaPrice());
			JsonAssertUtil.assertRegex(ParamConstant.MA_PRICE, String.valueOf(extend_details.getMaPrice()),
					regexMap.get(ParamConstant.MA_PRICE));
		}
		if (regexMap.keySet().contains(ParamConstant.WB)) {
			log.info("wb:"+extend_details.getWb());
			JsonAssertUtil.assertRegex(ParamConstant.WB, String.valueOf(extend_details.getWb()),
					regexMap.get(ParamConstant.WB));
		}
		if (regexMap.keySet().contains(ParamConstant.WC)) {
			log.info("wc:"+extend_details.getWc());
			JsonAssertUtil.assertRegex(ParamConstant.WC, String.valueOf(extend_details.getWc()),
					regexMap.get(ParamConstant.WC));
		}
		if (regexMap.keySet().contains(ParamConstant.JZC)) {
			log.info("jzc:"+extend_details.getJzc());
			JsonAssertUtil.assertRegex(ParamConstant.JZC, String.valueOf(extend_details.getJzc()),
					regexMap.get(ParamConstant.JZC));
		}
		if (regexMap.keySet().contains(ParamConstant.SJL)) {
			log.info("sjl:"+extend_details.getSjl());
			JsonAssertUtil.assertRegex(ParamConstant.SJL, String.valueOf(extend_details.getSjl()),
					regexMap.get(ParamConstant.SJL));
		}
		if (regexMap.keySet().contains(ParamConstant.SY)) {
			log.info("sy:"+extend_details.getSy());
			JsonAssertUtil.assertRegex(ParamConstant.SY, String.valueOf(extend_details.getSy()),
					regexMap.get(ParamConstant.SY));
		}
		if (regexMap.keySet().contains(ParamConstant.QUARTER)) {
			log.info("quarter:"+extend_details.getQuarter());
			JsonAssertUtil.assertRegex(ParamConstant.QUARTER, String.valueOf(extend_details.getQuarter()),
					regexMap.get(ParamConstant.QUARTER));
		}
		if (regexMap.keySet().contains(ParamConstant.LTG)) {
			log.info("ltg:"+extend_details.getLtg());
			JsonAssertUtil.assertRegex(ParamConstant.LTG, String.valueOf(extend_details.getLtg()),
					regexMap.get(ParamConstant.LTG));
		}
		if (regexMap.keySet().contains(ParamConstant.SYLJ)) {
			log.info("sylj:"+extend_details.getSylj());
			JsonAssertUtil.assertRegex(ParamConstant.SYLJ, String.valueOf(extend_details.getSylj()),
					regexMap.get(ParamConstant.SYLJ));
		}
		if (regexMap.keySet().contains(ParamConstant.ZGB)) {
			log.info("zgb:"+extend_details.getZgb());
			JsonAssertUtil.assertRegex(ParamConstant.ZGB, String.valueOf(extend_details.getZgb()),
					regexMap.get(ParamConstant.ZGB));
		}
		log.info("****************");
    	log.info("****************");
	}
}