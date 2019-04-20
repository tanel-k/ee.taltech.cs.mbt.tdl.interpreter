package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.coordinate_utils;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;

public class GuiCoordinateApproxFunction {
	public static GuiCoordinateApproxFunction of(Integer xIntercept, Integer yIntercept) {
		return of(GuiCoordinates.of(xIntercept, 0), GuiCoordinates.of(0, yIntercept));
	}

	public static GuiCoordinateApproxFunction of(GuiCoordinates start, GuiCoordinates end) {
		Double slope;
		Double yIntercept;
		Double xIntercept;

		if (end.getY() == start.getY()) {
			slope = 0.0;
			yIntercept = (double) start.getY();
			xIntercept = null;
		} else if (end.getX() == start.getX()) {
			slope = null;
			yIntercept = null;
			xIntercept = (double) start.getX();
		} else {
			slope = ((double) end.getY() - start.getY()) / ((double) end.getX() - start.getX());
			yIntercept = (start.getX() * -slope) + start.getY();
			xIntercept = -yIntercept * ((double) end.getX() - start.getX()) / ((double) end.getY() - start.getY());
		}

		return new GuiCoordinateApproxFunction(slope, yIntercept, xIntercept);
	}

	private final Double approxSlope;
	private final Double yIntercept;
	private final Double xIntercept;

	private GuiCoordinateApproxFunction(Double approxSlope, Double yIntercept, Double xIntercept) {
		this.approxSlope = approxSlope;
		this.yIntercept = yIntercept;
		this.xIntercept = xIntercept;
	}

	public Double approximateY(Double x) {
		if (approxSlope == null)
			return null;

		if (approxSlope == 0)
			return yIntercept;

		return approxSlope * x + yIntercept;
	}

	public Double approximateX(Double y) {
		if (approxSlope == null)
			return xIntercept;

		if (approxSlope == 0)
			return null;

		return (y - yIntercept) / approxSlope;
	}

	public Double getApproxSlope() {
		return approxSlope;
	}

	public Double getYIntercept() {
		return yIntercept;
	}

	public Double getXIntercept() {
		return xIntercept;
	}
}
