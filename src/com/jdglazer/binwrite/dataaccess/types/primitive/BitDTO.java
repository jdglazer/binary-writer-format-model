package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.BitSet;

import com.jdglazer.binwrite.dataaccess.DataType;

public class BitDTO extends PrimitiveDTO {
	
	private int length;

	public BitDTO(BitPrototype prototype) {
		super(prototype);
		length = 0;
	}
	
    public void setData( boolean [] data ) {
    	
    	BitSet bits = new BitSet();
    	
        if( data != null ) {

        	for( int i = 0; i < data.length ; i++ ) {
        		bits.set(i,data[i]);
        	}
        	this.length = data.length;
        	
        } else {
        	this.length = 0;
        }
        
        this.data = bits;
			
	}
    
    public BitSet getData() {
    	if( prototype.getDataType().equals( DataType.BIT ) ) {
    		return data;
    	}
    	return null;
    }

	public int getLength() {
		return length;
	}

}
