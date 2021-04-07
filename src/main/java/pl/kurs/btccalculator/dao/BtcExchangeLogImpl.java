package pl.kurs.btccalculator.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.btccalculator.model.AbstractBtcExchangeLog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class BtcExchangeLogImpl implements BtcExchangeLogDAO {

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Override
    public void save(AbstractBtcExchangeLog btcExchangeLog) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(btcExchangeLog);
        tx.commit();
        entityManager.close();
    }

    @Override
    public int getEntitiesAmount(){
        EntityManager entityManager = factory.createEntityManager();
        int result = entityManager.createNativeQuery("select * from bitcoin_sell_log.btcexchangelog;").getResultList().size();
        entityManager.close();
        return result;
    }
}
