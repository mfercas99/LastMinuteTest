package org.lastminute.test.dao;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.lastminute.dao.abstracts.AbstractDao;
import org.lastminute.pojo.interfaces.DomainObject;
import org.lastminute.test.dao.interfaces.DaoTestUnit;

public abstract class AbstractDaoTest<T extends DomainObject<E>, E> implements DaoTestUnit<T, E>{

	private AbstractDao<T, E> tester;
	
	@Test
	public void testDaoMethods(){
		Map<E, T> records = tester.getRecords();
		Assert.assertTrue(tester.getClass().getName() +  " not loading records! Check the file " + tester.getFileName(), records != null && records.size() > 0);
		DomainObject<E> object = (DomainObject<E>) records.entrySet().iterator().next().getValue();
		Assert.assertTrue(tester.getClass().getName() +  "Method: getCode is not working. Code: " + object.getCode().toString(), tester.getByCode(object.getCode()) != null);
	}
	
	public abstract void setUp();

	protected AbstractDao<T, E> getTester() {
		return tester;
	}

	protected void setTester(AbstractDao<T, E> tester) {
		this.tester = tester;
	}
	
}
