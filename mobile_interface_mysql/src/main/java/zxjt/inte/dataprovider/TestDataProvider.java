package zxjt.inte.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import zxjt.inte.util.BeforeClassUse;

public class TestDataProvider {

	// *自己的别名
	@DataProvider(name = "testData")
	// *自己的方法名
	public static Object[][] gpmmTest(Class testClazz) {
		Object[][] obj = null;
		Object service = BeforeClassUse.getDPInfo();

		Method m;

		try {
			Class clazz = service.getClass();
			m = clazz.getDeclaredMethod("getParamsInfo");

			obj = (Object[][]) m.invoke(service);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException(e);
		}

		return obj;
	}
}
