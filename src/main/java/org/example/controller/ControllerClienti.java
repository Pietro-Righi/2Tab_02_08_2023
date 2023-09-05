package org.example.controller;

import org.example.model.ClienteBean;
import org.example.query.QueryCliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class ControllerClienti {

    public static void controller(Connection con){

        ClienteBean client = new ClienteBean("Pietro", "Righi" , "123456790", new Date(System.currentTimeMillis()), 123);
        QueryCliente queryCliente = new QueryCliente();

        try{
            queryCliente.insertClienti(client , con);

        }catch(NullPointerException | SQLException e){
            System.out.print(e.getMessage());
        }

    }
}
