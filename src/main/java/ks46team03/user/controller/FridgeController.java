package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.admin.mapper.IngredientMapper;
import ks46team03.dto.Fridge;
import ks46team03.dto.Ingredient;
import ks46team03.dto.Location;
import ks46team03.user.mapper.UserFridgeMapper;
import ks46team03.user.service.UserFridgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user/fridge")
public class FridgeController {
	private final UserFridgeService userFridgeService;
	private final UserFridgeMapper userFridgeMapper;
	private final IngredientMapper ingredientMapper;

	public FridgeController(UserFridgeService userFridgeService, UserFridgeMapper userFridgeMapper, IngredientMapper ingredientMapper){
		this.userFridgeService = userFridgeService;
		this.userFridgeMapper = userFridgeMapper;
		this.ingredientMapper = ingredientMapper;
	}


	@GetMapping("/userFridge")
	public String userRecipePage(Model model
								, HttpSession session) {
		String memberId = (String) session.getAttribute("SID");
		String levelNum = (String) session.getAttribute("SLEVEL");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", "i.member_id");
		paramMap.put("searchValue", memberId);

		List<Fridge> fridgeList = userFridgeService.getFridgeList(paramMap);

		model.addAttribute("title", "나의재료");
		model.addAttribute("fridgeList", fridgeList);

		return "user/fridge/user_fridge";
	}

	@GetMapping("/addFridge")
	public String addFridge(Model model
							, HttpSession session){

		String memberId = (String) session.getAttribute("SID");
		String levelNum = (String) session.getAttribute("SLEVEL");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchKey", "i.member_id");
		paramMap.put("searchValue", memberId);

		List<Fridge> fridgeList = userFridgeService.getFridgeList(paramMap);
		List<Location> locationList = userFridgeMapper.getLocationList();
		List<Ingredient> ingredientList = userFridgeMapper.getIngredientList();

		model.addAttribute("title", "재료등록");
		model.addAttribute("fridgeList", fridgeList);
		model.addAttribute("locationList", locationList);
		model.addAttribute("ingredientList", ingredientList);

		return "user/fridge/user_addFridge";
	}

	@PostMapping("/addFridge")
	public String addFridge(Fridge fridge) {
		userFridgeService.addFridge(fridge);
		return "redirect:/user/addFridge";
	}
}
