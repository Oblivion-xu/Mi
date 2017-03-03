package org.bbs.service.impl;

import java.util.List;

import org.bbs.dao.BbsUserMapper;
import org.bbs.pojo.BbsUser;
import org.bbs.service.BbsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsUserServiceImpl implements BbsUserService {
	
	@Autowired
	private BbsUserMapper mapper;

	@Override
	public BbsUser login(BbsUser user) {
		return mapper.login(user);
	}

	@Override
	public BbsUser reg(BbsUser user) {
		mapper.reg(user);
		return mapper.findByNickName(user.getNickname());
	}

	@Override
	public BbsUser findById(Integer id) {
		return mapper.findById(id);
	}

	@Override
	public List<String> list() {
		return mapper.list();
	}

}
