package furama_resort.models.person;

public class Employee extends Person{
    private String employeeCode;
    private String education;
    private String position;
    private Long salary;

    public Employee(String name, String dateOfBirth, String gender, String identificationCard, String phoneNumber, String email, String employeeCode, String education, String position, Long salary) {
        super(name, dateOfBirth, gender, identificationCard, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.education = education;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + super.getName() + '\'' +
                ", dateOfBirth='" + super.getDateOfBirth() + '\'' +
                ", gender='" + super.getGender() + '\'' +
                ", identificationCard='" + super.getIdentificationCard() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", education='" + education + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
