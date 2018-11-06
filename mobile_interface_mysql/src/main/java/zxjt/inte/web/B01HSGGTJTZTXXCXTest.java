package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.B01HSGGTJYZTXXCXService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class B01HSGGTJTZTXXCXTest extends BaseController {

	// *自己的Service名称
	@Resource
	private B01HSGGTJYZTXXCXService jyztxxcxService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(jyztxxcxService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B01HsggtJyztxxcx(Map<String, String> param) {

		jyztxxcxService.test(param);
	}
}
