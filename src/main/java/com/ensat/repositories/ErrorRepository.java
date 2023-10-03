package com.ensat.repositories;

import com.ensat.entities.Error;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

public interface ErrorRepository extends JpaRepository<Error, Integer> {

}
