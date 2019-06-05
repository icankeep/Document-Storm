package com.passer.utils.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.passer.domain.PlayLists;
import com.passer.utils.crawl.GsonUtils;

import lombok.Cleanup;
import lombok.Data;

/**
* @Description: <p>
* @author: passer<p>
* @version：2019年5月20日 下午1:29:21<p>
*/
public class TranslateCrawlTest {


	public static void main(String[] args) throws IOException {
		URL url = new URL(
				"https://translate.google.cn/translate_a/single?client=webapp&sl=auto&tl=zh-CN&hl=zh-CN&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=ss&dt=t&source=bh&ssel=0&tsel=0&kc=1&tk=448952.17245&q=jsoup%20discussion%0AIf%20you%20have%20a%20question%20on%20how%20to%20use%20jsoup%2C%20please%20post%20in%20on%20Stack%20Overflow.%20Use%20the%20jsoup%20tag.%20Your%20question%20will%20be%20seen%20an%20answered%20sooner%20than%20if%20it%20is%20posted%20to%20the%20list.%20(And%20it%20may%20have%20already%20been%20answered.)%0A%0AFor%20general%20jsoup%20discussion%2C%20including%20development%20discussion%2C%20please%20join%20the%20jsoup%20mailing%20list%20by%20mailing%20jsoup%20subscribe%40googlegroups.com.%0A%0APost%20by%20sending%20mail%20to%20jsoup%40googlegroups.com.%20You%27re%20welcome%20to%20post%20without%20being%20subscribed%2C%20but%20you%20will%20need%20to%20watch%20the%20topic%20archive%20to%20get%20the%20replies.%0A%0ATo%20avoid%20spam%2C%20your%20first%20email%20to%20the%20group%20will%20be%20moderated.%20Please%20be%20patient%20and%20send%20only%20once%3A%20as%20soon%20as%20a%20moderator%20reads%20your%20email%20it%20will%20be%20sent%20on%20to%20the%20group.");
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
		@Cleanup
		InputStream inStream = conn.getInputStream();
		FileUtils.copyToFile(inStream, new File("/home/passer/1.txt"));
	}


	@Test
	public void test() throws Exception {
		Bean bean = GsonUtils.parseJsonWithGson("{list:{[1],[2]}}", Bean.class);
		System.out.println(bean.getName());
		System.out.println(bean.getList());
	}

	@Test
	public void testStr() throws Exception {
		String s = "lalala\\nlal\\n";
		s = s.replace("\n", " ");
		System.out.println(s);
	}
	private static final String IP = "http://47.100.45.234";
	private static final String CRAWLABLE_LIST_URL = IP + "/top/list?idx=";
	private static final String COMMENT_CRAWL_URL = IP + "/comment/hot?type=0&id=";
	@Test
	public void testList() throws Exception {
		URL url = new URL("http://47.100.45.234/top/list?idx=0");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
		InputStream inStream = conn.getInputStream();
		PlayLists playLists = GsonUtils.parseJsonWithGson(IOUtils.toString(url), PlayLists.class);
		System.out.println(playLists.getPlaylist());
	}


}

@Data
class Bean{
	String name;
	List<String> list;
}
