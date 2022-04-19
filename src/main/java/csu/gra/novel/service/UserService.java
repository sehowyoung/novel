package csu.gra.novel.service.impl;

import csu.gra.novel.domain.User;

/**
 * @author howyoung
 */
public interface UserService {
    Boolean insertUser(User user);

    User findUserByUsernameAndPassword(User user);
}
