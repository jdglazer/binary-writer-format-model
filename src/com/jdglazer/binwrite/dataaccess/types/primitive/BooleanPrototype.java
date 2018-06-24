package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.Map;

import com.jdglazer.binwrite.dataaccess.DataType;
import com.jdglazer.binwrite.dataaccess.XmlDataProvider;

public class BooleanPrototype extends PrimitivePrototype implements XmlDataProvider {
	
	public static final String XML_TAG_NAME = "Boolean";
	
    public BooleanPrototype( String name) {
		super(DataType.BOOLEAN, name);
		setLength(1);
	}

	@Override
	public String getTagName() {

		return XML_TAG_NAME;
	}

	@Override
	public Map<String, String> getAttributes() {
		return super.getAttributes();
	}

	@Override
	public String getEncasedContent() {
		return null;
	}
    
}
