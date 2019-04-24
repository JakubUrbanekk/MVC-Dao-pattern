package view;

import java.util.Scanner;

public class FootballClubView{
    public void printMenu() {
        System.out.println("1. Create Football Club");
        System.out.println("2. Print all Football Clubs");
        System.out.println("3. Print selected Football Club");
        System.out.println("4. Update Football Club data");
        System.out.println("5. Delete Football Club");
        System.out.println("6. Delete all Football Clubs");
        System.out.println("7. Back");
    }
     public int getUserInput() {
        System.out.println("What You want to do?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public int askForId() {
        System.out.print("Type Id of footbal club: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String askForName() {
        System.out.print("Type name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int askForEstablishmentYear() {
        System.out.print("Type year of establishment: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void printAllFootballClubs(String footballClubs) {
        System.out.println(footballClubs);
    }

    public void printFootballClub(String footballClub) {
        System.out.println(footballClub);
    }

    public void addedComm() {
        System.out.println("Football Club added!");
    }

    public void updatedComm() {
        System.out.println("Updated!");
    }

    public void deletedComm() {
        System.out.println("Deleted!");
    }

    public void errorComm() {
        System.out.println("Football Club not found!");
    }
}
