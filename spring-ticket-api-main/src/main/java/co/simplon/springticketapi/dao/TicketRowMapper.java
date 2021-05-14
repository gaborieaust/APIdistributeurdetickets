package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketRowMapper implements RowMapper<Ticket> {

    @Override
    public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Ticket((long) resultSet.getLong("id_ticket"), resultSet.getTimestamp("date").toLocalDateTime(),resultSet.getString("description"),resultSet.getInt("idx_learner"), resultSet.getTimestamp("dateresolution").toLocalDateTime());
    }
}
