package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_order")
    private int codeOrder;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "purchase_address", length = 512)
    private String purchaseAddress;

    @Column(name = "delivery_address", length = 512)
    private String deliveryAddress;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "delivery_price")
    private double deliveryPrice;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList;

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
    @JoinColumn(name = "code_form_delivery")
    private FormDelivery formDelivery;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "code_form_payment")
    private FormPayment formPayment;

}
