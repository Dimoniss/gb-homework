package com.flamexander.hibernate.crud;

import com.flamexander.hibernate.PrepareDataApp;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Почитать про (оптимистичные и пеммиситчиные блокировки) и посомтреть как они реализованы в hibernate (реализовать)
 * Запрос поиска по фильтру (Фильтр - объект у которого есть название поля, тип операции [eq ==, noteq !=, like, gt >, lt<], значение)
 * с использование criteria api
 *
 * * * Spring AOP
 */
public class CrudApp {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void showManyItems() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            List<SimpleItem> items = session.createQuery("from SimpleItem").getResultList();
            System.out.println(items + "\n");

            SimpleItem si1 = session.createQuery("select s from SimpleItem s where s.id = 3", SimpleItem.class).getSingleResult();
            System.out.println(si1 + "\n");

            session.createNamedQuery("byIdSelect", SimpleItem.class)
                    .setParameter("id", 3L).getSingleResult();

            session.get(SimpleItem.class, 3L);
            session.get(SimpleItem.class, 3L);
            session.get(SimpleItem.class, 3L);

            List<SimpleItem> cheapItems = session.createQuery("select s from SimpleItem s where s.price < 80").getResultList();
            System.out.println(cheapItems + "\n");

            session.getTransaction().commit();
        }
    }

    public static void showCache() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.get(SimpleItem.class, 3L);
            session.get(SimpleItem.class, 3L);
            session.get(SimpleItem.class, 3L);
            session.getTransaction().commit();
        }

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.get(SimpleItem.class, 3L);
            session.get(SimpleItem.class, 3L);
            session.get(SimpleItem.class, 3L);
            session.getTransaction().commit();
        }

//        try (Session session = factory.getCurrentSession()) {
//            NativeQuery nativeQuery = session.createNativeQuery("update hiber.simple_items set title = 'new' where id = 1");
//            nativeQuery.addSynchronizedEntityClass(SimpleItem.class);
//            nativeQuery.executeUpdate();
//        }

//        CacheManager.ALL_CACHE_MANAGERS.get(0)
//                .getCache("ds")
    }

    public static void shutdown() {
        factory.close();
    }

    public static void createExample() {
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                SimpleItem dragonStatue = new SimpleItem(null, "Dragon Statue", 100);
                System.out.println(dragonStatue);
                session.save(dragonStatue);
//                session.merge(dragonStatue);
                final SimpleItem simpleItem = session.get(SimpleItem.class, 1L);
                simpleItem.setTitle("newTitle");
                System.out.println(dragonStatue);
                session.getTransaction().commit();
                System.out.println(dragonStatue);
            } catch (Exception exception) {
                session.getTransaction().rollback();
            }
        }
    }

    public static void readAndPrintExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
//            session.enableFilter("bigPrice").setParameter("price_param", 15);
//            List from_simpleItem_ = session.createQuery("from SimpleItem ").getResultList();
            SimpleItem simpleItem = session.get(SimpleItem.class, 1L, LockMode.OPTIMISTIC);
            System.out.println(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static void updateExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 5L);
            simpleItem.setPrice(10000);
            session.getTransaction().commit();
        }
    }

    public static void deleteExample() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 1L);
            session.delete(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        try {
            init();
//            createExample();
//            readAndPrintExample();
//             updateExample();
//             deleteExample();
//            showCache();
            showManyItems();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
}
