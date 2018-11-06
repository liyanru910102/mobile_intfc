package zxjt.inte.web;

import java.util.Map;

import javax.annotation.Resource;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zxjt.inte.dataprovider.TestDataProvider;
import zxjt.inte.service.W04BKPHIndexService;
import zxjt.inte.util.BeforeClassUse;

/**
 * // http:// ip:port /api/quote/pb_blockRankIndex 板块排行索引
 * @author Administrator
 *
 */
//自己的类名
public class W04BKPHIndexTest extends BaseController {
	
	// *自己的Service名称
	@Resource
	private W04BKPHIndexService bkphindexService;

	@BeforeClass
	public void setup() {
		BeforeClassUse.setDPInfo(bkphindexService);
	}

	@Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
	public void W04BKPHIndex(Map<String, String> param) {

		bkphindexService.test(param);
	}
}