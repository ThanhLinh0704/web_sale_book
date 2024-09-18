package vn.project.web_sale_book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import vn.project.web_sale_book.entity.FormPayment;

@RepositoryRestResource(path = "form-payment")
public interface FormPaymentRepository extends JpaRepository<FormPayment, Integer> {
}
