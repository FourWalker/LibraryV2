package uno.zeron.one.LibraryV2.domain.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data

public class Book {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;
    @NotBlank(message = "ISBN must not be empty")
	private String isbn;
    @NotBlank(message = "Title must not be empty")
	private String title;
	@NotBlank(message = "Author must not be empty")
	private String author;
	
	
	private boolean isAvailable;
	
}
