package com.jdglazer.binwrite.dataaccess.types.primitive;

import java.util.Map;

import com.jdglazer.binwrite.dataaccess.DataType;
import com.jdglazer.binwrite.dataaccess.XmlDataProvider;

public class IntegerPrototype extends PrimitivePrototype implements XmlDataProvider {
	
	public static final String XML_TAG_NAME = "Int";
	
    public IntegerPrototype( String name) {
		super(DataType.INTEGER, name);
		setLength(32);
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
