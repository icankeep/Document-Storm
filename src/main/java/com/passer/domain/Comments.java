package com.passer.domain;

import java.util.List;

import lombok.Data;

/**
* @Description: <p>
* @author: passer<p>
* @version：2019年5月20日 下午8:17:15<p>
*/
@Data
public class Comments {
	private List<Comment> hotComments;
	private int total;
	private Song song;
}
