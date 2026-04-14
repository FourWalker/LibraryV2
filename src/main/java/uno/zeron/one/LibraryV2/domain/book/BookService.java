package uno.zeron.one.LibraryV2.domain.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uno.zeron.one.LibraryV2.exception.BusinessLogicException;
import uno.zeron.one.LibraryV2.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class BookService {
	private final BookRepository bookRepository; 
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Transactional(readOnly = true)
	public List<Book> getAllAvailableBooks() {
		return bookRepository.findByIsAvailable(true);
	}

	@Transactional(readOnly = true)
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	
	@Transactional
	public Book registerNewBook(BookRegistrationRequest request) {
		bookRepository.findByIsbn(request.isbn()).stream().findFirst().ifPresent(existing -> {

			boolean titleMatched = existing.getTitle().equalsIgnoreCase(request.title());
			boolean authorMatched = existing.getAuthor().equalsIgnoreCase(request.author());
			
			if(!titleMatched || !authorMatched) {
				throw new BusinessLogicException("ISBN mismatch: Book Title or Author does not match existing records");
			}
		});


		Book newBook = new Book();
		newBook.setTitle(request.title());
		newBook.setIsbn(request.isbn());
		newBook.setAvailable(true);
		newBook.setAuthor(request.author());
		return bookRepository.save(newBook);



	}

	@Transactional(readOnly = true)
	public Book getAvailableBook(Long bookid) {
		Book book = bookRepository.findByIdAndIsAvailableTrue(bookid).orElseThrow(() -> new BusinessLogicException("Book is not available"));
		return book;
	}



	@Transactional
	public void setBookAvailabilityById(Long id, boolean isAvailable) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book does not exist"));
		book.setAvailable(isAvailable);
		bookRepository.save(book);

	}

	@Transactional
	public void setBookAvailability(Book book, boolean isAvailable) {
		if(book.getId() == null){
			throw new ResourceNotFoundException("Book does not exist");
		}
		book.setAvailable(isAvailable);
		bookRepository.save(book);

	}
	
	
	

}
