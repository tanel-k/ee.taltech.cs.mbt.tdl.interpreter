package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.sections.system.progress_measure;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

public class ProgressMeasureDeclaration {
	private List<AbsExpression> measureExpressions;

	public ProgressMeasureDeclaration() {
		this.measureExpressions = new LinkedList<>();
	}

	public List<AbsExpression> getMeasureExpressions() {
		return measureExpressions;
	}
}
