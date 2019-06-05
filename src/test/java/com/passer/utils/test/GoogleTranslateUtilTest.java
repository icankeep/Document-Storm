package com.passer.utils.test;

import com.passer.utils.crawl.GoogleTranslateUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: passer
 * @Date: 19-6-5 下午2:57
 * @Version 1.0
 */
public class GoogleTranslateUtilTest {

    @Test
    public void testGenerateTk() throws Exception{
        String q = "happy new year!";
        String tk = GoogleTranslateUtil.excuteJs(q);
        Assert.assertNotNull(tk);
        Assert.assertEquals(tk, "968488.586588");
    }
}
