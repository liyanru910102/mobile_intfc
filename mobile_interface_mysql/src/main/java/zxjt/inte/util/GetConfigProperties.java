package zxjt.inte.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import zxjt.inte.entity.CommonInfo;

/**
 * 根据用户需求，获取config文件并将内容读出来
 * 
 * @author Administrator
 *
 */
public class GetConfigProperties {

	public static List<CommonInfo> getConfigProToCommon() {
		List<CommonInfo> listComm = new ArrayList<CommonInfo>();
		Properties prop = new Properties();
		try {
			// 读取属性文件config.properties
			InputStream in = new BufferedInputStream(new FileInputStream("config.properties"));
			prop.load(in); /// 加载属性列表

			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				CommonInfo comm = new CommonInfo();
				String key = it.next();
				System.out.print(key + "          ");
				comm.setCname(key);
				String value = prop.getProperty(key);
				comm.setCvalue(value);
				System.out.println(value);
				listComm.add(comm);
			}
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return listComm;
	}
}
