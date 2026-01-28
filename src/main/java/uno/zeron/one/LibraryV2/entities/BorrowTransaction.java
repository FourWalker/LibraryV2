package uno.zeron.one.LibraryV2.entities;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class BorrowTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter(AccessLevel.NONE)
	private Long id;
	private Long borrowerId;
	private Long bookId;
	private LocalDate borrowDate;
	private LocalDate returnDate;

}
