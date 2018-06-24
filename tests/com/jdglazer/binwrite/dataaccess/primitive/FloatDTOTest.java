package com.jdglazer.binwrite.dataaccess.primitive;

import org.junit.Test;

import com.jdglazer.binwrite.dataaccess.types.primitive.FloatDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.FloatPrototype;

import junit.framework.TestCase;

public class FloatDTOTest extends TestCase {
	
	@Test
	public void testDouble() {
		double startDouble = 2900342843.90;
		FloatPrototype proto = new FloatPrototype("uewfd");
		FloatDTO dto = new FloatDTO(proto);
		dto.setData(startDouble);
		
		assertEquals("Primitive double works", startDouble, dto.getData().doubleValue());
	}
}
