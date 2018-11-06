package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.W02BKPHService;
import zxjt.inte.util.BeforeClassUse;

/**
 * // /api/quote/pb_blockRank 获取板块的排行榜数据  // http://ip:port/api/quote/pb_blockRank 板块排行
 * @author Administrator
 *
 */
//自己的类名
public class W02BKPHTest extends BaseController {
	
	// *自己的Service名称
	@Resource
	private W02BKPHService bkphService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(bkphService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void W02BKPH(Map<String, String> param) {

		bkphService.test(param);
	}
}