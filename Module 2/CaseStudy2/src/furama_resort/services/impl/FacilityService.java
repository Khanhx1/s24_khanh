package furama_resort.services.impl;

import furama_resort.models.facility.Facility;
import furama_resort.models.facility.House;
import furama_resort.models.facility.Room;
import furama_resort.models.facility.Villa;
import furama_resort.repositories.IFacilityRepository;
import furama_resort.repositories.impl.FacilityRepository;
import furama_resort.services.IFacilityService;

import java.util.List;
import java.util.Map;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public List<Facility> findAll() {
        return null;
    }

    @Override
    public void add(Facility facility) {
    }

    @Override
    public Facility findByCode(String inputCode) {
        return null;
    }

    @Override
    public void remove(String inputCode) {

    }

    @Override
    public void addVilla(Villa villa) {
        facilityRepository.addVilla(villa);
    }

    @Override
    public void addHouse(House house) {
        facilityRepository.addHouse(house);
    }

    @Override
    public void addRoom(Room room) {
        facilityRepository.addRoom(room);
    }

    @Override
    public Map<Facility, Integer> findAllMap() {
        return facilityRepository.findAllMap();
    }

    @Override
    public void removeMap(String removeFacility) {
        facilityRepository.remove(removeFacility);
    }

    @Override
    public Facility findByCodeMap(String codeFacility) {
        return facilityRepository.findByCodeMap(codeFacility);
    }

    @Override
    public Map<Facility, Integer> showMaintenance() {
        return facilityRepository.showMaintenance();
    }
}
