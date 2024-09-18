package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "form_delivery")
public class FormDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_form_delivery")
    private int codeFormDelivery;

    @Column(name = "name_form_delivery")
    private String nameFormDelivery;

    @Column(name = "description_form_delivery")
    private String descriptionFormDelivery;

    @Column(name = "price_form_delivery")
    private double priceFormDelivery;

    @OneToMany(mappedBy = "formDelivery", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Order> orderList;
}
