package org.example.controller;

import org.example.model.MovimentoBean;
import org.example.query.QueryMovimento;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerMovimento {

    public static void controller(Connection con){

        MovimentoBean movement = new MovimentoBean(123, new Date(System.currentTimeMillis()), "prelievo");
        QueryMovimento queryMovimento = new QueryMovimento();

        try{
            //queryMovimento.insertMovimento(movement , 5, con);


            ResultSet resultSet = queryMovimento.selectMovimentsFromClient(5,con);
            PrintWriter writer = new PrintWriter(System.getProperty("user.home") + "\\" +"Desktop" + "\\prova.txt",
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


        }catch(UnsupportedEncodingException | NullPointerException | FileNotFoundException | SQLException e){
            System.out.print(e.getMessage());
        }

    }
}
