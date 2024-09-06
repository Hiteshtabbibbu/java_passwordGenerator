import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
class project1 
{
	JFrame ob;
	JLabel l1,l2,l3,l4;
	JTextField f1,f2;
	JCheckBox c1,c2,c3,c4;
	JButton b1,b2;
	int len,count,j,check;
	int rand,random;
	char temp;
	String password;
	project1()
	{
		ob=new JFrame("password generator");
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ob.setSize(1920,1080);
		ob.setVisible(true);
		ob.setLayout(null);
		Color col=new Color(255,239,213);
		ob.getContentPane().setBackground(col);
		l1=new JLabel("ENTER LENGTH OF PASSWORD");
		l1.setBounds(50,50,200,30);	
		ob.add(l1);
		f1=new JTextField("");
		f1.setBounds(300,50,200,30);
		l2=new JLabel("");
		l2.setBounds(50,250,200,30);
		f1.setColumns(15);
		ob.add(f1);
		c1=new JCheckBox("UPPERCASE");
		c1.setBounds(50,100,100,30);
		c2=new JCheckBox("lowercase");
		c2.setBounds(160,100,100,30);
		c3=new JCheckBox("numbers");
		c3.setBounds(270,100,100,30);
		c4=new JCheckBox("special characters");
		c4.setBounds(380,100,150,30);
		b1=new JButton("GENERATE PASSWORD");
		b1.setBounds(50,150,200,30);
		b1.setBackground(Color.GREEN);
		b1.setForeground(Color.WHITE);
		ob.add(c1); ob.add(c2); ob.add(c3); ob.add(c4);
		ob.add(b1);
		f2=new JTextField("password will be displayed here");
		f2.setColumns(15);
		f2.setBounds(260,150,200,30);
		int[] spl=new int[4];
		b2=new JButton("CHECK STRENGTH");
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setForeground(Color.WHITE);
		ob.add(b2);
		b2.setBounds(50,200,200,30);
		l4=new JLabel("");
		l4.setBounds(260,200,200,30);
		f1.addCaretListener(new CaretListener()
							{
								public void caretUpdate(CaretEvent are)
								{
									c1.setSelected(false);
									c2.setSelected(false);
									c3.setSelected(false);
									c4.setSelected(false);
									l4.setText("");
									f2.setText("");
								}
							}
				   );
		b1.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent ae)
								{
									count=0;
									try
									{
										if(f1.getText().equals(""))
											len=0;
										len=Integer.parseInt(f1.getText());
									}
									catch(Exception e)
									{	
										l2.setText("password must be a number>0");
									}
									password="";
									Random r=new Random();
									if(c1.isSelected())
									{
										count++;
										random=65 + r.nextInt(26);
										temp=(char)random;
										password = password + Character.toString(temp);
									}
									if(c2.isSelected())
									{	
										count++;
										random=97 + r.nextInt(26);
										temp=(char)random;
										password=password + Character.toString(temp);
									}
									if(c3.isSelected())
									{
										count++;
										random=48+ r.nextInt(10);
										temp=(char)random;
										password=password + Character.toString(temp);
									}
									if(c4.isSelected())
									{
										count++;
										j=0;
										spl[j]=33+ r.nextInt(15);
										j++;
										spl[j]=58 + r.nextInt(17);
										j++;
										spl[j]=91+ r.nextInt(7);
										j++;
										spl[j]=123+r.nextInt(4);
										j++;
										random=spl[r.nextInt(j)];
										temp=(char)random;
										password=password + Character.toString(temp);
									}
									for(int i=0;i<len-count;i++)
									{
										rand=33+r.nextInt(94);
										if(c1.isSelected() && rand>=65 && rand<=90)
										{
											temp=(char)rand;
											password = password + Character.toString(temp);
										}
										else if(c2.isSelected() && rand>=97 && rand<=122)
										{	
											temp=(char)rand;
											password=password + Character.toString(temp);
										}
										else if(c3.isSelected() && rand>=48 && rand<=57)
										{
											temp=(char)rand;
											password=password + Character.toString(temp);
										}
										else if(c4.isSelected() && ((rand>=33 && rand<=47) || (rand>=58 &&rand<=64) || (rand>=91 && rand<=96) || 																				(rand>=123 && rand<=126)))
										{
											temp=(char)rand;
											password=password + Character.toString(temp);
										}
										else if(c1.isSelected() || c2.isSelected() || c3.isSelected() || c4.isSelected())
										{
											l2.setText("");
											i--;
										}
										else 
										{
											l2.setText("SELECT ATLEAST OPTION");
										}
									}
									if(len==0)
									{
										f1.setText("ENTER A VALID NUMBER BTW 0-9");
										password="";
									}
									f2.setText(password);	
								}
							 });
		ob.add(f2);
		ob.add(l2);
		ob.add(b2);
		ob.add(l4);
		ob.setExtendedState(JFrame.MAXIMIZED_BOTH);
		b2.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent ae)
								{
									check=0;
									l4.setText("    ");
									if(c1.isSelected())
									{
										check++;
									}
									if(c2.isSelected())
									{
										check++;
									}
									if(c3.isSelected())
									{
										check++;
									}
									if(c4.isSelected())
									{
										check++;
									}
									switch(check)
									{
										case 1:
											l4.setText(l4.getText() + "weak");
											break;
										case 2:
											l4.setText(l4.getText() + "good");
											break;
										case 3,4:
											l4.setText(l4.getText() + "strong");
											break;
										default :
											break;
									}
								}
							}
				     );
	}
	public static void main(String[] args)
	{
		new project1();
	}
}
