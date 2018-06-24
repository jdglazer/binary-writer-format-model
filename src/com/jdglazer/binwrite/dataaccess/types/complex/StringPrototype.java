package com.jdglazer.binwrite.dataaccess.types.complex;

import java.util.Map;

import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;
import com.jdglazer.binwrite.dataaccess.XmlDataProvider;

public class StringPrototype extends DataElementPrototype implements XmlDataProvider {
	
	public static final String XML_TAG_NAME = "String";	
	
	/**
	 * Is the array of fixed length or not?
	 */
	private boolean fixedLength;
	
	private boolean fixed;
	
	/**
	 * The length of the string ( required for arrays that have fixed length )
	 */
	private int length;
	
	private String value;
	
	private String lengthElementName;
	
	public StringPrototype(String name) {
		super(DataType.STRING,name);
		fixedLength = false;
		fixed = false;
		value = null;
		lengthElementName = null;
		length = -1;
	}

	public boolean isFixedLength() {
		return fixedLength;
	}

	public void setFixedLength(boolean fixedLength) {
		this.fixedLength = fixedLength;
	}

	public int getFixedLength() {
		return fixedLength ? length : -1;
	}

	public void setLength(int length) {
		if( fixedLength && length >= 0)
		    this.length = length;
	}
	
	public void setValue( String defaultVal ) {
		value = defaultVal;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setLengthElementName( String lengthElement ) {
		lengthElementName = lengthElement;
	}
	
	public String getLengthElementName() {
		return lengthElementName;
	}

	@Override
	public String getTagName() {

		return XML_TAG_NAME;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
		if( fixed ) {
		    this.fixedLength = fixed;
		}
	}
	
	@Override
	public Map<String, String> getAttributes() {
		
        Map<String,String> attrs = super.getAttributes();
        
        attrs.put("fixed", Boolean.toString(fixed) );
        
        if ( fixed ) {
        	
        	attrs.put("value",value);
        	
        	attrs.put("length" , Integer.toString( value == null ? 0 : value.length() ) );
        	
        } else if( fixedLength )  {
        	
        	attrs.put("fixed-length", "true");
        	
        	attrs.put("length", Integer.toString( length ) );
        	
        } else if ( lengthElementName != null ) {
        	
        	attrs.put("length-element-name", lengthElementName );
        	
        	attrs.put("fixed-length", "true");
        }
        
        return attrs;
	}

	@Override
	public String getEncasedContent() {
		return null;
	}
 }