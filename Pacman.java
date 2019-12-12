
package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class Pacman {
    
    Laberinto lab = new Laberinto();
    private int x = 30;
    private int y = 30;
    private final int ancho = 30;
    private final int alto = 30;
    private final int movimiento = 30;
    int up=0,down=0,right=0,left=0;
    Timer timer;
        
    public void paint(Graphics grafico){
            grafico.setColor(Color.YELLOW);
            grafico.fillOval(x, y, ancho, alto);
            grafico.setColor(Color.BLACK);
            grafico.drawOval(x, y, ancho, alto);
    }    
    
    public Pacman(){
        this.movimiento();
    }
    
    public void teclapresionar(KeyEvent evento){
        final int[][] laberinto = lab.obtieneLaberinto();
        if(evento.getKeyCode()== KeyEvent.VK_UP){
            //System.out.println("tecla hacia arriba");
            up=1;
            down=0;
            right=0;
            left=0;
            
        }
        
        if(evento.getKeyCode()== KeyEvent.VK_DOWN){
            //System.out.println("tecla hacia abajo");
            up=0;
            down=1;
            right=0;
            left=0;
        }
        
        if(evento.getKeyCode()== KeyEvent.VK_RIGHT){
            //System.out.println("tecla hacia la derecha");
            up=0;
            down=0;
            right=1;
            left=0;
        }
        
        if(evento.getKeyCode()== KeyEvent.VK_LEFT){
            //System.out.println("tecla hacia la izquierda");
            up=0;
            down=0;
            right=0;
            left=1;
        }
         
    }
    
    public void movimiento(){
        final int[][] laberinto = lab.obtieneLaberinto();
        timer = new Timer(300, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(up==1 & laberinto[(y/30)-1][(x/30)]!=1){
                        y=y-movimiento;
                    }
                if(down==1 & laberinto[(y/30)+1][(x/30)]!=1){
                        y=y+movimiento;
                    }
                if(right==1 & laberinto[y/30][(x/30)+1]!=1){
                        x=x+movimiento;
                    }
                if(left==1 & laberinto[y/30][(x/30)-1]!=1){
                        x=x-movimiento;
                    }
            }
            
        });
        timer.start();
    }  
}
