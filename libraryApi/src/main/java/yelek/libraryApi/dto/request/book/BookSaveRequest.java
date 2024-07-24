package yelek.libraryApi.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSaveRequest {
    private String bookName;
    private String bookPublicationYear;
    private int bookStock;
    private int authorId;
    private int publisherId;
    private List<Integer> categoryIds;
}