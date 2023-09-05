package org.example.controller;

import org.example.model.MovimentoBean;
import org.example.query.QueryMovimento;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerMovimento {

    public static void controller(Connection con){

        MovimentoBean movement = new MovimentoBean(123, new Date(System.currentTimeMillis()), "prelievo");
        QueryMovimento queryMovimento = new QueryMovimento();
        ResultSet resultSet;
        PrintWriter writer;
        Scanner sc = new Scanner(System.in);
        int response;


        try{
            //queryMovimento.insertMovimento(movement , 5, con);

            System.out.print("Quale operazione di vuole effettuare ? " +
                    "\n 1- Inserimento " +
                    "\n 2- Select Singola dei movimento " +
                    "\n 3- Select Bulk " +
                    "\n Inserire la risposta:");

            response = sc.nextInt();


            switch(response){
                case 1:
                    queryMovimento.insertMovimento(movement , 4,con);
                    break;

                case 2:
                    resultSet = queryMovimento.selectMovimento(con);
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

                case 3:
                    resultSet = queryMovimento.selectMovimentsFromClient(5,con);
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

            }



        }catch(UnsupportedEncodingException | InputMismatchException | NullPointerException | FileNotFoundException | SQLException e){
            System.out.print(e.getMessage());
        }






    }
}
