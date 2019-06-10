package grimsi.accservermanager.backend.annotation;

import grimsi.accservermanager.backend.validator.SteamIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SteamIdValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSteamId {
    String message() default "invalid Steam ID format.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
