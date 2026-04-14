package uno.zeron.one.LibraryV2.domain.book;

import jakarta.validation.constraints.NotBlank;

public record BookRegistrationRequest(
        @NotBlank(message = "ISBN is required") String isbn,
        @NotBlank(message = "Title is required") String title,
        @NotBlank(message = "Author is required") String author
) {
    
}
