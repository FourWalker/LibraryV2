package uno.zeron.one.LibraryV2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uno.zeron.one.LibraryV2.entities.Book;
import uno.zeron.one.LibraryV2.services.BookService;

@RestController
public class BookController {

	
	BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.registerNewBook(book));
    }
	@GetMapping("/get")
	public String test() {
		return "test";
	}
	
}
