import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import java.awt.*;
import java.util.Collections;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
 // borrowed the core graphing hibarpanel from http://www.java-forums.org/java-2d/7987-how-draw-vertical-bar-graph-java.html
// buttons and toggle and sorts are not copied
public class draw implements Runnable {
    static HiBarPanel hiBarPanel1 = new HiBarPanel();
    static HiBarPanel hiBarPanel2 = new HiBarPanel();
    static HiBarPanel hiBarPanel3=new HiBarPanel();
    static HiBarPanel hiBarPanel4=new HiBarPanel();
    static HiBarPanel hiBarPanel5=new HiBarPanel();
    static HiBarPanel hiBarPanel6=new HiBarPanel();
    public static int[] unsorted1,unsorted2,unsorted3,unsorted4,unsorted5,unsorted6; 
    static Boolean run =false; 
    Random seed = new Random();
    static int delay = 200;
    static int length = 20;
     static JToggleButton jToggleButton1;
     static JTextField lengthinput;
     static JTextField delayinput;
     JTextField lengthtext;
 	static Timer timer  = new  Timer( delay, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
      	if(run)  
        	runsort() ;
        }
     });
    public void createbut(){
	   // makes run buttions and place to put length
    	 jToggleButton1 = new javax.swing.JToggleButton();
    	  lengthinput = new javax.swing.JTextField();
    	  delayinput = new javax.swing.JTextField();
    	  lengthtext = new javax.swing.JTextField();
    	  
          jToggleButton1.setText("Run");
          jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  jToggleButton1ActionPerformed(evt);
              }
          });

          lengthinput.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  lengthinputActionPerformed(evt);
              }
          });
          delayinput.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  delayinputActionPerformed(evt);
              }
          });
    }
    public draw() {
        Thread thread = new Thread(this);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.start(); 
        createbut();
    }
 
      
    public static int[] makerandom() 
    {
        Vector<Integer> temp= new Vector<Integer>();
        int[] temp2=new int[length];
        for(int i=0; i<length; i++) { 
             temp.add(i); 
        
        
        }
        Collections.shuffle(temp);
        for(int i=0; i<temp.size();i++){
        	temp2[i]=temp.elementAt(i);
        }
        // System.out.print("made ran");
        return temp2;
    }
    
    
    public void run() {
 
    }
    private int[] getData() {
        int[] data = new int[4];
        for(int i = 0; i < data.length; i++) {
            data[i] = seed.nextInt(1);
        }
        return data;
    }
 
    private JPanel getContent(int type) {
   	 if(type==1)
		 return hiBarPanel1;
	 if(type==2)
		 return hiBarPanel2;
	 if(type==3)
		 return hiBarPanel3;
	 if(type==4)
		 return hiBarPanel4;
	 if(type==5)
		 return hiBarPanel5;
	 if(type==6)
		 return hiBarPanel6;
	 return null;
    }
 
    public static void main(String[] args) {
    
    	JFrame mainframe= new JFrame();
    	mainframe.setTitle("Drawing Sorts");
    	mainframe.setMinimumSize(new Dimension(630,800 ));
    	mainframe.setPreferredSize(new Dimension(630,800 ) );
    	
    	
        JPanel f = new JPanel();
        mainframe.add(f);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title= new JLabel("Bubble Sorts"); 
        
        System.out.println("Bubble time");
        f.add(title);
        draw myDraw = new draw();
         f.add(myDraw.getContent(1));
        
       // f.setSize(400,400);
      //  f.setLocation(20,200);
        
       
        
        f.setVisible(true);
      
        mainframe.setVisible(true);
        
        lengthinput.setText("200");
        f.add(new JLabel("Input Length"));
        f.add(lengthinput );
        delayinput.setText("200");
        f.add(new JLabel("Input delay"));
        f.add(delayinput );        
        
        
    f.add(jToggleButton1);
  
        //insert
            
        System.out.println("Insertion");
        f.add( new JLabel("Insertion Sorts"));
         
        f.add(myDraw.getContent(2));
        f.setSize(400,400);
         
        //shell
        JLabel titles= new JLabel("Shell Sorts");  
        f.add(titles);
        f.add(myDraw.getContent(3));
        f.setSize(400,400);
        
        //merge  
        f.add(new JLabel("Merge Sorts") );
        f.add(myDraw.getContent(4));
        f.setSize(400,400);
      
        
        //quick sort
        f.add(new JLabel("Quick Sorts") );
        f.add(myDraw.getContent(5));
       f.setSize(400,400);     
        
        
        //heap sort
       f.add(new JLabel("Heap Sorts") );
       f.add(myDraw.getContent(6));
      f.setSize(400,400);
        
     
      
        jToggleButton1.setText("Run"); 
        while(true)
        {
        	timer.start();

        }
        
    }
    private static void runsort()
    {
		System.out.printf("insert = %s%n", java.util.Arrays.toString(unsorted2));
		hiBarPanel1.setData(unsorted1);
		hiBarPanel1.bubblestep();
		
		hiBarPanel2.setData(unsorted2);
		hiBarPanel2.insertStep();
    	
    }
    public static int[] getdata(int type)
    {
    	 if(type==1)
    			return unsorted1;
    	 if(type==2)
 			return unsorted2;
    	 if(type==3)
 			return unsorted3;
    	 if(type==4)
 			return unsorted4;
    	 if(type==5)
 			return unsorted5;
    	 if(type==6)
 			return unsorted6; 
    	 return null;
 	 
    }
    private static int[] makecopy(int[] temp)
    {
    	int[] temp2= new int[temp.length];
    	for (int i=0 ; i<temp.length;i++){
    		temp2[i]=temp[i];
    	}
    	return temp2;
    }
    private void lengthinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengthinputActionPerformed
        // TODO add your handling code here:
        try{
            //gets input length
            String temp =  this.lengthinput.getText();
            if (temp.length()>0)
            {
            	System.out.println("tempt length is: " + temp.length());
            	length=Integer.parseInt(temp);
            
            } 
            unsorted1=makerandom();//creates the vector containing the values and randomizes it
            //converts into arrary for faster handling
        	unsorted2=makecopy(unsorted1);
        	unsorted3=makecopy(unsorted1);
        	unsorted4=makecopy(unsorted1);
        	unsorted5=makecopy(unsorted1);
        	unsorted6=makecopy(unsorted1);
            
            System.out.print(" Length is "+ length);
             
            
         
            
        }
        catch(Exception e){
            System.out.print("Bad input Reenter valid input Ints only 1 \n");
            return;
        }
         
        
    }//GEN-LAST:event_lengthinputActionPerformed
    private void delayinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lengthinputActionPerformed
        // TODO add your handling code here:
        try{
            //gets input length
        	
            String temp =  this.delayinput.getText();
            if (temp!="")
            {
            	System.out.println(temp+"Temp");
            	delay=Integer.parseInt(temp);
            
            }
            System.out.print(" delay is "+ delay);
             
            
            
            
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(lengthtext, this,"Bad length input only enter integers  \n"
                  //  + "reenter int \n", 20);
            System.out.print("Bad input Reenter valid input Ints only  2 \n");
            return;
        }
        
        
    }
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        if(jToggleButton1.isSelected())
        {
           run=true; 
           System.out.print("run on \n"); 
           timer.start();
            
        }
        else{
            run=false;
            timer.stop();
             System.out.print("run off \n");
            
        };
        // TODO add your handling code here:
    }

}
 
