package com.passer.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.passer.utils.crawl.MyJsonResolve;

import lombok.Cleanup;

/**
* @Description: 文档翻译Servlet类<p>
* @author: passer<p>
* @version：2019年5月20日 下午1:37:53<p>
*/
@WebServlet("/word_translate")
public class TranslateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String urlPrefix = "https://translate.google.cn/translate_a/single?client=webapp&sl=auto&tl=zh-CN"
			+ "&hl=zh-CN&dt=at&dt=bd&dt=ex&dt=ld&dt=md&dt=qca&dt=rw&dt=rm&dt=ss&dt=t&source=bh"
			+ "&ssel=0&tsel=0&kc=1&tk=448952.17245&q=";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filePath = (String) req.getAttribute("filePath");
		String newFileName = (String) req.getAttribute("newFileName");
		if (newFileName != null && !"".equals(newFileName.trim())) {
			newFileName = FilenameUtils.getFullPath(filePath) + newFileName + ".doc";
		} else {
			newFileName = FilenameUtils.getFullPath(filePath) + FilenameUtils.getBaseName(filePath) + "_translate.doc";
		}
		String docString = FileUtils.readFileToString(new File(filePath), "utf-8");
		docString = URLEncoder.encode(docString);
//		docString = docString.replaceAll("@", "%40");
//		docString = docString.replace(",", "%2C");
//		docString = docString.replace(":", "%3A");
//		docString = docString.replace("'", "%27");
//		docString = docString.replaceAll(" ", "%20");
//		docString = docString.replaceAll("\\n", "%0A");
		String urlString = urlPrefix + docString;
		
		while (urlString.endsWith("%0A")) {
			urlString = urlString.substring(0, urlString.length() - 3);
		}
		
		URL url = new URL(urlString);
		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
		@Cleanup
		InputStream inStream = conn.getInputStream();
		File jsonFile = new File("json.txt");
		jsonFile.delete();
		FileUtils.copyToFile(inStream, jsonFile);
		String jsonString = FileUtils.readFileToString(new File("json.txt"), "utf-8");
		String[] lines = MyJsonResolve.resolve(jsonString).split("\\],\\[");
		File translateFile = new File(newFileName);
		@Cleanup
		FileOutputStream fos = new FileOutputStream(translateFile);
		for(String tmp : lines) {
			tmp = tmp.replaceAll("\\\\n", " ");
			tmp = tmp.substring(0, tmp.length() - 12) + "\n\n";
			System.out.println(tmp);
			fos.write(tmp.getBytes());
		}
		
		req.setAttribute("newFileName", newFileName);
		req.getRequestDispatcher("/download").forward(req, resp);
	}
}
