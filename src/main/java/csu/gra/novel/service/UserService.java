package csu.gra.novel.service;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.User;

import java.util.List;

/**
 * @author howyoung
 */
public interface UserService {
    User findUserByUsernameAndPassword(String username, String password);

    User register(User user);

    void insertFavorite(int userId, int bookId);

    Boolean findFavorite(int userId, int bookId);

    List<Book> getFavoriteBooks(int userId);

    void delFavorite(int userId, int bookId);
}
