package com.jdglazer.binwrite.dataaccess.primitive;

import org.junit.Test;

import com.jdglazer.binwrite.dataaccess.types.primitive.ByteDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.BytePrototype;

import junit.framework.TestCase;

public class ByteDTOTest extends TestCase {
	
	@Test
	public void testByte() {
		byte startByte = (byte) 214;
		BytePrototype proto = new BytePrototype("uoehqfbc");
		ByteDTO dto = new ByteDTO(proto);
		dto.setData(startByte);
		
		assertEquals("Primitive byte works", startByte, dto.getByte().byteValue());
	}
}
