import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Catalog {
  private ArrayList<String> catalogArr = new ArrayList<String>();
  private Scanner scanner = new Scanner(System.in);
  private String fullBookInfo;

  public void addCatalogArrElement(String element) {
      catalogArr.add(element);
  }

  public void setInfo() {
    System.out.print("\nEnter title: ");
    String title = scanner.nextLine();

    System.out.print("Enter author's first and last names: ");
    String author = scanner.nextLine();

    System.out.print("Enter genre: ");
    String genre = scanner.nextLine();

    System.out.print("Enter borrower (if currently in possession, enter 'no one'): ");
    String borrower = scanner.nextLine();

    fullBookInfo = title + ", by " + author + " (" + genre + "). Borrowed by " + borrower + ".";
    System.out.println("Your book info was successfully entered as: " + "\n  " + fullBookInfo);
    addCatalogArrElement(fullBookInfo);
  }

  public void printCatalog() {
    for (int i = 0; i < catalogArr.size(); i++) {
      System.out.println("  " + catalogArr.get(i));
    }
  }

  public void removeCatalogItem() {
    System.out.print("\nEnter the title of the book you would like to remove. \n--> ");
    String searchFor = scanner.next();
    for (int i = 0; i < catalogArr.size(); ++i) {
      if (catalogArr.get(i).contains(searchFor)) {
        catalogArr.remove(catalogArr.get(i));
      }
    }
    System.out.println("Your book was successfully removed from the catalog.");
  }

  public void listByGenre() {
    System.out.print("\nWhat genre would you like to list by? \n--> ");
    String userGenre = scanner.nextLine();

    for (int i = 0; i < catalogArr.size(); ++i) {
      if (catalogArr.get(i).contains(userGenre)) {
        System.out.println("  " + catalogArr.get(i));
      }
    }
  }

  public void listByBorrower() {
    System.out.print("\nEnter the name of the borrower. \n--> ");
    String searchFor = scanner.nextLine();

    for (int i = 0; i < catalogArr.size(); ++i) {
      if (catalogArr.get(i).contains(searchFor)) {
        System.out.println("  " + catalogArr.get(i).substring(0, catalogArr.get(i).indexOf(".")) + ".");
      }
    }
  }

  public void sortByAuthorLastName() {
      System.out.println("\nListing books in alphabetical order by author's last name:");
        Collections.sort(catalogArr, new Comparator<String>() { // custom comparator
          @Override
          public int compare(String entry1, String entry2) {
              String authorFullName1 = entry1.substring(entry1.indexOf("by "), entry1.indexOf(" ("));
              String authorFullName2 = entry2.substring(entry2.indexOf("by "), entry2.indexOf(" ("));

              String lastName1 = authorFullName1.split(" ")[authorFullName1.split(" ").length - 1];
              String lastName2 = authorFullName2.split(" ")[authorFullName2.split(" ").length - 1];

              int result = lastName1.compareTo(lastName2);
              if (result != 0) { // if they are different, the result is returned
                return result;
              }
              return authorFullName1.compareTo(authorFullName2); // otherwise, fullNames are compared

              // after all of this executes and all data is gathered, the sorting operation will arrange the book entries 
              // in alphabetical order using the author's last names
          }
      });
    }

  public void writeFile() {
      try {
          FileWriter writer = new FileWriter("catalogInfo.txt");
          writer.write("Your catalog info:");
          for (int i = 0; i < catalogArr.size(); ++i) {
              writer.write("\n  " + catalogArr.get(i));
          }
          writer.close();
          System.out.println("\nYour catalog information was written successfully.");
      } 
      catch (IOException e) {
          System.out.println("An error has occurred.");
          e.printStackTrace();
      }
  }

  public void readFile() {
      try {
          File file = new File("catalogInfo.txt");
          Scanner scanner = new Scanner(file);
          System.out.println();
          while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            System.out.println(data);
          }
          scanner.close();
      } 
      catch (FileNotFoundException e) {
          System.out.println("The file was not found.");
          e.printStackTrace();
      }
  }
}
