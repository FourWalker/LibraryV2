package uno.zeron.one.LibraryV2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Book {

    @Id
    @Getter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isbn;
	private String title;
	private String author;
	
	private boolean isAvailable;
	
	//Where are the setters and getters?
	//@Data annotation from Lombok creates those setters.
	//you can access them via the variable name with prefix get/is and set then, the variable name on PascalCase (getIsbn, setIsbn, isAvailable)
}
