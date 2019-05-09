package ee.taltech.cs.mbt.tdl.commons.st_utils.generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry.MissingSTException;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STFacade.InvalidSTFormatException;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STFacade.STRenderingException;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import org.stringtemplate.v4.ST;

import java.util.Collection;
import java.util.Optional;

public abstract class AbsSTGenerator<T> {
	private STRegistry stRegistry;
	private ContextBuilder lastContext;
	private AbsSTGenerator ctxProvidingGenerator;
	private Collection<ContextBuilder> lastContextCollection;

	protected AbsSTGenerator(STRegistry stRegistry) {
		this.stRegistry = stRegistry;
	}

	protected abstract IContextExtractor<T> getContextExtractor();
	protected abstract String getTemplateName();
	protected abstract Optional<String> getIterableTemplateName();

	protected STRegistry getStRegistry() {
		return stRegistry;
	}

	protected ContextBuilder extractContext(T inst) {
		// Get context from provider if possible:
		ContextBuilder providedCtx = ctxProvidingGenerator != null
				? ctxProvidingGenerator.getLastContext()
				: null;
		return providedCtx != null
				? providedCtx
				: getContextExtractor().extract(inst);
	}

	protected Collection<ContextBuilder> extractContext(Collection<T> instances) {
		// Get context from provider if possible:
		Collection<ContextBuilder> providedCtxColl = ctxProvidingGenerator != null
				? ctxProvidingGenerator.getLastContextCollection()
				: null;
		return providedCtxColl != null
				? providedCtxColl
				: getContextExtractor().extract(instances);
	}

	public ContextBuilder getLastContext() {
		return lastContext;
	}

	public Collection<ContextBuilder> getLastContextCollection() {
		return lastContextCollection;
	}

	public AbsSTGenerator getContextProvidingGenerator() {
		return ctxProvidingGenerator;
	}

	public AbsSTGenerator<T> setContextProvidingGenerator(AbsSTGenerator ctxProvidingGenerator) {
		this.ctxProvidingGenerator = ctxProvidingGenerator;
		return this;
	}

	public String generate(T inst) throws GenerationException {
		try {
			ST st = stRegistry.getTemplate(getTemplateName());
			STFacade stFacade = STFacade.wrap(st);
			ContextBuilder ctxBuilder =
					(lastContext = extractContext(inst));
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
			Collection<ContextBuilder> ctxBuilders =
					(lastContextCollection = extractContext(instances));
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
