package controller;

import model.FootballClubModel;
import table.FootballClub;
import view.FootballClubView;

public class FootballClubControler{
    FootballClubModel footballClubModel;
    FootballClubView footballClubView;

    public FootballClubControler (){
        footballClubView=new FootballClubView();
        footballClubModel=new FootballClubModel();
    }

    public FootballClubControler (FootballClubModel footballClubModel, FootballClubView footballClubView){
        this.footballClubModel = footballClubModel;
        this.footballClubView = footballClubView;
    }
    public void executeFootballClubController() {
        footballClubView.printMenu();
        int userInput = footballClubView.getUserInput();
        while (userInput != 7) {
            switch (userInput) {
                case 1: {
                    String name = footballClubView.askForName();
                    int establishmentYear = footballClubView.askForEstablishmentYear();
                    FootballClub fc=new FootballClub(name,establishmentYear);
                    footballClubModel.persist(fc);
                    footballClubView.addedComm();
                    break;
                }
                case 2: {
                    String allFootballClubs = footballClubModel.footballClubPrintAll();
                    if(allFootballClubs.equals("")){
                        footballClubView.errorComm();
                    }
                    else{
                        footballClubView.printAllFootballClubs(allFootballClubs);
                    }
                    break;
                }
                case 3: {
                    int idfootballClub = footballClubView.askForId();
                    String footballClubString = footballClubModel.findById(idfootballClub).toString();
                    if(footballClubString != "")
                        footballClubView.printFootballClub(footballClubString);
                    else
                        footballClubView.errorComm();
                    break;
                }
                case 4: {
                    int idFootballClub = footballClubView.askForId();
                    FootballClub fc=footballClubModel.findById(idFootballClub);
                    if(fc!=null){
                        String footballClubString = footballClubView.askForName();
                        int footballClubYear = footballClubView.askForEstablishmentYear();
                        fc.setName(footballClubString);
                        fc.setEstablishmentYear(footballClubYear);
                        footballClubModel.update(fc);
                        footballClubView.updatedComm();
                    }
                    else
                        footballClubView.errorComm();
                    break;
                }

                case 5: {
                    int idFootballClub = footballClubView.askForId();
                    FootballClub fc=footballClubModel.findById(idFootballClub);
                    if (fc!=null){
                        footballClubModel.delete(idFootballClub);
                        footballClubView.deletedComm();
                    }
                    else
                        footballClubView.errorComm();
                    break;
                }
                case 6: {
                    footballClubModel.deleteAll();
                    footballClubView.deletedComm();
                    break;
                }
                case 7: {
                    return;
                }
                default: {
                    System.out.println("Unknown command!");
                    break;
                }
            }
            footballClubView.printMenu();
            userInput = footballClubView.getUserInput();
        }
    }
}
