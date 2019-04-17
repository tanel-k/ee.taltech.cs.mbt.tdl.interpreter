package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IMergeable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.SystemLine;

import java.util.LinkedList;
import java.util.List;

public class SystemDefinition implements IMergeable<SystemDefinition> {
	private SystemLine systemLine;
	private List<AbsDeclarationStatement> declarations = new LinkedList<>();
	private List<AbsExpression> progressMeasureExpressions = new LinkedList<>();

	public List<AbsDeclarationStatement> getDeclarations() {
		return declarations;
	}

	public SystemDefinition addDeclaration(AbsDeclarationStatement declaration) {
		getDeclarations().add(declaration);
		return this;
	}

	public SystemLine getSystemLine() {
		return systemLine;
	}

	public SystemDefinition setSystemLine(SystemLine systemLine) {
		this.systemLine = systemLine;
		return this;
	}

	public List<AbsExpression> getProgressMeasureExpressions() {
		return progressMeasureExpressions;
	}

	public SystemDefinition addProgressMeasure(AbsExpression expression) {
		getProgressMeasureExpressions().add(expression);
		return this;
	}

	@Override
	public void merge(SystemDefinition other) {
		declarations.addAll(other.declarations);
		progressMeasureExpressions.addAll(other.progressMeasureExpressions);

		if (other.systemLine != null) {
			systemLine = systemLine != null
					? systemLine
					: new SystemLine();
			systemLine.merge(other.systemLine);
		}
	}
}
