package model;

import dao.FootballClubDao;
import dao.FootballerDao;
import table.FootballClub;
import table.Footballer;

import java.util.ArrayList;
import java.util.List;

public class FootballClubModel{
    private static FootballClubDao footballClubDao;
    public FootballClubModel (){
        footballClubDao=new FootballClubDao();
    }
    public void persist(FootballClub entity){
        footballClubDao.openCurrentSessionwithTransaction();
        footballClubDao.persist(entity);
        footballClubDao.closeCurrentSessionwithTransaction();
    }
    public void update(FootballClub entity){
        footballClubDao.openCurrentSessionwithTransaction();
        footballClubDao.update(entity);
        footballClubDao.closeCurrentSessionwithTransaction();
    }
    public FootballClub findById(int id){
        footballClubDao.openCurrentSession();
        FootballClub footballClub=footballClubDao.findById(id);
        footballClubDao.closeCurrentSession();
        return footballClub;
    }
    public void delete(int id){
        footballClubDao.openCurrentSessionwithTransaction();
        FootballClub footballClub=footballClubDao.findById(id);
        int idFootballClub=footballClub.getIdFootballClub();
        List<Footballer> footballers=new ArrayList<>();
        FootballerDao footballerDao=new FootballerDao();
        footballerDao.openCurrentSessionwithTransaction();
        footballers=footballerDao.findAll();
        for (Footballer foot:footballers){
            if (foot.getFc().getIdFootballClub()==idFootballClub){
                footballerDao.delete(foot);
                footballerDao.closeCurrentSessionwithTransaction();
            }
        }
        footballClubDao.delete(footballClub);
        footballClubDao.closeCurrentSessionwithTransaction();
    }
    public List<FootballClub> findAll(){
        footballClubDao.openCurrentSession();
        List<FootballClub> fcs=footballClubDao.findAll();
        footballClubDao.closeCurrentSession();
        return fcs;
    }
    public void deleteAll(){
        footballClubDao.openCurrentSessionwithTransaction();
        footballClubDao.deleteAll();
        footballClubDao.closeCurrentSessionwithTransaction();
    }
    public String footballClubPrint(int idFootballClub) {
        FootballClub fc = findById(idFootballClub);
        String result = "";
        if(fc != null)
            result = fc.toString() + "\n";
        return result;
    }
    public String footballClubPrintAll() {
        List<FootballClub> fcs = findAll();
        String result = "";
        for (int i=0; i<fcs.size(); i++){
            result +=footballClubPrint(fcs.get(i).getIdFootballClub());
        }
        return result;
    }

    public static FootballClubDao getFootballClubDao (){
        return footballClubDao;
    }
}
