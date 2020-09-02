import java.util.Random;
import java.awt.*;
import java.awt.event.*;

class Pacman extends Frame implements KeyListener
{
	final int FACEUP=1,FACEDOWN=2,FACELEFT=3,FACERIGHT=4;
	int pacx,pacy,pacface,villanx,villany,score=0;
	boolean villanPrint=true;
	Label l1,l2;
	Pacman()
	{
		setLayout(null);
		addKeyListener(this);
		l1=new Label(" PACMAN ");
		l1.setBounds(950,0,150,105);
		l1.setBackground(Color.YELLOW);
		l1.setFont(new Font("Serif",Font.BOLD,30));
		add(l1);
		l2=new Label();
		l2.setBounds(1700,0,200,105);
		l2.setBackground(Color.GREEN);
		l2.setFont(new Font("Serif",Font.BOLD,25));
		l2.setText(" Your Score: "+score);
		add(l2);
		drawPacman(100,100,3);
		drawVillan(600,200);
		
		setSize(2000,1010);
		setVisible(true);
	}
	void drawPacman(int x,int y,int face)
	{
		pacx=x;
		pacy=y;
		pacface=face;
		repaint();
	}
	void drawVillan(int x,int y)
	{
		villanx=x;
		villany=y;
		repaint();
	}
	void check()
	{
		if((villanx>=pacx-50 && villanx<pacx+50)&&(villany>=pacy-50&&villany<=pacy+50))
		{
			score++;
			villanPrint=false;
			l2.setText(" Your Score: "+score);
			System.out.println("score="+score);
		}
	}
		
	public void paint(Graphics g)
	{
		g.setColor(Color.YELLOW);
		//g.fillOval(pacx,pacy,30,30);
        //g.fillArc(300, 70, 200, 200, 45, 270);
		if(villanPrint==true)
		{
			//System.out.println("hello");
			g.setColor(Color.BLACK);
			g.fillArc(villanx, villany, 100, 100, 135, 360);
			g.setColor(Color.YELLOW);
		}
		else
		{
			Random rand=new Random();
			drawVillan(rand.nextInt(1900),180+rand.nextInt(800));
			villanPrint=true;
		}
		if(pacface==1)
		{
			g.fillArc(pacx, pacy, 100, 100, 135, 270);
		}
		if(pacface==2)
		{
			g.fillArc(pacx, pacy, 100, 100, 315, 270);
		}
		if(pacface==3)
		{
			g.fillArc(pacx, pacy, 100, 100, 225, 270);
		}
		if(pacface==4)
		{
			g.fillArc(pacx, pacy, 100, 100, 45, 270);
		}
		
		
	}
	public void keyPressed(KeyEvent k)
	{
		if(k.getKeyCode()==65||k.getKeyCode()==37)
		{
			pacx-=20;
			pacface=3;
		}
		if(k.getKeyCode()==68||k.getKeyCode()==39)
		{
			pacx+=20;
			pacface=4;
		}
		if(k.getKeyCode()==87||k.getKeyCode()==38)
		{
			pacy-=20;
			pacface=1;
		}
		if(k.getKeyCode()==83||k.getKeyCode()==40)
		{
			pacy+=20;
			pacface=2;
		}
		System.out.println("x="+villanx+"  y="+villany);
		drawPacman(pacx,pacy,pacface);
		check();
		drawVillan(villanx,villany);
	}
	public void keyTyped(KeyEvent k)
	{
	}
	public void keyReleased(KeyEvent k)
	{
	}
}
class mypro
{
	public static void main(String args[])
	{
		Pacman p=new Pacman();
	}
}