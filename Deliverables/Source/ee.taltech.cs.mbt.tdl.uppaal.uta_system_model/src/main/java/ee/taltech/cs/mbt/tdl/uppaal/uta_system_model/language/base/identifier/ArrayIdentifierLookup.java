package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

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
