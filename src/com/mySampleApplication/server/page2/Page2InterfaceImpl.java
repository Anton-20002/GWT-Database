package com.mySampleApplication.server.page2;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mySampleApplication.client.page2.Page2Interface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Page2InterfaceImpl extends RemoteServiceServlet implements Page2Interface {
  @Override
  public List<String> getData() {
    List<String> result = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/resttest?serverTimezone=Europe/Moscow&amp", "root", "372987316684azXY")) {

      if (conn != null) {
        System.out.println("Connected to the database!");
        Statement statement = conn.createStatement();
        String str = "SELECT * from books";
        ResultSet resultSet = statement.executeQuery(str);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        System.out.println(rsmd.getColumnCount());
        for (int i=1; i<=rsmd.getColumnCount(); i++){
          System.out.println(rsmd.getColumnName(i));
        }
        while (resultSet.next()) {

        result.add(resultSet.getString(2));

        }
        } else {
        System.out.println("Failed to make connection!");
      }

    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}