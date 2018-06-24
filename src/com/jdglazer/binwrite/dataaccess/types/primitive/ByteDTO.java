package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.BitSet;

import com.jdglazer.binwrite.dataaccess.DataType;

public class ByteDTO extends PrimitiveDTO {

	public ByteDTO(BytePrototype prototype) {
		super(prototype);
	}
	
    public void setData( byte data ){
		BitSet bits = new BitSet(8);
		for( int i = 0 ; i < 8 ; i++ ) {
			int set = data >> ( 7 - i) & 1;
		    bits.set(i, set == 1 ? true : false);
		}
		this.data = bits;
    }
    
    public Byte getByte() {
    	if( prototype.getDataType().equals( DataType.BYTE ) ) {
    		int i = 0;
    		for( int j = 0; j < 8 ; j++ ) {
				if( data.get(j) ) {
					i |= 1 << (7 - j);
				}
			}
    		return (byte) i;
    	}
    	return null;
    }
}
