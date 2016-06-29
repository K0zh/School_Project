package com.project.heyyo.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.heyyo.content.matching.Matching;
import com.project.heyyo.content.matching.MatchingDao;
import com.project.heyyo.content.model.Content;
import com.project.heyyo.content.model.ContentDao;

@Controller
public class ContentController {

	@Autowired
	@Qualifier("myContentDao")
	private ContentDao contentDao;

	@Autowired
	@Qualifier("myMatchingDao")
	private MatchingDao matchingDao;

	@RequestMapping(value = "infowindow.con")
	public String viewInfoWindow() {
		return "InfoWindow";
	}

	@RequestMapping(value = "write.con", method = RequestMethod.GET)
	public String viewWriteForm() {
		return "ContentWriteForm";
	}

	@RequestMapping(value = "write.con", method = RequestMethod.POST)
	public String doActionWrite(
			@ModelAttribute("Content") @Valid Content content,
			BindingResult bindingResult) {

		// 얻어온 좌표 가공
		String location = content.getLocation();
		location = location.replace("(", "").replace(")", "");

		// 가공한 좌표 재설정
		content.setLocation(location);

		contentDao.insertTalentData(content);

		return "redirect:main.do";
	}

	@RequestMapping(value = "detail.con")
	public ModelAndView viewDetail(@RequestParam(value = "num") int num,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Content content = contentDao.getContentByNum(num);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("num", num);
		List<Matching> lists = matchingDao.selectMatchingByNum(map);

		mav.addObject("content", content);
		System.out.println("LISTS" + lists);
		mav.addObject("matchingList", lists);

		mav.setViewName("ContentDetailView");

		return mav;
	}

	@RequestMapping(value = "matching.con")
	public String doActionMatching(
			@ModelAttribute("Matching") @Valid Matching matching,
			BindingResult bindingResult) {

		int num = matching.getM_num();
		matchingDao.insertRequestMatching(matching);

		return "redirect:detail.con?num=" + num;

	}

	@RequestMapping(value = "agree.con")
	public String doActionAgree() {
		return "matching/test";
	}

	@RequestMapping(value = "deny.con")
	public String doActionDeny(@RequestParam(value = "id") int id,
			@RequestParam(value = "num") int num) {
		matchingDao.deleteRequest(id);
		return "redirect:detail.con?num=" + num;
	}
	
	@RequestMapping(value = "agree.con")
	public String doActionAgree(@RequestParam(value = "id") int id,
			@RequestParam(value = "num") int num) {
		return "redirect:detail.con?num=" + num;
	}
}
