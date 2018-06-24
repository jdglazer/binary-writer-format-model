package com.jdglazer.binwrite.dataaccess.primitive;

import org.junit.Test;

import com.jdglazer.binwrite.dataaccess.types.primitive.IntegerDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.IntegerPrototype;

import junit.framework.TestCase;

public class IntegerDTOTest extends TestCase {
	
	@Test
	public void testInt() {
		int startInt = 23135;
		IntegerPrototype proto = new IntegerPrototype("ouhuoqe");
		IntegerDTO dto = new IntegerDTO(proto);
		dto.setData(startInt);
		
		assertEquals("Primitive integer works", startInt, dto.getInt().intValue());
	}
	
	@Test
	public void testLong() {
		long startLong = 2900342843L;
		IntegerPrototype proto = new IntegerPrototype("oufn");
		IntegerDTO dto = new IntegerDTO(proto);
		dto.setData(startLong);
		
		assertEquals("Primitive long works", startLong, dto.getLong().longValue());
	}
}
