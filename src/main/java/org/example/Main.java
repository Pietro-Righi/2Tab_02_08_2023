package org.example;

import org.example.controller.ControllerClienti;
import org.example.controller.ControllerMovimento;
import org.example.query.Connessione;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Connection con = null;
        Scanner sc = new Scanner(System.in);
        String response;



        try{
            con = Connessione.Connession();


            System.out.print("Su cosa si vuole effettuare operazioni ? (C / M): ");
            response = sc.next();

            switch (response) {
                case "C", "c" :
                    ControllerClienti.controller(con);
                    break;
                case "M", "m" :
                    ControllerMovimento.controller(con);
                    break;
            }

        }catch(ClassNotFoundException | InputMismatchException | SQLException e){
            System.out.print(e.getMessage());
        }




    }
}