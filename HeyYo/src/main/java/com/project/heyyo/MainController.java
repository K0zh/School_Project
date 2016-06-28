package com.project.heyyo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

	@Autowired
	@Qualifier("myContentDao")
	private ContentDao contentDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "home.do")
	public String home2() {
		return "index";
	}

	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public ModelAndView viewMain(@RequestParam(value="type", required = false) String type) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
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
