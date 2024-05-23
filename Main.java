import java.util.Scanner;
public class Main {

  public static void endMessage() {
    System.out.print("\nAvailable commands: \n  1. enter \n  2. remove \n  3. list by genre \n  4. list alphabetically \n  5. list by borrower \n  6. write info to file \n  7. read info from file \n  8. quit \n--> ");
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    Catalog catalog = new Catalog();
    System.out.print("\nWelcome to the book catalog program! Please enter the corresponding number of your desired command.");
    endMessage();

    String userCmd;
    while (scanner.hasNextLine()) {
        userCmd = scanner.nextLine();
        if (userCmd.equals("1")) {
            catalog.setInfo();
            endMessage();
        }
        else if (userCmd.equals("2")) {
            catalog.removeCatalogItem();
            endMessage();
        }
        else if (userCmd.equals("3")) {
            catalog.listByGenre();
            endMessage();
        }
        else if (userCmd.equals("4")) {
            catalog.sortByAuthorLastName();
            catalog.printCatalog();
            endMessage();
        }
        else if (userCmd.equals("5")) {
            catalog.listByBorrower();
            endMessage();
        }
        else if (userCmd.equals("6")) {
            catalog.writeFile();
            endMessage();
        }
        else if (userCmd.equals("7")) {
            catalog.readFile();
            endMessage();
        }
        else if (userCmd.equals("8")) {
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
