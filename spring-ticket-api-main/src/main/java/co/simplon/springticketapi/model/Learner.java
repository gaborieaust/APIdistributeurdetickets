package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Learner {
    // A vous de jouer
    private Long id;
    private String name;



    public Learner(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return "Learner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
