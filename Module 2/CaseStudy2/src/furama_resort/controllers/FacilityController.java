package furama_resort.controllers;

import furama_resort.models.facility.Facility;
import furama_resort.models.facility.House;
import furama_resort.models.facility.Room;
import furama_resort.models.facility.Villa;
import furama_resort.services.IFacilityService;
import furama_resort.services.impl.FacilityService;

import java.util.Map;

public class FacilityController {
    private IFacilityService facilityService = new FacilityService();

    public void addVilla(Villa villa) {
        facilityService.addVilla(villa);
    }

    public void addHouse(House house) {
        facilityService.addHouse(house);
    }

    public void addRoom(Room room) {
        facilityService.addRoom(room);
    }

    public Map<Facility, Integer> findAllMap() {
        return facilityService.findAllMap();
    }

    public void removeMap(String removeFacility) {
        facilityService.removeMap(removeFacility);
    }

    public Facility findByCodeMap(String codeFacility) {
        return facilityService.findByCodeMap(codeFacility);
    }

    public Map<Facility, Integer> showMaintenance() {
        return facilityService.showMaintenance();
    }
}
