package ks46team03.admin.controller;

import lombok.extern.slf4j.Slf4j;
import ks46team03.admin.mapper.BannedWordsMapper;
import ks46team03.admin.service.BannedWordsService;
import ks46team03.dto.BannedWords;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("adminBoardController")
@RequestMapping("/admin")
@Slf4j
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

        return"admin/board/admin_bannedWords";
    }

    @GetMapping("/removeBannedWords")
    public String removeBannedWords(@RequestParam("bannedWordsCode") String bannedWordsCode){
        bannedWordsService.removeBannedWords(bannedWordsCode);
        return "redirect:/admin/bannedWords";
    }
    @PostMapping("/addBannedWords")
    public String addBannedWords(BannedWords bannedWords){

       log.info("bannedWords addBannedWords BoardController={}", bannedWords);

        bannedWordsService.addBannedWords(bannedWords);
        return "redirect:/admin/bannedWords";
        /*return"/admin/board/admin_bannedWords";*/
    }

    @PostMapping("/removeCheckedBannedWords")
    @ResponseBody
    public List<String> removeCheckedBannedWords(@RequestParam(value="valueArr[]") List<String> valueArr) {

        bannedWordsService.removeCheckedBannedWords(valueArr);

        return valueArr;
    }


}
