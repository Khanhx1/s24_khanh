package furama_resort.models.facility;

public abstract class Facility {
private String codeService;
private String nameService;
private Double usageArea;
private Long rentalCost;
private Integer maximumPeople;
private String typeOfRental;

    public Facility() {
    }

    public Facility(String codeService, String nameService, Double usageArea, Long rentalCost, Integer maximumPeople, String typeOfRental) {
        this.codeService = codeService;
        this.nameService = nameService;
        this.usageArea = usageArea;
        this.rentalCost = rentalCost;
        this.maximumPeople = maximumPeople;
        this.typeOfRental = typeOfRental;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Double getUsageArea() {
        return usageArea;
    }

    public void setUsageArea(Double usageArea) {
        this.usageArea = usageArea;
    }

    public Long getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(Long rentalCost) {
        this.rentalCost = rentalCost;
    }

    public Integer getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(Integer maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    public String getTypeOfRental() {
        return typeOfRental;
    }

    public void setTypeOfRental(String typeOfRental) {
        this.typeOfRental = typeOfRental;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "codeService='" + codeService + '\'' +
                ", nameService='" + nameService + '\'' +
                ", usageArea=" + usageArea +
                ", rentalCost=" + rentalCost +
                ", maximumPeople=" + maximumPeople +
                ", typeOfRental='" + typeOfRental + '\'' +
                '}';
    }
}
