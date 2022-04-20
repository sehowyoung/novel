package csu.gra.novel;

import csu.gra.novel.domain.Book;
import csu.gra.novel.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author howyoung
 * @date 2022/4/19
 * @email howyoung525@foxmail.com
 */
@SpringBootTest
public class BookTest {
    @Autowired
    private BookService bookService;

    @Test
    void test(){
        List<Book> books = bookService.getRecommendBooks(0);
        for (Book book : books) {
            String cover = book.getCover();
            if (cover.contains("doc/topList")){
                cover = cover.replace("doc/topList", "/images");
                book.setCover(cover);
                bookService.updateBook(book);
            }
//            System.out.println(book.toString());
        }
    }
}
