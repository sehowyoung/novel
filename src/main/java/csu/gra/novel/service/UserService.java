package csu.gra.novel.service;

import csu.gra.novel.domain.User;

/**
 * @author howyoung
 */
public interface UserService {
    User findUserByUsernameAndPassword(String username, String password);

    User register(User user);
}
