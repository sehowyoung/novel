package csu.gra.novel.service.impl;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.User;
import csu.gra.novel.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author howyoung
 */
@Service
//@Transactional()
public class UserServiceImpl implements csu.gra.novel.service.UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @param username
     * @param password
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        if ("".equals(username) || username == null || "".equals(password) || password == null) {
            return null;
        } else {
            return userMapper.findUserByUsernameAndPassword(username, password);
        }
    }

    @Override
    public User register(User user) {
        String pwd = user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(pwd.getBytes(StandardCharsets.UTF_8)));
        userMapper.insertUser(user);
        return userMapper.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void insertFavorite(int userId, int bookId) {
        if (Boolean.FALSE.equals(findFavorite(userId, bookId))) {
            userMapper.insertFavorite(userId, bookId);
        }
    }

    @Override
    public Boolean findFavorite(int userId, int bookId) {
        Integer id = userMapper.findFavorite(userId, bookId);
        return id != null;
    }

    @Override
    public List<Book> getFavoriteBooks(int userId) {
        return userMapper.getFavoriteBooks(userId);
    }

    @Override
    public void delFavorite(int userId, int bookId) {
        userMapper.deleteFavorite(userId, bookId);
    }
}
