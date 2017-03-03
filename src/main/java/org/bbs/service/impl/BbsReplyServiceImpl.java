package org.bbs.service.impl;

import java.util.List;
import java.util.Map;

import org.bbs.dao.BbsReplyMapper;
import org.bbs.pojo.BbsReply;
import org.bbs.service.BbsReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsReplyServiceImpl implements BbsReplyService {
	
	@Autowired
	private BbsReplyMapper mapper;

	@Override
	public void addReply(BbsReply reply) {
		mapper.addReply(reply);
	}

	@Override
	public void delReply(Integer id) {
		mapper.delReply(id);
	}

	@Override
	public Integer getCount(Integer tid) {
		return mapper.getCount(tid);
	}

	@Override
	public List<BbsReply> list(Map<String, Object> condition) {
		return mapper.list(condition);
	}

}
