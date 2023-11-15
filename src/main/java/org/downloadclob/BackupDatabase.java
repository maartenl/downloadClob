package org.downloadclob;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

public class BackupDatabase {

  public void backup(String url, String user, String password, String filepath, String query)
      throws SQLException, IOException {

    List<String[]> clobs = new Database(url, user, password).getResultSet(query);
    writeObjectsToFile(clobs, Path.of(filepath));
  }

  public void writeObjectsToFile(List<String[]> lines, Path path) throws IOException {
    System.out.println("Writing rows to " + path.toString() + "..");
    try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
      for (String[] line : lines) {
        writer.writeNext(line);
      }
      System.out.println(lines.size() + " rows were succesfully written to " + path.toString() + ".");
    }
  }

}
