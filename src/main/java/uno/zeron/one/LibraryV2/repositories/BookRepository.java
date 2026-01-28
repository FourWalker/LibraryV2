package uno.zeron.one.LibraryV2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uno.zeron.one.LibraryV2.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByIsbn(String isbn);
	List<Book> findByIsBorrowedFalse();
}
