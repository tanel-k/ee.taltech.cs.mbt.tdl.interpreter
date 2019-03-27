package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.SystemLine;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SystemDefinition {
	private Set<AbsDeclarationStatement> declarations = new LinkedHashSet<>();
	private SystemLine systemLine;
	private List<AbsExpression> progressMeasureExpressions;

	public Set<AbsDeclarationStatement> getDeclarations() {
		return declarations;
	}

	public SystemLine getSystemLine() {
		return systemLine;
	}

	public void setSystemLine(SystemLine systemLine) {
		this.systemLine = systemLine;
	}

	public List<AbsExpression> getProgressMeasureExpressions() {
		return progressMeasureExpressions;
	}

	public void setProgressMeasureExpressions(List<AbsExpression> progressMeasureExpressions) {
		this.progressMeasureExpressions = progressMeasureExpressions;
	}
}
