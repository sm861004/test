package com.safe.www.comm.respository;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="basicDAO")
public class BasicDAOImpl implements BasicDAO {

	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<HashMap<String, Object>> getHashList(String sqlNm, Object obj) {
		return sqlSession.selectList(sqlNm, obj);
	}

	@Override
	public HashMap<String, Object> getHashOne(String sqlNm, Object obj) {
		return sqlSession.selectOne(sqlNm, obj);
	}

	@Override
	public Object pakageProcDml(String sqlNm, Object obj) {		
		return (Object)sqlSession.update(sqlNm, obj);
	}

	
}
