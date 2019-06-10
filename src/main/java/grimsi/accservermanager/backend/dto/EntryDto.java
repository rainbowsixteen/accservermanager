package grimsi.accservermanager.backend.dto;

import grimsi.accservermanager.backend.enums.CarModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//TODO: convert properties to enums instead of primitives

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryDto {
    private final int configVersion = 0;
    private List<DriverDto> drivers;
    private String customCar;
    private int raceNumber;
    private int defaultGridPosition;
    private CarModel forcedCarModel;
    private int overrideDriverInfo; //is a boolean, only 0 and 1
    private int isServerAdmin; //is a boolean, only 0 and 1
}
