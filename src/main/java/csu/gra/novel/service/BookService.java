package csu.gra.novel.service;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.Chapter;

import java.util.List;

/**
 * @author howyoung
 */
public interface BookService {
    /**
     * 查询推荐小说
     * @return List
     */
    List<Book> getRecommendBooks(int num);

    List<Book> getBooksByCategory(String category, int num);

    void updateBook(Book book);

    List<Book> getBooksByPage(String category, int state, int num);

    Book getBookById(int id);

    List<Book> getTopList(int num);

    List<Book> getBookByKeyword(String keyword);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByUser(int userId);

    Chapter getChapterById(int id);
}
