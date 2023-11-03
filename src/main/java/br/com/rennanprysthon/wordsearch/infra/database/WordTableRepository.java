package br.com.rennanprysthon.wordsearch.infra.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WordTableRepository extends JpaRepository<WordTable, String> {
}
