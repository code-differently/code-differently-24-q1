package com.codedifferently.lesson18.library;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryInfo {
  public String id;
  public Set<MediaItem> items;
  public Set<LibraryGuest> guests;
  public Map<UUID, Set<MediaItem>> checkedOutItemsByGuest;
}
