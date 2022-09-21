package com.blogapp.main.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	// We create this class so we can only provide some data to the api and hide the rest
	// also we will be able to create more feilds and add some data later on in the user object
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
}
