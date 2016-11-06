package org.lastminute.test.suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.lastminute.test.dao.AirlineDaoTest;
import org.lastminute.test.dao.AirportDaoTest;
import org.lastminute.test.dao.DaysPercentageDaoTest;
import org.lastminute.test.dao.FlightDaoTest;
import org.lastminute.test.dao.PassengerDaoTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AirlineDaoTest.class,
  AirportDaoTest.class,
  DaysPercentageDaoTest.class,
  FlightDaoTest.class,
  PassengerDaoTest.class
})

public class DaoSuitTest {

}
