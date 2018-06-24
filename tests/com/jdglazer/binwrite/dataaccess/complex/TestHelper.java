package com.jdglazer.binwrite.dataaccess.complex;

import java.util.HashMap;
import java.util.List;

import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;
import com.jdglazer.binwrite.dataaccess.types.complex.ArrayDTO;
import com.jdglazer.binwrite.dataaccess.types.complex.ArrayPrototype;
import com.jdglazer.binwrite.dataaccess.types.complex.ObjectDTO;
import com.jdglazer.binwrite.dataaccess.types.complex.ObjectPrototype;
import com.jdglazer.binwrite.dataaccess.types.complex.StringDTO;
import com.jdglazer.binwrite.dataaccess.types.complex.StringPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.BitDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.BitPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.BooleanDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.BooleanPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.ByteDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.BytePrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.CharDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.CharPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.FloatDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.FloatPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.IntegerDTO;
import com.jdglazer.binwrite.dataaccess.types.primitive.IntegerPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.PrimitiveDTO;

public abstract class TestHelper {
	
    public static StringDTO getStringDTO( String name ) {
    	StringPrototype prototype = new StringPrototype( name );
    	return new StringDTO(prototype);
    }
    
    public static StringDTO getFixedLengthStringDTO( String name, int length ) {
    	StringPrototype prototype = new StringPrototype( name );
    	prototype.setFixedLength(true);
    	prototype.setLength(length);
    	return new StringDTO(prototype);
    }
    
    public static ArrayDTO getArrayDTO(String name, DataElementPrototype dataElementPrototype ) {
        ArrayPrototype array = new ArrayPrototype(dataElementPrototype,name);
        return new ArrayDTO(array);
    }
    
    public static ArrayDTO getFixedLengthArrayDTO(String name, DataElementPrototype dataElementPrototype, int length ) {
        ArrayPrototype array = new ArrayPrototype(dataElementPrototype,name);
        array.setFixedLength(true);
        array.setLength(length);
        return new ArrayDTO(array);
    }
    
    public static ObjectDTO getObjectDTO(String name, List<DataElementPrototype> nameToMember) {
    	ObjectPrototype prototype = new ObjectPrototype(name);
    	for( DataElementPrototype d : nameToMember ) {
    		prototype.appendDataPrototype( d );
    	}
    	return new ObjectDTO(prototype);
    }
    
    public static ObjectDTO getObjectDTO(String name, List<DataElementPrototype> nameToMember, HashMap<String,DataElementPrototype> appendAfter, HashMap<String,DataElementPrototype> appendBefore) {
    	ObjectPrototype prototype = new ObjectPrototype(name);
    	for( DataElementPrototype d : nameToMember ) {
    		prototype.appendDataPrototype( d );
    	}
    	for( String s : appendAfter.keySet() ) {
    		prototype.addDataPrototypeAfter(appendAfter.get(s), s);
    	}
    	for( String s : appendBefore.keySet() ) {
    		prototype.addDataPrototypeBefore(appendBefore.get(s), s);
    	}
    	return new ObjectDTO(prototype);
    }
    
    public static PrimitiveDTO getPrimitiveDTO(String name, DataType type) {
    	
    	PrimitiveDTO dto = null;
    	
    	if( !type.isComplex()) {
    		
    		switch( type ) {
    		case INTEGER:
    			dto =  new IntegerDTO( new IntegerPrototype( name ) );
    			break;
    			
    		case FLOAT:
    			dto = new FloatDTO( new FloatPrototype( name ) );
    		    break;
    		    
    		case BYTE:
    			dto = new ByteDTO( new BytePrototype( name ) );
    			break;
    			
    		case CHAR:
    			dto = new CharDTO( new CharPrototype( name ) );
    			break;
    			
    		case BOOLEAN:
    			dto = new BooleanDTO( new BooleanPrototype( name ) );
    			break;
    			
    		case BIT:
    			dto = new BitDTO( new BitPrototype( name ) );
    			break;
			case ARRAY:
				break;
			case NULL:
				break;
			case OBJECT:
				break;
			case STRING:
				break;
			case UNSIGNED_FLOAT:
				break;
			case UNSIGNED_INTEGER:
				break;
			default:
				break;
    		}
    	}
    	
    	return dto;
    }
}
