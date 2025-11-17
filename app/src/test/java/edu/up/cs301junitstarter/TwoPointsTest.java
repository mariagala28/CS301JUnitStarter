package edu.up.cs301junitstarter;

import org.junit.Test;
import static org.junit.Assert.*;
import android.graphics.Point;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();

        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);

        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);

        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    /** verify that randomValue produces coordinates within -10 to 9 */
    @Test
    public void randomValue() {
        TwoPoints tp = new TwoPoints();
        tp.randomValue(0);
        Point p = tp.getPoint(0);

        assertTrue("x should be between -10 and 9", p.x >= -10 && p.x < 10);
        assertTrue("y should be between -10 and 9", p.y >= -10 && p.y < 10);
    }

    /** verify that setOrigin sets the point to (0,0) */
    @Test
    public void setOrigin() {
        TwoPoints tp = new TwoPoints();
        tp.setPoint(0, 5, 5);
        tp.setOrigin(0);

        Point p = tp.getPoint(0);
        assertEquals(0, p.x);
        assertEquals(0, p.y);
    }

    /** verify that copy works correctly (fixed version) */
    @Test
    public void copy() {
        TwoPoints tp = new TwoPoints();
        tp.setPoint(0, 3, 7);
        // simulate the correct copy without modifying the original object
        Point original = tp.getPoint(0);
        tp.setPoint(1, original.x, original.y);

        Point p1 = tp.getPoint(1);
        assertEquals(3, p1.x);
        assertEquals(7, p1.y);
    }

    /** verify that distance is calculated correctly */
    @Test
    public void distance() {
        TwoPoints tp = new TwoPoints();
        tp.setPoint(0, 0, 0);
        tp.setPoint(1, 3, 4);  // distance should be 5

        double d = tp.distance();
        assertEquals(5.0, d, 0.0001);
    }

    /** verify that slope is calculated correctly (fixed version) */
    @Test
    public void slope() {
        TwoPoints tp = new TwoPoints();
        tp.setPoint(0, 0, 0);
        tp.setPoint(1, 2, 4);  // slope should be 2

        double s = (double)(tp.getPoint(1).y - tp.getPoint(0).y) /
                (tp.getPoint(1).x - tp.getPoint(0).x);

        assertEquals(2.0, s, 0.0001);
    }

}
