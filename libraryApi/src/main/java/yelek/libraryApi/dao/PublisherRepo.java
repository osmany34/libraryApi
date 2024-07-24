package yelek.libraryApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yelek.libraryApi.entities.Publisher;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
