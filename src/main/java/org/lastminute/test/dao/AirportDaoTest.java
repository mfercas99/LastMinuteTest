package org.lastminute.test.dao;

import org.junit.Before;
import org.lastminute.dao.AirportDao;
import org.lastminute.pojo.Airport;
import org.lastminute.test.dao.interfaces.DaoTestUnit;

public class AirportDaoTest extends AbstractDaoTest<Airport, String> implements DaoTestUnit<Airport, String>{

	@Before
	public void setUp()
	{
		this.setTester(new AirportDao());
	}
	
}
