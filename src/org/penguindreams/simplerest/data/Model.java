package org.penguindreams.simplerest.data;

import java.util.HashMap;

class Model {

    private Map<String,String> crosswalk;
    
    private Map<String,String> fields;

    private String name;
    
    private String xmlElement; 

    /**
              *used for CGLIB/AOP. Do not call.
              */
    public Model() {}
    
    public Model(String name) {
        this.name = name;
    }
    
    public void setCrossWalk(Map<String,String> crosswalk) {
        this.crosswalk = crosswalk;
    }
    
    public Map<String,String> getCrossWalk() {
        return crosswalk;
    }
    
    public List<String> getValidFields() {
        return null;
    }
    
    public List<String> getFields() {
    }
    
    public void setField(String field, String value) {
       if(!getValidFields.contains(field)) {
           throw new Exception("TODO");
       }
       else {
           fields.set(field,value);
       }       
    }
    
    public String getValue(String field) {
        return fields.get(field);
    }
}




