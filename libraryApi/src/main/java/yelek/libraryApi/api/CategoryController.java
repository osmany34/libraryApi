package yelek.libraryApi.api;


import yelek.libraryApi.business.abstracts.ICategoryService;
import yelek.libraryApi.core.utilities.Msg;
import yelek.libraryApi.dto.request.category.CategorySaveRequest;
import yelek.libraryApi.dto.request.category.CategoryUpdateRequest;
import yelek.libraryApi.dto.response.CategoryResponse;
import yelek.libraryApi.core.config.IModelMapperService;
import yelek.libraryApi.core.result.Result;
import yelek.libraryApi.core.result.ResultData;
import yelek.libraryApi.core.utilities.ResultHelper;
import yelek.libraryApi.entities.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final ICategoryService categoryService;
    private final IModelMapperService modelMapper;

    public CategoryController(ICategoryService categoryService, IModelMapperService modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        Category saveCategory = this.modelMapper.forRequest().map(categorySaveRequest, Category.class);
        this.categoryService.save(saveCategory);
        CategoryResponse categoryResponse = this.modelMapper.forResponse().map(saveCategory, CategoryResponse.class);
        return ResultHelper.created(categoryResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> get(@PathVariable("id") int id) {
        Category category = this.categoryService.get(id);
        CategoryResponse categoryResponse = this.modelMapper.forResponse().map(category, CategoryResponse.class);
        return ResultHelper.success(categoryResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        Category updateCategory = this.modelMapper.forRequest().map(categoryUpdateRequest, Category.class);
        this.categoryService.update(updateCategory);
        CategoryResponse categoryResponse = this.modelMapper.forResponse().map(updateCategory, CategoryResponse.class);
        return ResultHelper.success(categoryResponse);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        String result = this.categoryService.delete(id);
        if (result.equals("Bu kategoriye ait kitap var. Bu kategori silinemedi.")) {
            return ResultHelper.error();
        } else {
            return ResultHelper.ok();
        }
    }
}
