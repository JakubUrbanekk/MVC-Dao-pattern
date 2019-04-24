package view;

import java.util.Scanner;

public class FootballerView{
    public void printMenu() {
        System.out.println("1. Create Footballer");
        System.out.println("2. Print all Footballers");
        System.out.println("3. Print selected Footballer");
        System.out.println("4. Update Footballer's data");
        System.out.println("5. Update Footballers's football club");
        System.out.println("6. Delete Footballer");
        System.out.println("7. Delete all Footballers");
        System.out.println("8. Back");
    }
    public int getUserInput() {
        System.out.println("What You want to do?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public int askForId() {
        System.out.print("Type Id of footballer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String askForName() {
        System.out.print("Type first name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String askForSurname() {
        System.out.print("Type surname: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public int askForAge() {
        System.out.print("Type age: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public int askForFootballClub() {
        System.out.print("Type new Football club id: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printAllFootballers(String footballClubs) {
        System.out.println(footballClubs);
    }

    public void printFootballer(String footballClub) {
        System.out.println(footballClub);
    }

    public void addedComm() {
        System.out.println("Footballer added!");
    }

    public void updatedComm() {
        System.out.println("Updated!");
    }

    public void deletedComm() {
        System.out.println("Deleted!");
    }

    public void errorComm() {
        System.out.println("Footballer not found!");
    }
    public void fcErrorComm() {
        System.out.println("Football Club not found!");
    }
}
