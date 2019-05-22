package com.passer.file;

import lombok.Data;

@Data
public class CFile {
	//文件名称
	private String fileName;
	//文件对应表单控件名称
	private String fieldName;
	//文件绝对路径名称
	private String absoluteFileName;
}
