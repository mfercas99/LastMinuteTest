package org.lastminute.test.dao;

import org.junit.Before;
import org.lastminute.dao.DaysPercentageDao;
import org.lastminute.pojo.DaysPercentage;
import org.lastminute.test.dao.interfaces.DaoTestUnit;

import junit.framework.Assert;

public class DaysPercentageDaoTest extends AbstractDaoTest<DaysPercentage, Integer> implements DaoTestUnit<DaysPercentage, Integer>{
	
	
	@Before
	public void setUp()
	{
		this.setTester(new DaysPercentageDao());
	}
	
	
	@Override	
	public void testDaoMethods() 
	{
		super.testDaoMethods();
		DaysPercentage itemByDays = ((DaysPercentageDao) this.getTester()).getByPriorDays(15);
		Assert.assertTrue("DaysPercentageDAO.getByPriorDays not working for 15 prior days! ", itemByDays != null);
	}
}
