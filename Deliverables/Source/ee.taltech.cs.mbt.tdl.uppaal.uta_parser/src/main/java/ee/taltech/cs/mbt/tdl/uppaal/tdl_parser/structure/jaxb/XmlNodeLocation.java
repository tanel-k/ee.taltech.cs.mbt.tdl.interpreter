
package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a location in an Uppaal TA template.
 * 
 * <p>Java class for LocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{}NameType" minOccurs="0"/&gt;
 *         &lt;element name="label" type="{}LocationLabelType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="urgent" type="{}MarkerType"/&gt;
 *           &lt;element name="committed" type="{}MarkerType"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{}OptCoordAndColorAttrGroup"/&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationType", propOrder = {
    "name",
    "labels",
    "committed",
    "urgent"
})
public class XmlNodeLocation {

    protected XmlNodeName name;
    @XmlElement(name = "label")
    protected List<XmlNodeLocationLabel> labels = new LinkedList<XmlNodeLocationLabel>();
    protected XmlNodeMarker committed;
    protected XmlNodeMarker urgent;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "color")
    protected String color;
    @XmlAttribute(name = "x")
    protected Integer x;
    @XmlAttribute(name = "y")
    protected Integer y;

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
     * {@link XmlNodeLocationLabel }
     * 
     * 
     */
    public List<XmlNodeLocationLabel> getLabels() {
        if (labels == null) {
            labels = new LinkedList<XmlNodeLocationLabel>();
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
     * Gets the value of the committed property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeMarker }
     *     
     */
    public XmlNodeMarker getCommitted() {
        return committed;
    }

    /**
     * Sets the value of the committed property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeMarker }
     *     
     */
    public void setCommitted(XmlNodeMarker value) {
        this.committed = value;
    }

    public boolean isSetCommitted() {
        return (this.committed!= null);
    }

    /**
     * Gets the value of the urgent property.
     * 
     * @return
     *     possible object is
     *     {@link XmlNodeMarker }
     *     
     */
    public XmlNodeMarker getUrgent() {
        return urgent;
    }

    /**
     * Sets the value of the urgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlNodeMarker }
     *     
     */
    public void setUrgent(XmlNodeMarker value) {
        this.urgent = value;
    }

    public boolean isSetUrgent() {
        return (this.urgent!= null);
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
