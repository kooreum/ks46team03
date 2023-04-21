package ks46team03.user.controller;


import jakarta.servlet.http.HttpSession;
import ks46team03.dto.Report;
import ks46team03.user.mapper.UserMemberMapper;
import ks46team03.user.mapper.UserReportMapper;
import ks46team03.user.service.UserReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class ReportController {

	private final UserReportService userReportService;
	private final UserMemberMapper userMemberMapper;
	private final UserReportMapper userReportMapper;

	public ReportController(UserReportService userReportService, UserMemberMapper userMemberMapper, UserReportMapper userReportMapper){
		this.userReportService = userReportService;
		this.userMemberMapper = userMemberMapper;
		this.userReportMapper = userReportMapper;
	}

	@GetMapping("/reportList") //noticeList 복사함
	public String getReportList(Model model
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

		List<Report> reportList = userReportService.getReportList(paramMap);
		model.addAttribute("title", "신고사항");
		model.addAttribute("reportList", reportList);
		if(msg != null) model.addAttribute("msg", msg);

		return "user/board/user_reportList";
	}

}
