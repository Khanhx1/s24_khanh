package furama_resort.models.facility;

import furama_resort.models.facility.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private Double poolArea;
    private Integer numberOfFloors;

   public Villa(String codeService, String nameService, Double usageArea, Long rentalCost, Integer maximumPeople, String typeOfRental, String roomStandard, Double poolArea, Integer numberOfFloors) {
       super(codeService, nameService, usageArea, rentalCost, maximumPeople,typeOfRental);
       this.roomStandard = roomStandard;
       this.poolArea = poolArea;
       this.numberOfFloors = numberOfFloors;
   }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "codeService='" + super.getCodeService() + '\'' +
                ", nameService='" + super.getNameService() + '\'' +
                ", usageArea=" + super.getUsageArea() +
                ", rentalCost=" + super.getRentalCost() +
                ", maximumPeople=" + super.getMaximumPeople() +
                ", typeOfRental='" + super.getTypeOfRental() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
