package uno.zeron.one.LibraryV2.domain.borrower;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
	@NotBlank
	private String name;
	@NotBlank
	private String email;

}
