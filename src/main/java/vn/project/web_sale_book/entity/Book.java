package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_book")
    private int codeBook;

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn", length = 255)
    private String ISBN;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price_original")
    private BigDecimal priceOriginal;

    @Column(name = "price_sale")
    private BigDecimal priceSale;

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
