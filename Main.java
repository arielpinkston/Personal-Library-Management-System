import java.util.Scanner;
public class Main {

  public static void endMessage() {
    System.out.print("\nAvailable commands: \n  enter \n  remove \n  list by genre \n  list alphabetically \n  list by borrower \n  write info to file \n  read info from file \n  quit \n--> ");
  }
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    Catalog catalog = new Catalog();
    System.out.print("\nWelcome to the book catalog program!");
    endMessage();

    String userCmd;
    while (scanner.hasNextLine()) {
        userCmd = scanner.nextLine();
        if (userCmd.equals("enter")) {
            catalog.setInfo();
            endMessage();
            continue;
        }
        else if (userCmd.equals("remove")) {
            catalog.removeCatalogItem();
            endMessage();
            continue;
        }
        else if (userCmd.equals("list by genre")) {
            catalog.listByGenre();
            endMessage();
            continue;
        }
        else if (userCmd.equals("list alphabetically")) {
            catalog.sortByAuthorLastName();
            catalog.printCatalog();
            endMessage();
            continue;
        }
        else if (userCmd.equals("list by borrower")) {
            catalog.listByBorrower();
            endMessage();
            continue;
        }
        else if (userCmd.equals("write info to file")) {
            catalog.writeFile();
            endMessage();
            continue;
        }
        else if (userCmd.equals("read info from file")) {
            catalog.readFile();
            endMessage();
            continue;
        }
        else if (userCmd.equals("quit")) {
            System.out.println("\nGoodbye!\n");
            break;
        }
        else {
            System.out.println("\nInvalid command. ");
            endMessage();
            continue;
        }
      
    }
  }
}