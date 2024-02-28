package furama_resort.repositories;

import furama_resort.models.facility.Facility;
import furama_resort.models.facility.House;
import furama_resort.models.facility.Room;
import furama_resort.models.facility.Villa;

import java.util.Map;

public interface IFacilityRepository extends IRepository {

    void addVilla(Villa villa);

    void addHouse(House house);

    void addRoom(Room room);

    Map<Facility, Integer> findAllMap();

    void remove(String removeFacility);

    Facility findByCodeMap(String codeFacility);

    Map<Facility, Integer> showMaintenance();
}
