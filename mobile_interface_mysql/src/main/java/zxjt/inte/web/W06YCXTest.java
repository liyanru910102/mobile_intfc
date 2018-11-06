package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.W06YCXService;
import zxjt.inte.util.BeforeClassUse;

/**
 * // http://111.13.63.2:9800/api/quote/cloud_dm/?000001
 * @author Administrator
 *
 */
//自己的类名
public class W06YCXTest extends BaseController {
	
	// *自己的Service名称
	@Resource
	private W06YCXService ycxService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(ycxService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void W06YCX(Map<String, String> param) {

		ycxService.test(param);
	}
}