package furama_resort.models.facility;

import furama_resort.models.facility.Facility;

public class House extends Facility {
    private String roomStandard;
    private Integer numberOfFloors;
    public House(String codeService, String nameService, Double usageArea, Long rentalCost, Integer maximumPeople, String typeOfRental, String roomStandard, Integer numberOfFloors) {
        super(codeService, nameService, usageArea, rentalCost, maximumPeople,typeOfRental);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "codeService='" + super.getCodeService() + '\'' +
                ", nameService='" + super.getNameService() + '\'' +
                ", usageArea=" + super.getUsageArea() +
                ", rentalCost=" + super.getRentalCost() +
                ", maximumPeople=" + super.getMaximumPeople() +
                ", typeOfRental='" + super.getTypeOfRental() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
