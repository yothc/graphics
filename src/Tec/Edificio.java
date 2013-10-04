package Tec;

/**
 *
 * @author marco Antonio 
 */


import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.Random;


public class Edificio extends JApplet implements Runnable {
    Thread animator;

    //variables para animar el sol
    int xSunPosition;
    int ySunPosition;

    //variables para el cambio de color del cielo
    int skyR, skyG, skyB;
    Color skyColor = new Color(skyR, skyG, skyB);

    //booleanos que controlan el momento que se producen animaciones
    boolean sunIsRising = true;
    boolean sunIsSetting = false;
    boolean cloudDrift = false;
    boolean starsComeOut = false;

    //variables para la animación de la nube
    int cloudX = 1000; // posicion de la nube
    int cloudY = 100;
    int cloudTracker = 0;

    //variables para mantener las estrellas ocultos hasta que viniesen a cabo
    Color starColor = skyColor;
    int starR, starG, starB;

    //variables para las puntas de las estrellas
    int starX;
    int starY;
    int xPoints[] = {starX, starX+11, starX+7, starX+3, starX+14};
    int yPoints[] = {starY, starY+8, starY-5, starY+8, starY};

    //objeto de números aleatorios para abrir y cerrar estrellas
    Random random = new Random();
    //controlar el color estrella de si un abrir y cerrar debe ir
    boolean startedTwinkling = false;
    //variables de color para cada una de las estrellas
    Color star1Color;
    Color star2Color;
    Color star3Color;
    Color star4Color;
    Color star5Color;
    Color star6Color;
    Color star7Color;
    Color star8Color;
    Color star9Color;
    Color star10Color;

    //para el doble búfer para evitar el parpadeo
    BufferedImage img;
    Graphics g2;
  
