package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.B00HSGGTCCCXService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class B00HSGGTCCCXTest extends BaseController {

	// *自己的Service名称
	@Resource
	private B00HSGGTCCCXService cccxService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(cccxService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B00HsggtCccx(Map<String, String> param) {

		cccxService.test(param);
	}
}
