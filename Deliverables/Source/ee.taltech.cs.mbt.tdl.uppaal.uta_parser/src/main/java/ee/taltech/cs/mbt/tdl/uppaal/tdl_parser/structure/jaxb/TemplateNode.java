
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
public class TemplateNode {

    @XmlElement(required = true)
    protected NameNode name;
    protected ParametersNode parameter;
    protected LocalDeclarationsNode declaration;
    @XmlElement(name = "location")
    protected List<LocationNode> locations = new LinkedList<LocationNode>();
    protected InitialLocationNode init;
    @XmlElement(name = "transition")
    protected List<TransitionNode> transitions = new LinkedList<TransitionNode>();

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link NameNode }
     *     
     */
    public NameNode getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameNode }
     *     
     */
    public void setName(NameNode value) {
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
     *     {@link ParametersNode }
     *     
     */
    public ParametersNode getParameter() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametersNode }
     *     
     */
    public void setParameter(ParametersNode value) {
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
     *     {@link LocalDeclarationsNode }
     *     
     */
    public LocalDeclarationsNode getDeclaration() {
        return declaration;
    }

    /**
     * Sets the value of the declaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDeclarationsNode }
     *     
     */
    public void setDeclaration(LocalDeclarationsNode value) {
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
     * {@link LocationNode }
     * 
     * 
     */
    public List<LocationNode> getLocations() {
        if (locations == null) {
            locations = new LinkedList<LocationNode>();
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
     *     {@link InitialLocationNode }
     *     
     */
    public InitialLocationNode getInit() {
        return init;
    }

    /**
     * Sets the value of the init property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialLocationNode }
     *     
     */
    public void setInit(InitialLocationNode value) {
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
     * {@link TransitionNode }
     * 
     * 
     */
    public List<TransitionNode> getTransitions() {
        if (transitions == null) {
            transitions = new LinkedList<TransitionNode>();
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
