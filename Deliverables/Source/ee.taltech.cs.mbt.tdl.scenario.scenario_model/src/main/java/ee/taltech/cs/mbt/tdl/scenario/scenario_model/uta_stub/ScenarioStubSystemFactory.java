package ee.taltech.cs.mbt.tdl.scenario.scenario_model.uta_stub;

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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.StructTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.CommentLabel;
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

public class ScenarioStubSystemFactory {
  public static class TdlConjunctionRecognizerTemplateFactory {
    public static TdlConjunctionRecognizerTemplateFactory getInstance() {
      return new TdlConjunctionRecognizerTemplateFactory();
    }

    public static final Identifier NAME = Identifier.of("TdlConjunctionRecognizer");

    public static TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_treeIndex,
        AbsExpression arg_leftOpIndex,
        AbsExpression arg_rightOpIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(NAME);

      // Set arguments/parameters:
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("treeIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_leftOpIndex != null) {
        inst.addArgument(arg_leftOpIndex);
      } else { // Either provide leftOpIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("leftOpIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_rightOpIndex != null) {
        inst.addArgument(arg_rightOpIndex);
      } else { // Either provide rightOpIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("rightOpIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }

      return inst;
    }

    protected TdlConjunctionRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_treeIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_leftOpIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("leftOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_rightOpIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rightOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected Location newId5Location() {
      return new Location()
          .setId("id5")
          .setName(
              new LocationName().setName("End").setCoordinates(GuiCoordinates.of(-2000, -1144)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1992, -1112));
    }

