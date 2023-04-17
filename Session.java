public class Session {
    final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

try(
    Session session = sessionFactory.openSession())

    {
        Transaction transaction = session.beginTransaction();

        // wykonanie operacji bazodanowych

        if (success) {
            transaction.commit();
        } else {
            transaction.rollback();
        }
    }
}
