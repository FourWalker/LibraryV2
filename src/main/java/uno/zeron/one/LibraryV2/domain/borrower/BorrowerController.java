package uno.zeron.one.LibraryV2.domain.borrower;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BorrowerController {
    private final BorrowerService borrowerService;

    @PostMapping("/addBorrower")
    public ResponseEntity<Borrower> addBorrower(@Valid @RequestBody Borrower borrower) {
        return ResponseEntity.ok(borrowerService.registerNewBorrower(borrower));
    }

    @GetMapping("/getAllBorrowers")
    public ResponseEntity<List<Borrower>> getAllBorrowers(){
        return ResponseEntity.ok(borrowerService.getAllBorrowers());
    }

}
