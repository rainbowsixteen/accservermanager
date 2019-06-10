package grimsi.accservermanager.backend.validator;

import grimsi.accservermanager.backend.annotation.ValidSteamId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SteamIdValidator implements ConstraintValidator<ValidSteamId, String> {

    @Override
    public boolean isValid(String steamid, ConstraintValidatorContext cxt) {
        /* A Steam64 ID is valid if it starts with "S" followed by 17 digits */
        return (steamid.matches("S[0-9]{17}"));
    }
}
