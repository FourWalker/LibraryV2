package uno.zeron.one.LibraryV2.domain.borrower;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface BorrowerRepository extends JpaRepository<Borrower, Long> {
	List<Borrower> findByEmail(String name);
	
}
