package nl.hu.sie.bep.bifi.group2.persistence.mysql.dao;

import javax.persistence.*;

@Entity
@Table(name="Persoon")
public class PersonDao {

    @Id
    @Column(name="PersoonID")
    private int id;

    @Column(name="Voornaam")
    private String firstName;

    @Column(name="Tussenvoegsel")
    private String insertion;

    @Column(name="Achternaam")
    private String lastName;

    @Column(name="Telefoon")
    private String phoneNumber;

    @Column(name="Fax")
    private String fax;

    @Column(name="Geslacht")
    private char gender;

    @JoinColumn(name="KlantID", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private CustomerDao customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public CustomerDao getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDao customer) {
        this.customer = customer;
    }
}
