package com.zain.shortcode.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * 
 * @author m.sabon
 *
 */

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DataTablesOutput.View.class)
	private long ID;

	@JsonView(DataTablesOutput.View.class)
	private String userName;

	@JsonView(DataTablesOutput.View.class)
	private String fullName;

	@JsonView(DataTablesOutput.View.class)
	private long status;

	@JsonView(DataTablesOutput.View.class)
	private String email;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "role_id", referencedColumnName = "ID")
	@JsonView(DataTablesOutput.View.class)

	private Roles role;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + ID + ", userName=" + userName + ", email=" + email + ", fullName=" + fullName
				+ ", status=" + status + ", role=" + role + "]";
	}

}
