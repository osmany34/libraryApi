package yelek.libraryApi.dto.request.bookBorrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {
    private int id;
    private String borrowerName;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private int bookId;
}