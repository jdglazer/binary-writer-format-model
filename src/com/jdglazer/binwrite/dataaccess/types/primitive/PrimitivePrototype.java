package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.Map;

import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;

public abstract class PrimitivePrototype extends DataElementPrototype {
    // Length in bits. Each class extending this object should set the default for this.
	private Integer length;
	
	//Is the value a constant
	private boolean fixed;
	
	//A default value for the primitive in string form
	private String value;
	
	public PrimitivePrototype(DataType dataType, String name) {
		super(dataType,name);
		//set defaults
		this.length = null;
		this.fixed = false;
		this.value=null;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public Map<String, String> getAttributes() {
		
		Map<String,String> attrs = super.getAttributes();
		
		attrs.put("value", value);

		attrs.put("fixed", Boolean.toString(fixed) );
		
		if( length != null ) {
			attrs.put("length", length.toString());
		}
		
		return attrs;
	}
    
}
