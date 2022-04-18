package HomeWork_Java_lvl_2;

public class Person {

    private String lastname;
    private String phone;

    public Person(String lastname, String phone) {
        this.lastname = lastname;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
