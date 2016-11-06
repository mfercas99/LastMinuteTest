package org.lastminute.test.dao;

import org.junit.Before;
import org.lastminute.dao.AirlineDao;
import org.lastminute.pojo.Airline;


public class AirlineDaoTest extends AbstractDaoTest<Airline, String> {
	
	@Before
	public void setUp()
	{
		this.setTester(new AirlineDao());
	}
	
}
