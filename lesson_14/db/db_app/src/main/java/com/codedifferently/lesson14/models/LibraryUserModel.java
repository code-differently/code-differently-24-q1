package com.codedifferently.lesson14.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author vscode
 */
@Entity
@Table(name = "library_users")
public class LibraryUserModel {
  @Id private String id;

  private String email;
  private String firstName;
  private String lastName;
  private String password;

  public LibraryUserModel(
      UUID id, String email, String firstName, String lastName, String password) {
    this.id = id.toString();
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    hashAndSetPassword(password);
  }

  public UUID getId() {
    return UUID.fromString(id);
  }

  public void setId(UUID id) {
    this.id = id.toString();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void hashAndSetPassword(String password) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] passwordBytes = password.getBytes();
      byte[] hashedBytes = digest.digest(passwordBytes);

      StringBuilder hexString = new StringBuilder();
      for (byte b : hashedBytes) {
        hexString.append(String.format("%02x", b));
      }

      this.password = hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }
}
