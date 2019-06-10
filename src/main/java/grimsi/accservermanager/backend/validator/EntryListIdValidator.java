package grimsi.accservermanager.backend.validator;

import grimsi.accservermanager.backend.annotation.ValidEventId;
import grimsi.accservermanager.backend.dto.EntryListDto;
import grimsi.accservermanager.backend.exception.NotFoundException;
import grimsi.accservermanager.backend.service.EntryListService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntryListIdValidator implements ConstraintValidator<ValidEventId, EntryListDto> {

    private final EntryListService entryListService;

    @Autowired
    public EntryListIdValidator(EntryListService entryListService) {
        this.entryListService = entryListService;
    }

    @Override
    public boolean isValid(EntryListDto entryList, ConstraintValidatorContext cxt) {
        try {
            entryListService.findById(entryList.getId());
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }
}
