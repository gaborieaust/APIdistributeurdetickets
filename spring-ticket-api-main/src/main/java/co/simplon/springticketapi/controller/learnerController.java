package co.simplon.springticketapi.controller;


import co.simplon.springticketapi.dao.LearnerDao;
import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/learner")
@RestController
public class learnerController {

    private final LearnerDao learnerDao;


    public learnerController(LearnerDao learnerDao) {
        this.learnerDao = learnerDao;
    }
    /* lister tous les tickets*/
    @GetMapping
    public List<Learner> getAllLearner() {
        return learnerDao.getAll();
    }

    /* lire un learner à partir de l'ID*/
    @GetMapping("/{id}")
    public Learner getLearner(@PathVariable Long id) {
        return learnerDao.get(id);
    }
    /* sauver un new learner */
    @PostMapping()
    public void postLearner(@RequestBody Learner learner){
             learnerDao.save(learner);
    };
    /* le learner avec le plus grand nombre de tickets*/
    @GetMapping("/(highestTickets)")
    public Learner highestTickets(Learner learner) {
       return learnerDao.highestTickets(learner);
    }

/*just for  a try*/



}
