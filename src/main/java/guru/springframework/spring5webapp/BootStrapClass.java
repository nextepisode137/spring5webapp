package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapClass implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public BootStrapClass(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("War And Peace","123123");
        Book book2 = new Book("Song Of Ice And Fire", "213213");

        Author author1 = new Author("Lev", "Tolstoy");
        Author author2 = new Author("George", "Martin");

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author2);
        author1.getBooks().add(book1);
        author2.getBooks().add(book2);


        authorRepository.save(author1);
        bookRepository.save(book1);



        authorRepository.save(author2);
        bookRepository.save(book2);
        System.out.println(bookRepository.count());
    }
}
