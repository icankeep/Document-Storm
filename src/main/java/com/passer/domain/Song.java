package com.passer.domain;

import lombok.Data;

/**
* @Description: 歌曲类,封装歌曲的一些属性<p>
* @author: passer<p>
* @version：2019年5月20日 下午9:11:50<p>
*/
public class Song {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
