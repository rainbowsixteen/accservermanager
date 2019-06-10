package grimsi.accservermanager.backend.entity;

import grimsi.accservermanager.backend.dto.EntryDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("entrylist")
@Getter
@Setter
public class EntryList {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private List<EntryDto> entries;
    private int configVersion = 1;
}
