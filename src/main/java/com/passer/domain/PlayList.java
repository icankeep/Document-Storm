package com.passer.domain;

import java.util.List;

import lombok.Data;

/**
* @Description: 歌单列表<p>
* @author: passer<p>
* @version：2019年5月20日 下午9:09:57<p>
*/
public class PlayList {
	private List<Song>  tracks;

	public List<Song> getTracks() {
		return tracks;
	}

	public void setTracks(List<Song> tracks) {
		this.tracks = tracks;
	}
}
