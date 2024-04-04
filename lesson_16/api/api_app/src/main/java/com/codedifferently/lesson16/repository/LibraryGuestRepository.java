package com.codedifferently.lesson16.repository;

import com.codedifferently.lesson16.models.LibraryGuestModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LibraryGuestRepository extends CrudRepository<LibraryGuestModel, String> {
  @Override
  List<LibraryGuestModel> findAll();
}
