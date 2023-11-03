package br.com.rennanprysthon.wordsearch.infra.database;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "TB_WORD")
public class WordTable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "wordTable"
    )
    private List<WordResultTable> results = new ArrayList<WordResultTable>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WordRowTable> rows = new ArrayList<>();

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<WordResultTable> getResults() {
        return results;
    }

    public String getUuid() {
        return uuid;
    }

    public void setResults(List<String> results) {
        List<WordResultTable> resultTables = new ArrayList<>();
        WordResultTable wordResultTable;

        for (String result : results) {
            wordResultTable = new WordResultTable(result);
            wordResultTable.setWordTable(this);
            resultTables.add(wordResultTable);

        }

        this.results = resultTables;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<WordRowTable> getRows() {
        return rows;
    }

    public void setRows(List<WordRowTable> rows) {
        this.rows = rows;
    }
}
