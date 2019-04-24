package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import table.FootballClub;


import java.util.List;
import java.util.logging.Level;


public class FootballClubDao implements Dao<FootballClub>{
    private Session currentSession;
    private Transaction currentTransaction;
    public FootballClubDao(){

    }
    public Session openCurrentSession(){
        currentSession=getSessionFactory().openSession();
        return currentSession;
    }
    public Session openCurrentSessionwithTransaction(){
        currentSession=getSessionFactory().openSession();
        currentTransaction=currentSession.beginTransaction();
        return currentSession;
    }
    public void closeCurrentSession(){
        currentSession.close();
    }
    public void closeCurrentSessionwithTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }
    public SessionFactory getSessionFactory(){
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Configuration configuration=new Configuration().configure();
        configuration.addAnnotatedClass(FootballClub.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    public Session getCurrentSession(){
        return currentSession;
    }
    public void setCurrentSession(Session currentSession){
        this.currentSession=currentSession;
    }

    public Transaction getCurrentTransaction (){
        return currentTransaction;
    }
    public void setCurrentTransaction(Transaction currentTransaction){
        this.currentTransaction=currentTransaction;
    }
    public void persist(FootballClub entity){
        getCurrentSession().save(entity);
    }
    public void update(FootballClub entity){
        getCurrentSession().update(entity);
    }
    public FootballClub findById(int id){
        FootballClub fc=(FootballClub) getCurrentSession().get(FootballClub.class, id);
        return fc;
    }

    public void delete(FootballClub entity){
        getCurrentSession().delete(entity);
    }
    public List<FootballClub> findAll(){
        List<FootballClub> fcs=(List<FootballClub>) getCurrentSession().createQuery("from FootballClub").list();
        return fcs;
    }
    public void deleteAll(){
        List<FootballClub> entityList = findAll();
        for(FootballClub entity : entityList){
            delete(entity);
        }
    }
}
