package com.example.demo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/api")
@RestController
public class ArrayController {
    
    @Autowired
    private ArrayRepository rep;

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> getResult(@RequestBody Ticket inputTicket) {
        try {
        rep.saveTicket(inputTicket);
        return new ResponseEntity<>(HttpStatus.CREATED);
      } catch (Exception e) {
       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }


    @GetMapping("/tickets")
    public List<Ticket> getAll(){
        
            return rep.getAllTickets();
        
    }

    @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> delete() {
       try {
        rep.deleteAllTickets();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}
