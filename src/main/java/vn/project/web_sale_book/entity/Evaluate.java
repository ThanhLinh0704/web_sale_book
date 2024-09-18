package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "evaluate")
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_evaluate")
    private long codeEvaluate;

    @Column(name = "rating_point")
    private float ratingPoint;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "code_book", nullable = false)
    private Book book;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "code_user", nullable = false)
    private User user;
}
