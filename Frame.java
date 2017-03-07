import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import Express.*;
class Frame extends JFrame implements ActionListener
{
	Container container;
	Screen screen;
	//-------------->> bug tracer
	public JToolBar tb;
	JButton pencil,eraser,line,oval,rectangle,color;
	ImageIcon i1,i2,i3,i4,i5,i6;
	public int tool;
	//------------->> bug tracer
	public JToolBar tb2;
	JButton red,blue,yellow,cyan,green,edit,black,white;
	ImageIcon c1,c2,c3,c4,c5,c6,c7;
	public Color selectedcolor;

	Frame()
	{
		 container = getContentPane();
		 screen=new Screen();					//canvas created in other library file
		container.setBackground(Color.white);
		container.setForeground(Color.black);	
		MenuCall menubar=new MenuCall();
		container.setLayout(new BorderLayout());
		container.add("North",menubar.jmb2);
		//container.add("Center",screen.pass);  		//canvas attached to container
		//Tools tools=new Tools();
		//container.add("West",tools.tb);
		//Cpallete cpallete=new Cpallete();
		//container.add("South",cpallete.tb);
		//screen.colored=cpallete.selectedcolor;
		//screen.option=tools.tool;
		//container.setForeground(cpallete.selectedcolor);
		container.add("Center",screen.pass); 
		selectedcolor=Color.black;
		tool=1;
		
		
		//window style appearence
		
	try{
	UIManager.setLookAndFeel("com.sun.java.swing,plaf.windows.WindowsLookAndFeel");
	SwingUtilities.updateComponentTreeUI(container);
	}
	catch(Exception e){}
	
	//--------------->> bug tracer
	
	tb=new JToolBar(1);
		tb.setBounds(0,0,22,600);
		i1=new ImageIcon("pencil.png");
		i2=new ImageIcon("line.png");
		i3=new ImageIcon("eraser.png");
		i4=new ImageIcon("color.png");
		i5=new ImageIcon("oval.png");
		i6=new ImageIcon("rectangle.png");
		Dimension d = new Dimension(80,50);
		pencil=new JButton(i1);
		pencil.setBorderPainted( false );
	    //pencil.setBounds(0,0,5,100);
		pencil.setPreferredSize(d);
		tb.add(pencil);
		line=new JButton(i2);
		line.setBorderPainted( false );
	    //line.setBounds(110,0,5,100);
		line.setPreferredSize(d);
		tb.add(line);
		eraser=new JButton(i3);
		eraser.setBorderPainted( false );
	    //eraser.setBounds(0,110,5,100);
	    eraser.setPreferredSize(d);
		tb.add(eraser);
		color=new JButton(i4);
		color.setBorderPainted( false );
	    //color.setBounds(0,0,5,100);
		color.setPreferredSize(d);
		tb.add(color);
		oval=new JButton(i5);
		oval.setBorderPainted( false );
	    //oval.setBounds(0,0,5,100);
		oval.setPreferredSize(d);
		tb.add(oval);
		rectangle=new JButton(i6);
		rectangle.setBorderPainted( false );
	    //rectangle.setBounds(0,0,5,100);
		rectangle.setPreferredSize(d);
		tb.add(rectangle);
		pencil.addActionListener(this);
		line.addActionListener(this);
		eraser.addActionListener(this);
		color.addActionListener(this);
		oval.addActionListener(this);
		rectangle.addActionListener(this);
		container.add("West",tb);
		
		//----------->> bug tracer
		
		tb2=new JToolBar(0);
		tb2.setBounds(22,580,30,30);
		c1=new ImageIcon("red.png");
		c2=new ImageIcon("blue.png");
		c3=new ImageIcon("yellow.jpg");
		c4=new ImageIcon("cyan.png");
		c5=new ImageIcon("green.png");
		c6=new ImageIcon("black.jpg");
		c7=new ImageIcon("white.png");
	    Dimension d2 = new Dimension(50,50);
		black=new JButton(c6);
		black.setBorderPainted( false );
		black.setPreferredSize(d2);
		tb2.add(black);
		red=new JButton(c1);
		red.setBorderPainted( false );
		red.setPreferredSize(d2);
		tb2.add(red);
		blue=new JButton(c2);
		blue.setBorderPainted( false );
		blue.setPreferredSize(d2);
		tb2.add(blue);
		yellow=new JButton(c3);
		yellow.setBorderPainted( false );
		yellow.setPreferredSize(d2);
		tb2.add(yellow);
		cyan=new JButton(c4);
		cyan.setBorderPainted( false );
		cyan.setPreferredSize(d2);
		tb2.add(cyan);
		white=new JButton(c7);
		white.setBorderPainted( false );
		white.setPreferredSize(d2);
		tb2.add(white);
		green=new JButton(c5);
		green.setBorderPainted( false );
		green.setPreferredSize(d2);
		tb2.add(green);
		
		edit=new JButton("Edit Colors");
		tb2.add(edit);
		edit.addActionListener(this);
		red.addActionListener(this);
		blue.addActionListener(this);
		yellow.addActionListener(this);
		green.addActionListener(this);
		cyan.addActionListener(this);
		black.addActionListener(this);
		white.addActionListener(this);
		container.add("South",tb2);
		
	}
	
	
	//-----------------> bug tracer
	
