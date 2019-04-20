package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.coordinate_utils;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.BiTuple;
import ee.taltech.cs.mbt.tdl.commons.utils.math.MathUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GuiCoordinateUtils {
	public static Integer distanceBetween(GuiCoordinates start, GuiCoordinates end) {
		double xDiff = (double) (end.getX() - start.getX());
		double yDiff = (double) (end.getY() - start.getY());
		return (int) Math.floor(
				Math.sqrt((xDiff * xDiff) + (yDiff * yDiff))
		);
	}

	public static GuiCoordinates midpointCoordinates(GuiCoordinates start, GuiCoordinates end) {
		return GuiCoordinates.of(
				Math.floorDiv(start.getX() + end.getX(), 2),
				Math.floorDiv(start.getY() + end.getY(), 2)
		);
	}

	public static List<GuiCoordinates> evenlyDistributedCoordinatesBetween(GuiCoordinates start, GuiCoordinates end, Integer count) {
		List<GuiCoordinates> coordinates = new ArrayList<>(count);
		int xDiff = Math.floorDiv(end.getX() - start.getX(), count + 1);
		int yDiff = Math.floorDiv(end.getY() - start.getY(), count + 1);

		for (int i = 1; i <= count; i++) {
			coordinates.add(
					i - 1,
					GuiCoordinates.of(
							start.getX() + xDiff * i,
							start.getY() + yDiff * i
					)
			);
		}

		return coordinates;
	}

	public static List<GuiCoordinates> evenlyDistributedCoordinatesOnPath(List<GuiCoordinates> path, Integer count) {
		Integer pathLength = 0;

		int segIdx = 0;
		List<Integer> segmentLengths = new ArrayList<>(count);
		List<Integer> partialPathLengths = new ArrayList<>(count);
		List<BiTuple<GuiCoordinates, GuiCoordinates>> segments = new ArrayList<>(count);
		GuiCoordinates prevCoordinates = null;
		for (GuiCoordinates pathCoordinates : path) {
			if (prevCoordinates != null) {
				int segLength = distanceBetween(prevCoordinates, pathCoordinates);
				pathLength += segLength;

				segmentLengths.add(segIdx, segLength);
				partialPathLengths.add(segIdx, pathLength);
				segments.add(segIdx, BiTuple.of(prevCoordinates, pathCoordinates));

				segIdx++;
			}
			prevCoordinates = pathCoordinates;
		}

		Integer distBtwn = Math.floorDiv(pathLength, count + 1);
		Integer nextLength = distBtwn;
		Integer prevSegLength = 0;
		List<GuiCoordinates> coordsOnPath = new ArrayList<>(count);
		for (int i = 0; i < partialPathLengths.size() && coordsOnPath.size() < count; i++) {
			Integer partialPathLength = partialPathLengths.get(i);
			BiTuple<GuiCoordinates, GuiCoordinates> segment = segments.get(i);

			GuiCoordinates startCoords = segment.getFirst();
			GuiCoordinates endCoords = segment.getSecond();
			GuiCoordinateApproxFunction approxFunction = GuiCoordinateApproxFunction
					.of(startCoords, endCoords);

			BiTuple<Integer, Integer> checkSignum = BiTuple.of(
					MathUtils.signum(endCoords.getX() - startCoords.getX()),
					MathUtils.signum(endCoords.getY() - startCoords.getY())
			);
			while (nextLength < partialPathLength && coordsOnPath.size() < count) {
				Integer lengthOnSegment = nextLength - prevSegLength;

				Double m = approxFunction.getApproxSlope();
				Double b = approxFunction.getYIntercept();

				if (b == null) {
					// Line through X axis:
					coordsOnPath.add(GuiCoordinates.of(
							startCoords.getX(),
							startCoords.getY() + lengthOnSegment
					));
					nextLength += distBtwn;
					continue;
				} else if (b == 0) {
					// Line through Y axis:
					coordsOnPath.add(GuiCoordinates.of(
							startCoords.getX() + lengthOnSegment,
							startCoords.getY()
					));

					nextLength += distBtwn;
					continue;
				}

				double x = startCoords.getX();
				double y = startCoords.getY();

				double qA = (m * m) + 1.0;
				double qB = 2.0 * ((m * b) - (m * y) - x);
				double qC = (b * b)
						- (2 * y * b)
						+ (y * y)
						+ (x * x)
						- (lengthOnSegment * lengthOnSegment);

				BiTuple<Double, Double> quadSolution = MathUtils.solveQuadraticApprox(qA, qB, qC);
				if (quadSolution != null) {
					GuiCoordinates candidateCoordsA = GuiCoordinates.of(
							quadSolution.getFirst().intValue(),
							approxFunction.approximateY(quadSolution.getFirst()).intValue()
					);
					GuiCoordinates candidateCoordsB = GuiCoordinates.of(
							quadSolution.getSecond().intValue(),
							approxFunction.approximateY(quadSolution.getSecond()).intValue()
					);
					BiTuple<Integer, Integer> candidateSignumA = BiTuple.of(
						MathUtils.signum(candidateCoordsA.getX() - startCoords.getX()),
						MathUtils.signum(candidateCoordsA.getY() - startCoords.getY())
					);
					if (checkSignum.equals(candidateSignumA)) {
						coordsOnPath.add(candidateCoordsA);
					} else {
						coordsOnPath.add(candidateCoordsB);
					}
				} else {
					// Shouldn't be possible.
					// FIXME.
				}

				nextLength += distBtwn;
			}

			prevSegLength = segmentLengths.get(i);
		}

		return coordsOnPath;
	}
}
