package com.passer.utils.crawl;

import com.google.gson.Gson;

/**
* @Description: Gson工具类,将JSON字符串转为Java对象<p>
* @author: passer<p>
* @version：2019年5月20日 下午2:24:03<p>
*/
public class GsonUtils {
	// 将Json数据解析成相应的映射对象
	public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
		Gson gson = new Gson();
		T result = gson.fromJson(jsonData, type);
		return result;
	}
}
