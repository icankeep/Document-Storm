package com.passer.utils.convert;

/**
* @Description: HTML转PDF<p>
* @author: passer<p>
* @version：2019年5月18日 上午11:51:00<p>
*/
import java.io.File;

public class HTMLToPDF {

	/**
	 * HTML转PDF
	 * @param srcPath HTML路径，可以是硬盘上的路径，也可以是网络路径
	 * @param destPath PDF保存路径
	 */
	public  void generatePDF(String srcPath, String destPath) {
		File file = new File(destPath);
		// 拼凑命令，调用底层wkhtmltopdf
		StringBuilder cmd = new StringBuilder();
		cmd.append("wkhtmltopdf ");
		cmd.append(srcPath);
		cmd.append(" ");
		cmd.append(destPath);
		try {
			// 调用子进程处理命令
			Process proc = Runtime.getRuntime().exec(cmd.toString());
			proc.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
////	        HtmlToPdf.convert("http://www.baidu.com", "F:/pdf/baidu.pdf");
//		HTMLToPDF.convert("/opt/eclipse/workspace/docstorm/src/test/resources/music-api-doc.html", "/opt/eclipse/workspace/docstorm/src/test/resources/music-api-doc.html.pdf");
////	        HtmlToPdf.convert("http://api.gyingyuan.com/", "F:/pdf/"+ UUID.randomUUID().toString()+".pdf");
////	        HtmlToPdf.convert("https://www.aliyun.com/jiaocheng/285649.html", "F:/pdf/baidu.pdf");
//	}
}