class HiBarPanel extends JPanel {
     
    int maxValue = 10;
    final int PAD = 30;
   int[]  data;
   static int pos1=0,pos2=0;
   static int pos=1,hole=1, temp=data[pos] ;
   void fillbubble(){
	   
	   data= draw.getdata(1);
	   
   }
   void fillinsert(){
	   data=draw.getdata(2);
   }
 void insertStep(){
		int temp,temp2;
		//System.out.printf("data = %s%n", java.util.Arrays.toString(data));
		
		Boolean inner=true,outter=false;
		System.out.print("pos "+ pos + " hole "+ hole+ "\n");
		
		
		if(hole>0 & temp<data[hole-1])
		{
			temp=data[hole-1];
			
			hole--;
			
		}
		else if(temp>data[hole-1])
		{
			
			//data[hole]=temp;
			pos++;
			hole=pos;		
			
		}
			
 
	
	}
   void bubblestep(){
		if(data!=null)   
	       {if (pos1 == data.length-1)
	       {
	         //reset pos1 once it reaches the top 
	           pos1=0; 
	           pos2++;
	       }
	       if(pos2 == data.length)
	       {
	           // entire array is sorted
	           
	          pos1=0;
	          pos2=0;
	       
	       }
	       if(data[pos1]>data[pos1+1])
	       {
	           //swaping the positions
	           int temp=data[pos1];
	           data[pos1]=data[pos1+1];
	           data[pos1+1]=temp;
	           
	           
	       }
	       pos1++;
	       
	       }
		 
   }
    HiBarPanel(){
    	setPreferredSize(new Dimension(200,200));
    }
    public void setData(int[] data) {
        this.data = data;
        
        //System.out.print("made ran");
      //  System.out.printf("data = %s%n", java.util.Arrays.toString(data));
        repaint();
    }
   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //setPreferredSize(new Dimension(120,120));
        double xInc, scale;
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight(); 
        
        g2.draw(new Line2D.Double(PAD, PAD+50, PAD, h-PAD)); 
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        if(data!=null)
        {  		xInc = (double)(w - 2*PAD)/data.length;
        		scale= (double)(h*2 - PAD)/data.length/4;
        }
        else
        	{xInc = (double)(w - 2*PAD)/1;
        	scale = (double)(h*2 - PAD)/1;
        	}
        Path2D.Double path = new Path2D.Double();
        // Draw data.
        double x = PAD;
        double y = h - PAD;
        path.moveTo(x, y);
        //draw bar
        if(data!=null)
        { for(int i = 0; i < data.length; i++) {
	            x = PAD + i*xInc;
	            y = h - PAD - scale*data[i];
	            path.lineTo(x, y);
	            path.lineTo(x+xInc, y);
	        }
        }
       // System.out.printf("bubble = %s%n", java.util.Arrays.toString(data));
        path.lineTo(x+xInc, h-PAD);
        g2.setPaint(new Color(220,220,210));
        g2.fill(path);
        g2.setPaint(Color.blue);
        g2.draw(path);
    }
    private javax.swing.JTextField lengthinput;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField lenghtext;
    
}