package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation.ITypeIdentifierVisitor;

public class BaseTypeIdentifiers {
	public static class BooleanTypeIdentifier extends AbsTypeIdentifier {
		private BooleanTypeIdentifier() { }

		@Override
		public void accept(ITypeIdentifierVisitor visitor) {
			visitor.visitBooleanTypeIdentifier(this);
		}
	}

	public static class IntegerTypeIdentifier extends AbsTypeIdentifier {
		private IntegerTypeIdentifier() { }

		@Override
		public void accept(ITypeIdentifierVisitor visitor) {
			visitor.visitIntegerTypeIdentifier(this);
		}
	}

	public static class ChannelTypeIdentifier extends AbsTypeIdentifier {
		private ChannelTypeIdentifier() { }

		@Override
		public void accept(ITypeIdentifierVisitor visitor) {
			visitor.visitChannelTypeIdentifier(this);
		}
	}

	public static class ClockTypeIdentifier extends AbsTypeIdentifier {
		private ClockTypeIdentifier() { }

		@Override
		public void accept(ITypeIdentifierVisitor visitor) {
			visitor.visitClockTypeIdentifier(this);
		}
	}

	public static final AbsTypeIdentifier BOOLEAN = new BooleanTypeIdentifier();
	public static final AbsTypeIdentifier INTEGER = new IntegerTypeIdentifier();
	public static final AbsTypeIdentifier CHANNEL = new ChannelTypeIdentifier();
	public static final AbsTypeIdentifier CLOCK = new ClockTypeIdentifier();

	private BaseTypeIdentifiers() { }
}
