package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Board;
import ks46team03.user.mapper.UserBoardMapper;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.service.UserBoardService;
import org.slf4j.ILoggerFactory;
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
public class BoardController {

	private final UserBoardService userBoardService;
	private final UserMemberMapper userMemberMapper;
	private final UserBoardMapper userBoardMapper;

	public BoardController(UserBoardService userBoardService, UserMemberMapper userMemberMapper, UserBoardMapper userBoardMapper){
		this.userBoardService = userBoardService;
		this.userMemberMapper = userMemberMapper;
		this.userBoardMapper = userBoardMapper;
	}

	@GetMapping("/noticeList") //GoodsList에서 가져옴
	public String getNoticeList(Model model
			, HttpSession session
			, @RequestParam(name="msg", required = false) String msg) {
		String memberLevel = (String) session.getAttribute("SLEVEL");

		Map<String, Object> paramMap = null;
		if(memberLevel != null && "2".equals(memberLevel)) {
			String sellerId = (String)session.getAttribute("SID");

			paramMap = new HashMap<String, Object>();
			paramMap.put("searchKey", "g_seller_id");
			paramMap.put("searchValue", sellerId);
		}

		List<Board> boardList = userBoardService.getBoardList(paramMap);
		model.addAttribute("title", "공지사항");
		model.addAttribute("boardList", boardList);
		if(msg != null) model.addAttribute("msg", msg);

		return "user/board/user_noticeList";
	}

	@GetMapping("/addNotice")
	public String addNotice(Model model){
		model.addAttribute("title", "공지사항");
		return "user/board/user_addNotice";
	}

	@PostMapping ("/addNotice")
	public String addNotice(Board board){
		userBoardService.addNotice(board);
		return "redirect:/user/noticeList";
	}


}
