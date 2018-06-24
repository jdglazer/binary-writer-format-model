package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.nio.ByteBuffer;
import java.util.BitSet;

import com.jdglazer.binwrite.dataaccess.DataType;

public class FloatDTO extends PrimitiveDTO {

	public FloatDTO(FloatPrototype prototype) {
		super(prototype);
	}
	
    public void setData( double data ) {
		if( prototype.getDataType().equals( DataType.FLOAT ) || prototype.getDataType().equals( DataType.UNSIGNED_FLOAT ) ) {
			BitSet bits = new BitSet(64);
			for( int i = 0 ; i < 64 ; i++ ) {
				long set = Double.doubleToLongBits(data) >> ( 63 - i) & 1;
			    bits.set(i, set == 1L ? true : false);
			}
			this.data = bits;
		}
	}
    
    public Double getData() {
		if( prototype.getDataType().equals( DataType.FLOAT ) ) {
			if( data.size() == 64) {
				long i = 0;
				if( data.size() == 64 ) {
					for( int j = 0; j < 64 ; j++ ) {
						if( data.get(j) ) {
							i |= 1L << (63 - j );
						}
					}
					return Double.longBitsToDouble(i);
				}
				return ByteBuffer.allocate(8).put(data.toByteArray()).getDouble();
			}
		}
		return null;
    }
}
