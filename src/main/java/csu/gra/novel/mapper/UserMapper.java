package csu.gra.novel.mapper;

import csu.gra.novel.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author howyoung
 */
@Repository
public interface UserMapper {
    /**
     * @param user 有用户名和密码
     * @return 用户所有信息
     */
    User findUserByUsernameAndPassword(User user);

    Boolean insertUser(User user);
}
