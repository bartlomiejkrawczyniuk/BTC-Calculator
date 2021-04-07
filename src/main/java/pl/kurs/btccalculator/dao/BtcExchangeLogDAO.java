package pl.kurs.btccalculator.dao;

import pl.kurs.btccalculator.model.AbstractBtcExchangeLog;

public interface BtcExchangeLogDAO {

    void save(AbstractBtcExchangeLog btcExchangeLog);

    int getEntitiesAmount();

}
