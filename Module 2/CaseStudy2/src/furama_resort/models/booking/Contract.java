package furama_resort.models.booking;

public class Contract {
private String numberOfContract;
private String bookingCode;
private Long deposit;
private Long totalReceivableAmount;

    public Contract() {
    }

    public Contract(String numberOfContract, String bookingCode, Long deposit, Long totalReceivableAmount) {
        this.numberOfContract = numberOfContract;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalReceivableAmount = totalReceivableAmount;
    }

    public String getNumberOfContract() {
        return numberOfContract;
    }

    public void setNumberOfContract(String numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getTotalReceivableAmount() {
        return totalReceivableAmount;
    }

    public void setTotalReceivableAmount(Long totalReceivableAmount) {
        this.totalReceivableAmount = totalReceivableAmount;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberOfContract='" + numberOfContract + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                ", deposit=" + deposit +
                ", totalReceivableAmount=" + totalReceivableAmount +
                '}';
    }
}
