package com.codedifferently.lesson18.library;

import com.codedifferently.lesson18.factory.LibraryDbDataLoader;
import com.codedifferently.lesson18.factory.LibraryFactory;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfiguration {

  @Bean
  public Library getDefaultLibrary(LibraryDbDataLoader loader) throws IOException {
    return LibraryFactory.createWithLoader(loader);
  }
}
