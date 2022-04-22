package csu.gra.novel.mapper;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.Chapter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author howyoung
 */
@Repository
public interface BookMapper {
    List<Book> selectCurrentBook(int num);

    List<Book> selectBooksByCategory(String category, int num);

    void updateBook(Book book);

    List<Book> selectBooksByPage(String category, int state, int num1, int num2);

    Book getBookById(int id);

    List<Chapter> getChaptersByBookId(int id);

    List<Book> getTopList(int num);

    List<Book> getBookByKeyword(String keyword);

    List<Book> getBooksByAuthor(String author);
}
