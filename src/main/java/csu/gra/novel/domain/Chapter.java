package csu.gra.novel.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author howyoung
 */
@Data
@Component
public class Chapter {
    private int id;
    private int bookId;
    private String name;
    private String content;
    private List<String> cons;

    public void setCons(String content){
        cons = new ArrayList<>();
        String[] strings = content.split("\n");
        Collections.addAll(cons, strings);
    }
}
