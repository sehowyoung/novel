package csu.gra.novel.service.impl;

import csu.gra.novel.domain.User;
import csu.gra.novel.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author howyoung
 */
@Service
public class UserServiceImpl implements csu.gra.novel.service.impl.UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @param user
     */
    @Override
    public Boolean insertUser(User user) {
        if ("".equals(user.getUsername()) || user.getUsername() == null || "".equals(user.getPassword()) || user.getPassword() == null) {
            return false;
        } else {
            return userMapper.insertUser(user);
        }
    }

    @Override
    public User findUserByUsernameAndPassword(User user) {
        if ("".equals(user.getUsername()) || user.getUsername() == null || "".equals(user.getPassword()) || user.getPassword() == null) {
            return null;
        } else {
            return userMapper.findUserByUsernameAndPassword(user);
        }
    }
}
