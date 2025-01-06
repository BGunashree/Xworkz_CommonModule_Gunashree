package com.xworkz.xworkzCommonModuleGunashreeB.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="user_details_table")
@Data
@NoArgsConstructor

@NamedQuery(name="check" , query ="select count(*) from UserEntity ue where ue.name =:ByName and ue.password =:ByPassword")
@NamedQuery(name="updateDetails", query="update UserEntity ue set ue.email =:setEmail, ue.phone =:setPhone, ue.alternateEmail =:setAltEmail, ue.alternatePhone =:setAltPhone, ue.location =:setLocation ,ue.updatedBy =:setUpdatedName, ue.updatedDate =:setUpdatedDate, ue.filePath =:setFilePath where ue.name =:byName")
@NamedQuery(name="countName" , query ="select count(*) from UserEntity ue where ue.name =:ByName")
@NamedQuery(name="countEmail" , query ="select count(*) from UserEntity ue where ue.email =:ByEmail")
@NamedQuery(name="countPhone" , query ="select count(*) from UserEntity ue where ue.phone =:ByPhone")
@NamedQuery(name="countAltEmail" , query ="select count(*) from UserEntity ue where ue.alternateEmail =:ByAltEmail")
@NamedQuery(name="countAltPhone" , query ="select count(*) from UserEntity ue where ue.alternatePhone =:ByAltPhone")
@NamedQuery(name="getAllByEmail",query="select ue from UserEntity ue where ue.email =:ByEmail")
@NamedQuery(name="updatePassword", query ="update UserEntity ue set ue.password =:SetPassword, ue.loginCount =:SetLoginCount where ue.name =:ByName")
@NamedQuery(name="getAllByName", query="select ue from UserEntity ue where ue.name =:ByName")
@NamedQuery(name="getAll",query="select ue from UserEntity ue where ue.email =:ByEmail and ue.password =:ByPassword")

@NamedQuery(name="updateLoginCount",query="update UserEntity ue set ue.loginCount =:SetLoginCount where ue.email =:byEmail")


@NamedQuery(name="resetLoginCount",query="update UserEntity ue set ue.loginCount =:SetLoginCount where ue.email =:byEmail")
public class UserEntity extends AbstractAuditEntity {


    @Id
    @GenericGenerator(name = "yourName" , strategy = "increment")
    @GeneratedValue(generator = "yourName")

    private int id;
    @Column(name="user_name")
    private String name;
    private String email;
    private long phone;
    @Column(name="alternate_email")
    private String alternateEmail;
    @Column(name="alternate_phone")
    private long alternatePhone;
    private String location;
    @Column(name="user_password")
    private String password;
    @Column(name="login_count")
    private int loginCount;
}



































/*function onEmail(){
    console.log('this is user name');
    var userEmail=document.getElementById('email');
    var userValue=userEmail.value;

    var xhttp =new XMLHttpRequest();
    xhttp.open("GET","http://localhost:8082/Xworkz_CommonModule_GunashreeB/email/"+userValue);
    xhttp.send();

    xhttp.onload =function(){
        document.getElementById("displayEmail").innerHTML = this.responseText;
    }
}*/