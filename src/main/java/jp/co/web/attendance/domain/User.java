package jp.co.web.attendance.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Component
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="USERID")
	private String userid;

    @Column(name="USERNM")
	private String usernm;

    @Column(name="PASSWORD")
	private String password;

    @Column(name="EMPLOYEENO")
	private int employeeno;

    @Column(name="DEPARTMENTCD")
	private String departmentcd;

    @Column(name="DEPARTMENTNM")
	private String departmentnm;

    @Column(name="POSTIONCD")
	private String positioncd;

    @Column(name="POSTIONNM")
	private String positionnm;

    @Column(name="JOINED")
	private String joined;

    @Column(name="AGE")
	private int age;

    @Column(name="POSTALCD")
	private String postalcd;

    @Column(name="ADDRESS")
	private String address;

    @Column(name="TELNO")
	private String telno;

}
