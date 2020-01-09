package recipefinder.recipefinder.model;

public class User {

    private int id;
    private String name;
    private int age;
    private String location;

    private UserCredentials userCredentials;

    public User() { this.userCredentials = new UserCredentials("dummy", "dummy"); }
    public User(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public int getId() {  return id;  }

    public void setId(int id) {  this.id = id;  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }
}
