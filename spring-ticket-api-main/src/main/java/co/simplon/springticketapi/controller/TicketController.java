package co.simplon.springticketapi.controller;

import co.simplon.springticketapi.dao.TicketDao;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tickets")
@RestController
public class TicketController {

    private final TicketDao ticketDao;

    public TicketController(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }
    /* lister tous les tickets*/
    @GetMapping
    public List<Ticket> getAllTickets() {
        System.out.println(ticketDao.getAll());
        return ticketDao.getAll();
    }
    /* lire un ticket  à partir de l'ID*/
    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketDao.get(id);
    }

    /*Créer des tickets en base de données*/
    @PostMapping()
    public Ticket postTicket(@RequestBody Ticket ticket){
        System.out.println(ticket);
        return ticketDao.post(ticket);
    };
    /* pour supprimer un ticket dans la base */
    @DeleteMapping("/{id}")
    public  void deleteTicket(@PathVariable Long id) {
        ticketDao.delete(id);
    }
    /* pour supprimer un ticket dans la base */


    @PutMapping("/{id}")
    public  Ticket updateTicket(@PathVariable Long id,@RequestBody Ticket ticket) {
     return ticketDao.update(id, ticket);
    }


}