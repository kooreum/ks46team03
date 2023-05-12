package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Calorie;
import ks46team03.dto.DayCalorie;
import ks46team03.user.mapper.UserCalorieMapper;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.service.UserCalorieService;
import ks46team03.user.service.UserDayCalorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class CalorieController {

	private final UserCalorieService userCalorieService;
	private final UserCalorieMapper userCalorieMapper;
	private final UserMemberMapper userMemberMapper;

	private final UserDayCalorieService userDayCalorieService;

	public CalorieController(UserCalorieService userCalorieService, UserCalorieMapper userCalorieMapper, UserMemberMapper userMemberMapper,UserDayCalorieService userDayCalorieService ){
		this.userCalorieMapper = userCalorieMapper;
		this.userCalorieService = userCalorieService;
		this.userMemberMapper = userMemberMapper;
		this.userDayCalorieService = userDayCalorieService;
	}

	@GetMapping("/calorieList")
	public String userCalorieList(Model model, HttpSession session) {
		String memberId = (String) session.getAttribute("SID");

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("searchKey", "om.member_id");
		paramMap.put("searchKey1", "od.member_id");
		paramMap.put("searchValue", memberId);

		List<DayCalorie> dayCalorieList = userDayCalorieService.getCaloriList(paramMap);
		List<Calorie> calorieList = userCalorieService.getCalorieList(paramMap);
		System.out.println("calorieList = " + calorieList);

		model.addAttribute("title", "나의 제한 칼로리");
		model.addAttribute("dayCalorieList", dayCalorieList);
		model.addAttribute("calorieList", calorieList);

		return "user/calorie/user_calorieList";
	}
	@GetMapping("/deleteCalorie")
	public String deleteUserCalorie(@RequestParam("oneMealCalCode") String oneMealCalCode) {
		userCalorieService.deleteUserCalorie(oneMealCalCode);
		return "redirect:/user/calorieList";
	}


    /*@GetMapping("/calorieList")
	public String userCalorieList(Model model, HttpSession session){
		String memberId = (String) session.getAttribute("SID");
		String levelNum = (String) session.getAttribute("SLEVEL");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", "om.member_id");
		paramMap.put("searchValue", memberId);

		List<Calorie> calorieList = userCalorieService.getCalorieList(paramMap);

		System.out.println(calorieList + "<-calorieList calorieList ");

		model.addAttribute("title", "나의 제한 칼로리");
		model.addAttribute("calorieList", calorieList);

		return "user/calorie/user_calorieList";
	}*/
}
