package th.ac.ku.restaurant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;;

    private String name;
    private String address;
    private String phone;
    private int numSeats;

    //use in postman => we can use "abc" substitute from "priceRange"
//    @JsonProperty("abc")
//    private int priceRange;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public UUID getId() {
        return id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    //    public int getPriceRange() {
//        return priceRange;
//    }
//
//    public void setPriceRange(int priceRange) {
//        this.priceRange = priceRange;
//    }




}
