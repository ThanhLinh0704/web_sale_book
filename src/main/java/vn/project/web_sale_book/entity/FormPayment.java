package vn.project.web_sale_book.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "form_payment")
public class FormPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeFormPayment;

    @Column(name = "name_form_payment")
    private String nameFormPayment;

    @Column(name = "description_form_payment")
    private String descriptionFormPayment;

    @Column(name = "price_form_payment")
    private double priceFormPayment;

    @OneToMany(mappedBy = "formPayment", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Order> orderList;
}
