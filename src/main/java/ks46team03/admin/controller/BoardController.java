package ks46team03.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminBoardController")
@RequestMapping("/admin/board")
public class BoardController {

    @GetMapping("/bannedWords")
    public String bannedWordsList(){
        return"/admin/board/admin_bannedWords";
    }
}
