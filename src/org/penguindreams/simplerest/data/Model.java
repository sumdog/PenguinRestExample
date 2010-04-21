package org.penguindreams.simplerest.data;

import java.util.Map;
import java.util.Set;

import org.penguindreams.simplerest.general.SimpleRestException;

class Model {

    private Map<String,String> crosswalk;
    
    private Map<String,String> fields;

	private String name;
    
    private String xmlElement; 
    
    private String table;

    public Model() {}
    
    public void setCrossWalk(Map<String,String> crosswalk) {
        this.crosswalk = crosswalk;
    }
    
    public Map<String,String> getCrossWalk() {
        return crosswalk;
    }
    
    public Set<String> getValidFields() {
        return crosswalk.keySet();
    }
    
    public Set<String> getFields() {
    	return fields.keySet();
    }
    
    public void setField(String field, String value) {
       if(!getValidFields().contains(field)) {
           throw new SimpleRestException("No field named " + field + " for model " + table);
       } 
       else {
           fields.put(field,value);
       }       
    }
    
    //Bean getters and setters
    
    public String getValue(String field) {
        return fields.get(field);
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getXmlElement() {
		return xmlElement;
	}

	public void setXmlElement(String xmlElement) {
		this.xmlElement = xmlElement;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}
}




