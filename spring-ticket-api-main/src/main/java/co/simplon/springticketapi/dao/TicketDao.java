package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Component
public class TicketDao implements Dao<Ticket> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Ticket> ticketRowMapper;

    public TicketDao(JdbcTemplate jdbcTemplate, RowMapper<Ticket> ticketRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.ticketRowMapper = ticketRowMapper;
    }
    /*selectionner un ticket à partir de l'ID*/
    @Override
    public Ticket get(Long id) {
        String sql = "SELECT * FROM ticket WHERE id_ticket = ?";
        return jdbcTemplate.queryForObject(sql,ticketRowMapper, id);
    }
    /* selectionner l'intégralité des données*/
    @Override
    public List<Ticket> getAll() {
                String sql = "SELECT * FROM ticket";
                return jdbcTemplate.query(sql,ticketRowMapper);

    }

    /*poster un ticket*/
    public Ticket post (Ticket ticket){
        jdbcTemplate.execute("Insert into ticket (date,description,idx_learner) VALUES ('" + ticket.getDate() + "','" + ticket.getDescription()+ "','" + ticket.getIdlearner() + "')");
        return ticket;

    }

    @Override
    public void save(Ticket ticket) {
        // A vous de jouer
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM ticket WHERE id_ticket = ?";
      jdbcTemplate.queryForObject(sql,ticketRowMapper, id);
    }

    /* mettre à jour un ticket*/
    public Ticket update(Long id, Ticket ticket) {
        String sql = "UPDATE ticket SET  date = ?, description = ?, dateresolution =? WHERE id_ticket = ?";
       jdbcTemplate.update(sql, ticket.getDate(),ticket.getDescription(),ticket.getDateresolution(),id);
        return ticket;
    }
    }

