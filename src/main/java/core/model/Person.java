package core.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer person_id;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "mail")
    private String Mail;

    @Column(name = "cibus_number")
    private String cibusNumber;

   /* @Column(name = "address")
    private Address address;*/

    @Column(name = "status")
    private String Status;

    @OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Phones> phones;

    @OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Company> companys;

    public Integer getUser_id() {
        return person_id;
    }

    public void setUser_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getCibusNumber() {
        return cibusNumber;
    }

    public void setCibusNumber(String cibusNumber) {
        this.cibusNumber = cibusNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<Phones> getPhones() {
        return phones;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }

    public List<Company> getCompanys() {
        return companys;
    }

    public void setCompanys(List<Company> companys) {
        this.companys = companys;
    }
}
