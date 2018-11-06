package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.W05GGZHService;
import zxjt.inte.util.BeforeClassUse;

/**
 * // /api/quote/pb_stockUnited  获取个股的基础详情、k线、分时、分笔数据// http://ip:port/api/quote/pb_stockUnited 个股详情
 * @author Administrator
 *
 */
//自己的类名
public class W05GGZHTest extends BaseController {
	
	// *自己的Service名称
	@Resource
	private W05GGZHService ggzhService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(ggzhService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void W05GGZH(Map<String, String> param) {

		ggzhService.test(param);
	}
}