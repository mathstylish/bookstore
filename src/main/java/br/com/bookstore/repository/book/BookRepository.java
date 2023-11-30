package br.com.bookstore.repository.book;

import br.com.bookstore.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BookRepository extends JpaRepository<Book, String> {

    @Query(value = "SELECT * FROM Books B WHERE B.Title LIKE %:title%", nativeQuery = true)
    List<Book> findAllByTitle(@Param("title") String title);

}
