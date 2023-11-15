package org.downloadclob;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DownloadClob {
  public static void main(String[] args) throws SQLException, IOException {
    if (args == null || args.length < 4) {
      System.out.println("downloadClob [url] [username] [pwd] [filename]");
      return;
    }
    System.out.println("Entered parameters: downloadClob " + String.join(" ", args));
    Scanner input = new Scanner(System.in);
    StringBuilder query = new StringBuilder();
    String inputString = input.nextLine();
    while (!inputString.equalsIgnoreCase("exit")) {
      query.append(" ").append(inputString);
      inputString = input.nextLine();
    }
    BackupDatabase backupDatabase = new BackupDatabase();
    backupDatabase.backup(args[0], args[1], args[2], args[3], query.toString());
  }

}
