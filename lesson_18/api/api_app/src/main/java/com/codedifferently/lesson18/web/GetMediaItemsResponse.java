package com.codedifferently.lesson18.web;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class GetMediaItemsResponse {
  @Singular private List<MediaItemResponse> items;
}
