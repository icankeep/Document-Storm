package com.passer.utils.crawl;

/**
* @Description: 自定义解析,目前用于解析谷歌翻译的响应<p>
* @author: passer<p>
* @version：2019年5月20日 下午4:37:49<p>
*/
public class MyJsonResolve {
	public static String resolve(String jsonData) {
		int count = 0;
		int i = 2;
		for(; i < jsonData.length(); i++) {
			if (jsonData.charAt(i) == '[') count++;
			else if (jsonData.charAt(i) == ']') {
				if (count == 0) break;
				count--;
			}
		}
		jsonData = "" + jsonData.substring(3, i);
		return jsonData;
	}
}
