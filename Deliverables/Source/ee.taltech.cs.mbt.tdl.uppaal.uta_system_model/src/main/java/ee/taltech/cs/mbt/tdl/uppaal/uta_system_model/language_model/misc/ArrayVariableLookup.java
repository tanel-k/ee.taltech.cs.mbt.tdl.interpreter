package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an array lookup performed on a plain array identifier {@link Identifier}.<br/>
 * Note we also have {@link ArrayLookupExpression}.<br/>
 * The latter allows for an expression to be used as the lookup target.<br/>
 * <br/>
 * Syntax:<br/>
 * <pre>
 * Lookup ::= ID
 *         |  Lookup '[' Expression ']'
 * </pre>
 */
public class ArrayVariableLookup implements IDeepCloneable<ArrayVariableLookup> {
	private Identifier identifier;
	private List<AbsExpression> lookupExpressions = new LinkedList<>();

	public ArrayVariableLookup of(Identifier identifier) {
		ArrayVariableLookup arrayVariableLookup = new ArrayVariableLookup();
		arrayVariableLookup.setIdentifier(identifier);
		return arrayVariableLookup;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public ArrayVariableLookup setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		return this;
	}

	public List<AbsExpression> getLookupExpressions() {
		return lookupExpressions;
	}

	public ArrayVariableLookup addLookupExpression(AbsExpression expr) {
		getLookupExpressions().add(expr);
		return this;
	}

	@Override
	public ArrayVariableLookup deepClone() {
		ArrayVariableLookup clone = new ArrayVariableLookup();
		clone.setIdentifier(getIdentifier().deepClone());
		getLookupExpressions().stream()
				.map(AbsExpression::deepClone)
				.forEachOrdered(clone::addLookupExpression);
		return clone;
	}
}
