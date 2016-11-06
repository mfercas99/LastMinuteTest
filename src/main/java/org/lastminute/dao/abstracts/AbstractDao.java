package org.lastminute.dao.abstracts;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import org.lastminute.dao.interfaces.DaoInterface;
import org.lastminute.pojo.interfaces.DomainObject;

public abstract class AbstractDao<T extends DomainObject<E>, E> implements DaoInterface<T, E>{
	
	private final String filePath = Paths.get("").toAbsolutePath().toString()  + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "files";
	private String fileName;
	private String splitBy;
	private Map<E, T> records;
	
	public String getFileName(){
		return this.fileName;
	}
	
	
	protected AbstractDao(String fileName, String splitBy){
		this.fileName = fileName;
		this.splitBy = splitBy;
		this.reloadRecords();
	}
	
	protected void reloadRecords() 
	{
		Stream<String> lines = null;
		try {
			this.records = new HashMap<E, T>();
			lines = Files.lines(Paths.get(this.filePath, this.fileName));
			Iterator<String> it = lines.iterator();
			String line = it.next(); // header
			while(it.hasNext())
			{
				line = it.next();
				T obj = getObjectFromLine(line);
				getRecords().put(obj.getCode(), obj);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public T getByCode(E code){
		return this.getRecords().get(code);
	}
	
	
	protected String getSplitBy(){
		return this.splitBy;
	}
	

	public Map<E, T> getRecords() {
		return records;
	}
	
	protected abstract T getObjectFromLine(String line);
	

}
