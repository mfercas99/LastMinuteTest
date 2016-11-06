package org.lastminute.test.dao;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.lastminute.dao.PassengerDao;
import org.lastminute.pojo.Passenger;

import junit.framework.Assert;

public class PassengerDaoTest {
	
	PassengerDao tester;
	
	@Before
	public void setUp()
	{
		tester = new PassengerDao();
	}
	
	@Test	
	public void testDAOMethods() 
	{
		Map<String, Passenger> records = tester.getRecords();
		Assert.assertTrue(tester.getClass().getName() + " not loading records! Check the file " + tester.getFileName(), records != null && records.size() > 0);
		Passenger item = (Passenger) records.entrySet().iterator().next().getValue();
		Assert.assertTrue(tester.getClass().getName() + " not working for code " + item.getCode(), tester.getByCode(item.getCode()) != null);
	}
}
