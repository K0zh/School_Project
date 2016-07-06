package com.project.heyyo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.heyyo.content.model.Content;
import com.project.heyyo.content.model.ContentDao;

@Controller
public class MainController {
	
	public static final Logger LOGGER = Logger.getLogger(MainController.class);
	
	@Autowired
	@Qualifier("myContentDao")
	private ContentDao contentDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "home.do")
	public String home2() {
		return "Main";
	}

	
	//메인 화면 이동
	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public ModelAndView viewMain(
			@RequestParam(value="type", required = false) String type,
			@RequestParam(value="talent", required = false) String talent,
			@RequestParam(value="init_lat", required = false) String init_lat,
			@RequestParam(value="init_lng", required = false) String init_lng,
			HttpSession session
			) {
		LOGGER.info("메인 실행");
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("talent", talent);
		
//		float lat = Float.parseFloat(init_lat);
//		float lng = Float.parseFloat(init_lng);
		
//		map.put("init_lat", lat);
//		map.put("init_lng", lng);
		
		List<Content> contentLists = contentDao.getAllContent(map);

		System.out.println(contentLists);
		mav.addObject("contentLists", contentLists);
		mav.setViewName("Main");

		return mav;
	}

	@RequestMapping(value = "test.do")
	public String Test() {
		return "test";
	}
}
