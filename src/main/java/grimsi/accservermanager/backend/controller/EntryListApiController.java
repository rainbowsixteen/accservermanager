package grimsi.accservermanager.backend.controller;

import grimsi.accservermanager.backend.api.EntryListApi;
import grimsi.accservermanager.backend.dto.EntryListDto;
import grimsi.accservermanager.backend.service.EntryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EntryListApiController implements EntryListApi {

    @Autowired
    private EntryListService EntryListService;

    @Override
    public ResponseEntity<List<EntryListDto>> getEntryLists(String name) {
        List<EntryListDto> EntryListDtos = EntryListService.findAll();
        return ResponseEntity.ok(EntryListDtos);
    }

    @Override
    public ResponseEntity<EntryListDto> getEntryListById(String EntryListId) {
        EntryListDto EntryListDto = EntryListService.findById(EntryListId);
        return ResponseEntity.ok(EntryListDto);
    }

    @Override
    public ResponseEntity<EntryListDto> createEntryList(@Valid EntryListDto body) {
        EntryListDto EntryListDto = EntryListService.create(body);
        return ResponseEntity.ok(EntryListDto);
    }

    @Override
    public ResponseEntity<EntryListDto> updateEntryListById(EntryListDto body, String EntryListId) {
        EntryListDto EntryListDto = EntryListService.updateById(EntryListId, body);
        return ResponseEntity.ok(EntryListDto);
    }

    @Override
    public ResponseEntity<Void> deleteEntryListById(String EntryListId) {
        EntryListService.deleteById(EntryListId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public SseEmitter getEntryListStream() {
        return EntryListService.createNewEntryListEmitter();
    }

    @Override
    public ResponseEntity<String> getEntryListSchema() {
        String schema = EntryListService.getJsonSchema();
        return ResponseEntity.ok(schema);
    }

}
