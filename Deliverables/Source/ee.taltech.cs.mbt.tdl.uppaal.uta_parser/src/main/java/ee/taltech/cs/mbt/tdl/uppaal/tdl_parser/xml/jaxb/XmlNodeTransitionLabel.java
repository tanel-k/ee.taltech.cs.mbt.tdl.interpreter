
package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Specifies labels which can be attached to a transition in a template.
 * 
 * <p>Java class for TransitionLabelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransitionLabelType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *       &lt;attGroup ref="{}OptCoordAttrGroup"/&gt;
 *       &lt;attribute name="kind" type="{}TransitionLabelKind" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransitionLabelType", propOrder = {
    "value"
})
public class XmlNodeTransitionLabel {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "kind")
    protected EXmlAttrTransitionLabelKind kind;
    @XmlAttribute(name = "x")
    protected Integer x;
    @XmlAttribute(name = "y")
    protected Integer y;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSetValue() {
        return (this.value!= null);
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link EXmlAttrTransitionLabelKind }
     *     
     */
    public EXmlAttrTransitionLabelKind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link EXmlAttrTransitionLabelKind }
     *     
     */
    public void setKind(EXmlAttrTransitionLabelKind value) {
        this.kind = value;
    }

    public boolean isSetKind() {
        return (this.kind!= null);
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
