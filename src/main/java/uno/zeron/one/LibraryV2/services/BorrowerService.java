package uno.zeron.one.LibraryV2.services;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import uno.zeron.one.LibraryV2.entities.Borrower;
import uno.zeron.one.LibraryV2.exception.BusinessLogicException;
import uno.zeron.one.LibraryV2.exception.ResourceNotFoundException;
import uno.zeron.one.LibraryV2.repositories.BorrowerRepository;

import java.util.List;

@Service
public class BorrowerService {

	BorrowerRepository borrowerRepository;
	
	public BorrowerService(BorrowerRepository borrowerRepo) {
		//writing this constructor instead of using the @RequiredArgsConstructor as a reminder how it works.
		this.borrowerRepository = borrowerRepo;
	}


	@Transactional
	public Borrower registerNewBorrower(Borrower borrower) {
		Borrower existing = borrowerRepository.findByEmail(borrower.getEmail()).stream().findFirst().orElse(null);
		if(existing != null) {
			throw new BusinessLogicException("Email is already used");
		}
		return borrowerRepository.save(borrower);
	}

	@Transactional(readOnly = true)
	public Borrower findById(Long id) {
		return borrowerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Borrower does not exist"));
	}
	@Transactional(readOnly = true)
	public List<Borrower> getAllBorrowers(){
		return borrowerRepository.findAll();
	}
}
