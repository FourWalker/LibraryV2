package uno.zeron.one.LibraryV2.services;

import uno.zeron.one.LibraryV2.entities.Book;
import uno.zeron.one.LibraryV2.entities.BorrowTransaction;
import uno.zeron.one.LibraryV2.entities.Borrower;
import uno.zeron.one.LibraryV2.repositories.BookRepository;
import uno.zeron.one.LibraryV2.repositories.BorrowerRepository;
import uno.zeron.one.LibraryV2.repositories.BorrowerTransactionRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
	private final BookRepository bookRepository; 
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Transactional(readOnly = true)
	public List<Book> getAllAvailableBooks() {
		return bookRepository.findByIsAvailableTrue();
	}
	
	@Transactional(readOnly = true)
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@Transactional
	public Book registerNewBook(Book book) {
		Book existing = bookRepository.findByIsbn(book.getIsbn()).stream().findFirst().orElse(null);
		if(existing != null) {
			if(!existing.getTitle().equals(book.getTitle()) || !existing.getAuthor().equals(book.getAuthor())) {
				throw new RuntimeException("ISBN mismatch: Book Title or Author does not match existing records");
			}
		}
		return bookRepository.save(book);
	}
	
	public Book getAvailableBook(Long bookid) {
		
		Book book = bookRepository.findById(bookid).stream().filter(Book::isAvailable).findFirst().orElseThrow(() -> new RuntimeException("Book is not available"));
		return book;
	}
	
	public void setBookAvailability(Book book, boolean isAvailable) {
		if(book.getId() == null) {
			throw new RuntimeException("Book does not exist");
		}
		book.setAvailable(isAvailable);
		bookRepository.save(book);
		
	}
	
	public void setBookAvailabilityById(Long id, boolean isAvailable) {
		Book book = bookRepository.findById(id).stream().findFirst().orElseThrow(() -> new RuntimeException("Book does not exist"));
		book.setAvailable(isAvailable);
		bookRepository.save(book);
		
	}
	
	
	

}
