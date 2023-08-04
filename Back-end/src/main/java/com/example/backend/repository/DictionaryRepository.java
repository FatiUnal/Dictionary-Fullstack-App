package com.example.backend.repository;

import com.example.backend.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary,Integer> {


    @Query("select t from Dictionary t where t.englishText like %:x% or t.turkishText like %:x%")
    List<Dictionary> findAllByEnglishTextStartingWithOrTurkishTextStartingWith(@Param("x") String x);
}
