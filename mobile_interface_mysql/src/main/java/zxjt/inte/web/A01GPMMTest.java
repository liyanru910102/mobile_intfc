package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.A01GPMMService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class A01GPMMTest extends BaseController {

	// *自己的Service名称
	@Resource
	private A01GPMMService gpmmService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(gpmmService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void A01GPMM(Map<String, String> param, Map<String, String> DependenceParam) {

		gpmmService.test(param, DependenceParam);
	}
}
