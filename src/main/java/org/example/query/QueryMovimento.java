package org.example.query;

import org.example.model.ClienteBean;
import org.example.model.MovimentoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryMovimento {
    public void insertMovimento(MovimentoBean movement, int id_client, Connection con) throws SQLException {
        try{


            PreparedStatement quer = con.prepareStatement("insert into " +
                    "movement (movement_type ,creation_date ,movement_amount, id_client) "  +
                    "values (?,?,?,?)");

            quer.setString(1,movement.getMovement_type());
            quer.setDate(2,movement.getMovement_date());
            quer.setInt(3,movement.getMovement_amount());
            quer.setInt(4,id_client);


            quer.execute();/*inizio transaction*/
            System.out.print("Inserimento...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }


    public ResultSet selectMovimento(Connection con) throws SQLException {
        ResultSet result = null;
        try{
            PreparedStatement quer = con.prepareStatement("select * from movement");

            result = quer.executeQuery();/*inizio transaction*/
            System.out.print("Trovando i risultati...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }

        return result;
    }

    public ResultSet selectMovimentsFromClient(int id_client , Connection con) throws SQLException {
        ResultSet result = null;
        try{
            PreparedStatement quer = con.prepareStatement("SELECT movement.movement_type, movement.creation_date, movement.movement_amount, client.name " +
                                                                    "FROM movement " +
                                                                    "left JOIN client " +
                                                                    "ON movement.id_client =client.id " +
                                                                    "WHERE client.id = ?" );

            quer.setInt(1,id_client);

            result = quer.executeQuery();/*inizio transaction*/
            System.out.print("Trovando i risultati...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }

        return result;
    }
}
