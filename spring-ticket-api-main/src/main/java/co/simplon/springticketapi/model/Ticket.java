package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private LocalDateTime date;
    private String description;
    private int idlearner;

    public Ticket(LocalDateTime localDateTime) {
        this.date = localDateTime;
    }


    public Ticket(Long id, LocalDateTime date, String description,int idlearner) {
        this.id = id;
        this.date = date;
        this.description = description ;
        this.idlearner = idlearner;
    }
    public Long getId() {
        return id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }

    public int getIdlearner() {
        return idlearner;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", idlearner=" + idlearner +
                '}';
    }
}




