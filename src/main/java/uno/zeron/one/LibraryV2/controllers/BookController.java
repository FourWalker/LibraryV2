package uno.zeron.one.LibraryV2.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uno.zeron.one.LibraryV2.dto.book.BookRegistrationRequest;
import uno.zeron.one.LibraryV2.entities.Book;
import uno.zeron.one.LibraryV2.services.BookService;

import java.util.List;

@RestController
public class BookController {

	
	BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookRegistrationRequest book) {
        return ResponseEntity.ok(bookService.registerNewBook(book));
    }
	@GetMapping("/getAllAvailableBooks")
	public ResponseEntity<List<Book>> getAllAvailableBooks() {
		return ResponseEntity.ok(bookService.getAllAvailableBooks());
	}

	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Book>> getAvailableBooks() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
}
