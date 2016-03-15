package com.ai.educore.batchdeal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaiduTest {
	String urlString;

	public static void main(String[] args) throws Exception {
//		BaidiTest client = new BaidiTest("https://www.jd.com/");
		BaiduTest client = new BaiduTest("https://www.baidu.com/");
		client.run();
	}

	public BaiduTest(String urlString) {
		this.urlString = urlString;
	}

	public void run() throws Exception {
		// 生成一个URL对象
		URL url = new URL(urlString);
		// 打开URL
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		// 得到输入流，即获得了网页的内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		// 读取输入流的数据，并显示
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}
}
