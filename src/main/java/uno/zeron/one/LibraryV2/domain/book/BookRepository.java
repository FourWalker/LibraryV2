package uno.zeron.one.LibraryV2.domain.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByIsbn(String isbn);
	List<Book> findByIsAvailable(boolean isAvailable);
	Optional<Book> findByIdAndIsAvailableTrue(Long id);
}
