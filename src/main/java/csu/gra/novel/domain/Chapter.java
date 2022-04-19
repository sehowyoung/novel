package csu.gra.novel.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author howyoung
 */
@Data
@Component
public class Chapter {
    private int id;
    private int bookId;
    private String content;
}
