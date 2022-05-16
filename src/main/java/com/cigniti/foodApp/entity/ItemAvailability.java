package com.cigniti.foodApp.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itemavailability")
public class ItemAvailability {

	@Id
	@Column(name = "itemAvailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int itemAvailId;

	@Column(name = "itemId")
	@Getter
	@Setter
	private int itemId;

	@Column(name = "restId")
	@Getter
	@Setter
	private int restId;

	@Column(name = "itemStatus")
	@Getter
	@Setter
	private String itemStatus;

	@Column(name = "logId")
	@Getter
	@Setter
	private String logId;

	@Column(name = "sysTime")
	@Getter
	@Setter
	private String sysTime;

	@Column(name = "ipAddress")
	@Getter
	@Setter
	private String ipAddress;

	@ManyToOne(targetEntity = Item.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "itemId", insertable = false, updatable = false)
	private Item item;

	@ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "restId", insertable = false, updatable = false)
	private Restaurant restaurant;

}
