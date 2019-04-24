package executable;

import controller.FootballClubControler;
import controller.FootballerController;
import model.FootballClubModel;
import table.FootballClub;
import view.FootballClubView;

import java.util.List;
import java.util.Scanner;

public class App{
        public static void main (String[]args){
            System.out.println("What do You want to edit?\n1. Footballer\n2. Football Club\n3. Exit");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            while (userInput != 3) {
                switch (userInput) {
                    case 1: {
                        FootballerController workerController = new FootballerController();
                        workerController.executeFootballerController();
                        break;
                    }
                    case 2: {
                        FootballClubControler companyController = new FootballClubControler();
                        companyController.executeFootballClubController();
                        break;
                    }
                    case 3: {
                        return;
                    }
                    default: {
                        System.out.println("Unknown command!");
                        break;
                    }
                }
                System.out.println("Which being You want to edit?\n1. Footballer\n2. Football Club\n3. Exit");
                userInput = scanner.nextInt();
            }
        }
}
