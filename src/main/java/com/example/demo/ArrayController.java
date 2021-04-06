package com.example.demo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class ArrayController {
    
    //private final List<Ticket> movieList = new ArrayList<>();
    @Autowired
    private ArrayRepository rep;

    @PostMapping("save")
    public void getResult(Ticket inputTicket) {
        rep.saveTicket(inputTicket);

    }


    @GetMapping("tickets")
    public List<Ticket> getAll(){
        return rep.getAllTickets();
    }

    @GetMapping("delete")
    public void delete() {
        rep.deleteAllTickets();
    }
}
