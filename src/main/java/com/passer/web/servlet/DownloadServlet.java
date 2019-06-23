package com.passer.web.servlet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
* @Description: 文件下载辅助工具类<p>
* @author: passer<p>
* @version：2019年5月19日 下午8:24:23<p>
*/
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = (String) req.getAttribute("newFileName");
		String responseName = FilenameUtils.getName(fileName);
		// 设置响应格式
		resp.setContentType("application/x-msdownload");

		String userAgent = req.getHeader("User-Agent");

		// 针对IE或者以IE为内核的浏览器：
		if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
			responseName = java.net.URLEncoder.encode(responseName, "UTF-8");
		} else {
			// 非IE浏览器的处理：
			responseName = new String(responseName.getBytes("UTF-8"), "ISO-8859-1");
		}
		// 设置响应头
		resp.setHeader("Content-disposition", "attachment; filename=" + responseName);
		FileUtils.copyFile(new File(fileName), resp.getOutputStream());
	}
}
