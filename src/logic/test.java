package logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class test {




    public static void main(String[] args) {

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
