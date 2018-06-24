package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.BitSet;

import com.jdglazer.binwrite.dataaccess.DataType;

public class IntegerDTO extends PrimitiveDTO {

	public IntegerDTO(IntegerPrototype prototype) {
		super(prototype);
	}
	
	public void setData( int data ) {
		if( prototype.getDataType().equals( DataType.INTEGER ) || prototype.getDataType().equals( DataType.UNSIGNED_INTEGER ) ) {
			BitSet bits = new BitSet(32);
			for( int i = 0 ; i < 32 ; i++ ) {
				int set = data >> ( 31 - i) & 1;
			    bits.set(i, set == 1 ? true : false);
			}
			this.data = bits;
		}
	}
	
	public void setData( long data ) {
		if( prototype.getDataType().equals( DataType.INTEGER ) || prototype.getDataType().equals( DataType.UNSIGNED_INTEGER ) ) {
			BitSet bits = new BitSet(64);
			for( int i = 0 ; i < 64 ; i++ ) {
				long set = data >> ( 63 - i) & 1;
			    bits.set(i, set == 1L ? true : false);
			}
			this.data = bits;
		}
	}
	
    public Long getLong() {
    	if( prototype.getDataType().equals( DataType.INTEGER ) ) {
			long i = 0;
			for( int j = 0; j < 64 ; j++ ) {
				if( data.get(j) ) {
					i |= 1L << (63 - j );
				}
			}
			return new Long(i);
		}
		return null;
    }
    
    public Integer getInt() {
		if( prototype.getDataType().equals( DataType.INTEGER ) ) {
			int i = 0;
			for( int j = 0; j < 32 ; j++ ) {
				if( data.get(j) ) {
					i |= 1 << (31 - j );
				}
			}
			return new Integer(i);
		}
		return null;
    }
}
