package com.jdglazer.binwrite.dataaccess.types.complex;

import java.util.Map;

import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;
import com.jdglazer.binwrite.dataaccess.XmlDataProvider;
import com.jdglazer.binwrite.dataaccess.types.primitive.BitPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.BooleanPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.CharPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.FloatPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.IntegerPrototype;
import com.jdglazer.binwrite.dataaccess.utils.XMLBuilder;

public class ArrayPrototype extends DataElementPrototype implements XmlDataProvider {
	
	public static final String XML_TAG_NAME = "Array";

	/**
	 * Is the array of fixed length or not?
	 */
	private boolean fixedLength;
	
	/**
	 * The length of the array ( required for arrays that have fixed length )
	 */
	private int length;
	
	/**
	 * The data type of the elements of the array
	 */
	private DataElementPrototype dataElementPrototype;
	
	private String dataElementNameReference;
	
	/**
	 * 
	 */
	private String lengthElementName;
	
	public ArrayPrototype( DataElementPrototype prototype, String name ) {
		super(DataType.ARRAY, name);
		this.dataElementPrototype = prototype;
		this.fixedLength = false;
		this.length = 0;
	}


	public boolean isFixedLength() {
		return fixedLength;
	}


	public void setFixedLength(boolean fixedLength) {
		this.fixedLength = fixedLength;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}

	public final DataElementPrototype getDataElementPrototype() {
		return dataElementPrototype;
	}
	
	public void setDataElementPrototype( DataElementPrototype prototype) {
		this.dataElementPrototype = prototype;
	}


	public String getLengthElementName() {
		return lengthElementName;
	}


	public void setLengthElementName(String lengthElementName) {
		this.lengthElementName = lengthElementName;
	}


	@Override
	public String getTagName() {

		return XML_TAG_NAME;
	}


	@Override
	public Map<String, String> getAttributes() {
		
        Map<String,String> attrs = super.getAttributes();
        
        attrs.put("fixed-length", Boolean.toString(fixedLength) );
        
        if( fixedLength ) {
        	
        	attrs.put("length", Integer.toString( length ) );
        }
        
        if ( dataElementNameReference != null ) {
			
			attrs.put("element-reference", dataElementNameReference);
		}
        
        return attrs;
	}

	public String getDataElementNameReference() {
		return dataElementNameReference;
	}


	public void setDataElementNameReference(String dataElementNameReference) {
		this.dataElementNameReference = dataElementNameReference;
	}

	@Override
	public String getEncasedContent() {
		
		String tagName = null;
		
		Map<String,String> attrs = null;
		
		String encasedContent = null;
        
		if( dataElementPrototype != null ) {
			
			switch( dataElementPrototype.getDataType() ) {
			
			case ARRAY:
				ArrayPrototype a = (ArrayPrototype) dataElementPrototype;
				tagName = a.getTagName();
				attrs = a.getAttributes();
				encasedContent = a.getEncasedContent();
				break;
				
			case OBJECT:
				ObjectPrototype o = (ObjectPrototype) dataElementPrototype;
				tagName = o.getTagName();
				attrs = o.getAttributes();
				encasedContent = o.getEncasedContent();
				break;
				
			case STRING:
				StringPrototype s = (StringPrototype) dataElementPrototype;
				tagName = s.getTagName();
				attrs = s.getAttributes();
				break;
				
			case BIT:
				BitPrototype b = (BitPrototype) dataElementPrototype;
				tagName = b.getTagName();
				attrs = b.getAttributes();
				break;
				
			case BYTE:
				ArrayPrototype by = (ArrayPrototype) dataElementPrototype;
				tagName = by.getTagName();
				attrs = by.getAttributes();
				break;
				
			case CHAR:
				CharPrototype c = (CharPrototype) dataElementPrototype;
				tagName = c.getTagName();
				attrs = c.getAttributes();
				break;
				
			case BOOLEAN:
				BooleanPrototype bo = (BooleanPrototype) dataElementPrototype;
				tagName = bo.getTagName();
				attrs = bo.getAttributes();
				break;
				
			case INTEGER:
				IntegerPrototype i = (IntegerPrototype) dataElementPrototype;
				tagName = i.getTagName();
				attrs = i.getAttributes();
				break;
				
			case FLOAT:
				FloatPrototype f = (FloatPrototype) dataElementPrototype;
				tagName = f.getTagName();
				attrs = f.getAttributes();
				break;
				
			case NULL:
				break;
				
			case UNSIGNED_FLOAT:
				break;
				
			case UNSIGNED_INTEGER:
				break;
				
			default:
				break;
			}
		} else if( dataElementNameReference == null) {
			
			System.out.println( "WARNING: No element type registered for Array "+getName() );
		}
		
		
		if( tagName != null ) {
			
			return XMLBuilder.buildElement(tagName, attrs, encasedContent);
			
			
		} else {
			
			System.out.println("ERROR: No encased tag identifiable from array data element type");
			
			return null;
		}
		
	}

}