    @Override
    public void init() {    
        JRootPane root = this.getRootPane();
        root.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);

    }

    @Override
    public void start()
    {
       img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
       g2 = img.createGraphics();
       xSunPosition = 1070; //posicion del sol
       ySunPosition = 600;
       animator = new Thread(this);
       animator.start();
       skyR = 0;
       skyG = 0;
       skyB = 0;
       skyColor = new Color(skyR, skyG, skyB);
       starColor = skyColor;
    }


    @Override
    public void stop()
    {
       animator = null;
    }

    @Override
    public void destroy()
    {
     
    }

    @Override
    public void paint(Graphics g) {

        //sky
        g2.setColor(skyColor);
        g2.fillRect(0,0, getWidth(), getHeight()-100);

        //estrella 1
        g2.setColor(starColor);
        
                            //estrella 2
                            if (startedTwinkling == false)
                                star1Color = starColor;
                            g2.setColor(star1Color);
                            starX = 700;
                            starY = 700;
                            updatePoints(starX, starY);
                            g2.fillPolygon(xPoints, yPoints, 5);
                            g2.fillOval(starX + 5, starY - 1, 6, 7);

                                    //estrella 3
                                    if (startedTwinkling == false)
                                       star2Color = starColor;
                                    g2.setColor(star2Color);
                                    starX = 100;
                                    starY = 180;
                                    updatePoints(starX, starY);
                                    g2.fillPolygon(xPoints, yPoints, 5);
                                    g2.fillOval(starX + 5, starY - 1, 6, 7);

                                            //estrella4
                                            if (startedTwinkling == false)
                                                star3Color = starColor;
                                            g2.setColor(star3Color);
                                            starX = 175;
                                            starY = 70;
                                            updatePoints(starX, starY);
                                            g2.fillPolygon(xPoints, yPoints, 5);
                                            g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                //estrella 5
                                                if (startedTwinkling == false)
                                                    star4Color = starColor;
                                                g2.setColor(star4Color);
                                                starX = 280;
                                                starY = 120;
                                                updatePoints(starX, starY);
                                                g2.fillPolygon(xPoints, yPoints, 5);
                                                g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                    //estrella 6
                                                    if (startedTwinkling == false)
                                                        star5Color = starColor;
                                                    g2.setColor(star5Color);
                                                    starX = 330;
                                                    starY = 300;
                                                    updatePoints(starX, starY);
                                                    g2.fillPolygon(xPoints, yPoints, 5);
                                                    g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                            //estrella 7
                                                            if (startedTwinkling == false)
                                                                star6Color = starColor;
                                                            g2.setColor(star6Color);
                                                            starX = 450;
                                                            starY = 50;
                                                            updatePoints(starX, starY);
                                                            g2.fillPolygon(xPoints, yPoints, 5);
                                                            g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                                //estrella 8
                                                                if (startedTwinkling == false)
                                                                    star7Color = starColor;
                                                                g2.setColor(star7Color);
                                                                starX = 500;
                                                                starY = 400;
                                                                updatePoints(starX, starY);
                                                                g2.fillPolygon(xPoints, yPoints, 5);
                                                                g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                                    //estrella 9
                                                                    if (startedTwinkling == false)
                                                                        star8Color = starColor;
                                                                    g2.setColor(star8Color);
                                                                    starX = 550;
                                                                    starY = 60;
                                                                    updatePoints(starX, starY);
                                                                    g2.fillPolygon(xPoints, yPoints, 5);
                                                                    g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                                            //estrella 10
                                                                            if (startedTwinkling == false)
                                                                                star9Color = starColor;
                                                                            g2.setColor(star9Color);
                                                                            starX = 600;
                                                                            starY = 500;
                                                                            updatePoints(starX, starY);
                                                                            g2.fillPolygon(xPoints, yPoints, 5);
                                                                            g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                                                    //estrella 11
                                                                                    if (startedTwinkling == false)
                                                                                        star10Color = starColor;
                                                                                    g2.setColor(star10Color);
                                                                                    starX = 650;
                                                                                    starY = 650;
                                                                                    updatePoints(starX, starY);
                                                                                    g2.fillPolygon(xPoints, yPoints, 5);
                                                                                    g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                                            //estrella 12
                                                                             if (startedTwinkling == false)
                                                                                star10Color = starColor;
                                                                            g2.setColor(star10Color);
                                                                            starX = 700;
                                                                            starY = 500;
                                                                            updatePoints(starX, starY);
                                                                            g2.fillPolygon(xPoints, yPoints, 5);
                                                                            g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                                    //estrella 13
                                                                     if (startedTwinkling == false)
                                                                        star10Color = starColor;
                                                                    g2.setColor(star10Color);
                                                                    starX = 750;
                                                                    starY = 89;
                                                                    updatePoints(starX, starY);
                                                                    g2.fillPolygon(xPoints, yPoints, 5);
                                                                    g2.fillOval(starX + 5, starY - 1, 6, 7);

                                                            //estrella 14
                                                             if (startedTwinkling == false)
                                                                star10Color = starColor;
                                                            g2.setColor(star10Color);
                                                            starX = 800;
                                                            starY = 58;
                                                            updatePoints(starX, starY);
                                                            g2.fillPolygon(xPoints, yPoints, 5);
                                                            g2.fillOval(starX + 5, starY - 1, 6, 7);

                                    //estrella 15
                                     if (startedTwinkling == false)
                                        star10Color = starColor;
                                    g2.setColor(star10Color);
                                    starX = 850;
                                    starY = 60;
                                    updatePoints(starX, starY);
                                    g2.fillPolygon(xPoints, yPoints, 5);
                                    g2.fillOval(starX + 5, starY - 1, 6, 7);

                //estrella 16
                 if (startedTwinkling == false)
                    star10Color = starColor;
                g2.setColor(star10Color);
                starX = 900;
                starY = 45;
                updatePoints(starX, starY);
                g2.fillPolygon(xPoints, yPoints, 5);
                g2.fillOval(starX + 5, starY - 1, 6, 7);

        //estrella 17
         if (startedTwinkling == false)
            star10Color = starColor;
        g2.setColor(star10Color);
        starX = 950;
        starY = 78;
        updatePoints(starX, starY);
        g2.fillPolygon(xPoints, yPoints, 5);
        g2.fillOval(starX + 5, starY - 1, 6, 7);

        
        
        
        //sol, amarillo
        g2.setColor(Color.yellow);
        g2.fillOval(xSunPosition, ySunPosition, 200, 200); //tamaño del sol

        //nube , blanca
        g2.setColor(Color.white);
        g2.fillOval(cloudX, cloudY, 80, 90);
        g2.fillOval(cloudX+15, cloudY-25, 90, 100);
        g2.fillOval(cloudX+30, cloudY+30, 90, 70);
        g2.fillOval(cloudX+60, cloudY, 90, 60);
        g2.fillOval(cloudX+50, cloudY-30, 60, 60);
        g2.fillOval(cloudX+80, cloudY-20, 90, 80);
        g2.fillOval(cloudX+80, cloudY+20, 90, 80);
        g2.fillOval(cloudX+100, cloudY, 90, 80);


        //hierba, verde
        g2.setColor(new Color(35, 180, 5));
        g2.fillRect(0, getHeight()-100, getWidth(), getHeight());

       //casa, 
        g2.setColor (Color.LIGHT_GRAY);
        g2.fillRect(50, 200, 1150, 400);

        
        
        //perilla
       g2.setColor(Color.white);  
       g2.fillOval(685, 555, 7, 7);
       g2.fillOval(708, 555, 7, 7);

        //Techo
        g2.setColor(Color.GRAY);
        g2.fillRect(50, 160, 1180, 60);
      
    
        //poligono
        g2.setColor(Color.white);
        int xRoof[] = { 80, 150, 440,500};
        int yRoof[] = { 220, 240, 240, 220 };
        g2.fillPolygon(xRoof, yRoof, 4);
    
        

        
       // barra de la izquierda
        g2.setColor(Color.GRAY);
        g2.fillRect(50, 210, 30, 390);
        
  

        
       //    poligono 
      g2.setColor(new Color(100, 100, 117));
      int wRoof[] ={ 150, 80,500,440};
      int eRoof[] = { 350, 380, 380, 350 };
      g2.fillPolygon(wRoof, eRoof, 4); 
        
          //linea de enmedio
        g2.setColor(Color.GRAY);
        g2.fillRect(50, 380, 450, 40);
      //Liniieeaa
        g2.setColor(Color.BLACK);
        g2.fillRect(150, 240, 2, 110); 
        
        g2.setColor(Color.BLACK);
        g2.fillRect(438, 240, 2, 110); 
        
        g2.setColor(Color.BLACK);
        g2.fillRect(500, 220, 2, 380); 
        
         g2.setColor(Color.BLACK);
        g2.fillRect(550, 220, 2, 380); 
  
        
        //linea azul
        g2.setColor(Color.BLUE);
        g2.fillRect(152, 240, 286, 110);
        
          //linea de enmedio
        g2.setColor(Color.GRAY);
        g2.fillRect(100, 290, 380, 10);
        
             // barra de la izquierda
        g2.setColor(Color.GRAY);
        g2.fillRect(185, 230, 30, 135);       
     
        // barra de la izquierda
        g2.setColor(Color.GRAY);
        g2.fillRect(280, 230, 30, 135);   
        
              // barra de la izquierda
        g2.setColor(Color.GRAY);
        g2.fillRect(370, 230, 30, 135);   
    
        
        
            // barra de la izquierda delgada
        g2.setColor(Color.GRAY);
        g2.fillRect(160, 230, 5, 135); 
          // barra de la izquierda delgada
        g2.setColor(Color.GRAY);
        g2.fillRect(260, 230, 5, 135); 
          // barra de la izquierda delgada
        g2.setColor(Color.GRAY);
        g2.fillRect(235, 230, 5, 135); 
          // barra de la izquierda delgada
        g2.setColor(Color.GRAY);
        g2.fillRect(347, 230, 5, 135); 
          // barra de la izquierda delgada
        g2.setColor(Color.GRAY);
        g2.fillRect(325, 230, 5, 135); 
          // barra de la izquierda delgada
        g2.setColor(Color.GRAY);
        g2.fillRect(415, 230, 5, 135); 
      
          //poligono  abajo
        g2.setColor(Color.white);
        int aRoof[] = { 80, 150, 440,500};
        int bRoof[] = { 420, 430, 430, 420 };
        g2.fillPolygon(aRoof, bRoof, 4);
        
        
        
        //Liniieeaa
        g2.setColor(Color.BLACK);
        g2.fillRect(150, 430, 2, 150); 
        g2.fillRect(444, 430, 2, 150); 
   
            //    poligono
       g2.setColor(new Color(100, 100, 117));
        int qRoof[] ={ 150, 80,500,445};
        int rRoof[] = { 560, 600, 600, 560 };
        g2.fillPolygon(qRoof, rRoof, 4); 

            //linea azul
        g2.setColor(Color.BLUE);
        g2.fillRect(152, 430, 292, 130);
        
           // barras de abajajo grasas 1
        g2.setColor(Color.GRAY);
        g2.fillRect(185, 425, 30, 155);       
     
        // barra 2
        g2.setColor(Color.GRAY);
        g2.fillRect(280, 425, 30, 155);   
        
              // barra 3
        g2.setColor(Color.GRAY);
        g2.fillRect(370, 425, 30, 155);
        
         // barra delgadas de abajo1
        g2.setColor(Color.GRAY);
        g2.fillRect(160, 425, 5, 155); 
          // barra de la izquierda delgada2
        g2.setColor(Color.GRAY);
        g2.fillRect(260, 425, 5, 155); 
          // barra de la izquierda delgada3
        g2.setColor(Color.GRAY);
        g2.fillRect(235, 425, 5, 155); 
          // barra de la izquierda delgada4
        g2.setColor(Color.GRAY);
        g2.fillRect(347, 425, 5, 155); 
          // barra de la izquierda delgada5
        g2.setColor(Color.GRAY);
        g2.fillRect(325, 425, 5, 155); 
          // barra de la izquierda delgada6
        g2.setColor(Color.GRAY);
        g2.fillRect(415, 425, 5, 155);        
        
          //linea de enmedio
        g2.setColor(Color.GRAY);
        g2.fillRect(100, 500, 380, 10);
        
        
        //linea de enmedio
        g2.setColor(Color.GRAY);
        g2.fillRect(552, 380, 250, 40);
        //color de fonfo
         g2.setColor(Color.BLUE);
    g2.fillRect(558, 220, 240, 160); 
        //fondo
         g2.setColor(Color.BLUE);
        g2.fillRect(558, 420, 245, 180);
        
        //puerta color
        g2.setColor(Color.BLACK);
        g2.fillRect(599, 470, 152, 130);
       //lineas
        g2.setColor(Color.black);
        g2.fillRect(552, 420, 250, 6);//acostada arriba
        g2.fillRect(552, 594, 250, 6);//acostada abajo
        g2.fillRect(552, 420, 6, 180); //parada derecha
        g2.fillRect(796, 420, 6, 180); //parada izquierda
        g2.fillRect(552, 470, 250, 2);//acostada 1
            g2.fillRect(552, 520, 250, 2);//acostada 2
                g2.fillRect(552, 560, 250, 2);//acostada 3
                
           g2.fillRect(599, 420, 2, 180); //parada 1
             g2.fillRect(650, 420,2, 180); //parada 2 
               g2.fillRect(700, 420, 2, 180); //parada3 
                 g2.fillRect(750, 420, 2, 180); //parada 4
          
                 
      
                          
       g2.fillRect(552, 220, 250, 6);//acostada arriba
        g2.fillRect(552, 380, 250, 6);//acostada abajo
           g2.fillRect(552, 220, 6, 160); //parada derecha
        g2.fillRect(796, 220, 6, 160); //parada izquierda
                 g2.fillRect(552, 300, 250, 2);//acostada 1
                   g2.fillRect(599, 220, 2, 160); //parada 1
             g2.fillRect(650, 220,2, 160); //parada 2 
               g2.fillRect(700, 220, 2, 160); //parada3 
                 g2.fillRect(750, 220, 2, 160); //parada 4
                 
              
            g2.fillRect(800, 280, 2, 160); //parada izquierda
                
            g2.fillRect(845, 220, 2, 380); //parada izquierda
            
            
              
        //linea azul
        g2.setColor(Color.BLUE);
        g2.fillRect(900, 240, 253, 110);
            
            //poligono
        g2.setColor(Color.white);
        int tRoof[] = { 848, 900, 1153,1200};
        int iRoof[] = { 220, 240, 240, 220 };
        g2.fillPolygon(tRoof, iRoof, 4);
        
        
         //linea de enmedio
        g2.setColor(Color.GRAY);
        g2.fillRect(847, 380, 354, 40);
   
         //    poligono
       g2.setColor(new Color(100, 100, 117));
        int oRoof[] ={ 900,848,1200,1153};
        int pRoof[] = { 350, 380, 380, 350 };
        g2.fillPolygon(oRoof, pRoof, 4); 
        
        
        g2.setColor(Color.BLACK);
        g2.fillRect(900, 240, 2, 110); 
        g2.fillRect(1153, 240, 2, 110); 
        // barra de la izquierda
        g2.setColor(Color.GRAY);
        g2.fillRect(1200, 210, 30, 390);
        
        
         // barra de la izquierda 1 arriba
        g2.setColor(Color.GRAY);
        g2.fillRect(955, 230, 30, 135); 
        
        g2.setColor(Color.GRAY);
        g2.fillRect(1070, 230, 30, 135); 
        
        
         //linea de enmedio
        g2.setColor(Color.GRAY);
        g2.fillRect(870, 290, 315, 10);
        
         // barra de la izquierda delgada
        g2.setColor(Color.GRAY);
        g2.fillRect(925, 230, 5, 135); 
        g2.fillRect(1040, 230, 5, 135); 
        g2.fillRect(1015, 230, 5, 135); 
        g2.fillRect(1120, 230, 5, 135); 
        
        
        //fondo
         g2.setColor(Color.BLUE);
        g2.fillRect(900, 420, 253, 180);
     
          //poligono abajo
        g2.setColor(Color.white);
        int sRoof[] = { 848,900,1153,1200};
        int hRoof[] = { 420, 430, 430, 420 };
        g2.fillPolygon(sRoof, hRoof, 4);
        
           //    poligono
       g2.setColor(new Color(100, 100, 117));
        int jRoof[] ={ 900,848,1200,1153};
        int kRoof[] = { 560, 600, 600, 560 };
        g2.fillPolygon(jRoof, kRoof, 4); 

        // barras de abajajo grasas 1
        g2.setColor(Color.GRAY);
        g2.fillRect(955, 425, 30, 155); 
         g2.fillRect(1070, 425, 30, 155); 
        
         // barra delgadas de abajo1
        g2.setColor(Color.GRAY);
        g2.fillRect(925, 425, 5, 155); 
        g2.fillRect(1015, 425, 5, 155); 
        g2.fillRect(1040, 425, 5, 155); 
        g2.fillRect(1120, 425, 5, 155); 
        
        
      
        
         g2.setColor(Color.BLACK);
        g2.fillRect(900, 430, 2, 130); 
        g2.fillRect(1153, 430, 2, 130); 
        
        
          //linea de enmedio
        g2.setColor(Color.GRAY);
        g2.fillRect(870, 500, 310, 10);
        
        
        //texto
        
        g2.setColor(Color.BLUE);
        g2.setFont( new Font( "Serif", Font.BOLD, 30 ) );
        g2.drawString( "INSTITUTO TECNOLOGICO DE CHILPANCINGO.", 100, 200 );
       
        g.drawImage(img, 0, 0, this);
    }
    
    //insertar imagen codiigo
