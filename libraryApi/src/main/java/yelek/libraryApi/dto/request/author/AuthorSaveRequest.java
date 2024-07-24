package yelek.libraryApi.dto.request.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorSaveRequest {
    private String authorName;
    private String authorBirthDate;
    private String authorCountry;
}