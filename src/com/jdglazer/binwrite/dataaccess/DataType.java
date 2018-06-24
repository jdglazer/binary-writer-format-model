package com.jdglazer.binwrite.dataaccess;

public enum DataType {
    INTEGER(false),
    UNSIGNED_INTEGER(false),
    FLOAT(false),
    UNSIGNED_FLOAT(false),
    CHAR(false),
    BYTE(false),
    BIT(false),
    BOOLEAN(false),
    STRING(true),
    ARRAY(true),
    OBJECT(true),
    NULL(false);
    
	/**
	 * Is the data type an amalgamation of other data types or not? ( complex or simple, respectively )
	 */
    private final boolean COMPLEX;
    /**
     * length of the data type in bits ( irrelevant for complex data )
     */
    private int length;
    
    private DataType( boolean complex ) {
    	this.COMPLEX = complex;
    }
    
    public boolean isComplex() {
    	return this.COMPLEX;
    }
    
    public void setLength( int length ) {
    	this.length = length;
    }
    
    public int getLength() {
    	return this.length;
    }
}
