package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.BitSet;

import com.jdglazer.binwrite.dataaccess.DataType;

public class CharDTO extends PrimitiveDTO {

	public CharDTO(CharPrototype prototype) {
		super(prototype);
	}
	
    public void setData( char data ){
		if( prototype.getDataType().equals( DataType.CHAR ) ) {
			BitSet bits = new BitSet(8);
			for( int i = 0 ; i < 8 ; i++ ) {
				int set = ( (int) data ) >> ( 7 - i) & 1;
			    bits.set(i, set == 1 ? true : false);
			}
			this.data = bits;
		}
    }
    
    public Character getData() {
    	if( prototype.getDataType().equals( DataType.CHAR ) ) {
    		int i = 0;
    		for( int j = 0; j < 8 ; j++ ) {
				if( data.get(j) ) {
					i |= 1 << (7 - j);
				}
			}
    		return (char) i;
    	}
    	return null;
    }
}
