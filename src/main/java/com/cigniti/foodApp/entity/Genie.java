
package com.cigniti.foodApp.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genie")

public class Genie {
    @Id
    @Column(name = "genieId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int genieId;

    @Column(name = "pickupAddress")
    @Getter @Setter
    private String pickupAddress;

    @Column(name = "dropAddress")
    @Getter @Setter
    private String dropAddress;

    @Column(name = "phoneNumber")
    @Getter @Setter
    private String phoneNumber;

    @Column(name = "taskDetails")
    @Getter @Setter
    private String taskDetails;

    @Column(name = "description")
    @Getter @Setter
    private String description;


}