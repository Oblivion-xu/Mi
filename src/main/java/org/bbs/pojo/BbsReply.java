package org.bbs.pojo;

import java.io.Serializable;
import java.util.Date;

public class BbsReply implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer replyId;

	private BbsTopic topic;

	private BbsUser bbsUser;

	private Date replyTime;

	private String replyContent;

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public BbsTopic getTopic() {
		return topic;
	}

	public void setTopic(BbsTopic topic) {
		this.topic = topic;
	}

	public BbsUser getBbsUser() {
		return bbsUser;
	}

	public void setBbsUser(BbsUser bbsUser) {
		this.bbsUser = bbsUser;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}