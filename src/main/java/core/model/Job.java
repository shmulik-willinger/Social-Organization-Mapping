package core.model;

import javax.persistence.*;
import java.text.DateFormat;

@Entity
@Table(name = "job")
public class Job
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer job_id;

    @Column(name = "start_date")
    private DateFormat StartDate;

    @Column(name = "end_date")
    private DateFormat EndDate;

    @Column(name = "company_id")
    private int CompanyId;

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public DateFormat getStartDate() {
        return StartDate;
    }

    public void setStartDate(DateFormat startDate) {
        StartDate = startDate;
    }

    public DateFormat getEndDate() {
        return EndDate;
    }

    public void setEndDate(DateFormat endDate) {
        EndDate = endDate;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int companyId) {
        CompanyId = companyId;
    }
}
