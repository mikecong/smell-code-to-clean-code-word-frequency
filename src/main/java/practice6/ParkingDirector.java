package practice6;

import java.util.List;

public class ParkingDirector {
    private final List<ParkingManager> parkingManagerList;

    public ParkingDirector(List<ParkingManager> parkingManager) {
        this.parkingManagerList = parkingManager;
    }

    public String viewReport() {
        String str = "";
        for (ParkingManager parkingManager : parkingManagerList) {
            str += parkingManager.viewReport();
        }
        return str;
    }
}
