
package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocationLabelKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LocationLabelKind"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="invariant"/&gt;
 *     &lt;enumeration value="comments"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LocationLabelKind")
@XmlEnum
public enum EXmlAttrLocationLabelKind {

    @XmlEnumValue("invariant")
    INVARIANT("invariant"),
    @XmlEnumValue("comments")
    COMMENTS("comments");
    private final String value;

    EXmlAttrLocationLabelKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EXmlAttrLocationLabelKind fromValue(String v) {
        for (EXmlAttrLocationLabelKind c: EXmlAttrLocationLabelKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
