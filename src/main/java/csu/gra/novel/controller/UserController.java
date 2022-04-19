package csu.gra.novel.controller;

import csu.gra.novel.domain.User;
import csu.gra.novel.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author howyoung
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index(){
        return "index";
    }

//    @PostMapping("login")
//    public String login(User user){
//        User loginUser = userService.login(user);
//        if (loginUser == null){
//            return "index";
//        } else {
//            return "main";
//        }
//    }
}
