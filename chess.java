import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Game extends JFrame implements MouseListener 
{
	Abc a;
	//Image Variables
	Image bck=new ImageIcon("bck.png").getImage();
	Image bb=new ImageIcon("bb.png").getImage();
	Image bkn=new ImageIcon("bkn.png").getImage();
	Image bp=new ImageIcon("bp.png").getImage();
	Image bk=new ImageIcon("bk.png").getImage();
	Image br=new ImageIcon("br.png").getImage();
	Image bq=new ImageIcon("bq.png").getImage();
	Image wb=new ImageIcon("wb.png").getImage();
	Image wkn=new ImageIcon("wkn.png").getImage();
	Image wp=new ImageIcon("wp.png").getImage();
	Image wk=new ImageIcon("wk.png").getImage();
	Image wr=new ImageIcon("wr.png").getImage();
	Image wq=new ImageIcon("wq.png").getImage();
	//Path Variables
	Path p,prev,pos_move;
	String place_goti[][],win,st;
	int player1=1,player2=0,stop=0,start=1;
	int ran[][]=new int[8][8];
	Font f=new Font("Arial",Font.BOLD,34);
	Color c=new Color(161, 166, 15);
	Color sc=new Color(42, 62, 94);
		//path Initilization of black player
		int br1_x=94,br1_y=84;
		int bkn1_x=204,bkn1_y=84;
		int bb1_x=314,bb1_y=84;
		int bq_x=424,bq_y=84;
		int bk_x=534,bk_y=84;
		int bb2_x=644,bb2_y=84;
		int bkn2_x=754,bkn2_y=84;
		int br2_x=864,br2_y=84;

		int bp1_x=94,bp1_y=200;
		int bp2_x=204,bp2_y=200;
		int bp3_x=314,bp3_y=200;
		int bp4_x=424,bp4_y=200;
		int bp5_x=534,bp5_y=200;
		int bp6_x=644,bp6_y=200;
		int bp7_x=754,bp7_y=200;
		int bp8_x=864,bp8_y=200;
		
		//path initilization of white player
		int wp1_x=94,wp1_y=762;
		int wp2_x=204,wp2_y=762;
		int wp3_x=314,wp3_y=762;
		int wp4_x=424,wp4_y=762;
		int wp5_x=534,wp5_y=762;
		int wp6_x=644,wp6_y=762;
		int wp7_x=754,wp7_y=762;
		int wp8_x=864,wp8_y=762;

		int wr1_x=94,wr1_y=864;
		int wkn1_x=204,wkn1_y=864;
		int wb1_x=314,wb1_y=864;
		int wq_x=424,wq_y=864;
		int wk_x=534,wk_y=864;
		int wb2_x=644,wb2_y=864;
		int wkn2_x=754,wkn2_y=864;
		int wr2_x=864,wr2_y=864;
		
	public Game()
	{
		place_goti=new String[8][8];
		a=new Abc();
		setLocation(50,0);
		setSize(1050,1050);
		setVisible(true);
		setTitle("Game Design By Vikash Sinha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		p=a.initPath();
		a.show(p);

		place_goti=a.initArray();
		
	}
	public void paint(Graphics g)
	{
		//backgroung Image
		g.fillRect(0,0,1050,1050);
		g.drawImage(bck,80,80,896,896,this);
		//Black  Player
		g.drawImage(br,br1_x,br1_y,84,90,this);
		g.drawImage(bkn,bkn1_x,bkn1_y,80,90,this);
		g.drawImage(bb,bb1_x,bb1_y,80,90,this);
		g.drawImage(bq,bq_x,bq_y,80,90,this);
		g.drawImage(bk,bk_x,bk_y,80,90,this);
		g.drawImage(bb,bb2_x,bb2_y,80,90,this);
		g.drawImage(bkn,bkn2_x,bkn2_y,80,90,this);
		g.drawImage(br,br2_x,br2_y,80,90,this);

		g.drawImage(bp,bp1_x,bp1_y,80,90,this);
		g.drawImage(bp,bp2_x,bp2_y,80,90,this);
		g.drawImage(bp,bp3_x,bp3_y,80,90,this);
		g.drawImage(bp,bp4_x,bp4_y,80,90,this);
		g.drawImage(bp,bp5_x,bp5_y,80,90,this);
		g.drawImage(bp,bp6_x,bp6_y,80,90,this);
		g.drawImage(bp,bp7_x,bp7_y,80,90,this);
		g.drawImage(bp,bp8_x,bp8_y,80,90,this);

		//White Player
		
		g.drawImage(wp,wp1_x,wp1_y,80,90,this);
		g.drawImage(wp,wp2_x,wp2_y,80,90,this);
		g.drawImage(wp,wp3_x,wp3_y,80,90,this);
		g.drawImage(wp,wp4_x,wp4_y,80,90,this);
		g.drawImage(wp,wp5_x,wp5_y,80,90,this);
		g.drawImage(wp,wp6_x,wp6_y,80,90,this);
		g.drawImage(wp,wp7_x,wp7_y,80,90,this);
		g.drawImage(wp,wp8_x,wp8_y,80,90,this);

		g.drawImage(wr,wr1_x,wr1_y,84,90,this);
		g.drawImage(wkn,wkn1_x,wkn1_y,80,90,this);
		g.drawImage(wb,wb1_x,wb1_y,80,90,this);
		g.drawImage(wq,wq_x,wq_y,80,90,this);
		g.drawImage(wk,wk_x,wk_y,80,90,this);
		g.drawImage(wb,wb2_x,wb2_y,80,90,this);
		g.drawImage(wkn,wkn2_x,wkn2_y,80,90,this);
		g.drawImage(wr,wr2_x,wr2_y,80,90,this);
		g.setFont(f);
		if(start==1)
		{
			start=5;
			for(int i=1;i<5;i++)
			{
				g.setColor(sc);
				g.fillOval(300,350,400,400);
				g.setColor(Color.WHITE);
				st="Game Start In "+Integer.toString(5-i);
				g.drawString(st,350,550);
				try{Thread.sleep(1000);}catch(Exception e){}

			}
		}
		if(stop==1)
		{
			
				g.setColor(sc);
				g.fillOval(300,350,400,400);
				g.setColor(Color.WHITE);
				
				g.drawString(win,350,550);
				

			
		}

		//draw move possile
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(ran[i][j]==1)
				{
					g.setColor(c);
					pos_move=a.loct(p,i,j);
					g.fillOval(pos_move.x+20,pos_move.y+20,50,50);
					try{Thread.sleep(100);}catch(Exception e){}
				}
			}
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		if(start==5)
		{
			start=0;
			repaint();
		}
		Path node;
		String value;
		
		int x,y,r,c;
		x=e.getX();
		y=e.getY();
		//which index in clicked
		node=a.checkIndex(p,x,y);
		value=place_goti[node.r][node.c];
		System.out.print("n".equals(value));
		if('w'==value.charAt(0)&&player1==1&&stop==0)
		{
			prev=new Path();
			prev=node;
			ran=a.range(place_goti,node.r,node.c,value);
			repaint();
			for(int i=0;i<8;i++)
			{
			for (int j=0;j<8;j++ )
				System.out.print(ran[i][j]);
			System.out.println(" ");
			}

		}
		if('b'==value.charAt(0)&&player2==1&&stop==0)
		{
			prev=new Path();
			prev=node;
			ran=a.range(place_goti,node.r,node.c,value);
			repaint();
			for(int i=0;i<8;i++)
			{
			for (int j=0;j<8;j++ )
				System.out.print(ran[i][j]);
			System.out.println(" ");
			}

		}
		if(player1==1&&stop==0)
		{
			if(ran[node.r][node.c]==1&&"wkn1".equals(place_goti[prev.r][prev.c]))
			{
				wkn1_x=node.x;
				wkn1_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wkn1";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wkn2".equals(place_goti[prev.r][prev.c]))
			{
				wkn2_x=node.x;
				wkn2_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wkn2";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wr1".equals(place_goti[prev.r][prev.c]))
			{
				wr1_x=node.x;
				wr1_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wr1";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wr2".equals(place_goti[prev.r][prev.c]))
			{
				wr2_x=node.x;
				wr2_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wr2";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wb1".equals(place_goti[prev.r][prev.c]))
			{
				wb1_x=node.x;
				wb1_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wb1";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wb2".equals(place_goti[prev.r][prev.c]))
			{
				wb2_x=node.x;
				wb2_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wb2";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wq".equals(place_goti[prev.r][prev.c]))
			{
				wq_x=node.x;
				wq_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wq";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wk".equals(place_goti[prev.r][prev.c]))
			{
				wk_x=node.x;
				wk_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wk";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wp1".equals(place_goti[prev.r][prev.c]))
			{
				wp1_x=node.x;
				wp1_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wp1";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wp2".equals(place_goti[prev.r][prev.c]))
			{
				wp2_x=node.x;
				wp2_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wp2";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wp3".equals(place_goti[prev.r][prev.c]))
			{
				wp3_x=node.x;
				wp3_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wp3";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wp4".equals(place_goti[prev.r][prev.c]))
			{
				wp4_x=node.x;
				wp4_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wp4";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wp5".equals(place_goti[prev.r][prev.c]))
			{
				wp5_x=node.x;
				wp5_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wp5";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wp6".equals(place_goti[prev.r][prev.c]))
			{
				wp6_x=node.x;
				wp6_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wp6";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wp7".equals(place_goti[prev.r][prev.c]))
			{
				wp7_x=node.x;
				wp7_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wp7";
				player1=0;
				player2=1;
			}
			else if(ran[node.r][node.c]==1&&"wp8".equals(place_goti[prev.r][prev.c]))
			{
				wp8_x=node.x;
				wp8_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="wp8";
				player1=0;
				player2=1;
			}
			if(player1==0)	
				{
					if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(br1_x,br1_y,80,90)))
					{
						br1_x=-30;
						br1_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(br2_x,br2_y,80,90)))
					{
						br2_x=-30;
						br2_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bkn1_x,bkn1_y,80,90)))
					{
						bkn1_x=-30;
						bkn1_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bkn2_x,bkn2_y,80,90)))
					{
						bkn2_x=-30;
						bkn2_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bb1_x,bb1_y,80,90)))
					{
						bb1_x=-30;
						bb1_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bb2_x,bb2_y,80,90)))
					{
						bb2_x=-30;
						bb2_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bq_x,bq_y,80,90)))
					{
						bq_x=-30;
						bq_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bk_x,bk_y,80,90)))
					{
						win="White player win Game";
						stop=1;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp1_x,bp1_y,80,90)))
					{
						bp1_x=-30;
						bp1_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp2_x,bp2_y,80,90)))
					{
						bp2_x=-30;
						bp2_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp3_x,bp3_y,80,90)))
					{
						bp3_x=-30;
						bp3_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp4_x,bp4_y,80,90)))
					{
						bp4_x=-30;
						bp4_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp5_x,bp5_y,80,90)))
					{
						bp5_x=-30;
						bp5_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp5_x,bp5_y,80,90)))
					{
						bp5_x=-30;
						bp5_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp6_x,bp6_y,80,90)))
					{
						bp6_x=-30;
						bp6_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp7_x,bp7_y,80,90)))
					{
						bp7_x=-30;
						bp7_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(bp8_x,bp8_y,80,90)))
					{
						bp8_x=-30;
						bp8_y=-30;
					}
				}		
			repaint();
		}
		if(player2==1&&stop==0)
		{
			if(ran[node.r][node.c]==1&&"bkn1".equals(place_goti[prev.r][prev.c]))
			{
				bkn1_x=node.x;
				bkn1_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bkn1";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bkn2".equals(place_goti[prev.r][prev.c]))
			{
				bkn2_x=node.x;
				bkn2_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bkn2";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"br1".equals(place_goti[prev.r][prev.c]))
			{
				br1_x=node.x;
				br1_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="br1";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"br2".equals(place_goti[prev.r][prev.c]))
			{
				br2_x=node.x;
				br2_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="br2";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bb1".equals(place_goti[prev.r][prev.c]))
			{
				bb1_x=node.x;
				bb1_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bb1";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bb2".equals(place_goti[prev.r][prev.c]))
			{
				bb2_x=node.x;
				bb2_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bb2";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bq".equals(place_goti[prev.r][prev.c]))
			{
				bq_x=node.x;
				bq_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bq";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bk".equals(place_goti[prev.r][prev.c]))
			{
				bk_x=node.x;
				bk_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bk";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bp1".equals(place_goti[prev.r][prev.c]))
			{
				bp1_x=node.x;
				bp1_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bp1";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bp2".equals(place_goti[prev.r][prev.c]))
			{
				bp2_x=node.x;
				bp2_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bp2";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bp3".equals(place_goti[prev.r][prev.c]))
			{
				bp3_x=node.x;
				bp3_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bp3";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bp4".equals(place_goti[prev.r][prev.c]))
			{
				bp4_x=node.x;
				bp4_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bp4";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bp5".equals(place_goti[prev.r][prev.c]))
			{
				bp5_x=node.x;
				bp5_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bp5";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bp6".equals(place_goti[prev.r][prev.c]))
			{
				bp6_x=node.x;
				bp6_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bp6";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bp7".equals(place_goti[prev.r][prev.c]))
			{
				bp7_x=node.x;
				bp7_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bp7";
				player1=1;
				player2=0;
			}
			else if(ran[node.r][node.c]==1&&"bp8".equals(place_goti[prev.r][prev.c]))
			{
				bp8_x=node.x;
				bp8_y=node.y;
				ran=a.initRange(ran);
				place_goti[prev.r][prev.c]="n";
				place_goti[node.r][node.c]="bp8";
				player1=1;
				player2=0;
			}
			if(player1==1)	
				{
					if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wr1_x,wr1_y,80,90)))
					{
						wr1_x=-30;
						wr1_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wr2_x,wr2_y,80,90)))
					{
						wr2_x=-30;
						wr2_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wkn1_x,wkn1_y,80,90)))
					{
						wkn1_x=-30;
						wkn1_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wkn2_x,wkn2_y,80,90)))
					{
						wkn2_x=-30;
						wkn2_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wb1_x,wb1_y,80,90)))
					{
						wb1_x=-30;
						wb1_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wb2_x,wb2_y,80,90)))
					{
						wb2_x=-30;
						wb2_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wq_x,wq_y,80,90)))
					{
						wq_x=-30;
						wq_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wk_x,wk_y,80,90)))
					{
						win="Black player win Game";
						stop=1;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp1_x,wp1_y,80,90)))
					{
						wp1_x=-30;
						wp1_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp2_x,wp2_y,80,90)))
					{
						wp2_x=-30;
						wp2_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp3_x,wp3_y,80,90)))
					{
						wp3_x=-30;
						wp3_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp4_x,wp4_y,80,90)))
					{
						wp4_x=-30;
						wp4_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp5_x,wp5_y,80,90)))
					{
						wp5_x=-30;
						wp5_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp5_x,wp5_y,80,90)))
					{
						wp5_x=-30;
						wp5_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp6_x,wp6_y,80,90)))
					{
						wp6_x=-30;
						wp6_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp7_x,wp7_y,80,90)))
					{
						wp7_x=-30;
						wp7_y=-30;
					}
					else if(new Rectangle(node.x,node.y,80,90).intersects(new Rectangle(wp8_x,wp8_y,80,90)))
					{
						wp8_x=-30;
						wp8_y=-30;
					}
				}
			repaint();
		}
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}


} 
class Abc
{
	public int[][] initRange(int[][] x)
	{
		for(int i=0;i<8;i++)
			for (int j=0;j<8 ;j++ )
			 x[i][j]=0;
		return x;
	}
	public int[][] range(String[][] place,int r, int c,String val)
	{
		int i,j,ran[][]=new int[8][8];
		for(i=0;i<8;i++)
			for (j=0;j<8;j++ )
				ran[i][j]=0;
		System.out.println(val);
		if(val.contains("wr")||val.contains("br"))
		{
			System.out.println("wr");
			if('w'==val.charAt(0))
			{
					for(i=c+1;i<8;i++)
					{
						if('w'!=place[r][i].charAt(0))
						{
							ran[r][i]=1;
							if('b'==place[r][i].charAt(0))
								break;
						}
						else
							break;
					}
					System.out.print("jai mata di");
					for(i=c-1;i>=0;i--)
					{
						if('w'!=place[r][i].charAt(0))
						{
							ran[r][i]=1;
							if('b'==place[r][i].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1;i<8;i++)
					{
						if('w'!=place[i][c].charAt(0))
						{
							ran[i][c]=1;
							if('b'==place[i][c].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r-1;i>=0;i--)
					{
						if('w'!=place[i][c].charAt(0))
						{
							ran[i][c]=1;
							if('b'==place[i][c].charAt(0))
								break;
						}
						else
							break;
					}
			}
			else
			{
					for(i=c+1;i<8;i++)
					{
						if('b'!=place[r][i].charAt(0))
						{
							ran[r][i]=1;
							if('w'==place[r][i].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=c-1;i>=0;i--)
					{
						if('b'!=place[r][i].charAt(0))
						{
							ran[r][i]=1;
							if('w'==place[r][i].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1;i<8;i++)
					{
						if('b'!=place[i][c].charAt(0))
						{
							ran[i][c]=1;
							if('w'==place[i][c].charAt(0))
								break;
						}
						else
							break;

					}

					for(i=r-1;i>=0;i++)
					{
						if('b'!=place[i][c].charAt(0))
						{
							ran[i][c]=1;
							if('w'==place[i][c].charAt(0))
								break;
						}
						else
							break;
					}
			}
			
		}
		else if(val.contains("wkn")||val.contains("bkn"))
		{
			System.out.println("wkn");
			if('w'==val.charAt(0))
			{
				if(r-2>=0&&c-1>=0&&('w'!=place[r-2][c-1].charAt(0)))
					ran[r-2][c-1]=1;
				if(r-2>=0&&c+1<=7&&('w'!=place[r-2][c+1].charAt(0)))
					ran[r-2][c+1]=1;
				if(r+1<=7&&c-2>=0&&('w'!=place[r+1][c-2].charAt(0)))
					ran[r+1][c-2]=1;
				if(r+1<=7&&c+2<=7&&('w'!=place[r+1][c+2].charAt(0)))
					ran[r+1][c+2]=1;

				if(r+2<=7&&c-1>=0&&('w'!=place[r+2][c-1].charAt(0)))
					ran[r+2][c-1]=1;
				if(r+2<=7&&c+1<=7&&('w'!=place[r+2][c+1].charAt(0)))
					ran[r+2][c+1]=1;
				if(r-1>=0&&c-2>=0&&('w'!=place[r-1][c-2].charAt(0)))
					ran[r-1][c-2]=1;
				if(r-1>=0&&c+2<=7&&('w'!=place[r-1][c+2].charAt(0)))
					ran[r-1][c+2]=1;
			}
			else
			{
				if(r-2>=0&&c-1>=0&&('b'!=place[r-2][c-1].charAt(0)))
					ran[r-2][c-1]=1;
				if(r-2>=0&&c+1<=7&&('b'!=place[r-2][c+1].charAt(0)))
					ran[r-2][c+1]=1;
				if(r+1<=7&&c-2>=0&&('b'!=place[r+1][c-2].charAt(0)))
					ran[r+1][c-2]=1;
				if(r+1<=7&&c+2<=7&&('b'!=place[r+1][c+2].charAt(0)))
					ran[r+1][c+2]=1;

				if(r+2<=7&&c-1>=0&&('b'!=place[r+2][c-1].charAt(0)))
					ran[r+2][c-1]=1;
				if(r+2<=7&&c+1<=7&&('b'!=place[r+2][c+1].charAt(0)))
					ran[r+2][c+1]=1;
				if(r-1>=0&&c-2>=0&&('b'!=place[r-1][c-2].charAt(0)))
					ran[r-1][c-2]=1;
				if(r-1>=0&&c+2<=7&&('b'!=place[r-1][c+2].charAt(0)))
					ran[r-1][c+2]=1;
			}
		}
		else if(val.contains("wb")||val.contains("bb"))
		{
			System.out.println("wb");
			if('w'==val.charAt(0))
			{
					for(i=r-1,j=c+1;i>=0&&j<8;j++,i--)
					{
						if('w'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('b'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1,j=c+1;i<8&&j<8;j++,i++)
					{
						if('w'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('b'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1,j=c-1;i<8&&j>=0;j--,i++)
					{
						if('w'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('b'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r-1,j=c-1;i>=0&&j>=0;j--,i--)
					{
						if('w'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('b'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
			}
			else
			{
				if('b'==val.charAt(0))
				{
					for(i=r-1,j=c+1;i>=0&&j<8;j++,i--)
					{
						if('b'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('w'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1,j=c+1;i<8&&j<8;j++,i++)
					{
						if('b'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('w'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1,j=c-1;i<8&&j>=0;j--,i++)
					{
						if('b'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('w'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r-1,j=c-1;i>=0&&j>=0;j--,i--)
					{
						if('b'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('w'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
				}
			}
		}
		else if(val.contains("wq")||val.contains("bq"))
		{
			System.out.println("wq");
			if('w'==val.charAt(0))
			{
					for(i=r-1,j=c-1;i>=0&&j>=0;i--,j--)
					{
						if('w'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('b'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1,j=c+1;i<8&&j<8;i++,j++)
					{
						if('w'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('b'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r-1,j=c+1;i>=0&&j<8;j++,i--)
					{
						if('w'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('b'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1,j=c-1;i<8&&j>=0;j--,i++)
					{
						if('w'!=place[i][j].charAt(0))
						{
							ran[i][j]=1;
							if('b'==place[i][j].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=c+1;i<8;i++)
						if('w'!=place[r][i].charAt(0))
						{
							ran[r][i]=1;
							if('b'==place[r][i].charAt(0))
								break;
						}
						else
							break;
					for(i=c-1;i>=0;i--)
					{
						if('w'!=place[r][i].charAt(0))
						{
							ran[r][i]=1;
							if('b'==place[r][i].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r+1;i<8;i++)
					{
						if('w'!=place[i][c].charAt(0))
						{
							ran[i][c]=1;
							if('b'==place[i][c].charAt(0))
								break;
						}
						else
							break;
					}
					for(i=r-1;i>=0;i--)
					{
						if('w'!=place[i][c].charAt(0))
						{
							ran[i][c]=1;
							if('b'==place[i][c].charAt(0))
								break;
						}
						else
							break;
					}


				}
					else
					{
						for(i=r-1,j=c-1;i>=0&&j>=0;i--,j--)
						{
								if('b'!=place[i][j].charAt(0))
								{
									ran[i][j]=1;
									if('w'==place[i][j].charAt(0))
										break;
								}
								else
									break;
							}
							for(i=r+1,j=c+1;i<8&&j<8;i++,j++)
							{
								if('b'!=place[i][j].charAt(0))
								{
									ran[i][j]=1;
									if('w'==place[i][j].charAt(0))
										break;
								}
								else
									break;
							}
							for(i=r-1,j=c+1;i>=0&&j<8;j++,i--)
							{
								if('b'!=place[i][j].charAt(0))
								{
									ran[i][j]=1;
									if('w'==place[i][j].charAt(0))
										break;
								}
								else
									break;
							}
							for(i=r+1,j=c-1;i<8&&j>=0;j--,i++)
							{
								if('b'!=place[i][j].charAt(0))
								{
									ran[i][j]=1;
									if('w'==place[i][j].charAt(0))
										break;
								}
								else
									break;
							}
							for(i=c+1;i<8;i++)
							{
								if('b'!=place[r][i].charAt(0))
								{
									ran[r][i]=1;
									if('w'==place[r][i].charAt(0))
										break;
								}
								else
									break;
							}
							for(i=c-1;i>=0;i--)
							{
								if('b'!=place[r][i].charAt(0))
								{
									ran[r][i]=1;
									if('w'==place[r][i].charAt(0))
										break;
								}
								else
									break;
							}
							for(i=r+1;i<8;i++)
							{
								if('b'!=place[i][c].charAt(0))
								{
									ran[i][c]=1;
									if('w'==place[i][c].charAt(0))
										break;
								}
								else
									break;
							}
							for(i=r-1;i>=0;i--)
							{
								if('b'!=place[i][c].charAt(0))
								{
									ran[i][c]=1;
									if('w'==place[i][c].charAt(0))
										break;
								}
								else
									break;
							}
					}
		}
		else if(val.contains("wk")||val.contains("bk"))
		{
			System.out.println("wk");
			if('w'==val.charAt(0))
			{
					if(r-1>=0&&'w'!=place[r-1][c].charAt(0))
						ran[r-1][c]=1;
					if(r+1<8&&'w'!=place[r+1][c].charAt(0))
						ran[r+1][c]=1;
					if(c-1>=0&&'w'!=place[r][c-1].charAt(0))
						ran[r][c-1]=1;
					if(c+1<8&&'w'!=place[r][c+1].charAt(0))
						ran[r][c+1]=1;
					if(c+1<8&&r+1<8&&'w'!=place[r+1][c+1].charAt(0))
						ran[r+1][c+1]=1;
					if(c+1<8&&r-1>=0&&'w'!=place[r-1][c+1].charAt(0))
						ran[r-1][c+1]=1;
					if(c-1>=0&&r+1<8&&'w'!=place[r+1][c-1].charAt(0))
						ran[r+1][c-1]=1;
					if(c-1>=0&&r-1>=0&&'w'!=place[r-1][c-1].charAt(0))
						ran[r-1][c-1]=1;
			}
			else
			{
					if(r-1>=0&&'b'!=place[r-1][c].charAt(0))
						ran[r-1][c]=1;
					if(r+1<8&&'b'!=place[r+1][c].charAt(0))
						ran[r+1][c]=1;
					if(c-1>=0&&'b'!=place[r][c-1].charAt(0))
						ran[r][c-1]=1;
					if(c+1<8&&'b'!=place[r][c+1].charAt(0))
						ran[r][c+1]=1;
					if(c+1<8&&r+1<8&&'b'!=place[r+1][c+1].charAt(0))
						ran[r+1][c+1]=1;
					if(c+1<8&&r-1>=0&&'b'!=place[r-1][c+1].charAt(0))
						ran[r-1][c+1]=1;
					if(c-1>=0&&r+1<8&&'b'!=place[r+1][c-1].charAt(0))
						ran[r+1][c-1]=1;
					if(c-1>=0&&r-1>=0&&'b'!=place[r-1][c-1].charAt(0))
						ran[r-1][c-1]=1;
			}
		}
		else if(val.contains("wp")||val.contains("bp"))
		{
			System.out.println("wp");
			if('w'==val.charAt(0))
			{
				System.out.println("jas ef");
				if(r==6)
				{
					System.out.println("jas 6");
					if(r-1>=0&&'n'==place[r-1][c].charAt(0)&&'w'!=place[r-1][c].charAt(0))
						ran[r-1][c]=1;
					if(r-2>=0&&'n'==place[r-2][c].charAt(0)&&'w'!=place[r-2][c].charAt(0))
						ran[r-2][c]=1;
					if(r-1>=0&&c-1>=0&&'b'==place[r-1][c-1].charAt(0)&&'b'==place[r-1][c-1].charAt(0))
						ran[r-1][c-1]=1;
					if(r-1>=0&&c+1<8&&'b'==place[r-1][c+1].charAt(0)&&'b'==place[r-1][c+1].charAt(0))
						ran[r-1][c+1]=1;
				}
				else
				{
					System.out.println("jas !6");
					if(r-1>=0&&'n'==place[r-1][c].charAt(0)&&'w'!=place[r-1][c].charAt(0))
						ran[r-1][c]=1;
					if(r-1>=0&&c-1>=0&&'b'==place[r-1][c-1].charAt(0)&&'b'==place[r-1][c-1].charAt(0))
						ran[r-1][c-1]=1;
					if(r-1>=0&&c+1<8&&'b'==place[r-1][c+1].charAt(0)&&'b'==place[r-1][c+1].charAt(0))
						ran[r-1][c+1]=1;
				}

			}
			else
			{
				if(r==1)
				{
					if(r+1>=0&&'n'==place[r+1][c].charAt(0)&&'b'!=place[r+1][c].charAt(0))
						ran[r+1][c]=1;
					if(r+2>=0&&'n'==place[r+2][c].charAt(0)&&'b'!=place[r+2][c].charAt(0))
						ran[r+2][c]=1;
					if(r+1>=0&&c-1>=0&&'w'==place[r+1][c-1].charAt(0)&&'w'==place[r+1][c-1].charAt(0))
						ran[r+1][c-1]=1;
					if(r+1>=0&&c+1<8&&'w'==place[r+1][c+1].charAt(0)&&'w'==place[r+1][c+1].charAt(0))
						ran[r+1][c+1]=1;
				}
				else
				{
					if(r+1>=0&&'n'==place[r+1][c].charAt(0)&&'b'!=place[r+1][c].charAt(0))
						ran[r+1][c]=1;
					if(r+1>=0&&c-1>=0&&'w'==place[r+1][c-1].charAt(0)&&'w'==place[r+1][c-1].charAt(0))
						ran[r+1][c-1]=1;
					if(r+1>=0&&c+1<8&&'w'==place[r+1][c+1].charAt(0)&&'w'==place[r+1][c+1].charAt(0))
						ran[r+1][c+1]=1;
				}
			}
		}

		else
			System.out.println("jai mata di");
		return ran;


	}
	public Path checkIndex(Path node,int x,int y)
	{
		while(node!=null)
		{
			if(x>node.x-10&&x<node.x+90&&y>node.y-10&&y<node.y+100)
				return node;
			node=node.next;
		}
		return node;
	}
	public Path loct(Path p,int r,int c)
	{
		while(p!=null)
		{
			if(p.r==r&&p.c==c)
				return p;
			p=p.next;
		}
		return p;
	}

	public String[][] initArray()
	{
		String[][] arr=new String[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(i==0)
				{
					arr[0][0]="br1";
					arr[0][1]="bkn1";
					arr[0][2]="bb1";
					arr[0][3]="bq";
					arr[0][4]="bk";
					arr[0][5]="bb2";
					arr[0][6]="bkn2";
					arr[0][7]="br2";
					j=8;

				}
				else if(i==1)
				{
					arr[1][0]="bp1";
					arr[1][1]="bp2";
					arr[1][2]="bp3";
					arr[1][3]="bp4";
					arr[1][4]="bp5";
					arr[1][5]="bp6";
					arr[1][6]="bp7";
					arr[1][7]="bp8";
					j=8;
				}
				else if(i==6)
				{
					arr[6][0]="wp1";
					arr[6][1]="wp2";
					arr[6][2]="wp3";
					arr[6][3]="wp4";
					arr[6][4]="wp5";
					arr[6][5]="wp6";
					arr[6][6]="wp7";
					arr[6][7]="wp8";
					j=8;
				}
				else if(i==7)
				{
					arr[7][0]="wr1";
					arr[7][1]="wkn1";
					arr[7][2]="wb1";
					arr[7][3]="wq";
					arr[7][4]="wk";
					arr[7][5]="wb2";
					arr[7][6]="wkn2";
					arr[7][7]="wr2";
					j=8;

				}
				else
					arr[i][j]="n";
			}

		}
		return arr;
	}


	public Path initPath()
	{
		Path start=null,node=null,temp=null;
		int x=94,y=84;
		for(int i=0;i<=7;i++)
		{
			for(int j=0;j<=7;j++)
			{
				temp=new Path();
				temp.r=i;
				temp.c=j;
				temp.x=x;
				temp.y=y;
				temp.next=null;
				x=x+110;
				//System.out.println(temp.x+" "+temp.y+" "+temp.r+" "+temp.c);
				if(start==null)
				{
					start=temp;
					node=temp;
					
				}
				else
				{
					node.next=temp;
					node=temp;
				}

			}
			y=y+112;
			x=94;
		}
		
		return start;
	}
	public void show(Path p)
	{
		while(p!=null)
		{
			
			p=p.next;
		}
		
	}

}

class Path
{
	int r,c,x,y;
	Path next;
}
class chess
{
	public static void main(String[] args) {
		Game g=new Game();
	}
}
