package yelek.libraryApi.api;


import yelek.libraryApi.business.abstracts.IBookService;
import yelek.libraryApi.business.abstracts.ICategoryService;
import yelek.libraryApi.core.config.IModelMapperService;
import yelek.libraryApi.core.result.Result;
import yelek.libraryApi.core.result.ResultData;
import yelek.libraryApi.core.utilities.ResultHelper;
import yelek.libraryApi.dto.request.book.BookSaveRequest;
import yelek.libraryApi.dto.request.book.BookUpdateRequest;
import yelek.libraryApi.dto.response.BookResponse;
import yelek.libraryApi.entities.Book;
import yelek.libraryApi.entities.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final IBookService bookService;
    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    public BookController(IBookService bookService, ICategoryService categoryService, IModelMapperService modelMapper) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest) {
        Book saveBook = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);
        List<Category> categories = bookSaveRequest.getCategoryIds().stream()
                .map(categoryId -> categoryService.get(categoryId))
                .collect(Collectors.toList());
        saveBook.setCategories(categories);
        this.bookService.save(saveBook);
        BookResponse bookResponse = this.modelMapper.forResponse().map(saveBook, BookResponse.class);
        return ResultHelper.created(bookResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) {
        Book updateBook = this.modelMapper.forRequest().map(bookUpdateRequest, Book.class);
        List<Category> categories = bookUpdateRequest.getCategoryIds().stream()
                .map(categoryId -> categoryService.get(categoryId))
                .collect(Collectors.toList());
        updateBook.setCategories(categories);
        this.bookService.update(updateBook);
        BookResponse bookResponse = this.modelMapper.forResponse().map(updateBook, BookResponse.class);
        return ResultHelper.success(bookResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable("id") int id) {
        Book book = this.bookService.get(id);
        BookResponse bookResponse = this.modelMapper.forResponse().map(book, BookResponse.class);
        return ResultHelper.success(bookResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.bookService.delete(id);
        return ResultHelper.ok();
    }
}
