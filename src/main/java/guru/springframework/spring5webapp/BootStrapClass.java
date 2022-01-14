package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapClass implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public BootStrapClass(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("War And Peace","123123");
        Book book2 = new Book("Song Of Ice And Fire", "213213");
        Publisher publisher = new Publisher("Some publisher","Ryazan", "Ryazan", "Novatorov", "390044");

        Author author1 = new Author("Lev", "Tolstoy");
        Author author2 = new Author("George", "Martin");

        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher);
        author1.getBooks().add(book1);
        author2.getBooks().add(book2);

        publisherRepository.save(publisher);

        authorRepository.save(author1);
        bookRepository.save(book1);



        authorRepository.save(author2);
        bookRepository.save(book2);
        System.out.println("books " + bookRepository.count());
        System.out.println("books with publishers" + publisherRepository.count());
    }
}
