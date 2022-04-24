package csu.gra.novel.controller;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.User;
import csu.gra.novel.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author howyoung
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam(value = "path", required = false, defaultValue = "/index") String path,
                        @Param("username") String username,
                        @Param("password") String password, HttpServletRequest request, Model model){
        if (username != null && !("").equals(username) && password != null && !("").equals(password)){
            password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
            User user = userService.findUserByUsernameAndPassword(username, password);
            if (user != null){
                model.addAttribute("msg", "登陆成功");
                request.getSession().setAttribute("user", user);
                return "redirect:" + path;
            }
        }
        model.addAttribute("msg", "请检查用户名和密码是否正确");
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "path", required = false, defaultValue = "/index") String path, Model model){
        model.addAttribute("path", path);
        return "/user/login";
    }

    @GetMapping("/register")
    public String register(){
        return "/user/register";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/index";
    }


    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> user, HttpServletRequest request){
        System.out.println(user.get("username"));
        System.out.println(user.get("password"));
        System.out.println(user.get("repassword"));
        System.out.println(user.get("email"));
//        newUser.setUsername(newUser.getUsername().replace(" ", ""));
//        newUser.setPassword(newUser.getPassword().replace(" ", ""));
//        if (!("").equals(newUser.getUsername()) && !("".equals(newUser.getPassword())) &&
//                newUser.getUsername() != null && newUser.getPassword() != null){
//            User user = userService.register(newUser);
//            request.setAttribute("user", user);
//        }
        return "redirect:/index";
    }

    @RequestMapping("/{bookId}")
    public String addFavorite(@RequestParam(value = "type", required = false, defaultValue = "/top/index")String type,
                              @PathVariable int bookId, HttpServletRequest request, Model model){
        User user = (User)request.getSession().getAttribute("user");
        userService.insertFavorite(user.getUserId(), bookId);
        return "redirect:" + type;
    }

    @RequestMapping("/favorite/index")
    public String bookshelf(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            List<Book> books = userService.getFavoriteBooks(user.getUserId());
            model.addAttribute("books", books);
            return "/favorite/index";
        }
        return "/user/login";
    }

    @RequestMapping("/del/{bookId}")
    public String delFav(HttpServletRequest request, @PathVariable int bookId){
        User user = (User) request.getSession().getAttribute("user");
        if (user != null){
            userService.delFavorite(user.getUserId(), bookId);
            return "redirect:/user/favorite/index";
        }
        return "/user/login";
    }
}
