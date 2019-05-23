package com.passer.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import com.passer.exception.LogicException;
import com.passer.utils.convert.MarkdownToPDF;
import com.passer.utils.convert.PDFToWord;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import com.qkyrie.markdown2pdf.internal.exceptions.Markdown2PdfLogicException;

/**
 * @description: markdown转为pdf的Servlet类
 * @author: passer
 * @Date: 2019年3月22日 下午4:10:00
 */
@WebServlet("/md2pdf")
public class MarkdownToPDFServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filePath = (String) req.getAttribute("filePath");
		String newFileName = (String) req.getAttribute("newFileName");
		if (newFileName != null && !"".equals(newFileName.trim())) {
			newFileName = FilenameUtils.getFullPath(filePath) + newFileName + ".pdf";
			System.out.println(newFileName);
		} else {
			newFileName = FilenameUtils.getFullPath(filePath) + FilenameUtils.getBaseName(filePath) + ".pdf";
			System.out.println(newFileName);
		}
		MarkdownToPDF convert = new MarkdownToPDF();
		try {
			convert.generatePDF(filePath, newFileName);
		} catch (Exception e) {
			// 跳转错误界面
			return;
		}
		req.setAttribute("newFileName", newFileName);
		req.getRequestDispatcher("/download").forward(req, resp);
	}
}
