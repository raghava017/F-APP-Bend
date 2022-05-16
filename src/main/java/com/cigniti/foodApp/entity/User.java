package com.cigniti.foodApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int userId;
	
	@Column(name = "firstName")
	@Getter @Setter
	private String firstName;

	@Column(name = "lastName")
	@Getter @Setter
	private String lastName;

	@Column(name = "email")
	@Getter @Setter
	private String email;

	@Column(name = "address")
	@Getter @Setter
	private String address;

	@Column(name = "phoneNumber")
	@Getter @Setter
	private String phoneNumber;

	@Column(name = "userName")
	@Getter @Setter
	private String userName;

	@Column(name = "password")
	@Getter @Setter
	private String password;

	@Column(name = "logId")
	@Getter @Setter
	private String logId;

	@Column(name = "sysTime")
	@Getter @Setter
	private String sysTime;

	@Column(name = "ipAddress")
	@Getter @Setter
	private String ipAddress;

	@Column(name = "status")
	@Getter @Setter
	private String status;

	@ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "restId", insertable = false, updatable = false)
	private Restaurant restaurant;

	@Column(name = "restId")
	@Getter @Setter
	private int restId;

	@Column(name = "role")
	@Getter @Setter
	private String role;
	
	@OneToMany(mappedBy = "user")
	private Set<Order> orders;
	
	@OneToMany(mappedBy = "user")
	private Set<Payment> payments;

}
