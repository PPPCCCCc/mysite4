package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;

	// 리스느
	public List<GalleryVo> galleryList() {
		System.out.println("gallery dao List");

		List<GalleryVo> galleryList = sqlSession.selectList("gallery.galleryList");

		System.out.println(galleryList);

		return galleryList;
	}

	// 업로드
	public int galleryUpload(GalleryVo galleryVo) {
		System.out.println("gallery dao upload");
		int count = sqlSession.insert("gallery.insert", galleryVo);

		return count;
	}

	// 리스트 이미지 1개
	public GalleryVo gallerySelect(int no) {
		System.out.println("gallery dao select");

		GalleryVo galleryVo = sqlSession.selectOne("gallery.gallerySelect", no);

		return galleryVo;
	}
	//삭제
	public int imgDelete(int no) {
		System.out.println("gallery dao delete");
		
		int count = sqlSession.delete("gallery.galleryDelete", no);
		
		return count;
	}
}
