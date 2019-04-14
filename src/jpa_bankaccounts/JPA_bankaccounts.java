/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_bankaccounts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author eyvind
 */
public class JPA_bankaccounts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Account b = new Account(33822);
        Customer p = new Customer();
        p.setAccount(b);
        p.setName("Steve");
        JPA_bankaccounts demo = new JPA_bankaccounts();
        demo.persist(p);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("JPA_bankaccountsPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
