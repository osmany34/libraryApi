package yelek.libraryApi.business.concretes;

import yelek.libraryApi.business.abstracts.ICategoryService;
import yelek.libraryApi.core.exception.NotFoundException;
import yelek.libraryApi.core.utilities.Msg;
import yelek.libraryApi.dao.BookRepo;
import yelek.libraryApi.dao.CategoryRepo;
import yelek.libraryApi.entities.Category;
import yelek.libraryApi.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {
    private final CategoryRepo categoryRepo;
    private final BookRepo bookRepo;

    public CategoryManager(CategoryRepo categoryRepo, BookRepo bookRepo) {
        this.categoryRepo = categoryRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category get(int id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Category update(Category category) {
        this.get(category.getCategoryId());
        return this.categoryRepo.save(category);
    }

    @Override
    public String delete(int id) {
        List<Book> books = bookRepo.findByCategoriesCategoryId(id);
        if (!books.isEmpty()) {
            return "Bu kategoriye ait kitap var. Bu kategori silinemedi.";
        }
        Category category = this.get(id);
        this.categoryRepo.delete(category);
        return "Kategori başarıyla silindi.";
    }
}
