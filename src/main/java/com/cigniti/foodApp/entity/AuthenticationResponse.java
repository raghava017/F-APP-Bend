package com.cigniti.foodApp.entity;

import java.io.Serializable;
import java.util.Optional;


@SuppressWarnings("serial")
public class AuthenticationResponse implements Serializable {

    private final String accessToken;
    private final Optional<User> user;

    public AuthenticationResponse(String accessToken,Optional<User> user2 ) {
        this.accessToken = accessToken;
        this.user = user2;
    }

    public String getAccessToken() {
        return accessToken;
    }
    
    public Optional<User> getUser(){
    	return user;
    }
}
