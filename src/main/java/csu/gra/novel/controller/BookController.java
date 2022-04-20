package csu.gra.novel.controller;

import csu.gra.novel.domain.Book;
import csu.gra.novel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author howyoung
 * @date 2022/4/19
 * @email howyoung525@foxmail.com
 */
@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("index")
    public String getListBook(Model model) {
        List<Book> recommends = bookService.getRecommendBooks(6);
        int num = 12;
        List<Book> fantasies = bookService.getBooksByCategory("玄幻小说", num);
        List<Book> cultivations = bookService.getBooksByCategory("修真小说", num);
        List<Book> cities = bookService.getBooksByCategory("都市小说", num);
        List<Book> sciences = bookService.getBooksByCategory("科幻小说", num);
        List<Book> history = bookService.getBooksByCategory("历史小说", num);
        List<Book> games = bookService.getBooksByCategory("网游小说", num);
        Map<String, List<Book>> category = new HashMap<>(6);
        category.put("玄幻小说", fantasies);
        category.put("修真小说", cultivations);
        category.put("都市小说", cities);
        category.put("科幻小说", sciences);
        category.put("历史小说", history);
        category.put("网游小说", games);

//        model.addAttribute("fantasies", fantasies);
//        model.addAttribute("cultivations", cultivations);
//        model.addAttribute("cities", cities);
//        model.addAttribute("sciences", sciences);
//        model.addAttribute("history", history);
//        model.addAttribute("games", games);
        model.addAttribute("category", category);
        model.addAttribute("recommends", recommends);
        return "index";
    }
}
