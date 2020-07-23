import java.awt.Color;
import java.awt.Graphics;

public class Player {
    public boolean right;
    public boolean left;
    public int x, y;
    public int speed;
    public int width, height;

    public Player(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = 40;
        this.height = 10;
    }

    public void tick() {
        if (right)
            x += speed;
        else if (left)
            x -= speed;

        if (x + width > Game.WIDTH)
            x = Game.WIDTH - width;
        else if (x < 0)
            x = 0;
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 40, 10);
    }
}