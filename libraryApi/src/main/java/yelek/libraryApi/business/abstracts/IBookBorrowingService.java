package yelek.libraryApi.business.abstracts;

import yelek.libraryApi.entities.Book;
import yelek.libraryApi.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface IBookBorrowingService {
    BookBorrowing save(BookBorrowing bookBorrowing);
    BookBorrowing get(int id);
    BookBorrowing update(BookBorrowing bookBorrowing);
    boolean delete(int id);
}
