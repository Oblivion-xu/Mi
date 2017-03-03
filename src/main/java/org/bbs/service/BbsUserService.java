package org.bbs.service;

import java.util.List;

import org.bbs.pojo.BbsUser;

public interface BbsUserService {

	BbsUser login(BbsUser user);

	BbsUser reg(BbsUser user);

	BbsUser findById(Integer id);

	List<String> list();
}
