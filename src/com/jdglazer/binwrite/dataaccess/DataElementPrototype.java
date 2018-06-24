package com.jdglazer.binwrite.dataaccess;

import java.util.HashMap;
import java.util.Map;

public class DataElementPrototype {
	
    private String name;
    
    private String description;
    
    private final DataType DATA_TYPE;
    
    protected DataElementPrototype( DataType dataType, String name ) {
    	this.DATA_TYPE = dataType;
    	this.name = name;
    }
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DataType getDataType() {
		return DATA_TYPE;
	}
	public Map<String,String> getAttributes() {
		
		HashMap<String,String> attrs = new HashMap<String,String>();
		
		attrs.put("name", name );
		
		if( description != null  ) {
			
		    attrs.put( "description", description );	
		}
		
		return attrs;
	}
}
