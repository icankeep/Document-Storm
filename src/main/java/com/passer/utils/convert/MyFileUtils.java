package com.passer.utils.convert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

import com.passer.exception.LogicException;

import lombok.Cleanup;

/**
 * @ClassName: FileUtils
 * @description:目前没有使用,文件工具类，处理文件上传、下载及格式转换操作<p>
 * @author: passer
 * @Date: 2019年3月24日 下午12:47:55
 */
//public class MyFileUtils {
//
//	/**
//	 * 实现图片到PDF文件的转换
//	 * @param imagePath		图片的路径
//	 * @param pdfPath		转换后PDF的路径，后缀必须为.pdf
//	 * @throws IOException	IO异常
//	 */
//	public static void image2PDF(String imagePath, String pdfPath) throws IOException {
//
//		PDDocument doc = new PDDocument();
//		try {
//			PDPage page = new PDPage();
//			doc.addPage(page);
//
//			// createFromFile is the easiest way with an image file
//			// if you already have the image in a BufferedImage,
//			// call LosslessFactory.createFromImage() instead
//			PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);
//
//			PDPageContentStream contents = new PDPageContentStream(doc, page);
//
//			// draw the image at full size at (x=20, y=20)
//			contents.drawImage(pdImage, 20, 20);
//
//			// to draw the image at half size at (x=20, y=20) use
//			// contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2,
//			// pdImage.getHeight() / 2);
//
//			contents.close();
//			doc.save(pdfPath);
//		} finally {
//			doc.close();
//		}
//	}
//
//	/**
//	 *
//	* <p>Description: PDF -- > DOC 文件转换 </p>
//	* @param pdfFileName	文件绝对路径名 </p>
//	* @return				返回修改之后文件的绝对路径 </p>
//	 */
//	public static String pdf2Word(String pdfFileName) {
//		try {
//			@Cleanup
//			PDDocument doc = PDDocument.load(new File(pdfFileName));
//			// 获取总页数
//			int pagenumber = doc.getNumberOfPages();
//			// 转换之后的绝对路径
//			String newFileName = pdfFileName.substring(0, pdfFileName.lastIndexOf(".")) + ".doc";
//			@Cleanup
//			FileOutputStream fos = new FileOutputStream(newFileName);
//			@Cleanup
//			Writer writer = new OutputStreamWriter(fos, "UTF-8");// 文件按字节读取，然后按照UTF-8的格式编码显示
//			PDFTextStripper stripper = new PDFTextStripper();
//			// 排序
//			stripper.setSortByPosition(true);
//			// 设置转换的开始页
//			stripper.setStartPage(1);
//			// 设置转换的结束页
//			stripper.setEndPage(pagenumber);
//			stripper.writeText(doc, writer);
//			return newFileName;
//		} catch (Exception e) {
//			throw new LogicException("文件转换出错，请重试！", e);
//		}
//	}
//
//	public static String word2PDF(String wordFileName) {
//		return wordFileName;
//	}
//
//	public static String upload(HttpServletRequest req, String mimeType) {
//		// Create a factory for disk-based file items
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//
//		// Create a new file upload handler
//		ServletFileUpload upload = new ServletFileUpload(factory);
//
//		// Parse the request
//		try {
//			List<FileItem> items = upload.parseRequest(req);
//			Iterator<FileItem> it = items.iterator();
//			while (it.hasNext()) {
//				FileItem item = it.next();
//				String fileName = FilenameUtils.getName(item.getName());
//				String fileExtension = FilenameUtils.getExtension(item.getName());
//				String fileMimeType = req.getServletContext().getMimeType(fileName);
//				if (!mimeType.startsWith(fileMimeType)) {
//					throw new LogicException("请上传正确的文件格式!");
//				}
//				// 转换后的名字
//				fileName = FilenameUtils.getBaseName(fileName) + "." + fileExtension;
//				// 获取上传文件夹目录
//				String dir = req.getServletContext().getRealPath("/WEB-INF/upload/");
//				File file = new File(dir, fileName);
//				// 将文件写入指定文件
//				file.delete();
//				item.write(file);
//				return file.getAbsolutePath();
//			}
//		} catch (LogicException e) {
//			throw e;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public static void download(HttpServletRequest req, HttpServletResponse resp, String fileName) {
//		if (fileName == null || "".equals(fileName.trim())) {
//			throw new LogicException("请正确输入文件下载名");
//		}
//		// 设置响应格式
//		resp.setContentType("application/x-msdownload");
//		// 设置响应头
//		resp.setHeader("Content-disposition", "attachment; filename=" + FilenameUtils.getName(fileName));
//		try {
//			FileUtils.copyFile(new File(fileName), resp.getOutputStream());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
