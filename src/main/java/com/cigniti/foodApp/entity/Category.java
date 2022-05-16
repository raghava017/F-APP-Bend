package com.cigniti.foodApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	@Getter @Setter
	private int categoryId;

	@Column(name = "categoryName")
	@Getter @Setter
	private String categoryName;

	@Column(name = "logId")
	@Getter @Setter
	private String logId;

	@Column(name = "sysTime")
	@Getter @Setter
	private String sysTime;

	@Column(name = "ipAddress")
	@Getter @Setter
	private String ipAddress;
	
	@OneToMany(mappedBy = "category")
	private Set<Item> items;

}
