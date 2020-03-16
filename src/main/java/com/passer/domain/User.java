package com.passer.domain;

import lombok.Data;

/**
* @Description: 网易云用户类,封装了用户的一些属性<p>
* @author: passer<p>
* @version：2019年5月20日 下午8:21:22<p>
*/
public class User {
	private String userId;
	private String nickname;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}

