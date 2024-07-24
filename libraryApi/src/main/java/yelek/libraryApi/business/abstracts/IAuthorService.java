package yelek.libraryApi.business.abstracts;


import yelek.libraryApi.entities.Author;
import org.springframework.data.domain.Page;

public interface IAuthorService {
    Author save(Author author);
    Author get(int id);
    Author update(Author author);
    boolean delete(int id);
}

