package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class LearnerDao implements Dao<Learner> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Learner> LearnerRowMapper;

    public LearnerDao(JdbcTemplate jdbcTemplate, RowMapper<Learner> learnerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        LearnerRowMapper = learnerRowMapper;
    }

    /* selectionner un learner à partir de l'ID*/
    @Override
    public Learner get(Long id) {
            String sql = "SELECT *  FROM learner  WHERE id_learner = ?";
            return jdbcTemplate.queryForObject(sql,LearnerRowMapper, id);
        }
    /* selectionner tous les learners*/
    @Override
    public List<Learner> getAll() {
            String sql = "SELECT * FROM learner";
            return jdbcTemplate.query(sql, LearnerRowMapper);
        }
    /* to save a new learner*/

    public void save(Learner learner) {
            jdbcTemplate.execute("Insert into learner (name) VALUES ('" + learner.getName() + "')");
    }

    @Override
    public void delete(Long id) {

    }

    /* learner with the highest numbers of tickets*/
    public Learner highestTickets(Learner learner){
        String sql = "select count(id_ticket), name,id_learner from ticket join learner l on ticket.idx_learner = l.id_learner\n" +
                "group by name,id_learner\n" +
                "order by count(id_ticket) DESC\n" +
                "limit 1";
        return jdbcTemplate.queryForObject(sql,LearnerRowMapper);
    }


}
