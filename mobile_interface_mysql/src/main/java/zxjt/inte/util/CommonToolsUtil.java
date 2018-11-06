package zxjt.inte.util;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

import net.minidev.json.JSONArray;
import zxjt.inte.dao.CommonWWDao;
import zxjt.inte.entity.CommonInfo;
import zxjt.inte.entity.CommonJY;
import zxjt.inte.entity.CommonWW;

public class CommonToolsUtil {

	/**
	 * 去除入参数据中包含的非传入数据，例如“测试点”、“类型”等等
	 * 
	 * @param param
	 * @return
	 */
	public static Map<String, String> getRParam(Map<String, String> param) {
		Map<String, String> RParam = new HashMap<>();
		RParam.putAll(param);
		RParam.remove("isExcute");
		RParam.remove("type");
		RParam.remove("expectMsg");
		RParam.remove("testPoint");
		RParam.remove("url");
		RParam.remove("row");
		RParam.remove(ParamConstant.SAFEURL);
		RParam.remove(ParamConstant.UNSAFEURL);
		return RParam;
	}

	/**
	 * 返回校验列的集合，用来校验入参是否与数据库一致的
	 * 
	 * @param content
	 *            从数据中取出来的content
	 * @return 返回存储了method和入参params的map；params用来校验，method用来判断本次请求是哪种方式（post、get等）
	 */
	public static Map<String, List<String>> getValidateParam(String content) {
		Map<String, List<String>> mapParam = new HashMap<String, List<String>>();
		List<String> param = new ArrayList<>();
		List<String> method = new ArrayList<>();
		Object o = JsonPath.read(content, "$.params", new Predicate[0]);
		JSONArray ja = (JSONArray) o;
		for (int i = 0; i < ja.size(); i++) {
			Map<String, String> map = (Map<String, String>) ja.get(i);
			param.add(map.get("name"));
		}
		mapParam.put(ParamConstant.VALIDATEPARAM, param);
		JSONArray jsMethod = (JSONArray) (JsonPath.read(content, "$.methods", new Predicate[0]));
		String strMethod = "";
		if (jsMethod.size() > 0) {
			strMethod = (String) jsMethod.get(0);
		}
		method.add(strMethod);
		mapParam.put(ParamConstant.MEHTOD, method);
		return mapParam;
	}

