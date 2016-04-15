/**
 * Created by sesion on 13/04/2016.
 */

import java.sql.*;

public class Main {
    public static void main( String args[] ) {

        //create object
        FilmTestClass filmA = new FilmTestClass("Everest", "Pavaroti", 2);
        FilmTestClass filmB = new FilmTestClass("Hot girls", "Pamela Anderson", 5);
        FilmTestClass filmC = new FilmTestClass("java sucks", "everyone", 6);

        String sql = "";
        Connection c = null;
        Statement stmt = null;
        try {
            ////////////////////////////////////////////
            //SET THE DRIVER AND CONNECT TO THE JDBC
            ////////////////////////////////////////////
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
        }catch (Exception e){
            System.err.println("ERROR CONNECTING TO THE DB");
        }



        try {
            //////////////////////
            ///// create TABLE ///
            //////////////////////
            stmt = c.createStatement();
            sql = "CREATE TABLE FILMS " +
                    "(ID INTEGER PRIMARY KEY  AUTOINCREMENT," +
                    "NAME           STRING    NOT NULL, " +
                    "DIRECTOR       STRING    NOT NULL, " +
                    "RATE            CHAR(3)    NOT NULL)";
            stmt.executeUpdate(sql);

        }catch (Exception ee) {
            System.err.println("ERROR CREATING THE DB... ¿ALREADY EXISTS?");
        }




        try{
            ////////////////////////////////////////////
            /////////////   INSERTS   //////////////////
            ////////////////////////////////////////////
            sql = "INSERT INTO FILMS(NAME, DIRECTOR, RATE) VALUES ('"+filmA.name+"' , '"+filmA.director+"', '"+ filmA.rate +"' )";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO FILMS(NAME, DIRECTOR, RATE) VALUES ('"+filmB.name+"' , '"+filmB.director+"', '"+ filmB.rate +"' )";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO FILMS(NAME, DIRECTOR, RATE) VALUES ('"+filmC.name+"' , '"+filmC.director+"', '"+ filmC.rate +"' )";
            stmt.executeUpdate(sql);






            /////////////////////////////////
            /////////// SELECTS /////////////
            /////////////////////////////////
            ResultSet rs = stmt.executeQuery( "SELECT * FROM FILMS;" );
            while ( rs.next() ) {
                System.out.println("ID: " + rs.getInt("ID") + ", NAME: "+rs.getString("NAME")+ " , DIRECTOR: "+ rs.getString("DIRECTOR")+ ", RATE: "+rs.getInt("RATE"));
            }
            System.out.println("----------------------------------------------------------");
            rs.close();





            /////////////////////////////////
            /////////// DELETES /////////////
            /////////////////////////////////
            try {
                sql = "DELETE from FILMS where ID=3;";
                stmt.executeUpdate(sql);

                //SELECT
                rs = stmt.executeQuery("SELECT * FROM FILMS;");
                while ( rs.next() ) {
                    System.out.println("ID: " + rs.getInt("ID") + ", NAME: "+rs.getString("NAME")+ " , DIRECTOR: "+ rs.getString("DIRECTOR")+ ", RATE: "+rs.getInt("RATE"));
                }
                System.out.println("----------------------------------------------------------");
                rs.close();
            }catch (Exception e){
                System.err.println("ERROR DELETING: ");
                e.printStackTrace();
            }






            /////////////////////////////////
            /////////// UPDATES /////////////
            /////////////////////////////////
            sql = "UPDATE FILMS set DIRECTOR = 'MARIANO RAJOY' where ID=1;";
            stmt.executeUpdate(sql);

            //SELECT
            rs = stmt.executeQuery("SELECT * FROM FILMS;");
            while ( rs.next() ) {
                System.out.println("ID: " + rs.getInt("ID") + ", NAME: "+rs.getString("NAME")+ " , DIRECTOR: "+ rs.getString("DIRECTOR")+ ", RATE: "+rs.getInt("RATE"));
            }
            System.out.println("----------------------------------------------------------");
            rs.close();


            /////////////////////////////////
            ///////  UPDATING TABLE /////////
            /////////////////////////////////
            sql = "ALTER TABLE FILMS ADD OSCAR BOOLEAN;";
            stmt.executeUpdate(sql);

            //SELECT
            rs = stmt.executeQuery("SELECT * FROM FILMS;");
            while ( rs.next() ) {
                System.out.println("ID: " + rs.getInt("ID") + ", NAME: "+rs.getString("NAME")+ " , DIRECTOR: "+ rs.getString("DIRECTOR")+ ", RATE: "+rs.getInt("RATE")+ ", ¿WIN A OSCAR?: "+ rs.getBoolean("OSCAR"));
            }
            System.out.println("----------------------------------------------------------");
            rs.close();



            //close connection
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("EXIT successfully");

    }
}
