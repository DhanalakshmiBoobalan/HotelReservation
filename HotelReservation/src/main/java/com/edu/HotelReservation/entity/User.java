package com.edu.HotelReservation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="userTbl")

public class User {
	
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "seq", initialValue = 11)
	
	private long userId;
	@Column(nullable = false)
	
	@NotNull
	@NotBlank(message = "First name is Mandatory")
	private String firstName;
	@Column(nullable = false)
	@NotBlank(message = "Last name is Mandatory")
	private String lastName;
	
	@Column(nullable = false)
	@Size(min=10,max=17)
	@NotBlank(message = "Contact number should be between 10 and 17")
	private String contactNo;
	@Column(nullable = false)
	@NotBlank(message = "Aadhar Number is Mandatory")
	private String aadharNo;
	
	@Column(nullable = false)
	@NotBlank(message = "User Name is Mandatory")
	private String userName;
	@Column(nullable = false)
	@Size(min = 5, message = "Atleast 5 charters is Mandatory for Password")
	private String password;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Email is Mandatory")
	@Email(message = "Invalid Email id")
	private String emailId;
	@Column(nullable = false)
	@NotBlank(message = "Address is Mandatory")
	private String fullAddress;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("user")
	private List<Reservation> reservation;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public User(long userId, String firstName, String lastName, String contactNo, String aadharNo, String userName,
			String password, String emailId, String fullAddress) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.aadharNo = aadharNo;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.fullAddress = fullAddress;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo="
				+ contactNo + ", aadharNo=" + aadharNo + ", userName=" + userName + ", password=" + password
				+ ", emailId=" + emailId + ", fullAddress=" + fullAddress + "]";
	}
	
}
	