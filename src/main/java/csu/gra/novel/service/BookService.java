package csu.gra.novel.service;

import csu.gra.novel.domain.Book;

import java.util.List;
import java.util.Map;

/**
 * @author howyoung
 */
public interface BookService {
    /**
     * 查询首页小说设置列表数据
     * @return
     */
    Map<Byte, List<Book>> listBooks();
}
