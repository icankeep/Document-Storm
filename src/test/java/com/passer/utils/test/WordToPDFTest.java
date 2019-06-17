package com.passer.utils.test;

import com.passer.utils.convert.WordToPDF;
import org.junit.Test;

/**
 * @Author: passer
 * @Date: 19-6-15 下午8:48
 * @Version 1.0
 */
public class WordToPDFTest {
    @Test
    public void testWordToPDF() {
        WordToPDF convert = new WordToPDF();
        convert.doc2pdf("/opt/eclipse/workspace/docstorm/src/test/resources/translate.doc", "/opt/eclipse/workspace/docstorm/src/test/resources/test-aspose.pdf");
    }
}
