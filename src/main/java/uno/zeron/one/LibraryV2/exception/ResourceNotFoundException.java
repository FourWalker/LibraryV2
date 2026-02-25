package uno.zeron.one.LibraryV2.exception;

// For when a Book or Borrower isn't in the DB
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}