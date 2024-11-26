
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class HiperDibu {

    public static void main(String[] args) {
        System.out.println("Iniciando Arte...");
	Arte MiMano = new Arte();
	MiMano.mostrar();
    }
}


class Arte extends JPanel implements MouseListener {

private JFrame ventanita;
private BufferedImage lienzo;
private Graphics2D g2d;
private Point puntoEnCurso;
private HiperCalc Calcu;


    public Arte() {
        super();
	puntoEnCurso = new Point();
	Calcu = new HiperCalc();
	System.out.println("Cargando... Dibujando");
        ventanita = new JFrame("HiperDibu ...");
        ventanita.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanita.add(this,BorderLayout.CENTER);
        ventanita.getContentPane().setBackground(Color.GRAY);
//        BorderLayout miLayout = (BorderLayout) ventanita.getContentPane().getLayout();
        ventanita.pack();
        ventanita.setLocationRelativeTo(null);
        this.requestFocus();
        iniciando();
    }

    public void mostrar(){
        ventanita.setVisible(true);
    }    

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(640,480);
    }

    private void iniciando(){
        setBackground(Color.BLACK);
        lienzo = new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
        g2d = lienzo.createGraphics();
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(2));
        addMouseListener(this);
    }

	@Override
	public void mousePressed(MouseEvent e){
	puntoEnCurso.setLocation(e.getPoint());
	g2d.drawOval(puntoEnCurso.x, puntoEnCurso.y, Calcu.distanciaW(puntoEnCurso.x, puntoEnCurso.y), Calcu.distanciaH(puntoEnCurso.x, puntoEnCurso.y));
	System.out.println("P-> " + puntoEnCurso.toString());
	repaint();
	}
	
public void mouseClicked(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(lienzo, 0, 0, null);
    }

}

class HiperCalc {

    public int distanciaH(int a, int b) {
        return (b + (a + 2)/2)/4;
    }
    public int distanciaW(int a, int b) {
        return (a + (b + 2)/2)/4;
    }
}
