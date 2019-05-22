package com.passer.utils.convert;

import java.io.File;
import java.io.UnsupportedEncodingException;

import org.parboiled.common.FileUtils;

import com.qkyrie.markdown2pdf.Markdown2PdfConverter;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import com.qkyrie.markdown2pdf.internal.exceptions.Markdown2PdfLogicException;
import com.qkyrie.markdown2pdf.internal.writing.SimpleFileMarkdown2PdfWriter;

/**
* @Description Markdown文件转成PDF<p>
* link:https://github.com/Qkyrie/Markdown2Pdf<p>
* @author passer<p>
* @version 2019年5月18日 下午3:49:44<p>
*/
public class MarkdownToPDF {

	/**
	 * Our API has been implemented in such a way, that you can use it as a oneliner.
	 * The above example can be rewritten, as shown in the this example
	 */
	public void generatePDF(String mdFileName, String pdfFileName) throws Markdown2PdfLogicException, ConversionException {
		// 读取markdown文件
		File mdFile = new File(mdFileName);
		byte[] buf = FileUtils.readAllBytes(mdFile);	
		
		File pdfFile = new File(pdfFileName);
		
		// 转换格式到指定路径
		Markdown2PdfConverter.newConverter().readFrom(() -> {
			try {
				return new String(buf, "utf8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return pdfFileName;
		}).writeTo(new SimpleFileMarkdown2PdfWriter(pdfFile)).doIt();
	}
}
