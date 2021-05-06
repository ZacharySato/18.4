package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.fintech.qa.homework.db.hibernate.models.Animal;
import ru.fintech.qa.homework.db.hibernate.models.Places;
import ru.fintech.qa.homework.db.hibernate.models.Zoo;
import java.util.List;

public class DBClient {
    private static final SessionFactory SESSION_FACTORY = HibernateSessionCreator.getSessionFactory();

    public static List<Animal> getAnimals() {
        Session session = SESSION_FACTORY.openSession();
        List<Animal> result = session.createNativeQuery("SELECT * FROM animal", Animal.class).list();
        session.close();
        return result;
    }

    public static List<Zoo> getZoos() {
        Session session = SESSION_FACTORY.openSession();
        List<Zoo> result = session.createNativeQuery("SELECT * FROM zoo", Zoo.class).list();
        session.close();
        return result;
    }

    public static List<Places> getPlaces() {
        Session session = SESSION_FACTORY.openSession();
        List<Places> result = session.createNativeQuery("SELECT * FROM places", Places.class).list();
        session.close();
        return result;
    }

    public static <T> void putRecord(final T record) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(record);
        transaction.commit();
        session.close();
    }


}