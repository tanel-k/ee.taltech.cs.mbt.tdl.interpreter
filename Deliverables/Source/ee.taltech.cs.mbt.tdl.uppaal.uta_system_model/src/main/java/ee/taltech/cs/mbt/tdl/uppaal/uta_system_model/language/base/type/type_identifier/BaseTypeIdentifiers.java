package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation.ITypeIdentifierVisitor;

/**
 * Defines the identifier instances for the 4 predefined Uppaal types: int, bool, clock, chan.<br/>
 */
public class BaseTypeIdentifiers {
	/**
	 * Identifies the predefined UPPAAL type `bool`.<br/>
	 * Variables of type bool can have the values false and true,
	 * which are equivalent to the integer values 0 and 1.<br/>
	 * Any non-zero integer value evaluates to true.<br/>
	 * 0 evaluates to false.<br/>
	 *
	 * Syntax fragment:<br/>
	 * <pre>
	 * TypeId        ::= ... | 'bool' | ...
	 * </pre>
	 */
	public static class BooleanTypeIdentifier extends AbsTypeIdentifier {
		private BooleanTypeIdentifier() { }

		@Override
		public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
			return visitor.visitBooleanTypeIdentifier(this);
		}
	}

	/**
	 * Identifies the predefined UPPAAL type `int`.<br/>
	 * The default range of an integer is [-32768, 32767].<br/>
	 * Syntax fragment:<br/>
	 * <pre>
	 * TypeId        ::= ... | 'int' | ...
	 * </pre>
	 */
	public static class IntegerTypeIdentifier extends AbsTypeIdentifier {
		private IntegerTypeIdentifier() { }

		@Override
		public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
			return visitor.visitIntegerTypeIdentifier(this);
		}
	}

	/**
	 * Identifies the predefined UPPAAL type `chan`.<br/>
	 * Syntax fragment:<br/>
	 * <pre>
	 * TypeId        ::= ... | 'chan' | ...
	 * </pre>
	 */
	public static class ChannelTypeIdentifier extends AbsTypeIdentifier {
		private ChannelTypeIdentifier() { }

		@Override
		public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
			return visitor.visitChannelTypeIdentifier(this);
		}
	}

	/**
	 * Identifies the predefined UPPAAL type `clock`.
	 * Syntax fragment:<br/>
	 * <pre>
	 * TypeId        ::= ... | 'clock' | ...
	 * </pre>
	 */
	public static class ClockTypeIdentifier extends AbsTypeIdentifier {
		private ClockTypeIdentifier() { }

		@Override
		public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
			return visitor.visitClockTypeIdentifier(this);
		}
	}

	public static final BooleanTypeIdentifier BOOLEAN = new BooleanTypeIdentifier();
	public static final IntegerTypeIdentifier INTEGER = new IntegerTypeIdentifier();
	public static final ChannelTypeIdentifier CHANNEL = new ChannelTypeIdentifier();
	public static final ClockTypeIdentifier CLOCK = new ClockTypeIdentifier();

	private BaseTypeIdentifiers() { }
}
