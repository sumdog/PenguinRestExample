package org.penguindreams.simplerest.data;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
import org.jdom.Document;
import org.jdom.Element;
import org.penguindreams.pdbimpy.base.SimpleException;
import org.penguindreams.simplerest.spring.MySpring;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class XMLConverter {

	public static final String rootElement = "Entries";
		
	public Model[] getDataModelsFromXml(String xml) throws SimpleException {
		
		List<Model> models = new ArrayList<Model>();
		
		try {
			
			Document doc = new SAXBuilder().build(new StringReader(xml));
			XPath pathref = XPath.newInstance("/" + rootElement);
			List<?> rows = pathref.selectNodes(doc);
			
			//root (should only be 1)
			Iterator<?> iRoot = rows.iterator();
			while(iRoot.hasNext()) {
				Element e = (Element) iRoot.next();
				
				//individual models 
				Iterator<?> iModels = e.getChildren().iterator();
				while(iModels.hasNext()) {
					Element eModel = (Element) iModels.next();
					//could throw NoSuchBeanDefinition Exception
					Model mRow = (Model) MySpring.getBean("Model" + eModel.getName());
					
					//model fields
					Iterator<?> iModelFields = eModel.getChildren().iterator();
					while(iModelFields.hasNext()) {
						Element eField = (Element) iModelFields.next();
						//could throw exception for invalid field
						mRow.setField(eField.getName(), eField.getValue());
					}
					
					models.add(mRow);
				}										
			}			
		}
		catch(NoSuchBeanDefinitionException b) {
			throw new SimpleException("Invalid Model " + b.getBeanName(),b);
		}
		catch(Exception e) {
			throw new SimpleException("Error Processing Model " + e.getMessage(),e);
		}
		
		return models.toArray(new Model[models.size()]);
	}
	
	public String getXmlForDataModels(Model[] models) {
		return null;
	}
	
}
