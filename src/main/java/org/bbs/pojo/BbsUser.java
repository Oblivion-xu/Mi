package org.bbs.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BbsUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String nickname;

	private String password;

	private Integer role;

	private List<BbsReply> replys = new ArrayList<BbsReply>();

	private List<BbsTopic> topics = new ArrayList<BbsTopic>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public List<BbsReply> getReplys() {
		return replys;
	}

	public void setReplys(List<BbsReply> replys) {
		this.replys = replys;
	}

	public List<BbsTopic> getTopics() {
		return topics;
	}

	public void setTopics(List<BbsTopic> topics) {
		this.topics = topics;
	}

}