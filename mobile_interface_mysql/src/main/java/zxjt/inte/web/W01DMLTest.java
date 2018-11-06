package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.W01DMLService;
import zxjt.inte.util.BeforeClassUse;

/**
 * // http://ip:port/api/quote/pb_codeList 代码链  // /api/quote/pb_codeList 全市场代码表
 * @author Administrator
 *
 */
//自己的类名
public class W01DMLTest extends BaseController {
	
	// *自己的Service名称
	@Resource
	private W01DMLService dmlService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(dmlService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void W01DML(Map<String, String> param) {

		dmlService.test(param);
	}
}