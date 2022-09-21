package com.blogapp.main.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	  
	@NotNull
	@NotEmpty
	@Size(min = 4,message = "username must be atleast 4 characters")
	private String name;
	@Email(message = "Email Address Not Valid")
	private String email;
	@Size(min = 4,max = 12, message = "Entered Password should be from 4 to 12 characters")
	@NotEmpty
	private String password;
	@NotNull(message = "About cannot be blank")
	private String about;
}
