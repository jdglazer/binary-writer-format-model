package com.jdglazer.binwrite.dataaccess.primitive;

import org.junit.Test;

import com.jdglazer.binwrite.dataaccess.types.primitive.BooleanDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.BooleanPrototype;

import junit.framework.TestCase;

public class BooleanDTOTest extends TestCase {
	
	@Test
	public void testBool() {
		boolean yesNo = true;
		BooleanPrototype proto = new BooleanPrototype("oeuhqfbqc");
		BooleanDTO dto = new BooleanDTO(proto);
		dto.setData(yesNo);
		
		assertEquals("Primitive boolean works", yesNo, dto.getBoolean().booleanValue());
	}
}
