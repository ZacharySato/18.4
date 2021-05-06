package ru.fintech.qa.homework.db.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.fintech.qa.homework.db.hibernate.models.Animal;
import ru.fintech.qa.homework.db.hibernate.models.Places;
import ru.fintech.qa.homework.db.hibernate.models.Positions;
import ru.fintech.qa.homework.db.hibernate.models.Sex;
import ru.fintech.qa.homework.db.hibernate.models.Workman;
import ru.fintech.qa.homework.db.hibernate.models.Zoo;
import ru.fintech.qa.homework.db.hibernate.models.ZooAnimal;

public final class HibernateSessionCreator {
    private static SessionFactory session;

    public static SessionFactory getSessionFactory() {
        if (session == null) {
            session = new Configuration().configure().
                    addAnnotatedClass(Animal.class).
                    addAnnotatedClass(Places.class).
                    addAnnotatedClass(Positions.class).
                    addAnnotatedClass(Sex.class).
                    addAnnotatedClass(Workman.class).
                    addAnnotatedClass(Zoo.class).
                    addAnnotatedClass(ZooAnimal.class).
                    buildSessionFactory();
        }
        return session;
    }
}