    protected Location newId7Location() {
      return new Location()
          .setId("id7")
          .setName(
              new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-3280, -1032)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-3272, -1000));
    }

    protected Location newId0Location() {
      return new Location()
          .setId("id0")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2248, -1000));
    }

    protected Location newId2Location() {
      return new Location()
          .setId("id2")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2248, -1112));
    }

    protected Location newId1Location() {
      return new Location()
          .setId("id1")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2520, -1112));
    }

    protected Location newId6Location() {
      return new Location()
          .setId("id6")
          .setName(
              new LocationName().setName("Ready").setCoordinates(GuiCoordinates.of(-2512, -992)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2520, -1000));
    }

    protected Location newId3Location() {
      return new Location()
          .setId("id3")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2776, -1000));
    }

    protected Location newId4Location() {
      return new Location()
          .setId("id4")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-3024, -1000));
    }

    protected Transition newId5ToId7Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(-1992, -936))
          .addNail(GuiCoordinates.of(-3272, -936));
    }

    protected Transition newId0ToId2Transition(Location source, Location target) {
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

    protected Transition newId1ToId2Transition(Location source, Location target) {
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

    protected Transition newId6ToId1Transition(Location source, Location target) {
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

    protected Transition newId6ToId0Transition(Location source, Location target) {
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

    protected Transition newId3ToId6Transition(Location source, Location target) {
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

    protected Transition newId4ToId3Transition(Location source, Location target) {
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

    protected Transition newId2ToId5Transition(Location source, Location target) {
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

    protected Transition newId7ToId4Transition(Location source, Location target) {
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

    public Template newTemplate() {
      Template TdlConjunctionRecognizer = new Template();

      // Template name:
      Identifier identifier = Identifier.of("TdlConjunctionRecognizer");
      TdlConjunctionRecognizer.setName(identifier);

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlConjunctionRecognizer.getParameters(), new_treeIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlConjunctionRecognizer.getParameters(), new_leftOpIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlConjunctionRecognizer.getParameters(), new_rightOpIndex_ParameterDeclaration());

      // Set local declarations:

      // Set locations:
      Location locationId5 = newId5Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId5);

      Location locationId7 = newId7Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId7);
      TdlConjunctionRecognizer.setInitialLocation(locationId7);
      Location locationId0 = newId0Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId0);

      Location locationId2 = newId2Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId2);

      Location locationId1 = newId1Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId1);

      Location locationId6 = newId6Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId6);

      Location locationId3 = newId3Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId3);

      Location locationId4 = newId4Location();
      TdlConjunctionRecognizer.getLocationGraph().addVertex(locationId4);

      // Set transitions:
      Transition transitionId5ToId7 = newId5ToId7Transition(locationId5, locationId7);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId5, locationId7, transitionId5ToId7);
      Transition transitionId0ToId2 = newId0ToId2Transition(locationId0, locationId2);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId0, locationId2, transitionId0ToId2);
      Transition transitionId1ToId2 = newId1ToId2Transition(locationId1, locationId2);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId1, locationId2, transitionId1ToId2);
      Transition transitionId6ToId1 = newId6ToId1Transition(locationId6, locationId1);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId1, transitionId6ToId1);
      Transition transitionId6ToId0 = newId6ToId0Transition(locationId6, locationId0);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId6, locationId0, transitionId6ToId0);
      Transition transitionId3ToId6 = newId3ToId6Transition(locationId3, locationId6);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId3, locationId6, transitionId3ToId6);
      Transition transitionId4ToId3 = newId4ToId3Transition(locationId4, locationId3);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId4, locationId3, transitionId4ToId3);
      Transition transitionId2ToId5 = newId2ToId5Transition(locationId2, locationId5);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId2, locationId5, transitionId2ToId5);
      Transition transitionId7ToId4 = newId7ToId4Transition(locationId7, locationId4);
      TdlConjunctionRecognizer.getLocationGraph()
          .addEdge(locationId7, locationId4, transitionId7ToId4);

      return TdlConjunctionRecognizer;
    }
  }

  public static class TdlDisjunctionRecognizerTemplateFactory {
    public static TdlDisjunctionRecognizerTemplateFactory getInstance() {
      return new TdlDisjunctionRecognizerTemplateFactory();
    }

    public static final Identifier NAME = Identifier.of("TdlDisjunctionRecognizer");

    public static TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_treeIndex,
        AbsExpression arg_leftOpIndex,
        AbsExpression arg_rightOpIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(NAME);

      // Set arguments/parameters:
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("treeIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_leftOpIndex != null) {
        inst.addArgument(arg_leftOpIndex);
      } else { // Either provide leftOpIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("leftOpIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_rightOpIndex != null) {
        inst.addArgument(arg_rightOpIndex);
      } else { // Either provide rightOpIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("rightOpIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }

      return inst;
    }

    protected TdlDisjunctionRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_treeIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_leftOpIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("leftOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_rightOpIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rightOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected Location newId9Location() {
      return new Location()
          .setId("id9")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1000, -600));
    }

    protected Location newId8Location() {
      return new Location()
          .setId("id8")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(-760, -632)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-752, -600));
    }

    protected Location newId10Location() {
      return new Location()
          .setId("id10")
          .setName(
              new LocationName().setName("Ready").setCoordinates(GuiCoordinates.of(-1288, -512)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1296, -520));
    }

    protected Location newId11Location() {
      return new Location()
          .setId("id11")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1552, -520));
    }

    protected Location newId12Location() {
      return new Location()
          .setId("id12")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1792, -520));
    }

    protected Location newId13Location() {
      return new Location()
          .setId("id13")
          .setName(
              new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-2040, -552)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-2032, -520));
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

    protected Transition newId10ToId9Transition_Nr1(Location source, Location target) {
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

    protected Transition newId10ToId9Transition_Nr2(Location source, Location target) {
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

    protected Transition newId11ToId10Transition(Location source, Location target) {
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

    protected Transition newId12ToId11Transition(Location source, Location target) {
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

    protected Transition newId13ToId12Transition(Location source, Location target) {
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

    protected Transition newId8ToId13Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(-752, -456))
          .addNail(GuiCoordinates.of(-2032, -456));
    }

    public Template newTemplate() {
      Template TdlDisjunctionRecognizer = new Template();

      // Template name:
      Identifier identifier = Identifier.of("TdlDisjunctionRecognizer");
      TdlDisjunctionRecognizer.setName(identifier);

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlDisjunctionRecognizer.getParameters(), new_treeIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlDisjunctionRecognizer.getParameters(), new_leftOpIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlDisjunctionRecognizer.getParameters(), new_rightOpIndex_ParameterDeclaration());

      // Set local declarations:

      // Set locations:
      Location locationId9 = newId9Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId9);

      Location locationId8 = newId8Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId8);

      Location locationId10 = newId10Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId10);

      Location locationId11 = newId11Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId11);

      Location locationId12 = newId12Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId12);

      Location locationId13 = newId13Location();
      TdlDisjunctionRecognizer.getLocationGraph().addVertex(locationId13);
      TdlDisjunctionRecognizer.setInitialLocation(locationId13);

      // Set transitions:
      Transition transitionId9ToId8 = newId9ToId8Transition(locationId9, locationId8);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId9, locationId8, transitionId9ToId8);
      Transition transitionId10ToId9_Nr1 = newId10ToId9Transition_Nr1(locationId10, locationId9);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId10, locationId9, transitionId10ToId9_Nr1);
      Transition transitionId10ToId9_Nr2 = newId10ToId9Transition_Nr2(locationId10, locationId9);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId10, locationId9, transitionId10ToId9_Nr2);
      Transition transitionId11ToId10 = newId11ToId10Transition(locationId11, locationId10);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId11, locationId10, transitionId11ToId10);
      Transition transitionId12ToId11 = newId12ToId11Transition(locationId12, locationId11);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId12, locationId11, transitionId12ToId11);
      Transition transitionId13ToId12 = newId13ToId12Transition(locationId13, locationId12);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId13, locationId12, transitionId13ToId12);
      Transition transitionId8ToId13 = newId8ToId13Transition(locationId8, locationId13);
      TdlDisjunctionRecognizer.getLocationGraph()
          .addEdge(locationId8, locationId13, transitionId8ToId13);

      return TdlDisjunctionRecognizer;
    }
  }

  public static class TdlQuantificationRecognizerTemplateFactory {
    public static TdlQuantificationRecognizerTemplateFactory getInstance() {
      return new TdlQuantificationRecognizerTemplateFactory();
    }

    public static final Identifier NAME = Identifier.of("TdlQuantificationRecognizer");

    public static final Identifier DECLARED_NAME_negatedUniversalQuantification =
        Identifier.of("negatedUniversalQuantification");
    public static final Identifier DECLARED_NAME_negatedExistentialQuantification =
        Identifier.of("negatedExistentialQuantification");
    public static final Identifier DECLARED_NAME_universalQuantification =
        Identifier.of("universalQuantification");
    public static final Identifier DECLARED_NAME_existentialQuantification =
        Identifier.of("existentialQuantification");

    public static TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_universal,
        AbsExpression arg_negated,
        AbsExpression arg_treeIndex,
        AbsExpression arg_trapset) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(NAME);

      // Set arguments/parameters:
      if (arg_universal != null) {
        inst.addArgument(arg_universal);
      } else { // Either provide universal argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("universal"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(BaseTypeIdentifiers.BOOLEAN))));
      }
      if (arg_negated != null) {
        inst.addArgument(arg_negated);
      } else { // Either provide negated argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("negated"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(BaseTypeIdentifiers.BOOLEAN))));
      }
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("treeIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_trapset != null) {
        inst.addArgument(arg_trapset);
      } else { // Either provide trapset argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("trapset"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.NONE)
                                .setTypeId(CustomTypeId.of(Identifier.of("Trapset"))))
                        .setReferenceType(true)));
      }

      return inst;
    }

    protected TdlQuantificationRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_universal_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("universal"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)));
    }

    protected ParameterDeclaration new_negated_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("negated"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(BaseTypeIdentifiers.BOOLEAN)));
    }

    protected ParameterDeclaration new_treeIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_trapset_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("trapset"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.NONE)
                          .setTypeId(CustomTypeId.of(Identifier.of("Trapset"))))
                  .setReferenceType(true));
    }

    protected VariableDeclaration new_negatedUniversalQuantification_Declaration() {
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

    protected VariableDeclaration new_negatedExistentialQuantification_Declaration() {
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

    protected VariableDeclaration new_universalQuantification_Declaration() {
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

    protected VariableDeclaration new_existentialQuantification_Declaration() {
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

    protected Location newId16Location() {
      return new Location()
          .setId("id16")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-552, -8));
    }

    protected Location newId14Location() {
      return new Location()
          .setId("id14")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-104, -8));
    }

    protected Location newId15Location() {
      return new Location()
          .setId("id15")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(128, -40)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(144, -8));
    }

    protected Location newId17Location() {
      return new Location()
          .setId("id17")
          .setName(new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-800, -40)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-792, -8));
    }

    protected Transition newId16ToId14Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-488, 8))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(
                                          IdentifierExpression.of(
                                              "negatedExistentialQuantification"))
                                      .setRightChild(
                                          new GroupedExpression()
                                              .setChild(
                                                  new EqualityExpression()
                                                      .setLeftChild(
                                                          new FieldAccessExpression()
                                                              .setIdentifier(Identifier.of("flags"))
                                                              .setChild(
                                                                  IdentifierExpression.of(
                                                                      "trapset")))
                                                      .setRightChild(
                                                          NaturalNumberLiteral.of("0"))))))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-488, 32))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of(
                                                      "TrapsetActivatorChannels"))
                                              .setRightChild(
                                                  new FieldAccessExpression()
                                                      .setIdentifier(Identifier.of("index"))
                                                      .setChild(
                                                          IdentifierExpression.of("trapset")))))))
          .addNail(GuiCoordinates.of(-552, 32))
          .addNail(GuiCoordinates.of(-104, 32));
    }

    protected Transition newId16ToId14Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-496, -96))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(
                                          IdentifierExpression.of("negatedUniversalQuantification"))
                                      .setRightChild(
                                          new GroupedExpression()
                                              .setChild(
                                                  new InequalityExpression()
                                                      .setLeftChild(
                                                          new FieldAccessExpression()
                                                              .setIdentifier(Identifier.of("flags"))
                                                              .setChild(
                                                                  IdentifierExpression.of(
                                                                      "trapset")))
                                                      .setRightChild(
                                                          new FieldAccessExpression()
                                                              .setIdentifier(
                                                                  Identifier.of("fullMask"))
                                                              .setChild(
                                                                  IdentifierExpression.of(
                                                                      "trapset")))))))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-496, -72))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of(
                                                      "TrapsetActivatorChannels"))
                                              .setRightChild(
                                                  new FieldAccessExpression()
                                                      .setIdentifier(Identifier.of("index"))
                                                      .setChild(
                                                          IdentifierExpression.of("trapset")))))))
          .addNail(GuiCoordinates.of(-552, -72))
          .addNail(GuiCoordinates.of(-104, -72));
    }

    protected Transition newId16ToId14Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-496, -144))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(
                                          IdentifierExpression.of("universalQuantification"))
                                      .setRightChild(
                                          new GroupedExpression()
                                              .setChild(
                                                  new EqualityExpression()
                                                      .setLeftChild(
                                                          new FieldAccessExpression()
                                                              .setIdentifier(Identifier.of("flags"))
                                                              .setChild(
                                                                  IdentifierExpression.of(
                                                                      "trapset")))
                                                      .setRightChild(
                                                          new FieldAccessExpression()
                                                              .setIdentifier(
                                                                  Identifier.of("fullMask"))
                                                              .setChild(
                                                                  IdentifierExpression.of(
                                                                      "trapset")))))))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-496, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of(
                                                      "TrapsetActivatorChannels"))
                                              .setRightChild(
                                                  new FieldAccessExpression()
                                                      .setIdentifier(Identifier.of("index"))
                                                      .setChild(
                                                          IdentifierExpression.of("trapset")))))))
          .addNail(GuiCoordinates.of(-552, -120))
          .addNail(GuiCoordinates.of(-104, -120))
          .addNail(GuiCoordinates.of(-104, -80));
    }

    protected Transition newId14ToId15Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-88, -32))
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
                              .setCoordinates(GuiCoordinates.of(-88, 0))
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

    protected Transition newId15ToId17Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-408, 136))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new CallExpression()
                                              .addArgument(IdentifierExpression.of("trapset"))
                                              .setChild(IdentifierExpression.of("resetTrapset")))
                                      .build())))
          .addNail(GuiCoordinates.of(144, 160))
          .addNail(GuiCoordinates.of(-792, 160));
    }

    protected Transition newId16ToId14Transition_Nr4(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-488, 72))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(
                                          IdentifierExpression.of("existentialQuantification"))
                                      .setRightChild(
                                          new GroupedExpression()
                                              .setChild(
                                                  new GreaterThanExpression()
                                                      .setLeftChild(
                                                          new FieldAccessExpression()
                                                              .setIdentifier(Identifier.of("flags"))
                                                              .setChild(
                                                                  IdentifierExpression.of(
                                                                      "trapset")))
                                                      .setRightChild(
                                                          NaturalNumberLiteral.of("0"))))))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-488, 96))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of(
                                                      "TrapsetActivatorChannels"))
                                              .setRightChild(
                                                  new FieldAccessExpression()
                                                      .setIdentifier(Identifier.of("index"))
                                                      .setChild(
                                                          IdentifierExpression.of("trapset")))))))
          .addNail(GuiCoordinates.of(-552, 96))
          .addNail(GuiCoordinates.of(-104, 96));
    }

    protected Transition newId17ToId16Transition(Location source, Location target) {
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

    public Template newTemplate() {
      Template TdlQuantificationRecognizer = new Template();

      // Template name:
      Identifier identifier = Identifier.of("TdlQuantificationRecognizer");
      TdlQuantificationRecognizer.setName(identifier);

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_universal_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_negated_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_treeIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getParameters(), new_trapset_ParameterDeclaration());

      // Set local declarations:
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(),
          new_negatedUniversalQuantification_Declaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(),
          new_negatedExistentialQuantification_Declaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(), new_universalQuantification_Declaration());
      CollectionUtils.addIfNonNull(
          TdlQuantificationRecognizer.getDeclarations(),
          new_existentialQuantification_Declaration());

      // Set locations:
      Location locationId16 = newId16Location();
      TdlQuantificationRecognizer.getLocationGraph().addVertex(locationId16);

      Location locationId14 = newId14Location();
      TdlQuantificationRecognizer.getLocationGraph().addVertex(locationId14);

      Location locationId15 = newId15Location();
      TdlQuantificationRecognizer.getLocationGraph().addVertex(locationId15);

      Location locationId17 = newId17Location();
      TdlQuantificationRecognizer.getLocationGraph().addVertex(locationId17);
      TdlQuantificationRecognizer.setInitialLocation(locationId17);

      // Set transitions:
      Transition transitionId16ToId14_Nr1 = newId16ToId14Transition_Nr1(locationId16, locationId14);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId16, locationId14, transitionId16ToId14_Nr1);
      Transition transitionId16ToId14_Nr2 = newId16ToId14Transition_Nr2(locationId16, locationId14);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId16, locationId14, transitionId16ToId14_Nr2);
      Transition transitionId16ToId14_Nr3 = newId16ToId14Transition_Nr3(locationId16, locationId14);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId16, locationId14, transitionId16ToId14_Nr3);
      Transition transitionId14ToId15 = newId14ToId15Transition(locationId14, locationId15);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId14, locationId15, transitionId14ToId15);
      Transition transitionId15ToId17 = newId15ToId17Transition(locationId15, locationId17);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId15, locationId17, transitionId15ToId17);
      Transition transitionId16ToId14_Nr4 = newId16ToId14Transition_Nr4(locationId16, locationId14);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId16, locationId14, transitionId16ToId14_Nr4);
      Transition transitionId17ToId16 = newId17ToId16Transition(locationId17, locationId16);
      TdlQuantificationRecognizer.getLocationGraph()
          .addEdge(locationId17, locationId16, transitionId17ToId16);

      return TdlQuantificationRecognizer;
    }
  }

  public static class TdlLeadsToRecognizerTemplateFactory {
    public static TdlLeadsToRecognizerTemplateFactory getInstance() {
      return new TdlLeadsToRecognizerTemplateFactory();
    }

    public static final Identifier NAME = Identifier.of("TdlLeadsToRecognizer");

    public static TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_treeIndex,
        AbsExpression arg_leftOpIndex,
        AbsExpression arg_rightOpIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(NAME);

      // Set arguments/parameters:
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("treeIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_leftOpIndex != null) {
        inst.addArgument(arg_leftOpIndex);
      } else { // Either provide leftOpIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("leftOpIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_rightOpIndex != null) {
        inst.addArgument(arg_rightOpIndex);
      } else { // Either provide rightOpIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("rightOpIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }

      return inst;
    }

    protected TdlLeadsToRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_treeIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_leftOpIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("leftOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_rightOpIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rightOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected Location newId18Location() {
      return new Location()
          .setId("id18")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(288, -448)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(296, -416));
    }

    protected Location newId24Location() {
      return new Location()
          .setId("id24")
          .setName(
              new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-1208, -448)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1200, -416));
    }

    protected Location newId19Location() {
      return new Location()
          .setId("id19")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(48, -416));
    }

    protected Location newId20Location() {
      return new Location()
          .setId("id20")
          .setName(
              new LocationName()
                  .setName("ReadyForRightOp")
                  .setCoordinates(GuiCoordinates.of(-264, -448)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-216, -416));
    }

    protected Location newId21Location() {
      return new Location()
          .setId("id21")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-464, -416));
    }

    protected Location newId22Location() {
      return new Location()
          .setId("id22")
          .setName(
              new LocationName()
                  .setName("ReadyForLeftOp")
                  .setCoordinates(GuiCoordinates.of(-768, -448)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-720, -416));
    }

    protected Location newId23Location() {
      return new Location()
          .setId("id23")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-952, -416));
    }

    protected Transition newId18ToId24Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(296, -360))
          .addNail(GuiCoordinates.of(-1200, -360));
    }

    protected Transition newId19ToId18Transition(Location source, Location target) {
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

    protected Transition newId20ToId19Transition(Location source, Location target) {
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

    protected Transition newId21ToId20Transition(Location source, Location target) {
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

    protected Transition newId22ToId21Transition(Location source, Location target) {
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

    protected Transition newId23ToId22Transition(Location source, Location target) {
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

    protected Transition newId24ToId23Transition(Location source, Location target) {
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

    public Template newTemplate() {
      Template TdlLeadsToRecognizer = new Template();

      // Template name:
      Identifier identifier = Identifier.of("TdlLeadsToRecognizer");
      TdlLeadsToRecognizer.setName(identifier);

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlLeadsToRecognizer.getParameters(), new_treeIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlLeadsToRecognizer.getParameters(), new_leftOpIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlLeadsToRecognizer.getParameters(), new_rightOpIndex_ParameterDeclaration());

      // Set local declarations:

      // Set locations:
      Location locationId18 = newId18Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId18);

      Location locationId24 = newId24Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId24);
      TdlLeadsToRecognizer.setInitialLocation(locationId24);
      Location locationId19 = newId19Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId19);

      Location locationId20 = newId20Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId20);

      Location locationId21 = newId21Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId21);

      Location locationId22 = newId22Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId22);

      Location locationId23 = newId23Location();
      TdlLeadsToRecognizer.getLocationGraph().addVertex(locationId23);

      // Set transitions:
      Transition transitionId18ToId24 = newId18ToId24Transition(locationId18, locationId24);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId18, locationId24, transitionId18ToId24);
      Transition transitionId19ToId18 = newId19ToId18Transition(locationId19, locationId18);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId19, locationId18, transitionId19ToId18);
      Transition transitionId20ToId19 = newId20ToId19Transition(locationId20, locationId19);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId20, locationId19, transitionId20ToId19);
      Transition transitionId21ToId20 = newId21ToId20Transition(locationId21, locationId20);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId21, locationId20, transitionId21ToId20);
      Transition transitionId22ToId21 = newId22ToId21Transition(locationId22, locationId21);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId22, locationId21, transitionId22ToId21);
      Transition transitionId23ToId22 = newId23ToId22Transition(locationId23, locationId22);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId23, locationId22, transitionId23ToId22);
      Transition transitionId24ToId23 = newId24ToId23Transition(locationId24, locationId23);
      TdlLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId24, locationId23, transitionId24ToId23);

      return TdlLeadsToRecognizer;
    }
  }

  public static class TdlBoundedLeadsToRecognizerTemplateFactory {
    public static TdlBoundedLeadsToRecognizerTemplateFactory getInstance() {
      return new TdlBoundedLeadsToRecognizerTemplateFactory();
    }

    public static final Identifier NAME = Identifier.of("TdlBoundedLeadsToRecognizer");

    public static final Identifier DECLARED_NAME_lessThanBound = Identifier.of("lessThanBound");
    public static final Identifier DECLARED_NAME_lessThanOrEqBound =
        Identifier.of("lessThanOrEqBound");
    public static final Identifier DECLARED_NAME_greaterThanBound =
        Identifier.of("greaterThanBound");
    public static final Identifier DECLARED_NAME_greaterThanOrEqBound =
        Identifier.of("greaterThanOrEqBound");
    public static final Identifier DECLARED_NAME_equalityBound = Identifier.of("equalityBound");
    public static final Identifier DECLARED_NAME_localClock = Identifier.of("localClock");

    public static TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_boundType,
        AbsExpression arg_boundValue,
        AbsExpression arg_treeIndex,
        AbsExpression arg_leftOpIndex,
        AbsExpression arg_rightOpIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(NAME);

      // Set arguments/parameters:
      if (arg_boundType != null) {
        inst.addArgument(arg_boundType);
      } else { // Either provide boundType argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("boundType"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("BoundType"))))));
      }
      if (arg_boundValue != null) {
        inst.addArgument(arg_boundValue);
      } else { // Either provide boundValue argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("boundValue"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("BoundValue"))))));
      }
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("treeIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_leftOpIndex != null) {
        inst.addArgument(arg_leftOpIndex);
      } else { // Either provide leftOpIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("leftOpIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_rightOpIndex != null) {
        inst.addArgument(arg_rightOpIndex);
      } else { // Either provide rightOpIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("rightOpIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }

      return inst;
    }

    protected TdlBoundedLeadsToRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_boundType_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("boundType"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))));
    }

    protected ParameterDeclaration new_boundValue_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("boundValue"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("BoundValue")))));
    }

    protected ParameterDeclaration new_treeIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_leftOpIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("leftOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_rightOpIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("rightOpIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected VariableDeclaration new_lessThanBound_Declaration() {
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

    protected VariableDeclaration new_lessThanOrEqBound_Declaration() {
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

    protected VariableDeclaration new_greaterThanBound_Declaration() {
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

    protected VariableDeclaration new_greaterThanOrEqBound_Declaration() {
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

    protected VariableDeclaration new_equalityBound_Declaration() {
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

    protected VariableDeclaration new_localClock_Declaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("localClock"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.NONE)
                          .setTypeId(BaseTypeIdentifiers.CLOCK)));
    }

    protected Location newId27Location() {
      return new Location()
          .setId("id27")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-232, -96));
    }

    protected Location newId31Location() {
      return new Location()
          .setId("id31")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1304, -96));
    }

    protected Location newId28Location() {
      return new Location()
          .setId("id28")
          .setName(
              new LocationName()
                  .setName("ReadyForRightOp")
                  .setCoordinates(GuiCoordinates.of(-552, -136)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-504, -96));
    }

    protected Location newId26Location() {
      return new Location()
          .setId("id26")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-96, -96));
    }

    protected Location newId25Location() {
      return new Location()
          .setId("id25")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(136, -128)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(152, -96));
    }

    protected Location newId32Location() {
      return new Location()
          .setId("id32")
          .setName(
              new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-1554, -126)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1544, -96));
    }

    protected Location newId29Location() {
      return new Location()
          .setId("id29")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-768, -96));
    }

    protected Location newId30Location() {
      return new Location()
          .setId("id30")
          .setName(
              new LocationName()
                  .setName("ReadyForLeftOp")
                  .setCoordinates(GuiCoordinates.of(-1088, -136)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1040, -96));
    }

    protected Transition newId27ToId31Transition_Nr1(Location source, Location target) {
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

    protected Transition newId27ToId28Transition_Nr1(Location source, Location target) {
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

    protected Transition newId27ToId26Transition_Nr1(Location source, Location target) {
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

    protected Transition newId27ToId28Transition_Nr2(Location source, Location target) {
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

    protected Transition newId27ToId26Transition_Nr2(Location source, Location target) {
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

    protected Transition newId27ToId26Transition_Nr3(Location source, Location target) {
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

    protected Transition newId27ToId31Transition_Nr2(Location source, Location target) {
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

    protected Transition newId26ToId25Transition(Location source, Location target) {
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

    protected Transition newId27ToId26Transition_Nr4(Location source, Location target) {
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

    protected Transition newId27ToId31Transition_Nr3(Location source, Location target) {
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

    protected Transition newId25ToId32Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(152, 40))
          .addNail(GuiCoordinates.of(-1544, 40));
    }

    protected Transition newId27ToId26Transition_Nr5(Location source, Location target) {
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

    protected Transition newId27ToId28Transition_Nr3(Location source, Location target) {
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

    protected Transition newId28ToId27Transition(Location source, Location target) {
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

    protected Transition newId29ToId28Transition(Location source, Location target) {
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

    protected Transition newId30ToId29Transition(Location source, Location target) {
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

    protected Transition newId31ToId30Transition(Location source, Location target) {
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

    protected Transition newId32ToId31Transition(Location source, Location target) {
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

    public Template newTemplate() {
      Template TdlBoundedLeadsToRecognizer = new Template();

      // Template name:
      Identifier identifier = Identifier.of("TdlBoundedLeadsToRecognizer");
      TdlBoundedLeadsToRecognizer.setName(identifier);

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_boundType_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_boundValue_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_treeIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_leftOpIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getParameters(), new_rightOpIndex_ParameterDeclaration());

      // Set local declarations:
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_lessThanBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_lessThanOrEqBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_greaterThanBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_greaterThanOrEqBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_equalityBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedLeadsToRecognizer.getDeclarations(), new_localClock_Declaration());

      // Set locations:
      Location locationId27 = newId27Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId27);

      Location locationId31 = newId31Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId31);

      Location locationId28 = newId28Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId28);

      Location locationId26 = newId26Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId26);

      Location locationId25 = newId25Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId25);

      Location locationId32 = newId32Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId32);
      TdlBoundedLeadsToRecognizer.setInitialLocation(locationId32);
      Location locationId29 = newId29Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId29);

      Location locationId30 = newId30Location();
      TdlBoundedLeadsToRecognizer.getLocationGraph().addVertex(locationId30);

      // Set transitions:
      Transition transitionId27ToId31_Nr1 = newId27ToId31Transition_Nr1(locationId27, locationId31);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId31, transitionId27ToId31_Nr1);
      Transition transitionId27ToId28_Nr1 = newId27ToId28Transition_Nr1(locationId27, locationId28);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId28, transitionId27ToId28_Nr1);
      Transition transitionId27ToId26_Nr1 = newId27ToId26Transition_Nr1(locationId27, locationId26);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId26, transitionId27ToId26_Nr1);
      Transition transitionId27ToId28_Nr2 = newId27ToId28Transition_Nr2(locationId27, locationId28);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId28, transitionId27ToId28_Nr2);
      Transition transitionId27ToId26_Nr2 = newId27ToId26Transition_Nr2(locationId27, locationId26);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId26, transitionId27ToId26_Nr2);
      Transition transitionId27ToId26_Nr3 = newId27ToId26Transition_Nr3(locationId27, locationId26);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId26, transitionId27ToId26_Nr3);
      Transition transitionId27ToId31_Nr2 = newId27ToId31Transition_Nr2(locationId27, locationId31);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId31, transitionId27ToId31_Nr2);
      Transition transitionId26ToId25 = newId26ToId25Transition(locationId26, locationId25);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId26, locationId25, transitionId26ToId25);
      Transition transitionId27ToId26_Nr4 = newId27ToId26Transition_Nr4(locationId27, locationId26);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId26, transitionId27ToId26_Nr4);
      Transition transitionId27ToId31_Nr3 = newId27ToId31Transition_Nr3(locationId27, locationId31);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId31, transitionId27ToId31_Nr3);
      Transition transitionId25ToId32 = newId25ToId32Transition(locationId25, locationId32);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId25, locationId32, transitionId25ToId32);
      Transition transitionId27ToId26_Nr5 = newId27ToId26Transition_Nr5(locationId27, locationId26);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId26, transitionId27ToId26_Nr5);
      Transition transitionId27ToId28_Nr3 = newId27ToId28Transition_Nr3(locationId27, locationId28);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId27, locationId28, transitionId27ToId28_Nr3);
      Transition transitionId28ToId27 = newId28ToId27Transition(locationId28, locationId27);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId28, locationId27, transitionId28ToId27);
      Transition transitionId29ToId28 = newId29ToId28Transition(locationId29, locationId28);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId29, locationId28, transitionId29ToId28);
      Transition transitionId30ToId29 = newId30ToId29Transition(locationId30, locationId29);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId30, locationId29, transitionId30ToId29);
      Transition transitionId31ToId30 = newId31ToId30Transition(locationId31, locationId30);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId31, locationId30, transitionId31ToId30);
      Transition transitionId32ToId31 = newId32ToId31Transition(locationId32, locationId31);
      TdlBoundedLeadsToRecognizer.getLocationGraph()
          .addEdge(locationId32, locationId31, transitionId32ToId31);

      return TdlBoundedLeadsToRecognizer;
    }
  }

  public static class TdlBoundedRepetitionRecognizerTemplateFactory {
    public static TdlBoundedRepetitionRecognizerTemplateFactory getInstance() {
      return new TdlBoundedRepetitionRecognizerTemplateFactory();
    }

    public static final Identifier NAME = Identifier.of("TdlBoundedRepetitionRecognizer");

    public static final Identifier DECLARED_NAME_lessThanBound = Identifier.of("lessThanBound");
    public static final Identifier DECLARED_NAME_lessThanOrEqBound =
        Identifier.of("lessThanOrEqBound");
    public static final Identifier DECLARED_NAME_greaterThanBound =
        Identifier.of("greaterThanBound");
    public static final Identifier DECLARED_NAME_greaterThanOrEqBound =
        Identifier.of("greaterThanOrEqBound");
    public static final Identifier DECLARED_NAME_equalityBound = Identifier.of("equalityBound");
    public static final Identifier DECLARED_NAME_repetitions = Identifier.of("repetitions");

    public static TemplateInstantiation createInstantiation(
        Identifier newTemplateName,
        AbsExpression arg_boundType,
        AbsExpression arg_boundValue,
        AbsExpression arg_treeIndex,
        AbsExpression arg_operandIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(NAME);

      // Set arguments/parameters:
      if (arg_boundType != null) {
        inst.addArgument(arg_boundType);
      } else { // Either provide boundType argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("boundType"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("BoundType"))))));
      }
      if (arg_boundValue != null) {
        inst.addArgument(arg_boundValue);
      } else { // Either provide boundValue argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("boundValue"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("BoundValue"))))));
      }
      if (arg_treeIndex != null) {
        inst.addArgument(arg_treeIndex);
      } else { // Either provide treeIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("treeIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }
      if (arg_operandIndex != null) {
        inst.addArgument(arg_operandIndex);
      } else { // Either provide operandIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("operandIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))));
      }

      return inst;
    }

    protected TdlBoundedRepetitionRecognizerTemplateFactory() {}

    protected ParameterDeclaration new_boundType_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("boundType"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("BoundType")))));
    }

    protected ParameterDeclaration new_boundValue_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("boundValue"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("BoundValue")))));
    }

    protected ParameterDeclaration new_treeIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("treeIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected ParameterDeclaration new_operandIndex_ParameterDeclaration() {
      return new ParameterDeclaration()
          .setIdentifier(Identifier.of("operandIndex"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.CONSTANT)
                          .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex")))));
    }

    protected VariableDeclaration new_lessThanBound_Declaration() {
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

    protected VariableDeclaration new_lessThanOrEqBound_Declaration() {
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

    protected VariableDeclaration new_greaterThanBound_Declaration() {
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

    protected VariableDeclaration new_greaterThanOrEqBound_Declaration() {
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

    protected VariableDeclaration new_equalityBound_Declaration() {
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

    protected VariableDeclaration new_repetitions_Declaration() {
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

    protected Location newId35Location() {
      return new Location()
          .setId("id35")
          .setName(new LocationName().setName("End").setCoordinates(GuiCoordinates.of(222, -70)))
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(232, -40));
    }

    protected Location newId33Location() {
      return new Location()
          .setId("id33")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-752, 88));
    }

    protected Location newId36Location() {
      return new Location()
          .setId("id36")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-400, -40));
    }

    protected Location newId34Location() {
      return new Location()
          .setId("id34")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-16, -40));
    }

    protected Location newId38Location() {
      return new Location()
          .setId("id38")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-944, -40));
    }

    protected Location newId39Location() {
      return new Location()
          .setId("id39")
          .setName(new LocationName().setName("Idle").setCoordinates(GuiCoordinates.of(-1202, -70)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-1192, -40));
    }

    protected Location newId37Location() {
      return new Location()
          .setId("id37")
          .setName(new LocationName().setName("Ready").setCoordinates(GuiCoordinates.of(-696, -72)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-680, -40));
    }

    protected Transition newId35ToId33Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(new TransitionLabels())
          .addNail(GuiCoordinates.of(232, 88));
    }

    protected Transition newId36ToId33Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-744, 32))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("lessThanOrEqBound"))
                                      .setRightChild(
                                          new GreaterThanExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, 56))
          .addNail(GuiCoordinates.of(-752, 56));
    }

    protected Transition newId36ToId33Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-744, 0))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("lessThanBound"))
                                      .setRightChild(
                                          new GreaterThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, 24))
          .addNail(GuiCoordinates.of(-752, 24));
    }

    protected Transition newId36ToId34Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-368, 32))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("lessThanOrEqBound"))
                                      .setRightChild(
                                          new LessThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, 56))
          .addNail(GuiCoordinates.of(-16, 56));
    }

    protected Transition newId36ToId34Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-368, 0))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("lessThanBound"))
                                      .setRightChild(
                                          new LessThanExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, 24))
          .addNail(GuiCoordinates.of(-16, 24));
    }

    protected Transition newId36ToId34Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-368, -160))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanOrEqBound"))
                                      .setRightChild(
                                          new GreaterThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, -136))
          .addNail(GuiCoordinates.of(-16, -136));
    }

    protected Transition newId36ToId34Transition_Nr4(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-368, -128))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanBound"))
                                      .setRightChild(
                                          new GreaterThanExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, -104))
          .addNail(GuiCoordinates.of(-16, -104));
    }

    protected Transition newId36ToId38Transition_Nr1(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-816, -160))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanOrEqBound"))
                                      .setRightChild(
                                          new LessThanExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, -136))
          .addNail(GuiCoordinates.of(-944, -136));
    }

    protected Transition newId36ToId38Transition_Nr2(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-816, -128))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("greaterThanBound"))
                                      .setRightChild(
                                          new LessThanOrEqualExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, -104))
          .addNail(GuiCoordinates.of(-944, -104));
    }

    protected Transition newId34ToId35Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(0, -40))
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
                              .setCoordinates(GuiCoordinates.of(0, -64))
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

    protected Transition newId36ToId38Transition_Nr3(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-816, -96))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("equalityBound"))
                                      .setRightChild(
                                          new LessThanExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, -72))
          .addNail(GuiCoordinates.of(-944, -72));
    }

    protected Transition newId33ToId39Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-1056, 64))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new AssignmentExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(NaturalNumberLiteral.of("0")))
                                      .build())))
          .addNail(GuiCoordinates.of(-1192, 88));
    }

    protected Transition newId36ToId34Transition_Nr5(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-368, -96))
                              .setContent(
                                  new ConjunctionExpression()
                                      .setLeftChild(IdentifierExpression.of("equalityBound"))
                                      .setRightChild(
                                          new EqualityExpression()
                                              .setLeftChild(IdentifierExpression.of("repetitions"))
                                              .setRightChild(
                                                  IdentifierExpression.of("boundValue"))))))
          .addNail(GuiCoordinates.of(-400, -72))
          .addNail(GuiCoordinates.of(-16, -72));
    }

    protected Transition newId37ToId36Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setAssignmentsLabel(
                      (AssignmentsLabel)
                          new AssignmentsLabel()
                              .setCoordinates(GuiCoordinates.of(-584, -64))
                              .setContent(
                                  CollectionUtils.collectionBuilder(new LinkedList<AbsExpression>())
                                      .add(
                                          new PostfixIncrementExpression()
                                              .setChild(IdentifierExpression.of("repetitions")))
                                      .build()))
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-664, -40))
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

    protected Transition newId38ToId37Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-928, -40))
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

    protected Transition newId39ToId38Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-1176, -64))
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

    public Template newTemplate() {
      Template TdlBoundedRepetitionRecognizer = new Template();

      // Template name:
      Identifier identifier = Identifier.of("TdlBoundedRepetitionRecognizer");
      TdlBoundedRepetitionRecognizer.setName(identifier);

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getParameters(), new_boundType_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getParameters(), new_boundValue_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getParameters(), new_treeIndex_ParameterDeclaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getParameters(), new_operandIndex_ParameterDeclaration());

      // Set local declarations:
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_lessThanBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_lessThanOrEqBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_greaterThanBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_greaterThanOrEqBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_equalityBound_Declaration());
      CollectionUtils.addIfNonNull(
          TdlBoundedRepetitionRecognizer.getDeclarations(), new_repetitions_Declaration());

      // Set locations:
      Location locationId35 = newId35Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId35);

      Location locationId33 = newId33Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId33);

      Location locationId36 = newId36Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId36);

      Location locationId34 = newId34Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId34);

      Location locationId38 = newId38Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId38);

      Location locationId39 = newId39Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId39);
      TdlBoundedRepetitionRecognizer.setInitialLocation(locationId39);
      Location locationId37 = newId37Location();
      TdlBoundedRepetitionRecognizer.getLocationGraph().addVertex(locationId37);

      // Set transitions:
      Transition transitionId35ToId33 = newId35ToId33Transition(locationId35, locationId33);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId35, locationId33, transitionId35ToId33);
      Transition transitionId36ToId33_Nr1 = newId36ToId33Transition_Nr1(locationId36, locationId33);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId33, transitionId36ToId33_Nr1);
      Transition transitionId36ToId33_Nr2 = newId36ToId33Transition_Nr2(locationId36, locationId33);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId33, transitionId36ToId33_Nr2);
      Transition transitionId36ToId34_Nr1 = newId36ToId34Transition_Nr1(locationId36, locationId34);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId34, transitionId36ToId34_Nr1);
      Transition transitionId36ToId34_Nr2 = newId36ToId34Transition_Nr2(locationId36, locationId34);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId34, transitionId36ToId34_Nr2);
      Transition transitionId36ToId34_Nr3 = newId36ToId34Transition_Nr3(locationId36, locationId34);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId34, transitionId36ToId34_Nr3);
      Transition transitionId36ToId34_Nr4 = newId36ToId34Transition_Nr4(locationId36, locationId34);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId34, transitionId36ToId34_Nr4);
      Transition transitionId36ToId38_Nr1 = newId36ToId38Transition_Nr1(locationId36, locationId38);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId38, transitionId36ToId38_Nr1);
      Transition transitionId36ToId38_Nr2 = newId36ToId38Transition_Nr2(locationId36, locationId38);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId38, transitionId36ToId38_Nr2);
      Transition transitionId34ToId35 = newId34ToId35Transition(locationId34, locationId35);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId34, locationId35, transitionId34ToId35);
      Transition transitionId36ToId38_Nr3 = newId36ToId38Transition_Nr3(locationId36, locationId38);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId38, transitionId36ToId38_Nr3);
      Transition transitionId33ToId39 = newId33ToId39Transition(locationId33, locationId39);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId33, locationId39, transitionId33ToId39);
      Transition transitionId36ToId34_Nr5 = newId36ToId34Transition_Nr5(locationId36, locationId34);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId36, locationId34, transitionId36ToId34_Nr5);
      Transition transitionId37ToId36 = newId37ToId36Transition(locationId37, locationId36);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId37, locationId36, transitionId37ToId36);
      Transition transitionId38ToId37 = newId38ToId37Transition(locationId38, locationId37);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId38, locationId37, transitionId38ToId37);
      Transition transitionId39ToId38 = newId39ToId38Transition(locationId39, locationId38);
      TdlBoundedRepetitionRecognizer.getLocationGraph()
          .addEdge(locationId39, locationId38, transitionId39ToId38);

      return TdlBoundedRepetitionRecognizer;
    }
  }

  public static class TdlStopwatchTemplateFactory {
    public static TdlStopwatchTemplateFactory getInstance() {
      return new TdlStopwatchTemplateFactory();
    }

    public static final Identifier NAME = Identifier.of("TdlStopwatch");

    public static final Identifier DECLARED_NAME_timeoutClock = Identifier.of("timeoutClock");

    public static TemplateInstantiation createInstantiation(
        Identifier newTemplateName, AbsExpression arg_rootIndex) {
      TemplateInstantiation inst =
          new TemplateInstantiation()
              .setNewTemplateName(newTemplateName)
              .setSourceTemplateName(NAME);

      // Set arguments/parameters:
      if (arg_rootIndex != null) {
        inst.addArgument(arg_rootIndex);
      } else { // Either provide rootIndex argument or leave a parameter:
        inst.addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("rootIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.CONSTANT)
                                .setTypeId(CustomTypeId.of(Identifier.of("TdlTreeIndex"))))
                        .setReferenceType(true)));
      }

      return inst;
    }

    protected TdlStopwatchTemplateFactory() {}

    protected ParameterDeclaration new_rootIndex_ParameterDeclaration() {
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

    protected VariableDeclaration new_timeoutClock_Declaration() {
      return new VariableDeclaration()
          .setIdentifier(Identifier.of("timeoutClock"))
          .setType(
              new Type()
                  .setBaseType(
                      new BaseType()
                          .setPrefix(ETypePrefix.NONE)
                          .setTypeId(BaseTypeIdentifiers.CLOCK)));
    }

    protected Location newId42Location() {
      return new Location()
          .setId("id42")
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(
              new LocationLabels()
                  .setInvariantLabel(
                      (InvariantLabel)
                          new InvariantLabel()
                              .setCoordinates(GuiCoordinates.of(-264, -64))
                              .setContent(
                                  new LessThanOrEqualExpression()
                                      .setLeftChild(IdentifierExpression.of("timeoutClock"))
                                      .setRightChild(IdentifierExpression.of("TDL_TIMEOUT"))))
                  .setCommentLabel((CommentLabel) new CommentLabel().setContent("test")))
          .setCoordinates(GuiCoordinates.of(-280, -56));
    }

    protected Location newId40Location() {
      return new Location()
          .setId("id40")
          .setName(new LocationName().setName("Fail").setCoordinates(GuiCoordinates.of(-136, 48)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-152, 56));
    }

    protected Location newId41Location() {
      return new Location()
          .setId("id41")
          .setName(new LocationName().setName("Pass").setCoordinates(GuiCoordinates.of(-136, -168)))
          .setExitPolicy(ELocationExitPolicy.NORMAL)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-152, -160));
    }

    protected Location newId43Location() {
      return new Location()
          .setId("id43")
          .setExitPolicy(ELocationExitPolicy.COMMITTED)
          .setLabels(new LocationLabels())
          .setCoordinates(GuiCoordinates.of(-528, -56));
    }

    protected Transition newId42ToId40Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setGuardLabel(
                      (GuardLabel)
                          new GuardLabel()
                              .setCoordinates(GuiCoordinates.of(-200, -8))
                              .setContent(
                                  new EqualityExpression()
                                      .setLeftChild(IdentifierExpression.of("timeoutClock"))
                                      .setRightChild(IdentifierExpression.of("TDL_TIMEOUT")))));
    }

    protected Transition newId42ToId41Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setSynchronizationLabel(
                      (SynchronizationLabel)
                          new SynchronizationLabel()
                              .setCoordinates(GuiCoordinates.of(-192, -120))
                              .setContent(
                                  new Synchronization()
                                      .setActiveSync(false)
                                      .setExpression(
                                          new ArrayLookupExpression()
                                              .setLeftChild(
                                                  IdentifierExpression.of("TdlTerminatorChannels"))
                                              .setRightChild(
                                                  IdentifierExpression.of("rootIndex"))))));
    }

    protected Transition newId43ToId42Transition(Location source, Location target) {
      return new Transition()
          .setSource(source)
          .setTarget(target)
          .setLabels(
              new TransitionLabels()
                  .setCommentLabel(
                      (CommentLabel) new CommentLabel().setContent("Placeholder text."))
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
                                      .add(
                                          new CallExpression()
                                              .setChild(IdentifierExpression.of("initTrapsets")))
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

    public Template newTemplate() {
      Template TdlStopwatch = new Template();

      // Template name:
      Identifier identifier = Identifier.of("TdlStopwatch");
      TdlStopwatch.setName(identifier);

      // Set parameter declarations:
      CollectionUtils.addIfNonNull(
          TdlStopwatch.getParameters(), new_rootIndex_ParameterDeclaration());

      // Set local declarations:
      CollectionUtils.addIfNonNull(TdlStopwatch.getDeclarations(), new_timeoutClock_Declaration());

      // Set locations:
      Location locationId42 = newId42Location();
      TdlStopwatch.getLocationGraph().addVertex(locationId42);

      Location locationId40 = newId40Location();
      TdlStopwatch.getLocationGraph().addVertex(locationId40);

      Location locationId41 = newId41Location();
      TdlStopwatch.getLocationGraph().addVertex(locationId41);

      Location locationId43 = newId43Location();
      TdlStopwatch.getLocationGraph().addVertex(locationId43);
      TdlStopwatch.setInitialLocation(locationId43);

      // Set transitions:
      Transition transitionId42ToId40 = newId42ToId40Transition(locationId42, locationId40);
      TdlStopwatch.getLocationGraph().addEdge(locationId42, locationId40, transitionId42ToId40);
      Transition transitionId42ToId41 = newId42ToId41Transition(locationId42, locationId41);
      TdlStopwatch.getLocationGraph().addEdge(locationId42, locationId41, transitionId42ToId41);
      Transition transitionId43ToId42 = newId43ToId42Transition(locationId43, locationId42);
      TdlStopwatch.getLocationGraph().addEdge(locationId43, locationId42, transitionId43ToId42);

      return TdlStopwatch;
    }
  }

  public static class ScenarioStubSystemDefinitionFactory {
    public static ScenarioStubSystemDefinitionFactory getInstance() {
      return new ScenarioStubSystemDefinitionFactory();
    }

    protected ScenarioStubSystemDefinitionFactory() {}

    protected TemplateInstantiation new_TdlSW_Declaration() {
      return new TemplateInstantiation()
          .setNewTemplateName(Identifier.of("TdlSW"))
          .setSourceTemplateName(Identifier.of("TdlStopwatch"))
          .addArgument(NaturalNumberLiteral.of("0"));
    }

    protected static final Identifier ProcessReferenceTdlSW = Identifier.of("TdlSW");

    protected SystemLine newSystemLine() {
      return new SystemLine()
          .addGroup(new ProcessReferenceGroup().addIdentifier(Identifier.of("TdlSW")));
    }

    public SystemDefinition newSystemDefinition() {
      SystemDefinition systemDefinition = new SystemDefinition();

      // Set local declarations:
      CollectionUtils.addIfNonNull(systemDefinition.getDeclarations(), new_TdlSW_Declaration());
      // Set system line:
      systemDefinition.setSystemLine(newSystemLine());
      // Set progress measures:

      return systemDefinition;
    }
  }

  public static ScenarioStubSystemFactory getInstance() {
    return new ScenarioStubSystemFactory();
  }

  public static final Identifier DECLARED_NAME_MAX_INT = Identifier.of("MAX_INT");
  public static final Identifier DECLARED_NAME_TDL_TIMEOUT = Identifier.of("TDL_TIMEOUT");
  public static final Identifier DECLARED_NAME_TDL_TREE_NODE_COUNT =
      Identifier.of("TDL_TREE_NODE_COUNT");
  public static final Identifier DECLARED_NAME_TRAPSET_COUNT = Identifier.of("TRAPSET_COUNT");
  public static final Identifier DECLARED_NAME_MAX_TRAPSET_SIZE = Identifier.of("MAX_TRAPSET_SIZE");
  public static final Identifier DECLARED_NAME_BoundType = Identifier.of("BoundType");
  public static final Identifier DECLARED_NAME_TrapsetIndex = Identifier.of("TrapsetIndex");
  public static final Identifier DECLARED_NAME_TrapsetFlags = Identifier.of("TrapsetFlags");
  public static final Identifier DECLARED_NAME_TrapsetMask = Identifier.of("TrapsetMask");
  public static final Identifier DECLARED_NAME_BoundValue = Identifier.of("BoundValue");
  public static final Identifier DECLARED_NAME_TdlTreeIndex = Identifier.of("TdlTreeIndex");
  public static final Identifier DECLARED_NAME_Trapset = Identifier.of("Trapset");
  public static final Identifier DECLARED_NAME_BitMask = Identifier.of("BitMask");
  public static final Identifier DECLARED_NAME_BIT_MASKS = Identifier.of("BIT_MASKS");
  public static final Identifier DECLARED_NAME_BOUND_EQ = Identifier.of("BOUND_EQ");
  public static final Identifier DECLARED_NAME_BOUND_GT = Identifier.of("BOUND_GT");
  public static final Identifier DECLARED_NAME_BOUND_GTE = Identifier.of("BOUND_GTE");
  public static final Identifier DECLARED_NAME_BOUND_LT = Identifier.of("BOUND_LT");
  public static final Identifier DECLARED_NAME_BOUND_LTE = Identifier.of("BOUND_LTE");
  public static final Identifier DECLARED_NAME_initTrapset = Identifier.of("initTrapset");
  public static final Identifier DECLARED_NAME_setTrapVisited = Identifier.of("setTrapVisited");
  public static final Identifier DECLARED_NAME_resetTrapset = Identifier.of("resetTrapset");
  public static final Identifier DECLARED_NAME_TdlDiagnostics = Identifier.of("TdlDiagnostics");
  public static final Identifier DECLARED_NAME_TdlActivatorChannels =
      Identifier.of("TdlActivatorChannels");
  public static final Identifier DECLARED_NAME_TdlTerminatorChannels =
      Identifier.of("TdlTerminatorChannels");
  public static final Identifier DECLARED_NAME_TrapsetActivatorChannels =
      Identifier.of("TrapsetActivatorChannels");
  public static final Identifier DECLARED_NAME_TrapsetTerminatorChannels =
      Identifier.of("TrapsetTerminatorChannels");
  public static final Identifier DECLARED_NAME_initTrapsets = Identifier.of("initTrapsets");
  public static final Identifier DECLARED_NAME_TdlConjunctionRecognizer =
      Identifier.of("TdlConjunctionRecognizer");
  public static final Identifier DECLARED_NAME_TdlDisjunctionRecognizer =
      Identifier.of("TdlDisjunctionRecognizer");
  public static final Identifier DECLARED_NAME_TdlQuantificationRecognizer =
      Identifier.of("TdlQuantificationRecognizer");
  public static final Identifier DECLARED_NAME_TdlLeadsToRecognizer =
      Identifier.of("TdlLeadsToRecognizer");
  public static final Identifier DECLARED_NAME_TdlBoundedLeadsToRecognizer =
      Identifier.of("TdlBoundedLeadsToRecognizer");
  public static final Identifier DECLARED_NAME_TdlBoundedRepetitionRecognizer =
      Identifier.of("TdlBoundedRepetitionRecognizer");
  public static final Identifier DECLARED_NAME_TdlStopwatch = Identifier.of("TdlStopwatch");

  protected ScenarioStubSystemFactory() {}

  protected VariableDeclaration new_MAX_INT_Declaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("MAX_INT"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(BaseTypeIdentifiers.INTEGER)))
        .setInitializer(
            new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("32767")));
  }

  protected VariableDeclaration new_TDL_TIMEOUT_Declaration() {
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

  protected VariableDeclaration new_TDL_TREE_NODE_COUNT_Declaration() {
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

  protected VariableDeclaration new_TRAPSET_COUNT_Declaration() {
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

  protected VariableDeclaration new_MAX_TRAPSET_SIZE_Declaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("MAX_TRAPSET_SIZE"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(BaseTypeIdentifiers.INTEGER)))
        .setInitializer(new FlatVariableInitializer().setExpression(NaturalNumberLiteral.of("1")));
  }

  protected TypeDeclaration new_BoundType_Declaration() {
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

  protected TypeDeclaration new_TrapsetIndex_Declaration() {
    return new TypeDeclaration()
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(
                            BoundedIntegerTypeId.of(
                                NaturalNumberLiteral.of("0"),
                                IdentifierExpression.of("TRAPSET_COUNT")))))
        .setIdentifier(Identifier.of("TrapsetIndex"));
  }

  protected TypeDeclaration new_TrapsetFlags_Declaration() {
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
                                    .setLeftChild(
                                        new GroupedExpression()
                                            .setChild(
                                                new LeftShiftExpression()
                                                    .setLeftChild(NaturalNumberLiteral.of("1"))
                                                    .setRightChild(
                                                        IdentifierExpression.of(
                                                            "MAX_TRAPSET_SIZE"))))
                                    .setRightChild(NaturalNumberLiteral.of("1"))))))
        .setIdentifier(Identifier.of("TrapsetFlags"));
  }

  protected TypeDeclaration new_TrapsetMask_Declaration() {
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
                                    .setLeftChild(
                                        new GroupedExpression()
                                            .setChild(
                                                new LeftShiftExpression()
                                                    .setLeftChild(NaturalNumberLiteral.of("1"))
                                                    .setRightChild(
                                                        IdentifierExpression.of(
                                                            "MAX_TRAPSET_SIZE"))))
                                    .setRightChild(NaturalNumberLiteral.of("1"))))))
        .setIdentifier(Identifier.of("TrapsetMask"));
  }

  protected TypeDeclaration new_BoundValue_Declaration() {
    return new TypeDeclaration()
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(
                            BoundedIntegerTypeId.of(
                                NaturalNumberLiteral.of("0"), IdentifierExpression.of("MAX_INT")))))
        .setIdentifier(Identifier.of("BoundValue"));
  }

  protected TypeDeclaration new_TdlTreeIndex_Declaration() {
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

  protected TypeDeclaration new_Trapset_Declaration() {
    return new TypeDeclaration()
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(
                            new StructTypeId()
                                .addFieldDeclaration(
                                    new FieldDeclaration()
                                        .setType(
                                            new Type()
                                                .setBaseType(
                                                    new BaseType()
                                                        .setPrefix(ETypePrefix.NONE)
                                                        .setTypeId(
                                                            CustomTypeId.of(
                                                                Identifier.of("TrapsetFlags")))))
                                        .setIdentifier(Identifier.of("flags")))
                                .addFieldDeclaration(
                                    new FieldDeclaration()
                                        .setType(
                                            new Type()
                                                .setBaseType(
                                                    new BaseType()
                                                        .setPrefix(ETypePrefix.NONE)
                                                        .setTypeId(
                                                            CustomTypeId.of(
                                                                Identifier.of("TrapsetMask")))))
                                        .setIdentifier(Identifier.of("fullMask")))
                                .addFieldDeclaration(
                                    new FieldDeclaration()
                                        .setType(
                                            new Type()
                                                .setBaseType(
                                                    new BaseType()
                                                        .setPrefix(ETypePrefix.NONE)
                                                        .setTypeId(
                                                            CustomTypeId.of(
                                                                Identifier.of("TrapsetIndex")))))
                                        .setIdentifier(Identifier.of("index"))))))
        .setIdentifier(Identifier.of("Trapset"));
  }

  protected TypeDeclaration new_BitMask_Declaration() {
    return new TypeDeclaration()
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.NONE)
                        .setTypeId(
                            new StructTypeId()
                                .addFieldDeclaration(
                                    new FieldDeclaration()
                                        .setType(
                                            new Type()
                                                .setBaseType(
                                                    new BaseType()
                                                        .setPrefix(ETypePrefix.NONE)
                                                        .setTypeId(BaseTypeIdentifiers.INTEGER)))
                                        .setIdentifier(Identifier.of("isolated")))
                                .addFieldDeclaration(
                                    new FieldDeclaration()
                                        .setType(
                                            new Type()
                                                .setBaseType(
                                                    new BaseType()
                                                        .setPrefix(ETypePrefix.NONE)
                                                        .setTypeId(BaseTypeIdentifiers.INTEGER)))
                                        .setIdentifier(Identifier.of("unset"))))))
        .setIdentifier(Identifier.of("BitMask"));
  }

  protected VariableDeclaration new_BIT_MASKS_Declaration() {
    return new VariableDeclaration()
        .setIdentifier(Identifier.of("BIT_MASKS"))
        .setType(
            new Type()
                .setBaseType(
                    new BaseType()
                        .setPrefix(ETypePrefix.CONSTANT)
                        .setTypeId(CustomTypeId.of(Identifier.of("BitMask"))))
                .addArrayModifier(
                    new SizeExpressionArrayModifier()
                        .setSizeSpecifier(IdentifierExpression.of("MAX_TRAPSET_SIZE"))))
        .setInitializer(
            new StructuredVariableInitializer()
                .addInitializer(
                    new StructuredVariableInitializer()
                        .addInitializer(
                            new FlatVariableInitializer()
                                .setExpression(
                                    new LeftShiftExpression()
                                        .setLeftChild(NaturalNumberLiteral.of("1"))
                                        .setRightChild(NaturalNumberLiteral.of("0"))))
                        .addInitializer(
                            new FlatVariableInitializer()
                                .setExpression(
                                    new SubtractionExpression()
                                        .setLeftChild(IdentifierExpression.of("MAX_INT"))
                                        .setRightChild(
                                            new GroupedExpression()
                                                .setChild(
                                                    new LeftShiftExpression()
                                                        .setLeftChild(NaturalNumberLiteral.of("1"))
                                                        .setRightChild(
                                                            NaturalNumberLiteral.of("0"))))))));
  }

  protected VariableDeclaration new_BOUND_EQ_Declaration() {
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

  protected VariableDeclaration new_BOUND_GT_Declaration() {
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

  protected VariableDeclaration new_BOUND_GTE_Declaration() {
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

  protected VariableDeclaration new_BOUND_LT_Declaration() {
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

  protected VariableDeclaration new_BOUND_LTE_Declaration() {
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

  protected FunctionDeclaration new_initTrapset_Declaration() {
    return new FunctionDeclaration()
        .setName(Identifier.of("initTrapset"))
        .addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("trapset"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.NONE)
                                .setTypeId(CustomTypeId.of(Identifier.of("Trapset"))))
                        .setReferenceType(true)))
        .addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("index"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.NONE)
                                .setTypeId(CustomTypeId.of(Identifier.of("TrapsetIndex"))))))
        .addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("size"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.NONE)
                                .setTypeId(BaseTypeIdentifiers.INTEGER))))
        .setStatementBlock(
            new StatementBlock()
                .addStatement(
                    new ExpressionStatement()
                        .setExpression(
                            new AssignmentExpression()
                                .setLeftChild(
                                    new FieldAccessExpression()
                                        .setIdentifier(Identifier.of("flags"))
                                        .setChild(IdentifierExpression.of("trapset")))
                                .setRightChild(NaturalNumberLiteral.of("0"))))
                .addStatement(
                    new ExpressionStatement()
                        .setExpression(
                            new AssignmentExpression()
                                .setLeftChild(
                                    new FieldAccessExpression()
                                        .setIdentifier(Identifier.of("index"))
                                        .setChild(IdentifierExpression.of("trapset")))
                                .setRightChild(IdentifierExpression.of("index"))))
                .addStatement(
                    new ExpressionStatement()
                        .setExpression(
                            new AssignmentExpression()
                                .setLeftChild(
                                    new FieldAccessExpression()
                                        .setIdentifier(Identifier.of("fullMask"))
                                        .setChild(IdentifierExpression.of("trapset")))
                                .setRightChild(
                                    new SubtractionExpression()
                                        .setLeftChild(
                                            new GroupedExpression()
                                                .setChild(
                                                    new LeftShiftExpression()
                                                        .setLeftChild(NaturalNumberLiteral.of("1"))
                                                        .setRightChild(
                                                            IdentifierExpression.of("size"))))
                                        .setRightChild(NaturalNumberLiteral.of("1"))))));
  }

  protected FunctionDeclaration new_setTrapVisited_Declaration() {
    return new FunctionDeclaration()
        .setName(Identifier.of("setTrapVisited"))
        .addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("trapset"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.NONE)
                                .setTypeId(CustomTypeId.of(Identifier.of("Trapset"))))
                        .setReferenceType(true)))
        .addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("trapIndex"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.NONE)
                                .setTypeId(BaseTypeIdentifiers.INTEGER))))
        .addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("visited"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.NONE)
                                .setTypeId(BaseTypeIdentifiers.BOOLEAN))))
        .setStatementBlock(
            new StatementBlock()
                .addDeclaration(
                    new VariableDeclaration()
                        .setIdentifier(Identifier.of("mask"))
                        .setType(
                            new Type()
                                .setBaseType(
                                    new BaseType()
                                        .setPrefix(ETypePrefix.NONE)
                                        .setTypeId(CustomTypeId.of(Identifier.of("BitMask")))))
                        .setInitializer(
                            new FlatVariableInitializer()
                                .setExpression(
                                    new ArrayLookupExpression()
                                        .setLeftChild(IdentifierExpression.of("BIT_MASKS"))
                                        .setRightChild(IdentifierExpression.of("trapIndex")))))
                .addStatement(
                    new ExpressionStatement()
                        .setExpression(
                            new AssignmentExpression()
                                .setLeftChild(
                                    new FieldAccessExpression()
                                        .setIdentifier(Identifier.of("flags"))
                                        .setChild(IdentifierExpression.of("trapset")))
                                .setRightChild(
                                    new BitwiseOrExpression()
                                        .setLeftChild(
                                            new GroupedExpression()
                                                .setChild(
                                                    new BitwiseAndExpression()
                                                        .setLeftChild(
                                                            new FieldAccessExpression()
                                                                .setIdentifier(
                                                                    Identifier.of("flags"))
                                                                .setChild(
                                                                    IdentifierExpression.of(
                                                                        "trapset")))
                                                        .setRightChild(
                                                            new FieldAccessExpression()
                                                                .setIdentifier(
                                                                    Identifier.of("unset"))
                                                                .setChild(
                                                                    IdentifierExpression.of(
                                                                        "mask")))))
                                        .setRightChild(
                                            new GroupedExpression()
                                                .setChild(
                                                    new TernaryExpression()
                                                        .setLeftChild(
                                                            IdentifierExpression.of("visited"))
                                                        .setMiddleChild(
                                                            new FieldAccessExpression()
                                                                .setIdentifier(
                                                                    Identifier.of("isolated"))
                                                                .setChild(
                                                                    IdentifierExpression.of(
                                                                        "mask")))
                                                        .setRightChild(
                                                            NaturalNumberLiteral.of("0"))))))));
  }

  protected FunctionDeclaration new_resetTrapset_Declaration() {
    return new FunctionDeclaration()
        .setName(Identifier.of("resetTrapset"))
        .addParameter(
            new ParameterDeclaration()
                .setIdentifier(Identifier.of("trapset"))
                .setType(
                    new Type()
                        .setBaseType(
                            new BaseType()
                                .setPrefix(ETypePrefix.NONE)
                                .setTypeId(CustomTypeId.of(Identifier.of("Trapset"))))
                        .setReferenceType(true)))
        .setStatementBlock(
            new StatementBlock()
                .addStatement(
                    new ExpressionStatement()
                        .setExpression(
                            new AssignmentExpression()
                                .setLeftChild(
                                    new FieldAccessExpression()
                                        .setIdentifier(Identifier.of("flags"))
                                        .setChild(IdentifierExpression.of("trapset")))
                                .setRightChild(NaturalNumberLiteral.of("0")))));
  }

  protected VariableDeclaration new_TdlDiagnostics_Declaration() {
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

  protected VariableDeclaration new_TdlActivatorChannels_Declaration() {
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

  protected VariableDeclaration new_TdlTerminatorChannels_Declaration() {
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

  protected VariableDeclaration new_TrapsetActivatorChannels_Declaration() {
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

  protected VariableDeclaration new_TrapsetTerminatorChannels_Declaration() {
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

  protected FunctionDeclaration new_initTrapsets_Declaration() {
    return new FunctionDeclaration()
        .setName(Identifier.of("initTrapsets"))
        .setStatementBlock(new StatementBlock());
  }

  protected Template new_TdlConjunctionRecognizer_Template() {
    return TdlConjunctionRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlDisjunctionRecognizer_Template() {
    return TdlDisjunctionRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlQuantificationRecognizer_Template() {
    return TdlQuantificationRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlLeadsToRecognizer_Template() {
    return TdlLeadsToRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlBoundedLeadsToRecognizer_Template() {
    return TdlBoundedLeadsToRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlBoundedRepetitionRecognizer_Template() {
    return TdlBoundedRepetitionRecognizerTemplateFactory.getInstance().newTemplate();
  }

  protected Template new_TdlStopwatch_Template() {
    return TdlStopwatchTemplateFactory.getInstance().newTemplate();
  }

  protected SystemDefinition newSystemDefinition() {
    return ScenarioStubSystemDefinitionFactory.getInstance().newSystemDefinition();
  }

  public UtaSystem newSystem() {
    UtaSystem ScenarioStub = new UtaSystem();

    // Set global declarations:
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_MAX_INT_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_TDL_TIMEOUT_Declaration());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getDeclarations(), new_TDL_TREE_NODE_COUNT_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_TRAPSET_COUNT_Declaration());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getDeclarations(), new_MAX_TRAPSET_SIZE_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BoundType_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_TrapsetIndex_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_TrapsetFlags_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_TrapsetMask_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BoundValue_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_TdlTreeIndex_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_Trapset_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BitMask_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BIT_MASKS_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BOUND_EQ_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BOUND_GT_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BOUND_GTE_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BOUND_LT_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_BOUND_LTE_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_initTrapset_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_setTrapVisited_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_resetTrapset_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_TdlDiagnostics_Declaration());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getDeclarations(), new_TdlActivatorChannels_Declaration());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getDeclarations(), new_TdlTerminatorChannels_Declaration());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getDeclarations(), new_TrapsetActivatorChannels_Declaration());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getDeclarations(), new_TrapsetTerminatorChannels_Declaration());
    CollectionUtils.addIfNonNull(ScenarioStub.getDeclarations(), new_initTrapsets_Declaration());

    // Set templates:
    CollectionUtils.addIfNonNull(
        ScenarioStub.getTemplates(), new_TdlConjunctionRecognizer_Template());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getTemplates(), new_TdlDisjunctionRecognizer_Template());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getTemplates(), new_TdlQuantificationRecognizer_Template());
    CollectionUtils.addIfNonNull(ScenarioStub.getTemplates(), new_TdlLeadsToRecognizer_Template());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getTemplates(), new_TdlBoundedLeadsToRecognizer_Template());
    CollectionUtils.addIfNonNull(
        ScenarioStub.getTemplates(), new_TdlBoundedRepetitionRecognizer_Template());
    CollectionUtils.addIfNonNull(ScenarioStub.getTemplates(), new_TdlStopwatch_Template());
    // Set system definition:
    SystemDefinition systemDefinition = newSystemDefinition();
    if (systemDefinition != null) {
      ScenarioStub.setSystemDefinition(systemDefinition);
    }
    return ScenarioStub;
  }
}
