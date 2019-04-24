package model;

import dao.FootballClubDao;
import dao.FootballerDao;
import table.FootballClub;
import table.Footballer;

import java.util.List;

public class FootballerModel{
    private static FootballerDao footballerDao;
    private static FootballClubDao footballClubDao;
    public FootballerModel (){
        footballerDao=new FootballerDao();
        footballClubDao=new FootballClubDao();
    }
    public boolean persist(Footballer entity, int idFc){
        footballClubDao.openCurrentSession();
        FootballClub footballClub=footballClubDao.findById(idFc);
        footballClubDao.closeCurrentSession();
        if (footballClub==null){
            return false;
        }
        entity.setFc(footballClub);
        footballerDao.openCurrentSessionwithTransaction();
        footballerDao.persist(entity);
        footballerDao.closeCurrentSessionwithTransaction();
        return true;
    }
    public void update(Footballer entity){
        footballerDao.openCurrentSessionwithTransaction();
        footballerDao.update(entity);
        footballerDao.closeCurrentSessionwithTransaction();
    }
    public boolean update(Footballer entity, int idFootballClub){
        footballClubDao.openCurrentSession();
        FootballClub footballClub=footballClubDao.findById(idFootballClub);
        footballClubDao.closeCurrentSession();
        if (footballClub==null){
            return false;
        }
        entity.setFc(footballClub);
        footballerDao.openCurrentSessionwithTransaction();
        footballerDao.update(entity);
        footballerDao.closeCurrentSessionwithTransaction();
        return true;
    }
    public Footballer findById(int id){
        footballerDao.openCurrentSession();
        Footballer footballer=footballerDao.findById(id);
        footballerDao.closeCurrentSession();
        return footballer;
    }
    public void delete(int id){
        footballerDao.openCurrentSessionwithTransaction();
        Footballer footballClub=footballerDao.findById(id);
        footballerDao.delete(footballClub);
        footballerDao.closeCurrentSessionwithTransaction();
    }
    public List<Footballer> findAll(){
        footballerDao.openCurrentSession();
        List<Footballer> fcs=footballerDao.findAll();
        footballerDao.closeCurrentSession();
        return fcs;
    }
    public void deleteAll(){
        footballerDao.openCurrentSessionwithTransaction();
        footballerDao.deleteAll();
        footballerDao.closeCurrentSessionwithTransaction();
    }
    public String footballerPrint(int idFootballer) {
        Footballer fb = findById(idFootballer);
        String result = "";
        if(fb != null)
            result = fb.toString() + "\n";
        return result;
    }
    public String footballerPrintAll() {
        List<Footballer> fcs = findAll();
        String result = "";
        for (int i=0; i<fcs.size(); i++){
            result +=footballerPrint(fcs.get(i).getIdFootballer());
        }
        return result;
    }

    public static FootballerDao getFootballer (){
        return footballerDao;
    }
}
