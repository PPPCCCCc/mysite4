package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private GalleryDao galleryDao;

	// 리스트
	public List<GalleryVo> galleryListt() {
		System.out.println("gallery serviceList");

		List<GalleryVo> galleryList = galleryDao.galleryList();

		return galleryList;
	}

	// 업로드
	public String galleryUpload(MultipartFile file, GalleryVo galleryVo) {
		System.out.println("gallery serviceupload");

		String saveDir = "C:\\javaStudy\\upload";
		// 오리지널파일명
		String orgName = file.getOriginalFilename();
		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		// 저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		// 파일저장경로
		String filePath = saveDir + "\\" + saveName;
		// 파일사이즈
		long fileSize = file.getSize();

		galleryVo.setFilePath(filePath);
		galleryVo.setOrgName(orgName);
		galleryVo.setSaveName(saveName);
		galleryVo.setFileSize(fileSize);

		galleryDao.galleryUpload(galleryVo);

		// 파일저장
		try {
			byte[] fileData = file.getBytes();
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveName;
	}

}
