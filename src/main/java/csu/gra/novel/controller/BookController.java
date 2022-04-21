package csu.gra.novel.controller;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.Chapter;
import csu.gra.novel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        model.addAttribute("category", category);
        model.addAttribute("recommends", recommends);
        return "index";
    }

    @GetMapping("book/index")
    public String getBooksByCategory(@RequestParam(value = "type", required = false) String type,
                                     @RequestParam(value = "state", required = false, defaultValue = "0") int state,
                                     @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                     Model model){
        System.out.println(state +"\t" + page);
        List<Book> books = bookService.getBooksByPage(type, state, page);
        for (Book book : books) {
            book.setStatus(book.getStatusCode());
        }
        model.addAttribute("books", books);
        model.addAttribute("type", type);
        model.addAttribute("page", page);
        model.addAttribute("state", state);
        return "book/index";
    }

    @GetMapping("book/{id}")
    public String getBookDetails(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book/book";
    }

    @GetMapping("/book/{bookId}/{chapterId}")
    public String getChapter(@PathVariable int bookId, @PathVariable int chapterId, Model model){
        Book book = bookService.getBookById(bookId);
        if (book != null){
            List<Chapter> list = book.getChapters();
            int index = book.getBookByChapterId(chapterId);
            Chapter chapter = list.get(index);
            chapter.setCons(chapter.getContent());
            Chapter next = new Chapter();
            Chapter pre = new Chapter();
            if (index > 0){
                pre = list.get(index - 1);
            }
            if (index != list.size() - 1){
                next = list.get(index + 1);
            }
            model.addAttribute("book", book);
            model.addAttribute("chapter", chapter);
            model.addAttribute("next", next);
            model.addAttribute("pre", pre);
        } else {
            System.out.println("huo qu shi bai");
        }
        return "book/chapter";
    }

    @GetMapping("/top/index")
    public String getTopList(Model model){
        List<Book> topList = bookService.getTopList(0);
        model.addAttribute("topList", topList);
        return "top/index";
    }
}
