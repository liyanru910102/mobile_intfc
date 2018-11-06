package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.W03GPPHService;
import zxjt.inte.util.BeforeClassUse;

/**
 * // /api/quote/pb_stockRank 获取股票的排行榜数据   // http://ip:port/api/quote/pb_stockRank 股票排行
 * @author Administrator
 *
 */
//自己的类名
public class W03GPPHTest extends BaseController {
	
	// *自己的Service名称
	@Resource
	private W03GPPHService gpphService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(gpphService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void W03GPPH(Map<String, String> param) {

		gpphService.test(param);
	}
}