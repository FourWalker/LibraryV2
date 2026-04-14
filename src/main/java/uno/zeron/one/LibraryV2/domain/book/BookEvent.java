package uno.zeron.one.LibraryV2.domain.book;

import java.time.LocalDateTime;

public record BookEvent(
        Long bookId,
        Long borrowerId,
        String action,
        LocalDateTime timestamp
) {
}
