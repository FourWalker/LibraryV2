package uno.zeron.one.LibraryV2.dto;

import jakarta.validation.constraints.NotBlank;

public record BorrowTransactionRequest(
		@NotBlank(message = "Book Id is required") Long bookId, 
		@NotBlank(message = "Borrower Id is required") Long borrowerId) {

}
