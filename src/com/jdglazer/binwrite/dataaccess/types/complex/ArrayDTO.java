package com.jdglazer.binwrite.dataaccess.types.complex;

import java.util.ArrayList;

import com.jdglazer.binwrite.dataaccess.DataElementDTO;
import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;
import com.jdglazer.binwrite.dataaccess.types.primitive.PrimitiveDTO;

public class ArrayDTO implements DataElementDTO {
	
	private ArrayPrototype prototype;
	private ArrayList data;
	
	public ArrayDTO( ArrayPrototype prototype ) {
		this.prototype = prototype;
		DataType elementDataType = prototype.getDataElementPrototype().getDataType();
		
		if( !elementDataType.isComplex() ) {
			data = new ArrayList<PrimitiveDTO>();
		} else {
			switch( elementDataType ) {
			case STRING:
				data = new ArrayList<StringDTO>();
				break;
			case ARRAY:
				data = new ArrayList<ArrayDTO>();
				break;
			case OBJECT:
				data = new ArrayList<ObjectDTO>();
				break;
			default:
			}
		}
	}

	public int getLength() {
		if( prototype.isFixedLength() ) {
		    return prototype.getLength();
		} else {
			return data != null ? data.size() : 0;
		}
	}
	
	public void addElement ( Object object, int offset ) {
		if ( !validateElement( object, offset ) ) {
			System.out.println("ERROR: can not add invalid element to Array. Object type given: "+object.getClass().getSimpleName()+". Data type expected: "+prototype.getDataElementPrototype().getDataType());
			return;
		}
		DataType elementDataType = prototype.getDataElementPrototype().getDataType();
		if( !elementDataType.isComplex() ) {
			data.add( offset, (PrimitiveDTO) object );
		} else {
			switch( elementDataType ) {
			case STRING:
				data.add( offset, (StringDTO) object );
				break;
			case ARRAY:
				data.add( offset, (ArrayDTO) object );
				break;
			case OBJECT:
				data.add( offset, (ObjectDTO) object );
				break;
			}
		}
	}
	
	public void appendElement ( Object object ) {
		addElement( object, data.size() );
	}
	
	public String getElementObjectName() {
		
		DataType elementDataType = prototype.getDataElementPrototype().getDataType();
		
		if( !elementDataType.isComplex() ) {
			return "PrimitiveDTO";
		} else {
			switch( elementDataType ) {
			case STRING:
				return "StringDTO";
			case ARRAY:
				return "ArrayDTO";
			case OBJECT:
				return "ObjectDTO";
			default:
				return null;
			}
		}
	}
	
	public Object getElement( int offset ) {
		return data.get(offset);
	}
	
	private boolean validateElement( Object object ) {
		if ( object == null ) {
			return false;
		}
		String complexTypeName = getElementObjectName();
		Class clazz = object.getClass();
	    return clazz.getSuperclass().getSimpleName().equals( complexTypeName ) || clazz.getSimpleName().equals( complexTypeName );
	}
	
	private boolean validateElement( Object object, int offset ) {
		if ( offset < 0 || ( prototype.isFixedLength() && offset >= prototype.getLength() ) ) {
			return false;
		} else {
			return validateElement( object );
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