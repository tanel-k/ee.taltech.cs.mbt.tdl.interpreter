package picklePackage;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.StructuredVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.BitwiseAndExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.BitwiseOrExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.CallExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.EqualityExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.FieldAccessExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.GreaterThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.GreaterThanOrEqualExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.GroupedExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.InequalityExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.LeftShiftExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.LessThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.LessThanOrEqualExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.PostfixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.SubtractionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.TernaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.SystemLine;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.ETypePrefix;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.BooleanTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.ChannelTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.ClockTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.IntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.StructTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.InvariantLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SynchronizationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location.LocationName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.LocationLabels;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.TransitionLabels;

import java.util.LinkedList;


public class PickleNameSystemFactory {
	public static class TdlConjunctionRecognizerTemplateFactory {
		public static TdlConjunctionRecognizerTemplateFactory getInstance() {
			return new TdlConjunctionRecognizerTemplateFactory();
		}

		protected TdlConjunctionRecognizerTemplateFactory() { }

		protected ParameterDeclaration newTreeIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("treeIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newLeftOpIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("leftOpIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newRightOpIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("rightOpIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}


		protected Location newId5Location() {
			return new Location()
					.setId("id5")
					.setName(
							new LocationName()
									.setName("End")
									.setCoordinates(GuiCoordinates.of(-2000, -1144))
					)
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1992, -1112));
		}
		protected Location newId7Location() {
			return new Location()
					.setId("id7")
					.setName(
							new LocationName()
									.setName("Idle")
									.setCoordinates(GuiCoordinates.of(-3280, -1032))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-3272, -1000));
		}
		protected Location newId0Location() {
			return new Location()
					.setId("id0")
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-2248, -1000));
		}
		protected Location newId2Location() {
			return new Location()
					.setId("id2")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-2248, -1112));
		}
		protected Location newId1Location() {
			return new Location()
					.setId("id1")
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-2520, -1112));
		}
		protected Location newId6Location() {
			return new Location()
					.setId("id6")
					.setName(
							new LocationName()
									.setName("Ready")
									.setCoordinates(GuiCoordinates.of(-2512, -992))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-2520, -1000));
		}
		protected Location newId3Location() {
			return new Location()
					.setId("id3")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-2776, -1000));
		}
		protected Location newId4Location() {
			return new Location()
					.setId("id4")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-3024, -1000));
		}

		protected Transition newId0ToId2Transition_1(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-2240, -1064)))
					)
					;
		}
		protected Transition newId6ToId1Transition_2(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-2760, -1064)))
					)
					;
		}
		protected Transition newId5ToId7Transition_3(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
					)
					.addNail(GuiCoordinates.of(-1992, -936))
					.addNail(GuiCoordinates.of(-3272, -936));
		}
		protected Transition newId1ToId2Transition_4(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-2512, -1144)))
					)
					;
		}
		protected Transition newId3ToId6Transition_5(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-2768, -992)))
					)
					;
		}
		protected Transition newId4ToId3Transition_6(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-3008, -992)))
					)
					;
		}
		protected Transition newId6ToId0Transition_7(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-2504, -1024)))
					)
					;
		}
		protected Transition newId7ToId4Transition_8(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-3248, -1024)))
					)
					;
		}
		protected Transition newId2ToId5Transition_9(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			new ArrayLookupExpression()
																					.setLeftChild(
																							IdentifierExpression.of("TdlDiagnostics")
																					)
																					.setRightChild(
																							IdentifierExpression.of("treeIndex")
																					)
																	)
																	.setRightChild(
																			LiteralConsts.TRUE
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-2232, -1136)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-2232, -1104)))
					)
					;
		}

		public Template newTdlConjunctionRecognizerTemplate() {
			Template TdlConjunctionRecognizer = new Template();

			// Template name:
			Identifier identifier = Identifier.of("TdlConjunctionRecognizer");
			TdlConjunctionRecognizer.setName(identifier);

			// Set parameter declarations:
			CollectionUtils.addIfNonNull(
					TdlConjunctionRecognizer.getParameters(),
					newTreeIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlConjunctionRecognizer.getParameters(),
					newLeftOpIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlConjunctionRecognizer.getParameters(),
					newRightOpIndexParameterDeclaration()
			);

			// Set local declarations:

			// Set locations:
			Location locationId5 = newId5Location();
			TdlConjunctionRecognizer.getLocationGraph()
					.addVertex(locationId5);

			Location locationId7 = newId7Location();
			TdlConjunctionRecognizer.getLocationGraph()
					.addVertex(locationId7);
			TdlConjunctionRecognizer.setInitialLocation(locationId7);
			Location locationId0 = newId0Location();
			TdlConjunctionRecognizer.getLocationGraph()
					.addVertex(locationId0);

			Location locationId2 = newId2Location();
			TdlConjunctionRecognizer.getLocationGraph()
					.addVertex(locationId2);

			Location locationId1 = newId1Location();
			TdlConjunctionRecognizer.getLocationGraph()
					.addVertex(locationId1);

			Location locationId6 = newId6Location();
			TdlConjunctionRecognizer.getLocationGraph()
					.addVertex(locationId6);

			Location locationId3 = newId3Location();
			TdlConjunctionRecognizer.getLocationGraph()
					.addVertex(locationId3);

			Location locationId4 = newId4Location();
			TdlConjunctionRecognizer.getLocationGraph()
					.addVertex(locationId4);


			// Set transitions:
			Transition transitionId0ToId2_1 = newId0ToId2Transition_1(
					locationId0,
					locationId2
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId0,
					locationId2,
					transitionId0ToId2_1
			);
			Transition transitionId6ToId1_2 = newId6ToId1Transition_2(
					locationId6,
					locationId1
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId6,
					locationId1,
					transitionId6ToId1_2
			);
			Transition transitionId5ToId7_3 = newId5ToId7Transition_3(
					locationId5,
					locationId7
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId5,
					locationId7,
					transitionId5ToId7_3
			);
			Transition transitionId1ToId2_4 = newId1ToId2Transition_4(
					locationId1,
					locationId2
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId1,
					locationId2,
					transitionId1ToId2_4
			);
			Transition transitionId3ToId6_5 = newId3ToId6Transition_5(
					locationId3,
					locationId6
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId3,
					locationId6,
					transitionId3ToId6_5
			);
			Transition transitionId4ToId3_6 = newId4ToId3Transition_6(
					locationId4,
					locationId3
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId4,
					locationId3,
					transitionId4ToId3_6
			);
			Transition transitionId6ToId0_7 = newId6ToId0Transition_7(
					locationId6,
					locationId0
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId6,
					locationId0,
					transitionId6ToId0_7
			);
			Transition transitionId7ToId4_8 = newId7ToId4Transition_8(
					locationId7,
					locationId4
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId7,
					locationId4,
					transitionId7ToId4_8
			);
			Transition transitionId2ToId5_9 = newId2ToId5Transition_9(
					locationId2,
					locationId5
			);
			TdlConjunctionRecognizer.getLocationGraph().addEdge(
					locationId2,
					locationId5,
					transitionId2ToId5_9
			);

			return TdlConjunctionRecognizer;
		}
	}

	public static class TdlDisjunctionRecognizerTemplateFactory {
		public static TdlDisjunctionRecognizerTemplateFactory getInstance() {
			return new TdlDisjunctionRecognizerTemplateFactory();
		}

		protected TdlDisjunctionRecognizerTemplateFactory() { }

		protected ParameterDeclaration newTreeIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("treeIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newLeftOpIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("leftOpIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newRightOpIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("rightOpIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}


		protected Location newId9Location() {
			return new Location()
					.setId("id9")
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1000, -600));
		}
		protected Location newId8Location() {
			return new Location()
					.setId("id8")
					.setName(
							new LocationName()
									.setName("End")
									.setCoordinates(GuiCoordinates.of(-760, -632))
					)
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-752, -600));
		}
		protected Location newId10Location() {
			return new Location()
					.setId("id10")
					.setName(
							new LocationName()
									.setName("Ready")
									.setCoordinates(GuiCoordinates.of(-1288, -512))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1296, -520));
		}
		protected Location newId11Location() {
			return new Location()
					.setId("id11")
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1552, -520));
		}
		protected Location newId12Location() {
			return new Location()
					.setId("id12")
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1792, -520));
		}
		protected Location newId13Location() {
			return new Location()
					.setId("id13")
					.setName(
							new LocationName()
									.setName("Idle")
									.setCoordinates(GuiCoordinates.of(-2040, -552))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-2032, -520));
		}

		protected Transition newId12ToId11Transition_1(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1784, -512)))
					)
					;
		}
		protected Transition newId11ToId10Transition_2(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1536, -512)))
					)
					;
		}
		protected Transition newId13ToId12Transition_3(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-2016, -544)))
					)
					;
		}
		protected Transition newId10ToId9Transition_4(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1272, -544)))
					)
					.addNail(GuiCoordinates.of(-1000, -520));
		}
		protected Transition newId9ToId8Transition_5(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			new ArrayLookupExpression()
																					.setLeftChild(
																							IdentifierExpression.of("TdlDiagnostics")
																					)
																					.setRightChild(
																							IdentifierExpression.of("treeIndex")
																					)
																	)
																	.setRightChild(
																			LiteralConsts.TRUE
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-976, -624)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-984, -592)))
					)
					;
		}
		protected Transition newId10ToId9Transition_6(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1272, -624)))
					)
					.addNail(GuiCoordinates.of(-1296, -600));
		}
		protected Transition newId8ToId13Transition_7(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
					)
					.addNail(GuiCoordinates.of(-752, -456))
					.addNail(GuiCoordinates.of(-2032, -456));
		}

		public Template newTdlDisjunctionRecognizerTemplate() {
			Template TdlDisjunctionRecognizer = new Template();

			// Template name:
			Identifier identifier = Identifier.of("TdlDisjunctionRecognizer");
			TdlDisjunctionRecognizer.setName(identifier);

			// Set parameter declarations:
			CollectionUtils.addIfNonNull(
					TdlDisjunctionRecognizer.getParameters(),
					newTreeIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlDisjunctionRecognizer.getParameters(),
					newLeftOpIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlDisjunctionRecognizer.getParameters(),
					newRightOpIndexParameterDeclaration()
			);

			// Set local declarations:

			// Set locations:
			Location locationId9 = newId9Location();
			TdlDisjunctionRecognizer.getLocationGraph()
					.addVertex(locationId9);

			Location locationId8 = newId8Location();
			TdlDisjunctionRecognizer.getLocationGraph()
					.addVertex(locationId8);

			Location locationId10 = newId10Location();
			TdlDisjunctionRecognizer.getLocationGraph()
					.addVertex(locationId10);

			Location locationId11 = newId11Location();
			TdlDisjunctionRecognizer.getLocationGraph()
					.addVertex(locationId11);

			Location locationId12 = newId12Location();
			TdlDisjunctionRecognizer.getLocationGraph()
					.addVertex(locationId12);

			Location locationId13 = newId13Location();
			TdlDisjunctionRecognizer.getLocationGraph()
					.addVertex(locationId13);
			TdlDisjunctionRecognizer.setInitialLocation(locationId13);

			// Set transitions:
			Transition transitionId12ToId11_1 = newId12ToId11Transition_1(
					locationId12,
					locationId11
			);
			TdlDisjunctionRecognizer.getLocationGraph().addEdge(
					locationId12,
					locationId11,
					transitionId12ToId11_1
			);
			Transition transitionId11ToId10_2 = newId11ToId10Transition_2(
					locationId11,
					locationId10
			);
			TdlDisjunctionRecognizer.getLocationGraph().addEdge(
					locationId11,
					locationId10,
					transitionId11ToId10_2
			);
			Transition transitionId13ToId12_3 = newId13ToId12Transition_3(
					locationId13,
					locationId12
			);
			TdlDisjunctionRecognizer.getLocationGraph().addEdge(
					locationId13,
					locationId12,
					transitionId13ToId12_3
			);
			Transition transitionId10ToId9_4 = newId10ToId9Transition_4(
					locationId10,
					locationId9
			);
			TdlDisjunctionRecognizer.getLocationGraph().addEdge(
					locationId10,
					locationId9,
					transitionId10ToId9_4
			);
			Transition transitionId9ToId8_5 = newId9ToId8Transition_5(
					locationId9,
					locationId8
			);
			TdlDisjunctionRecognizer.getLocationGraph().addEdge(
					locationId9,
					locationId8,
					transitionId9ToId8_5
			);
			Transition transitionId10ToId9_6 = newId10ToId9Transition_6(
					locationId10,
					locationId9
			);
			TdlDisjunctionRecognizer.getLocationGraph().addEdge(
					locationId10,
					locationId9,
					transitionId10ToId9_6
			);
			Transition transitionId8ToId13_7 = newId8ToId13Transition_7(
					locationId8,
					locationId13
			);
			TdlDisjunctionRecognizer.getLocationGraph().addEdge(
					locationId8,
					locationId13,
					transitionId8ToId13_7
			);

			return TdlDisjunctionRecognizer;
		}
	}

	public static class TdlQuantificationRecognizerTemplateFactory {
		public static TdlQuantificationRecognizerTemplateFactory getInstance() {
			return new TdlQuantificationRecognizerTemplateFactory();
		}

		protected TdlQuantificationRecognizerTemplateFactory() { }

		protected ParameterDeclaration newUniversalParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("universal"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											BaseTypeIdentifiers.BOOLEAN
									))
					);
		}
		protected ParameterDeclaration newNegatedParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("negated"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											BaseTypeIdentifiers.BOOLEAN
									))
					);
		}
		protected ParameterDeclaration newTreeIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("treeIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newTrapsetParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("trapset"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.NONE)
									.setTypeId(
											CustomTypeId.of(Identifier.of("Trapset"))
									))
							.setReferenceType(true)
					);
		}

		protected VariableDeclaration newNegatedUniversalQuantificationDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("negatedUniversalQuantification"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new ConjunctionExpression()
															.setLeftChild(
																	IdentifierExpression.of("universal")
															)
															.setRightChild(
																	IdentifierExpression.of("negated")
															)
											)
							)


					;
		}
		protected VariableDeclaration newNegatedExistentialQuantificationDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("negatedExistentialQuantification"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new ConjunctionExpression()
															.setLeftChild(
																	new NegationExpression()
																			.setChild(
																					IdentifierExpression.of("universal")
																			)
															)
															.setRightChild(
																	IdentifierExpression.of("negated")
															)
											)
							)


					;
		}
		protected VariableDeclaration newUniversalQuantificationDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("universalQuantification"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new ConjunctionExpression()
															.setLeftChild(
																	IdentifierExpression.of("universal")
															)
															.setRightChild(
																	new NegationExpression()
																			.setChild(
																					IdentifierExpression.of("negated")
																			)
															)
											)
							)


					;
		}
		protected VariableDeclaration newExistentialQuantificationDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("existentialQuantification"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new ConjunctionExpression()
															.setLeftChild(
																	new NegationExpression()
																			.setChild(
																					IdentifierExpression.of("universal")
																			)
															)
															.setRightChild(
																	new NegationExpression()
																			.setChild(
																					IdentifierExpression.of("negated")
																			)
															)
											)
							)


					;
		}

		protected Location newId16Location() {
			return new Location()
					.setId("id16")
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-552, -8));
		}
		protected Location newId14Location() {
			return new Location()
					.setId("id14")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-104, -8));
		}
		protected Location newId15Location() {
			return new Location()
					.setId("id15")
					.setName(
							new LocationName()
									.setName("End")
									.setCoordinates(GuiCoordinates.of(128, -40))
					)
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(144, -8));
		}
		protected Location newId17Location() {
			return new Location()
					.setId("id17")
					.setName(
							new LocationName()
									.setName("Idle")
									.setCoordinates(GuiCoordinates.of(-800, -40))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-792, -8));
		}

		protected Transition newId14ToId15Transition_1(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			new ArrayLookupExpression()
																					.setLeftChild(
																							IdentifierExpression.of("TdlDiagnostics")
																					)
																					.setRightChild(
																							IdentifierExpression.of("treeIndex")
																					)
																	)
																	.setRightChild(
																			LiteralConsts.TRUE
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-88, -32)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-88, 0)))
					)
					;
		}
		protected Transition newId16ToId14Transition_2(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("negatedUniversalQuantification")
													)
													.setRightChild(
															new GroupedExpression().setChild(
																	new InequalityExpression()
																			.setLeftChild(
																					new FieldAccessExpression()
																							.setIdentifier(Identifier.of("flags"))
																							.setChild(
																									IdentifierExpression.of("trapset")
																							)
																			)
																			.setRightChild(
																					new FieldAccessExpression()
																							.setIdentifier(Identifier.of("fullMask"))
																							.setChild(
																									IdentifierExpression.of("trapset")
																							)
																			)
															)
													)
									)
											.setCoordinates(GuiCoordinates.of(-496, -96)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TrapsetActivatorChannels")
															)
															.setRightChild(
																	new FieldAccessExpression()
																			.setIdentifier(Identifier.of("index"))
																			.setChild(
																					IdentifierExpression.of("trapset")
																			)
															)
											))
											.setCoordinates(GuiCoordinates.of(-496, -72)))
					)
					.addNail(GuiCoordinates.of(-552, -72))
					.addNail(GuiCoordinates.of(-104, -72));
		}
		protected Transition newId16ToId14Transition_3(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("existentialQuantification")
													)
													.setRightChild(
															new GroupedExpression().setChild(
																	new GreaterThanExpression()
																			.setLeftChild(
																					new FieldAccessExpression()
																							.setIdentifier(Identifier.of("flags"))
																							.setChild(
																									IdentifierExpression.of("trapset")
																							)
																			)
																			.setRightChild(
																					NaturalNumberLiteral.of("0")
																			)
															)
													)
									)
											.setCoordinates(GuiCoordinates.of(-488, 72)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TrapsetActivatorChannels")
															)
															.setRightChild(
																	new FieldAccessExpression()
																			.setIdentifier(Identifier.of("index"))
																			.setChild(
																					IdentifierExpression.of("trapset")
																			)
															)
											))
											.setCoordinates(GuiCoordinates.of(-488, 96)))
					)
					.addNail(GuiCoordinates.of(-552, 96))
					.addNail(GuiCoordinates.of(-104, 96));
		}
		protected Transition newId15ToId17Transition_4(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new CallExpression()
																	.addArgument(
																			IdentifierExpression.of("trapset")
																	)

																	.setChild(
																			IdentifierExpression.of("resetTrapset")
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-408, 136)))
					)
					.addNail(GuiCoordinates.of(144, 160))
					.addNail(GuiCoordinates.of(-792, 160));
		}
		protected Transition newId16ToId14Transition_5(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("universalQuantification")
													)
													.setRightChild(
															new GroupedExpression().setChild(
																	new EqualityExpression()
																			.setLeftChild(
																					new FieldAccessExpression()
																							.setIdentifier(Identifier.of("flags"))
																							.setChild(
																									IdentifierExpression.of("trapset")
																							)
																			)
																			.setRightChild(
																					new FieldAccessExpression()
																							.setIdentifier(Identifier.of("fullMask"))
																							.setChild(
																									IdentifierExpression.of("trapset")
																							)
																			)
															)
													)
									)
											.setCoordinates(GuiCoordinates.of(-496, -144)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TrapsetActivatorChannels")
															)
															.setRightChild(
																	new FieldAccessExpression()
																			.setIdentifier(Identifier.of("index"))
																			.setChild(
																					IdentifierExpression.of("trapset")
																			)
															)
											))
											.setCoordinates(GuiCoordinates.of(-496, -120)))
					)
					.addNail(GuiCoordinates.of(-552, -120))
					.addNail(GuiCoordinates.of(-104, -120))
					.addNail(GuiCoordinates.of(-104, -80));
		}
		protected Transition newId17ToId16Transition_6(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-776, 0)))
					)
					;
		}
		protected Transition newId16ToId14Transition_7(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("negatedExistentialQuantification")
													)
													.setRightChild(
															new GroupedExpression().setChild(
																	new EqualityExpression()
																			.setLeftChild(
																					new FieldAccessExpression()
																							.setIdentifier(Identifier.of("flags"))
																							.setChild(
																									IdentifierExpression.of("trapset")
																							)
																			)
																			.setRightChild(
																					NaturalNumberLiteral.of("0")
																			)
															)
													)
									)
											.setCoordinates(GuiCoordinates.of(-488, 8)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TrapsetActivatorChannels")
															)
															.setRightChild(
																	new FieldAccessExpression()
																			.setIdentifier(Identifier.of("index"))
																			.setChild(
																					IdentifierExpression.of("trapset")
																			)
															)
											))
											.setCoordinates(GuiCoordinates.of(-488, 32)))
					)
					.addNail(GuiCoordinates.of(-552, 32))
					.addNail(GuiCoordinates.of(-104, 32));
		}

		public Template newTdlQuantificationRecognizerTemplate() {
			Template TdlQuantificationRecognizer = new Template();

			// Template name:
			Identifier identifier = Identifier.of("TdlQuantificationRecognizer");
			TdlQuantificationRecognizer.setName(identifier);

			// Set parameter declarations:
			CollectionUtils.addIfNonNull(
					TdlQuantificationRecognizer.getParameters(),
					newUniversalParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlQuantificationRecognizer.getParameters(),
					newNegatedParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlQuantificationRecognizer.getParameters(),
					newTreeIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlQuantificationRecognizer.getParameters(),
					newTrapsetParameterDeclaration()
			);

			// Set local declarations:
			CollectionUtils.addIfNonNull(
					TdlQuantificationRecognizer.getDeclarations(),
					newNegatedUniversalQuantificationDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlQuantificationRecognizer.getDeclarations(),
					newNegatedExistentialQuantificationDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlQuantificationRecognizer.getDeclarations(),
					newUniversalQuantificationDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlQuantificationRecognizer.getDeclarations(),
					newExistentialQuantificationDeclaration()
			);

			// Set locations:
			Location locationId16 = newId16Location();
			TdlQuantificationRecognizer.getLocationGraph()
					.addVertex(locationId16);

			Location locationId14 = newId14Location();
			TdlQuantificationRecognizer.getLocationGraph()
					.addVertex(locationId14);

			Location locationId15 = newId15Location();
			TdlQuantificationRecognizer.getLocationGraph()
					.addVertex(locationId15);

			Location locationId17 = newId17Location();
			TdlQuantificationRecognizer.getLocationGraph()
					.addVertex(locationId17);
			TdlQuantificationRecognizer.setInitialLocation(locationId17);

			// Set transitions:
			Transition transitionId14ToId15_1 = newId14ToId15Transition_1(
					locationId14,
					locationId15
			);
			TdlQuantificationRecognizer.getLocationGraph().addEdge(
					locationId14,
					locationId15,
					transitionId14ToId15_1
			);
			Transition transitionId16ToId14_2 = newId16ToId14Transition_2(
					locationId16,
					locationId14
			);
			TdlQuantificationRecognizer.getLocationGraph().addEdge(
					locationId16,
					locationId14,
					transitionId16ToId14_2
			);
			Transition transitionId16ToId14_3 = newId16ToId14Transition_3(
					locationId16,
					locationId14
			);
			TdlQuantificationRecognizer.getLocationGraph().addEdge(
					locationId16,
					locationId14,
					transitionId16ToId14_3
			);
			Transition transitionId15ToId17_4 = newId15ToId17Transition_4(
					locationId15,
					locationId17
			);
			TdlQuantificationRecognizer.getLocationGraph().addEdge(
					locationId15,
					locationId17,
					transitionId15ToId17_4
			);
			Transition transitionId16ToId14_5 = newId16ToId14Transition_5(
					locationId16,
					locationId14
			);
			TdlQuantificationRecognizer.getLocationGraph().addEdge(
					locationId16,
					locationId14,
					transitionId16ToId14_5
			);
			Transition transitionId17ToId16_6 = newId17ToId16Transition_6(
					locationId17,
					locationId16
			);
			TdlQuantificationRecognizer.getLocationGraph().addEdge(
					locationId17,
					locationId16,
					transitionId17ToId16_6
			);
			Transition transitionId16ToId14_7 = newId16ToId14Transition_7(
					locationId16,
					locationId14
			);
			TdlQuantificationRecognizer.getLocationGraph().addEdge(
					locationId16,
					locationId14,
					transitionId16ToId14_7
			);

			return TdlQuantificationRecognizer;
		}
	}

	public static class TdlLeadsToRecognizerTemplateFactory {
		public static TdlLeadsToRecognizerTemplateFactory getInstance() {
			return new TdlLeadsToRecognizerTemplateFactory();
		}

		protected TdlLeadsToRecognizerTemplateFactory() { }

		protected ParameterDeclaration newTreeIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("treeIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newLeftOpIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("leftOpIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newRightOpIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("rightOpIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}


		protected Location newId18Location() {
			return new Location()
					.setId("id18")
					.setName(
							new LocationName()
									.setName("End")
									.setCoordinates(GuiCoordinates.of(288, -448))
					)
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(296, -416));
		}
		protected Location newId24Location() {
			return new Location()
					.setId("id24")
					.setName(
							new LocationName()
									.setName("Idle")
									.setCoordinates(GuiCoordinates.of(-1208, -448))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1200, -416));
		}
		protected Location newId19Location() {
			return new Location()
					.setId("id19")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(48, -416));
		}
		protected Location newId20Location() {
			return new Location()
					.setId("id20")
					.setName(
							new LocationName()
									.setName("ReadyForRightOp")
									.setCoordinates(GuiCoordinates.of(-264, -448))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-216, -416));
		}
		protected Location newId21Location() {
			return new Location()
					.setId("id21")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-464, -416));
		}
		protected Location newId22Location() {
			return new Location()
					.setId("id22")
					.setName(
							new LocationName()
									.setName("ReadyForLeftOp")
									.setCoordinates(GuiCoordinates.of(-768, -448))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-720, -416));
		}
		protected Location newId23Location() {
			return new Location()
					.setId("id23")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-952, -416));
		}

		protected Transition newId23ToId22Transition_1(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-944, -408)))
					)
					;
		}
		protected Transition newId19ToId18Transition_2(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			new ArrayLookupExpression()
																					.setLeftChild(
																							IdentifierExpression.of("TdlDiagnostics")
																					)
																					.setRightChild(
																							IdentifierExpression.of("treeIndex")
																					)
																	)
																	.setRightChild(
																			LiteralConsts.TRUE
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(64, -416)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(64, -440)))
					)
					;
		}
		protected Transition newId24ToId23Transition_3(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1184, -440)))
					)
					;
		}
		protected Transition newId18ToId24Transition_4(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
					)
					.addNail(GuiCoordinates.of(296, -360))
					.addNail(GuiCoordinates.of(-1200, -360));
		}
		protected Transition newId21ToId20Transition_5(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-456, -408)))
					)
					;
		}
		protected Transition newId22ToId21Transition_6(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-712, -408)))
					)
					;
		}
		protected Transition newId20ToId19Transition_7(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-208, -408)))
					)
					;
		}

		public Template newTdlLeadsToRecognizerTemplate() {
			Template TdlLeadsToRecognizer = new Template();

			// Template name:
			Identifier identifier = Identifier.of("TdlLeadsToRecognizer");
			TdlLeadsToRecognizer.setName(identifier);

			// Set parameter declarations:
			CollectionUtils.addIfNonNull(
					TdlLeadsToRecognizer.getParameters(),
					newTreeIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlLeadsToRecognizer.getParameters(),
					newLeftOpIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlLeadsToRecognizer.getParameters(),
					newRightOpIndexParameterDeclaration()
			);

			// Set local declarations:

			// Set locations:
			Location locationId18 = newId18Location();
			TdlLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId18);

			Location locationId24 = newId24Location();
			TdlLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId24);
			TdlLeadsToRecognizer.setInitialLocation(locationId24);
			Location locationId19 = newId19Location();
			TdlLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId19);

			Location locationId20 = newId20Location();
			TdlLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId20);

			Location locationId21 = newId21Location();
			TdlLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId21);

			Location locationId22 = newId22Location();
			TdlLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId22);

			Location locationId23 = newId23Location();
			TdlLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId23);


			// Set transitions:
			Transition transitionId23ToId22_1 = newId23ToId22Transition_1(
					locationId23,
					locationId22
			);
			TdlLeadsToRecognizer.getLocationGraph().addEdge(
					locationId23,
					locationId22,
					transitionId23ToId22_1
			);
			Transition transitionId19ToId18_2 = newId19ToId18Transition_2(
					locationId19,
					locationId18
			);
			TdlLeadsToRecognizer.getLocationGraph().addEdge(
					locationId19,
					locationId18,
					transitionId19ToId18_2
			);
			Transition transitionId24ToId23_3 = newId24ToId23Transition_3(
					locationId24,
					locationId23
			);
			TdlLeadsToRecognizer.getLocationGraph().addEdge(
					locationId24,
					locationId23,
					transitionId24ToId23_3
			);
			Transition transitionId18ToId24_4 = newId18ToId24Transition_4(
					locationId18,
					locationId24
			);
			TdlLeadsToRecognizer.getLocationGraph().addEdge(
					locationId18,
					locationId24,
					transitionId18ToId24_4
			);
			Transition transitionId21ToId20_5 = newId21ToId20Transition_5(
					locationId21,
					locationId20
			);
			TdlLeadsToRecognizer.getLocationGraph().addEdge(
					locationId21,
					locationId20,
					transitionId21ToId20_5
			);
			Transition transitionId22ToId21_6 = newId22ToId21Transition_6(
					locationId22,
					locationId21
			);
			TdlLeadsToRecognizer.getLocationGraph().addEdge(
					locationId22,
					locationId21,
					transitionId22ToId21_6
			);
			Transition transitionId20ToId19_7 = newId20ToId19Transition_7(
					locationId20,
					locationId19
			);
			TdlLeadsToRecognizer.getLocationGraph().addEdge(
					locationId20,
					locationId19,
					transitionId20ToId19_7
			);

			return TdlLeadsToRecognizer;
		}
	}

	public static class TdlBoundedLeadsToRecognizerTemplateFactory {
		public static TdlBoundedLeadsToRecognizerTemplateFactory getInstance() {
			return new TdlBoundedLeadsToRecognizerTemplateFactory();
		}

		protected TdlBoundedLeadsToRecognizerTemplateFactory() { }

		protected ParameterDeclaration newBoundTypeParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("boundType"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("BoundType"))
									))
					);
		}
		protected ParameterDeclaration newBoundValueParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("boundValue"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("BoundValue"))
									))
					);
		}
		protected ParameterDeclaration newTreeIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("treeIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newLeftOpIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("leftOpIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newRightOpIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("rightOpIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}

		protected VariableDeclaration newLessThanBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("lessThanBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_LT")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newLessThanOrEqBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("lessThanOrEqBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_LTE")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newGreaterThanBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("greaterThanBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_GT")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newGreaterThanOrEqBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("greaterThanOrEqBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_GTE")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newEqualityBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("equalityBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_EQ")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newLocalClockDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("localClock"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.NONE)
											.setTypeId(
													BaseTypeIdentifiers.CLOCK
											))
							)


					;
		}

		protected Location newId27Location() {
			return new Location()
					.setId("id27")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-232, -96));
		}
		protected Location newId31Location() {
			return new Location()
					.setId("id31")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1304, -96));
		}
		protected Location newId28Location() {
			return new Location()
					.setId("id28")
					.setName(
							new LocationName()
									.setName("ReadyForRightOp")
									.setCoordinates(GuiCoordinates.of(-552, -136))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-504, -96));
		}
		protected Location newId26Location() {
			return new Location()
					.setId("id26")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-96, -96));
		}
		protected Location newId25Location() {
			return new Location()
					.setId("id25")
					.setName(
							new LocationName()
									.setName("End")
									.setCoordinates(GuiCoordinates.of(136, -128))
					)
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(152, -96));
		}
		protected Location newId32Location() {
			return new Location()
					.setId("id32")
					.setName(
							new LocationName()
									.setName("Idle")
									.setCoordinates(GuiCoordinates.of(-1554, -126))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1544, -96));
		}
		protected Location newId29Location() {
			return new Location()
					.setId("id29")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-768, -96));
		}
		protected Location newId30Location() {
			return new Location()
					.setId("id30")
					.setName(
							new LocationName()
									.setName("ReadyForLeftOp")
									.setCoordinates(GuiCoordinates.of(-1088, -136))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1040, -96));
		}

		protected Transition newId27ToId28Transition_1(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("equalityBound")
													)
													.setRightChild(
															new LessThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-504, 0)))
					)
					.addNail(GuiCoordinates.of(-232, 24))
					.addNail(GuiCoordinates.of(-504, 24));
		}
		protected Transition newId30ToId29Transition_2(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			NaturalNumberLiteral.of("0")
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-964, -96)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1024, -120)))
					)
					;
		}
		protected Transition newId32ToId31Transition_3(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1528, -120)))
					)
					;
		}
		protected Transition newId27ToId26Transition_4(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("lessThanOrEqBound")
													)
													.setRightChild(
															new LessThanOrEqualExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-224, -200)))
					)
					.addNail(GuiCoordinates.of(-232, -176))
					.addNail(GuiCoordinates.of(-96, -176));
		}
		protected Transition newId27ToId31Transition_5(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("lessThanOrEqBound")
													)
													.setRightChild(
															new GreaterThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-912, -200)))
					)
					.addNail(GuiCoordinates.of(-232, -176))
					.addNail(GuiCoordinates.of(-1304, -176));
		}
		protected Transition newId27ToId26Transition_6(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("equalityBound")
													)
													.setRightChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-224, -232)))
					)
					.addNail(GuiCoordinates.of(-232, -208))
					.addNail(GuiCoordinates.of(-96, -208));
		}
		protected Transition newId27ToId31Transition_7(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("equalityBound")
													)
													.setRightChild(
															new GreaterThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-912, -232)))
					)
					.addNail(GuiCoordinates.of(-232, -208))
					.addNail(GuiCoordinates.of(-1304, -208));
		}
		protected Transition newId29ToId28Transition_8(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-752, -120)))
					)
					;
		}
		protected Transition newId31ToId30Transition_9(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("leftOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1288, -120)))
					)
					;
		}
		protected Transition newId27ToId26Transition_10(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("greaterThanOrEqBound")
													)
													.setRightChild(
															new GreaterThanOrEqualExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-224, -32)))
					)
					.addNail(GuiCoordinates.of(-232, -8))
					.addNail(GuiCoordinates.of(-96, -8));
		}
		protected Transition newId27ToId26Transition_11(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("greaterThanBound")
													)
													.setRightChild(
															new GreaterThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-224, -64)))
					)
					.addNail(GuiCoordinates.of(-232, -40))
					.addNail(GuiCoordinates.of(-96, -40));
		}
		protected Transition newId27ToId26Transition_12(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("lessThanBound")
													)
													.setRightChild(
															new LessThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-224, -168)))
					)
					.addNail(GuiCoordinates.of(-232, -144))
					.addNail(GuiCoordinates.of(-96, -144));
		}
		protected Transition newId26ToId25Transition_13(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			new ArrayLookupExpression()
																					.setLeftChild(
																							IdentifierExpression.of("TdlDiagnostics")
																					)
																					.setRightChild(
																							IdentifierExpression.of("treeIndex")
																					)
																	)
																	.setRightChild(
																			LiteralConsts.TRUE
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-80, -96)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-80, -120)))
					)
					;
		}
		protected Transition newId27ToId28Transition_14(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("greaterThanOrEqBound")
													)
													.setRightChild(
															new LessThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-568, -32)))
					)
					.addNail(GuiCoordinates.of(-232, -8))
					.addNail(GuiCoordinates.of(-504, -8));
		}
		protected Transition newId25ToId32Transition_15(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
					)
					.addNail(GuiCoordinates.of(152, 40))
					.addNail(GuiCoordinates.of(-1544, 40));
		}
		protected Transition newId28ToId27Transition_16(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rightOpIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-488, -120)))
					)
					;
		}
		protected Transition newId27ToId31Transition_17(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("lessThanBound")
													)
													.setRightChild(
															new GreaterThanOrEqualExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-912, -168)))
					)
					.addNail(GuiCoordinates.of(-232, -144))
					.addNail(GuiCoordinates.of(-1304, -144));
		}
		protected Transition newId27ToId28Transition_18(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("greaterThanBound")
													)
													.setRightChild(
															new LessThanOrEqualExpression()
																	.setLeftChild(
																			IdentifierExpression.of("localClock")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-544, -64)))
					)
					.addNail(GuiCoordinates.of(-232, -40))
					.addNail(GuiCoordinates.of(-504, -40));
		}

		public Template newTdlBoundedLeadsToRecognizerTemplate() {
			Template TdlBoundedLeadsToRecognizer = new Template();

			// Template name:
			Identifier identifier = Identifier.of("TdlBoundedLeadsToRecognizer");
			TdlBoundedLeadsToRecognizer.setName(identifier);

			// Set parameter declarations:
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getParameters(),
					newBoundTypeParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getParameters(),
					newBoundValueParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getParameters(),
					newTreeIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getParameters(),
					newLeftOpIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getParameters(),
					newRightOpIndexParameterDeclaration()
			);

			// Set local declarations:
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getDeclarations(),
					newLessThanBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getDeclarations(),
					newLessThanOrEqBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getDeclarations(),
					newGreaterThanBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getDeclarations(),
					newGreaterThanOrEqBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getDeclarations(),
					newEqualityBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedLeadsToRecognizer.getDeclarations(),
					newLocalClockDeclaration()
			);

			// Set locations:
			Location locationId27 = newId27Location();
			TdlBoundedLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId27);

			Location locationId31 = newId31Location();
			TdlBoundedLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId31);

			Location locationId28 = newId28Location();
			TdlBoundedLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId28);

			Location locationId26 = newId26Location();
			TdlBoundedLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId26);

			Location locationId25 = newId25Location();
			TdlBoundedLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId25);

			Location locationId32 = newId32Location();
			TdlBoundedLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId32);
			TdlBoundedLeadsToRecognizer.setInitialLocation(locationId32);
			Location locationId29 = newId29Location();
			TdlBoundedLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId29);

			Location locationId30 = newId30Location();
			TdlBoundedLeadsToRecognizer.getLocationGraph()
					.addVertex(locationId30);


			// Set transitions:
			Transition transitionId27ToId28_1 = newId27ToId28Transition_1(
					locationId27,
					locationId28
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId28,
					transitionId27ToId28_1
			);
			Transition transitionId30ToId29_2 = newId30ToId29Transition_2(
					locationId30,
					locationId29
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId30,
					locationId29,
					transitionId30ToId29_2
			);
			Transition transitionId32ToId31_3 = newId32ToId31Transition_3(
					locationId32,
					locationId31
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId32,
					locationId31,
					transitionId32ToId31_3
			);
			Transition transitionId27ToId26_4 = newId27ToId26Transition_4(
					locationId27,
					locationId26
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId26,
					transitionId27ToId26_4
			);
			Transition transitionId27ToId31_5 = newId27ToId31Transition_5(
					locationId27,
					locationId31
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId31,
					transitionId27ToId31_5
			);
			Transition transitionId27ToId26_6 = newId27ToId26Transition_6(
					locationId27,
					locationId26
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId26,
					transitionId27ToId26_6
			);
			Transition transitionId27ToId31_7 = newId27ToId31Transition_7(
					locationId27,
					locationId31
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId31,
					transitionId27ToId31_7
			);
			Transition transitionId29ToId28_8 = newId29ToId28Transition_8(
					locationId29,
					locationId28
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId29,
					locationId28,
					transitionId29ToId28_8
			);
			Transition transitionId31ToId30_9 = newId31ToId30Transition_9(
					locationId31,
					locationId30
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId31,
					locationId30,
					transitionId31ToId30_9
			);
			Transition transitionId27ToId26_10 = newId27ToId26Transition_10(
					locationId27,
					locationId26
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId26,
					transitionId27ToId26_10
			);
			Transition transitionId27ToId26_11 = newId27ToId26Transition_11(
					locationId27,
					locationId26
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId26,
					transitionId27ToId26_11
			);
			Transition transitionId27ToId26_12 = newId27ToId26Transition_12(
					locationId27,
					locationId26
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId26,
					transitionId27ToId26_12
			);
			Transition transitionId26ToId25_13 = newId26ToId25Transition_13(
					locationId26,
					locationId25
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId26,
					locationId25,
					transitionId26ToId25_13
			);
			Transition transitionId27ToId28_14 = newId27ToId28Transition_14(
					locationId27,
					locationId28
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId28,
					transitionId27ToId28_14
			);
			Transition transitionId25ToId32_15 = newId25ToId32Transition_15(
					locationId25,
					locationId32
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId25,
					locationId32,
					transitionId25ToId32_15
			);
			Transition transitionId28ToId27_16 = newId28ToId27Transition_16(
					locationId28,
					locationId27
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId28,
					locationId27,
					transitionId28ToId27_16
			);
			Transition transitionId27ToId31_17 = newId27ToId31Transition_17(
					locationId27,
					locationId31
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId31,
					transitionId27ToId31_17
			);
			Transition transitionId27ToId28_18 = newId27ToId28Transition_18(
					locationId27,
					locationId28
			);
			TdlBoundedLeadsToRecognizer.getLocationGraph().addEdge(
					locationId27,
					locationId28,
					transitionId27ToId28_18
			);

			return TdlBoundedLeadsToRecognizer;
		}
	}

	public static class TdlBoundedRepetitionRecognizerTemplateFactory {
		public static TdlBoundedRepetitionRecognizerTemplateFactory getInstance() {
			return new TdlBoundedRepetitionRecognizerTemplateFactory();
		}

		protected TdlBoundedRepetitionRecognizerTemplateFactory() { }

		protected ParameterDeclaration newBoundTypeParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("boundType"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("BoundType"))
									))
					);
		}
		protected ParameterDeclaration newBoundValueParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("boundValue"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("BoundValue"))
									))
					);
		}
		protected ParameterDeclaration newTreeIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("treeIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}
		protected ParameterDeclaration newOperandIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("operandIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
					);
		}

		protected VariableDeclaration newLessThanBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("lessThanBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_LT")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newLessThanOrEqBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("lessThanOrEqBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_LTE")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newGreaterThanBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("greaterThanBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_GT")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newGreaterThanOrEqBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("greaterThanOrEqBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_GTE")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newEqualityBoundDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("equalityBound"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.CONSTANT)
											.setTypeId(
													BaseTypeIdentifiers.BOOLEAN
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													new GroupedExpression().setChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("boundType")
																	)
																	.setRightChild(
																			IdentifierExpression.of("BOUND_EQ")
																	)
													)
											)
							)


					;
		}
		protected VariableDeclaration newRepetitionsDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("repetitions"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.NONE)
											.setTypeId(
													BaseTypeIdentifiers.INTEGER
											))
							)
							.setInitializer(
									new FlatVariableInitializer()
											.setExpression(
													NaturalNumberLiteral.of("0")
											)
							)


					;
		}

		protected Location newId35Location() {
			return new Location()
					.setId("id35")
					.setName(
							new LocationName()
									.setName("End")
									.setCoordinates(GuiCoordinates.of(222, -70))
					)
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(232, -40));
		}
		protected Location newId33Location() {
			return new Location()
					.setId("id33")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-752, 88));
		}
		protected Location newId36Location() {
			return new Location()
					.setId("id36")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-400, -40));
		}
		protected Location newId34Location() {
			return new Location()
					.setId("id34")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-16, -40));
		}
		protected Location newId38Location() {
			return new Location()
					.setId("id38")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-944, -40));
		}
		protected Location newId39Location() {
			return new Location()
					.setId("id39")
					.setName(
							new LocationName()
									.setName("Idle")
									.setCoordinates(GuiCoordinates.of(-1202, -70))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-1192, -40));
		}
		protected Location newId37Location() {
			return new Location()
					.setId("id37")
					.setName(
							new LocationName()
									.setName("Ready")
									.setCoordinates(GuiCoordinates.of(-696, -72))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-680, -40));
		}

		protected Transition newId36ToId33Transition_1(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("lessThanBound")
													)
													.setRightChild(
															new GreaterThanOrEqualExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-744, 0)))
					)
					.addNail(GuiCoordinates.of(-400, 24))
					.addNail(GuiCoordinates.of(-752, 24));
		}
		protected Transition newId36ToId34Transition_2(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("lessThanOrEqBound")
													)
													.setRightChild(
															new LessThanOrEqualExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-368, 32)))
					)
					.addNail(GuiCoordinates.of(-400, 56))
					.addNail(GuiCoordinates.of(-16, 56));
		}
		protected Transition newId38ToId37Transition_3(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("operandIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-928, -40)))
					)
					;
		}
		protected Transition newId36ToId33Transition_4(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("lessThanOrEqBound")
													)
													.setRightChild(
															new GreaterThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-744, 32)))
					)
					.addNail(GuiCoordinates.of(-400, 56))
					.addNail(GuiCoordinates.of(-752, 56));
		}
		protected Transition newId36ToId34Transition_5(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("greaterThanBound")
													)
													.setRightChild(
															new GreaterThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-368, -128)))
					)
					.addNail(GuiCoordinates.of(-400, -104))
					.addNail(GuiCoordinates.of(-16, -104));
		}
		protected Transition newId36ToId38Transition_6(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("greaterThanOrEqBound")
													)
													.setRightChild(
															new LessThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-816, -160)))
					)
					.addNail(GuiCoordinates.of(-400, -136))
					.addNail(GuiCoordinates.of(-944, -136));
		}
		protected Transition newId37ToId36Transition_7(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new PostfixIncrementExpression()
																	.setChild(
																			IdentifierExpression.of("repetitions")
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-584, -64)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("operandIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-664, -40)))
					)
					;
		}
		protected Transition newId36ToId38Transition_8(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("equalityBound")
													)
													.setRightChild(
															new LessThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-816, -96)))
					)
					.addNail(GuiCoordinates.of(-400, -72))
					.addNail(GuiCoordinates.of(-944, -72));
		}
		protected Transition newId36ToId34Transition_9(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("greaterThanOrEqBound")
													)
													.setRightChild(
															new GreaterThanOrEqualExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-368, -160)))
					)
					.addNail(GuiCoordinates.of(-400, -136))
					.addNail(GuiCoordinates.of(-16, -136));
		}
		protected Transition newId36ToId34Transition_10(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("lessThanBound")
													)
													.setRightChild(
															new LessThanExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-368, 0)))
					)
					.addNail(GuiCoordinates.of(-400, 24))
					.addNail(GuiCoordinates.of(-16, 24));
		}
		protected Transition newId39ToId38Transition_11(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-1176, -64)))
					)
					;
		}
		protected Transition newId35ToId33Transition_12(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
					)
					.addNail(GuiCoordinates.of(232, 88));
		}
		protected Transition newId36ToId38Transition_13(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("greaterThanBound")
													)
													.setRightChild(
															new LessThanOrEqualExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-816, -128)))
					)
					.addNail(GuiCoordinates.of(-400, -104))
					.addNail(GuiCoordinates.of(-944, -104));
		}
		protected Transition newId33ToId39Transition_14(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			NaturalNumberLiteral.of("0")
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-1056, 64)))
					)
					.addNail(GuiCoordinates.of(-1192, 88));
		}
		protected Transition newId36ToId34Transition_15(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new ConjunctionExpression()
													.setLeftChild(
															IdentifierExpression.of("equalityBound")
													)
													.setRightChild(
															new EqualityExpression()
																	.setLeftChild(
																			IdentifierExpression.of("repetitions")
																	)
																	.setRightChild(
																			IdentifierExpression.of("boundValue")
																	)
													)
									)
											.setCoordinates(GuiCoordinates.of(-368, -96)))
					)
					.addNail(GuiCoordinates.of(-400, -72))
					.addNail(GuiCoordinates.of(-16, -72));
		}
		protected Transition newId34ToId35Transition_16(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			new ArrayLookupExpression()
																					.setLeftChild(
																							IdentifierExpression.of("TdlDiagnostics")
																					)
																					.setRightChild(
																							IdentifierExpression.of("treeIndex")
																					)
																	)
																	.setRightChild(
																			LiteralConsts.TRUE
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(0, -40)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("treeIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(0, -64)))
					)
					;
		}

		public Template newTdlBoundedRepetitionRecognizerTemplate() {
			Template TdlBoundedRepetitionRecognizer = new Template();

			// Template name:
			Identifier identifier = Identifier.of("TdlBoundedRepetitionRecognizer");
			TdlBoundedRepetitionRecognizer.setName(identifier);

			// Set parameter declarations:
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getParameters(),
					newBoundTypeParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getParameters(),
					newBoundValueParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getParameters(),
					newTreeIndexParameterDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getParameters(),
					newOperandIndexParameterDeclaration()
			);

			// Set local declarations:
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getDeclarations(),
					newLessThanBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getDeclarations(),
					newLessThanOrEqBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getDeclarations(),
					newGreaterThanBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getDeclarations(),
					newGreaterThanOrEqBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getDeclarations(),
					newEqualityBoundDeclaration()
			);
			CollectionUtils.addIfNonNull(
					TdlBoundedRepetitionRecognizer.getDeclarations(),
					newRepetitionsDeclaration()
			);

			// Set locations:
			Location locationId35 = newId35Location();
			TdlBoundedRepetitionRecognizer.getLocationGraph()
					.addVertex(locationId35);

			Location locationId33 = newId33Location();
			TdlBoundedRepetitionRecognizer.getLocationGraph()
					.addVertex(locationId33);

			Location locationId36 = newId36Location();
			TdlBoundedRepetitionRecognizer.getLocationGraph()
					.addVertex(locationId36);

			Location locationId34 = newId34Location();
			TdlBoundedRepetitionRecognizer.getLocationGraph()
					.addVertex(locationId34);

			Location locationId38 = newId38Location();
			TdlBoundedRepetitionRecognizer.getLocationGraph()
					.addVertex(locationId38);

			Location locationId39 = newId39Location();
			TdlBoundedRepetitionRecognizer.getLocationGraph()
					.addVertex(locationId39);
			TdlBoundedRepetitionRecognizer.setInitialLocation(locationId39);
			Location locationId37 = newId37Location();
			TdlBoundedRepetitionRecognizer.getLocationGraph()
					.addVertex(locationId37);


			// Set transitions:
			Transition transitionId36ToId33_1 = newId36ToId33Transition_1(
					locationId36,
					locationId33
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId33,
					transitionId36ToId33_1
			);
			Transition transitionId36ToId34_2 = newId36ToId34Transition_2(
					locationId36,
					locationId34
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId34,
					transitionId36ToId34_2
			);
			Transition transitionId38ToId37_3 = newId38ToId37Transition_3(
					locationId38,
					locationId37
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId38,
					locationId37,
					transitionId38ToId37_3
			);
			Transition transitionId36ToId33_4 = newId36ToId33Transition_4(
					locationId36,
					locationId33
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId33,
					transitionId36ToId33_4
			);
			Transition transitionId36ToId34_5 = newId36ToId34Transition_5(
					locationId36,
					locationId34
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId34,
					transitionId36ToId34_5
			);
			Transition transitionId36ToId38_6 = newId36ToId38Transition_6(
					locationId36,
					locationId38
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId38,
					transitionId36ToId38_6
			);
			Transition transitionId37ToId36_7 = newId37ToId36Transition_7(
					locationId37,
					locationId36
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId37,
					locationId36,
					transitionId37ToId36_7
			);
			Transition transitionId36ToId38_8 = newId36ToId38Transition_8(
					locationId36,
					locationId38
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId38,
					transitionId36ToId38_8
			);
			Transition transitionId36ToId34_9 = newId36ToId34Transition_9(
					locationId36,
					locationId34
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId34,
					transitionId36ToId34_9
			);
			Transition transitionId36ToId34_10 = newId36ToId34Transition_10(
					locationId36,
					locationId34
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId34,
					transitionId36ToId34_10
			);
			Transition transitionId39ToId38_11 = newId39ToId38Transition_11(
					locationId39,
					locationId38
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId39,
					locationId38,
					transitionId39ToId38_11
			);
			Transition transitionId35ToId33_12 = newId35ToId33Transition_12(
					locationId35,
					locationId33
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId35,
					locationId33,
					transitionId35ToId33_12
			);
			Transition transitionId36ToId38_13 = newId36ToId38Transition_13(
					locationId36,
					locationId38
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId38,
					transitionId36ToId38_13
			);
			Transition transitionId33ToId39_14 = newId33ToId39Transition_14(
					locationId33,
					locationId39
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId33,
					locationId39,
					transitionId33ToId39_14
			);
			Transition transitionId36ToId34_15 = newId36ToId34Transition_15(
					locationId36,
					locationId34
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId36,
					locationId34,
					transitionId36ToId34_15
			);
			Transition transitionId34ToId35_16 = newId34ToId35Transition_16(
					locationId34,
					locationId35
			);
			TdlBoundedRepetitionRecognizer.getLocationGraph().addEdge(
					locationId34,
					locationId35,
					transitionId34ToId35_16
			);

			return TdlBoundedRepetitionRecognizer;
		}
	}

	public static class TdlStopwatchTemplateFactory {
		public static TdlStopwatchTemplateFactory getInstance() {
			return new TdlStopwatchTemplateFactory();
		}

		protected TdlStopwatchTemplateFactory() { }

		protected ParameterDeclaration newRootIndexParameterDeclaration() {
			return new ParameterDeclaration()
					.setIdentifier(Identifier.of("rootIndex"))
					.setType(new Type()
							.setBaseType(new BaseType()
									.setPrefix(ETypePrefix.CONSTANT)
									.setTypeId(
											CustomTypeId.of(Identifier.of("TdlTreeIndex"))
									))
							.setReferenceType(true)
					);
		}

		protected VariableDeclaration newTimeoutClockDeclaration() {
			return
					new VariableDeclaration()
							.setIdentifier(Identifier.of("timeoutClock"))
							.setType(new Type()
									.setBaseType(new BaseType()
											.setPrefix(ETypePrefix.NONE)
											.setTypeId(
													BaseTypeIdentifiers.CLOCK
											))
							)


					;
		}

		protected Location newId42Location() {
			return new Location()
					.setId("id42")
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
									.setInvariantLabel((InvariantLabel) new InvariantLabel().setContent(
											new LessThanOrEqualExpression()
													.setLeftChild(
															IdentifierExpression.of("timeoutClock")
													)
													.setRightChild(
															IdentifierExpression.of("TDL_TIMEOUT")
													)
									)
											.setCoordinates(GuiCoordinates.of(-264, -64)))
					)
					.setCoordinates(GuiCoordinates.of(-280, -56));
		}
		protected Location newId40Location() {
			return new Location()
					.setId("id40")
					.setName(
							new LocationName()
									.setName("Fail")
									.setCoordinates(GuiCoordinates.of(-136, 48))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-152, 56));
		}
		protected Location newId41Location() {
			return new Location()
					.setId("id41")
					.setName(
							new LocationName()
									.setName("Pass")
									.setCoordinates(GuiCoordinates.of(-136, -168))
					)
					.setExitPolicy(ELocationExitPolicy.NORMAL)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-152, -160));
		}
		protected Location newId43Location() {
			return new Location()
					.setId("id43")
					.setExitPolicy(ELocationExitPolicy.COMMITTED)
					.setLabels(
							new LocationLabels()
					)
					.setCoordinates(GuiCoordinates.of(-528, -56));
		}

		protected Transition newId42ToId41Transition_1(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(false)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlTerminatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rootIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-192, -120)))
					)
					;
		}
		protected Transition newId42ToId40Transition_2(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setGuardLabel((GuardLabel) new GuardLabel().setContent(
											new EqualityExpression()
													.setLeftChild(
															IdentifierExpression.of("timeoutClock")
													)
													.setRightChild(
															IdentifierExpression.of("TDL_TIMEOUT")
													)
									)
											.setCoordinates(GuiCoordinates.of(-200, -8)))
					)
					;
		}
		protected Transition newId43ToId42Transition_3(Location source, Location target) {
			return new Transition()
					.setSource(source)
					.setTarget(target)
					.setLabels(
							new TransitionLabels()
									.setAssignmentsLabel((AssignmentsLabel) new AssignmentsLabel().setContent(
											CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
													.add(
															new AssignmentExpression()
																	.setLeftChild(
																			IdentifierExpression.of("timeoutClock")
																	)
																	.setRightChild(
																			NaturalNumberLiteral.of("0")
																	)
													)
													.add(
															new CallExpression()
																	.setChild(
																			IdentifierExpression.of("initTrapsets")
																	)
													)
													.build()
									)
											.setCoordinates(GuiCoordinates.of(-464, -56)))
									.setSynchronizationLabel((SynchronizationLabel) new SynchronizationLabel().setContent(new Synchronization()
											.setActiveSync(true)
											.setExpression(
													new ArrayLookupExpression()
															.setLeftChild(
																	IdentifierExpression.of("TdlActivatorChannels")
															)
															.setRightChild(
																	IdentifierExpression.of("rootIndex")
															)
											))
											.setCoordinates(GuiCoordinates.of(-504, -80)))
					)
					;
		}

		public Template newTdlStopwatchTemplate() {
			Template TdlStopwatch = new Template();

			// Template name:
			Identifier identifier = Identifier.of("TdlStopwatch");
			TdlStopwatch.setName(identifier);

			// Set parameter declarations:
			CollectionUtils.addIfNonNull(
					TdlStopwatch.getParameters(),
					newRootIndexParameterDeclaration()
			);

			// Set local declarations:
			CollectionUtils.addIfNonNull(
					TdlStopwatch.getDeclarations(),
					newTimeoutClockDeclaration()
			);

			// Set locations:
			Location locationId42 = newId42Location();
			TdlStopwatch.getLocationGraph()
					.addVertex(locationId42);

			Location locationId40 = newId40Location();
			TdlStopwatch.getLocationGraph()
					.addVertex(locationId40);

			Location locationId41 = newId41Location();
			TdlStopwatch.getLocationGraph()
					.addVertex(locationId41);

			Location locationId43 = newId43Location();
			TdlStopwatch.getLocationGraph()
					.addVertex(locationId43);
			TdlStopwatch.setInitialLocation(locationId43);

			// Set transitions:
			Transition transitionId42ToId41_1 = newId42ToId41Transition_1(
					locationId42,
					locationId41
			);
			TdlStopwatch.getLocationGraph().addEdge(
					locationId42,
					locationId41,
					transitionId42ToId41_1
			);
			Transition transitionId42ToId40_2 = newId42ToId40Transition_2(
					locationId42,
					locationId40
			);
			TdlStopwatch.getLocationGraph().addEdge(
					locationId42,
					locationId40,
					transitionId42ToId40_2
			);
			Transition transitionId43ToId42_3 = newId43ToId42Transition_3(
					locationId43,
					locationId42
			);
			TdlStopwatch.getLocationGraph().addEdge(
					locationId43,
					locationId42,
					transitionId43ToId42_3
			);

			return TdlStopwatch;
		}
	}
	public static class PickleNameSystemDefinitionFactory {
		public static PickleNameSystemDefinitionFactory getInstance() {
			return new PickleNameSystemDefinitionFactory();
		}

		protected PickleNameSystemDefinitionFactory() { }

		protected TemplateInstantiation newSWDeclaration() {
			return
					new TemplateInstantiation()
							.setNewTemplateName(Identifier.of("SW"))
							.setSourceTemplateName(Identifier.of("TdlStopwatch"))
							.addArgument(
									NaturalNumberLiteral.of("1")

							)
					;
		}

		protected static final Identifier ProcessReferenceSW = Identifier.of("SW");


		protected SystemLine newSystemLine() {
			return new SystemLine()
					.addGroup(
							new ProcessReferenceGroup()
									.addIdentifier(Identifier.of("SW"))
					);
		}

		public SystemDefinition newSystemDefinition() {
			SystemDefinition systemDefinition = new SystemDefinition();

			// Set local declarations:
			CollectionUtils.addIfNonNull(
					systemDefinition.getDeclarations(),
					newSWDeclaration()
			);
			// Set system line:
			systemDefinition.setSystemLine(newSystemLine());
			// Set progress measures:

			return systemDefinition;
		}
	}
	public static PickleNameSystemFactory getInstance() {
		return new PickleNameSystemFactory();
	}

	protected PickleNameSystemFactory() { }

	protected VariableDeclaration newMAX_INTDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("MAX_INT"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												BaseTypeIdentifiers.INTEGER
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("32767")
										)
						)


				;
	}
	protected VariableDeclaration newTDL_TIMEOUTDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("TDL_TIMEOUT"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												BaseTypeIdentifiers.INTEGER
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("10000")
										)
						)


				;
	}
	protected VariableDeclaration newTDL_TREE_NODE_COUNTDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("TDL_TREE_NODE_COUNT"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												BaseTypeIdentifiers.INTEGER
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("0")
										)
						)


				;
	}
	protected VariableDeclaration newTRAPSET_COUNTDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("TRAPSET_COUNT"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												BaseTypeIdentifiers.INTEGER
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("0")
										)
						)


				;
	}
	protected VariableDeclaration newMAX_TRAPSET_SIZEDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("MAX_TRAPSET_SIZE"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												BaseTypeIdentifiers.INTEGER
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("1")
										)
						)


				;
	}
	protected TypeDeclaration newBoundTypeDeclaration() {
		return
				new TypeDeclaration()
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												BoundedIntegerTypeId.of(
														NaturalNumberLiteral.of("1")
														,
														NaturalNumberLiteral.of("5")

												)
										))
						)
						.setIdentifier(Identifier.of("BoundType"))

				;
	}
	protected TypeDeclaration newTrapsetIndexDeclaration() {
		return
				new TypeDeclaration()
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												BoundedIntegerTypeId.of(
														NaturalNumberLiteral.of("0")
														,
														IdentifierExpression.of("TRAPSET_COUNT")

												)
										))
						)
						.setIdentifier(Identifier.of("TrapsetIndex"))

				;
	}
	protected TypeDeclaration newTrapsetFlagsDeclaration() {
		return
				new TypeDeclaration()
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												BoundedIntegerTypeId.of(
														NaturalNumberLiteral.of("0")
														,
														new SubtractionExpression()
																.setLeftChild(
																		new GroupedExpression().setChild(
																				new LeftShiftExpression()
																						.setLeftChild(
																								NaturalNumberLiteral.of("1")
																						)
																						.setRightChild(
																								IdentifierExpression.of("MAX_TRAPSET_SIZE")
																						)
																		)
																)
																.setRightChild(
																		NaturalNumberLiteral.of("1")
																)

												)
										))
						)
						.setIdentifier(Identifier.of("TrapsetFlags"))

				;
	}
	protected TypeDeclaration newTrapsetMaskDeclaration() {
		return
				new TypeDeclaration()
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												BoundedIntegerTypeId.of(
														NaturalNumberLiteral.of("0")
														,
														new SubtractionExpression()
																.setLeftChild(
																		new GroupedExpression().setChild(
																				new LeftShiftExpression()
																						.setLeftChild(
																								NaturalNumberLiteral.of("1")
																						)
																						.setRightChild(
																								IdentifierExpression.of("MAX_TRAPSET_SIZE")
																						)
																		)
																)
																.setRightChild(
																		NaturalNumberLiteral.of("1")
																)

												)
										))
						)
						.setIdentifier(Identifier.of("TrapsetMask"))

				;
	}
	protected TypeDeclaration newBoundValueDeclaration() {
		return
				new TypeDeclaration()
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												BoundedIntegerTypeId.of(
														NaturalNumberLiteral.of("0")
														,
														IdentifierExpression.of("MAX_INT")

												)
										))
						)
						.setIdentifier(Identifier.of("BoundValue"))

				;
	}
	protected TypeDeclaration newTdlTreeIndexDeclaration() {
		return
				new TypeDeclaration()
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												BoundedIntegerTypeId.of(
														NaturalNumberLiteral.of("0")
														,
														new SubtractionExpression()
																.setLeftChild(
																		IdentifierExpression.of("TDL_TREE_NODE_COUNT")
																)
																.setRightChild(
																		NaturalNumberLiteral.of("1")
																)

												)
										))
						)
						.setIdentifier(Identifier.of("TdlTreeIndex"))

				;
	}
	protected TypeDeclaration newTrapsetDeclaration() {
		return
				new TypeDeclaration()
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												new StructTypeId()
														.addFieldDeclaration(
																new FieldDeclaration()
																		.setType(new Type()
																				.setBaseType(new BaseType()
																						.setPrefix(ETypePrefix.NONE)
																						.setTypeId(
																								CustomTypeId.of(Identifier.of("TrapsetFlags"))
																						))
																		)
																		.setIdentifier(Identifier.of("flags"))
														)
														.addFieldDeclaration(
																new FieldDeclaration()
																		.setType(new Type()
																				.setBaseType(new BaseType()
																						.setPrefix(ETypePrefix.NONE)
																						.setTypeId(
																								CustomTypeId.of(Identifier.of("TrapsetMask"))
																						))
																		)
																		.setIdentifier(Identifier.of("fullMask"))
														)
														.addFieldDeclaration(
																new FieldDeclaration()
																		.setType(new Type()
																				.setBaseType(new BaseType()
																						.setPrefix(ETypePrefix.NONE)
																						.setTypeId(
																								CustomTypeId.of(Identifier.of("TrapsetIndex"))
																						))
																		)
																		.setIdentifier(Identifier.of("index"))
														)

										))
						)
						.setIdentifier(Identifier.of("Trapset"))

				;
	}
	protected TypeDeclaration newBitMaskDeclaration() {
		return
				new TypeDeclaration()
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												new StructTypeId()
														.addFieldDeclaration(
																new FieldDeclaration()
																		.setType(new Type()
																				.setBaseType(new BaseType()
																						.setPrefix(ETypePrefix.NONE)
																						.setTypeId(
																								BaseTypeIdentifiers.INTEGER
																						))
																		)
																		.setIdentifier(Identifier.of("isolated"))
														)
														.addFieldDeclaration(
																new FieldDeclaration()
																		.setType(new Type()
																				.setBaseType(new BaseType()
																						.setPrefix(ETypePrefix.NONE)
																						.setTypeId(
																								BaseTypeIdentifiers.INTEGER
																						))
																		)
																		.setIdentifier(Identifier.of("unset"))
														)

										))
						)
						.setIdentifier(Identifier.of("BitMask"))

				;
	}
	protected VariableDeclaration newBIT_MASKSDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("BIT_MASKS"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												CustomTypeId.of(Identifier.of("BitMask"))
										))
								.addArrayModifier(
										new SizeExpressionArrayModifier()
												.setSizeSpecifier(
														IdentifierExpression.of("MAX_TRAPSET_SIZE")
												)
								)
						)
						.setInitializer(
								new StructuredVariableInitializer()
										.addInitializer(
												new StructuredVariableInitializer()
														.addInitializer(
																new FlatVariableInitializer()
																		.setExpression(
																				new LeftShiftExpression()
																						.setLeftChild(
																								NaturalNumberLiteral.of("1")
																						)
																						.setRightChild(
																								NaturalNumberLiteral.of("0")
																						)
																		)
														)
														.addInitializer(
																new FlatVariableInitializer()
																		.setExpression(
																				new SubtractionExpression()
																						.setLeftChild(
																								IdentifierExpression.of("MAX_INT")
																						)
																						.setRightChild(
																								new GroupedExpression().setChild(
																										new LeftShiftExpression()
																												.setLeftChild(
																														NaturalNumberLiteral.of("1")
																												)
																												.setRightChild(
																														NaturalNumberLiteral.of("0")
																												)
																								)
																						)
																		)
														)

										)

						)


				;
	}
	protected VariableDeclaration newBOUND_EQDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("BOUND_EQ"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												CustomTypeId.of(Identifier.of("BoundType"))
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("1")
										)
						)


				;
	}
	protected VariableDeclaration newBOUND_GTDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("BOUND_GT"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												CustomTypeId.of(Identifier.of("BoundType"))
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("2")
										)
						)


				;
	}
	protected VariableDeclaration newBOUND_GTEDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("BOUND_GTE"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												CustomTypeId.of(Identifier.of("BoundType"))
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("3")
										)
						)


				;
	}
	protected VariableDeclaration newBOUND_LTDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("BOUND_LT"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												CustomTypeId.of(Identifier.of("BoundType"))
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("4")
										)
						)


				;
	}
	protected VariableDeclaration newBOUND_LTEDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("BOUND_LTE"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.CONSTANT)
										.setTypeId(
												CustomTypeId.of(Identifier.of("BoundType"))
										))
						)
						.setInitializer(
								new FlatVariableInitializer()
										.setExpression(
												NaturalNumberLiteral.of("5")
										)
						)


				;
	}
	protected FunctionDeclaration newInitTrapsetDeclaration() {
		return
				new FunctionDeclaration()
						.setName(Identifier.of("initTrapset"))
						.addParameter(
								new ParameterDeclaration()
										.setIdentifier(Identifier.of("trapset"))
										.setType(new Type()
												.setBaseType(new BaseType()
														.setPrefix(ETypePrefix.NONE)
														.setTypeId(
																CustomTypeId.of(Identifier.of("Trapset"))
														))
												.setReferenceType(true)
										)
						)
						.addParameter(
								new ParameterDeclaration()
										.setIdentifier(Identifier.of("index"))
										.setType(new Type()
												.setBaseType(new BaseType()
														.setPrefix(ETypePrefix.NONE)
														.setTypeId(
																CustomTypeId.of(Identifier.of("TrapsetIndex"))
														))
										)
						)
						.addParameter(
								new ParameterDeclaration()
										.setIdentifier(Identifier.of("size"))
										.setType(new Type()
												.setBaseType(new BaseType()
														.setPrefix(ETypePrefix.NONE)
														.setTypeId(
																BaseTypeIdentifiers.INTEGER
														))
										)
						)

						.setStatementBlock(new StatementBlock()
								.addStatement(
										new ExpressionStatement().setExpression(
												new AssignmentExpression()
														.setLeftChild(
																new FieldAccessExpression()
																		.setIdentifier(Identifier.of("flags"))
																		.setChild(
																				IdentifierExpression.of("trapset")
																		)
														)
														.setRightChild(
																NaturalNumberLiteral.of("0")
														)
										)
								)
								.addStatement(
										new ExpressionStatement().setExpression(
												new AssignmentExpression()
														.setLeftChild(
																new FieldAccessExpression()
																		.setIdentifier(Identifier.of("index"))
																		.setChild(
																				IdentifierExpression.of("trapset")
																		)
														)
														.setRightChild(
																IdentifierExpression.of("index")
														)
										)
								)
								.addStatement(
										new ExpressionStatement().setExpression(
												new AssignmentExpression()
														.setLeftChild(
																new FieldAccessExpression()
																		.setIdentifier(Identifier.of("fullMask"))
																		.setChild(
																				IdentifierExpression.of("trapset")
																		)
														)
														.setRightChild(
																new SubtractionExpression()
																		.setLeftChild(
																				new GroupedExpression().setChild(
																						new LeftShiftExpression()
																								.setLeftChild(
																										NaturalNumberLiteral.of("1")
																								)
																								.setRightChild(
																										IdentifierExpression.of("size")
																								)
																				)
																		)
																		.setRightChild(
																				NaturalNumberLiteral.of("1")
																		)
														)
										)
								)

						)
				;
	}
	protected FunctionDeclaration newSetTrapVisitedDeclaration() {
		return
				new FunctionDeclaration()
						.setName(Identifier.of("setTrapVisited"))
						.addParameter(
								new ParameterDeclaration()
										.setIdentifier(Identifier.of("trapset"))
										.setType(new Type()
												.setBaseType(new BaseType()
														.setPrefix(ETypePrefix.NONE)
														.setTypeId(
																CustomTypeId.of(Identifier.of("Trapset"))
														))
												.setReferenceType(true)
										)
						)
						.addParameter(
								new ParameterDeclaration()
										.setIdentifier(Identifier.of("trapIndex"))
										.setType(new Type()
												.setBaseType(new BaseType()
														.setPrefix(ETypePrefix.NONE)
														.setTypeId(
																BaseTypeIdentifiers.INTEGER
														))
										)
						)
						.addParameter(
								new ParameterDeclaration()
										.setIdentifier(Identifier.of("visited"))
										.setType(new Type()
												.setBaseType(new BaseType()
														.setPrefix(ETypePrefix.NONE)
														.setTypeId(
																BaseTypeIdentifiers.BOOLEAN
														))
										)
						)

						.setStatementBlock(new StatementBlock()
								.addDeclaration(
										new VariableDeclaration()
												.setIdentifier(Identifier.of("mask"))
												.setType(new Type()
														.setBaseType(new BaseType()
																.setPrefix(ETypePrefix.NONE)
																.setTypeId(
																		CustomTypeId.of(Identifier.of("BitMask"))
																))
												)
												.setInitializer(
														new FlatVariableInitializer()
																.setExpression(
																		new ArrayLookupExpression()
																				.setLeftChild(
																						IdentifierExpression.of("BIT_MASKS")
																				)
																				.setRightChild(
																						IdentifierExpression.of("trapIndex")
																				)
																)
												)


								)

								.addStatement(
										new ExpressionStatement().setExpression(
												new AssignmentExpression()
														.setLeftChild(
																new FieldAccessExpression()
																		.setIdentifier(Identifier.of("flags"))
																		.setChild(
																				IdentifierExpression.of("trapset")
																		)
														)
														.setRightChild(
																new BitwiseOrExpression()
																		.setLeftChild(
																				new GroupedExpression().setChild(
																						new BitwiseAndExpression()
																								.setLeftChild(
																										new FieldAccessExpression()
																												.setIdentifier(Identifier.of("flags"))
																												.setChild(
																														IdentifierExpression.of("trapset")
																												)
																								)
																								.setRightChild(
																										new FieldAccessExpression()
																												.setIdentifier(Identifier.of("unset"))
																												.setChild(
																														IdentifierExpression.of("mask")
																												)
																								)
																				)
																		)
																		.setRightChild(
																				new GroupedExpression().setChild(
																						new TernaryExpression()
																								.setLeftChild(
																										IdentifierExpression.of("visited")
																								)
																								.setMiddleChild(
																										IdentifierExpression.of("visited")
																								)
																								.setRightChild(
																										NaturalNumberLiteral.of("0")
																								)
																				)
																		)
														)
										)
								)

						)
				;
	}
	protected FunctionDeclaration newResetTrapsetDeclaration() {
		return
				new FunctionDeclaration()
						.setName(Identifier.of("resetTrapset"))
						.addParameter(
								new ParameterDeclaration()
										.setIdentifier(Identifier.of("trapset"))
										.setType(new Type()
												.setBaseType(new BaseType()
														.setPrefix(ETypePrefix.NONE)
														.setTypeId(
																CustomTypeId.of(Identifier.of("Trapset"))
														))
												.setReferenceType(true)
										)
						)

						.setStatementBlock(new StatementBlock()
								.addStatement(
										new ExpressionStatement().setExpression(
												new AssignmentExpression()
														.setLeftChild(
																new FieldAccessExpression()
																		.setIdentifier(Identifier.of("flags"))
																		.setChild(
																				IdentifierExpression.of("trapset")
																		)
														)
														.setRightChild(
																NaturalNumberLiteral.of("0")
														)
										)
								)

						)
				;
	}
	protected VariableDeclaration newTdlDiagnosticsDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("TdlDiagnostics"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.NONE)
										.setTypeId(
												BaseTypeIdentifiers.BOOLEAN
										))
								.addArrayModifier(
										new SizeExpressionArrayModifier()
												.setSizeSpecifier(
														IdentifierExpression.of("TdlTreeIndex")
												)
								)
						)


				;
	}
	protected VariableDeclaration newTdlActivatorChannelsDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("TdlActivatorChannels"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.BROADCAST)
										.setTypeId(
												BaseTypeIdentifiers.CHANNEL
										))
								.addArrayModifier(
										new SizeExpressionArrayModifier()
												.setSizeSpecifier(
														IdentifierExpression.of("TdlTreeIndex")
												)
								)
						)


				;
	}
	protected VariableDeclaration newTdlTerminatorChannelsDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("TdlTerminatorChannels"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.BROADCAST)
										.setTypeId(
												BaseTypeIdentifiers.CHANNEL
										))
								.addArrayModifier(
										new SizeExpressionArrayModifier()
												.setSizeSpecifier(
														IdentifierExpression.of("TdlTreeIndex")
												)
								)
						)


				;
	}
	protected VariableDeclaration newTrapsetActivatorChannelsDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("TrapsetActivatorChannels"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.BROADCAST)
										.setTypeId(
												BaseTypeIdentifiers.CHANNEL
										))
								.addArrayModifier(
										new SizeExpressionArrayModifier()
												.setSizeSpecifier(
														IdentifierExpression.of("TrapsetIndex")
												)
								)
						)


				;
	}
	protected VariableDeclaration newTrapsetTerminatorChannelsDeclaration() {
		return
				new VariableDeclaration()
						.setIdentifier(Identifier.of("TrapsetTerminatorChannels"))
						.setType(new Type()
								.setBaseType(new BaseType()
										.setPrefix(ETypePrefix.BROADCAST)
										.setTypeId(
												BaseTypeIdentifiers.CHANNEL
										))
								.addArrayModifier(
										new SizeExpressionArrayModifier()
												.setSizeSpecifier(
														IdentifierExpression.of("TrapsetIndex")
												)
								)
						)


				;
	}
	protected FunctionDeclaration newInitTrapsetsDeclaration() {
		return
				new FunctionDeclaration()
						.setName(Identifier.of("initTrapsets"))
						.setStatementBlock(new StatementBlock()
						)
				;
	}

	protected Template newTdlConjunctionRecognizerTemplate() {
		return TdlConjunctionRecognizerTemplateFactory.getInstance()
				.newTdlConjunctionRecognizerTemplate();
	}
	protected Template newTdlDisjunctionRecognizerTemplate() {
		return TdlDisjunctionRecognizerTemplateFactory.getInstance()
				.newTdlDisjunctionRecognizerTemplate();
	}
	protected Template newTdlQuantificationRecognizerTemplate() {
		return TdlQuantificationRecognizerTemplateFactory.getInstance()
				.newTdlQuantificationRecognizerTemplate();
	}
	protected Template newTdlLeadsToRecognizerTemplate() {
		return TdlLeadsToRecognizerTemplateFactory.getInstance()
				.newTdlLeadsToRecognizerTemplate();
	}
	protected Template newTdlBoundedLeadsToRecognizerTemplate() {
		return TdlBoundedLeadsToRecognizerTemplateFactory.getInstance()
				.newTdlBoundedLeadsToRecognizerTemplate();
	}
	protected Template newTdlBoundedRepetitionRecognizerTemplate() {
		return TdlBoundedRepetitionRecognizerTemplateFactory.getInstance()
				.newTdlBoundedRepetitionRecognizerTemplate();
	}
	protected Template newTdlStopwatchTemplate() {
		return TdlStopwatchTemplateFactory.getInstance()
				.newTdlStopwatchTemplate();
	}

	protected SystemDefinition newSystemDefinition() {
		return PickleNameSystemDefinitionFactory.getInstance()
				.newSystemDefinition();
	}

	public UtaSystem newPickleNameSystem() {
		UtaSystem pickleName = new UtaSystem();

		// Set global declarations:
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newMAX_INTDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTDL_TIMEOUTDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTDL_TREE_NODE_COUNTDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTRAPSET_COUNTDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newMAX_TRAPSET_SIZEDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBoundTypeDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTrapsetIndexDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTrapsetFlagsDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTrapsetMaskDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBoundValueDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTdlTreeIndexDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTrapsetDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBitMaskDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBIT_MASKSDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBOUND_EQDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBOUND_GTDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBOUND_GTEDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBOUND_LTDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newBOUND_LTEDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newInitTrapsetDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newSetTrapVisitedDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newResetTrapsetDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTdlDiagnosticsDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTdlActivatorChannelsDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTdlTerminatorChannelsDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTrapsetActivatorChannelsDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newTrapsetTerminatorChannelsDeclaration()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getDeclarations(),
				newInitTrapsetsDeclaration()
		);

		// Set templates:
		CollectionUtils.addIfNonNull(
				pickleName.getTemplates(),
				newTdlConjunctionRecognizerTemplate()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getTemplates(),
				newTdlDisjunctionRecognizerTemplate()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getTemplates(),
				newTdlQuantificationRecognizerTemplate()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getTemplates(),
				newTdlLeadsToRecognizerTemplate()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getTemplates(),
				newTdlBoundedLeadsToRecognizerTemplate()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getTemplates(),
				newTdlBoundedRepetitionRecognizerTemplate()
		);
		CollectionUtils.addIfNonNull(
				pickleName.getTemplates(),
				newTdlStopwatchTemplate()
		);
		// Set system definition:
		SystemDefinition systemDefinition = newSystemDefinition();
		if (systemDefinition != null) {
			pickleName.setSystemDefinition(systemDefinition);
		}
		return pickleName;
	}
}
