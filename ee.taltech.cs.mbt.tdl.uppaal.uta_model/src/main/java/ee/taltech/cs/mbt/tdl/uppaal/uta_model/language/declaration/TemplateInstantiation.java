package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IDeclarationVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a template instantiation.<br/>
 * <br/>
 * Adapted from UPPAAL documentation:<br/>
 * <i>
 * New templates can be defined from existing templates.<br/>
 * The new template has the same automaton structure
 * and the same local variables as the template it is derived from.<br/>
 * Arguments are provided for any formal parameters of the template,
 * thus modifying the interface of the template.<br/>
 * Template instantiation is used to bind formal parameters to actual arguments.<br/>
 * The resulting template is later <b>instantiated into a process</b> by listing it in the system line.<br/>
 * </i>
 * <br/>
 * Syntax:<br/>
 * <pre>
 * Instantiation ::= ID [ '(' Parameters  ')' ] '=' ID '(' Arguments ')' ';'
 * </pre>
 * <br/>
 * In light of the information provided above, note that <i>Process = Template()</i> does not in fact
 * create a new process variable.<br/>
 * Instead:
 * <pre>
 * Process = Template(); // instantiates a new `Process` template based on `Template`.
 * system Process; // Instantiates a process from the `Process` template.
 * </pre>
 */
public class TemplateInstantiation extends AbsDeclarationStatement {
	private Identifier newTemplateName;
	private Identifier sourceTemplateName;
	private List<ParameterDeclaration> parameters = new LinkedList<>();
	private List<AbsExpression> arguments = new LinkedList<>();

	public Identifier getNewTemplateName() {
		return newTemplateName;
	}

	public TemplateInstantiation setNewTemplateName(Identifier newTemplateName) {
		this.newTemplateName = newTemplateName;
		return this;
	}

	public Identifier getSourceTemplateName() {
		return sourceTemplateName;
	}

	public TemplateInstantiation setSourceTemplateName(Identifier sourceTemplateName) {
		this.sourceTemplateName = sourceTemplateName;
		return this;
	}

	public List<AbsExpression> getArguments() {
		return arguments;
	}

	public TemplateInstantiation addArgument(AbsExpression expression) {
		getArguments().add(expression);
		return this;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	public TemplateInstantiation addParameter(ParameterDeclaration parameter) {
		getParameters().add(parameter);
		return this;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitTemplateInstantiation(this);
	}

	@Override
	public TemplateInstantiation deepClone() {
		TemplateInstantiation clone = new TemplateInstantiation();

		clone.newTemplateName = newTemplateName.deepClone();
		clone.sourceTemplateName = sourceTemplateName.deepClone();
		getArguments().stream()
				.forEachOrdered(arg -> clone.arguments.add(arg.deepClone()));
		getParameters().stream()
				.forEachOrdered(param -> clone.parameters.add(param.deepClone()));

		return clone;
	}
}
