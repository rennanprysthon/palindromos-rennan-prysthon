package br.com.rennanprysthon.wordsearch.infra.database;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_WORD")
public class WordTable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @ElementCollection
    @Column(name="results", nullable=false)
    @CollectionTable(
            name = "TB_WORD_RESULT",
            joinColumns = @JoinColumn(
                    name = "tb_word_id",
                    referencedColumnName = "uuid"
            )
    )
    private List<String> results = new ArrayList<String>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WordRowTable> rows = new ArrayList<>();

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<String> getResults() {
        return results;
    }

    public String getUuid() {
        return uuid;
    }

    public void setResults(List<String> results) {
        this.results = results;
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
