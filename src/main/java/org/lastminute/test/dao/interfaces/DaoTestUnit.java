package org.lastminute.test.dao.interfaces;

import org.lastminute.pojo.interfaces.DomainObject;

public interface DaoTestUnit<T extends DomainObject<E>, E> {

	void setUp();

	void testDaoMethods();

}
