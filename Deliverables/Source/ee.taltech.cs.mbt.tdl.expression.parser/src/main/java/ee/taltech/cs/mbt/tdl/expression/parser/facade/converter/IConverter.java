package ee.taltech.cs.mbt.tdl.expression.parser.facade.converter;

public interface IConverter<FromType, ToType> {
	ToType convert(FromType sourceObject);
}
