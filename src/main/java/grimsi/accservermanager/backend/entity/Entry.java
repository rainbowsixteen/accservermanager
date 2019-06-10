package grimsi.accservermanager.backend.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Entry {
    private int configVersion = 0;
    private List<Driver> drivers;
    private String customCar;
    private int raceNumber;
    private int defaultGridPosition;
    private int forcedCarModel;
    private int overrideDriverInfo;
    private int isServerAdmin;
}
