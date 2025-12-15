package com.first.project.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity //jpa dependency - mahrizim sha osim tabla, shema shel database
@Table(name="Employee")  // ma shem shel tabla
@Getter @Setter @AllArgsConstructor //lombok - getter, setter and constructor /что бы работала на весь класс анотация
// должна быть над классом
public class Employee implements Serializable {  //Serializable - interface movna
    private static final long serialVersionUID = 1L; // iotcer meshtane shaishmor
    //cdai sha annotacia iavod rak lmeshatane tzaric lasim oto meal meshtane
    @Id //jpa annotation mgdirim id
    @GeneratedValue(strategy= GenerationType.AUTO)// eutzer id automaty
    private Long id;
    //hibernate- validation dependency
    @NotEmpty //yosa bdika sha sade lo rek / oved rak al string
    @Length(max = 30) //oreh maximaly 30 tavim
    @NotBlank(message = "Name cannot be empty")
    private String fullName;
    ///////////////////////////////////////////////////////////////
    @Min(8000) //min maskoret
    @Max(15000) // max maskoret
    private double salary;
    ///////////////////////////////////////////////////////////////
    @Length(max = 10,min=10)
    private String phone;
    ///////////////////////////////////////////////////////////////
    @Email
    private String email;
    ///////////////////////////////////////////////////////////////
    private String homeAdress;
    ///////////////////////////////////////////////////////////////
    private String position;
    ///////////////////////////////////////////////////////////////
    private  boolean EmployeeStatu;
    ///////////////////////////////////////////////////////////////
    @NotNull
    @PastOrPresent
    private LocalDate hireDate;
    ///////////////////////////////////////////////////////////////
    @Range(min = 18, max = 70, message = "Age valid range is 18-70")
    private int age;
}