	public void actionPerformed(ActionEvent ae)
	{
		//event for pencil tool
		if(ae.getSource()==pencil)
		{
			tool=1;
			screen.set(1,selectedcolor);
			
		}
		//event for line tool
		if(ae.getSource()==line)
		{
			tool=2;
			screen.set(2,selectedcolor);
		}
		//event for eraser tool
		if(ae.getSource()==eraser)
		{
			tool=3;
			screen.set(3,selectedcolor);
		}
		//event for color tool
		if(ae.getSource()==color)
		{
			tool=4;
			screen.set(4,selectedcolor);
		}
		//event for oval tool
		if(ae.getSource()==oval)
		{
			tool=5;
			screen.set(5,selectedcolor);
		}
		//event for rectangle tool
		if(ae.getSource()==rectangle)
		{
			tool=6;
			screen.set(6,selectedcolor);
		}
		
		//--------------> bug tracer
		
		//event for black color
		if(ae.getSource()==black)
		{
			selectedcolor=Color.black;
			screen.set(tool,selectedcolor);
		}
		//event for red color
		if(ae.getSource()==red)
		{
			selectedcolor=Color.red;
			screen.set(tool,selectedcolor);
		}
		//event for blue color
		if(ae.getSource()==blue)
		{
			selectedcolor=Color.blue;
			screen.set(tool,selectedcolor);
		}
		//event for yellow color
		if(ae.getSource()==yellow)
		{
			selectedcolor=Color.yellow;
			screen.set(tool,selectedcolor);
			System.out.println("yellow selected");
		}
		//event for green color
		if(ae.getSource()==green)
		{
			selectedcolor=Color.green;
			screen.set(tool,selectedcolor);
			System.out.println("green selected");
		}
		//event for white color
		if(ae.getSource()==white)
		{
			selectedcolor=Color.white;
			screen.set(tool,selectedcolor);
		}
		//event for cyan color
		if(ae.getSource()==cyan)
		{
			selectedcolor=Color.cyan;
			screen.set(tool,selectedcolor);
			System.out.println("cyan selected");
		}
		
		//event for edit color
		if(ae.getSource()==edit)
		{
		Color color=JColorChooser.showDialog(this,"Select a color",selectedcolor);
		if(color!=null)
		{
			selectedcolor=color;
			screen.set(tool,selectedcolor);
		}
		//tb2.setBackground(selectedcolor);
		}
	
		
	}
	
	
	public static void main(String args[])
	{
		Frame frame=new Frame();
		frame.setTitle("Express It!");
		frame.setSize(800,600);
		ImageIcon img=new ImageIcon("sha.jpg");
	    frame.setIconImage(img.getImage());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
}