package csu.gra.novel.service.impl;

import csu.gra.novel.domain.User;
import csu.gra.novel.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author howyoung
 */
@Service
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
}
