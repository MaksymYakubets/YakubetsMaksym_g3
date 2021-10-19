package model;

public class Account {
    private String gender;
    private String firstCustomerName;
    private String lastCustomerName;
    private String email;
    private String password;
    private String day;
    private String month;
    private String year;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String phoneMobile;
    private String alias;

    public Account(String gender, String firstCustomerName, String lastCustomerName, String email, String password, String day, String month, String year,
                   String firstName, String lastName, String company, String address1, String address2, String city, String state, String postCode,
                   String country, String phoneMobile, String alias) {
        this.gender = gender;
        this.firstCustomerName = firstCustomerName;
        this.lastCustomerName = lastCustomerName;
        this.email = email;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
        this.phoneMobile = phoneMobile;
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstCustomerName() {
        return firstCustomerName;
    }

    public String getLastCustomerName() {
        return lastCustomerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getAlias() {
        return alias;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFirstCustomerName(String firstCustomerName) {
        this.firstCustomerName = firstCustomerName;
    }

    public void setLastCustomerName(String lastCustomerName) {
        this.lastCustomerName = lastCustomerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
