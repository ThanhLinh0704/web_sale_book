package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_order_detail")
    private long codeOrderDetail;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_sale")
    private double priceSale;

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
    @JoinColumn(name = "code_order", nullable = false)
    private Order order;

}
