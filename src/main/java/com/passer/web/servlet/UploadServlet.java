package com.passer.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
* @Description: 文件上传工具类,并根据opt参数进行请求转发到不同Servlet中<p>
* @author: passer<p>
* @version：2019年5月19日 下午8:22:26<p>
*/
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 判断是否是正常的上传操作
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			// 跳转到错误界面
			return;
		} 
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(req);
			Iterator<FileItem> it = items.iterator();
			String newFileName = null;
			String opt = null;
			String filePath = null;
			String fileExtension = null;
			while (it.hasNext()) {
				FileItem item = it.next();
				if (item.isFormField()) {
					if ("newFileName".equals(item.getFieldName())) {
						newFileName = item.getString();
					} else {
						opt = item.getString();
					}
				} else {
					String fileName = FilenameUtils.getName(item.getName());
					fileExtension = FilenameUtils.getExtension(item.getName());
					// 获取上传文件夹目录
					String dir = req.getServletContext().getRealPath("/WEB-INF/upload/");
					File file = new File(dir);
					file.mkdir();
					
					file = new File(dir, fileName);
					filePath = file.getAbsolutePath();
					// 将文件写入指定文件
					if (file.exists()) file.delete();
					item.write(file);
				}

			}
			// 操作有误
			if (opt == null || filePath == null) {
				req.setAttribute("errorMsg", "请按正确操作上传文件！");
				// 跳转到错误界面
				return;
			}
			
			// 设置属性 请求转发
			if (newFileName != null || !"".equals(newFileName.trim())) {
				req.setAttribute("newFileName", FilenameUtils.getBaseName(newFileName));
			}
			req.setAttribute("filePath", filePath);
			if ("pdf2doc".equals(opt) && "pdf".equals(fileExtension)) {
				req.getRequestDispatcher("/pdf2doc").forward(req, resp);
			} else if ("md2html".equals(opt) && "md".equals(fileExtension)) {
				req.getRequestDispatcher("/md2html").forward(req, resp);
			} else if ("md2pdf".equals(opt) && "md".equals(fileExtension)) {
				req.getRequestDispatcher("/md2pdf").forward(req, resp);
			} else if ("word_translate".equals(opt)) {
				req.getRequestDispatcher("/word_translate").forward(req, resp);
			} else if ("doc2pdf".equals(opt) && ("doc".equals(fileExtension) || "docx".equals(fileExtension) || "odt".equals(fileExtension))) {
				req.getRequestDispatcher("/doc2pdf").forward(req, resp);
			} else if ("html2pdf".equals(opt) && "html".equals(fileExtension)) {
				req.getRequestDispatcher("/html2pdf").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
