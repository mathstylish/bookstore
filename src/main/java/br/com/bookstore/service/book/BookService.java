package br.com.bookstore.service.book;

import br.com.bookstore.domain.book.Book;
import br.com.bookstore.exception.BookNotFoundException;
import br.com.bookstore.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        var books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new BookNotFoundException("Books not found");
        }

        return books;
    }

    public List<Book> findAllByTitle(String title) {
        //TODO: Implementar uma regra para que quando o livro que a pessoa quer nao for encontrado ela receba uma lista de livros com generos semelhantes ao que a pessoa procurou ordenado por ranking do livro
        return bookRepository.findAllByTitle(title);
    }

}
