package com.cyc.collectyourcollections.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCollectionRepository extends JpaRepository<BookEntity, Long> {
   BookEntity deleteById(long id);
}
