package com.codedifferently.lesson14.repository;

import com.codedifferently.lesson14.models.LibraryUserModel;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface LibraryUserRepository extends CrudRepository<LibraryUserModel, UUID> {
}
