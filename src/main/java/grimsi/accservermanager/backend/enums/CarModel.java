package grimsi.accservermanager.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CarModel {

    PORSCHE_991_GT3(0, "Porsche 991 GT3"),
    MERCEDES_AMG_GT3(1, "Mercedes AMG GT3"),
    FERRARI_488_GT3(2, "Ferrari 488 GT3"),
    AUDI_R8_LMS(3, "Audi R8 LMS"),
    LAMBORGHINI_HURACAN_GT3(4, "Lamborghini Huracan GT3"),
    MCLAREN_650S_GT3(5, "Mclaren 650S GT3"),
    NISSAN_GTR_NISMO_GT3_2018(6, "Nissan GT R Nismo GT3 2018"),
    BMW_M6_GT3(7, "BMW M6 GT3"),
    BENTLEY_CONTINENTAL_GT3_2018(8, "Bentley Continental GT3 2018"),
    PORSCHE_991_2_GT3_CUP(9, "Porsche 991.2 GT3 Cup"),
    NISSAN_GTR_NISMO_GT3_2017(10, "Nissan GT-R Nismo GT3 2017"),
    BENTLEY_CONTINENTAL_GT3_2016(11, "Bentley Continental GT3 2016"),
    ASTON_MARTIN_VANTAGE_V12_GT3(12, "Aston Martin Vantage V12 GT3"),
    LAMBORGHINI_GALLARDO_R_EX(13, "Lamborghini Gallardo R-EX"),
    JAGUAR_GT3(14, "Jaguar GT3"),
    LEXUS_RC_F_GT3(15, "Lexus RC F GT3"),
    TO_BE_ANNOUNCED(16, "Tba."),
    HONDA_NSX_GT3(17, "Honda NSX GT3"),
    LAMBORGHINI_HURACAN_SUPERTROFEO(18, "Lamborghini Huracan SuperTrofeo");

    private int id;
    private String name;

    @Override
    public String toString() {
        //gson should serialize the id, not the car name
        return String.valueOf(id);
    }
}
