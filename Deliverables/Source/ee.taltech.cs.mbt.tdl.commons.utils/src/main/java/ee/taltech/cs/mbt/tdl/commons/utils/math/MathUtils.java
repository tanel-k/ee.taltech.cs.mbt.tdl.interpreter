package ee.taltech.cs.mbt.tdl.commons.utils.math;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.BiTuple;

public class MathUtils {
	public static BiTuple<Double, Double> solveQuadraticApprox(double a, double b, double c) {
		if (a == 0.0) {
			if (b == 0.0)
				return null;

			double solution = -c / b;
			return BiTuple.of(solution, solution);
		}

		double determinant = b * b - (4 * a * c);

		if (determinant >= 0){
			return BiTuple.of(
					(-b + Math.sqrt(determinant)) / (2.0 * a),
					(-b - Math.sqrt(determinant)) / (2.0 * a)
			);
		}

		return null;
	}

	public static int signum(int x) {
		return x < 0 ? - 1 : 1;
	}

	public static boolean inRange(double x, double a, double b) {
		if (a <= b)
			return a <= x && x <= b;
		return b <= x && x <= a;
	}

	public static boolean inRange(int x, int a, int b) {
		if (a <= b)
			return a <= x && x <= b;
		return b <= x && x <= a;
	}
}
