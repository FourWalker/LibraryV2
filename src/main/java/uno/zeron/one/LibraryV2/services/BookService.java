package uno.zeron.one.LibraryV2.services;

import uno.zeron.one.LibraryV2.entities.Book;
import uno.zeron.one.LibraryV2.entities.BorrowTransaction;
import uno.zeron.one.LibraryV2.entities.Borrower;
import uno.zeron.one.LibraryV2.repositories.BookRepository;
import uno.zeron.one.LibraryV2.repositories.BorrowerRepository;
import uno.zeron.one.LibraryV2.repositories.BorrowerTransactionRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	BookRepository bookRepository; 
	BorrowerRepository borrowerRepository;
	BorrowerTransactionRepository btRepository;
	
	
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllAvailableBooks() {
		return bookRepository.findByIsBorrowedFalse();
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	public Book registerNewBook(Book book) {
		
		//validate if the existing book has the same Title and Author with the new Book entry
		Book existing = bookRepository.findByIsbn(book.getIsbn()).stream().findFirst().orElse(null);
		if(existing != null) {
			if(!existing.getTitle().equals(book.getTitle()) || !existing.getAuthor().equals(book.getAuthor())) {
				throw new RuntimeException("ISBN mismatch: Book Title and Author does not match existing records");
			}
			return bookRepository.save(existing);
		}
		return bookRepository.save(book);
	}
	
	public BorrowTransaction borrowBook(BorrowTransaction bt) {
		
		BorrowTransaction exist = btRepository.findByBookidAndReturnDateIsNull(bt.getBookId()).stream().findFirst().orElse(null);
		if(exist != null) {
			throw new RuntimeException("Book is already borrowed");
		}
		btRepository.save(bt);
		return bt;
	}
	
	public BorrowTransaction returnBook(BorrowTransaction bt) {
		BorrowTransaction exist = btRepository.findByBookidAndReturnDateIsNull(bt.getBookId()).stream().findFirst().orElse(null);
		if(exist == null) {
			throw new RuntimeException("Book is not borrowed");
		}
		exist.setReturnDate(bt.getReturnDate());
		btRepository.save(exist);
		return exist;
	}
	
	
	

}
