package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ArrayRepository {

    @Autowired
    private JdbcTemplate db;

    public void saveTicket(Ticket inputTicket) {
        String sql = "INSERT INTO Ticket (movie, fName, lName, mail, tel, num) VALUES(?,?,?,?,?,?)";
        db.update(sql, inputTicket.getMovie(), inputTicket.getfName(), inputTicket.getlName(), inputTicket.getMail(), inputTicket.getTel(), inputTicket.getNum());
    }

    public List<Ticket> getAllTickets(){
        String sql = "SELECT * FROM Ticket ORDER BY lName";
        List<Ticket> allTickets = db.query(sql, new BeanPropertyRowMapper(Ticket.class));
        return allTickets;
    }

    public void deleteAllTickets() {
        String sql = "DELETE FROM Ticket";
        db.update(sql);
    }
}