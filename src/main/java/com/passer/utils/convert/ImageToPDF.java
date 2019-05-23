package com.passer.utils.convert;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import lombok.Cleanup;

/**
* @Description: 图像转PDF转换类<p>
* @author: passer<p>
* @version：2019年5月19日 下午10:22:15<p>
*/
public class ImageToPDF {
	/**
	 * 实现图片到PDF文件的转换
	 * @param imagePath		图片的路径
	 * @param pdfPath		转换后PDF的路径，后缀必须为.pdf
	 * @throws IOException	IO异常
	 */
	public void generatePDF(String imagePath, String pdfPath) throws IOException {

		PDDocument doc = new PDDocument();
		PDPage page = new PDPage();
		doc.addPage(page);

		// createFromFile is the easiest way with an image file
		// if you already have the image in a BufferedImage,
		// call LosslessFactory.createFromImage() instead
		PDImageXObject pdImage = PDImageXObject.createFromFile(imagePath, doc);

		PDPageContentStream contents = new PDPageContentStream(doc, page);

		// draw the image at full size at (x=20, y=20)
		contents.drawImage(pdImage, 0, 0);
		contents.close();
		// to draw the image at half size at (x=20, y=20) use
		// contents.drawImage(pdImage, 20, 20, pdImage.getWidth() / 2,
		// pdImage.getHeight() / 2);
		doc.save(pdfPath);
		doc.close();
	}
}
