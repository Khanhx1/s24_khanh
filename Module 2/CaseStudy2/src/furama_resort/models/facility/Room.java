package furama_resort.models.facility;

import furama_resort.models.facility.Facility;

public class Room extends Facility {
    private String complimentaryService;

    public Room(String codeService, String nameService, Double usageArea, Long rentalCost, Integer maximumPeople, String typeOfRental, String complimentaryService) {
        super(codeService, nameService, usageArea, rentalCost, maximumPeople, typeOfRental);
        this.complimentaryService = complimentaryService;
    }

    public String getComplimentaryService() {
        return complimentaryService;
    }

    public void setComplimentaryService(String complimentaryService) {
        this.complimentaryService = complimentaryService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "codeService='" + super.getCodeService() + '\'' +
                ", nameService='" + super.getNameService() + '\'' +
                ", usageArea=" + super.getUsageArea() +
                ", rentalCost=" + super.getRentalCost() +
                ", maximumPeople=" + super.getMaximumPeople() +
                ", typeOfRental='" + super.getTypeOfRental() + '\'' +
                ", complimentaryService='" + complimentaryService + '\'' +
                '}';
    }
}
