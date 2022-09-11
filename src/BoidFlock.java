

import java.awt.Graphics;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivanc
 */
public class BoidFlock {

    private List<Boid> boids;

    public BoidFlock() {
        setBoids(new ArrayList<Boid>());
    }

    public List<Boid> getBoids() {
        return boids;
    }

    public void setBoids(List<Boid> boids) {
        this.boids = boids;
    }

    public void addBoid(Boid boid) {

        boids.add(boid);
    }

    public Boid removeBoid() {

        Boid boid = boids.remove(0);
        boid.requestStop();
        return boid;

    }

    public synchronized List<Boid> getNeighbours(Boid boid) {

        List<Boid> withinRadius = new ArrayList();

        
        
        for (Boid b : this.boids) {
            int distance = (int)(Math.sqrt((Math.pow(boid.getPositionX() - b.getPositionX(), 2) + (pow(boid.getPositionY() - b.getPositionY(), 2)))));
            if ( distance < Boid.RADIUS_DETECTION) //if distance between 2 boids < radius detection
            {
                withinRadius.add(b); // add those boids to temp list
            }
            
        }
        
        return withinRadius; // returns list of Boids within detection of function argument Boid

    }

    public int size() {
        return getBoids().size();
    }

    public void drawBoids(Graphics g) {
        for (Boid boid : boids) {
            boid.draw(g);
        }
    }

}