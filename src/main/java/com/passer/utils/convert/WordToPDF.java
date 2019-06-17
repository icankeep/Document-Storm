package com.passer.utils.convert;


import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @Author: passer
 * @Date: 19-6-15 下午8:18
 * @Version 1.0
 */
public class WordToPDF {
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void doc2pdf(String srcPath, String destPath) {
        if (!getLicense()) {          // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            File file = new File(destPath);  //新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(srcPath);                    //Address是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
