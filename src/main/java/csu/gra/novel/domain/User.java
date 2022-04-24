package csu.gra.novel.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author howyoung
 */
@Data
//@Component
public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private ArrayList<Book> favorites;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
