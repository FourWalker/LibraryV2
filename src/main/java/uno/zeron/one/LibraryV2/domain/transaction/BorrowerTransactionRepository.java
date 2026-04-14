package uno.zeron.one.LibraryV2.domain.transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerTransactionRepository extends JpaRepository<BorrowTransaction, Long> {
	Optional<BorrowTransaction> findByBookIdAndReturnDateIsNull(Long id);
	List<BorrowTransaction> findByReturnDateIsNull();
}
