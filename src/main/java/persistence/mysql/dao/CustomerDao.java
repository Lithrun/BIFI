package persistence.mysql.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Klant")
public class CustomerDao {

    @Id
    @Column(name="KlantID")
    private int id;

    @Column(name="Bedrijfsnaam")
    private String companyName;

    @Column(name="Rechtsvorm")
    private String salutation;

    @Column(name="VAT")
    private String vatNumber;

    @Column(name="BankRek")
    private String iban;

    @Column(name="Giro")
    private String giro;

    @Column(name="Bik")
    private String bic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KlantID")
    private PersonDao person;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "KlantID")
    private List<AddressDao> addresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public PersonDao getPerson() {
        return person;
    }

    public void setPerson(PersonDao person) {
        this.person = person;
    }

    public List<AddressDao> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDao> addresses) {
        this.addresses = addresses;
    }
}
