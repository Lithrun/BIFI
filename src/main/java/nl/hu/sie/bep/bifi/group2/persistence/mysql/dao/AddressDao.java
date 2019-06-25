package nl.hu.sie.bep.bifi.group2.persistence.mysql.dao;

import javax.persistence.*;

@Entity
@Table(name="Adres")
public class AddressDao {

    @Id
    @Column(name="AdresID")
    private int id;

    @Column(name="Straat")
    private String street;

    @Column(name="Type")
    private char type;

    @Column(name="Huisnummer")
    private Integer streetNumber;

    @Column(name="postcode")
    private String zipCode;

    @Column(name="Plaats")
    private String city;

    @Column(name="BIC")
    private String bic;

    @JoinColumn(name="KlantID", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private CustomerDao customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public CustomerDao getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDao customer) {
        this.customer = customer;
    }
}
