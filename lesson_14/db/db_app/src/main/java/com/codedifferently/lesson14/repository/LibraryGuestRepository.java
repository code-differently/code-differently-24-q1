package com.codedifferently.lesson14.repository;

import com.codedifferently.lesson14.models.LibraryGuestModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LibraryGuestRepository extends CrudRepository<LibraryGuestModel, String> {
  @Override
  List<LibraryGuestModel> findAll();
}
