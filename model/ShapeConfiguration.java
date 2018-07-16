package model;

public class ShapeConfiguration {

	ShapeColor primary_color;
	ShapeColor secondary_color;
	ShapeType shape_type;
	ShapeShadingType shading_type;
	
	public ShapeConfiguration(ShapeType shape_type, ShapeColor primary_color, ShapeColor secondary_color,
			ShapeShadingType shading_type) {
		this.shape_type = shape_type;
		this.primary_color = primary_color;
		this.secondary_color = secondary_color;
		this.shading_type = shading_type;
	}
	
	public ShapeType getCurrentShapeType() {
		return shape_type;
	}
	
	public ShapeColor getPrimaryColor() {
		return primary_color;
	}
	
	public ShapeColor getSecondaryColor() {
		return secondary_color;
	}
	
	public ShapeShadingType getShadingType() {
		return shading_type;
	}
	
	
}
