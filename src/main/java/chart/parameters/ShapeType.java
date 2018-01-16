package chart.parameters;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public enum ShapeType {

    SMALL_REC(new Rectangle(2, 2)),
    NONE(new Rectangle(1, 1)),
    CIRCLE(new Ellipse2D.Double());

    private final Shape shape;

    ShapeType(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }
}
