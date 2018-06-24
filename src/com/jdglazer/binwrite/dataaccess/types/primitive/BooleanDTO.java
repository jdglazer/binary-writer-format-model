package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.BitSet;

import com.jdglazer.binwrite.dataaccess.DataType;

public class BooleanDTO extends PrimitiveDTO {

	public BooleanDTO(BooleanPrototype prototype) {
		super(prototype);
	}
	
    public void setData( boolean data ){
		if( prototype.getDataType().equals( DataType.BOOLEAN ) ) {
			this.data = new BitSet(1);
			this.data.set(0,data);
		}
    }
    
    public Boolean getBoolean() {
    	if( prototype.getDataType().equals(DataType.BOOLEAN) ) {
    		return data.get(0);
    	}
    	
    	return null;
    }
}
