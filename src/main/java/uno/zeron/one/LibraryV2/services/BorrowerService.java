package uno.zeron.one.LibraryV2.services;

import org.springframework.stereotype.Service;

import uno.zeron.one.LibraryV2.entities.Borrower;
import uno.zeron.one.LibraryV2.repositories.BorrowerRepository;

@Service
public class BorrowerService {

	BorrowerRepository borrowerRepository;
	
	public BorrowerService(BorrowerRepository borrowerRepo) {
		this.borrowerRepository = borrowerRepo;
	}
	
	public Borrower registerNewBorrower(Borrower borrower) {
		Borrower existing = borrowerRepository.findByEmail(borrower.getEmail()).stream().findFirst().orElse(null);
		if(existing != null) {
			throw new RuntimeException("Email is already used");
		}
		return borrowerRepository.save(borrower);
	}
	public Borrower findById(Long id) {
		Borrower existing = borrowerRepository.findById(id).stream().findFirst().orElseThrow(() -> new RuntimeException("Borrower does not exist"));
		return existing;
	}
}
