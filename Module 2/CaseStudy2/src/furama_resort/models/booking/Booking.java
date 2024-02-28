package furama_resort.models.booking;

public class Booking {
private String bookingCode;
private String dateOfBooking;
private String startDate;
private String endDate;
private String customerCode;
private String serviceCode;

    public Booking() {
    }

    public Booking(String bookingCode, String dateOfBooking, String startDate, String endDate, String customerCode, String serviceCode) {
        this.bookingCode = bookingCode;
        this.dateOfBooking = dateOfBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.serviceCode = serviceCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(String dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", dateOfBooking='" + dateOfBooking + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                '}';
    }
}
