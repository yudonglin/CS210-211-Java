import java.awt.*;
import javax.swing.JFrame;
import java.util.*; 

class Star {
	int x;
	int y;
	int size;
	int speedX;
	int speedY;
	Color color;
	}


public class cs210Star extends JFrame{;
	private static final long serialVersionUID = 1L;
	public static ArrayList<Star> myStar = new ArrayList<>();  //创建mystar列表
	static int width = 800; //界面的宽度
	static int height = 600; //界面的高度
	static int howMany = 50; //图案数量

	public cs210Star() {     // Constructor (Ch08)
        super("Your Title");  //文件启动时的名字
        setBounds(100, 100, width, height);  //屏幕上显示的位置
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
	public static void createStar(){
		Random random = new Random();
		int R, G, B;
		for(int i=0; i<howMany; i++){
        	Star s = new Star();  //载入x,y,speed的定义
            R = random.nextInt(256); //随机R的颜色
            G = random.nextInt(256); //随机G的颜色
            B = random.nextInt(256); //随机B的颜色
            s.color = new Color(R, G, B); //给图案上色
            s.x = random.nextInt(width-29)+29;  //图案出现的x轴，范围：29-宽最大值， 29为上方bar的宽度
            s.y = random.nextInt(height-29)+29; //图案出现的Y轴，范围：29-宽最大值
            s.size = random.nextInt(10)+10;  //图案的大小：20-10
            s.speedX = random.nextInt(5)+1;  //图案在x轴上的移动速度
            s.speedY = random.nextInt(5)+1;  //图案在y轴上的移动速度
            myStar.add(s);  //将图案的数据导入mystar列表中
            }
	}
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);  //将界面底色设置为黑色
		g.fillRect(0, 0, width, height);
		int boradTop = height-getContentPane().getSize().height;  //获取顶上bar的高度
			for (int i = 0; i < myStar.size(); i++){   // mystar列表的长度等于howmany,即图案的数量
			g.setColor(myStar.get(i).color);
			myStar.get(i).x += myStar.get(i).speedX;
			if(myStar.get(i).x > getWidth() || myStar.get(i).x < boradTop) {myStar.get(i).speedX = myStar.get(i).speedX*-1;}
			myStar.get(i).y += myStar.get(i).speedY;
			if(myStar.get(i).y > getHeight() || myStar.get(i).y < boradTop) {myStar.get(i).speedY = myStar.get(i).speedY*-1;}
			drawStar(g, myStar.get(i).x, myStar.get(i).y, myStar.get(i).size);
			}
		try{
			Thread.sleep(10);
		} catch (Exception exc){}
		repaint();
	}


	 public void drawStar(Graphics g, int sx, int sy, int size) {
		 g.fillRect(sx, sy, size, size);
	 }
	 public static void main(String[] args) {
		 createStar();
		 new cs210Star();
	 }
}
