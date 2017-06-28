package com.safe.www.comm.respository;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value="basicService")
public class BasicServiceImpl implements BasicService {

	@Autowired
	private BasicDAO basicDAO;
	
	@Override
	public HashMap<String, Object> getMemberInfo(HashMap<String, Object> params) {
		return basicDAO.getHashOne("config.sql.mapper.basic-sql.memberInfo", params);
	}
	

}
