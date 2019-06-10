package grimsi.accservermanager.backend.api;

import grimsi.accservermanager.backend.dto.EntryListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/v1/entrylists")
public interface EntryListApi {

    @GetMapping(produces = {"application/json"})
    ResponseEntity<List<EntryListDto>> getEntryLists(@Valid @RequestParam(value = "name", required = false) String name);

    @GetMapping(value = "/{EntryListId}", produces = {"application/json"})
    ResponseEntity<EntryListDto> getEntryListById(@PathVariable("EntryListId") String EntryListId);

    @PostMapping(produces = {"application/json"}, consumes = {"application/json"})
    ResponseEntity<EntryListDto> createEntryList(@Valid @RequestBody EntryListDto body);

    @PutMapping(value = "/{EntryListId}", produces = {"application/json"}, consumes = {"application/json"})
    ResponseEntity<EntryListDto> updateEntryListById(@Valid @RequestBody EntryListDto body, @PathVariable("EntryListId") String EntryListId);

    @DeleteMapping(value = "/{EntryListId}", produces = {"application/json"})
    ResponseEntity<Void> deleteEntryListById(@PathVariable("EntryListId") String EntryListId);

    @GetMapping(value = "/stream")
    SseEmitter getEntryListStream();

    @GetMapping(value = "/schema", produces = {"application/json"})
    ResponseEntity<String> getEntryListSchema();
}
