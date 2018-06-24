package com.jdglazer.binwrite.dataaccess.types.complex;

import java.util.HashMap;

import com.jdglazer.binwrite.dataaccess.DataElementDTO;
import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;
import com.jdglazer.binwrite.dataaccess.types.InvalidDataTypeException;

public class ObjectDTO implements DataElementDTO {

	private ObjectPrototype prototype;
	private DataElementDTO [] dataElements;
	private HashMap<String,DataElementDTO> namesToData;
	
	public ObjectDTO(ObjectPrototype prototype) {
		this.prototype = prototype;
		dataElements = new DataElementDTO[ prototype.getPrototypeCount() ];
		for( String name : prototype.getNameSet() ) {
			namesToData.put(name, null);
		}
	}
	
	public void set( String name, DataElementDTO dataElement ) throws InvalidDataTypeException {
		DataElementPrototype deProto = prototype.getPrototypeByName(name);
		if ( !deProto.getDataType().equals( dataElement.getDataType() ) ) {
			//log an type mismatch error and throw exception
			throw new InvalidDataTypeException();
		}
		
		if( namesToData.containsKey(name) ) {
			int offset = prototype.getOffsetByName(name);
			if ( offset >= 0 ) {
			    namesToData.put(name, dataElement );
			    dataElements[offset] = dataElement;
			}
		}
	}
	
	public DataElementDTO get( String name ) {
		return namesToData.get(name);
	}

	@Override
	public String getName() {
		return prototype.getName();
	}

	@Override
	public String getDescription() {
		return prototype.getDescription();
	}

	@Override
	public DataType getDataType() {
		return prototype.getDataType();
	}

	@Override
	public DataElementPrototype getPrototype() {
		return prototype;
	}
}
