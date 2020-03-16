package com.passer.domain;

import lombok.Data;

/**
* @Description: 爬取一次获取的歌单<p>
* @author: passer<p>
* @version：2019年5月20日 下午9:12:42<p>
*/
public class PlayLists {
	private PlayList playlist;

	public PlayList getPlaylist() {
		return playlist;
	}

	public void setPlaylist(PlayList playlist) {
		this.playlist = playlist;
	}
}
