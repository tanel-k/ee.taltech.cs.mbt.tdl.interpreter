package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.mapping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

public class DeclarationMapper implements IContextMapper<AbsDeclarationStatement>, IDeclarationVisitor<ContextBuilder> {
	public static DeclarationMapper getInstance() {
		return INSTANCE;
	}

	private static final DeclarationMapper INSTANCE = new DeclarationMapper();

	private DeclarationMapper() { }

	@Override
	public ContextBuilder map(AbsDeclarationStatement inst) {
		return inst.accept(this);
	}

	@Override
	public ContextBuilder visitVariableDeclaration(VariableDeclaration decl) {
		decl.getIdentifier();
		decl.getInitializer();
		decl.getType();
		return ContextBuilder.newBuilder("variableDeclaration");
	}

	@Override
	public ContextBuilder visitTypeDeclaration(TypeDeclaration decl) {
		decl.getIdentifier();
		decl.getType();
		return ContextBuilder.newBuilder("typeDeclaration");
	}

	@Override
	public ContextBuilder visitChannelPriorityDeclaration(ChannelPrioritySequence decl) {
		decl.getPrioritySequence();
		return ContextBuilder.newBuilder("channelPriorityDeclaration");
	}

	@Override
	public ContextBuilder visitTemplateInstantiation(TemplateInstantiation decl) {
		decl.getArguments();
		decl.getNewTemplateName();
		decl.getSourceTemplateName();
		decl.getParameters();
		return ContextBuilder.newBuilder("templateInstantiation");
	}

	@Override
	public ContextBuilder visitFunctionDeclaration(FunctionDeclaration decl) {
		return ContextBuilder.newBuilder("functionDeclaration")
				.put("valueType", TypeMapper.getInstance().map(decl.getValueType()))
				.put("identifierValue", decl.getName().getText())
				.put("parameters", ParameterDeclarationMapper.getInstance().mapCollection(decl.getParameterDeclarations()))
				.put("body", StatementMapper.getInstance().map(decl.getBody()));
	}

	@Override
	public ContextBuilder visitDeclarationGroup(DeclarationGroup group) {
		return ContextBuilder.newBuilder("declarationGroup")
				.put("declarations", mapCollection(((DeclarationGroup<?>) group).getAbstractDeclarations()));
	}
}
