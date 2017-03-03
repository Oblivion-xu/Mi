package org.bbs.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BbsTopic implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String topicTitle;

	private String topicContent;

	private Date topicTime;

	private BbsUser bbsUser;
	
	private List<BbsReply> replys = new ArrayList<BbsReply>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public Date getTopicTime() {
		return topicTime;
	}

	public void setTopicTime(Date topicTime) {
		this.topicTime = topicTime;
	}

	public BbsUser getBbsUser() {
		return bbsUser;
	}

	public void setBbsUser(BbsUser bbsUser) {
		this.bbsUser = bbsUser;
	}

	public List<BbsReply> getReplys() {
		return replys;
	}

	public void setReplys(List<BbsReply> replys) {
		this.replys = replys;
	}
	

}