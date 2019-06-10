package grimsi.accservermanager.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntryListInUseException extends RuntimeException {
    private static final long serialVersionUID = 1625750374746560586L;

    public EntryListInUseException(String entryListId) {
        super("entryList with id '" + entryListId + "' is still used by at least one instance.");
    }
}
