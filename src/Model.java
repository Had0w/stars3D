import java.util.ArrayList;

public class Model {
    public ArrayList<Point> points = new ArrayList<>();
    public static  float INITIAL_Z_COORD = -3f;
    public static  float MOTION_SPEED = 0.001f;

    public void update(long elapsedTime) {
        float birthChange = 0.02f;
        if(random(0, 1) < birthChange) {
            points.add(new Point(random(-1, 1), random(-1, 1), INITIAL_Z_COORD));
        }
        for (Point point: points) {
            point.z += elapsedTime * MOTION_SPEED;
        }

        points.removeIf(point -> point.z >= 0);
    }

    public float random(float from, float to) {
        return (float) (from + (to - from) * Math.random());
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
