package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.MediaItem;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetMediaItemsResponse {
  private List<MediaItem> items;
}
