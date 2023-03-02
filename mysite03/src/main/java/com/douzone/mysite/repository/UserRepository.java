package com.douzone.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.UserVo;

@Repository
public class UserRepository {
	
	@Autowired
    private SqlSession sqlSession;

	public void insert(UserVo vo) {
		sqlSession.insert("user.insert", vo);
		
	}

	public UserVo findByEmailAndPassword(UserVo vo) {
		return sqlSession.selectOne("user.findByEmailAndPassword", vo);
		
	}
	
	
	// map 사용 예제
//	public UserVo findByEmailAndPassword(String email, String password) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("e", email);
//		map.put("p",password);
//		return sqlSession.selectOne("user.findByEmailAndPassword", map);
//		
//	}

	public UserVo FindByNo(Long no) {
		return sqlSession.selectOne("user.FindByNo", no);
	}

	public void update(UserVo vo) {
		sqlSession.update("user.update", vo);
	}

	public UserVo findByEmail(String email) {
		return sqlSession.selectOne("user.findByEmail", email);
	}

}
