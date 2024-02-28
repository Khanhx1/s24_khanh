package furama_resort.utils.exception;

public class FacilityCondition {
    public boolean checkAreaGreaterThan30(Double area) {
        if (area > 30) {
            return true;
        }
        return false;
    }
    public boolean checkRentalCost(Long cost){
        if(cost > 0) {
            return true;
        }
        return false;
    }
    public boolean checkMaximumPeople(Integer people) {
        if(people > 0 && people < 20) {
            return true;
        }
        return false;
    }
    public boolean checkFloors(Integer floor) {
        if(floor > 0) {
            return true;
        }
        return false;
    }
}
