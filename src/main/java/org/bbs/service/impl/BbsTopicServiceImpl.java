package org.bbs.service.impl;

import java.util.List;
import java.util.Map;

import org.bbs.dao.BbsTopicMapper;
import org.bbs.pojo.BbsTopic;
import org.bbs.pojo.Pager;
import org.bbs.service.BbsTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsTopicServiceImpl implements BbsTopicService {
	
	@Autowired
	private BbsTopicMapper mapper;
	
	@Override
	public void addTopic(BbsTopic topic) {
		mapper.addTopic(topic);
	}

	@Override
	public void delTopic(Integer id) {
		mapper.delTopic(id);
	}

	@Override
	public BbsTopic findById(Integer id) {
		return mapper.findById(id);
	}

	@Override
	public List<BbsTopic> list(Map<String, Integer> conditionMap) {
		return mapper.list(conditionMap);
	}

	@Override
	public Integer getCount() {
		return mapper.getCount();
	}

}
