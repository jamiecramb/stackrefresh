package org.jcramb.stackrefresh.book.repository;

import org.jcramb.stackrefresh.book.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repository contract that also uses the spring-data-jpa infrastructure to generate default CRUD methods for us.
 * Extends the {@link BookRepositoryCustom} to add in methods that spring-data-jpa can't generated for us.
 * 
 * @author Jamie Cramb
 */
public interface BookRepository extends JpaRepository<BookModel, Long>, BookRepositoryCustom {

}