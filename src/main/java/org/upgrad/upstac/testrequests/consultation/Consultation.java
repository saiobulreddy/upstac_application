package org.upgrad.upstac.testrequests.consultation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Consultation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private TestRequest request;

    private DoctorSuggestion suggestion;
//
//    public TestRequest getRequest() {
//        return request;
//    }
//
//    public DoctorSuggestion getSuggestion() {
//        return suggestion;
//    }
//
//    public String getComments() {
//        return comments;
//    }

    public LocalDate getUpdatedOn() {
        return updatedOn;
    }

    public User getDoctor() {
        return doctor;
    }

    private String comments;

    private LocalDate updatedOn;

    @ManyToOne
    User doctor;









}
