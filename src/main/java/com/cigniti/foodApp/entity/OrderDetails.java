package com.cigniti.foodApp.entity;


import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetails {
	
	@Id
	@Column(name = "orderDetailsId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int orderDetailsId;
	
	@Column(name = "orderId")
	@Getter @Setter
	private int orderId;
	
	@Column(name = "quantity")
	@Getter @Setter
	private Integer quantity;
	
	@Column(name = "itemId")
	@Getter @Setter
	private int itemId;
	
	@Column(name = "unitPrice")
	@Getter @Setter
	private Double unitPrice;
	
	@Column(name = "logId")
	@Getter @Setter
	private String logId;
	
	@Column(name = "sysTime")
	@Getter @Setter
	private String sysTime;
	
	@Column(name = "ipAddress")
	@Getter @Setter
	private String ipAddress;
	
	@ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Order order;
	
	@ManyToOne(targetEntity = Item.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "itemId", insertable = false, updatable = false)
	private Item item;

}
