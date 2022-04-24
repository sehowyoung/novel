package csu.gra.novel;

import csu.gra.novel.domain.Book;
import csu.gra.novel.domain.User;
import csu.gra.novel.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author howyoung
 * @date 2022/4/24
 * @email howyoung525@foxmail.com
 */
@SpringBootTest
@MapperScan("csu.gra.novel.mapper")
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    void testRegister() {
        String username = "test001";
        String password = "howyoung";
        String email = "howyoung525@foxmail.com";

        User user = new User(username, password, email);
        User register = userService.register(user);
        System.out.println(register.toString());
    }

    @Test
    void testFindFav(){
        int userId = 3;
        int bookId = 18;
        System.out.println(userService.findFavorite(userId, bookId));
    }

    @Test
    void testInsert(){
        int userId = 2;
        int bookId = 21;
        userService.insertFavorite(userId, bookId);
    }

    @Test
    void testLogin(){
        String username = "howyoung";
        String password = "howyoung";
        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        User user = userService.findUserByUsernameAndPassword(username, password);
        System.out.println(user.toString());
    }

    @Test
    void testBookshelf(){
        List<Book> books = userService.getFavoriteBooks(2);
        for(Book book : books){
            System.out.println(book.getName());
        }
    }
}
