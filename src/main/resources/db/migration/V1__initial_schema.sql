CREATE TABLE book (
                      id BIGSERIAL PRIMARY KEY,
                      isbn VARCHAR(20) NOT NULL,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      is_available BOOLEAN DEFAULT TRUE
);

CREATE TABLE borrower (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE borrow_transaction (
                                    id BIGSERIAL PRIMARY KEY,
                                    book_id BIGINT NOT NULL,
                                    borrower_id BIGINT NOT NULL,
                                    borrow_date DATE NOT NULL,
                                    return_date DATE,
                                    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book(id),
                                    CONSTRAINT fk_borrower FOREIGN KEY (borrower_id) REFERENCES borrower(id)
);