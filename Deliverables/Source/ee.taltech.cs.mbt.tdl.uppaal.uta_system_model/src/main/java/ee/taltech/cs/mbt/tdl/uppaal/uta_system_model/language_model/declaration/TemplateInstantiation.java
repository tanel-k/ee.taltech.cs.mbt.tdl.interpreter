package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
	private Identifier originalTemplateName;
	private List<ParameterDeclaration> parameters = new LinkedList<>();
	private List<AbsExpression> arguments = new LinkedList<>();

	public Identifier getNewTemplateName() {
		return newTemplateName;
	}

	public void setNewTemplateName(Identifier newTemplateName) {
		this.newTemplateName = newTemplateName;
	}

	public Identifier getOriginalTemplateName() {
		return originalTemplateName;
	}

	public void setOriginalTemplateName(Identifier originalTemplateName) {
		this.originalTemplateName = originalTemplateName;
	}

	public List<AbsExpression> getArguments() {
		return arguments;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> declarationVisitor) {
		return declarationVisitor.visitTemplateInstantiation(this);
	}
}
