package com.boilerplate.dto;

import com.boilerplate.domain.Authority;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO
{
    Long id;
    String name;
    String surname;
    String userName;
    String password;

    List<BookDTO> books;
    List<Authority> authorities;
}
