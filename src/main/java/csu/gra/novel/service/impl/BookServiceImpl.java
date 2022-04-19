package csu.gra.novel.service.impl;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.Constants;
import csu.gra.novel.mapper.BookMapper;
import csu.gra.novel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author howyoung
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Map<Byte, List<Book>> listBooks() {
        List<Book> books = bookMapper.selectCurrentBook(Constants.INDEX_BOOK_SETTING_NUM);
        Map<Byte, List<Book>> bookMap = new HashMap<Byte, List<Book>>();
        if (books.size() == Constants.INDEX_BOOK_SETTING_NUM) {

            List<Book> bookList = new ArrayList<Book>(Constants.INDEX_BOOK_SETTING_NUM);
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                byte type;
            }
        }
        return bookMap;
    }
}
