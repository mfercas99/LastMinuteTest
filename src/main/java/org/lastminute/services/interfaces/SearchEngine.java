package org.lastminute.services.interfaces;

import org.lastminute.services.pojo.SearchResult;

public interface SearchEngine {
	SearchResult performSearch(Integer numAdults, 
									 Integer numChild, 
									 Integer numInfant, 
									 Integer daysToDeparture, 
									 String origin, 
									 String destination);
}
