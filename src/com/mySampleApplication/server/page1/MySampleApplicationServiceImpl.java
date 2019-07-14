package com.mySampleApplication.server.page1;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.page1.MySampleApplicationService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySampleApplicationServiceImpl extends RemoteServiceServlet implements MySampleApplicationService {
  // Implementation of sample interface method
  public String getMessage(String msg) {
    return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
  }

  @Override
  public void connection() {
    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/resttest?serverTimezone=Europe/Moscow&amp", "root", "372987316684azXY")) {

      if (conn != null) {
        System.out.println("Connected to the database!");
      } else {
        System.out.println("Failed to make connection!");
      }

    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}