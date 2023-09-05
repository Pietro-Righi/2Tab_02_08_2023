package org.example.controller;

import org.example.model.ClienteBean;
import org.example.query.QueryCliente;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ControllerClienti {

    public static void controller(Connection con){

        ClienteBean client = new ClienteBean("Pietro", "Righi" , "123456790", new Date(System.currentTimeMillis()), 123);
        QueryCliente queryCliente = new QueryCliente();
        ResultSet resultSet;
        PrintWriter writer;
        int response;
        Scanner sc = new Scanner(System.in);

        try{
            queryCliente.insertClienti(client , con);
            System.out.print("Quale operazione di vuole effettuare ? " +
                    "\n 1- Inserimento " +
                    "\n 2- Select Singola dei clienti " +
                    "\n 3- Select Movimenti Cliente " +
                    "\n 4- Delete Cliente "+
                    "\n 5- Update Cliente "+
                    "\n Inserire la risposta:");

            response = sc.nextInt();


            switch (response){
                case 1:
                    queryCliente.insertClienti(client, con);
                    break;

                case 2 ,3:
                    resultSet = queryCliente.selectClienti(con);
                    writer = new PrintWriter(System.getProperty("user.home") + "\\" +"Desktop" + "\\prova.txt",
                            "UTF-8");


                    while (resultSet.next()) {
                        writer.println();
                        writer.print("Movimento{"+
                                "tipo movimento: "+resultSet.getString(1)+" "+
                                "data movimento: "+resultSet.getDate(2)+" "+
                                "totale movimento: "+resultSet.getInt(3)+" "+
                                "utente del movimento: "+resultSet.getString(4)+" "+
                                "}");
                    }

                    writer.close();
                    break;

                case 4:
                    queryCliente.deleteCliente("11111" , con);
                    break;


                case 5:
                    queryCliente.updateClienti(client , "1222", con);
                    break;

            }

        }catch(NullPointerException | FileNotFoundException | UnsupportedEncodingException | SQLException e){
            System.out.print(e.getMessage());
        }

    }
}
