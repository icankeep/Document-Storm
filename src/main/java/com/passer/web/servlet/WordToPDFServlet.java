package com.passer.web.servlet;

import com.passer.utils.convert.WordToPDF;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: word转为pdf的Servlet类
 * @author: passer
 * @Date: 2019年3月22日 下午4:10:00
 */
@WebServlet("/doc2pdf")
public class WordToPDFServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filePath = (String) req.getAttribute("filePath");
		String newFileName = (String) req.getAttribute("newFileName");
		WordToPDF convert = new WordToPDF();
		if (newFileName != null && !"".equals(newFileName.trim())) {
			newFileName = FilenameUtils.getFullPath(filePath) + newFileName + ".pdf";
		} else {
			newFileName = FilenameUtils.getFullPath(filePath) + FilenameUtils.getBaseName(filePath) + ".pdf";
		}
		convert.doc2pdf(filePath, newFileName);
		req.setAttribute("newFileName", newFileName);
		req.getRequestDispatcher("/download").forward(req, resp);
	}
}
