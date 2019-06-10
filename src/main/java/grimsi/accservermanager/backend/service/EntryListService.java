package grimsi.accservermanager.backend.service;

import com.google.gson.Gson;
import grimsi.accservermanager.backend.dto.EntryListDto;
import grimsi.accservermanager.backend.entity.EntryList;
import grimsi.accservermanager.backend.exception.ConflictException;
import grimsi.accservermanager.backend.exception.EntryListInUseException;
import grimsi.accservermanager.backend.exception.NotFoundException;
import grimsi.accservermanager.backend.repository.EntryListRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryListService {

    @Autowired
    JsonSchemaService jsonSchemaService;

    @Autowired
    InstanceService instanceService;

    @Autowired
    EntryListRepository entryListRepository;

    @Autowired
    ModelMapper mapper;

    @Autowired
    Gson gson;

    private List<SseEmitter> sseEmitters = new ArrayList<>();

    public List<EntryListDto> findAll() {
        List<EntryList> entryLists = entryListRepository.findAll();
        return mapper.map(entryLists, new TypeToken<List<EntryListDto>>() {
        }.getType());
    }

    public EntryListDto findByName(String name) {
        EntryList entryList = entryListRepository.findByName(name).orElseThrow(NotFoundException::new);
        return mapper.map(entryList, EntryListDto.class);
    }

    public EntryListDto findById(String id) {
        EntryList entryList = entryListRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.map(entryList, EntryListDto.class);
    }

    public EntryListDto create(EntryListDto entryListDto) {
        entryListDto = save(entryListDto);
        emitNewEvent("create", gson.toJson(entryListDto));
        return entryListDto;
    }

    public EntryListDto updateById(String id, EntryListDto entryListDto) {
        findById(id);

        /* Set the values that the user is not allowed to change */
        entryListDto.setId(id);

        /* Set the restart required flag for all instances that use this entryList */
        instanceService.findInstancesByEntryListId(id).forEach(
                i -> instanceService.requireRestart(i.getId())
        );

        entryListDto = save(entryListDto);
        emitNewEvent("update", gson.toJson(entryListDto));
        return entryListDto;
    }

    public void deleteById(String id) {
        findById(id);

        if (instanceService.isEntryListInUse(id)) {
            throw new EntryListInUseException(id);
        }

        entryListRepository.deleteById(id);
        emitNewEvent("delete", id);
    }

    @SuppressWarnings("Duplicates")
    public SseEmitter createNewEntryListEmitter() {
        SseEmitter emitter = new SseEmitter();
        sseEmitters.add(emitter);

        emitter.onCompletion(() -> sseEmitters.remove(emitter));
        emitter.onTimeout(() -> sseEmitters.remove(emitter));
        emitter.onError((throwable) -> sseEmitters.remove(emitter));

        return emitter;
    }

    @SuppressWarnings("Duplicates")
    private void emitNewEvent(String name, String data) {
        sseEmitters.forEach(sseEmitter -> {
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(data)
                        .name(name);
                sseEmitter.send(event);
            } catch (Exception ex) {
                sseEmitter.completeWithError(ex);
            }
        });
    }

    public EntryListDto save(EntryListDto entryListDto) {
        EntryList entryList = convertToEntity(entryListDto);

        try {
            entryList = entryListRepository.save(entryList);
        } catch (DuplicateKeyException e) {
            throw new ConflictException("Name '" + entryList.getName() + "' is already in use.");
        }

        return convertToDto(entryList);
    }

    public String getJsonSchema() {
        String schema = jsonSchemaService.getJsonSchema(EntryListDto.class);
        if (schema == null) {
            throw new NullPointerException("Error parsing JSON schema");
        }
        return schema;
    }

    private EntryListDto convertToDto(EntryList EntryList) {
        return mapper.map(EntryList, EntryListDto.class);
    }

    private EntryList convertToEntity(EntryListDto EntryListDto) {
        return mapper.map(EntryListDto, EntryList.class);
    }
}
