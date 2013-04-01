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
 // borrowed the core graphing hibarpanel from http://www.java-forums.org/java-2d/7987-how-draw-vertical-bar-graph-java.html
// buttons and toggle and sorts are not copied
public class draw implements Runnable {
    HiBarPanel hiBarPanel1 = new HiBarPanel();
    HiBarPanel hiBarPanel2 = new HiBarPanel();
    static HiBarPanel hiBarPanel3=new HiBarPanel();
    static HiBarPanel hiBarPanel4=new HiBarPanel();
    static HiBarPanel hiBarPanel5=new HiBarPanel();
    static HiBarPanel hiBarPanel6=new HiBarPanel();
    public static int[] unsorted1,unsorted2,unsorted3,unsorted4,unsorted5,unsorted6; 
    Boolean run =false; 
    Random seed = new Random();
    int delay = 200;
    static int length = 20;
     static JToggleButton jToggleButton1;
     static JTextField jTextField1;
     static JTextField jTextField2;
     JTextField lengthtext;
    public void createbut(){
	   // makes run buttions and place to put length
    	 jToggleButton1 = new javax.swing.JToggleButton();
    	  jTextField1 = new javax.swing.JTextField();
    	  jTextField2 = new javax.swing.JTextField();
    	  lengthtext = new javax.swing.JTextField();
    	  
          jToggleButton1.setText("Run");
          jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  jToggleButton1ActionPerformed(evt);
              }
          });

          jTextField1.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  jTextField1ActionPerformed(evt);
              }
          });
          jTextField2.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  jTextField2ActionPerformed(evt);
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
    	unsorted1=unsorted2=unsorted3=unsorted4=unsorted5=unsorted6= makerandom();
    	//1-6 are the unsorted arrays that will be sorted by the methods
    	
        while(true) {
        	System.out.print(run);
        	if(run==true){
        		System.out.printf("insert = %s%n", java.util.Arrays.toString(unsorted2));
        			hiBarPanel1.setData(unsorted1);
        			hiBarPanel1.bubblestep();
        			
        			hiBarPanel2.setData(unsorted2);
        			hiBarPanel2.insertStep();
        	
        		
	            try {
	                Thread.sleep(delay);
	                System.out.printf("in delay");
	            } catch(InterruptedException e) {
	                break;
	            }
	            System.out.printf("out delay");
        	}
        }
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
    	mainframe.setPreferredSize(new Dimension(630,900 ) );
    	
    	
        JPanel f = new JPanel();
        mainframe.add(f);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title= new JLabel("Bubble Sorts"); 
        
        f.add(title);
         f.add(new draw().getContent(1));
        
        f.setSize(400,400);
        f.setLocation(20,200);
        
       
        
        f.setVisible(true);
        f.add(jToggleButton1);
        mainframe.setVisible(true);
        
        jTextField1.setText("Input label");
        f.add(new JLabel("Input Length"));
        f.add(jTextField1 );
        jTextField2.setText("200");
        f.add(new JLabel("Input delay"));
        f.add(jTextField2 );        
        jToggleButton1.setText("Run"); 
        

  
        //insert
       
        f.add( new JLabel("Insertion Sorts"));
        f.add(new draw().getContent(2));
        f.setSize(400,400);
        
     /* 
        //shell
        JLabel titles= new JLabel("Shell Sorts");  
        f.add(titles);
         f.add(new draw().getContent(3));
        f.setSize(400,400);
        
        //merge  
        f.add(new JLabel("Merge Sorts") );
         f.add(new draw().getContent(4));
        f.setSize(400,400);
      
        
        //quick sort
        f.add(new JLabel("Quick Sorts") );
        f.add(new draw().getContent(5));
       f.setSize(400,400);     
        
        
        //heap sort
       f.add(new JLabel("Heap Sorts") );
       f.add(new draw().getContent(6));
      f.setSize(400,400);
        
        
        
   */     
        
        mainframe.pack();
        
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
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        try{
            //gets input length
            length= Integer.parseInt(this.jTextField1.getText());
            
            this.lengthtext.setText(  String.valueOf(length) );
            unsorted1=makerandom();//creates the vector containing the values and randomizes it
            //converts into arrary for faster handling
            
            System.out.print(" Length is "+ length);
             
            
            
            
        }
        catch(Exception e){
            System.out.print("Bad input Reenter valid input Ints only \n");
            return;
        }
        
        
    }//GEN-LAST:event_jTextField1ActionPerformed
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        try{
            //gets input length
            delay= Integer.parseInt(this.jTextField2.getText());
            
        
            
            
            System.out.print(" delay is "+ delay);
             
            
            
            
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(lengthtext, this,"Bad length input only enter integers  \n"
                  //  + "reenter int \n", 20);
            System.out.print("Bad input Reenter valid input Ints only \n");
            return;
        }
        
        
    }
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

        if(jToggleButton1.isSelected())
        {
           run=true; 
           System.out.print("run on \n"); 
            
        }
        else{
            run=false;
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
   
   void fillbubble(){
	   
	   data= draw.getdata(1);
	   
   }
   void fillinsert(){
	   data=draw.getdata(2);
   }
 void insertStep(){
		int pos=1,hole=1,temp;
		System.out.printf("data = %s%n", java.util.Arrays.toString(data));
		Boolean inner=true,outter=false;
		hole=pos;
		temp = data[pos];
		if(hole>0 & temp<data[hole-1])
		{
			data[pos]=data[pos-1];
			hole--;
			
		}
		else
		{
			
			data[hole]=temp;
			pos++;
					
			
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField lenghtext;
    
}