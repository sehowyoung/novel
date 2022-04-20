package csu.gra.novel.service.impl;

import csu.gra.novel.domain.Book;
import csu.gra.novel.mapper.BookMapper;
import csu.gra.novel.service.BookService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author howyoung
 */
@Service
@MapperScan("csu.gra.novel.mapper")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getRecommendBooks(int num){
        return bookMapper.selectCurrentBook(num);
    }

    @Override
    public List<Book> getBooksByCategory(String category, int num){
        return bookMapper.selectBooksByCategory(category, num);
    }

    @Override
    public List<Book> getBooksByPage(String category, int state, int num) {
        return bookMapper.selectBooksByPage(category, state, (num - 1) * 12, 12);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }
}
