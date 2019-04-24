
package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes a transition between locations in a TA template.
 * 
 * <p>Java class for TransitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransitionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="source" type="{}IdRefType"/&gt;
 *         &lt;element name="target" type="{}IdRefType"/&gt;
 *         &lt;element name="label" type="{}TransitionLabelType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="nail" type="{}NailType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="color" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransitionType", propOrder = {
    "source",
    "target",
    "labels",
    "nails"
})
public class TransitionNode {

    @XmlElement(required = true)
    protected IdReferenceNode source;
    @XmlElement(required = true)
    protected IdReferenceNode target;
    @XmlElement(name = "label")
    protected List<TransitionLabelNode> labels = new LinkedList<TransitionLabelNode>();
    @XmlElement(name = "nail")
    protected List<TransitionNailNode> nails = new LinkedList<TransitionNailNode>();
    @XmlAttribute(name = "color")
    protected String color;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link IdReferenceNode }
     *     
     */
    public IdReferenceNode getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdReferenceNode }
     *     
     */
    public void setSource(IdReferenceNode value) {
        this.source = value;
    }

    public boolean isSetSource() {
        return (this.source!= null);
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link IdReferenceNode }
     *     
     */
    public IdReferenceNode getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdReferenceNode }
     *     
     */
    public void setTarget(IdReferenceNode value) {
        this.target = value;
    }

    public boolean isSetTarget() {
        return (this.target!= null);
    }

    /**
     * Gets the value of the labels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransitionLabelNode }
     * 
     * 
     */
    public List<TransitionLabelNode> getLabels() {
        if (labels == null) {
            labels = new LinkedList<TransitionLabelNode>();
        }
        return this.labels;
    }

    public boolean isSetLabels() {
        return ((this.labels!= null)&&(!this.labels.isEmpty()));
    }

    public void unsetLabels() {
        this.labels = null;
    }

    /**
     * Gets the value of the nails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransitionNailNode }
     * 
     * 
     */
    public List<TransitionNailNode> getNails() {
        if (nails == null) {
            nails = new LinkedList<TransitionNailNode>();
        }
        return this.nails;
    }

    public boolean isSetNails() {
        return ((this.nails!= null)&&(!this.nails.isEmpty()));
    }

    public void unsetNails() {
        this.nails = null;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    public boolean isSetColor() {
        return (this.color!= null);
    }

}
