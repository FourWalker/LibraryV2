package uno.zeron.one.LibraryV2.controllers;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uno.zeron.one.LibraryV2.dto.BorrowTransactionRequest;
import uno.zeron.one.LibraryV2.entities.BorrowTransaction;
import uno.zeron.one.LibraryV2.services.BorrowTransactionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class BorrowTransactionController {


    private final BorrowTransactionService borrowTransactionService;


    @PostMapping("/borrowBook")
    public ResponseEntity<BorrowTransaction> borrowBook(@Valid @RequestBody BorrowTransactionRequest request){
        return ResponseEntity.ok(borrowTransactionService.borrowBook(request));
    }


    @GetMapping("/getAllUnreturnedBooks")
    public ResponseEntity<List<BorrowTransaction>> getAllUnreturnedBooks(){
        return ResponseEntity.ok(borrowTransactionService.getAllUnreturnedBooks());
    }

    
    @GetMapping("/getAllBorrowTransactionHistory")
    public ResponseEntity<List<BorrowTransaction>> getAllBorrowTransactionHistory(){
        return ResponseEntity.ok(borrowTransactionService.getBorrowTransactionHistory());
    }

    @PostMapping("/returnBook/{bookId}")
    public ResponseEntity<BorrowTransaction> returnBook(@Positive(message = "Book ID must be greater than 0") @PathVariable Long bookId){
        return  ResponseEntity.ok(borrowTransactionService.returnBook(bookId));
    }





}
