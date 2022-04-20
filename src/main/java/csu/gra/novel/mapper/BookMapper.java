package csu.gra.novel.mapper;

import csu.gra.novel.domain.Book;
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
}
