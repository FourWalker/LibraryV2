package uno.zeron.one.LibraryV2.domain.transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BorrowTransactionRequest(
		@Positive(message = "Book ID must be greater than 0") @NotNull(message = "Book Id is required") Long bookId,
		@Positive(message = "Book ID must be greater than 0") @NotNull(message = "Borrower Id is required") Long borrowerId) {

}
