package jp.co.web.attendance.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="DEPARTMENTCD")
	private String departmentcd;

    @Column(name="DEPARTMENTNM")
	private String departmentnm;

}
