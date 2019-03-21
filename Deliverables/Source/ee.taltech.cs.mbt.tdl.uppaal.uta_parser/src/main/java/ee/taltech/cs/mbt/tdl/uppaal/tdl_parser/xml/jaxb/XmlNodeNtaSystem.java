
package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NtaSystemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NtaSystemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="imports" type="{}ImportsType" minOccurs="0"/&gt;
 *         &lt;element name="declaration" type="{}GlobalDeclarationsType" minOccurs="0"/&gt;
 *         &lt;element name="template" type="{}TemplateType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="instantiation" type="{}InstantiationType" minOccurs="0"/&gt;
 *         &lt;element name="system" type="{}SystemDefinitionType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NtaSystemType", propOrder = {
    "imports",
    "declaration",
    "templates",
    "instantiation",
    "system"
})
@XmlSeeAlso({
    XmlNodeNta.class
})
public class XmlNodeNtaSystem {

    protected XmlNodeImports imports;
    protected XmlNodeGlobalDeclarations declaration;
    @XmlElement(name = "template", required = true)
    protected List<XmlNodeTemplate> templates = new LinkedList<XmlNodeTemplate>();
    protected XmlNodeInstantiation instantiation;
    @XmlElement(required = true)
    protected XmlNodeSystemDefinition system;

    /**
     * Gets the value of the imports property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeImports }
     *     
     */
    public XmlNodeImports getImports() {
        return imports;
    }

    /**
     * Sets the value of the imports property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeImports }
     *     
     */
    public void setImports(XmlNodeImports value) {
        this.imports = value;
    }

    public boolean isSetImports() {
        return (this.imports!= null);
    }

    /**
     * Gets the value of the declaration property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeGlobalDeclarations }
     *     
     */
    public XmlNodeGlobalDeclarations getDeclaration() {
        return declaration;
    }

    /**
     * Sets the value of the declaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeGlobalDeclarations }
     *     
     */
    public void setDeclaration(XmlNodeGlobalDeclarations value) {
        this.declaration = value;
    }

    public boolean isSetDeclaration() {
        return (this.declaration!= null);
    }

    /**
     * Gets the value of the templates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlNodeTemplate }
     * 
     * 
     */
    public List<XmlNodeTemplate> getTemplates() {
        if (templates == null) {
            templates = new LinkedList<XmlNodeTemplate>();
        }
        return this.templates;
    }

    public boolean isSetTemplates() {
        return ((this.templates!= null)&&(!this.templates.isEmpty()));
    }

    public void unsetTemplates() {
        this.templates = null;
    }

    /**
     * Gets the value of the instantiation property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeInstantiation }
     *     
     */
    public XmlNodeInstantiation getInstantiation() {
        return instantiation;
    }

    /**
     * Sets the value of the instantiation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeInstantiation }
     *     
     */
    public void setInstantiation(XmlNodeInstantiation value) {
        this.instantiation = value;
    }

    public boolean isSetInstantiation() {
        return (this.instantiation!= null);
    }

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeSystemDefinition }
     *     
     */
    public XmlNodeSystemDefinition getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeSystemDefinition }
     *     
     */
    public void setSystem(XmlNodeSystemDefinition value) {
        this.system = value;
    }

    public boolean isSetSystem() {
        return (this.system!= null);
    }

}
