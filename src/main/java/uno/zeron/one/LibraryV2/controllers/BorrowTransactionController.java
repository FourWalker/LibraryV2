package uno.zeron.one.LibraryV2.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uno.zeron.one.LibraryV2.dto.BorrowTransactionRequest;
import uno.zeron.one.LibraryV2.entities.BorrowTransaction;
import uno.zeron.one.LibraryV2.services.BorrowTransactionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BorrowTransactionController {


    private final BorrowTransactionService borrowTransactionService;


    @PostMapping("/borrowBook")
    public ResponseEntity<BorrowTransaction> borrowBook(BorrowTransactionRequest request){
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

    @PostMapping("/returnBook")
    public ResponseEntity<BorrowTransaction> returnBook(Long bookId){
        return  ResponseEntity.ok(borrowTransactionService.returnBook(bookId));
    }





}
