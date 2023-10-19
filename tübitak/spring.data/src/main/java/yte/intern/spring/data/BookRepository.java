package yte.intern.spring.data;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
public interface BookRepository extends JpaRepository<Book,Long> {

    Book findByTitleGreaterThan(String title);
    List<Book> findByAgeGreaterThan(Long age, Sort sort);
    List<Book> findByPublishDateAfter(LocalDateTime publishDate, PageRequest pageRequest);//PageRequest attığımız sorguların sayfalandırılabilmesi için gerekli
    List<Book> findByTitleContains(String title);
    List<Book> findByTitleContainsIgnoreCase(String title);
    List<Book> findByAuthorAndAgeGreaterThan(String author,Long Age);
    long countByAuthor(String author);
    boolean existsByAuthor(String author);

    @Query("select b from Book b where b.title = :title")
    Book findByTitleQuery(String title);
    @Query("select b from Book b where b.age > :age")
    List<Book> findByAgeQuery(Long age,Sort sort);
    @Query("select b from Book b where b.publishdate > :publishDate")
    List<Book> findByPublishDate(LocalDateTime publishDate,PageRequest pageRequest);
    @Query("select b from Book b where b.title ilike %:title%")
    List<Book> findByTitleLike(String title);
    @Query("select b from Book b where b.author = :author and b.age > :age")
    List<Book> findByAuthorAndAge(String author,Long age);

    @Query("select count(b) from Book b where b.author= :author")
    long countByAuthorQuery(String author);

}
