package vn.project.web_sale_book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.project.web_sale_book.entity.Book;

@RepositoryRestResource(path = "book")
public interface BookRepository extends JpaRepository<Book, Integer> {
}
