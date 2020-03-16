package com.passer.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import lombok.Data;

/**
* @Description: 网易云评论类,封装了包含评论的属性<p>
* @author: passer<p>
* @version：2019年5月20日 下午8:17:28<p>
*/
public class Comment {
	private String commentId;
	private Long time;
	private User user;
	private String content;
	private String likedCount;
	private Song song;
	
	public String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss  yyyy-MM-dd");
		return format.format(new Date(time));
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLikedCount() {
		return likedCount;
	}

	public void setLikedCount(String likedCount) {
		this.likedCount = likedCount;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
}
