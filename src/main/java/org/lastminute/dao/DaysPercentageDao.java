package org.lastminute.dao;

import java.util.Map.Entry;

import org.lastminute.dao.abstracts.AbstractDao;
import org.lastminute.pojo.DaysPercentage;

public class DaysPercentageDao extends AbstractDao<DaysPercentage, Integer>{

	public DaysPercentageDao(){
		super("daysPercentage.csv", ",");
	}

	@Override
	protected DaysPercentage getObjectFromLine(String line) {
		String [] d = line.split(this.getSplitBy());
		DaysPercentage obj = new DaysPercentage();
		obj.setCode(new Integer(d[0]));
		obj.setTopDaysRange(new Integer(d[0]));
		obj.setMinDaysRange(new Integer(d[1]));
		obj.setPercentage(new Double(d[2]));
		return obj;
	}

	public DaysPercentage getByPriorDays(Integer daysToDeparture) {
		DaysPercentage resul = null;
		if(this.getRecords().containsKey(daysToDeparture)){
			return this.getRecords().get(daysToDeparture);
		}
		for(Entry<Integer, DaysPercentage> e : this.getRecords().entrySet()){
			DaysPercentage daysPercentage = e.getValue();
			if(daysPercentage.getTopDaysRange() >= daysToDeparture && daysPercentage.getMinDaysRange() <= daysToDeparture){
				return daysPercentage;
			}
		}
		return resul;
	}

	
}
