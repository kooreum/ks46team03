package ks46team03.admin.controller;

import ks46team03.admin.mapper.BannedWordsMapper;
import ks46team03.admin.service.BannedWordsService;
import ks46team03.dto.BannedWords;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("adminBoardController")
@RequestMapping("/admin/board")
public class BoardController {

    private final BannedWordsService bannedWordsService;
    private final BannedWordsMapper bannedWordsMapper;

    public BoardController(BannedWordsService bannedWordsService, BannedWordsMapper bannedWordsMapper){
        this.bannedWordsService =bannedWordsService;
        this.bannedWordsMapper = bannedWordsMapper;
    }

    @GetMapping("/bannedWords")
    public String bannedWordsList(Model model){
        List<BannedWords> bannedWordsList = bannedWordsService.getBannedWordsList();
        model.addAttribute("title","금칙어 목록");
        model.addAttribute("bannedWordsList", bannedWordsList);

        return"/admin/board/admin_bannedWords";
    }


}
