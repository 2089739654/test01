package pojo;

public class User {
    private Integer index;
    private String name;
    private String id;
    private String phone;
    private String address;
    private String password;

    public User(Integer index, String name, String id, String phone, String address, String password) {
        this.index = index;
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public User() {
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
