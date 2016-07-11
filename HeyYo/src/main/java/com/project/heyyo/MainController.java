package com.project.heyyo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import utility.Paging;

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
		return "initPage";
	}

	@RequestMapping(value = "main.do")
	public String home2() {
		return "Main";
	}

	// ���� ȭ�� �̵�
	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public ModelAndView viewMain(@RequestParam(value = "type", required = false) String type, @RequestParam(value = "talent", required = false) String talent, @RequestParam(value = "location", required = false) String location,
			@RequestParam(value="lat", required= false) String lat,
			@RequestParam(value="lng", required= false) String lng,
			HttpSession session) {
		LOGGER.info("MAIN들어옴");
		ModelAndView mav = new ModelAndView();

		Map<String, String> map = new HashMap<String, String>();
		System.out.println(location);
		map.put("type", type);
		map.put("talent", talent);
		map.put("location", location);

		List<Content> contentLists = contentDao.getAllContent(map);

		mav.addObject("contentLists", contentLists);
		mav.addObject("lat", lat);
		mav.addObject("lng", lng);
		mav.setViewName("Main");

		return mav;
	}

	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public ModelAndView viewList(@RequestParam(value = "type", required = false) String type, @RequestParam(value = "talent", required = false) String talent, @RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("talent", talent);

		System.out.println("type : " + type);
		System.out.println("talent : " + talent);

		mav.setViewName("List");

		String url = request.getContextPath() + "/list.do";
		int totalCount = contentDao.GetTotalCount(map);
		System.out.println("totalcount : " + totalCount);

		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, type, talent, null);

		List<Content> contentLists = contentDao.getAllContentList(pageInfo, map);

		mav.addObject("contentLists", contentLists);
		mav.addObject("pageInfo", pageInfo);
		return mav;
	}

	@RequestMapping(value = "location.do", method = RequestMethod.GET)
	public ModelAndView viewLocation(@RequestParam(value = "type", required = false) String type, @RequestParam(value = "talent", required = false) String talent, @RequestParam(value = "location", required = false) String location,
			@RequestParam(value="lat", required= false) String lat,
			@RequestParam(value="lng", required= false) String lng,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("talent", talent);
		map.put("location", location);

		List<Content> contentLists = contentDao.getAllContent(map);

		mav.addObject("contentLists", contentLists);
		mav.addObject("lat", lat);
		mav.addObject("lng", lng);
		mav.setViewName("Main");

		return mav;

	}
}
