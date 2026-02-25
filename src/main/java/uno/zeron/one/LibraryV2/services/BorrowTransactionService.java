package uno.zeron.one.LibraryV2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uno.zeron.one.LibraryV2.dto.BorrowTransactionRequest;
import uno.zeron.one.LibraryV2.entities.Book;
import uno.zeron.one.LibraryV2.entities.BorrowTransaction;
import uno.zeron.one.LibraryV2.entities.Borrower;
import uno.zeron.one.LibraryV2.repositories.BorrowerTransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor //This creates a constructor for dependency injection.
public class BorrowTransactionService {

	private final BorrowerTransactionRepository btRepository;
	private final BookService bookService;
	private final BorrowerService borrowerService;


	@Transactional
	public BorrowTransaction borrowBook(BorrowTransactionRequest bt) {

		Book book = bookService.getAvailableBook(bt.bookId());
		Borrower borrower = borrowerService.findById(bt.borrowerId());
		bookService.setBookAvailability(book, false);

		BorrowTransaction bookTransaction = new BorrowTransaction();
		bookTransaction.setBook(book);
		bookTransaction.setBorrower(borrower);
		bookTransaction.setBorrowDate(LocalDate.now());


		btRepository.save(bookTransaction);
		return bookTransaction;
	}

	@Transactional
	public BorrowTransaction returnBook(Long id) {
		BorrowTransaction exist = btRepository.findByBookIdAndReturnDateIsNull(id).orElseThrow(() -> new RuntimeException("Book is not borrowed"));
		bookService.setBookAvailability(exist.getBook(), true);
		exist.setReturnDate(LocalDate.now());
		btRepository.save(exist);
		return exist;
	}

	@Transactional(readOnly = true)
	public List<BorrowTransaction> getBorrowTransactionHistory(){
		return btRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<BorrowTransaction> getAllUnreturnedBooks(){
		return btRepository.findByReturnDateIsNull();
	}


}
