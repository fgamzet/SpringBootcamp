package yte.intern.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(Application.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		List<Book> exampleBooks = new ArrayList<>();
		exampleBooks.add(new Book(null, "Clean Code", "Robert C. Martin", 18L, LocalDateTime.now()));
		exampleBooks.add(new Book(null, "Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 20L, LocalDateTime.now()));
		exampleBooks.add(new Book(null, "The Pragmatic Programmer", "Andrew Hunt, David Thomas", 22L, LocalDateTime.now()));
		exampleBooks.add(new Book(null, "Java: The Complete Reference", "Herbert Schildt", 25L, LocalDateTime.now()));
		exampleBooks.add(new Book(null, "Effective Java", "Joshua Bloch", 30L, LocalDateTime.now()));
		bookRepository.saveAll(exampleBooks);
		//System.out.println(bookRepository.findByTitle("Effective Java"));
		//System.out.println(bookRepository.findByAgeGreaterThan(15L, Sort.by("age").ascending()));
		//System.out.println(bookRepository.findByPublishDateAfter(LocalDateTime.parse("2000-01-01T00:00"), PageRequest.of(1, 5)));
		//System.out.println(bookRepository.findByTitleContains("Clean"));//exact match.
		System.out.println(bookRepository.findByTitleContainsIgnoreCase("clean"));
		System.out.println(bookRepository.findByAuthorAndAgeGreaterThan("Joshua Bloch",10L));
		System.out.println(bookRepository.countByAuthor("Joshua Bloch"));
		System.out.println(bookRepository.existsByAuthor("Joshua rick"));
	}

}
