package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

/**
 * BootStrapData
 *
 * @author zebrilus
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        Publisher pub1 = new Publisher("O'Really?", "somewhere", "somecity", "Alabama", "90210");
        publisherRepository.save(pub1);
        
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        ddd.setPublisher(pub1);
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);
        pub1.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub1);
        
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        noEJB.setPublisher(pub1);
        noEJB.getAuthors().add(rod);
        rod.getBooks().add(noEJB);
        pub1.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub1);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        
    }
}
