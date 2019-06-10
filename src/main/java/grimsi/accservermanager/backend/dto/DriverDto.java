package grimsi.accservermanager.backend.dto;

import grimsi.accservermanager.backend.annotation.ValidSteamId;
import grimsi.accservermanager.backend.enums.DriverCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//TODO: convert properties to enums instead of primitives

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private String firstName;

    private String lastName;

    private String shortName;

    private DriverCategory driverCategory;

    /*
    -- Not yet supported/implemented according to KUNOS --

    private int nationality;

    private int helmetTemplateKey;

    private int helmetBaseColor;

    private int helmetDetailColor;

    private int helmetMaterialType;

    private int helmetGlassColor;

    private BigDecimal helmetGlassMetallic;

    private int glovesTemplateKey;

    private int suitTemplateKey;

    private int suitDetailColor1;

    private int suitDetailColor2;*/

    @ValidSteamId
    private String playerID;
}
