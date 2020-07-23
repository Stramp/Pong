import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;

public class Ball {
    public boolean right;
    public boolean left;
    public double x, y, dx, dy;
    public double speed;
    public int width, height;

    public Ball(int x, int y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = 4;
        this.height = 4;

        int angle = new Random().nextInt(120 - 45) + 45 + 1;
        System.out.println(angle);
        this.dx = Math.cos(Math.toRadians(angle));
        this.dy = Math.sin(Math.toRadians(angle));
    }

    public void tick() {
        if (x + (dx * speed) + width >= Game.WIDTH)
            dx *= -1;
        else if (x + (dx * speed) < 0)
            dx *= -1;

        if (y > Game.HEIGHT) {
            System.out.println("ponto do inimigo");
            new Game();
            return;
        } else if (y < 0) {
            System.out.println("ponto meu");
            new Game();
            return;
        }

        Rectangle bounds = new Rectangle((int) (x + (dx * speed)), (int) (y + (dy * speed)), width, height);
        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
        Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x, (int) Game.enemy.y, Game.enemy.width,
                Game.enemy.height);

        if (bounds.intersects(boundsPlayer)) {
            int angle = new Random().nextInt(120 - 45) + 45 + 1;
            this.dx = Math.cos(Math.toRadians(angle));
            this.dy = Math.sin(Math.toRadians(angle));
            if (dy > 0)
                dy *= -1;

        }

        else if (bounds.intersects(boundsEnemy)) {
            int angle = new Random().nextInt(120 - 45) + 45 + 1;
            this.dx = Math.cos(Math.toRadians(angle));
            this.dy = Math.sin(Math.toRadians(angle));
            if (dy < 0)
                dy *= -1;

        }

        x += dx * speed;
        y += dy * speed;

    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, width, height);
    }
}