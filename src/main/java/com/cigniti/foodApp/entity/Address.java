package com.cigniti.foodApp.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")

public class Address {
    @Id
    @Column(name = "addressId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int addressId;
    @Getter @Setter
    @Column(name = "fullname")
    private String fullname ;
    @Getter @Setter
    @Column(name = "number")
    private String number;
    @Getter @Setter
    @Column(name = "city")
    private String city;
    @Getter @Setter
    @Column(name = "state")
    private String state ;
    @Getter @Setter
    @Column(name = "pincode")
    private Integer pincode;
    @Getter @Setter
    @Column(name = "houseno")
    private String houseno;
    @Getter @Setter
    @Column(name = "landmark")
    private String landmark ;
    @Getter @Setter
    @Column(name = "addresstype")
    private String addresstype;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;



}