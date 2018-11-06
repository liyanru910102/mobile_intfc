package zxjt.inte.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WTXHBean {
	
	// 存储合同单号用以撤单或查询等功能使用
	private static Map<Object, Object> mapVo = new HashMap<>();

	public static String getVo(String key) {
		return (String) mapVo.get(key);

	}

	/*
	 * 仅需要操作合同序号进行撤单的
	 */
	public static void putVo(String key, String value) {
		mapVo.put(key, value);

	}

	public static Set<Object> ConkeySet() {
		Set<Object> conKeySet = mapVo.keySet();
		return conKeySet;
	}

	public static void removeKey(String key) {
		mapVo.remove(key);
	}

	/*
	 * 需要操作多个参数进行撤单的
	 */
	public static void putMap(String key, Map<String, String> param) {
		mapVo.put(key, param);

	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> getMap(String key) {
		return (Map<String, String>) mapVo.get(key);

	}
}
