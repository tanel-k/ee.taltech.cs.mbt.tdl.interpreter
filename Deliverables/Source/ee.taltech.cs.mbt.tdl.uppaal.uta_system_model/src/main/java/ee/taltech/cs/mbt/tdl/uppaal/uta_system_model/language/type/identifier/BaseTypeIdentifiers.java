package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier;

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
	public static class BooleanTypeId extends AbsTypeId {
		private BooleanTypeId() { }

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
	public static class IntegerTypeId extends AbsTypeId {
		private IntegerTypeId() { }

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
	public static class ChannelTypeId extends AbsTypeId {
		private ChannelTypeId() { }

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
	public static class ClockTypeId extends AbsTypeId {
		private ClockTypeId() { }

		@Override
		public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
			return visitor.visitClockTypeIdentifier(this);
		}
	}

	public static final BooleanTypeId BOOLEAN = new BooleanTypeId();
	public static final IntegerTypeId INTEGER = new IntegerTypeId();
	public static final ChannelTypeId CHANNEL = new ChannelTypeId();
	public static final ClockTypeId CLOCK = new ClockTypeId();

	private BaseTypeIdentifiers() { }
}
