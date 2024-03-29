package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException e) { 
         e.printStackTrace();
      }
   }

   @Test
   public void testConnection() {
      try(Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe"
            , "scott"
            , "tiger")){
         
         log.info( con);
         // INFO : org.zerock.persistence.JDBCTests - oracle.jdbc.driver.T4CConnection@e580929
         
         
      }catch (Exception e) {
          e.printStackTrace();
      }
   }

}