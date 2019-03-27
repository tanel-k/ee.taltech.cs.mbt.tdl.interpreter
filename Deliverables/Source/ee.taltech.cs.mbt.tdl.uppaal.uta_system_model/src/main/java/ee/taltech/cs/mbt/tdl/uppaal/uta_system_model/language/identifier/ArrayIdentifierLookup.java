package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.access.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an array lookup performed on a plain array identifier {@link IdentifierName}.<br/>
 * Note we also have {@link ArrayLookupExpression}.<br/>
 * The latter allows for an expression to be used as the lookup target.<br/>
 * <br/>
 * Syntax:<br/>
 * <pre>
 * Lookup ::= ID
 *         |  Lookup '[' Expression ']'
 * </pre>
 */
public class ArrayIdentifierLookup {
	private IdentifierName identifierName;
	private List<AbsExpression> lookupExpressions = new LinkedList<>();

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
	}

	public List<AbsExpression> getLookupExpressions() {
		return lookupExpressions;
	}
}
