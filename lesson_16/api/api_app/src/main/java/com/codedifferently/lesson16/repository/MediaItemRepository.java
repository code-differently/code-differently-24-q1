package com.codedifferently.lesson16.repository;

import com.codedifferently.lesson16.models.MediaItemModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface MediaItemRepository extends CrudRepository<MediaItemModel, UUID> {
  @Override
  List<MediaItemModel> findAll();
}
