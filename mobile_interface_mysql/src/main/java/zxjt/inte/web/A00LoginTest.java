package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.A00LoginService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class A00LoginTest extends BaseController {

	// *自己的Service名称
	@Resource
	private A00LoginService loginService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(loginService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void A00Login(Map<String, String> param) {

		loginService.test(param);
	}
}
