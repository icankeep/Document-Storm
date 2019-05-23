package com.passer.web.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Description: 用于对网站请求的分发,根据opt参数值确定后续的操作<p>
* @author: passer<p>
* @version：2019年5月19日 上午10:54:15<p>
*/
@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static final Set<String> optSet = new HashSet<String>();
	
	static {
		optSet.add("pdf2doc");
		optSet.add("md2html");
		optSet.add("md2pdf");
		optSet.add("word_translate");
		optSet.add("html2pdf");
		optSet.add("image2pdf");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opt = req.getParameter("opt");
		if(opt == null || !optSet.contains(opt)) {
			//调到错误界面
			return;
		}
		req.setAttribute("opt", opt);
		req.getRequestDispatcher("fileupload.jsp").forward(req, resp);
	}
}
