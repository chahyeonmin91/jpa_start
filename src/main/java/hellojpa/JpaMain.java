package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            //비영속
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//
//            //영속
//            em.persist(member);

//            member.setName("ZZZZ");
//            if (member.getName().equals("ZZZZ")) {
//                em.persist(member);
//
//            }

            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");

            em.clear();

            Member member2 = em.find(Member.class, 150L);

//            em.flush();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
