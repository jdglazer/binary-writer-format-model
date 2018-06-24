package com.jdglazer.binwrite.dataaccess.primitive;

import org.junit.Test;

import com.jdglazer.binwrite.dataaccess.types.primitive.CharDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.CharPrototype;

import junit.framework.TestCase;

public class CharDTOTest extends TestCase {
	
	@Test
	public void testChar() {
		char startChar = 'g';
		CharPrototype proto = new CharPrototype("ipwdjnl");
		CharDTO dto = new CharDTO(proto);
		dto.setData(startChar);
		
		assertEquals("Primitive character works", startChar, dto.getData().charValue());
	}
}
