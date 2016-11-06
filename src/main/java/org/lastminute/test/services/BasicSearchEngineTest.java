package org.lastminute.test.services;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lastminute.services.BasicSearchEngine;
import org.lastminute.services.interfaces.SearchEngine;
import org.lastminute.services.pojo.ResultItem;
import org.lastminute.services.pojo.SearchResult;



public class BasicSearchEngineTest {
	
	List<ResultItem> itemsResExample1;
	List<ResultItem> itemsResExample2;
	List<ResultItem> itemsResExample3;
	List<ResultItem> itemsResExample4;
	
	@Before
	public void setUp(){
		
		/*****EXAMPLE 1*****/
		
		itemsResExample1 = new ArrayList<ResultItem>();
		ResultItem r1 = new ResultItem();
		ResultItem r2 = new ResultItem();
		ResultItem r3 = new ResultItem();

		r1.setFlightCode("TK2659");
		r1.setTotalPrice(new BigDecimal("198.40"));
		
		r2.setFlightCode("LH5909");
		r2.setTotalPrice(new BigDecimal("90.40"));
		
		r3.setFlightCode("TK2372");
		r3.setTotalPrice(new BigDecimal("157.60"));
		
		itemsResExample1.add(r1);
		itemsResExample1.add(r2);
		itemsResExample1.add(r3);
		
		/*****EXAMPLE 2*****/
		itemsResExample2 = new ArrayList<ResultItem>();
		r1 = new ResultItem();
		r2 = new ResultItem();

		r1.setFlightCode("LH1085");
		r1.setTotalPrice(new BigDecimal("481.19"));
		
		r2.setFlightCode("TK8891");
		r2.setTotalPrice(new BigDecimal("806.00"));

		itemsResExample2.add(r1);
		itemsResExample2.add(r2);
		
		/*****EXAMPLE 3*****/
		itemsResExample3 = new ArrayList<ResultItem>();
		r1 = new ResultItem();
		r2 = new ResultItem();
		
		r1.setFlightCode("LH5496");
		r1.setTotalPrice(new BigDecimal("1028.43"));
		
		r2.setFlightCode("IB2171");
		r2.setTotalPrice(new BigDecimal("909.09"));
		

		itemsResExample3.add(r1);
		itemsResExample3.add(r2);
		
		/*****EXAMPLE 4*****/
		itemsResExample4 = new ArrayList<ResultItem>();
	}
	
	@Test
	public void testSearchEngine(){
		SearchEngine tester = new BasicSearchEngine();

		//* 1 adult, 31 days to the departure date, flying AMS -> FRA
		int numAdult = 1;
		int numChild = 0;
		int numInfant = 0;
		int daysPrior = 31;
		String origin = "AMS";
		String destination = "FRA";
		SearchResult res = tester.performSearch(numAdult, numChild, numInfant, daysPrior, origin, destination);
		Assert.assertEquals(res.getResulList(), itemsResExample1);
		

		//2 adults, 1 child, 1 infant, 15 days to the departure date, flying LHR -> IST
		numAdult = 2;
		numChild = 1;
		numInfant = 1;
		daysPrior = 15;
		origin = "LHR";
		destination = "IST";
		res = tester.performSearch(numAdult, numChild, numInfant, daysPrior, origin, destination);
		Assert.assertEquals(res.getResulList(), itemsResExample2);
		
		// 1 adult, 2 children, 2 days to the departure date, flying BCN -> MAD
		numAdult = 1;
		numChild = 2;
		numInfant = 0;
		daysPrior = 2;
		origin = "BCN";
		destination = "MAD";
		res = tester.performSearch(numAdult, numChild, numInfant, daysPrior, origin, destination);
		Assert.assertEquals(res.getResulList(), itemsResExample3);
		
		// CDG -> FRA
		numAdult = 1;
		numChild = 1;
		numInfant = 1;
		daysPrior = 15;
		origin = "CDG";
		destination = "FRA";
		res = tester.performSearch(numAdult, numChild, numInfant, daysPrior, origin, destination);
		Assert.assertEquals(res.getResulList(), itemsResExample4);

	}
	
}
