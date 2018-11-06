package zxjt.inte.util;

import java.util.HashMap;
import java.util.Map;

public class ValidateExceptionBean {
	private static Map<Integer, Object> veInfo= new HashMap<>() ;
	private static int i=1;

	public static Map<Integer, Object> getveInfo() {
		return veInfo;
	}

	public static void setveInfo(Object veInfo) {
		ValidateExceptionBean.veInfo.put(i, veInfo);
		i++;
	}
	
	public static void clear()
	{
		i=1;
		veInfo.clear();
	}
}
