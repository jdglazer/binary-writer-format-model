package com.jdglazer.binwrite.dataaccess.primitive;

import java.util.BitSet;

import org.junit.Test;

import com.jdglazer.binwrite.dataaccess.types.primitive.BitDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.BitPrototype;

import junit.framework.TestCase;

public class BitDTOTest extends TestCase {

	@Test
	public void testBits() {
		
		boolean [] bitValues = new boolean[] { false, true, true, false, false };
		BitPrototype proto = new BitPrototype("oeuhqfbqc");
		BitDTO dto = new BitDTO(proto);
		
		dto.setData(bitValues);
		BitSet dataOut = dto.getData();
		
		assertEquals( "Invalid sized bit set returned from BitDTO", bitValues.length, dto.getLength() );
		
		for( int i = 0; i < dto.getLength(); i++ ) {
			assertEquals("Invalid bit at index "+i+" set.", bitValues[i], dataOut.get(i) );
		}	
	}
    
}
