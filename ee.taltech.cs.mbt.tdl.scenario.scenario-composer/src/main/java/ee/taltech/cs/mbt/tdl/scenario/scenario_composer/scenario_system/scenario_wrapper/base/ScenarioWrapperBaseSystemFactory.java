package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.scenario_wrapper.base;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.CallExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.EqualityExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.GreaterThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.GreaterThanOrEqualExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.GroupedExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.InequalityExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.LessThanExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.LessThanOrEqualExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.PostfixIncrementExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.QuantificationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.QuantificationExpression.EQuantificationType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.SubtractionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.ExpressionStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop.IterationLoop;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.system_line.SystemLine;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.ETypePrefix;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.InvariantLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.SynchronizationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location.LocationName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.LocationLabels;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.TransitionLabels;

import java.util.LinkedList;

/** Generated on 11/May/2019 using the UTA pickler plugin. */
public class ScenarioWrapperBaseSystemFactory {
  public static class TdlScenarioStopwatchTemplateFactory {
    public static TdlScenarioStopwatchTemplateFactory getInstance() {
      return new TdlScenarioStopwatchTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlScenarioStopwatch");

    public static final Identifier DECLARED_NAME_timeoutClock = Identifier.of("timeoutClock");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlScenarioStopwatchTemplateFactory() {}

    protected ParameterDeclaration new_rootIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rootIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))
                  .setReferenceType(true));
    }

    protected VariableDeclaration new_timeoutClockDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("timeoutClock"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.NONE)
                          .setTypeId(BaseTypeIdentifiers.CLOCK)));
    }

    protected Location newId2Location() {
      return new Location()
          .setId("id2")
          .setName(
              new LocationName().setName("Listening").setCoordinates(GuiCoordinates.of(-264, -64)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(
              new LocationLabels()
                  .setInvariantLabel(
                      (InvariantLabel)
                          new InvariantLabel()
                              .setCoordinates(GuiCoordinates.of(-264, -80))
                              .setContent(
                                  new LessThanExpression()
                                      .setLeftChild(IdentifierExpression.of("timeoutClock"))
                                      .setRightChild(IdentifierExpression.of("TDL_TIMEOUT")))))
          .setCoordinates(GuiCoordinates.of(-280, -56));
    }

    protected Location newId0Location() {
      return new Location()
          .setId("id0")
          .setName(new LocationName().setName("Fail").setCoordinates(GuiCoordinates.of(-32, 48)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-48, 56));
    }

    protected Location newId1Location() {
      return new Location()
          .setId("id1")
          .setName(new LocationName().setName("Pass").setCoordinates(GuiCoordinates.of(-32, -168)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-48, -160));
    }

    protected Location newId3Location() {
      return new Location()
          .setId("id3")
          .setName(
              new LocationName().setName("Starting").setCoordinates(GuiCoordinates.of(-592, -72)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-528, -56));
    }

    protected Transition newId2ToId0Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-272, 32))
                              .setContent(
                                  new GreaterThanOrEqualExpression()
                                      .setLeftChild(IdentifierExpression.of("timeoutClock"))
                                      .setRightChild(IdentifierExpression.of("TDL_TIMEOUT")))))
          .addNail(GuiCoordinates.of(-280, 56));
    }

    protected Transition newId2ToId1Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-280, -184))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rootIndex"))))))
          .addNail(GuiCoordinates.of(-280, -160));
    }

    protected Transition newId3ToId2Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-464, -56))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(IdentifierExpression.of("timeoutClock"))
                                              .setRightChild(NaturalNumberLiteral.of("0")))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-504, -80))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rootIndex"))))));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName, AbsExpression arg_rootIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_rootIndex != null) {
        inst.addArgument(arg_rootIndex);
      } else { // Either provide rootIndex argument or leave a parameter:
        inst.addParameter(new_rootIndexParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlScenarioStopwatch = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlScenarioStopwatch.getParameters(), new_rootIndexParameterDeclaration());

      // Set local declarations:
      CollectionUtils.addIfNonNull(
          TdlScenarioStopwatch.getDeclarations(), new_timeoutClockDeclaration());

      // Set locations:
      Location locationId2 = newId2Location();
      TdlScenarioStopwatch.getLocationGraph().addVertex(locationId2);

      Location locationId0 = newId0Location();
      TdlScenarioStopwatch.getLocationGraph().addVertex(locationId0);

      Location locationId1 = newId1Location();
      TdlScenarioStopwatch.getLocationGraph().addVertex(locationId1);

      Location locationId3 = newId3Location();
      TdlScenarioStopwatch.getLocationGraph().addVertex(locationId3);
      TdlScenarioStopwatch.setInitialLocation(locationId3);

      // Set transitions:
      Transition transitionId2ToId0 = newId2ToId0Transition(locationId2, locationId0);
      TdlScenarioStopwatch.getLocationGraph().addEdge(locationId2, locationId0, transitionId2ToId0);
      Transition transitionId2ToId1 = newId2ToId1Transition(locationId2, locationId1);
      TdlScenarioStopwatch.getLocationGraph().addEdge(locationId2, locationId1, transitionId2ToId1);
      Transition transitionId3ToId2 = newId3ToId2Transition(locationId3, locationId2);
      TdlScenarioStopwatch.getLocationGraph().addEdge(locationId3, locationId2, transitionId3ToId2);

      return TdlScenarioStopwatch;
    }
  }

  public static class TdlBoundedLeadsToRecognizerTemplateFactory {
    public static TdlBoundedLeadsToRecognizerTemplateFactory getInstance() {
      return new TdlBoundedLeadsToRecognizerTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlBoundedLeadsToRecognizer");

    public static final Identifier DECLARED_NAME_lessThanBound = Identifier.of("lessThanBound");
    public static final Identifier DECLARED_NAME_lessThanOrEqBound =
        Identifier.of("lessThanOrEqBound");
    public static final Identifier DECLARED_NAME_greaterThanBound =
        Identifier.of("greaterThanBound");
    public static final Identifier DECLARED_NAME_greaterThanOrEqBound =
        Identifier.of("greaterThanOrEqBound");
    public static final Identifier DECLARED_NAME_equalityBound = Identifier.of("equalityBound");
    public static final Identifier DECLARED_NAME_localClock = Identifier.of("localClock");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlBoundedLeadsToRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_boundTypeParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("boundType"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))));
    }

    protected ParameterDeclaration new_boundValueParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("boundValue"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("BoundValue")))));
    }

    protected ParameterDeclaration new_treeIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_leftOpIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("leftOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_rightOpIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rightOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected VariableDeclaration new_lessThanBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("lessThanBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_LT")))));
    }

    protected VariableDeclaration new_lessThanOrEqBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("lessThanOrEqBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_LTE")))));
    }

    protected VariableDeclaration new_greaterThanBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("greaterThanBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_GT")))));
    }

    protected VariableDeclaration new_greaterThanOrEqBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("greaterThanOrEqBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_GTE")))));
    }

    protected VariableDeclaration new_equalityBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("equalityBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_EQ")))));
    }

    protected VariableDeclaration new_localClockDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("localClock"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.NONE)
                          .setTypeId(BaseTypeIdentifiers.CLOCK)));
    }

    protected Location newId6Location() {
      return new Location()
          .setId("id6")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-232, -96));
    }

    protected Location newId10Location() {
      return new Location()
          .setId("id10")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1304, -96));
    }

    protected Location newId7Location() {
      return new Location()
          .setId("id7")
          .setName(
              new LocationName()
                  .setName("ListeningRightOp")
                  .setCoordinates(GuiCoordinates.of(-552, -136)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-504, -96));
    }

    protected Location newId5Location() {
      return new Location()
          .setId("id5")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-96, -96));
    }

    protected Location newId4Location() {
      return new Location()
          .setId("id4")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(136, -128)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(152, -96));
    }

    protected Location newId11Location() {
      return new Location()
          .setId("id11")
          .setName(
              new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-1554, -126)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1544, -96));
    }

    protected Location newId8Location() {
      return new Location()
          .setId("id8")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-768, -96));
    }

    protected Location newId9Location() {
      return new Location()
          .setId("id9")
          .setName(
              new LocationName()
                  .setName("ListeningLeftOp")
                  .setCoordinates(GuiCoordinates.of(-1088, -136)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1040, -96));
    }

    protected Transition newId6ToId10Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-912, -232))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("equalityBound"))
                                      .setRightChild(
                                          new GreaterThanExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -208))
          .addNail(GuiCoordinates.of(-1304, -208));
    }

    protected Transition newId6ToId7Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-504, 0))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("equalityBound"))
                                      .setRightChild(
                                          new LessThanExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, 24))
          .addNail(GuiCoordinates.of(-504, 24));
    }

    protected Transition newId6ToId5Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-224, -232))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("equalityBound"))
                                      .setRightChild(
                                          new EqualityExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -208))
          .addNail(GuiCoordinates.of(-96, -208));
    }

    protected Transition newId6ToId7Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-568, -32))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanOrEqBound"))
                                      .setRightChild(
                                          new LessThanExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -8))
          .addNail(GuiCoordinates.of(-504, -8));
    }

    protected Transition newId6ToId5Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-224, -32))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanOrEqBound"))
                                      .setRightChild(
                                          new GreaterThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -8))
          .addNail(GuiCoordinates.of(-96, -8));
    }

    protected Transition newId6ToId5Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-224, -168))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("lessThanBound"))
                                      .setRightChild(
                                          new LessThanExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -144))
          .addNail(GuiCoordinates.of(-96, -144));
    }

    protected Transition newId6ToId10Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-912, -168))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("lessThanBound"))
                                      .setRightChild(
                                          new GreaterThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -144))
          .addNail(GuiCoordinates.of(-1304, -144));
    }

    protected Transition newId5ToId4Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-80, -96))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("TdlDiagnostics"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("treeIndex")))
                                              .setRightChild(LiteralConsts.TRUE))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-80, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    protected Transition newId6ToId5Transition_Nr4(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-224, -200))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("lessThanOrEqBound"))
                                      .setRightChild(
                                          new LessThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -176))
          .addNail(GuiCoordinates.of(-96, -176));
    }

    protected Transition newId6ToId10Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-912, -200))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("lessThanOrEqBound"))
                                      .setRightChild(
                                          new GreaterThanExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -176))
          .addNail(GuiCoordinates.of(-1304, -176));
    }

    protected Transition newId4ToId11Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(152, 40))
          .addNail(GuiCoordinates.of(-1544, 40));
    }

    protected Transition newId6ToId5Transition_Nr5(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-224, -64))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanBound"))
                                      .setRightChild(
                                          new GreaterThanExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -40))
          .addNail(GuiCoordinates.of(-96, -40));
    }

    protected Transition newId6ToId7Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-544, -64))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanBound"))
                                      .setRightChild(
                                          new LessThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-232, -40))
          .addNail(GuiCoordinates.of(-504, -40));
    }

    protected Transition newId7ToId6Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-488, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))));
    }

    protected Transition newId8ToId7Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-752, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))));
    }

    protected Transition newId9ToId8Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-964, -96))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(IdentifierExpression.of("localClock"))
                                              .setRightChild(NaturalNumberLiteral.of("0")))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1024, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))));
    }

    protected Transition newId10ToId9Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1288, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))));
    }

    protected Transition newId11ToId10Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1528, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_boundType,
        AbsExpression arg_boundValue,
        AbsExpression arg_treeIndex,
        AbsExpression arg_leftOpIndex,
        AbsExpression arg_rightOpIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_boundType != null) {
        inst.addArgument(arg_boundType);
      } else { // Either provide boundType argument or leave a parameter:
        inst.addParameter(new_boundTypeParameterDeclaration());
      }
      if (arg_boundValue != null) {
        inst.addArgument(arg_boundValue);
      } else { // Either provide boundValue argument or leave a parameter:
        inst.addParameter(new_boundValueParameterDeclaration());
      }
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(new_treeIndexParameterDeclaration());
      }
      if (arg_leftOpIndex != null) {
        inst.addArgument(arg_leftOpIndex);
      } else { // Either provide leftOpIndex argument or leave a parameter:
        inst.addParameter(new_leftOpIndexParameterDeclaration());
      }
      if (arg_rightOpIndex != null) {
        inst.addArgument(arg_rightOpIndex);
      } else { // Either provide rightOpIndex argument or leave a parameter:
        inst.addParameter(new_rightOpIndexParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlBoundedLeadsToRecognizer = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_boundTypeParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_boundValueParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_treeIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_leftOpIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_rightOpIndexParameterDeclaration());

      // Set local declarations:
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_lessThanBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_lessThanOrEqBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_greaterThanBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_greaterThanOrEqBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_equalityBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_localClockDeclaration());

      // Set locations:
      Location locationId6 = newId6Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId6);

      Location locationId10 = newId10Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId10);

      Location locationId7 = newId7Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId7);

      Location locationId5 = newId5Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId5);

      Location locationId4 = newId4Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId4);

      Location locationId11 = newId11Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId11);
      TdlBoundedLeadsToRecognizer.setInitialLocation(locationId11);
      Location locationId8 = newId8Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId8);

      Location locationId9 = newId9Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId9);

      // Set transitions:
      Transition transitionId6ToId10_Nr1 = newId6ToId10Transition_Nr1(locationId6, locationId10);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId10, transitionId6ToId10_Nr1);
      Transition transitionId6ToId7_Nr1 = newId6ToId7Transition_Nr1(locationId6, locationId7);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId7, transitionId6ToId7_Nr1);
      Transition transitionId6ToId5_Nr1 = newId6ToId5Transition_Nr1(locationId6, locationId5);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId5, transitionId6ToId5_Nr1);
      Transition transitionId6ToId7_Nr2 = newId6ToId7Transition_Nr2(locationId6, locationId7);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId7, transitionId6ToId7_Nr2);
      Transition transitionId6ToId5_Nr2 = newId6ToId5Transition_Nr2(locationId6, locationId5);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId5, transitionId6ToId5_Nr2);
      Transition transitionId6ToId5_Nr3 = newId6ToId5Transition_Nr3(locationId6, locationId5);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId5, transitionId6ToId5_Nr3);
      Transition transitionId6ToId10_Nr2 = newId6ToId10Transition_Nr2(locationId6, locationId10);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId10, transitionId6ToId10_Nr2);
      Transition transitionId5ToId4 = newId5ToId4Transition(locationId5, locationId4);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId5, locationId4, transitionId5ToId4);
      Transition transitionId6ToId5_Nr4 = newId6ToId5Transition_Nr4(locationId6, locationId5);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId5, transitionId6ToId5_Nr4);
      Transition transitionId6ToId10_Nr3 = newId6ToId10Transition_Nr3(locationId6, locationId10);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId10, transitionId6ToId10_Nr3);
      Transition transitionId4ToId11 = newId4ToId11Transition(locationId4, locationId11);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId4, locationId11, transitionId4ToId11);
      Transition transitionId6ToId5_Nr5 = newId6ToId5Transition_Nr5(locationId6, locationId5);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId5, transitionId6ToId5_Nr5);
      Transition transitionId6ToId7_Nr3 = newId6ToId7Transition_Nr3(locationId6, locationId7);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId7, transitionId6ToId7_Nr3);
      Transition transitionId7ToId6 = newId7ToId6Transition(locationId7, locationId6);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId7, locationId6, transitionId7ToId6);
      Transition transitionId8ToId7 = newId8ToId7Transition(locationId8, locationId7);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId8, locationId7, transitionId8ToId7);
      Transition transitionId9ToId8 = newId9ToId8Transition(locationId9, locationId8);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId9, locationId8, transitionId9ToId8);
      Transition transitionId10ToId9 = newId10ToId9Transition(locationId10, locationId9);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId10, locationId9, transitionId10ToId9);
      Transition transitionId11ToId10 = newId11ToId10Transition(locationId11, locationId10);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId11, locationId10, transitionId11ToId10);

      return TdlBoundedLeadsToRecognizer;
    }
  }

  public static class TdlBoundedRepetitionRecognizerTemplateFactory {
    public static TdlBoundedRepetitionRecognizerTemplateFactory getInstance() {
      return new TdlBoundedRepetitionRecognizerTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlBoundedRepetitionRecognizer");

    public static final Identifier DECLARED_NAME_lessThanBound = Identifier.of("lessThanBound");
    public static final Identifier DECLARED_NAME_lessThanOrEqBound =
        Identifier.of("lessThanOrEqBound");
    public static final Identifier DECLARED_NAME_greaterThanBound =
        Identifier.of("greaterThanBound");
    public static final Identifier DECLARED_NAME_greaterThanOrEqBound =
        Identifier.of("greaterThanOrEqBound");
    public static final Identifier DECLARED_NAME_equalityBound = Identifier.of("equalityBound");
    public static final Identifier DECLARED_NAME_repetitions = Identifier.of("repetitions");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlBoundedRepetitionRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_boundTypeParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("boundType"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))));
    }

    protected ParameterDeclaration new_boundValueParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("boundValue"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("BoundValue")))));
    }

    protected ParameterDeclaration new_treeIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_operandIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("operandIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected VariableDeclaration new_lessThanBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("lessThanBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_LT")))));
    }

    protected VariableDeclaration new_lessThanOrEqBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("lessThanOrEqBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_LTE")))));
    }

    protected VariableDeclaration new_greaterThanBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("greaterThanBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_GT")))));
    }

    protected VariableDeclaration new_greaterThanOrEqBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("greaterThanOrEqBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_GTE")))));
    }

    protected VariableDeclaration new_equalityBoundDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("equalityBound"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new GroupedExpression()
                          .setChild(
                              new EqualityExpression()
                                  .setLeftChild(IdentifierExpression.of("boundType"))
                                  .setRightChild(IdentifierExpression.of("BOUND_EQ")))));
    }

    protected VariableDeclaration new_repetitionsDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("repetitions"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.NONE)
                          .setTypeId(BaseTypeIdentifiers.INTEGER)))
          .setInitializer(
              new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("0")));
    }

    protected Location newId16Location() {
      return new Location()
          .setId("id16")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(-8, 192)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-24, 200));
    }

    protected Location newId20Location() {
      return new Location()
          .setId("id20")
          .setName(new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-1640, 184)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1600, 200));
    }

    protected Location newId13Location() {
      return new Location()
          .setId("id13")
          .setName(
              new LocationName()
                  .setName("CheckCounter")
                  .setCoordinates(GuiCoordinates.of(-616, 360)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-624, 352));
    }

    protected Location newId15Location() {
      return new Location()
          .setId("id15")
          .setName(
              new LocationName()
                  .setName("StartListening")
                  .setCoordinates(GuiCoordinates.of(-1152, 360)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1160, 352));
    }

    protected Location newId17Location() {
      return new Location()
          .setId("id17")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-272, 200));
    }

    protected Location newId12Location() {
      return new Location()
          .setId("id12")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1208, 264));
    }

    protected Location newId19Location() {
      return new Location()
          .setId("id19")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1376, 200));
    }

    protected Location newId14Location() {
      return new Location()
          .setId("id14")
          .setName(
              new LocationName().setName("Listening").setCoordinates(GuiCoordinates.of(-896, 360)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-904, 352));
    }

    protected Location newId18Location() {
      return new Location()
          .setId("id18")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1160, 136));
    }

    protected Transition newId16ToId20Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(-24, 472))
          .addNail(GuiCoordinates.of(-1600, 472));
    }

    protected Transition newId13ToId15Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-960, 424))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanOrEqBound"))
                                      .setRightChild(
                                          new LessThanExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-624, 448))
          .addNail(GuiCoordinates.of(-1160, 448));
    }

    protected Transition newId13ToId15Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-936, 400))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanBound"))
                                      .setRightChild(
                                          new LessThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-624, 424))
          .addNail(GuiCoordinates.of(-1160, 424));
    }

    protected Transition newId13ToId15Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-904, 376))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("equalityBound"))
                                      .setRightChild(
                                          new InequalityExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-624, 400))
          .addNail(GuiCoordinates.of(-1160, 400));
    }

    protected Transition newId13ToId17Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-616, 312))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanOrEqBound"))
                                      .setRightChild(
                                          new GreaterThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-624, 336))
          .addNail(GuiCoordinates.of(-272, 336));
    }

    protected Transition newId13ToId17Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-616, 288))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanBound"))
                                      .setRightChild(
                                          new GreaterThanExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-624, 312))
          .addNail(GuiCoordinates.of(-272, 312));
    }

    protected Transition newId12ToId15Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1200, 296))
                              .setContent(
                                  new GreaterThanExpression()
                                      .setLeftChild(IdentifierExpression.of("boundValue"))
                                      .setRightChild(NaturalNumberLiteral.of("0")))))
          .addNail(GuiCoordinates.of(-1208, 352));
    }

    protected Transition newId12ToId17Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1192, 240))
                              .setContent(
                                  new EqualityExpression()
                                      .setLeftChild(IdentifierExpression.of("boundValue"))
                                      .setRightChild(NaturalNumberLiteral.of("0"))))
                  .setCommentLabel(
                      (CommentLabel)
                          new CommentLabel()
                              .setContent(
                                  "The condition is \"== n\" or \"&gt= n\" where n == 0.\n"
                                      + "\n"
                                      + "When we begin testing, the number of repetitions is already 0, so we can immediately successfully terminate.\n")))
          .addNail(GuiCoordinates.of(-272, 264));
    }

    protected Transition newId19ToId12Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1360, 208))
                              .setContent(IdentifierExpression.of("equalityBound"))))
          .addNail(GuiCoordinates.of(-1376, 232))
          .addNail(GuiCoordinates.of(-1208, 232));
    }

    protected Transition newId14ToId13Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-816, 352))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new PostfixIncrementExpression()
                                              .setChild(IdentifierExpression.of("repetitions")))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-888, 328))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("operandIndex"))))));
    }

    protected Transition newId15ToId14Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1144, 328))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("operandIndex"))))));
    }

    protected Transition newId13ToId17Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-616, 264))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("equalityBound"))
                                      .setRightChild(
                                          new EqualityExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-624, 288))
          .addNail(GuiCoordinates.of(-272, 288));
    }

    protected Transition newId19ToId12Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1368, 240))
                              .setContent(IdentifierExpression.of("greaterThanOrEqBound"))))
          .addNail(GuiCoordinates.of(-1376, 264));
    }

    protected Transition newId19ToId15Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1368, 328))
                              .setContent(IdentifierExpression.of("greaterThanBound"))))
          .addNail(GuiCoordinates.of(-1376, 352))
          .addNail(GuiCoordinates.of(-1208, 352));
    }

    protected Transition newId18ToId17Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1144, 112))
                              .setContent(
                                  new GreaterThanExpression()
                                      .setLeftChild(IdentifierExpression.of("boundValue"))
                                      .setRightChild(NaturalNumberLiteral.of("0"))))
                  .setCommentLabel(
                      (CommentLabel)
                          new CommentLabel()
                              .setContent(
                                  "The condition is \"&lt; n\" (n &gt;= 1).\n"
                                      + "When we begin testing, the number of repetitions is 0 but 0 &lt; n for n &gt;= 1, so we can immediately successfully terminate.\n")))
          .addNail(GuiCoordinates.of(-272, 136));
    }

    protected Transition newId17ToId16Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-256, 200))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("TdlDiagnostics"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("treeIndex")))
                                              .setRightChild(LiteralConsts.TRUE))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-256, 176))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    protected Transition newId18ToId20Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1280, 112))
                              .setContent(
                                  new EqualityExpression()
                                      .setLeftChild(IdentifierExpression.of("boundValue"))
                                      .setRightChild(NaturalNumberLiteral.of("0"))))
                  .setCommentLabel(
                      (CommentLabel)
                          new CommentLabel()
                              .setContent(
                                  "The condition is \"&lt; n\" (n &lt; 1).\n"
                                      + "This is equivalent to \"&lt; 0\" (n &lt; 1 and n &gt;= 0).\n"
                                      + "We cannot test whether a state occurs less than 0 times.\n")))
          .addNail(GuiCoordinates.of(-1600, 136));
    }

    protected Transition newId19ToId17Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1360, 176))
                              .setContent(IdentifierExpression.of("lessThanOrEqBound")))
                  .setCommentLabel(
                      (CommentLabel)
                          new CommentLabel()
                              .setContent(
                                  "The condition is \"&lt;= n\" (n &gt;= 0).\n"
                                      + "When we begin testing, the number of repetitions is already 0, but 0 &lt;= n for n &gt;= 0, so we can immediately successfully terminate.\n")));
    }

    protected Transition newId19ToId18Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-1360, 144))
                              .setContent(IdentifierExpression.of("lessThanBound"))))
          .addNail(GuiCoordinates.of(-1376, 168))
          .addNail(GuiCoordinates.of(-1160, 168));
    }

    protected Transition newId20ToId19Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-1548, 200))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(NaturalNumberLiteral.of("0")))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1592, 176))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_boundType,
        AbsExpression arg_boundValue,
        AbsExpression arg_treeIndex,
        AbsExpression arg_operandIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_boundType != null) {
        inst.addArgument(arg_boundType);
      } else { // Either provide boundType argument or leave a parameter:
        inst.addParameter(new_boundTypeParameterDeclaration());
      }
      if (arg_boundValue != null) {
        inst.addArgument(arg_boundValue);
      } else { // Either provide boundValue argument or leave a parameter:
        inst.addParameter(new_boundValueParameterDeclaration());
      }
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(new_treeIndexParameterDeclaration());
      }
      if (arg_operandIndex != null) {
        inst.addArgument(arg_operandIndex);
      } else { // Either provide operandIndex argument or leave a parameter:
        inst.addParameter(new_operandIndexParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlBoundedRepetitionRecognizer = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getParameters(), new_boundTypeParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getParameters(), new_boundValueParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getParameters(), new_treeIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getParameters(), new_operandIndexParameterDeclaration());

      // Set local declarations:
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_lessThanBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_lessThanOrEqBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_greaterThanBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_greaterThanOrEqBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_equalityBoundDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_repetitionsDeclaration());

      // Set locations:
      Location locationId16 = newId16Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId16);

      Location locationId20 = newId20Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId20);
      TdlBoundedRepetitionRecognizer.setInitialLocation(locationId20);
      Location locationId13 = newId13Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId13);

      Location locationId15 = newId15Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId15);

      Location locationId17 = newId17Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId17);

      Location locationId12 = newId12Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId12);

      Location locationId19 = newId19Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId19);

      Location locationId14 = newId14Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId14);

      Location locationId18 = newId18Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId18);

      // Set transitions:
      Transition transitionId16ToId20 = newId16ToId20Transition(locationId16, locationId20);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId16, locationId20, transitionId16ToId20);
      Transition transitionId13ToId15_Nr1 = newId13ToId15Transition_Nr1(locationId13, locationId15);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId13, locationId15, transitionId13ToId15_Nr1);
      Transition transitionId13ToId15_Nr2 = newId13ToId15Transition_Nr2(locationId13, locationId15);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId13, locationId15, transitionId13ToId15_Nr2);
      Transition transitionId13ToId15_Nr3 = newId13ToId15Transition_Nr3(locationId13, locationId15);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId13, locationId15, transitionId13ToId15_Nr3);
      Transition transitionId13ToId17_Nr1 = newId13ToId17Transition_Nr1(locationId13, locationId17);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId13, locationId17, transitionId13ToId17_Nr1);
      Transition transitionId13ToId17_Nr2 = newId13ToId17Transition_Nr2(locationId13, locationId17);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId13, locationId17, transitionId13ToId17_Nr2);
      Transition transitionId12ToId15 = newId12ToId15Transition(locationId12, locationId15);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId12, locationId15, transitionId12ToId15);
      Transition transitionId12ToId17 = newId12ToId17Transition(locationId12, locationId17);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId12, locationId17, transitionId12ToId17);
      Transition transitionId19ToId12_Nr1 = newId19ToId12Transition_Nr1(locationId19, locationId12);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId19, locationId12, transitionId19ToId12_Nr1);
      Transition transitionId14ToId13 = newId14ToId13Transition(locationId14, locationId13);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId14, locationId13, transitionId14ToId13);
      Transition transitionId15ToId14 = newId15ToId14Transition(locationId15, locationId14);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId15, locationId14, transitionId15ToId14);
      Transition transitionId13ToId17_Nr3 = newId13ToId17Transition_Nr3(locationId13, locationId17);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId13, locationId17, transitionId13ToId17_Nr3);
      Transition transitionId19ToId12_Nr2 = newId19ToId12Transition_Nr2(locationId19, locationId12);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId19, locationId12, transitionId19ToId12_Nr2);
      Transition transitionId19ToId15 = newId19ToId15Transition(locationId19, locationId15);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId19, locationId15, transitionId19ToId15);
      Transition transitionId18ToId17 = newId18ToId17Transition(locationId18, locationId17);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId18, locationId17, transitionId18ToId17);
      Transition transitionId17ToId16 = newId17ToId16Transition(locationId17, locationId16);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId17, locationId16, transitionId17ToId16);
      Transition transitionId18ToId20 = newId18ToId20Transition(locationId18, locationId20);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId18, locationId20, transitionId18ToId20);
      Transition transitionId19ToId17 = newId19ToId17Transition(locationId19, locationId17);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId19, locationId17, transitionId19ToId17);
      Transition transitionId19ToId18 = newId19ToId18Transition(locationId19, locationId18);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId19, locationId18, transitionId19ToId18);
      Transition transitionId20ToId19 = newId20ToId19Transition(locationId20, locationId19);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId20, locationId19, transitionId20ToId19);

      return TdlBoundedRepetitionRecognizer;
    }
  }

  public static class TdlConjunctionRecognizerTemplateFactory {
    public static TdlConjunctionRecognizerTemplateFactory getInstance() {
      return new TdlConjunctionRecognizerTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlConjunctionRecognizer");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlConjunctionRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_treeIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_leftOpIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("leftOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_rightOpIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rightOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected Location newId26Location() {
      return new Location()
          .setId("id26")
          .setName(
              new LocationName().setName("End").setCoordinates(GuiCoordinates.of(-2000, -1144)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1992, -1112));
    }

    protected Location newId28Location() {
      return new Location()
          .setId("id28")
          .setName(
              new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-3280, -1032)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-3272, -1000));
    }

    protected Location newId21Location() {
      return new Location()
          .setId("id21")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2248, -1000));
    }

    protected Location newId23Location() {
      return new Location()
          .setId("id23")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2248, -1112));
    }

    protected Location newId22Location() {
      return new Location()
          .setId("id22")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2520, -1112));
    }

    protected Location newId27Location() {
      return new Location()
          .setId("id27")
          .setName(
              new LocationName()
                  .setName("Listening")
                  .setCoordinates(GuiCoordinates.of(-2512, -992)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2520, -1000));
    }

    protected Location newId24Location() {
      return new Location()
          .setId("id24")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2776, -1000));
    }

    protected Location newId25Location() {
      return new Location()
          .setId("id25")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-3024, -1000));
    }

    protected Transition newId26ToId28Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(-1992, -936))
          .addNail(GuiCoordinates.of(-3272, -936));
    }

    protected Transition newId21ToId23Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-2240, -1064))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))));
    }

    protected Transition newId22ToId23Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-2512, -1144))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))));
    }

    protected Transition newId27ToId22Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-2760, -1064))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))));
    }

    protected Transition newId27ToId21Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-2504, -1024))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))));
    }

    protected Transition newId24ToId27Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-2768, -992))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))));
    }

    protected Transition newId25ToId24Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-3008, -992))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))));
    }

    protected Transition newId23ToId26Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-2232, -1136))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("TdlDiagnostics"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("treeIndex")))
                                              .setRightChild(LiteralConsts.TRUE))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-2232, -1104))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    protected Transition newId28ToId25Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-3248, -1024))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_treeIndex,
        AbsExpression arg_leftOpIndex,
        AbsExpression arg_rightOpIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(new_treeIndexParameterDeclaration());
      }
      if (arg_leftOpIndex != null) {
        inst.addArgument(arg_leftOpIndex);
      } else { // Either provide leftOpIndex argument or leave a parameter:
        inst.addParameter(new_leftOpIndexParameterDeclaration());
      }
      if (arg_rightOpIndex != null) {
        inst.addArgument(arg_rightOpIndex);
      } else { // Either provide rightOpIndex argument or leave a parameter:
        inst.addParameter(new_rightOpIndexParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlConjunctionRecognizer = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlConjunctionRecognizer.getParameters(), new_treeIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlConjunctionRecognizer.getParameters(), new_leftOpIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlConjunctionRecognizer.getParameters(), new_rightOpIndexParameterDeclaration());

      // Set local declarations:

      // Set locations:
      Location locationId26 = newId26Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId26);

      Location locationId28 = newId28Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId28);
      TdlConjunctionRecognizer.setInitialLocation(locationId28);
      Location locationId21 = newId21Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId21);

      Location locationId23 = newId23Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId23);

      Location locationId22 = newId22Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId22);

      Location locationId27 = newId27Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId27);

      Location locationId24 = newId24Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId24);

      Location locationId25 = newId25Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId25);

      // Set transitions:
      Transition transitionId26ToId28 = newId26ToId28Transition(locationId26, locationId28);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId26, locationId28, transitionId26ToId28);
      Transition transitionId21ToId23 = newId21ToId23Transition(locationId21, locationId23);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId21, locationId23, transitionId21ToId23);
      Transition transitionId22ToId23 = newId22ToId23Transition(locationId22, locationId23);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId22, locationId23, transitionId22ToId23);
      Transition transitionId27ToId22 = newId27ToId22Transition(locationId27, locationId22);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId22, transitionId27ToId22);
      Transition transitionId27ToId21 = newId27ToId21Transition(locationId27, locationId21);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId21, transitionId27ToId21);
      Transition transitionId24ToId27 = newId24ToId27Transition(locationId24, locationId27);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId24, locationId27, transitionId24ToId27);
      Transition transitionId25ToId24 = newId25ToId24Transition(locationId25, locationId24);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId25, locationId24, transitionId25ToId24);
      Transition transitionId23ToId26 = newId23ToId26Transition(locationId23, locationId26);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId23, locationId26, transitionId23ToId26);
      Transition transitionId28ToId25 = newId28ToId25Transition(locationId28, locationId25);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId28, locationId25, transitionId28ToId25);

      return TdlConjunctionRecognizer;
    }
  }

  public static class TdlDisjunctionRecognizerTemplateFactory {
    public static TdlDisjunctionRecognizerTemplateFactory getInstance() {
      return new TdlDisjunctionRecognizerTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlDisjunctionRecognizer");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlDisjunctionRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_treeIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_leftOpIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("leftOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_rightOpIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rightOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected Location newId30Location() {
      return new Location()
          .setId("id30")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1000, -600));
    }

    protected Location newId29Location() {
      return new Location()
          .setId("id29")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(-760, -632)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-752, -600));
    }

    protected Location newId31Location() {
      return new Location()
          .setId("id31")
          .setName(
              new LocationName()
                  .setName("Listening")
                  .setCoordinates(GuiCoordinates.of(-1288, -512)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1296, -520));
    }

    protected Location newId32Location() {
      return new Location()
          .setId("id32")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1552, -520));
    }

    protected Location newId33Location() {
      return new Location()
          .setId("id33")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1792, -520));
    }

    protected Location newId34Location() {
      return new Location()
          .setId("id34")
          .setName(
              new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-2040, -552)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2032, -520));
    }

    protected Transition newId30ToId29Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-976, -624))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("TdlDiagnostics"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("treeIndex")))
                                              .setRightChild(LiteralConsts.TRUE))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-984, -592))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    protected Transition newId31ToId30Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1272, -624))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))))
          .addNail(GuiCoordinates.of(-1296, -600));
    }

    protected Transition newId31ToId30Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1272, -544))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))))
          .addNail(GuiCoordinates.of(-1000, -520));
    }

    protected Transition newId32ToId31Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1536, -512))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))));
    }

    protected Transition newId33ToId32Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1784, -512))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))));
    }

    protected Transition newId34ToId33Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-2016, -544))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    protected Transition newId29ToId34Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(-752, -456))
          .addNail(GuiCoordinates.of(-2032, -456));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_treeIndex,
        AbsExpression arg_leftOpIndex,
        AbsExpression arg_rightOpIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(new_treeIndexParameterDeclaration());
      }
      if (arg_leftOpIndex != null) {
        inst.addArgument(arg_leftOpIndex);
      } else { // Either provide leftOpIndex argument or leave a parameter:
        inst.addParameter(new_leftOpIndexParameterDeclaration());
      }
      if (arg_rightOpIndex != null) {
        inst.addArgument(arg_rightOpIndex);
      } else { // Either provide rightOpIndex argument or leave a parameter:
        inst.addParameter(new_rightOpIndexParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlDisjunctionRecognizer = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlDisjunctionRecognizer.getParameters(), new_treeIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlDisjunctionRecognizer.getParameters(), new_leftOpIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlDisjunctionRecognizer.getParameters(), new_rightOpIndexParameterDeclaration());

      // Set local declarations:

      // Set locations:
      Location locationId30 = newId30Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId30);

      Location locationId29 = newId29Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId29);

      Location locationId31 = newId31Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId31);

      Location locationId32 = newId32Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId32);

      Location locationId33 = newId33Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId33);

      Location locationId34 = newId34Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId34);
      TdlDisjunctionRecognizer.setInitialLocation(locationId34);

      // Set transitions:
      Transition transitionId30ToId29 = newId30ToId29Transition(locationId30, locationId29);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId30, locationId29, transitionId30ToId29);
      Transition transitionId31ToId30_Nr1 = newId31ToId30Transition_Nr1(locationId31, locationId30);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId31, locationId30, transitionId31ToId30_Nr1);
      Transition transitionId31ToId30_Nr2 = newId31ToId30Transition_Nr2(locationId31, locationId30);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId31, locationId30, transitionId31ToId30_Nr2);
      Transition transitionId32ToId31 = newId32ToId31Transition(locationId32, locationId31);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId32, locationId31, transitionId32ToId31);
      Transition transitionId33ToId32 = newId33ToId32Transition(locationId33, locationId32);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId33, locationId32, transitionId33ToId32);
      Transition transitionId34ToId33 = newId34ToId33Transition(locationId34, locationId33);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId34, locationId33, transitionId34ToId33);
      Transition transitionId29ToId34 = newId29ToId34Transition(locationId29, locationId34);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId29, locationId34, transitionId29ToId34);

      return TdlDisjunctionRecognizer;
    }
  }

  public static class TdlLeadsToRecognizerTemplateFactory {
    public static TdlLeadsToRecognizerTemplateFactory getInstance() {
      return new TdlLeadsToRecognizerTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlLeadsToRecognizer");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlLeadsToRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_treeIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_leftOpIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("leftOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_rightOpIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rightOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected Location newId35Location() {
      return new Location()
          .setId("id35")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(288, -448)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(296, -416));
    }

    protected Location newId41Location() {
      return new Location()
          .setId("id41")
          .setName(
              new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-1208, -448)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1200, -416));
    }

    protected Location newId36Location() {
      return new Location()
          .setId("id36")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(48, -416));
    }

    protected Location newId37Location() {
      return new Location()
          .setId("id37")
          .setName(
              new LocationName()
                  .setName("ListeningRightOp")
                  .setCoordinates(GuiCoordinates.of(-264, -448)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-216, -416));
    }

    protected Location newId38Location() {
      return new Location()
          .setId("id38")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-464, -416));
    }

    protected Location newId39Location() {
      return new Location()
          .setId("id39")
          .setName(
              new LocationName()
                  .setName("ListeningLeftOp")
                  .setCoordinates(GuiCoordinates.of(-768, -448)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-720, -416));
    }

    protected Location newId40Location() {
      return new Location()
          .setId("id40")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-952, -416));
    }

    protected Transition newId35ToId41Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(296, -360))
          .addNail(GuiCoordinates.of(-1200, -360));
    }

    protected Transition newId36ToId35Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(64, -416))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("TdlDiagnostics"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("treeIndex")))
                                              .setRightChild(LiteralConsts.TRUE))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(64, -440))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    protected Transition newId37ToId36Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-208, -408))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))));
    }

    protected Transition newId38ToId37Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-456, -408))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rightOpIndex"))))));
    }

    protected Transition newId39ToId38Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-712, -408))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))));
    }

    protected Transition newId40ToId39Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-944, -408))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("leftOpIndex"))))));
    }

    protected Transition newId41ToId40Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1184, -440))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_treeIndex,
        AbsExpression arg_leftOpIndex,
        AbsExpression arg_rightOpIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(new_treeIndexParameterDeclaration());
      }
      if (arg_leftOpIndex != null) {
        inst.addArgument(arg_leftOpIndex);
      } else { // Either provide leftOpIndex argument or leave a parameter:
        inst.addParameter(new_leftOpIndexParameterDeclaration());
      }
      if (arg_rightOpIndex != null) {
        inst.addArgument(arg_rightOpIndex);
      } else { // Either provide rightOpIndex argument or leave a parameter:
        inst.addParameter(new_rightOpIndexParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlLeadsToRecognizer = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlLeadsToRecognizer.getParameters(), new_treeIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlLeadsToRecognizer.getParameters(), new_leftOpIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlLeadsToRecognizer.getParameters(), new_rightOpIndexParameterDeclaration());

      // Set local declarations:

      // Set locations:
      Location locationId35 = newId35Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId35);

      Location locationId41 = newId41Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId41);
      TdlLeadsToRecognizer.setInitialLocation(locationId41);
      Location locationId36 = newId36Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId36);

      Location locationId37 = newId37Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId37);

      Location locationId38 = newId38Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId38);

      Location locationId39 = newId39Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId39);

      Location locationId40 = newId40Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId40);

      // Set transitions:
      Transition transitionId35ToId41 = newId35ToId41Transition(locationId35, locationId41);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId35, locationId41, transitionId35ToId41);
      Transition transitionId36ToId35 = newId36ToId35Transition(locationId36, locationId35);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId35, transitionId36ToId35);
      Transition transitionId37ToId36 = newId37ToId36Transition(locationId37, locationId36);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId37, locationId36, transitionId37ToId36);
      Transition transitionId38ToId37 = newId38ToId37Transition(locationId38, locationId37);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId38, locationId37, transitionId38ToId37);
      Transition transitionId39ToId38 = newId39ToId38Transition(locationId39, locationId38);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId39, locationId38, transitionId39ToId38);
      Transition transitionId40ToId39 = newId40ToId39Transition(locationId40, locationId39);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId40, locationId39, transitionId40ToId39);
      Transition transitionId41ToId40 = newId41ToId40Transition(locationId41, locationId40);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId41, locationId40, transitionId41ToId40);

      return TdlLeadsToRecognizer;
    }
  }

  public static class TdlQuantificationRecognizerTemplateFactory {
    public static TdlQuantificationRecognizerTemplateFactory getInstance() {
      return new TdlQuantificationRecognizerTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlQuantificationRecognizer");

    public static final Identifier DECLARED_NAME_negatedUniversalQuantification =
        Identifier.of("negatedUniversalQuantification");
    public static final Identifier DECLARED_NAME_negatedExistentialQuantification =
        Identifier.of("negatedExistentialQuantification");
    public static final Identifier DECLARED_NAME_universalQuantification =
        Identifier.of("universalQuantification");
    public static final Identifier DECLARED_NAME_existentialQuantification =
        Identifier.of("existentialQuantification");
    public static final Identifier DECLARED_NAME_index = Identifier.of("index");
    public static final Identifier DECLARED_NAME_resetTrapset = Identifier.of("resetTrapset");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlQuantificationRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_universalParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("universal"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)));
    }

    protected ParameterDeclaration new_negatedParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("negated"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)));
    }

    protected ParameterDeclaration new_treeIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_trapsetIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("trapsetIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TrapsetIndex")))));
    }

    protected ParameterDeclaration new_trapsetSizeParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("trapsetSize"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.INTEGER)));
    }

    protected ParameterDeclaration new_trapsetParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("trapset"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.NONE)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN))
                  .setReferenceType(true)
                  .addArrayModifier(
                      new SizeExpressionArrayModifier()
                          .setSizeSpecifier(NaturalNumberLiteral.of("0"))));
    }

    protected VariableDeclaration new_negatedUniversalQuantificationDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("negatedUniversalQuantification"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new ConjunctionExpression()
                          .setLeftChild(IdentifierExpression.of("universal"))
                          .setRightChild(IdentifierExpression.of("negated"))));
    }

    protected VariableDeclaration new_negatedExistentialQuantificationDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("negatedExistentialQuantification"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new ConjunctionExpression()
                          .setLeftChild(
                              new NegationExpression()
                                  .setChild(IdentifierExpression.of("universal")))
                          .setRightChild(IdentifierExpression.of("negated"))));
    }

    protected VariableDeclaration new_universalQuantificationDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("universalQuantification"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new ConjunctionExpression()
                          .setLeftChild(IdentifierExpression.of("universal"))
                          .setRightChild(
                              new NegationExpression()
                                  .setChild(IdentifierExpression.of("negated")))));
    }

    protected VariableDeclaration new_existentialQuantificationDeclaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("existentialQuantification"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)))
          .setInitializer(
              new FlatVariableInitializer()
                  .setExpression(
                      new ConjunctionExpression()
                          .setLeftChild(
                              new NegationExpression()
                                  .setChild(IdentifierExpression.of("universal")))
                          .setRightChild(
                              new NegationExpression()
                                  .setChild(IdentifierExpression.of("negated")))));
    }

    protected TypeDeclaration new_indexDeclaration() {
      return new TypeDeclaration()
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.NONE)
                          .setTypeId(
                              BoundedIntegerTypeId.of(
                                  NaturalNumberLiteral.of("0"),
                                  new SubtractionExpression()
                                      .setLeftChild(IdentifierExpression.of("trapsetSize"))
                                      .setRightChild(NaturalNumberLiteral.of("1"))))))
          .setIdentifier(Identifier.of("index"));
    }

    protected FunctionDeclaration new_resetTrapsetDeclaration() {
      return new FunctionDeclaration()
          .setName(Identifier.of("resetTrapset"))
          .setStatementBlock(
              new StatementBlock()
                  .addStatement(
                      new IterationLoop()
                          .setIteratedType(
                              new BaseType()
                                  .setPrefix(ETypePrefix.NONE)
                                  .setTypeId(CustomTypeId.of(Identifier.of("index"))))
                          .setLoopVariable(Identifier.of("i"))
                          .setStatement(
                              new StatementBlock()
                                  .addStatement(
                                      new ExpressionStatement()
                                          .setExpression(
                                              new AssignmentExpression()
                                                  .setLeftChild(
                                                      new ArrayLookupExpression()
                                                          .setLeftChild(
                                                              IdentifierExpression.of("trapset"))
                                                          .setRightChild(
                                                              IdentifierExpression.of("i")))
                                                  .setRightChild(LiteralConsts.FALSE))))));
    }

    protected Location newId44Location() {
      return new Location()
          .setId("id44")
          .setName(
              new LocationName().setName("Listening").setCoordinates(GuiCoordinates.of(-536, -16)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-552, -8));
    }

    protected Location newId42Location() {
      return new Location()
          .setId("id42")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-16, -8));
    }

    protected Location newId43Location() {
      return new Location()
          .setId("id43")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(216, -40)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(232, -8));
    }

    protected Location newId45Location() {
      return new Location()
          .setId("id45")
          .setName(new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-800, -40)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-792, -8));
    }

    protected Transition newId44ToId42Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-480, 8))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(
                                          IdentifierExpression.of(
                                              "negatedExistentialQuantification"))
                                      .setRightChild(
                                          new QuantificationExpression()
                                              .setQuantificationType(EQuantificationType.UNIVERSAL)
                                              .setIterationVariableType(
                                                  new BaseType()
                                                      .setPrefix(ETypePrefix.NONE)
                                                      .setTypeId(
                                                          CustomTypeId.of(Identifier.of("index"))))
                                              .setIdentifierName(Identifier.of("i"))
                                              .setChild(
                                                  new NegationExpression()
                                                      .setChild(
                                                          new ArrayLookupExpression()
                                                              .setLeftChild(
                                                                  IdentifierExpression.of(
                                                                      "trapset"))
                                                              .setRightChild(
                                                                  IdentifierExpression.of("i")))))))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-424, 32))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of(
                                                      "TrapsetActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("trapsetIndex"))))))
          .addNail(GuiCoordinates.of(-552, 32))
          .addNail(GuiCoordinates.of(-16, 32));
    }

    protected Transition newId44ToId42Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-488, -96))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(
                                          IdentifierExpression.of("negatedUniversalQuantification"))
                                      .setRightChild(
                                          new QuantificationExpression()
                                              .setQuantificationType(
                                                  EQuantificationType.EXISTENTIAL)
                                              .setIterationVariableType(
                                                  new BaseType()
                                                      .setPrefix(ETypePrefix.NONE)
                                                      .setTypeId(
                                                          CustomTypeId.of(Identifier.of("index"))))
                                              .setIdentifierName(Identifier.of("i"))
                                              .setChild(
                                                  new NegationExpression()
                                                      .setChild(
                                                          new ArrayLookupExpression()
                                                              .setLeftChild(
                                                                  IdentifierExpression.of(
                                                                      "trapset"))
                                                              .setRightChild(
                                                                  IdentifierExpression.of("i")))))))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-424, -72))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of(
                                                      "TrapsetActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("trapsetIndex"))))))
          .addNail(GuiCoordinates.of(-552, -72))
          .addNail(GuiCoordinates.of(-16, -72));
    }

    protected Transition newId44ToId42Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-456, -144))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(
                                          IdentifierExpression.of("universalQuantification"))
                                      .setRightChild(
                                          new QuantificationExpression()
                                              .setQuantificationType(EQuantificationType.UNIVERSAL)
                                              .setIterationVariableType(
                                                  new BaseType()
                                                      .setPrefix(ETypePrefix.NONE)
                                                      .setTypeId(
                                                          CustomTypeId.of(Identifier.of("index"))))
                                              .setIdentifierName(Identifier.of("i"))
                                              .setChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("trapset"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("i"))))))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-424, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of(
                                                      "TrapsetActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("trapsetIndex"))))))
          .addNail(GuiCoordinates.of(-552, -120))
          .addNail(GuiCoordinates.of(-16, -120))
          .addNail(GuiCoordinates.of(-16, -80));
    }

    protected Transition newId42ToId43Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(0, -32))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("TdlDiagnostics"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("treeIndex")))
                                              .setRightChild(LiteralConsts.TRUE))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(0, 0))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    protected Transition newId43ToId45Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-336, 136))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new CallExpression()
                                              .setChild(IdentifierExpression.of("resetTrapset")))
                                      .build())))
          .addNail(GuiCoordinates.of(232, 160))
          .addNail(GuiCoordinates.of(-792, 160));
    }

    protected Transition newId44ToId42Transition_Nr4(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-456, 72))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(
                                          IdentifierExpression.of("existentialQuantification"))
                                      .setRightChild(
                                          new QuantificationExpression()
                                              .setQuantificationType(
                                                  EQuantificationType.EXISTENTIAL)
                                              .setIterationVariableType(
                                                  new BaseType()
                                                      .setPrefix(ETypePrefix.NONE)
                                                      .setTypeId(
                                                          CustomTypeId.of(Identifier.of("index"))))
                                              .setIdentifierName(Identifier.of("i"))
                                              .setChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("trapset"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("i"))))))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-424, 96))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of(
                                                      "TrapsetActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("trapsetIndex"))))))
          .addNail(GuiCoordinates.of(-552, 96))
          .addNail(GuiCoordinates.of(-16, 96));
    }

    protected Transition newId45ToId44Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-776, 0))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_universal,
        AbsExpression arg_negated,
        AbsExpression arg_treeIndex,
        AbsExpression arg_trapsetIndex,
        AbsExpression arg_trapsetSize,
        AbsExpression arg_trapset) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_universal != null) {
        inst.addArgument(arg_universal);
      } else { // Either provide universal argument or leave a parameter:
        inst.addParameter(new_universalParameterDeclaration());
      }
      if (arg_negated != null) {
        inst.addArgument(arg_negated);
      } else { // Either provide negated argument or leave a parameter:
        inst.addParameter(new_negatedParameterDeclaration());
      }
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(new_treeIndexParameterDeclaration());
      }
      if (arg_trapsetIndex != null) {
        inst.addArgument(arg_trapsetIndex);
      } else { // Either provide trapsetIndex argument or leave a parameter:
        inst.addParameter(new_trapsetIndexParameterDeclaration());
      }
      if (arg_trapsetSize != null) {
        inst.addArgument(arg_trapsetSize);
      } else { // Either provide trapsetSize argument or leave a parameter:
        inst.addParameter(new_trapsetSizeParameterDeclaration());
      }
      if (arg_trapset != null) {
        inst.addArgument(arg_trapset);
      } else { // Either provide trapset argument or leave a parameter:
        inst.addParameter(new_trapsetParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlQuantificationRecognizer = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_universalParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_negatedParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_treeIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_trapsetIndexParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_trapsetSizeParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_trapsetParameterDeclaration());

      // Set local declarations:
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(),
          new_negatedUniversalQuantificationDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(),
          new_negatedExistentialQuantificationDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(), new_universalQuantificationDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(),
          new_existentialQuantificationDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(), new_indexDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(), new_resetTrapsetDeclaration());

      // Set locations:
      Location locationId44 = newId44Location();
      TdlQuantificationRecognizer.getLocationGraph().addVertex(locationId44);

      Location locationId42 = newId42Location();
      TdlQuantificationRecognizer.getLocationGraph().addVertex(locationId42);

      Location locationId43 = newId43Location();
      TdlQuantificationRecognizer.getLocationGraph().addVertex(locationId43);

      Location locationId45 = newId45Location();
      TdlQuantificationRecognizer.getLocationGraph().addVertex(locationId45);
      TdlQuantificationRecognizer.setInitialLocation(locationId45);

      // Set transitions:
      Transition transitionId44ToId42_Nr1 = newId44ToId42Transition_Nr1(locationId44, locationId42);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId44, locationId42, transitionId44ToId42_Nr1);
      Transition transitionId44ToId42_Nr2 = newId44ToId42Transition_Nr2(locationId44, locationId42);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId44, locationId42, transitionId44ToId42_Nr2);
      Transition transitionId44ToId42_Nr3 = newId44ToId42Transition_Nr3(locationId44, locationId42);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId44, locationId42, transitionId44ToId42_Nr3);
      Transition transitionId42ToId43 = newId42ToId43Transition(locationId42, locationId43);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId42, locationId43, transitionId42ToId43);
      Transition transitionId43ToId45 = newId43ToId45Transition(locationId43, locationId45);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId43, locationId45, transitionId43ToId45);
      Transition transitionId44ToId42_Nr4 = newId44ToId42Transition_Nr4(locationId44, locationId42);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId44, locationId42, transitionId44ToId42_Nr4);
      Transition transitionId45ToId44 = newId45ToId44Transition(locationId45, locationId44);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId45, locationId44, transitionId45ToId44);

      return TdlQuantificationRecognizer;
    }
  }

  public static class TdlTrivialTrueRecognizerTemplateFactory {
    public static TdlTrivialTrueRecognizerTemplateFactory getInstance() {
      return new TdlTrivialTrueRecognizerTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlTrivialTrueRecognizer");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlTrivialTrueRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_treeIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected Location newId46Location() {
      return new Location()
          .setId("id46")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(390, -30)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(400, 0));
    }

    protected Location newId48Location() {
      return new Location()
          .setId("id48")
          .setName(new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-154, -30)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-144, 0));
    }

    protected Location newId47Location() {
      return new Location()
          .setId("id47")
          .setName(
              new LocationName().setName("Notifying").setCoordinates(GuiCoordinates.of(96, -32)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(120, 0));
    }

    protected Transition newId46ToId48Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(400, 56))
          .addNail(GuiCoordinates.of(-144, 56));
    }

    protected Transition newId47ToId46Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(168, 0))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(
                                                  new ArrayLookupExpression()
                                                      .setLeftChild(
                                                          IdentifierExpression.of("TdlDiagnostics"))
                                                      .setRightChild(
                                                          IdentifierExpression.of("treeIndex")))
                                              .setRightChild(LiteralConsts.TRUE))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(160, -24))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(true)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    protected Transition newId48ToId47Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-120, -24))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName, AbsExpression arg_treeIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(new_treeIndexParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlTrivialTrueRecognizer = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlTrivialTrueRecognizer.getParameters(), new_treeIndexParameterDeclaration());

      // Set local declarations:

      // Set locations:
      Location locationId46 = newId46Location();
      TdlTrivialTrueRecognizer.getLocationGraph().addVertex(locationId46);

      Location locationId48 = newId48Location();
      TdlTrivialTrueRecognizer.getLocationGraph().addVertex(locationId48);
      TdlTrivialTrueRecognizer.setInitialLocation(locationId48);
      Location locationId47 = newId47Location();
      TdlTrivialTrueRecognizer.getLocationGraph().addVertex(locationId47);

      // Set transitions:
      Transition transitionId46ToId48 = newId46ToId48Transition(locationId46, locationId48);
      TdlTrivialTrueRecognizer.getLocationGraph()
          .addEdge(locationId46, locationId48, transitionId46ToId48);
      Transition transitionId47ToId46 = newId47ToId46Transition(locationId47, locationId46);
      TdlTrivialTrueRecognizer.getLocationGraph()
          .addEdge(locationId47, locationId46, transitionId47ToId46);
      Transition transitionId48ToId47 = newId48ToId47Transition(locationId48, locationId47);
      TdlTrivialTrueRecognizer.getLocationGraph()
          .addEdge(locationId48, locationId47, transitionId48ToId47);

      return TdlTrivialTrueRecognizer;
    }
  }

  public static class TdlTrivialFalseRecognizerTemplateFactory {
    public static TdlTrivialFalseRecognizerTemplateFactory getInstance() {
      return new TdlTrivialFalseRecognizerTemplateFactory();
    }

    public static final Identifier TEMPLATE_NAME = Identifier.of("TdlTrivialFalseRecognizer");

    public Identifier getTemplateName() {
      return TEMPLATE_NAME;
    }

    protected TdlTrivialFalseRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_treeIndexParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected Location newId49Location() {
      return new Location()
          .setId("id49")
          .setName(new LocationName().setName("NoOp").setCoordinates(GuiCoordinates.of(-40, -32)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(0, 0));
    }

    protected Transition newId49ToId49Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(88, -16))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlActivatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("treeIndex"))))))
          .addNail(GuiCoordinates.of(80, -88))
          .addNail(GuiCoordinates.of(80, 80));
    }

    public TemplateInstantiation createInstantiation(
        Identifier newTemplateName, AbsExpression arg_treeIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(getTemplateName());

      // Set arguments/parameters:
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(new_treeIndexParameterDeclaration());
      }

      return inst;
    }

    public Template newTemplate() {
      Template TdlTrivialFalseRecognizer = new Template().setName(getTemplateName());

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlTrivialFalseRecognizer.getParameters(), new_treeIndexParameterDeclaration());

      // Set local declarations:

      // Set locations:
      Location locationId49 = newId49Location();
      TdlTrivialFalseRecognizer.getLocationGraph().addVertex(locationId49);
      TdlTrivialFalseRecognizer.setInitialLocation(locationId49);

      // Set transitions:
      Transition transitionId49ToId49 = newId49ToId49Transition(locationId49, locationId49);
      TdlTrivialFalseRecognizer.getLocationGraph()
          .addEdge(locationId49, locationId49, transitionId49ToId49);

      return TdlTrivialFalseRecognizer;
    }
  }

  public static class ScenarioWrapperBaseSystemDefinitionFactory {
    public static ScenarioWrapperBaseSystemDefinitionFactory getInstance() {
      return new ScenarioWrapperBaseSystemDefinitionFactory();
    }

    protected ScenarioWrapperBaseSystemDefinitionFactory() {}

    protected TemplateInstantiation new_TdlStopwatchDeclaration() {
      return new TemplateInstantiation()
          .setNewTemplateName(Identifier.of("TdlStopwatch"))
          .setSourceTemplateName(Identifier.of("TdlScenarioStopwatch"))
          .addArgument(NaturalNumberLiteral.of("0"));
    }

    protected static final Identifier ProcessReferenceTdlStopwatch = Identifier.of("TdlStopwatch");

    protected SystemLine newSystemLine() {
      return new SystemLine()
          .addGroup(new ProcessReferenceGroup().addIdentifier(Identifier.of("TdlStopwatch")));
    }

    public SystemDefinition newSystemDefinition() {
      SystemDefinition systemDefinition = new SystemDefinition();

      // Set local declarations:
      CollectionUtils.addIfNonNull(
          systemDefinition.getDeclarations(), new_TdlStopwatchDeclaration());
      // Set system line:
      systemDefinition.setSystemLine(newSystemLine());
      // Set progress measures:

      return systemDefinition;
    }
  }

  public static ScenarioWrapperBaseSystemFactory getInstance() {
    return new ScenarioWrapperBaseSystemFactory();
  }

  public static final Identifier DECLARED_NAME_TDL_MAX_INT = Identifier.of("TDL_MAX_INT");
  public static final Identifier DECLARED_NAME_TDL_TIMEOUT = Identifier.of("TDL_TIMEOUT");
  public static final Identifier DECLARED_NAME_TRAPSET_COUNT = Identifier.of("TRAPSET_COUNT");
  public static final Identifier DECLARED_NAME_TDL_TREE_NODE_COUNT =
      Identifier.of("TDL_TREE_NODE_COUNT");
  public static final Identifier DECLARED_NAME_BoundType = Identifier.of("BoundType");
  public static final Identifier DECLARED_NAME_BoundValue = Identifier.of("BoundValue");
  public static final Identifier DECLARED_NAME_TrapsetIndex = Identifier.of("TrapsetIndex");
  public static final Identifier DECLARED_NAME_TdlTreeIndex = Identifier.of("TdlTreeIndex");
  public static final Identifier DECLARED_NAME_BOUND_EQ = Identifier.of("BOUND_EQ");
  public static final Identifier DECLARED_NAME_BOUND_GT = Identifier.of("BOUND_GT");
  public static final Identifier DECLARED_NAME_BOUND_GTE = Identifier.of("BOUND_GTE");
  public static final Identifier DECLARED_NAME_BOUND_LT = Identifier.of("BOUND_LT");
  public static final Identifier DECLARED_NAME_BOUND_LTE = Identifier.of("BOUND_LTE");
  public static final Identifier DECLARED_NAME_TdlActivatorChannels =
      Identifier.of("TdlActivatorChannels");
  public static final Identifier DECLARED_NAME_TdlTerminatorChannels =
      Identifier.of("TdlTerminatorChannels");
  public static final Identifier DECLARED_NAME_TrapsetActivatorChannels =
      Identifier.of("TrapsetActivatorChannels");
  public static final Identifier DECLARED_NAME_TrapsetTerminatorChannels =
      Identifier.of("TrapsetTerminatorChannels");
  public static final Identifier DECLARED_NAME_TdlDiagnostics = Identifier.of("TdlDiagnostics");
  public static final Identifier DECLARED_NAME_TdlScenarioStopwatch =
      Identifier.of("TdlScenarioStopwatch");
  public static final Identifier DECLARED_NAME_TdlBoundedLeadsToRecognizer =
      Identifier.of("TdlBoundedLeadsToRecognizer");
  public static final Identifier DECLARED_NAME_TdlBoundedRepetitionRecognizer =
      Identifier.of("TdlBoundedRepetitionRecognizer");
  public static final Identifier DECLARED_NAME_TdlConjunctionRecognizer =
      Identifier.of("TdlConjunctionRecognizer");
  public static final Identifier DECLARED_NAME_TdlDisjunctionRecognizer =
      Identifier.of("TdlDisjunctionRecognizer");
  public static final Identifier DECLARED_NAME_TdlLeadsToRecognizer =
      Identifier.of("TdlLeadsToRecognizer");
  public static final Identifier DECLARED_NAME_TdlQuantificationRecognizer =
      Identifier.of("TdlQuantificationRecognizer");
  public static final Identifier DECLARED_NAME_TdlTrivialTrueRecognizer =
      Identifier.of("TdlTrivialTrueRecognizer");
  public static final Identifier DECLARED_NAME_TdlTrivialFalseRecognizer =
      Identifier.of("TdlTrivialFalseRecognizer");

  protected ScenarioWrapperBaseSystemFactory() {}

  protected VariableDeclaration new_TDL_MAX_INTDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TDL_MAX_INT"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(BaseTypeIdentifiers.INTEGER)))
        .setInitializer(
            new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("32767")));
  }

  protected VariableDeclaration new_TDL_TIMEOUTDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TDL_TIMEOUT"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(BaseTypeIdentifiers.INTEGER)))
        .setInitializer(
            new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("10000")));
  }

  protected VariableDeclaration new_TRAPSET_COUNTDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TRAPSET_COUNT"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(BaseTypeIdentifiers.INTEGER)))
        .setInitializer(new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("1")));
  }

  protected VariableDeclaration new_TDL_TREE_NODE_COUNTDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TDL_TREE_NODE_COUNT"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(BaseTypeIdentifiers.INTEGER)))
        .setInitializer(new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("1")));
  }

  protected TypeDeclaration new_BoundTypeDeclaration() {
    return new TypeDeclaration()
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(
                            BoundedIntegerTypeId.of(
                                NaturalNumberLiteral.of("1"), NaturalNumberLiteral.of("5")))))
        .setIdentifier(Identifier.of("BoundType"));
  }

  protected TypeDeclaration new_BoundValueDeclaration() {
    return new TypeDeclaration()
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(
                            BoundedIntegerTypeId.of(
                                NaturalNumberLiteral.of("0"),
                                IdentifierExpression.of("TDL_MAX_INT")))))
        .setIdentifier(Identifier.of("BoundValue"));
  }

  protected TypeDeclaration new_TrapsetIndexDeclaration() {
    return new TypeDeclaration()
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(
                            BoundedIntegerTypeId.of(
                                NaturalNumberLiteral.of("0"),
                                new SubtractionExpression()
                                    .setLeftChild(IdentifierExpression.of("TRAPSET_COUNT"))
                                    .setRightChild(NaturalNumberLiteral.of("1"))))))
        .setIdentifier(Identifier.of("TrapsetIndex"));
  }

  protected TypeDeclaration new_TdlTreeIndexDeclaration() {
    return new TypeDeclaration()
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(
                            BoundedIntegerTypeId.of(
                                NaturalNumberLiteral.of("0"),
                                new SubtractionExpression()
                                    .setLeftChild(IdentifierExpression.of("TDL_TREE_NODE_COUNT"))
                                    .setRightChild(NaturalNumberLiteral.of("1"))))))
        .setIdentifier(Identifier.of("TdlTreeIndex"));
  }

  protected VariableDeclaration new_BOUND_EQDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("BOUND_EQ"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))))
        .setInitializer(new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("1")));
  }

  protected VariableDeclaration new_BOUND_GTDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("BOUND_GT"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))))
        .setInitializer(new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("2")));
  }

  protected VariableDeclaration new_BOUND_GTEDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("BOUND_GTE"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))))
        .setInitializer(new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("3")));
  }

  protected VariableDeclaration new_BOUND_LTDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("BOUND_LT"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))))
        .setInitializer(new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("4")));
  }

  protected VariableDeclaration new_BOUND_LTEDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("BOUND_LTE"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))))
        .setInitializer(new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("5")));
  }

  protected VariableDeclaration new_TdlActivatorChannelsDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TdlActivatorChannels"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.BROADCAST)
                        .setTypeId(BaseTypeIdentifiers.CHANNEL))
                .addArrayModifier(
                    new SizeExpressionArrayModifier()
                        .setSizeSpecifier(IdentifierExpression.of("TdlTreeIndex"))));
  }

  protected VariableDeclaration new_TdlTerminatorChannelsDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TdlTerminatorChannels"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.BROADCAST)
                        .setTypeId(BaseTypeIdentifiers.CHANNEL))
                .addArrayModifier(
                    new SizeExpressionArrayModifier()
                        .setSizeSpecifier(IdentifierExpression.of("TdlTreeIndex"))));
  }

  protected VariableDeclaration new_TrapsetActivatorChannelsDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TrapsetActivatorChannels"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.BROADCAST)
                        .setTypeId(BaseTypeIdentifiers.CHANNEL))
                .addArrayModifier(
                    new SizeExpressionArrayModifier()
                        .setSizeSpecifier(IdentifierExpression.of("TrapsetIndex"))));
  }

  protected VariableDeclaration new_TrapsetTerminatorChannelsDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TrapsetTerminatorChannels"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.BROADCAST)
                        .setTypeId(BaseTypeIdentifiers.CHANNEL))
                .addArrayModifier(
                    new SizeExpressionArrayModifier()
                        .setSizeSpecifier(IdentifierExpression.of("TrapsetIndex"))));
  }

  protected VariableDeclaration new_TdlDiagnosticsDeclaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("TdlDiagnostics"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(BaseTypeIdentifiers.BOOLEAN))
                .addArrayModifier(
                    new SizeExpressionArrayModifier()
                        .setSizeSpecifier(IdentifierExpression.of("TdlTreeIndex"))));
  }

  protected Template new_TdlScenarioStopwatchTemplate() {
    return TdlScenarioStopwatchTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlBoundedLeadsToRecognizerTemplate() {
    return TdlBoundedLeadsToRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlBoundedRepetitionRecognizerTemplate() {
    return TdlBoundedRepetitionRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlConjunctionRecognizerTemplate() {
    return TdlConjunctionRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlDisjunctionRecognizerTemplate() {
    return TdlDisjunctionRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlLeadsToRecognizerTemplate() {
    return TdlLeadsToRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlQuantificationRecognizerTemplate() {
    return TdlQuantificationRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlTrivialTrueRecognizerTemplate() {
    return TdlTrivialTrueRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlTrivialFalseRecognizerTemplate() {
    return TdlTrivialFalseRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected SystemDefinition newSystemDefinition() {
    return ScenarioWrapperBaseSystemDefinitionFactory.getInstance().newSystemDefinition();
  }

  public UtaSystem constructSystem() {
    UtaSystem ScenarioWrapperBase = new UtaSystem();

    // Set global declarations:
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TDL_MAX_INTDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TDL_TIMEOUTDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TRAPSET_COUNTDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TDL_TREE_NODE_COUNTDeclaration());
    CollectionUtils.addIfNonNull(ScenarioWrapperBase.getDeclarations(), new_BoundTypeDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_BoundValueDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TrapsetIndexDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TdlTreeIndexDeclaration());
    CollectionUtils.addIfNonNull(ScenarioWrapperBase.getDeclarations(), new_BOUND_EQDeclaration());
    CollectionUtils.addIfNonNull(ScenarioWrapperBase.getDeclarations(), new_BOUND_GTDeclaration());
    CollectionUtils.addIfNonNull(ScenarioWrapperBase.getDeclarations(), new_BOUND_GTEDeclaration());
    CollectionUtils.addIfNonNull(ScenarioWrapperBase.getDeclarations(), new_BOUND_LTDeclaration());
    CollectionUtils.addIfNonNull(ScenarioWrapperBase.getDeclarations(), new_BOUND_LTEDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TdlActivatorChannelsDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TdlTerminatorChannelsDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TrapsetActivatorChannelsDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TrapsetTerminatorChannelsDeclaration());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getDeclarations(), new_TdlDiagnosticsDeclaration());

    // Set templates:
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlScenarioStopwatchTemplate());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlBoundedLeadsToRecognizerTemplate());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlBoundedRepetitionRecognizerTemplate());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlConjunctionRecognizerTemplate());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlDisjunctionRecognizerTemplate());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlLeadsToRecognizerTemplate());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlQuantificationRecognizerTemplate());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlTrivialTrueRecognizerTemplate());
    CollectionUtils.addIfNonNull(
        ScenarioWrapperBase.getTemplates(), new_TdlTrivialFalseRecognizerTemplate());
    // Set system definition:
    SystemDefinition systemDefinition = newSystemDefinition();
    if (systemDefinition != null) {
      ScenarioWrapperBase.setSystemDefinition(systemDefinition);
    }
    return ScenarioWrapperBase;
  }
}
