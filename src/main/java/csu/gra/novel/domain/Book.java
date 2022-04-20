package csu.gra.novel.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author howyoung
 */
@Data
@Component
public class Book {
    private int bookId;
    private String name;
    private String description;
    private String author;
    private String category;
    private String updated;
    private String cover;
    private String hot;
    private int statusCode;
    private String status;
    private String word;
    private ArrayList<Chapter> chapters;

    public void setStatus(int statusCode){
        if (statusCode == 1){
            status = "连载中";
        } else if (statusCode == 0){
            status = "已完结";
        }
    }
}
