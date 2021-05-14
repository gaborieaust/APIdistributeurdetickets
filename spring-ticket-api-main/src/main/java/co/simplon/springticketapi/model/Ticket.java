package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private LocalDateTime date;
    private String description;
    private int idlearner;
    private LocalDateTime dateresolution;

    public Ticket(LocalDateTime localDateTime) {
        this.date = localDateTime;
    }


    public Ticket(Long id, LocalDateTime date, String description,int idlearner, LocalDateTime dateresolution) {
        this.id = id;
        this.date = date;
        this.description = description ;
        this.idlearner = idlearner;
        this.dateresolution = dateresolution;
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
    public LocalDateTime getDateresolution() {return dateresolution; }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", idlearner=" + idlearner +
                ", dateresolution=" + dateresolution +
                '}';
    }
}




