package com.jdglazer.binwrite.dataaccess;

import java.util.Map;

public interface XmlDataProvider {
	
	public String getTagName();
	
	public Map<String,String> getAttributes();
	
	public String getEncasedContent();
}

