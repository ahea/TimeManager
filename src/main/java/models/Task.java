package models;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by aleksei on 21.01.17.
 */

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "owner_id")
    private User owner;

    @NotNull
    private String header;

    @NotNull
    private String description;

    @NotNull
    Date date;

    @NotNull
    boolean completed;
/*
    public Task(){}

    public Task(long id){
        this.id = id;
    }

    public Task(User owner, String header, String description, Date date,
                boolean completed){
        this.owner = owner;
        this.header = header;
        this.description = description;
        this.date = date;
        this.completed = completed;
    }
*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
