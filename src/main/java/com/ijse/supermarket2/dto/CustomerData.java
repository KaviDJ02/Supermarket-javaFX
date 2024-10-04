package com.ijse.supermarket2.dto;

public class CustomerData {
    private String customerId;
    private String name;
    private String nic;
    private String email;
    private String phone;

    public CustomerData(String customerId, String name, String nic, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}