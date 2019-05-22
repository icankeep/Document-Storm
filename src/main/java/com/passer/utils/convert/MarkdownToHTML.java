package com.passer.utils.convert;

/**
* @Description: Markdown文件转为HTML文件<p>
* @author: passer<p>
* @version：2019年5月18日 下午1:42:17<p>
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.FilenameUtils;
import org.parboiled.common.FileUtils;
import org.pegdown.PegDownProcessor;

import lombok.Cleanup;

public class MarkdownToHTML {

	private static void startDocument(StringBuilder buf, String mdFileName) throws IOException {
		buf.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"" + "\n"
				+ "\"http://www.w3.org/TR/html4/loose.dtd\">\n");
		buf.append("<html><head>");
		buf.append("<title>").append(FilenameUtils.getName(mdFileName)).append("</title>\n");
		buf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=\"UTF-8\">\n");
		buf.append("</head>\n");
		buf.append("<body>\n");
	}

	private static void endDocument(StringBuilder buf) throws IOException {
		buf.append("</body></html>");
	}

	public void generateHtml(String mdFileName, String htmlFileName) throws IOException {
		// 缓冲html文件
		StringBuilder buf = new StringBuilder();
		// html头部
		startDocument(buf, mdFileName);
		
		@Cleanup
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(mdFileName)), "UTF-8"));
		@Cleanup
		FileOutputStream fos = new FileOutputStream(new File(htmlFileName), true);
		
		// 读入markdown文件
		String line = null;
		String mdContent = "";
		while ((line = br.readLine()) != null) {
			mdContent += line + "\r\n";
		}
		
		// markdown文件转换
		PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
		buf.append(pdp.markdownToHtml(mdContent));
		
		// 加入html尾部
		endDocument(buf);
		fos.write(buf.toString().getBytes());
	}
}
