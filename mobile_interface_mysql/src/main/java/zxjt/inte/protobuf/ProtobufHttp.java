package zxjt.inte.protobuf;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ProtobufHttp {

	/**
	 * 向外围地址发送请求
	 * @param postdata 入参流
	 * @param strUrl 外围地址
	 * @return 响应流
	 */
	public static InputStream post(byte[] postdata, String strUrl) {

		InputStream stream = null;
		try {
			
			// 获取请求地址
			URL url = new URL(strUrl); 
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoInput(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setConnectTimeout(3000);
			BufferedOutputStream outputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
			
			// 写入输出流
			outputStream.write(postdata);
			outputStream.flush();
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
				 stream = httpURLConnection.getInputStream();
			}else
			{
				throw new RuntimeException(httpURLConnection.getResponseMessage());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		// 返回响应流
		return stream;
	}
}