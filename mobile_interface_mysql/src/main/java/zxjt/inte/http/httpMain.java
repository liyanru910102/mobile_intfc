package zxjt.inte.http;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zxjt.inte.report.DBConnection;
import zxjt.inte.testng.listener.HTMLReporter;
import zxjt.inte.util.TestNg;

public class httpMain {

	public static void main(String[] args) throws Exception {

		if (args.length <= 0) {
			throw new RuntimeException("请输入需要执行的模块");
		}

		String testCase = String.valueOf(args[0]);
		String[] strTst = testCase.split(",");
		List<String> list = Arrays.asList(strTst);

		TestNg testNew = new TestNg(false);
		testNew.setParam(list);
		testNew.run();
		HTMLReporter.generate();
		DBConnection.close();
	}
}