package com.cigniti.foodApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentId")
	@Getter
	@Setter
	private int paymentId;

	@Column(name = "orderId")
	@Getter
	@Setter
	private int orderId;

	@Column(name = "userId")
	@Getter
	@Setter
	private int userId;

	@Column(name = "amount")
	@Getter
	@Setter
	private Double amount;

	@Column(name = "paymentDate")
	@Getter
	@Setter
	private String paymentDate;

	@Column(name = "paymentMethod")
	@Getter
	@Setter
	private String paymentMethod;

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
	private String ipAdddress;

	@ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Order order;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private User user;

}
