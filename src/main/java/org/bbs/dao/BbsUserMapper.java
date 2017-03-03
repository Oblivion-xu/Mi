package org.bbs.dao;

import java.util.List;

import org.bbs.pojo.BbsUser;


public interface BbsUserMapper {
    
	BbsUser login(BbsUser user);
	
	void reg(BbsUser user);
	
	BbsUser findById(Integer id);
	
	BbsUser findByNickName(String name);
	
	List<String> list();
}