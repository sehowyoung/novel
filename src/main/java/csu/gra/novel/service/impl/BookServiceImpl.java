package csu.gra.novel.service.impl;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.Chapter;
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
    public Book getBookById(int id) {
        Book book = bookMapper.getBookById(id);
        book.setStatus(book.getStatusCode());
        List<Chapter> chapters = bookMapper.getChaptersByBookId(id);
        for (Chapter chapter : chapters) {
            String name = chapter.getName();
            int index1 = name.indexOf('.');
            int index2 = name.indexOf(".txt");
            name = name.substring(index1 + 1, index2);
            chapter.setName(name);
        }
        book.setChapters(chapters);
        return book;
    }

    @Override
    public List<Book> getBooksByPage(String category, int state, int num) {
        return bookMapper.selectBooksByPage(category, state, (num - 1) * 12, 12);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public List<Book> getTopList(int num) {
        List<Book> books = bookMapper.getTopList(num);
        for (Book book : books) {
            book.setStatus(book.getStatusCode());
            List<Chapter> chapters = bookMapper.getChaptersByBookId(book.getBookId());
            for (Chapter chapter : chapters) {
                String name = chapter.getName();
                int index1 = name.indexOf('.');
                int index2 = name.indexOf(".txt");
                name = name.substring(index1 + 1, index2);
                chapter.setName(name);
                break;
            }
            book.setChapters(chapters);
        }
        return books;
    }

    @Override
    public List<Book> getBookByKeyword(String keyword) {
        return bookMapper.getBookByKeyword(keyword);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookMapper.getBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByUser(int userId) {
        return bookMapper.getBooksByUser(userId);
    }

    @Override
    public Chapter getChapterById(int id) {
        return bookMapper.getChapterById(id);
    }
}
