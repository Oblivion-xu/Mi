package org.bbs.service;

import java.util.List;
import java.util.Map;

import org.bbs.pojo.BbsReply;

public interface BbsReplyService {
	
	void addReply(BbsReply reply);

	void delReply(Integer id);

	Integer getCount(Integer tid);

	List<BbsReply> list(Map<String, Object> condition);
}
