package pojo;

public class Client {
    private Integer index;
    private String name;
    private String phone;
    private String identity;
    private String id;
    private String company;

    public Client() {
    }

    public Client(Integer index, String name, String phone, String identity, String id, String company) {
        this.index = index;
        this.name = name;
        this.phone = phone;
        this.identity = identity;
        this.id = id;
        this.company = company;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
