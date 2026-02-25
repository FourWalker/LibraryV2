package uno.zeron.one.LibraryV2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;
	private String name;
	private String email;
	
}
