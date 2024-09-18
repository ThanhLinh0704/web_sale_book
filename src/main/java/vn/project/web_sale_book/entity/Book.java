package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_book")
    private int codeBook;

    @Column(name = "name_book", length = 256)
    private String nameBook;

    @Column(name = "author", length = 256)
    private String author;

    @Column(name = "isbn", length = 256)
    private String ISBN;

    @Column(name = "describe", columnDefinition = "text")
    private String describe;

    @Column(name = "price_original")
    private double priceOriginal;

    @Column(name = "price_sale")
    private double priceSale;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "rating")
    private Double rating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "code_book"),
            inverseJoinColumns = @JoinColumn(name = "code_category")
    )
    List<Category> categoryList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE
    })
    List<Image> imageList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Evaluate> evaluateList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    List<OrderDetail> orderDetailList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<FavoriteBook> favoriteBookList;
}
