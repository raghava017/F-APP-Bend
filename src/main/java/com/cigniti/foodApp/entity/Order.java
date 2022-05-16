package com.cigniti.foodApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int orderId;
	
	@Column(name = "userId")
	@Getter @Setter
	private int userId;
	
	@Column(name = "orderDate")
	@Getter @Setter
	private String orderDate;
	
	@Column(name = "description")
	@Getter @Setter
	private String description;
	
	@Column(name = "logId")
	@Getter @Setter
	private String logId;
	
	@Column(name = "sysTime")
	@Getter @Setter
	private String sysTime;
	
	@Column(name = "ipAddress")
	@Getter @Setter
	private String ipAddress;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private User user;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderDetails> orderDetails;
	
	@OneToMany(mappedBy = "order")
	private Set<Payment> payments;

}
