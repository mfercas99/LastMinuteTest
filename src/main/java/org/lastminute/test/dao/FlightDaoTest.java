package org.lastminute.test.dao;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import org.lastminute.dao.FlightDao;
import org.lastminute.pojo.Flight;
import org.lastminute.test.dao.interfaces.DaoTestUnit;

public class FlightDaoTest extends AbstractDaoTest<Flight, String> implements DaoTestUnit<Flight, String>{
	
	
	@Before
	public void setUp()
	{
		this.setTester(new FlightDao());
	}
	
	@Override
	@Test
	public void testDaoMethods() 
	{
		super.testDaoMethods();
		
		FlightDao tester =  ((FlightDao)this.getTester());
		Flight item = tester.getRecords().entrySet().iterator().next().getValue();
		Map<String, Flight> itemsByOrgDest = tester.getByOriginDestination(item.getOrigin(), item.getDestination());
		String message = tester.getClass().getName() + "; Method itemsByOrgDest is not working for codes ORG: ";
		message +=   item.getOrigin().getCode() + " DEST: " + item.getDestination().getCode();
		Assert.assertTrue(message, itemsByOrgDest != null && itemsByOrgDest.size() >= 1);
	}
}
