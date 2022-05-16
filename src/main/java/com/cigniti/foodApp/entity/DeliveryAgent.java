package com.cigniti.foodApp.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deliveryagent")
public class DeliveryAgent {

	@Id
	@Column(name = "agentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int agentId;

	@Column(name = "agentName")
	@Getter
	@Setter
	private String agentName;

	@Column(name = "agentPhNo")
	@Getter
	@Setter
	private String agentPhNo;

	@Column(name = "agentAddress")
	@Getter
	@Setter
	private String agentAddress;

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

}
