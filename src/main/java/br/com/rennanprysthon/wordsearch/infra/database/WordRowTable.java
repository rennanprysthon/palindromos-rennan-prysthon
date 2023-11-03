package br.com.rennanprysthon.wordsearch.infra.database;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_WORD_ROW")
public class WordRowTable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ElementCollection
    @Column(name="columns", nullable=false)
    @CollectionTable(
        name = "TB_WORD_COLUMN",
        joinColumns = @JoinColumn(
            name = "tb_word_id",
            referencedColumnName = "uuid"
        )
    )
    private List<String> columns = new ArrayList<String>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
