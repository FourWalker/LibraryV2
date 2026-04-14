package uno.zeron.one.LibraryV2.domain.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uno.zeron.one.LibraryV2.domain.book.BookEvent;
import uno.zeron.one.LibraryV2.domain.book.BookService;
import uno.zeron.one.LibraryV2.domain.borrower.BorrowerService;
import uno.zeron.one.LibraryV2.domain.book.Book;
import uno.zeron.one.LibraryV2.domain.borrower.Borrower;
import uno.zeron.one.LibraryV2.exception.BusinessLogicException;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

		BookEvent event = new BookEvent(
				bookTransaction.getBook().getId(),
				bookTransaction.getBorrower().getId(),
				"BORROWED",
				LocalDateTime.now()
		);



		return bookTransaction;
	}

	@Transactional
	public BorrowTransaction returnBook(Long id) {
		BorrowTransaction exist = btRepository.findByBookIdAndReturnDateIsNull(id).orElseThrow(() -> new BusinessLogicException("Book is not borrowed"));
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
