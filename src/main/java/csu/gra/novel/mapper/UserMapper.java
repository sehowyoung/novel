package csu.gra.novel.mapper;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author howyoung
 */
@Repository
public interface UserMapper {
    /**
     * @param user 有用户名和密码
     * @return 用户所有信息
     */
    User findUserByUsernameAndPassword(String username, String password);

    void insertUser(User user);

    void insertFavorite(int userId, int bookId);

    Integer findFavorite(int userId, int bookId);

    List<Book> getFavoriteBooks(int userId);

    void deleteFavorite(int userId, int bookId);
}
