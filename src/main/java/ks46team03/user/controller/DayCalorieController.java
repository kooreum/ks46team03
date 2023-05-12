package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Calorie;
import ks46team03.dto.DayCalorie;
import ks46team03.user.mapper.UserCalorieMapper;
import ks46team03.user.mapper.UserDayCalorieMapper;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.service.UserCalorieService;
import ks46team03.user.service.UserDayCalorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class DayCalorieController {

	private final UserDayCalorieService userDayCalorieService;
	private final UserDayCalorieMapper userDayCalorieMapper;
	private final UserMemberMapper userMemberMapper;

	public DayCalorieController(UserDayCalorieService userDayCalorieService, UserDayCalorieMapper userDayCalorieMapper, UserMemberMapper userMemberMapper){
		this.userDayCalorieService = userDayCalorieService;
		this.userDayCalorieMapper = userDayCalorieMapper;
		this.userMemberMapper = userMemberMapper;
	}
	/*@GetMapping("/calorieList")
	public String userDayCalorieList(Model model, HttpSession session){
		String memberId = (String) session.getAttribute("SID");
		*//*String levelNum = (String) session.getAttribute("SLEVEL");*//*

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", "od.member_id");
		paramMap.put("searchValue", memberId);

		List<DayCalorie> dayCalorieList = userDayCalorieService.getCaloriList(paramMap);

		model.addAttribute("dayCalorieList",dayCalorieList);

		return "user/calorie/user_calorieList";

	}*/
}
