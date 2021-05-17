package com.github.repository;

import com.github.entity.Tournament;
import com.github.entity.User;
import com.github.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Repository {

    public Tournament save(Tournament tournament) {
        Transaction transaction = null;
        System.out.println(tournament);
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tournament);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return tournament;
    }

    public User save(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public User findByEmail(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> cr = cb.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            cr.select(root).where(cb.equal(root.get("email"), user.getEmail()));
            Query<User> query = session.createQuery(cr);
            List<User> results = query.getResultList();
            if (results.size() != 0) user = results.get(0);
            else user = null;
            Hibernate.initialize(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    public User findByNickname(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> cr = cb.createQuery(User.class);
            Root<User> root = cr.from(User.class);
            cr.select(root).where(cb.equal(root.get("nickname"), user.getNickname()));
            Query<User> query = session.createQuery(cr);
            List<User> results = query.getResultList();
            if (results.size() != 0) {user = results.get(0);}
            else {user = null;}
            Hibernate.initialize(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Tournament findByName(Tournament tournament) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Tournament> cr = cb.createQuery(Tournament.class);
            Root<Tournament> root = cr.from(Tournament.class);
            cr.select(root).where(cb.equal(root.get("tourName"), tournament.getTourName()));
            Query<Tournament> query = session.createQuery(cr);
            List<Tournament> results = query.getResultList();
            if (results.size() != 0) {tournament = results.get(0);}
            else {tournament = null;}
            Hibernate.initialize(tournament);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tournament;
    }

    public List<Tournament> findByDate(Tournament tournament) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Tournament> cr = cb.createQuery(Tournament.class);
            Root<Tournament> root = cr.from(Tournament.class);
            cr.select(root).where(cb.gt(root.get("startDate"), tournament.getStartDate()));
            Query<Tournament> query = session.createQuery(cr);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public List<Tournament> findByPlace(Tournament tournament) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Tournament> cr = cb.createQuery(Tournament.class);
            Root<Tournament> root = cr.from(Tournament.class);
            cr.select(root).where(cb.equal(root.get("place"), tournament.getPlace()));
            Query<Tournament> query = session.createQuery(cr);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public List<User> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("select p from User p", User.class).list();
        }
    }

    public List<Tournament> findAllTournaments() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("select p from Tournament p", Tournament.class).list();
        }
    }

    public void update(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        UsersRepository usersRepository = new UsersRepository();
//        usersRepository.save(new User());
//    }

}
