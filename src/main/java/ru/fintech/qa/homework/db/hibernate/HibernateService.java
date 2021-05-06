package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.fintech.qa.homework.db.hibernate.models.Animal;
import ru.fintech.qa.homework.db.hibernate.models.Places;
import ru.fintech.qa.homework.db.hibernate.models.Zoo;

import java.util.List;

public class HibernateService {

    public static List<Animal> getAnimals() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Animal> result = session.createNativeQuery("SELECT * FROM animal", Animal.class).list();
        session.close();
        return result;
    }

    public static List<Zoo> getZoos() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Zoo> result = session.createNativeQuery("SELECT * FROM zoo", Zoo.class).list();
        session.close();
        return result;
    }

    public static List<Places> getPlaces() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Places> result = session.createNativeQuery("SELECT * FROM places", Places.class).list();
        session.close();
        return result;
    }

    public static void putPlaces(final Places place) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(place);
        transaction.commit();
        session.close();
    }

    public static void putAnimal(final Animal animal) {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(animal);
        transaction.commit();
        session.close();
    }

}