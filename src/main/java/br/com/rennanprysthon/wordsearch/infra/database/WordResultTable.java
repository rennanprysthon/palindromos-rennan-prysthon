package br.com.rennanprysthon.wordsearch.infra.database;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_WORD_RESULT")
public class WordResultTable {
    public WordResultTable() {
    }

    public WordResultTable(String resultWord) {
        this.resultWord = resultWord;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(name = "TXT_RESULT")
    private String resultWord;

    @ManyToOne
    private WordTable wordTable;

    public String getResultWord() {
        return resultWord;
    }

    public WordTable getWordTable() {
        return wordTable;
    }

    public void setWordTable(WordTable wordTable) {
        this.wordTable = wordTable;
    }

    public String getUuid() {
        return uuid;
    }
}
