package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	@RequestMapping(value = "/gallery/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("galleryList");

		List<GalleryVo> galleryList = galleryService.galleryListt();

		model.addAttribute("galleryList", galleryList);

		return "/gallery/list";
	}
	@RequestMapping(value = "/gallery/upload", method = { RequestMethod.GET, RequestMethod.POST })
	public String upload(@RequestParam("file") MultipartFile file, Model model, GalleryVo galleryVo) {

		System.out.println("galleryupload");

		String saveName = galleryService.galleryUpload(file, galleryVo);

		model.addAttribute("saveName", saveName);

		return "redirect:/gallery/list";
	}


}
