
package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransitionLabelKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransitionLabelKind"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="comments"/&gt;
 *     &lt;enumeration value="select"/&gt;
 *     &lt;enumeration value="guard"/&gt;
 *     &lt;enumeration value="synchronisation"/&gt;
 *     &lt;enumeration value="assignment"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TransitionLabelKind")
@XmlEnum
public enum EXmlAttrTransitionLabelKind {

    @XmlEnumValue("comments")
    COMMENTS("comments"),
    @XmlEnumValue("select")
    SELECT("select"),
    @XmlEnumValue("guard")
    GUARD("guard"),
    @XmlEnumValue("synchronisation")
    SYNCHRONISATION("synchronisation"),
    @XmlEnumValue("assignment")
    ASSIGNMENT("assignment");
    private final String value;

    EXmlAttrTransitionLabelKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EXmlAttrTransitionLabelKind fromValue(String v) {
        for (EXmlAttrTransitionLabelKind c: EXmlAttrTransitionLabelKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}