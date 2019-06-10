package grimsi.accservermanager.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryListDto {
    private final int configVersion = 1;

    @Id
    private String id;

    @NotBlank(message = "name is required.")
    @Pattern(regexp = "[a-zA-Z0-9_-]*", message = "invalid name. Allowed characters: a-z, A-Z, 0-9, '_', '-'")
    private String name;

    private List<EntryDto> entries;
}
