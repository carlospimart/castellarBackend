package com.castellar.carlos.picon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BooksRepository extends JpaRepository<Books, Integer> {
    List<Books> findByTitleContainingIgnoreCase(String title_piece);
}

