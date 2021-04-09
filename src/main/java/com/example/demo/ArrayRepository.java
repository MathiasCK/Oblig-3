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
        try {
            db.update(sql, inputTicket.getMovie(), inputTicket.getfName(), inputTicket.getlName(), inputTicket.getMail(), inputTicket.getTel(), inputTicket.getNum());
        } catch (Exception e) {
           System.out.println("Feil i saveTicket : " + e);
        }}

        public List<Ticket> getAllTickets(){
            String sql = "SELECT * FROM Ticket ORDER BY lName";
            try {
                List<Ticket> allTickets = db.query(sql, new BeanPropertyRowMapper(Ticket.class));
            return allTickets;
            } catch (Exception e) {
                // Fikk feilmelding når jeg prøvde å hente inn logger
                System.out.print("Feil i getAllTickets :" + e);
                return null;
            }
        }
    
        public void deleteAllTickets() {
            String sql = "DELETE FROM Ticket";
            try {
                db.update(sql);
            } catch (Exception e) {
                System.out.println("Feil i deleteAllTickets : " + e);
            }
        }
    }

    