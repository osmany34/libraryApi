package yelek.libraryApi.dto.request.category;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategorySaveRequest {
    @NotNull(message= "Kategori adı boş veya null olamaz")
    private String name;
}
