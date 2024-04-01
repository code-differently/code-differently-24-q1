package com.codedifferently.lesson14.service;

import com.codedifferently.lesson14.models.LibraryUserModel;
import com.codedifferently.lesson14.repository.LibraryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryUserService {

  @Autowired LibraryUserRepository libraryUserRepository;

  public void addUser(LibraryUserModel libraryUserModel) {
    libraryUserRepository.save(libraryUserModel);
  }

  public Iterable<LibraryUserModel> findAllUsers() {
    return libraryUserRepository.findAll();
  }
}
