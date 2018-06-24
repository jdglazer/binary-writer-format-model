package com.jdglazer.binwrite.dataaccess.types.complex;

import com.jdglazer.binwrite.dataaccess.DataElementDTO;
import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;

public class StringDTO implements DataElementDTO {
	
	private StringPrototype prototype;
	/**
	 * The data type of the elements of the array
	 */
	private String string;

	public StringDTO ( StringPrototype prototype ) {
		this.prototype = prototype;
	}
	
	public StringDTO ( StringPrototype prototype, String string ) {
		this( prototype );
		setString( string );
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		if( !prototype.isFixedLength() ) {
			prototype.setLength( string.length() );
		} else {
			if( string.length() == prototype.getFixedLength() ) {
				prototype.setLength( string.length() );
			} else {
				//log error
				return;
			}
		}
		this.string = string;
	}
	
	public int getLength() {
		if( prototype.isFixedLength() ) {
			return prototype.getFixedLength();
		} else {
			return string != null ? string.length() : 0;	 
		}
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
