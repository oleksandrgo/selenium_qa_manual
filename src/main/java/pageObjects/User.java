package pageObjects;

public class User {
    private String firstName = "Test";
    private String lastName = "Test";
    private String email;
    private String password = "Test!123";
    private  String mileage = "1";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getRandomEmail(){
        return  this.email = "test" + randomData() + "@gmail.com";
    }

    public String getMileage(){
      return this.mileage;
    }


    private  int randomData() {
        return (int) ((Math.random() * 100000));
    }
}
