package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.admin.mapper.IngredientMapper;
import ks46team03.dto.Allergy;
import ks46team03.dto.Fridge;
import ks46team03.dto.Ingredient;
import ks46team03.dto.Location;
import ks46team03.user.mapper.UserAllergyMapper;
import ks46team03.user.mapper.UserFridgeMapper;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.service.UserAllergyService;
import ks46team03.user.service.UserFridgeService;
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
public class AllergyController {
	private final UserAllergyService userAllergyService;
	private final UserAllergyMapper userAllergyMapper;
	private final UserMemberMapper userMemberMapper;
	private final UserFridgeMapper userFridgeMapper;

	public AllergyController(UserAllergyService userAllergyService, UserAllergyMapper userAllergyMapper
							,UserMemberMapper userMemberMapper ,UserFridgeMapper userFridgeMapper){
		this.userAllergyService = userAllergyService;
		this.userAllergyMapper = userAllergyMapper;
		this.userMemberMapper = userMemberMapper;
		this.userFridgeMapper = userFridgeMapper;
	}


	@GetMapping("/allergyList")
	public String userAllergyList(Model model
								, HttpSession session) {
		String memberId = (String) session.getAttribute("SID");
		String levelNum = (String) session.getAttribute("SLEVEL");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", "a.member_id");
		paramMap.put("searchValue", memberId);

		List<Allergy> allergyList = userAllergyService.getAllergyList(paramMap);

		model.addAttribute("title", "나의 알러지 재료");
		model.addAttribute("allergyList", allergyList);

		return "user/allergy/user_allergyList";
	}


	@GetMapping("/addAllergy")
	public String addAllergy(Model model
							, HttpSession session){
		//
		String memberId = (String) session.getAttribute("SID");
		String levelNum = (String) session.getAttribute("SLEVEL");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", "a.member_id");
		paramMap.put("searchValue", memberId);


		//myAllergyCode 변수에 ingredient_1 값을 받아 map에 put을 하지 못하기 때문입니다.


		List<Allergy> allergyList = userAllergyService.getAllergyList(paramMap);
		List<Ingredient> ingredientList = userFridgeMapper.getIngredientList();
		System.out.println(allergyList + "<- allergyList addAllergy");
		System.out.println(ingredientList + "<- ingredientList addAllergy");

		model.addAttribute("title", "재료등록");
		model.addAttribute("allergyList", allergyList);
		model.addAttribute("ingredientList", ingredientList);

		return "user/allergy/user_addAllergy";
	}


	@PostMapping("/addAllergy")
	public String addAllergy(Allergy allergy) {
		System.out.println(allergy + "<- allergy addAllergy");


		userAllergyService.addAllergy(allergy);
		return "redirect:/user/allergyList";
	}

	@GetMapping("/removeAllergy")
	public String removeAllergy(@RequestParam("allergyCode") String allergyCode){
		userAllergyService.removeAllergyByCode(allergyCode);
		return "redirect:/user/allergyList";
	}
}
