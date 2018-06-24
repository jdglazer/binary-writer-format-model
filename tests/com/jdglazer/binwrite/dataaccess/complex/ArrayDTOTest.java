package com.jdglazer.binwrite.dataaccess.complex;

import org.junit.Test;

import static org.junit.Assert.*;

import com.jdglazer.binwrite.dataaccess.types.complex.ArrayDTO;
import com.jdglazer.binwrite.dataaccess.types.complex.ArrayPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.CharDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.CharPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.IntegerDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.IntegerPrototype;

import junit.framework.TestCase;

public class ArrayDTOTest extends TestCase {

	@Test
	public void testPrimitiveVariableIntArray() {
		IntegerPrototype protoElement = new IntegerPrototype("fdaf");
		ArrayPrototype proto = new ArrayPrototype(protoElement,"dfafda");
		ArrayDTO dto = new ArrayDTO(proto);
		
		for( int i = 0 ; i < 8; i++ ) {
			IntegerDTO primitive = new IntegerDTO(protoElement);
			primitive.setData(i*11);
			dto.appendElement(primitive);
		}
		
		int [] values = new int[8];
		for( int i = 0 ; i < 8; i++ ) {
			IntegerDTO value = (IntegerDTO) dto.getElement(i);
			values[i] = value.getInt();
		}
		
		assertArrayEquals("Variable length primitive int array values", new int[]{0,11,22,33,44,55,66,77}, values);
		assertEquals("Correct length primitive int array stored", 8, dto.getLength());
	}

	@Test
	public void testPrimitiveFixedIntArray() {
		IntegerPrototype protoElement = new IntegerPrototype("ungd");
		ArrayPrototype proto = new ArrayPrototype(protoElement,"oiryu");
		proto.setFixedLength(true);
		proto.setLength(11);
		ArrayDTO dto = new ArrayDTO(proto);
		
		for( int i = 0 ; i < 11; i++ ) {
			IntegerDTO primitive = new IntegerDTO(protoElement);
			primitive.setData(i*11);
			dto.appendElement(primitive);
		}
		
		int [] values = new int[11];
		for( int i = 0 ; i < 11; i++ ) {
			IntegerDTO value = (IntegerDTO) dto.getElement(i);
			values[i] = value.getInt();
		}
		
		// attempt to add an index out of bounds
		dto.appendElement(121);
		dto.addElement(12,144);
		
		assertArrayEquals("Variable length primitive int array values", new int[]{0,11,22,33,44,55,66,77,88,99,110}, values);
		assertEquals("Correct length primitive int array stored", 11, dto.getLength());
		
		boolean outOfBounds = false;
		try {
			dto.getElement(11);
		} catch( IndexOutOfBoundsException e) {
			outOfBounds = true;
		}
		assertTrue("No values registered out of fixed array bounds", outOfBounds );
	}
	
	@Test
	public void testPrimitiveVariableCharArray() {
		CharPrototype protoElement = new CharPrototype("njut");
		ArrayPrototype proto = new ArrayPrototype(protoElement,"iefwgh");
		ArrayDTO dto = new ArrayDTO(proto);

		char [] TEST_VALUES = new char[] {'a','z','a','m','g','j','i','a'};
		
		for( char c : TEST_VALUES ) {
			CharDTO val = new CharDTO(protoElement);
			val.setData(c);
			dto.appendElement(val);
		}
		
		char [] values = new char[8];
		for( int i = 0 ; i < 8; i++ ) {
			CharDTO value = (CharDTO) dto.getElement(i);
			values[i] = value.getData();
		}
		
		assertArrayEquals("Variable length primitive int array values", TEST_VALUES, values);
		assertEquals("Correct length primitive int array stored", 8, dto.getLength());
		
	}
	
	@Test
	public void testPrimitiveFixedCharArray() {
		CharPrototype protoElement = new CharPrototype("uhkbqe");
		ArrayPrototype proto = new ArrayPrototype(protoElement,"oueqfb");
		proto.setFixedLength(true);
		proto.setLength(11);
		ArrayDTO dto = new ArrayDTO(proto);
		
		char [] TEST_VALUES = new char[] {'a','z','a','m','g','j','i','a','T','R','D'};
		for( char c : TEST_VALUES ) {
			CharDTO primitive = new CharDTO(protoElement);
			primitive.setData(c);
			dto.appendElement(primitive);
		}
		
		char [] values = new char[11];
		for( int i = 0 ; i < 11; i++ ) {
			CharDTO value = (CharDTO) dto.getElement(i);
			values[i] = value.getData();
		}
		
		// attempt to add an index out of bounds
		dto.appendElement('l');
		dto.addElement(12,'H');
		
		assertArrayEquals("Variable length primitive int array values", TEST_VALUES, values);
		assertEquals("Correct length primitive int array stored", 11, dto.getLength());
		
		boolean outOfBounds = false;
		try {
			dto.getElement(11);
		} catch( IndexOutOfBoundsException e) {
			outOfBounds = true;
		}
		assertTrue("No values registered out of fixed array bounds", outOfBounds );
	}
}
