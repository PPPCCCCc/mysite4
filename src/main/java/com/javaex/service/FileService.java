package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.FileDao;
import com.javaex.vo.FileVo;

@Service
public class FileService {
	@Autowired
	private FileDao fileDao; 
	//파일저장 (파일하드디스크 저장, 파일정보(DB정보) 추출 저장)
	public String save(MultipartFile file) {
		System.out.println("file service");
		System.out.println(file.getOriginalFilename());
		
		String saveDir ="D:\\lecture\\javaStudy\\upload";
		
		//파일정보(DB정보) 추출 저장
		
		//오리지널파일명, 저장경로+파일명
		
		//오리지널파일명
		String orgName = file.getOriginalFilename();
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		//저장파일명
		String saveName= 	 System.currentTimeMillis()+UUID.randomUUID().toString()+exName;
		//파일저장경로
		String  filePath =  saveDir + "\\"+saveName;
		//파일사이즈
		long fileSize = file.getSize();
		
		//Vo묶기
		FileVo fileVo = new FileVo(orgName, saveName,filePath,fileSize );
		System.out.println(fileVo);
		//DB저장 과제
		fileDao.insertFile(fileVo);
		//파일저장
		try {
			byte[] fileData = file.getBytes();
			OutputStream os =  new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*String test = UUID.randomUUID().toString();
		long test2 = System.currentTimeMillis();
		
		System.out.println(test);
		System.out.println(test2);
		*/
		return saveName;
	}
}