//public abstract boolean drawImage( Image img,
  //                                 int x,
    //                               int y,
      //                             int width,
        //                           int height,
          //                         ImageObserver observer )
    public static void main(String s[]) {
        JFrame f = new JFrame("Fernando Lucena Calixto ***GRAFICACION**");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JApplet applet = new Edificio();
        f.getContentPane().add(applet);
        applet.init();
        f.pack();
        //dimenciones del panel de la animacion
        f.setSize(new Dimension(1280, 700));
        f.setVisible(true);
        applet.start();
    }

    public void run() {
        while (Thread.currentThread() == animator) {

            //sunrise animation
            //amanecer animación
            if (sunIsRising) {
                if (ySunPosition > 10)
                    ySunPosition -=1;


                    if (skyR < 200) {
                        skyR++;
                    }
                    if (skyG < 230) {
                        skyG++;
                    }
                    if (skyB < 250) {
                        skyB++;
                    }

                skyColor = new Color(skyR, skyG, skyB);
                starColor = skyColor;

              
                //once the sun is risen, run the cloud animation
                //una vez que el sol se ha levantado, ejecute la animación nube
                if (ySunPosition == 10) {
                    sunIsRising = false;
                    cloudDrift = true;
                }
            }


            //cloud animation
            //animacion de la nube
            if (cloudDrift) {
                //drift the cloud by decreasing cloudX
                //la deriva de la nube al disminuir cloud X
                cloudX--;
                cloudTracker++;

                //after the cloud has gone a ways, decrease y every fifth x
                // después de la nube ha pasado un largo camino, disminuya y cada quinto x
                //so that the cloud goes up and disappears at the top of the screen
                 // para que la nube sube y desaparece en la parte superior de la pantalla
                if (cloudTracker > 500) {
                    if (cloudTracker % 5 == 0)
                        cloudY--;
                }
                //once the cloud is gone, run the sunset
                //una vez que la nube se ha ido, ejecute la puesta de sol
                if (cloudY == -40) {
                    cloudDrift = false;
                    sunIsSetting = true;
                }
            }

            //sunset animation
            //atardecer animación
            if (sunIsSetting) {
                if (ySunPosition < 600) {
                    ySunPosition +=1;
                }

                //once the sun is low, start darkening the sky
                // una vez que el sol está bajo, inicie oscureciendo el cielo
                if (ySunPosition > 350) {

                    if (skyR > 0)
                        skyR--;
                    if (skyG > 0)
                        skyG--;
                    if (skyB > 0)
                        skyB--;
                }
                skyColor = new Color(skyR, skyG, skyB);
                //stars still hidden
                //estrellas aún ocultas
                starColor = skyColor;

                //when the sky is completely dark, run the stars
                //cuando el cielo está completamente oscuro, ejecute las estrellas
                if (skyR == 0 && skyG == 0 && skyB == 0) {
                    sunIsSetting = false;
                    starsComeOut = true;
                }
            }

            //star animation
            //animacion de las estrellas
            if (starsComeOut) {
                
                //fade the stars in
                //desaparecer las estrellas
                if (starR < 255) {
                     starR++;
                     starG++;
                     starB++;
                     starColor = new Color(starR, starG, starB);
                }
                

                  //make them twinkle
                //hacerlos twinkle
                if (starR == 255)
                    startedTwinkling = true;
                if(startedTwinkling) {
                    int randNumber =  random.nextInt(10); //Returns random int >= 0 and < n //Regreso al azar int> = 0 y <n

                    switch (randNumber+1) {
                        case 1: //twinkle star 1
                            star1Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds  //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star1Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds  //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star1Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds  //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star1Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 2: //twinkle star
                            star2Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star2Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star2Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star2Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds    //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 3: //etc
                            star3Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star3Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds    //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star3Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star3Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 4:
                            star4Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star4Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star4Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star4Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 5:
                            star5Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds    //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star5Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star5Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star5Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 6:
                            star6Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star6Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star6Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star6Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds    //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 7:
                            star7Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star7Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star7Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star7Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 8:
                            star8Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star8Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star8Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star8Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 9:
                            star9Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star9Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }  
                            catch (Exception e) {
                                break;
                            }
                            star9Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }
                            star9Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   //tiempo en milisegundos
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        case 10: //twinkle star 10
                            star10Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds  twinkle star 10
                            }
                            catch (Exception e) {
                                break;
                            }
                            star10Color = new Color(starR-60, starG-60, starB-60);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds   twinkle star 10
                            }
                            catch (Exception e) {
                                break;
                            }
                            star10Color = new Color(starR-30, starG-30, starB-30);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds  twinkle star 10
                            } 
                            catch (Exception e) {
                                break;
                            }
                            star10Color = new Color(starR, starG, starB);
                            repaint();
                            try {
                                Thread.sleep(60); //time in milliseconds  twinkle star 10
                            }
                            catch (Exception e) {
                                break;
                            }

                            break;
                        default: //do-nothing, shouldn't ever get this
                            //no hacer nada, no debe nunca conseguir esta
                            break;
                    }

                }
//end twinkle loop
                //loop brillo final
            }         

            repaint();
            try {
                Thread.sleep(27); //time in milliseconds  twinkle star 10 // tiempo en milisegundos del twinkle star 10
            }
            catch (Exception e) {
                break;
            }
        }
    }
    private void updatePoints(int x, int y) {
        xPoints[0] = x;
        xPoints[1] = x + 11;
        xPoints[2] = x + 7;
        xPoints[3] = x + 3;
        xPoints[4] = x + 14;
        yPoints[0] = y;
        yPoints[1] = y + 8;
        yPoints[2] = y - 5;
        yPoints[3] = y + 8;
        yPoints[4] = y;
    }
}