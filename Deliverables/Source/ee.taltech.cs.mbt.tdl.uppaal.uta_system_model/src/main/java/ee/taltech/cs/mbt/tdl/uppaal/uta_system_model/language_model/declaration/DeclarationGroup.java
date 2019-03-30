package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class.<br/>
 * Some declarations in UTA can be grouped together in a single line (e.g variable and type declarations).<br/>
 * This class provides a way to represent such groupings.<br/>
 * {@link AbsDeclarationStatement} types that should be "groupable" must be marked with {@link IGroupableDeclaration}.
 */
public class DeclarationGroup<T extends AbsDeclarationStatement & IGroupableDeclaration> extends AbsDeclarationStatement
	implements Iterable<AbsDeclarationStatement> {
	private List<T> declarations = new LinkedList<>();

	public List<T> getDeclarations() {
		return declarations;
	}

	/**
	 * When this class is encountered without generic type arg information and we need to iterate the nested instances,
	 * we will have to check for each AbsDeclarationStatement & IGroupableDeclaration implementing type.<br/>
	 * To avoid this we provide a method that yields a view of the nested instances reduced to their lower type bound.
	 */
	private List<AbsDeclarationStatement> getAbstractDeclarations() {
		return Collections.unmodifiableList(getDeclarations());
	}

	public boolean hasSingleDeclaration() {
		return getDeclarations().size() == 1;
	}

	public boolean isEmpty() {
		return getDeclarations().isEmpty();
	}

	public AbsDeclarationStatement getFirstDeclaration() {
		if (isEmpty())
			throw new IllegalStateException("The declaration group is empty.");
		return declarations.get(0);
	}

	@Override
	public Iterator<AbsDeclarationStatement> iterator() {
		return getAbstractDeclarations().iterator();
	}

	@Override
	public <V> V accept(IDeclarationVisitor<V> visitor) {
		return visitor.visitDeclarationGroup(this);
	}
}
