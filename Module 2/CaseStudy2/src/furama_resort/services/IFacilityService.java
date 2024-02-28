package furama_resort.services;

import furama_resort.models.facility.Facility;
import furama_resort.models.facility.House;
import furama_resort.models.facility.Room;
import furama_resort.models.facility.Villa;

import java.util.Map;

public interface IFacilityService extends IService<Facility> {

    void addVilla(Villa villa);

    void addHouse(House house);

    void addRoom(Room room);

    Map<Facility, Integer> findAllMap();

    void removeMap(String removeFacility);

    Facility findByCodeMap(String codeFacility);

    Map<Facility, Integer> showMaintenance();
}
