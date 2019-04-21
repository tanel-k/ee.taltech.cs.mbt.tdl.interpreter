package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.coordinate_utils;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.BiTuple;
import ee.taltech.cs.mbt.tdl.commons.utils.math.MathUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GuiCoordinateUtils {
	public static Integer flooredDistanceBetween(GuiCoordinates start, GuiCoordinates end) {
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
		if (count < 0)
			throw new IllegalArgumentException("Coordinate count must be >= 0");

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
		if (path.size() < 2)
			throw new IllegalArgumentException("Path must have at least two nodes.");

		if (count <= 0)
			throw new IllegalArgumentException("Coordinate count must be > 0.");

		Integer pathLength = 0;

		int segmentIndex = 0;
		List<Integer> partialPathLengths = new ArrayList<>(count);
		List<BiTuple<GuiCoordinates, GuiCoordinates>> segments = new ArrayList<>(count);
		GuiCoordinates prevCoordinates = null;
		for (GuiCoordinates pathCoordinates : path) {
			if (prevCoordinates != null) {
				int segLength = flooredDistanceBetween(prevCoordinates, pathCoordinates);
				pathLength += segLength;

				partialPathLengths.add(segmentIndex, pathLength);
				segments.add(segmentIndex, BiTuple.of(prevCoordinates, pathCoordinates));

				segmentIndex++;
			}
			prevCoordinates = pathCoordinates;
		}

		Integer distBetweenPts = Math.floorDiv(pathLength, count + 1);
		Integer currLengthTarget = distBetweenPts;
		Integer prevPartialPathLength = 0;
		List<GuiCoordinates> coordsOnPath = new ArrayList<>(count);
		for (segmentIndex = 0; segmentIndex < partialPathLengths.size() && coordsOnPath.size() < count; segmentIndex++) {
			Integer partialPathLength = partialPathLengths.get(segmentIndex);

			if (currLengthTarget > partialPathLength) {
				prevPartialPathLength = partialPathLength;
				continue;
			}

			BiTuple<GuiCoordinates, GuiCoordinates> segment = segments.get(segmentIndex);
			GuiCoordinates startCoords = segment.getFirst();
			GuiCoordinates endCoords = segment.getSecond();
			GuiCoordinateLineFunction approxFunction = GuiCoordinateLineFunction
					.of(startCoords, endCoords);

			BiTuple<Integer, Integer> segmentEndpointDiffSignum = BiTuple.of(
					MathUtils.signum(endCoords.getX() - startCoords.getX()),
					MathUtils.signum(endCoords.getY() - startCoords.getY())
			);
			while (currLengthTarget <= partialPathLength && coordsOnPath.size() < count) {
				Integer lengthOnSegment = currLengthTarget - prevPartialPathLength;

				Double segSlope = approxFunction.getApproxSlope();
				Double segYIntercept = approxFunction.getYIntercept();

				if (segYIntercept == null) {
					// Line through X axis:
					coordsOnPath.add(GuiCoordinates.of(
							startCoords.getX(),
							startCoords.getY() + (segmentEndpointDiffSignum.getSecond() * lengthOnSegment)
					));
					currLengthTarget += distBetweenPts;
					continue;
				} else if (segYIntercept == 0) {
					// Line through Y axis:
					coordsOnPath.add(GuiCoordinates.of(
							startCoords.getX() + (segmentEndpointDiffSignum.getFirst() * lengthOnSegment),
							startCoords.getY()
					));
					currLengthTarget += distBetweenPts;
					continue;
				}

				// yL = segSlope * xL + segYIntercept.
				// sqrt((xL - xOrigin)^2 + (yL - yOrigin)^2) = lengthOnSegment.

				double xOrigin = startCoords.getX();
				double yOrigin = startCoords.getY();

				double qA = (segSlope * segSlope) + 1.0;
				double qB = 2.0 * ((segSlope * segYIntercept) - (segSlope * yOrigin) - xOrigin);
				double qC = (segYIntercept * segYIntercept)
						- (2 * yOrigin * segYIntercept)
						+ (yOrigin * yOrigin)
						+ (xOrigin * xOrigin)
						- (lengthOnSegment * lengthOnSegment);

				// Rough solution due to Double precision - good enough since coordinates are int-based.
				BiTuple<Double, Double> quadraticSolution = MathUtils.solveQuadratic(qA, qB, qC);
				if (quadraticSolution != null) {
					GuiCoordinates candidateCoordsA = GuiCoordinates.of(
							quadraticSolution.getFirst().intValue(),
							approxFunction.approximateYFloored(quadraticSolution.getFirst())
					);
					GuiCoordinates candidateCoordsB = GuiCoordinates.of(
							quadraticSolution.getSecond().intValue(),
							approxFunction.approximateYFloored(quadraticSolution.getSecond())
					);
					BiTuple<Integer, Integer> diffSignumA = BiTuple.of(
						MathUtils.signum(candidateCoordsA.getX() - startCoords.getX()),
						MathUtils.signum(candidateCoordsA.getY() - startCoords.getY())
					);
					if (segmentEndpointDiffSignum.equals(diffSignumA)) {
						coordsOnPath.add(candidateCoordsA);
					} else {
						coordsOnPath.add(candidateCoordsB);
					}
				} else {
					throw new IllegalStateException(
							"Cannot find point at distance " + lengthOnSegment + " between " + startCoords + " and " + endCoords
									+ ". Unsolvable quadratic equation with A=" + qA + ", B=" + qB + ", C=" + qC + "."
					);
				}

				currLengthTarget += distBetweenPts;
			}

			prevPartialPathLength = partialPathLength;
		}

		return coordsOnPath;
	}

	public static LinkedList<LinkedList<GuiCoordinates>> segmentPath(
			List<GuiCoordinates> pathToSegment,
			List<GuiCoordinates> interceptingPoints
	) {
		// Seems adequate for most cases; should probably figure out a formula:
		final double errorTolerance = 5.0;

		List<GuiCoordinateLineFunction> lineFunctions = new LinkedList<>();
		GuiCoordinates prevPathPt = null;
		for (GuiCoordinates pathPt : pathToSegment) {
			if (prevPathPt != null) {
				lineFunctions.add(GuiCoordinateLineFunction.of(prevPathPt, pathPt));
			}
			prevPathPt = pathPt;
		}

		LinkedList<LinkedList<GuiCoordinates>> segments = new LinkedList<>();
		int segmentPtIdx = 0;
		int interceptPtIdx = 0;

		LinkedList<GuiCoordinates> segment = new LinkedList<>();
		segments.add(segment);

		for (; segmentPtIdx < lineFunctions.size(); segmentPtIdx++) {
			GuiCoordinateLineFunction segLineFn = lineFunctions.get(segmentPtIdx);
			GuiCoordinates segmentStartPt = pathToSegment.get(segmentPtIdx);
			GuiCoordinates segmentEndPt = pathToSegment.get(segmentPtIdx + 1);

			GuiCoordinates interceptPt = interceptingPoints.get(interceptPtIdx);
			if (!segLineFn.checkIntercepts(interceptPt, errorTolerance)) {
				// ... - segmentStartPt - segmentEndPt - ... - interceptPt - ...
				if (segment.isEmpty()) {
					// endPt in last iter is startPt in this iter.
					// If segment is empty, startPt does not exist in segment (not added in last iter as endPt).
					segment.add(segmentStartPt);
				}
				segment.add(segmentEndPt);
				continue;
			}

			if (segment.isEmpty()) {
				// segmentEndPt in last iter is segmentStartPt in this iter.
				// If segment is empty, segmentStartPt does not exist in segment (not added in last iter as segmentEndPt).
				segment.add(segmentStartPt);
			} // else: segmentStartPt is already in segment.

			while (++interceptPtIdx < interceptingPoints.size()
					&& segLineFn.checkIntercepts(interceptingPoints.get(interceptPtIdx), errorTolerance)
					) {
				// Still on the same segment but this time we have no other pts btwn interceptors.
				// ... - segmentStartPt - origInterceptPt - interceptPt - ... - segmentEndPt - ...
				segment = new LinkedList<>();
				segments.add(segment);
			}

			if (interceptPtIdx < interceptingPoints.size()) {
				// Prepare for next iteration:
				segment = new LinkedList<>();
				segments.add(segment);
			} else {
				break;
			}
		}

		// Final segment prep:
		if (!segment.isEmpty()
				&& segmentPtIdx < pathToSegment.size()
				&& segment.getLast().equals(pathToSegment.get(segmentPtIdx))
				) {
			segmentPtIdx++;
		}

		// Final segment:
		segment = new LinkedList<>();
		segments.add(segment);
		for (; segmentPtIdx < pathToSegment.size(); segmentPtIdx++) {
			segment.add(pathToSegment.get(segmentPtIdx));
		}

		// Just in case:
		CollectionUtils.fill(
				segments,
				interceptingPoints.size() + 1,
				LinkedList::new
		);

		return segments;
	}
}
