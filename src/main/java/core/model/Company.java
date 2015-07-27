package core.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer company_id;

    @Column(name = "company_name")
    private String name;

  /*  @OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Address> address;*/

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
