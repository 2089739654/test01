package pojo;

import java.util.Properties;

public class Port {
    private Integer index;
    private String port_name;
    private String container_id;
    private String container_size;
    private String lading_id;
    private String container_yard;
    private String action;
    private String action_date;


    public Port(Integer index, String port_name, String container_id, String container_size, String lading_id, String container_yard, String action, String action_date) {
        this.index = index;
        this.port_name = port_name;
        this.container_id = container_id;
        this.container_size = container_size;
        this.container_yard = container_yard;
        this.lading_id = lading_id;
        this.action = action;
        this.action_date = action_date;
    }

    public Port() {
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getPort_name() {
        return port_name;
    }

    public void setPort_name(String port_name) {
        this.port_name = port_name;
    }

    public String getContainer_id() {
        return container_id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }

    public String getContainer_size() {
        return container_size;
    }

    public void setContainer_size(String container_size) {
        this.container_size = container_size;
    }

    public String getContainer_yard() {
        return container_yard;
    }

    public void setContainer_yard(String container_yard) {
        this.container_yard = container_yard;
    }

    public String getLading_id() {
        return lading_id;
    }

    public void setLading_id(String lading_id) {
        this.lading_id = lading_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction_date() {
        return action_date;
    }

    public void setAction_date(String action_date) {
        this.action_date = action_date;
    }

    @Override
    public String toString() {
        return "Port{" +
                "index=" + index +
                ", port_name='" + port_name + '\'' +
                ", container_id='" + container_id + '\'' +
                ", container_size='" + container_size + '\'' +
                ", lading_id='" + lading_id + '\'' +
                ", container_yard='" + container_yard + '\'' +
                ", action='" + action + '\'' +
                ", action_date='" + action_date + '\'' +
                '}';
    }
}
