package grimsi.accservermanager.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver {
    private String firstName;
    private String lastName;
    private String shortName;
    private int driverCategory;
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
    private String playerID;
}
