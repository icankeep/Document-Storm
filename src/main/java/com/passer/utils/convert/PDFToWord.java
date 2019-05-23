package com.passer.utils.convert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.passer.exception.LogicException;

import lombok.Cleanup;

/**
* @Description: PDF转Word<p>
* @author: passer<p>
* @version：2019年5月19日 下午9:46:12<p>
*/
public class PDFToWord {
	/**
	 * 
	* <p>Description: PDF -- > DOC 文件转换 </p>
	* @param pdfFileName	文件绝对路径名 </p>
	* @return				返回修改之后文件的绝对路径 </p>	
	 */
	public void generateWord(String pdfFileName, String docFileName) {
		try {
			@Cleanup
			PDDocument doc = PDDocument.load(new File(pdfFileName));
			// 获取总页数
			int pagenumber = doc.getNumberOfPages();
			@Cleanup
			FileOutputStream fos = new FileOutputStream(docFileName);
			@Cleanup
			Writer writer = new OutputStreamWriter(fos, "UTF-8");// 文件按字节读取，然后按照UTF-8的格式编码显示
			PDFTextStripper stripper = new PDFTextStripper();
			// 排序
			stripper.setSortByPosition(true);
			// 设置转换的开始页
			stripper.setStartPage(1);
			// 设置转换的结束页
			stripper.setEndPage(pagenumber);
			stripper.writeText(doc, writer);
		} catch (Exception e) {
			throw new LogicException("文件转换出错，请重试！", e);
		}
	}
}
