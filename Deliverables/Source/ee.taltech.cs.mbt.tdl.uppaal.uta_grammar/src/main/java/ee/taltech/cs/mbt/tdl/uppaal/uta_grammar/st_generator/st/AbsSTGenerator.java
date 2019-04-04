package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.STRegistry.MissingSTException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.STWrapper.InvalidSTFormatException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.STWrapper.STRenderingException;
import org.stringtemplate.v4.ST;

import java.util.Collection;
import java.util.Optional;

public abstract class AbsSTGenerator<T> {
	private STRegistry stRegistry;

	protected AbsSTGenerator(STRegistry stRegistry) {
		this.stRegistry = stRegistry;
	}

	protected abstract IContextMapper<T> getContextMapper();

	protected abstract String getTemplateName();
	protected abstract Optional<String> getIterableTemplateName();

	public String generate(T inst) throws CodeGenerationException {
		try {
			ST st = stRegistry.getTemplate(getTemplateName());
			STWrapper stWrapper = STWrapper.wrap(st);
			stWrapper.setRootContext(getContextMapper().map(inst));
			return stWrapper.render();
		} catch (MissingSTException | InvalidSTFormatException ex) {
			throw new RuntimeException(ex.getMessage(), ex); // Not recoverable
		} catch (STRenderingException e) {
			throw new CodeGenerationException("Code generation failed. Template exception.", e);
		} catch (Throwable t) {
			throw new CodeGenerationException("Code generation failed. Unexpected error", t);
		}
	}

	public String generate(Collection<T> instances) throws CodeGenerationException {
		String templateName = getIterableTemplateName()
				.orElseThrow(() -> new UnsupportedOperationException("This generator does not support collections."));
		try {
			ST st = stRegistry.getTemplate(templateName);
			STWrapper stWrapper = STWrapper.wrap(st);
			Collection<ContextBuilder> ctxBuilders = getContextMapper().map(instances);
			stWrapper.setRootIterable(ctxBuilders);
			return stWrapper.render();
		} catch (MissingSTException | InvalidSTFormatException ex) {
			throw new RuntimeException(ex.getMessage(), ex); // Not recoverable
		} catch (STRenderingException e) {
			throw new CodeGenerationException("Code generation failed. Template exception.", e);
		} catch (Throwable t) {
			throw new CodeGenerationException("Code generation failed. Unexpected error", t);
		}
	}
}
