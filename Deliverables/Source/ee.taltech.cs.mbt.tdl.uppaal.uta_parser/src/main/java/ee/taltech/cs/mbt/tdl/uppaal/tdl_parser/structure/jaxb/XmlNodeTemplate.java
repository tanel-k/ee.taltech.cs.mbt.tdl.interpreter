
package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An Uppaal TA template.
 * 
 * <p>Java class for TemplateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemplateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{}NameType"/&gt;
 *         &lt;element name="parameter" type="{}ParametersType" minOccurs="0"/&gt;
 *         &lt;element name="declaration" type="{}LocalDeclarationsType" minOccurs="0"/&gt;
 *         &lt;element name="location" type="{}LocationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="init" type="{}InitType" minOccurs="0"/&gt;
 *         &lt;element name="transition" type="{}TransitionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateType", propOrder = {
    "name",
    "parameter",
    "declaration",
    "locations",
    "init",
    "transitions"
})
public class XmlNodeTemplate {

    @XmlElement(required = true)
    protected XmlNodeName name;
    protected XmlNodeParameters parameter;
    protected XmlNodeLocalDeclarations declaration;
    @XmlElement(name = "location")
    protected List<XmlNodeLocation> locations = new LinkedList<XmlNodeLocation>();
    protected XmlNodeInitialLocation init;
    @XmlElement(name = "transition")
    protected List<XmlNodeTransition> transitions = new LinkedList<XmlNodeTransition>();

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeName }
     *     
     */
    public XmlNodeName getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeName }
     *     
     */
    public void setName(XmlNodeName value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeParameters }
     *     
     */
    public XmlNodeParameters getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeParameters }
     *     
     */
    public void setParameter(XmlNodeParameters value) {
        this.parameter = value;
    }

    public boolean isSetParameter() {
        return (this.parameter!= null);
    }

    /**
     * Gets the value of the declaration property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeLocalDeclarations }
     *     
     */
    public XmlNodeLocalDeclarations getDeclaration() {
        return declaration;
    }

    /**
     * Sets the value of the declaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeLocalDeclarations }
     *     
     */
    public void setDeclaration(XmlNodeLocalDeclarations value) {
        this.declaration = value;
    }

    public boolean isSetDeclaration() {
        return (this.declaration!= null);
    }

    /**
     * Gets the value of the locations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlNodeLocation }
     * 
     * 
     */
    public List<XmlNodeLocation> getLocations() {
        if (locations == null) {
            locations = new LinkedList<XmlNodeLocation>();
        }
        return this.locations;
    }

    public boolean isSetLocations() {
        return ((this.locations!= null)&&(!this.locations.isEmpty()));
    }

    public void unsetLocations() {
        this.locations = null;
    }

    /**
     * Gets the value of the init property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeInitialLocation }
     *     
     */
    public XmlNodeInitialLocation getInit() {
        return init;
    }

    /**
     * Sets the value of the init property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeInitialLocation }
     *     
     */
    public void setInit(XmlNodeInitialLocation value) {
        this.init = value;
    }

    public boolean isSetInit() {
        return (this.init!= null);
    }

    /**
     * Gets the value of the transitions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transitions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransitions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XmlNodeTransition }
     * 
     * 
     */
    public List<XmlNodeTransition> getTransitions() {
        if (transitions == null) {
            transitions = new LinkedList<XmlNodeTransition>();
        }
        return this.transitions;
    }

    public boolean isSetTransitions() {
        return ((this.transitions!= null)&&(!this.transitions.isEmpty()));
    }

    public void unsetTransitions() {
        this.transitions = null;
    }

}
