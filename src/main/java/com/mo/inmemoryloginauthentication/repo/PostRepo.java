
package com.mo.inmemoryloginauthentication.repo;

import com.mo.inmemoryloginauthentication.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {
}

