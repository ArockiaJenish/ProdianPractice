package com.jenish.demo.repository;

import java.util.List;
//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jenish.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	String rawQuery = "SELECT * FROM book WHERE yop = :yop and b_author = :auth";

	@Query(nativeQuery = true, value = rawQuery)
	List<Book> findByYearOfPublication(@Param("yop") int yop, @Param("auth") String auth);

	String rawQuery2 = "select * from book order by b_name";

	@Query(nativeQuery = true, value = rawQuery2) // nativeQuery = true,
	List<Book> findAssendingOrdername();

	String query3 = "insert into book (b_id, b_name, b_author, yop) values(?1, ?2, ?3, ?4)";

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = query3)
	int saveBooks(int id, String bName, String bAuthor, int yop);

	String query4 = "update book set b_name = :name, yop = :year where b_id = :id";
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = query4)
	int updateBooks(@Param("name") String bName, @Param("year") int bAuthor, @Param("id") int id);
}
