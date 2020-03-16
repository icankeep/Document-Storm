package com.passer.domain;

import java.util.List;

import lombok.Data;

/**
* @Description: 爬取一次获取的所有评论,包含评论总数,和评论所属歌曲<p>
* @author: passer<p>
* @version：2019年5月20日 下午8:17:15<p>
*/
@Data
public class Comments {
	private List<Comment> hotComments;
	private int total;
	private Song song;

	public List<Comment> getHotComments() {
		return hotComments;
	}

	public void setHotComments(List<Comment> hotComments) {
		this.hotComments = hotComments;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}


}
