package uno.zeron.one.LibraryV2.domain.transaction;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import uno.zeron.one.LibraryV2.domain.book.Book;
import uno.zeron.one.LibraryV2.domain.borrower.Borrower;


@Entity
@Data
public class BorrowTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "borrower_id")
	private Borrower borrower;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	private LocalDate borrowDate;
	private LocalDate returnDate;
	

	
	
}