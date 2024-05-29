package hellojpa;

import hellojpa.domain.Book;
import hellojpa.domain.Order;
import hellojpa.domain.OrderItem;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); // 영속성컨텍스트 생성

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("진관호");

            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
