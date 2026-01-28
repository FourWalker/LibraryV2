package uno.zeron.one.LibraryV2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uno.zeron.one.LibraryV2.entities.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
	List<Borrower> findByEmail(String name);
	
}
