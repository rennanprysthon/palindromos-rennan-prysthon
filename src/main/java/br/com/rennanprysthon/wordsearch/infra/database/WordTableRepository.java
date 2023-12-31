package br.com.rennanprysthon.wordsearch.infra.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordTableRepository extends JpaRepository<WordTable, String> {
}
