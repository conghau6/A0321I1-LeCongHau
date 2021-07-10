package _6_ke_thua.bai_tap.lop_point_va_movablepoint;

public class MoveblePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveblePoint() {
    }

    public MoveblePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveblePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] array = new float[2];
        array[0] = xSpeed;
        array[1] = ySpeed;
        return array;
    }

    public String toString() {
        return super.toString() + ", speed = (" + xSpeed + "," + ySpeed + ")";
    }

    public MoveblePoint move() {
        this.setX(this.getX() + xSpeed);
        this.setY(this.getY() + ySpeed);
        return this;
    }
}
