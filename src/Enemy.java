import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    public boolean right;
    public boolean left;
    public double x, y;
    public int width, height, speed;

    public Enemy(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = 40;
        this.height = 10;
    }

    public void tick() {
        x += (Game.ball.x - x - 6) * 0.1;

        if (x + width > Game.WIDTH)
            x = Game.WIDTH - width;
        else if (x < 0)
            x = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 40, 10);
    }
}