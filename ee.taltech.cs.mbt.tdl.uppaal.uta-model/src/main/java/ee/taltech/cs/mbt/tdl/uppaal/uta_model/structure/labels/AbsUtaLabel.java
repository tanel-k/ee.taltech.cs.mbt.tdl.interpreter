package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;

public abstract class AbsUtaLabel<ContentType> implements IDeepCloneable<AbsUtaLabel<ContentType>> {
	private ContentType content;

	public ContentType getContent() {
		return content;
	}

	public AbsUtaLabel<ContentType> setContent(ContentType content) {
		this.content = content;
		return this;
	}

	public abstract <T> T accept(ILabelVisitor<T> visitor);
}
