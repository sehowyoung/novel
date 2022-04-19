package csu.gra.novel.service;

import csu.gra.novel.domain.Book;

import java.util.List;
import java.util.Map;

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
}
