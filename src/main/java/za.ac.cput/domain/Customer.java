package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Customer implements Serializable {
    @Id
    private String customerId;
    private String privileges;

    private String userID;



    @OneToMany(mappedBy = "customerID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders;


    public Customer() {
    }

    private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.privileges = builder.privileges;
        this.userID = builder.userID;
        this.orders = builder.orders;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }



    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        if (customerId != null ? !customerId.equals(customer.customerId) : customer.customerId != null) return false;
        if (privileges != null ? !privileges.equals(customer.privileges) : customer.privileges != null) return false;
        return userID != null ? userID.equals(customer.userID) : customer.userID == null;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (privileges != null ? privileges.hashCode() : 0);
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", privileges='" + privileges + '\'' +
                ", userID='" + userID + '\'' +
                ", orders=" + orders +
                '}';
    }

    public static class Builder {
        private String customerId;
        private String privileges;
        private String userID;
        private List<Orders> orders;

        public Builder setCustomerId(String  customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setPrivileges(String privileges) {
            this.privileges = privileges;
            return this;
        }

        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public Builder setOrders(List<Orders> orders) {
            this.orders = orders;
            return this;
        }

        public  Builder copy(Customer customer) {
            this.customerId = customer.customerId;
            this.privileges = customer.privileges;
            this.userID = customer.userID;
            this.orders = customer.orders;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
