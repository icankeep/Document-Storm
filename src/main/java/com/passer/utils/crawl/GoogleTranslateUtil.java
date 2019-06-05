package com.passer.utils.crawl;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

/**
 * @Author: passer
 * @Date: 19-6-4 下午10:41
 * @Version 1.0
 */
public class GoogleTranslateUtil {
    /**
     * 调用js文件获取tk
     * @param q     需要翻译的文本
     * @return
     * @throws ScriptException
     * @throws FileNotFoundException
     * @throws NoSuchMethodException
     */
    public static String excuteJs(String q) throws ScriptException,
            FileNotFoundException, NoSuchMethodException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("JavaScript"); // 得到脚本引擎
        //获取文件所在的相对路径
        //String text = System.getProperty("user.dir");
        //reader = text + "\\src\\main\\resources\\test.js";
        System.out.println();
        FileReader reader = new FileReader(Thread.currentThread().getContextClassLoader().getResource("Google.js").getFile());
        engine.eval(reader);

        Invocable inv = (Invocable) engine;
        //调用js中的方法
        String tk = (String)inv.invokeFunction("TL", q);
        try{
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return tk;
    }

}
