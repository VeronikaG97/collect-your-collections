package com.cyc.collectyourcollections.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCollectionRepository extends JpaRepository<BookEntity, Long> {
   BookEntity deleteById(long id);
   List<BookEntity> findByTitle(String title);
}
