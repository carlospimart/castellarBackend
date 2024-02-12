package com.castellar.carlos.picon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    List<Users> findByUsername(String username);
    Users findOnlyByUsername(String username);
}
