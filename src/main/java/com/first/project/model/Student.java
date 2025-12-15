package com.first.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity //jpa dependency - mahrizim sha osim tabla, shema shel database
@Table(name="student")  // ma shem shel tabla
@Getter @Setter @AllArgsConstructor //lombok - getter, setter and constructor /что бы работала на весь класс анотация
// должна быть над классом
public class Student implements Serializable {  //Serializable - interface movna
    private static final long serialVersionUID = 1L; // iotcer meshtane shaishmor

    //cdai sha annotacia iavod rak lmeshatane tzaric lasim oto meal meshtane
    @Id //jpa annotation mgdirim id
    @GeneratedValue(strategy= GenerationType.AUTO)// eutzer id automaty
    private Long id;

    //hibernate- validation dependency
    @NotEmpty //yosa bdika sha sade lo rek / oved rak al string
    @Length(max = 30) //oreh maximaly 30 tavim
    private String fullName;
    ///////////////////////////////////////////////////////////////
    @Min(100) //tzun minimum 100 and maximum 800
    @Max(800)
    private Integer psycoScore;
    ///////////////////////////////////////////////////////////////
    @Min(30)
    @Max(100)
    private Double graduationScore;
    ///////////////////////////////////////////////////////////////
    @Length(max = 10)
    private String phone;
    ///////////////////////////////////////////////////////////////
    @Length(max = 500)
    private String profilePicture;

    public Student(){}

    public Student(String fullName, Integer psycoScore, Double graduationScore, String phone, String profilePicture) {
        this.fullName = fullName;
        this.psycoScore = psycoScore;
        this.graduationScore = graduationScore;
        this.phone = phone;
        this.profilePicture = profilePicture;
    }
}