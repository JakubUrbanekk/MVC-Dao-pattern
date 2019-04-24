package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import table.FootballClub;
import table.Footballer;
import table.Footballer;

import java.util.List;
import java.util.logging.Level;

public class FootballerDao implements Dao<Footballer>{
    private Session currentSession;
    private Transaction currentTransaction;
    public FootballerDao(){

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
        configuration.addAnnotatedClass(Footballer.class);
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
    public void persist(Footballer entity){
        getCurrentSession().save(entity);
    }
    public void update(Footballer entity){
        getCurrentSession().update(entity);
    }
    public Footballer findById(int id){
        Footballer fc=(Footballer) getCurrentSession().get(Footballer.class, id);
        return fc;
    }

    public void delete(Footballer entity){
        getCurrentSession().delete(entity);
    }
    public List<Footballer> findAll(){
        List<Footballer> fcs=(List<Footballer>) getCurrentSession().createQuery("from Footballer").list();
        return fcs;
    }
    public void deleteAll(){
        List<Footballer> entityList = findAll();
        for(Footballer entity : entityList){
            delete(entity);
        }
    }
}
