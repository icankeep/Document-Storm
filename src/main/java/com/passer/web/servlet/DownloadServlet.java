package com.passer.web.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
* @Description: <p>
* @author: passer<p>
* @version：2019年5月19日 下午8:24:23<p>
*/
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = (String) req.getAttribute("newFileName");
		// 设置响应格式
		resp.setContentType("application/x-msdownload");
		// 设置响应头
		resp.setHeader("Content-disposition", "attachment; filename=" + FilenameUtils.getName(fileName));
		FileUtils.copyFile(new File(fileName), resp.getOutputStream());
	}
}
