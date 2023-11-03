package br.com.rennanprysthon.wordsearch.infra.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordResultRepository extends JpaRepository<WordResultTable, String> {
    List<WordResultTable> findAllByResultWordContainingIgnoreCase(String term);
}
