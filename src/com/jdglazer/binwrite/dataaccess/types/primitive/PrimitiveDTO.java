package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.BitSet;

import com.jdglazer.binwrite.dataaccess.DataElementDTO;
import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;

public abstract class PrimitiveDTO implements DataElementDTO {

	protected BitSet data;
	
	protected PrimitivePrototype prototype;
	
	public PrimitiveDTO(PrimitivePrototype prototype) {
		this.prototype = prototype;
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
