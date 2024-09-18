package vn.project.web_sale_book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.project.web_sale_book.entity.FavoriteBook;

@RepositoryRestResource(path = "favorite-book")
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Integer> {
}
