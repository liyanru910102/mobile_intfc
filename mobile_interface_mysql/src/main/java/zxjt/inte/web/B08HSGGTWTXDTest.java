package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.B02HSGGTKMMSLCXService;
import zxjt.inte.service.B08HSGGTWTXDService;
import zxjt.inte.util.BeforeClassUse;

//自己的类名
public class B08HSGGTWTXDTest extends BaseController {

	// *自己的Service名称
	@Resource
	private B08HSGGTWTXDService wtxdService;
	
	@Resource
	private B02HSGGTKMMSLCXService kmmslcxService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(wtxdService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void B08HsggtWtxd(Map<String, String> param,Map<String, String> tempKmmsl) {

		wtxdService.test(param,tempKmmsl,kmmslcxService);
	}
}
