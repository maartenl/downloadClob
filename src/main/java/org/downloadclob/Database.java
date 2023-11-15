package org.downloadclob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Database {

  private final String url;
  private final String user;
  private final String password;

  public Database(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public List<String[]> getResultSet(String query) throws SQLException {
    System.out.println("Retrieving rows from the database...");
    List<String[]> rows = new ArrayList<>();

    //step2 create  the connection object
    try (Connection con = DriverManager.getConnection(
        url, user, password);
        Statement stmt = con.createStatement()
    ) {
      ResultSet rs = stmt.executeQuery(query);
      int columnCount = rs.getMetaData().getColumnCount();
      while (rs.next()) {
        // System.out.println("Retrieving a row...");
        String[] row = new String[columnCount];
        IntStream.range(1, columnCount + 1).forEach(i -> {
          try {
            row[i - 1] = rs.getString(i);
          }
          catch (SQLException e) {
            throw new RuntimeException(e);
          }
        });
        rows.add(row);
      }
    }
    System.out.println(rows.size() + " rows were retrieved from the database");
    return rows;
  }

}
