package com.jdglazer.binwrite.dataaccess.types.complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.jdglazer.binwrite.dataaccess.DataElementPrototype;
import com.jdglazer.binwrite.dataaccess.DataType;
import com.jdglazer.binwrite.dataaccess.XmlDataProvider;
import com.jdglazer.binwrite.dataaccess.types.primitive.BitPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.BooleanPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.CharPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.FloatPrototype;
import com.jdglazer.binwrite.dataaccess.types.primitive.IntegerPrototype;
import com.jdglazer.binwrite.dataaccess.utils.XMLBuilder;

public class ObjectPrototype extends DataElementPrototype implements XmlDataProvider {

	public static final String XML_TAG_NAME = "Object";
	/**
	 * A map of element names to data point DTO
	 */
	private HashMap<String,DataElementPrototype> nameToDataPoint = new HashMap<String,DataElementPrototype>();
	
	private ArrayList<DataElementPrototype> orderedDataPoints = new ArrayList<DataElementPrototype>();
	
	/**
	 * References another object in the file format by it's name
	 * This object must still maintain it's own name, but it takes
	 * the description and properties of the referenced object.
	 * When this is null, the object is a uniquely defined object
	 */
	private String elementReference;
	
	public ObjectPrototype(String name) {
		super(DataType.OBJECT, name);
		setElementReference(null);
	}
	
	public void appendDataPrototype( DataElementPrototype data ) {
		if( data == null ) {
			System.out.println("DEBUG: can not append null data prototype value to object data");
			return;
		} else if( data.getName() == null ) {
			return;
		}
		orderedDataPoints.add(data);
		nameToDataPoint.put(data.getName(), data);
	}
	
    public void addDataPrototype( DataElementPrototype data, int offset ) {
		if( data == null || offset < 0 ) {
			return;
		} else if( data.getName() == null ) {
			return;
		}
		orderedDataPoints.set(offset,data);
		nameToDataPoint.put(data.getName(),data);
	}
    
    public void addDataPrototypeAfter( DataElementPrototype data, String name ) {
		if( data == null || name == null ) {
			return;
		} else if( data.getName() == null ) {
			return;
		}
		for( int i = 0; i < orderedDataPoints.size(); i++ ) {
			DataElementPrototype prototype = orderedDataPoints.get(i);
			if ( prototype != null ) {
				if( prototype.getName().equals(name) ) {
				    orderedDataPoints.add(i+1,data);
				    nameToDataPoint.put(data.getName(), data);
					break;
				}
			}
		}
    }
    
    public void addDataPrototypeBefore( DataElementPrototype data, String name ) {
		if( data == null || name == null ) {
			return;
		} else if( data.getName() == null ) {
			return;
		}
		for( int i = 0; i < orderedDataPoints.size(); i++ ) {
			DataElementPrototype prototype = orderedDataPoints.get(i);
			if ( prototype != null ) {
				if( prototype.getName().equals(name) ) {
					orderedDataPoints.add(i,data);
				    nameToDataPoint.put(data.getName(), data);
					break;
				}
			}
		}
    }
    
    public int getOffsetByName( String name ) {
    	if( name != null ) {
    		//log debug error
    		return -1;
    	}
    	if( nameToDataPoint.containsKey(name) ) {
    		for( int i = 0; i < orderedDataPoints.size(); i++ ) {
    			DataElementPrototype prototype = orderedDataPoints.get(i);
    			if( prototype != null ) {
    				if ( prototype.getName().equals(name) ) {
    					return i;
    				}
    			}
    		}
    	}
    	return -1;
    }
    
    public DataElementPrototype getPrototypeByName( String name ) {
    	return nameToDataPoint.get(name);
    }
    
    public DataElementPrototype getPrototype( int offset ) {
    	return orderedDataPoints.get(offset);
    }
    
    public ArrayList<DataElementPrototype> getPrototypes() {
    	return orderedDataPoints;
    }
    
    public Set<String> getNameSet() {
    	return nameToDataPoint.keySet();
    }
    
    public int getPrototypeCount() {
        return orderedDataPoints.size();
    }
    
	public String getElementReference() {
		return elementReference;
	}

	public void setElementReference(String elementReference) {
		this.elementReference = elementReference;
	}
	
	@Override
	public String getTagName() {

		return XML_TAG_NAME;
	}

	@Override
	public Map<String, String> getAttributes() {
		
		Map<String,String> attrs = super.getAttributes();
		
		
		return attrs;
	}

	@Override
	public String getEncasedContent() {
        
		String content = "";
		
		for ( DataElementPrototype dep : orderedDataPoints ) {
			
			String tagName = null;
			
			Map<String,String> attrs = null;
			
			String encasedContent = null;
			
			switch( dep.getDataType() ) {
			
			case ARRAY:
				ArrayPrototype a = (ArrayPrototype) dep;
				tagName = a.getTagName();
				attrs = a.getAttributes();
				encasedContent = a.getEncasedContent();
				break;
				
			case OBJECT:
				ObjectPrototype o = (ObjectPrototype) dep;
				tagName = o.getTagName();
				attrs = o.getAttributes();
				encasedContent = o.getEncasedContent();
				break;
				
			case STRING:
				StringPrototype s = (StringPrototype) dep;
				tagName = s.getTagName();
				attrs = s.getAttributes();
				break;
				
			case BIT:
				BitPrototype b = (BitPrototype) dep;
				tagName = b.getTagName();
				attrs = b.getAttributes();
				break;
				
			case BYTE:
				ArrayPrototype by = (ArrayPrototype) dep;
				tagName = by.getTagName();
				attrs = by.getAttributes();
				break;
				
			case CHAR:
				CharPrototype c = (CharPrototype) dep;
				tagName = c.getTagName();
				attrs = c.getAttributes();
				break;
				
			case BOOLEAN:
				BooleanPrototype bo = (BooleanPrototype) dep;
				tagName = bo.getTagName();
				attrs = bo.getAttributes();
				break;
				
			case INTEGER:
				IntegerPrototype i = (IntegerPrototype) dep;
				tagName = i.getTagName();
				attrs = i.getAttributes();
				break;
				
			case FLOAT:
				FloatPrototype f = (FloatPrototype) dep;
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
		
	        if( tagName != null ) {
				
				content += XMLBuilder.buildElement(tagName, attrs, encasedContent) + "\n";
				
				
			} else {
				
				System.out.println("ERROR: No encased tag identifiable from array data element type");
				
				return null;
			}
		}
		
		return content.isEmpty() ? null : content;
	}
}
