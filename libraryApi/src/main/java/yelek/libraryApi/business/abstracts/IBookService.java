package yelek.libraryApi.business.abstracts;

import yelek.libraryApi.entities.Book;
import org.springframework.data.domain.Page;

public interface IBookService {
    Book save(Book book);
    Book get(int id);
    Book update(Book book);
    boolean delete(int id);
}
