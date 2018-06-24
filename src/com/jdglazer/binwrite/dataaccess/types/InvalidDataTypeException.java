package com.jdglazer.binwrite.dataaccess.types;

public class InvalidDataTypeException extends Exception {
	
    public InvalidDataTypeException() {
    }
    
    public InvalidDataTypeException(String msg) {
    	super(msg);
    }
}
