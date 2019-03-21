
package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb;

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
 *       &lt;attGroup ref="{}OptCoordAndColorAttrGroup"/&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
public class XmlNodeTransition {

    @XmlElement(required = true)
    protected XmlNodeIdReference source;
    @XmlElement(required = true)
    protected XmlNodeIdReference target;
    @XmlElement(name = "label")
    protected List<XmlNodeTransitionLabel> labels = new LinkedList<XmlNodeTransitionLabel>();
    @XmlElement(name = "nail")
    protected List<XmlNodeTransitionNail> nails = new LinkedList<XmlNodeTransitionNail>();
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "color")
    protected String color;
    @XmlAttribute(name = "x")
    protected Integer x;
    @XmlAttribute(name = "y")
    protected Integer y;

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeIdReference }
     *     
     */
    public XmlNodeIdReference getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeIdReference }
     *     
     */
    public void setSource(XmlNodeIdReference value) {
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
     *     {@link XmlNodeIdReference }
     *     
     */
    public XmlNodeIdReference getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeIdReference }
     *     
     */
    public void setTarget(XmlNodeIdReference value) {
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
     * {@link XmlNodeTransitionLabel }
     * 
     * 
     */
    public List<XmlNodeTransitionLabel> getLabels() {
        if (labels == null) {
            labels = new LinkedList<XmlNodeTransitionLabel>();
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
     * {@link XmlNodeTransitionNail }
     * 
     * 
     */
    public List<XmlNodeTransitionNail> getNails() {
        if (nails == null) {
            nails = new LinkedList<XmlNodeTransitionNail>();
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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
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

    /**
     * Gets the value of the x property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setX(int value) {
        this.x = value;
    }

    public boolean isSetX() {
        return (this.x!= null);
    }

    public void unsetX() {
        this.x = null;
    }

    /**
     * Gets the value of the y property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setY(int value) {
        this.y = value;
    }

    public boolean isSetY() {
        return (this.y!= null);
    }

    public void unsetY() {
        this.y = null;
    }

}
