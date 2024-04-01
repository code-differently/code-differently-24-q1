package com.codedifferently.lesson14.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "library_user")
public class LibraryUserModel {
   @Id public UUID userID;
    public String email;
    public String firstName;
    public String lastName;
    public String password;
}
