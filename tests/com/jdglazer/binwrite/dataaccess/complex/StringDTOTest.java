package com.jdglazer.binwrite.dataaccess.complex;

import org.junit.Test;

import com.jdglazer.binwrite.dataaccess.types.complex.StringDTO;
import com.jdglazer.binwrite.dataaccess.types.complex.StringPrototype;

import junit.framework.TestCase;

public class StringDTOTest extends TestCase {

	@Test
	public void testFixedLengthString() {
		StringPrototype proto = new StringPrototype("AString");
		proto.setFixedLength(true);
		proto.setLength(12);
		StringDTO dto = new StringDTO( proto );
		
		String INVALID_LENGTH_STRING = "invalid length string";
		String VALID_LENGTH_STRING = "valid length";	
		
		dto.setString(INVALID_LENGTH_STRING);
		
		assertEquals( "Length of string", 12, dto.getLength() );
		assertNull("No string set for invalid length", dto.getString());
		
		dto.setString(VALID_LENGTH_STRING);
		
		assertEquals( "Length of valid String", 12, dto.getLength() );
		assertEquals("String set for valid length", VALID_LENGTH_STRING, dto.getString());
	}
	
	@Test
	public void testVariableLengthString() {
		StringPrototype proto = new StringPrototype("AnotherString");
		StringDTO dto = new StringDTO( proto );
		
		String STRING_SET = "I am a string to set";
		
		assertEquals("Length starts at 0", 0, dto.getLength() );
		
		dto.setString(STRING_SET);
		
		assertEquals("Valid string stored", STRING_SET, dto.getString() );
		assertEquals("Valid string length provided", STRING_SET.length(), dto.getLength() );
	}

}
