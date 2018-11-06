package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.B03HSGGTZJCXService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class B03HSGGTZJCXTest extends BaseController {

	// *自己的Service名称
	@Resource
	private B03HSGGTZJCXService hsggtService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(hsggtService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B03HsggtZjcx(Map<String, String> param) {

		hsggtService.test(param);
	}
}
