package org.example.query;

import org.example.model.ClienteBean;

import java.sql.*;

public class QueryCliente {
    public void insertClienti(ClienteBean client, Connection con) throws SQLException {
        try{


            PreparedStatement quer = con.prepareStatement("insert into " +
                                                                "client(name ,surname ,tax_code ,creation_date, amount) " +
                                                                "values (?,?,?,?,?)");

            quer.setString(1,client.getName());
            quer.setString(2,client.getSurname());
            quer.setString(3,client.getTax_code());
            quer.setDate(4,client.getCreation_date());
            quer.setInt(5,client.getAmount());


            quer.execute();/*inizio transaction*/
            System.out.print("Inserimento...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }

    public ResultSet selectClienti(Connection con) throws SQLException {
        ResultSet result = null;
        try{


            PreparedStatement quer = con.prepareStatement("select * from client");

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

    public ResultSet selectOrdine(String tax_code, Connection con) throws SQLException {
        ResultSet result = null;
        try{


            PreparedStatement quer = con.prepareStatement("select * from client where tax_code = ?");
            quer.setString(1,tax_code);


            result = quer.executeQuery();/*inizio transaction*/
            System.out.print("Trovando il risultato...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }

        return result;
    }


    public void deleteCliente(String tax_code , Connection con) throws SQLException {
        try{
            PreparedStatement quer = con.prepareStatement("delete from client where tax_code = ?");
            quer.setString(1,tax_code);


            quer.execute();/*inizio transaction*/
            System.out.print("Cancellazione...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }

    public void updateMovimento(Date date_movemento, String movement_type, int movement_amount, String tax_code , Connection con) throws SQLException {
        try {

            PreparedStatement quer = con.prepareStatement("update client " +
                    "SET last_movement_date=?, movement_type=?, movement_amount=? " +
                    "where tax_code = ?");

            quer.setDate(1, date_movemento);
            quer.setString(2, movement_type);
            quer.setInt(3, movement_amount);
            quer.setString(4, tax_code);


            quer.execute();/*inizio transaction*/
            System.out.print("Modificando il dato...");
            con.commit();/*fine transaction*/

        } catch (SQLException e) {
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }

    public void updateClienti(ClienteBean client, String tax_code , Connection con) throws SQLException {
        try{

            PreparedStatement quer = con.prepareStatement("update client " +
                                                                "SET name=? ,surname=? ,tax_code=? ,creation_date=?, amount=?, " +
                                                                "last_movement_date=?, movement_type=?, movement_amount=? " +
                                                                "where tax_code = ?");

            quer.setString(1,client.getName());
            quer.setString(2,client.getSurname());
            quer.setString(3,client.getTax_code());
            quer.setDate(4,client.getCreation_date());
            quer.setInt(5,client.getAmount());
            quer.setDate(6,client.getLast_movement());
            quer.setString(7,client.getMovement_type());
            quer.setInt(8,client.getMovement_amount());
            quer.setString(3,tax_code);



            quer.execute();/*inizio transaction*/
            System.out.print("Modificando il dato...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }
}
