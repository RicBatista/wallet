package com.wallet.dto;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	@Length(min = 3, max = 75, message = "O Nome deve ter no mínimo 3 caracteres!")
	private String name;
	@NotNull
	@Length(min = 3, max = 8, message = "A senha deve ter no mínimo 3 caracteres!")
	private String password;
	@Email(message = "Email inválido")
	private String email;

}
