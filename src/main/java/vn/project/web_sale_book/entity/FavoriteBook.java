package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favorite_book")
public class FavoriteBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_favorite_book")
    private int codeFavoriteBook;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "code_user", nullable = false)
    private User user;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "code_book", nullable = false)
    private Book book;
}
