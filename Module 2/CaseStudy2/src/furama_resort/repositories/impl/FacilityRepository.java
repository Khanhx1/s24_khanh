package furama_resort.repositories.impl;


import furama_resort.models.facility.Facility;
import furama_resort.models.facility.House;
import furama_resort.models.facility.Room;
import furama_resort.models.facility.Villa;
import furama_resort.repositories.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private Map<Facility,Integer> facilityIntegerMap = new LinkedHashMap<>();

    @Override
    public void addVilla(Villa villa) {
        facilityIntegerMap.put(villa,0);
    }

    @Override
    public void addHouse(House house) {
        facilityIntegerMap.put(house, 0);
    }

    @Override
    public void addRoom(Room room) {
        facilityIntegerMap.put(room, 0);
    }

    @Override
    public Map<Facility, Integer> findAllMap() {
       return facilityIntegerMap;
    }

    @Override
    public void remove(String removeFacility) {
        for (Facility key : facilityIntegerMap.keySet()) {
            if(key.getCodeService().equalsIgnoreCase(removeFacility)){
                facilityIntegerMap.remove(key);
                break;
            }
        }
    }

    @Override
    public Facility findByCodeMap(String codeFacility) {
        for (Facility key : facilityIntegerMap.keySet()){
            if(key.getCodeService().equalsIgnoreCase(codeFacility)){
                return key;
            }
        }
        return null;
    }

    @Override
    public Map<Facility, Integer> showMaintenance() {
        Map<Facility, Integer> maintenanceMap = new LinkedHashMap<>();
        for (Facility key : facilityIntegerMap.keySet()){
            if(facilityIntegerMap.get(key) > 5) {
              maintenanceMap.put(key, 0);
            }
        }
        return maintenanceMap;
    }
}
