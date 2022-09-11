

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ivanc
 */
public class BoidsGUI extends JPanel implements ActionListener { // 

    private BoidFlock flock;

    private JLabel boidCount;

    private ButtonPanel bp;
    private DrawPanel drawPanel;
    private Timer timer;

    public BoidsGUI() {
        super(new BorderLayout());

        flock = new BoidFlock();
        boidCount = new JLabel("Boid Count: 0" + this.flock.size());
        drawPanel = new DrawPanel();
        bp = new ButtonPanel();

        bp.addBoid.addActionListener(this);
        bp.removeBoid.addActionListener(this);

        bp.alignWeight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                for (Boid b : flock.getBoids()) { // iterates through boids in flock
                    b.ALIGNMENT_WEIGHT = bp.alignWeight.getValue(); // sets alignmentweight variable of boid to value of slider
                    System.out.println("ALIGNMENT_WEIGHT: " + b.ALIGNMENT_WEIGHT); // prints out variable for testing pursposes

                }

            }
        });

        bp.sepWeight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                for (Boid b : flock.getBoids()) { // iterates through boids in flock
                    b.SEPARATION_WEIGHT = bp.sepWeight.getValue(); // sets alignmentweight variable of boid to value of slider
                    System.out.println("SEPARATION_WEIGHT: " + b.SEPARATION_WEIGHT); // prints out variable for testing pursposes

                }

            }
        });

        bp.cohesionWeight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                for (Boid b : flock.getBoids()) { // iterates through boids in flock
                    b.COHESION_WEIGHT = bp.cohesionWeight.getValue(); // sets alignmentweight variable of boid to value of slider
                    System.out.println("COHESION_WEIGHT: " + b.COHESION_WEIGHT); // prints out variable for testing pursposes

                }

            }
        });

        bp.radDetect.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                for (Boid b : flock.getBoids()) { // iterates through boids in flock
                    b.RADIUS_DETECTION = bp.radDetect.getValue(); // sets alignmentweight variable of boid to value of slider
                    System.out.println("RADIUS_DETECTION: " + b.RADIUS_DETECTION); // prints out variable for testing pursposes

                }

            }
        });

        drawPanel.add(boidCount, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(bp, BorderLayout.SOUTH);

        timer = new Timer(20, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == bp.addBoid) {
            System.out.println("Add a Boid");
            Boid boid = new Boid(flock);
            Thread thread = new Thread(boid);
            thread.start(); // tells thread class to run() the boid class (boid is runable i.e implements runnable)
            flock.addBoid(boid);
        }
        if (source == bp.removeBoid && flock.size() != 0) {
            System.out.println("Remove Boid");
            flock.removeBoid();
        }

        boidCount.setText("Boid Count: " + this.flock.size());
        drawPanel.repaint();
    }

    private class DrawPanel extends JPanel {

        public DrawPanel() {
            setPreferredSize(new Dimension(1000, 600));
            setBackground(Color.WHITE);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Boid.WORLD_WIDTH = getWidth();
            Boid.WORLD_HEIGHT = getHeight();
            if (flock.size() != 0) {
                flock.drawBoids(g);
            }

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BOIDSGUI");
        // kill all threads when frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BoidsGUI());
        frame.pack(); // resizes
        // position the frame in the middle of the screen

        Toolkit tk = Toolkit.getDefaultToolkit(); // gets toolkit for this OS
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = frame.getSize();
        frame.setLocation((screenDimension.width - frameDimension.width) / 2,
                (screenDimension.height - frameDimension.height) / 2);
        frame.setVisible(true);

    }
}
