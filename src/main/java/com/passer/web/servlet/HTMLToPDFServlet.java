package com.passer.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.passer.utils.convert.HTMLToPDF;

/**
 * @ClassName: PDFServlet
 * @description: PDF文件上传到服务器转成DOC，并供用户下载
 * @author: passer
 * @Date: 2019年3月22日 下午4:10:00
 */
@WebServlet("/html2pdf")
public class HTMLToPDFServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filePath = (String) req.getAttribute("filePath");
		String newFileName = (String) req.getAttribute("newFileName");
		HTMLToPDF convert = new HTMLToPDF();
		if (newFileName != null && !"".equals(newFileName.trim())) {
			newFileName = FilenameUtils.getFullPath(filePath) + newFileName + ".pdf";
		} else {
			newFileName = FilenameUtils.getFullPath(filePath) + FilenameUtils.getBaseName(filePath) + ".pdf";
		}
		convert.generatePDF(filePath, newFileName);
		req.setAttribute("newFileName", newFileName);
		req.getRequestDispatcher("/download").forward(req, resp);
	}
}
