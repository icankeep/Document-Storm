//package com.passer.web.servlet;
//
//import java.io.IOException;
//import java.util.LinkedList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.passer.domain.Comment;
//import com.passer.utils.crawl.CommentsCrawl;
//
///**
//* @Description: <p>
//* @author: passer<p>
//* @version：2019年5月20日 下午8:57:01<p>
//*/
//@WebServlet("/index")
//public class IndexServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Comment comment = null;
//		try {
//			comment = CommentsCrawl.getComment();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		req.setAttribute("comment", comment);
//		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
//
//	}
//}
