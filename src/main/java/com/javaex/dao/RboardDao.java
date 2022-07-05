package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RboardVo;

@Repository
public class RboardDao {

	@Autowired
	private SqlSession sqlSession;

	public List<RboardVo> rBoardList() {
		System.out.println("dao List");

		return sqlSession.selectList("rboard.rboardList");

	}

	// 글쓰기
	public int rboardwrite(RboardVo rBoardVo) {
		System.out.println("rboardDao.Insert");
		int count = sqlSession.insert("rboard.rboardwrite", rBoardVo);

		return count;
	}

	// 게시물읽기
	public RboardVo rboardRead(int no) {
		System.out.println("rboardDao.read");
		RboardVo rBoardVo = sqlSession.selectOne("rboard.rboardRead", no);

		return rBoardVo;
	}

	// 조회수
	public int rboardHit(int no) {
		System.out.println("rboardDao.Hit");
		int count = sqlSession.update("rboard.rboardHit", no);

		return count;
	}

	// 삭제
	public int rboardDelete(int no) {
		System.out.println("rboardDao.delete");
		int count = sqlSession.delete("rboard.rboardDelete", no);

		return count;
	}

	public int rboardModify(RboardVo rBoardVo) {
		System.out.println("rboardDao.modify");
		int count = sqlSession.update("rboard.rboardModify", rBoardVo);

		return count;
	}

	public RboardVo rboardModifyFrom(int no) {
		System.out.println("rboardDao.modifyform");

		return sqlSession.selectOne("rboard.rboardModifyFrom", no);

	}

	public RboardVo rboardcommentFrom(int no) {
		System.out.println("rboardDao.commentform");

		return sqlSession.selectOne("rboard.rboardcommentFrom", no);

	}

	public int rboardcomment(RboardVo rBoardVo) {
		System.out.println("rboardDao.comment");
		int count = sqlSession.update("rboard. rboardcomment", rBoardVo);

		return count;
	}

	public int updateOrderNo(RboardVo rBoardVo) {
		System.out.println("rboardDao.updateord");

		return sqlSession.update("rboard.updateOrderNo", rBoardVo);

	}
}
