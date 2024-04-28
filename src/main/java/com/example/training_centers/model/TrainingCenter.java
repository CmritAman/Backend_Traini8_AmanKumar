package com.example.training_centers.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name="training_centers")
public class TrainingCenter
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "center_name", length = 40, nullable = false)
    private String centerName;

    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be alphanumeric and exactly 12 characters long")
    @Column(name = "center_code", length = 12, nullable = false)
    private String centerCode;

    @Embedded
    private Address address;

    @Column(name = "student_capacity",nullable = false)
    private Integer studentCapacity;

    @ElementCollection
    @Column(name = "courses_offered")
    private List<String> coursesOffered;

    @Column(name = "created_on",nullable = false)
    private Long createdOn=System.currentTimeMillis();

    @Email(message = "Invalid email format")
    @Column(name = "contact_email",nullable = false)
    private String contactEmail;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
    @Column(name="contact_phone",nullable = false)
    private String contactPhone;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public List<String> getCourses_offered() {
        return coursesOffered;
    }

    public void setCourses_offered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public Integer getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(Integer studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public TrainingCenter(String centerName, String centerCode, Address address, Integer studentCapacity,
                          List<String> coursesOffered, Long createdOn, String contactEmail, String contactPhone)
    {
        this.centerName = centerName;
        this.centerCode = centerCode;
        this.address = address;
        this.studentCapacity = studentCapacity;
        this.coursesOffered = coursesOffered;
        this.createdOn = createdOn;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public TrainingCenter()
    {

    }

    @Override
    public String toString() {
        return "TrainingCenter [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode + ",address="+address+", capacity="
                + studentCapacity + ", course=" + coursesOffered + ", createdOn=" + createdOn
                + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone + "]";
    }
}