package grimsi.accservermanager.backend.repository;

import grimsi.accservermanager.backend.entity.EntryList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EntryListRepository extends MongoRepository<EntryList, String> {
    Optional<EntryList> findByName(String name);
}
