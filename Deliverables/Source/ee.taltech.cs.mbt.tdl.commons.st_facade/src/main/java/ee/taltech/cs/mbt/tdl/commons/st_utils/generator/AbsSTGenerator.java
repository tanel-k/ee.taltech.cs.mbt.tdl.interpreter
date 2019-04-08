package ee.taltech.cs.mbt.tdl.commons.st_utils.generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry.MissingSTException;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STFacade.InvalidSTFormatException;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STFacade.STRenderingException;
import org.stringtemplate.v4.ST;

import java.util.Collection;
import java.util.Optional;

public abstract class AbsSTGenerator<T> {
	private STRegistry stRegistry;

	protected AbsSTGenerator(STRegistry stRegistry) {
		this.stRegistry = stRegistry;
	}

	protected abstract IContextExtractor<T> getContextExtractor();

	protected abstract String getTemplateName();
	protected abstract Optional<String> getIterableTemplateName();

	protected ContextBuilder extractContext(T inst) {
		return getContextExtractor().extract(inst);
	}

	protected Collection<ContextBuilder> extractContext(Collection<T> instances) {
		return getContextExtractor().extract(instances);
	}

	public String generate(T inst) throws GenerationException {
		try {
			ST st = stRegistry.getTemplate(getTemplateName());
			STFacade stFacade = STFacade.wrap(st);
			ContextBuilder ctxBuilder = extractContext(inst);
			stFacade.setRootContext(ctxBuilder);
			return stFacade.render();
		} catch (MissingSTException | InvalidSTFormatException ex) {
			throw new RuntimeException(ex.getMessage(), ex); // Not recoverable
		} catch (STRenderingException e) {
			throw new GenerationException("Code generation failed. Template exception.", e);
		} catch (Throwable t) {
			throw new GenerationException("Code generation failed. Unexpected error", t);
		}
	}

	public String generate(Collection<T> instances) throws GenerationException {
		String templateName = getIterableTemplateName()
				.orElseThrow(() -> new UnsupportedOperationException("This generator does not support collections."));
		try {
			ST st = stRegistry.getTemplate(templateName);
			STFacade stFacade = STFacade.wrap(st);
			Collection<ContextBuilder> ctxBuilders = extractContext(instances);
			stFacade.setRootIterable(ctxBuilders);
			return stFacade.render();
		} catch (MissingSTException | InvalidSTFormatException ex) {
			throw new RuntimeException(ex.getMessage(), ex); // Not recoverable
		} catch (STRenderingException e) {
			throw new GenerationException("Code generation failed. Template exception.", e);
		} catch (Throwable t) {
			throw new GenerationException("Code generation failed. Unexpected error", t);
		}
	}
}
