
package brick.breaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NewClass extends JPanel implements KeyListener , ActionListener{

    //ImageIcon im;
    int gan =0;
    Timer timer;
    Timer time;
    boolean t  = false;
    boolean gr_1 = false;
    boolean rr_1 = false;
    boolean gr_2 = false;
    boolean rr_2 = false;
    boolean nr =false;
    boolean a =false;
    boolean b= false;
    boolean c= false;
    boolean d = false;
    boolean e =false;
    boolean f= false;
    boolean h= false;
    boolean i = false;
    
    int game_st= 0;
    boolean game_over = false;
    boolean star = false;
    int xV =15;
    int yV=15;
    int x=0,y=230;
    int x2 =0,x3=0,x4;
     int f1_x = 350,f1_y= 200,f2_x=400,f2_y=200;
    int tt_1 = 0;
    Image enemy;
    Image enemy2,enemy3,enemy4,f_c1,f_c11,f_c111,f_c2,f_c22,f_c222;
    boolean c1=false;
    boolean c2= false;
    boolean c3= false,c4= false;
    final int  hi=350,we=615;
    Image bg;
    int car_in_road_1=0,car_in_road_2=0,total_car_passed=0;
    int score=0;
     int high_score;
    int new_high_score=0;
    public void paint(Graphics g){
        
                 super.paint(g);
       
                 g.drawImage(bg,0,0,null);
                 g.drawImage(enemy, x, y, this);
                 g.drawImage(enemy2, x2, y, this);
                 g.drawImage(enemy3, x3, y, this);
                 g.drawImage(enemy3, x3, y, this);
                 g.drawImage(enemy4, x4, 250, this);
                   if(f1_x<450){
                 g.drawImage(f_c1, f1_x, f1_y, this);
                   }else if(f1_x<500){
                g.drawImage(f_c11, f1_x, f1_y, this);
                   }else{
                       g.drawImage(f_c111, f1_x, f1_y, this);
                   }
             //  }
             
               if(f2_x<450){
                 g.drawImage(f_c2, f2_x, f2_y, this);
                   }else{
                g.drawImage(f_c22, f2_x, f2_y, this);
                   }

              if(a){
                  
                  G_1_ON(g);
              }
              if(b){
                 
                 G_1_OFF(g); 
              }
              if(c){
                  
                  R_1_ON(g);
              }
              if(d){
                  
                  R_1_OFF(g);
              }
              
              
               if(e){
                   
                  G_2_ON(g);
              }
              if(f){
                  
                 G_2_OFF(g); 
              }
              if(h){
                  
                  R_2_ON(g);
              }
              if(i){
                  R_2_OFF(g);
              }
              if(game_st !=2){
           Nr(g);
            
          }
           if(high_score>=score){   
        g.setColor(Color.red);
        g.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,20));
        g.drawString("High Score : "+high_score, 410, 15); 
        g.drawString("Score: "+score, 482, 30);
         
           }else{
               if(new_high_score<=4){
         g.setColor(Color.magenta);
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
                g.drawString("Congratulations, New High Score", 240, 70);    
                   new_high_score++;
               }
         high_score=score;
            
        g.setColor(Color.red);
        g.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,20));
         g.drawString("High Score : "+high_score, 410, 15); 
        g.drawString("Score: "+score, 482, 30);
       
               
           }
                 if(game_over){
                     
                     try{
                     Formatter formatter = new Formatter("high_score.txt");
                     formatter.format("%d\r\n",high_score);
                     formatter.close();
                     }catch(Exception e){
                         
                     }
                    over(g);
                }       
           
        
    }
      public void Nr(Graphics g){
          
          
          
             g.setColor(Color.BLACK);
            g.fillRect(350,203,30,50); 
            g.setColor(Color.BLACK);
            g.fillRect(580,180,20,40);
            
           
            g.setColor(Color.GRAY);    
          
            
            g.fillOval(354,206,22,22);
            g.setColor(Color.GRAY);
            g.fillOval(354,229,22,22);

                
       
             
                  
                 g.setColor(Color.GRAY) ;
             
              g.fillOval(581,180,18,18);
             
            
                  g.setColor(Color.GRAY);
             
            g.fillOval(581,200,18,18);
          
          
          
      }
      public void G_1_ON(Graphics g){
          
            g.setColor(Color.BLACK);
            g.fillRect(350,203,30,50); 
            g.setColor(Color.BLACK);
            g.fillRect(580,180,20,40);
           
            g.setColor(Color.GRAY);    
          
            
            g.fillOval(354,206,22,22);
            g.setColor(Color.GREEN);
            g.fillOval(354,229,22,22);

                
       
              if(rr_2){
                  g.setColor(Color.RED);
              }else{
                  
                 g.setColor(Color.GRAY) ;
              }
              g.fillOval(581,180,18,18);
              if(gr_2){
                  g.setColor(Color.GREEN);
              }else{
                  g.setColor(Color.GRAY);
              }
            //g.fillOval(551,213,18,18);
            
       g.fillOval(581,200,18,18);
            gr_1= true;
            rr_1 = false;
            
          
      }
      
      
      
        public void G_1_OFF(Graphics g){
          
            g.setColor(Color.BLACK);
            g.fillRect(350,203,30,50); 
            g.setColor(Color.BLACK);
            g.fillRect(580,180,20,40);
            
            if(rr_1){
            g.setColor(Color.RED);
            }else{
                 g.setColor(Color.GRAY);    
            }
            
              g.fillOval(354,206,22,22);
            g.setColor(Color.GRAY);
            g.fillOval(354,229,22,22);
            
            
              if(rr_2){
                  g.setColor(Color.RED);
              }else{
                  
                 g.setColor(Color.GRAY) ;
              }
               g.fillOval(581,180,18,18);

              if(gr_2){
                  g.setColor(Color.GREEN);
              }else{
                  g.setColor(Color.GRAY);
              }
              g.fillOval(581,200,18,18);
      
            gr_1= false;
      }
        
            public void R_1_ON(Graphics g){
          
            g.setColor(Color.BLACK);
            g.fillRect(350,203,30,50);
            g.setColor(Color.BLACK);
            g.fillRect(580,180,20,40);
            
           
            g.setColor(Color.RED);
          
            
            g.fillOval(354,206,22,22);
            
            g.setColor(Color.GRAY); 
        
            g.fillOval(354,229,22,22);
            
            
            
            
              if(rr_2){
                  g.setColor(Color.RED);
              }else{
                  
                 g.setColor(Color.GRAY) ;
              }
             g.fillOval(581,180,18,18);
              if(gr_2){
                  g.setColor(Color.GREEN);
              }else{
                  g.setColor(Color.GRAY);
              }
             g.fillOval(581,200,18,18);
      
            rr_1= true;
            gr_1 = false;
            
          
      }
            
       public void R_1_OFF(Graphics g){

          g.setColor(Color.BLACK);
          g.fillRect(350,203,30,50);
          g.setColor(Color.BLACK);
          g.fillRect(580,180,20,40);
            
           
          g.setColor(Color.GRAY);
          
            
          g.fillOval(354,206,22,22);
            if(gr_1){
            g.setColor(Color.GREEN);
            }else{
               g.setColor(Color.GRAY); 
                
            }
            g.fillOval(354,229,22,22);
              if(rr_2){
                  g.setColor(Color.RED);
              }else{
                  
                 g.setColor(Color.GRAY) ;
              }
              g.fillOval(581,180,18,18);
              if(gr_2){
                  g.setColor(Color.GREEN);
              }else{
                  g.setColor(Color.GRAY);
              }
              g.fillOval(581,200,18,18);
      
            rr_1= false;
           
       }
             public void G_2_ON(Graphics g){

            g.setColor(Color.BLACK);
         g.fillRect(350,203,30,50); 
            g.setColor(Color.BLACK);
             g.fillRect(580,180,20,40);
               if(rr_1){
                g.setColor(Color.RED);
         }else{
                 g.setColor(Color.GRAY);  
               }
              g.fillOval(354,206,22,22);
            if(gr_1){
            g.setColor(Color.GREEN);
            }else{
               g.setColor(Color.GRAY); 
                
            }
           g.fillOval(354,229,22,22);
            
            
            
             g.setColor(Color.GRAY);      
             
            
         g.fillOval(581,180,18,18);
           
            g.setColor(Color.GREEN);

            g.fillOval(581,200,18,18);
      
            gr_2= true;
            rr_2 = false;
           
       }
             
             
          public void G_2_OFF(Graphics g){

            g.setColor(Color.BLACK);
            g.fillRect(350,203,30,50); 
            g.setColor(Color.BLACK);
             g.fillRect(580,180,20,40);            
             if(rr_1){
                g.setColor(Color.RED);
         }else{
                g.setColor(Color.GRAY);  
             }
             g.fillOval(354,206,22,22);
            if(gr_1){
            g.setColor(Color.GREEN);
            }else{
               g.setColor(Color.GRAY); 
                
            }
            g.fillOval(354,229,22,22);

            
             if(rr_2){
            g.setColor(Color.RED);
             }else{
                  g.setColor(Color.GRAY);      
             }
            
            g.fillOval(581,180,18,18);
           
            g.setColor(Color.GRAY);

           g.fillOval(581,200,18,18);
      
            gr_2= false;
           
       }
          
          
                       public void R_2_ON(Graphics g){

            g.setColor(Color.BLACK);
            g.fillRect(350,203,30,50);
            g.setColor(Color.BLACK);
             g.fillRect(580,180,20,40);
             if(rr_1){
                g.setColor(Color.RED);
         }else{
                 
                  g.setColor(Color.GRAY);
             }
             g.fillOval(354,206,22,22);
            if(gr_1){
            g.setColor(Color.GREEN);
            }else{
               g.setColor(Color.GRAY); 
                
            }
          g.fillOval(354,229,22,22);

            
          g.setColor(Color.RED);
             
            
          g.fillOval(581,180,18,18);
              
          g.setColor(Color.GRAY); 
              

          g.fillOval(581,200,18,18);
      
            rr_2= true;
            gr_2 = false;
           
       }
          public void R_2_OFF(Graphics g){

            g.setColor(Color.BLACK);
            g.fillRect(350,203,30,50);
            g.setColor(Color.BLACK);
            g.fillRect(580,180,20,40);
            
            if(rr_1){
                g.setColor(Color.RED);
         }else{
                 
                  g.setColor(Color.GRAY);
             }
              g.fillOval(354,206,22,22);
            if(gr_1){
            g.setColor(Color.GREEN);
            }else{
               g.setColor(Color.GRAY); 
                
            }
             g.fillOval(354,229,22,22);
           
            
            g.setColor(Color.GRAY);
             
            
            g.fillOval(581,180,18,18);
               if(gr_2){
            g.setColor(Color.GREEN);
               }else{
                   g.setColor(Color.GRAY); 
               }

              g.fillOval(581,200,18,18);
      
            rr_2= false;
           
       }
         
    public void Aud() throws UnsupportedAudioFileException, IOException, LineUnavailableException   {
    File f = new File("ssound.wav");
    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
    Clip clip = AudioSystem.getClip();
    clip.open(audioIn);
    clip.start();
    tt_1++;
    System.out.printf("%d",tt_1);
    
                         }
    
    
    
          public void Aud2() throws UnsupportedAudioFileException, IOException, LineUnavailableException   {
              
           if(game_st==1 && gan ==0){
               gan =1;
    File f = new File("mu.wav");
    AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
    Clip cli = AudioSystem.getClip();
    cli.open(audioIn);
      cli.loop(Clip.LOOP_CONTINUOUSLY);
    
      cli.start();
    }
    

           }
              
    
    
                        
          
         
                         
    NewClass() throws FileNotFoundException{
       
        ins();
       this.setPreferredSize(new Dimension(we,hi));
        this.setSize(1000,1000);
        this.setLayout(null);
        this.addKeyListener(this);
        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//URL resource = classLoader.getResource("breaker/bgc.jpg");
//ImageIcon bg= new ImageIcon(resource);
//ImageIcon bg = new javax.swing.ImageIcon(getClass().getResource("bgc.jpg"));
        bg = new ImageIcon("bgc.jpg").getImage();
        enemy=new ImageIcon("ccar.png").getImage();
        enemy3=new ImageIcon("c3.png").getImage();
        f_c1 = new ImageIcon("f_c1_v1.png").getImage();
        f_c11 = new ImageIcon("f_c1_v2.png").getImage();
        
        f_c2 = new ImageIcon("f_c2_v1.png").getImage();
        f_c22 = new ImageIcon("f_c2_v2.png").getImage();
         f_c111 = new ImageIcon("f_c1_v3.png").getImage();
        try {
            Aud2();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
       setFocusable(true);          ////
       requestFocus();
      
       try{
        //Formatter file_high_score = new Formatter("high_score.txt");
        File hi_sc_fi = new File("high_score.txt");
        Scanner input = new Scanner(hi_sc_fi);
        while(input.hasNextInt()){
            high_score = input.nextInt();
            System.out.println(high_score+"\n");
        }
        input.close();
        
       }catch(Exception e){
           
       }
       

         timer = new Timer(700,this);
         timer.start();
    
         this.setBackground(Color.WHITE);
      
       
    }
    
      public void over(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(90,100, 460,90);

        g.setColor(Color.CYAN);
        g.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        g.drawString("Game Over !!",200,130);
      //  g.setColor(Color.RED);
        g.setColor(Color.CYAN);
        g.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,16));
        g.drawString("Your Score is : "+score , 200, 150);
        g.drawString("Press r to restart the game- " , 200, 170);
        
       // g.setFont(new Font(Font.MONOSPACED,Font.BOLD,120));
       // g.drawString("You :(", 110,340);
    //    g.setColor(Color.BLACK);
       // g.setFont(new Font(Font.SERIF,Font.BOLD,20));
        //g.drawString("(Press ENTER To Restart)", 330,420);
    }
         public void restart(){
             
                car_in_road_1=0;
                car_in_road_2=0;
                total_car_passed=0;
                game_over = false;
                x=0;
                y=230;
                 x2 =0;
                 x3=0;
                 x4=0;
                 f1_x = 350;
                 f1_y= 200;
                 f2_x=400;
                 f2_y=200;
                 new_high_score=0;
                 high_score =0; 
                 score =0;
                  game_st= 0;
                 try{
        //Formatter file_high_score = new Formatter("high_score.txt");
        File hi_sc_fi = new File("high_score.txt");
        Scanner input = new Scanner(hi_sc_fi);
        while(input.hasNextInt()){
            high_score = input.nextInt();
            System.out.println(high_score+"\n");
        }
        input.close();
        
       }catch(Exception e){
           
       }
                 
         }
         public void ins(){
        String i1="1. press 'a'(small) to ON the Green light in road-1(Here road-1 is the Horizontal road and road-2 is the vertical road)";
        String i2="\n2. press 'c'(small) to ON the Red light in road-1";
        String i3="\n3. press 'e'(small) to ON the Green light in road-2";
        String i4="\n4. press 'h'(small) to ON the Red light in road-2";
        String i5="\n5. press 'b'(small) to OFF the Green light in road-1";
        String i6="\n6. press 'd'(small) to OFF the Red light in road-1";
        String i7="\n7. press 'f'(small) to OFF the Green light in road-2";
        String i8="\n8. press 'i'(small) to OFF the Red light in road-2";
        String i9="\n9. press 's'(small) to START the game";
        String i10="\n\n(Do Not pass the cars by only one road,you have to pass the cars by both roads.Be Safe,Thank you)";
        
        JOptionPane.showMessageDialog(null, i1+i2+i3+i4+i5+i6+i7+i8+i9+i10, "Instruction", JOptionPane.DEFAULT_OPTION);
    }


    @Override
    public void keyTyped(KeyEvent ke) {
       //  game_st = true;
       switch (ke.getKeyChar()){
           case 's':
               game_st=1;
       {
           try {
               Aud2();
           } catch (UnsupportedAudioFileException ex) {
               Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
           } catch (LineUnavailableException ex) {
               Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
               break;
                
           case 'a':
               a= true;
               b= false;
               c= false;
               d= false;
               e = false;
               f = false;
               h = false;
               i = false;
           if(game_st==1){
               game_st=2;
           }
               
            repaint();
             
             break;
           case 'b':

               a= false;
               b= true;
               c= false;
               d= false;
               e = false;
               f = false;
               h = false;
               i = false;
                          if(game_st==1){
               game_st=2;
           }
               repaint();
               break;
           case 'c':
               a= false;
               b= false;
               c= true;
               d= false;
               e = false;
               f = false;
               h = false;
               i = false;
                          if(game_st==1){
               game_st=2;
           }
               repaint();
               break;
               
               
           case 'd':
               a= false;
               b= false;
               c= false;
               d= true;
               e = false;
               f = false;
               h = false;
               i = false;
                          if(game_st==1){
               game_st=2;
           }
               repaint();
               break;
          
           case 'e':
               a= false;
               b= false;
               c= false;
               d= false;
               e = true;
               f = false;
               h = false;
               i = false;
                          if(game_st==1){
               game_st=2;
           }
               repaint();
               break;
           case 'f':
               a= false;
               b= false;
               c= false;
               d= false;
               e = false;
               f = true;
               h = false;
               i = false;
                          if(game_st==1){
               game_st=2;
           }
               repaint();
               break;
           case 'h':
                  a= false;
               b= false;
               c= false;
               d= false;
               e = false;
               f = false;
               h = true;
               i = false;
                          if(game_st==1){
               game_st=2;
           }
              repaint();
              break;
           case 'i':
               a= false;
               b= false;
               c= false;
               d= false;
               e = false;
               f = false;
               h = false;
               i = true; 
              if(game_st==1){
               game_st=2;
           }
           case 'r':
               restart();
               if(game_st==1){
               game_st=2;
           }
               repaint();
               break;
       }



// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
 System.out.printf("%d \n",total_car_passed);  
    System.out.println(rr_2);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) throws FileNotFoundException {
     new MYFRAME(); 
     
     
     
    }

    @Override
   
    
   public void actionPerformed(ActionEvent ae) {
      
              
        
           if(total_car_passed==5){           //passing car onujai e car er speed increase kora hocche 
              timer.stop();
             timer = new Timer(650,this);
             System.out.println("650");
             timer.start();
         }
            if(total_car_passed==7){           //passing car onujai e car er speed increase kora hocche 
              timer.stop();
             timer = new Timer(625,this);
             System.out.println("625");
             timer.start();
         }
            if(total_car_passed==10){      //passing car onujai e car er speed increase kora hocche 
             timer.stop();
             timer = new Timer(600,this);
             System.out.println("600");
             timer.start();
         } 
             if(total_car_passed==13){           //passing car onujai e car er speed increase kora hocche 
              timer.stop();
             timer = new Timer(575,this);
             System.out.println("575");
             timer.start();
         }
             if(total_car_passed==15){             //passing car onujai e car er speed increase kora hocche 
             timer.stop();
             timer = new Timer(550,this);
             System.out.println("550");
             timer.start();
         }
            if(total_car_passed==17){             //passing car onujai e car er speed increase kora hocche 
             timer.stop();
             timer = new Timer(525,this);
             System.out.println("525");
             timer.start();
         }
               if(total_car_passed==20){             //passing car onujai e car er speed increase kora hocche 
             timer.stop();
             timer = new Timer(500,this);
             System.out.println("500");
             timer.start();
         }
             if(total_car_passed==25){         //passing car onujai e car er speed increase kora hocche 
                 timer.stop();
             timer = new Timer(400,this);
             System.out.println("400");
             timer.start();
         }
  if(total_car_passed==30){                           //passing car onujai e car er speed increase kora hocche 
                 timer.stop();
             timer = new Timer(300,this);
             System.out.println("300");
             timer.start();
         }
  if(total_car_passed==50){                           //passing car onujai e car er speed increase kora hocche 
                 timer.stop();
             timer = new Timer(250,this);
             System.out.println("250");
             timer.start();
         }
  if(total_car_passed==60){                               //passing car onujai e car er speed increase kora hocche 
                 timer.stop();
             timer = new Timer(200,this);
             System.out.println("200");
             timer.start();
         }
    if(total_car_passed==150){                               //passing car onujai e car er speed increase kora hocche 
                 timer.stop();
             timer = new Timer(100,this);
             System.out.println("100");
             timer.start();
         }
           
    //  if(abs(f1_x-x)<=10 || abs(f2_x-x)<=10 || abs(f1_x-x2)<=10 || abs(f2_x-x2)<=10 || abs(f1_x-x3)<=10 || abs(f2_x-x3) <= 10 || abs(f1_x-x4)<=10 || abs(f2_x-x4)<=10){
         //  game_over = true;
     //  }
     if(((f1_y>=220 && f1_y <=240)&& (x>=500 && x<570) && (f1_x >= 500 && f1_x<600)  )||( (f1_y>=220 && f1_y <=240)&& (x2>=500 && x2<570) && (f1_x >= 500 && f1_x<600))|| ((f1_y>=220 && f1_y <=240)&& (x3>=500 && x3<570) && (f1_x >= 500 && f1_x<600)) ||((f1_y>=220 && f1_y <=240)&& (x4>=500 && x4<570) && (f1_x >= 500 && f1_x<600)) || ((f2_y>=220 && f2_y <=240)&& (x>=520 && x<600) && (f2_x >= 600 && f2_x<624)) || ((f2_y>=220 && f2_y <=240)&& (x2>=520 && x2<600) && (f2_x >= 600 && f2_x<624)) || ((f2_y>=220 && f2_y <=240)&& (x3>=520 && x3<600) && (f2_x >= 600 && f2_x<624)) || ((f2_y>=220 && f2_y <=240)&& (x4>=520 && x4<600) && (f2_x >= 600 && f2_x<624)) ){
          game_over = true;
     }//game over er condition
       if(!game_over && (game_st ==1 || game_st==2) ){
        if(x==600){
            x=0;
            c2= true;
            enemy2=new ImageIcon("c2.png").getImage();
            car_in_road_1++;
            total_car_passed++;
            System.out.printf("%d, " ,car_in_road_1);
            score+=10;
          
        }
        if(x2==600){   //game er road er baire chole gele abar ai rasatay notun kore asbe ai condition onujai e
            x2=0 ;
            car_in_road_1++;
            total_car_passed++;
            score+=10;
        }

        if(x3==600){       //game er road er baire chole gele abar ai rasatay notun kore asbe ai condition onujai e
            
            x3=0;
            car_in_road_1++;
            total_car_passed++;
            score+=10;
        }
        if(x4==600){             //game er road er baire chole gele abar ai rasatay notun kore asbe ai condition onujai e
            
            x4=0;
            car_in_road_1++;
            total_car_passed++;
            score+=10;
        }
        
     
        
        
                   if(f1_y>250){             //game er road er baire chole gele abar ai rasatay notun kore asbe ai condition onujai e
                   f1_y = 200;  
                   f1_x = 350;
                   car_in_road_2++;
                   total_car_passed++;
                   score+=10;
              }
              
                 if(f2_y>250){              //game er road er baire chole gele abar ai rasatay notun kore asbe ai condition onujai e
                   f2_y = 200;  
                   f2_x = 400;
                   car_in_road_2++;
                   total_car_passed++;
                   score+=10;
              }
                 
              if(((f1_y>220 && f1_y<230) && (rr_2)) ){      //red light on tai ai condition onujai e gari pause hobe
                  
              }else{                                      //nahole gari cholbe
                 
                 
                      f1_x+=(22);
                      f1_y+=5;
                  
                  
              }
              if((f2_y>210 && f2_y<220) && (rr_2)){               ////red light on tai ai condition onujai e gari pause hobe
                  
              }else{                                                   //nahole gari cholbe       
                    f2_x+=(28);
                     f2_y+=(3);
              }
      if((!rr_1 && !gr_1) || (gr_1)){ 
          if(c2){
              x2+=20;
          }
          if(c4){
              x4+=30;
              
          }
          if(c3){
               x3= x3+30; 
          }
        
          if(c1){
              x= x+40; 
          }
          c1=true;
         // c2=true;
          c3=true;
          
         


      }else{
          if(rr_1 && ((x<255 ||x<270 || x<285) && (x>250)) ){
              if(total_car_passed % 3==0){
                      
                  try {
                      Aud();
                   
                      c4= true;
                      enemy4=new ImageIcon("c4.png").getImage();
                  } catch (UnsupportedAudioFileException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (LineUnavailableException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  }
                            
       }
              c1=false;

          }else{
              x+=40;
          }
             
              if(rr_1 && (x2>=255 && x2<=285) ){
              if(tt_1<3){
                      
                  try {
                      Aud();
                        } catch (UnsupportedAudioFileException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (LineUnavailableException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  c2 = false;
          
              }
              }else{
                  
                  x2+=20;
              }
              
                if(rr_1 && (x3>=255 && x3<=285) ){
              if(tt_1<3){
                      
                  try {
                      Aud();
                    } catch (UnsupportedAudioFileException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (LineUnavailableException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  c3 = false;
          
              }
                            }else{
                                
                                x3+=30;
                      
              
          }
                            
                                  if(rr_1 && (x4>=255 && x4<=285) ){
              if(tt_1<3){
                      
                  try {
                      Aud();
                   } catch (UnsupportedAudioFileException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (LineUnavailableException ex) {
                      Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  c3 = false;
          
              }
                            }else{
                                
                                x4+=40;
                      
              
          }
                            
          }
      
       }else{
          
       }
        System.out.printf("cars %d %d \n",car_in_road_1,car_in_road_2 );
       if(car_in_road_1>= 4){ // road 1 a jodi aksathe 6 ta gari ja and road 2 te kunu gari na jay tahole game over hobe
           if(car_in_road_2==0){
           game_over=true;
           }else{
               car_in_road_1=0;
               car_in_road_2=0;
           }
       }
       if(car_in_road_2==4 ){ // road 2 te jodi aksathe 4 ta gari jay and road 1 a kunu car na jay taholeo game over hobe,karon erokom na hole j kew sudu road 1 er road off rakhbe and road 2 te sudu gari pass kore score korbe abong kunu accideient o hobe na tokhon,uporer tar jonno o vice versa
           if(car_in_road_1==0){
              game_over=true;
           }else{
            //  car_in_road_1=0;
              car_in_road_2=0;  
       }
       }
           repaint();
      
   // @Override
    

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
} 


