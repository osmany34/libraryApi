package yelek.libraryApi.business.abstracts;

import yelek.libraryApi.entities.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {
    Category save(Category category);
    Category get(int id);
    Category update(Category category);
    String delete(int id);
}