	/**
	 * 将被依赖接口从数据库中取出来的值组合成入参的map
	 * 
	 * @param lisMap
	 *            数据库查询出来入参值
	 * @param commonParam
	 *            从公共数据表中查询出来的公共入参
	 * @return 拼接后指定url需要的入参值
	 */
	public static Map<String, String> getDependencyParamInfo(Object map, Map<String, String> commonParam) {

		List<Object> lisMap = (List<Object>) map;
		Map<String, String> mapParam = new HashMap<>();
		int rowIndex = 1;
		String paramUrl = "";
		Class clazz = lisMap.get(0).getClass();
		try {

			Method mUrl = clazz.getDeclaredMethod("getUrl");
			Method mContent = clazz.getDeclaredMethod("getContent");

			paramUrl = (String) mUrl.invoke(lisMap.get(0));
			String url = commonParam.get(ParamConstant.SAFEURL) + paramUrl;

			for (int i = 0; i < lisMap.size(); i++) {
				Class evCla = lisMap.get(i).getClass();
				Method mRowIndex = evCla.getDeclaredMethod("getRowindex");
				Method mCname = evCla.getDeclaredMethod("getCname");
				Method mCvalue = evCla.getDeclaredMethod("getCvalue");
				if (rowIndex != ((Integer) mRowIndex.invoke(lisMap.get(i)))) {
					throw new RuntimeException("依赖接口不能存在多条数据，请查证！");
				}

				mapParam.put((String) mCname.invoke(lisMap.get(i)), (String) mCvalue.invoke(lisMap.get(i)));

			}
			String content = (String) mContent.invoke(lisMap.get(0));
			mapParam.putAll(commonParam);
			mapParam.put("url", url);

			// 校验
			validateParamIsMatch(content, mapParam);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return mapParam;
	}

	/**
	 * 将测试接口从数据库中取出来的值组合成入参的map集合
	 * 
	 * @param lisMap
	 *            数据库查询出来入参值
	 * @param commonParam
	 *            从公共数据表中查询出来的公共入参
	 * @return 拼接后指定url需要的入参值
	 */
	public static List<Map<String, String>> getDependencyParamsInfo(List<CommonJY> lis, Map<String, String> commonParam) {

		List<CommonJY> lisMap =  lis;
		Map<String, String> mapParam = new HashMap<>();
		List<Map<String, String>> lisTemp = new ArrayList<>();
		int rowIndex = 0;
		try {

			String url = commonParam.get(ParamConstant.SAFEURL) + lisMap.get(0).getUrl();
			for (int i = 0; i < lisMap.size(); i++) {
				CommonJY cj = lisMap.get(i);
				int mRowIndex=cj.getRowindex();

				if (rowIndex != mRowIndex) {
					rowIndex = mRowIndex;
					mapParam.putAll(commonParam);
					mapParam.put("url", url);
					lisTemp.add(mapParam);
					mapParam = new HashMap<>();
					mapParam.put("row", String.valueOf(rowIndex));
				}
				mapParam.put(cj.getCname(), cj.getCvalue());
			}
			lisTemp.add(mapParam);
			lisTemp.remove(0);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return lisTemp;
	}

	/**
	 * 将测试接口从数据库中取出来的值组合成入参的map集合
	 * 
	 * @param lisMap
	 *            数据库查询出来入参值
	 * @param commonParam
	 *            从公共数据表中查询出来的公共入参
	 * @return 拼接后指定url需要的入参值
	 */
	public static List<Map<String, String>> getWWParamsInfo(Object map, Map<String, String> commonParam) {

		List<Object> lisMap = (List<Object>) map;
		Map<String, String> mapParam = new HashMap<>();
		List<Map<String, String>> lisTemp = new ArrayList<>();
		int rowIndex = 0;
		String paramUrl = "";
		Class clazz = lisMap.get(0).getClass();
		try {

			Method mUrl = clazz.getDeclaredMethod("getUrl");

			paramUrl = (String) mUrl.invoke(lisMap.get(0));

			for (int i = 0; i < lisMap.size(); i++) {
				Class evCla = lisMap.get(i).getClass();
				Method mRowIndex = evCla.getDeclaredMethod("getRowindex");
				Method mCname = evCla.getDeclaredMethod("getCname");
				Method mCvalue = evCla.getDeclaredMethod("getCvalue");

				if (rowIndex != ((Integer) mRowIndex.invoke(lisMap.get(i)))) {
					rowIndex = (Integer) mRowIndex.invoke(lisMap.get(i));
					lisTemp.add(mapParam);
					mapParam = new HashMap<>();
					String url = commonParam.get(ParamConstant.UNSAFEURL) + paramUrl;
					mapParam.put("url", url);
					mapParam.put("row", String.valueOf(rowIndex));
				}
				mapParam.put((String) mCname.invoke(lisMap.get(i)), (String) mCvalue.invoke(lisMap.get(i)));
			}
			lisTemp.add(mapParam);
			lisTemp.remove(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lisTemp;
	}

	public static List<Map<String, String>> filterOfIsExcute(List<Map<String, String>> lisParams) {
		List<Map<String, String>> lis = new ArrayList<>();
		lis.addAll(lisParams);
		for (int i = 0; i < lis.size(); i++) {
			Map<String, String> map = lis.get(i);
			if (!Boolean.valueOf(map.get("type"))) {
				lis.remove(map);
			}
		}
		return lis;
	}

	/**
	 * 
	 * @param content
	 *            数据库搜索出来的content
	 * @param mapTemp
	 *            要校验的每行数据的map
	 */
	public static void validateParamIsMatch(String content, Map<String, String> mapTemp) {
		try {
			Map<String, List<String>> mapStr = CommonToolsUtil.getValidateParam(content);
			List<String> lStr = mapStr.get(ParamConstant.VALIDATEPARAM);
			Map<String, String> m = CommonToolsUtil.getRParam(mapTemp);
			List<String> list2 = new ArrayList<String>();
			List<String> list3 = new ArrayList<String>();
			list2.addAll(m.keySet());
			if (!list2.containsAll(lStr) || !lStr.containsAll(list2)) {
				throw new RuntimeException("该接口入参已更新，请修正代码以匹配数据库的更改再执行！");
			} else {
				System.out.println("入参校验通过！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String getPrice(String pricetype, String response) {

		String wtjg = "";
		try {
			switch (pricetype) {
			case "{PRICE}":
			case "市价":
				wtjg = String.valueOf(JsonPath.read(response, "$.kmmxx[0].jrkpj", new Predicate[0]));
				break;
			case "{LOW}":
				String dtjg = (String) JsonPath.read(response, "$.kmmxx[0].dtjg", new Predicate[0]);
				if ("".equals(dtjg) || null == dtjg) {
					throw new RuntimeException("查询接口返回字段异常：dtjg字段为空值");
				}
				wtjg = String.format("%.2f", Double.valueOf(dtjg) - 0.1);
				break;
			case "{HIGH}":
				String ztjg = (String) JsonPath.read(response, "$.kmmxx[0].ztjg", new Predicate[0]);
				if ("".equals(ztjg) || null == ztjg) {
					throw new RuntimeException("查询接口返回字段异常：ztjg字段为空值");
				}
				wtjg = String.format("%.2f", Double.valueOf(ztjg) + 0.1);
				break;
			case "{latestDealPrice}":
				String jg = (String) JsonPath.read(response, "$.kmmxx[0].wtjg", new Predicate[0]);
				if ("".equals(jg) || null == jg) {
					throw new RuntimeException("查询接口返回字段异常：wtjg字段为空值");
				}
				wtjg = String.format("%.2f", Double.valueOf(jg));
				break;
			case "{DealConfirmPrice}":
				String DealConfirmPrice = (String) JsonPath.read(response, "$.htxx[0].wtjg", new Predicate[0]);
				if ("".equals(DealConfirmPrice) || null == DealConfirmPrice) {
					throw new RuntimeException("查询接口返回字段异常：htxx[0].wtjg字段为空值");
				}
				wtjg = String.format("%.2f", Double.valueOf(DealConfirmPrice));
				break;
			case "{NULL}":
				wtjg = "";
				break;
			default:
				wtjg = pricetype;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return wtjg;

	}

	/**
	 * 获取查询接口的最大可买数量，赋值给下单接口报文中
	 * 
	 * @param 获取的买卖类别
	 * @param 获取的数量的类型
	 * @param 从接口返回的数据的被查找的字符串
	 * @return 返回修改好的价格
	 */
	public static String getOverBSQty(String mmlb, String qtytype, String CXRespose) {
		String actualqty = "";
		String qtyflag = "";
		if ("B".equals(mmlb)) {
			qtyflag = "$.kmmxx[0].kmsl";
		}
		if ("S".equals(mmlb)) {
			qtyflag = "$.kmmxx[0].gfkys";
		}
		switch (qtytype) {
		case "{OverBSQty}":
			try {
				actualqty = String.valueOf(
						Integer.parseInt((String) JsonPath.read(CXRespose, qtyflag, new Predicate[0])) / 1000 * 1000
								+ 1000);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());// 123456
			}
			break;
		default:
			actualqty = qtytype;
		}
		return actualqty;
	}

	public static Map<String, String> getCommonParam(List<CommonInfo> lisCo) {
		Map<String, String> commonParam = new HashMap<>();
		for (CommonInfo a : lisCo) {
			commonParam.put(a.getCname(), a.getCvalue());
		}
		return commonParam;
	}

	public static Object[][] getObjParam(List<Map<String, String>> lisTemp) {
		Object[][] obj = new Object[lisTemp.size()][1];
		for (int j = 0; j < obj.length; j++) {
			obj[j][0] = lisTemp.get(j);
		}
		return obj;
	}

	public static Object[][] getWWservice(CommonWWDao wwDao, int id) {
		// 公共参数操作
		List<CommonInfo> lisag = GetConfigProperties.getConfigProToCommon();
		Map<String, String> commonParam = CommonToolsUtil.getCommonParam(lisag);

		// 数据操作
		List<CommonWW> lis = wwDao.getParamsInfo(id);
		List<Map<String, String>> lisTemp = CommonToolsUtil.getWWParamsInfo(lis, commonParam);

		Object[][] obj = getObjParam(lisTemp);
		return obj;
	}

	public static String getToday(String format) {

		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat(format);
		String today = sd.format(date);
		return today;
	}
	
	/**
	 * 获取查询日期信息
	 * 
	 * @param param
	 *            下单发送的json转换的map
	 * @return 返回修改好入参的下单报文map
	 */
	public static void getcxrqInfo(Map<String, String> param) {
		Calendar cal = Calendar.getInstance();
		Date dateNow = cal.getTime();
		if ((param.get(ParamConstant.QSRQ).contains(ParamConstant.ONEMONTH))
				||(param.get(ParamConstant.ZZRQ).contains(ParamConstant.ONEMONTH))) {
			cal.add(Calendar.DAY_OF_YEAR, -1);
			dateNow = cal.getTime();
			cal.add(Calendar.MONTH, -1);

		} else if ((param.get(ParamConstant.QSRQ).contains(ParamConstant.THREEMONTH))
				||(param.get(ParamConstant.ZZRQ).contains(ParamConstant.THREEMONTH))) {
			cal.add(Calendar.MONTH, -3);
		} else {
			return;
		}
		Date dateKS = cal.getTime();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String dateKsrq = df.format(dateKS);
		String dateZzrq = df.format(dateNow);
		param.put(ParamConstant.QSRQ, dateKsrq);
		param.put(ParamConstant.ZZRQ, dateZzrq);
		
	}
	
	/**
	 * 返回数量值
	 * 
	 * @param mrdw
	 *            买入单位（如果查询结果中不存在该字段，则传每手股最小单位即可，股票100，基金1000）
	 * @param num
	 *            买卖上限加情况下的计算基础值
	 * @param parWtsl
	 *            数量类型
	 * @param plus
	 *            可买卖上限加的数值 ETF-10000 ；LOF-10000；开放式基金-1000
	 * @return 网下现金认购信息查询接口返回结果
	 */
	public static String getWtsl(String mrdw, String num, String parWtsl, int plus) {
		int iMrdw = Math.round(Float.valueOf(mrdw));
		int iWtsl = 0;

		// 不同场合下处理方式
		if ("1倍".equals(parWtsl)) {
			iWtsl = iMrdw;
		} else if ("可买卖上限加".equals(parWtsl)) {
			iWtsl = Math.round(Float.valueOf(num)) / iMrdw * iMrdw + plus;

		} else if ("不是整数倍".equals(parWtsl)) {
			iWtsl = iMrdw + 1;
		} else {
			String pattern = "([0-9]+|[0-9]+\\.[0-9]+)";
			Pattern p = Pattern.compile(pattern);
			Matcher matcher = p.matcher(parWtsl);
			if (matcher.matches()) {
				iWtsl = Math.round(Float.valueOf(parWtsl));
			} else {
				throw new RuntimeException("数据库中委托数量有误");
			}
		}
		return String.valueOf(iWtsl);
	}
}
