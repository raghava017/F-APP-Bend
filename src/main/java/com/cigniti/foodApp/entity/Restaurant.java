package com.cigniti.foodApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restId")
	@Getter
	@Setter
	private int restId;

	@Getter
	@Setter
	@Column(name = "restName")
	private String restName;

	@Getter
	@Setter
	@Column(name = "restOwner")
	private String restOwner;

	@Getter
	@Setter
	@Column(name = "restPhNo")
	private String restPhNo;

	@Getter
	@Setter
	@Column(name = "restAddress")
	private String restAddress;

	@Getter
	@Setter
	@Column(name = "restPincode")
	private String restPincode;

	@Getter
	@Setter
	@Column(name = "rating")
	private Integer rating;

	@Getter
	@Setter
	@Column(name = "logId")
	private String logId;

	@Getter
	@Setter
	@Column(name = "sysTime")
	private String sysTime;

	@Getter
	@Setter
	@Column(name = "ipAddress")
	private String ipAddress;

	@OneToMany(mappedBy = "restaurant")
	private Set<User> users;

	@OneToMany(mappedBy = "restaurant")
	private Set<ItemAvailability> itemsAvalability;

	@OneToMany(mappedBy = "restaurant")
	private Set<Item> items;

}
