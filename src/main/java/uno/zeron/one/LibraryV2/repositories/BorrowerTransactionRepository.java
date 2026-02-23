package uno.zeron.one.LibraryV2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uno.zeron.one.LibraryV2.entities.BorrowTransaction;

public interface BorrowerTransactionRepository extends JpaRepository<BorrowTransaction, Long> {
	List<BorrowTransaction> findByBookIdAndReturnDateIsNull(Long id);
}
