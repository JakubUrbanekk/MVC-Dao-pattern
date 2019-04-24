package controller;

import model.FootballerModel;
import table.Footballer;
import view.FootballerView;

public class FootballerController{
    FootballerModel footballerModel;
    FootballerView footballerView;

    public FootballerController() {
        footballerModel = new FootballerModel();
        footballerView = new FootballerView();
    }

    public void executeFootballerController() {
        footballerView.printMenu();
        int userInput = footballerView.getUserInput();
        while (userInput != 8) {
            switch (userInput) {
                case 1: {
                    String footballerName = footballerView.askForName();
                    String footballerSurname = footballerView.askForSurname();
                    int footballerAge = footballerView.askForAge();
                    int footballClubId = footballerView.askForFootballClub();
                    Footballer fb=new Footballer(footballerName, footballerSurname, footballerAge);
                    boolean created=footballerModel.persist(fb, footballClubId);
                    if (created==true)
                    footballerView.addedComm();
                    else
                        footballerView.fcErrorComm();
                    break;
                }
                case 2: {
                    String allFootballers = footballerModel.footballerPrintAll();
                    footballerView.printAllFootballers(allFootballers);
                    break;
                }
                case 3: {
                    int footballerId = footballerView.askForId();
                    String footballerString = footballerModel.footballerPrint(footballerId);
                    if(footballerString != "")
                        footballerView.printFootballer(footballerString);
                    else
                        footballerView.errorComm();
                    break;
                }
                case 4: {
                    int footballerId = footballerView.askForId();
                    Footballer footballer=footballerModel.findById(footballerId);
                    if (footballer!=null){
                        String firstName = footballerView.askForName();
                        String surname = footballerView.askForSurname();
                        int age = footballerView.askForAge();
                        footballer.setAge(age);
                        footballer.setFirstName(firstName);
                        footballer.setSecondName(surname);
                        footballerModel.update(footballer);
                        footballerView.updatedComm();
                    }
                    else
                        footballerView.errorComm();
                    break;
                }
                case 5: {
                    int idFootballer = footballerView.askForId();
                    Footballer footballer=footballerModel.findById(idFootballer);
                    if (footballer!=null){
                        int idFoorballClub = footballerView.askForFootballClub();
                        if (footballerModel.update(footballer, idFoorballClub))
                        footballerView.updatedComm();
                        else {
                            footballerView.fcErrorComm();
                        }
                    }
                    else
                        footballerView.errorComm();
                    break;
                }
                case 6: {
                    int idFootballer = footballerView.askForId();
                    Footballer footballer= footballerModel.findById(idFootballer);
                    if (footballer!=null){
                        footballerModel.delete(idFootballer);
                        footballerView.updatedComm();
                    }
                    else
                        footballerView.errorComm();
                    break;
                }
                case 7: {
                    footballerModel.deleteAll();
                    footballerView.deletedComm();
                    break;

                }
                case 8: {
                    return;
                }
                default: {
                    System.out.println("Unknown command!");
                    break;
                }
            }
            footballerView.printMenu();
            userInput = footballerView.getUserInput();
        }
    }
}
