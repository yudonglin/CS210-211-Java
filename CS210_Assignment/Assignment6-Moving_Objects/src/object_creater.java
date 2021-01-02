import java.awt.*;
import javax.swing.JFrame;
import java.util.*; 

class shape_value {
	int x;
	int y;
	int size;
	int speedX;
	int speedY;
	Color color;
	}

public class object_creater extends JFrame{
	private static final long serialVersionUID = 1L;
	public static ArrayList<shape_value> myShapeList = new ArrayList<>();  //创建储存图案数据的列表
	public static ArrayList<Integer> shape_maount = new ArrayList<>();
	static int width = 800; //界面的宽度
	static int height = 600; //界面的高度
	public static Scanner console = new Scanner(System.in);
	public static final Random random = new Random();
	
	public object_creater () {     // Constructor (Ch08)
        super("Homework");  //文件启动时的名字
        setBounds(100, 100, width, height);  //屏幕上显示的位置
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
	public static void data_input(int howMany,ArrayList<shape_value> myShapeList){
		Random random = new Random();
		int R, G, B;
		for(int i=0; i<howMany; i++){
			shape_value s = new shape_value();  //载入x,y,speed的定义
            R = random.nextInt(256); //随机R的颜色
            G = random.nextInt(256); //随机G的颜色
            B = random.nextInt(256); //随机B的颜色
            s.color = new Color(R, G, B); //给图案上色
            s.x = random.nextInt(width-29)+29;  //图案出现的x轴，范围：29-宽最大值， 29为上方bar的宽度
            s.y = random.nextInt(height+29)+29; //图案出现的Y轴，范围：29-宽最大值
            s.size = random.nextInt(10)+10;  //图案的大小：20-10
            s.speedX = random.nextInt(5)+1;  //图案在x轴上的移动速度
            s.speedY = random.nextInt(5)+1;  //图案在y轴上的移动速度
            myShapeList.add(s);  //将图案的数据导入图案数据的列表中
        }
	}
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);  //将界面底色设置为黑色
		g.fillRect(0, 0, width, height);
		int boradTop = height-getContentPane().getSize().height;  //获取顶上bar的高度
		//画星形  draw star
		for (int i = 0; i < shape_maount.get(0); i++){		
			g.setColor(myShapeList.get(i).color);
	        double ch = 72 * Math.PI / 180;// 圆心角的弧度数
	        int x1 = myShapeList.get(i).x;  //原点  start point for x
	        int x2 = (int) (myShapeList.get(i).x - Math.sin(ch) * myShapeList.get(i).size);
	        int x3 = (int) (myShapeList.get(i).x + Math.sin(ch) * myShapeList.get(i).size);
	        int x4 = (int) (myShapeList.get(i).x - Math.sin(ch / 2) * myShapeList.get(i).size);
	        int x5 = (int) (myShapeList.get(i).x + Math.sin(ch / 2) * myShapeList.get(i).size);        
	        int y1 = myShapeList.get(i).y - myShapeList.get(i).size; //原点  start point for y
	        int y2 = (int) (myShapeList.get(i).y - Math.cos(ch) * myShapeList.get(i).size);
	        int y3 = y2;
	        int y4 = (int) (myShapeList.get(i).y + Math.cos(ch / 2) * myShapeList.get(i).size);
	        int y5 = y4;	        
	        int bx = (int) (myShapeList.get(i).x + Math.cos(ch) * Math.tan(ch / 2) * myShapeList.get(i).size);
	        int by = y2;
	        Polygon a = new Polygon();
	        Polygon b = new Polygon();
	        a.addPoint(x2, y2);
	        a.addPoint(x5, y5);
	        a.addPoint(bx, by);
	        b.addPoint(x1, y1);
	        b.addPoint(bx, by);
	        b.addPoint(x3, y3);
	        b.addPoint(x4, y4);
			myShapeList.get(i).x += myShapeList.get(i).speedX;
			if(myShapeList.get(i).x+myShapeList.get(i).size >= getWidth() || myShapeList.get(i).x-myShapeList.get(i).size <= 0) {myShapeList.get(i).speedX = myShapeList.get(i).speedX*-1;}
			myShapeList.get(i).y += myShapeList.get(i).speedY;
			if(myShapeList.get(i).y+myShapeList.get(i).size >= getHeight() || myShapeList.get(i).y-myShapeList.get(i).size <= boradTop) {myShapeList.get(i).speedY = myShapeList.get(i).speedY*-1;}			
	        g.fillPolygon(a);
	        g.fillPolygon(b);
		}		
		//画长方形  draw rect
		for (int i = shape_maount.get(0); i < shape_maount.get(0)+shape_maount.get(1); i++){
			g.setColor(myShapeList.get(i).color);
			myShapeList.get(i).x += myShapeList.get(i).speedX;
			if(myShapeList.get(i).x+myShapeList.get(i).size >= getWidth() || myShapeList.get(i).x <= 0) {myShapeList.get(i).speedX = myShapeList.get(i).speedX*-1;}
			myShapeList.get(i).y += myShapeList.get(i).speedY;
			if(myShapeList.get(i).y+myShapeList.get(i).size >= getHeight() || myShapeList.get(i).y <= boradTop) {myShapeList.get(i).speedY = myShapeList.get(i).speedY*-1;}
			g.fillRect(myShapeList.get(i).x, myShapeList.get(i).y, myShapeList.get(i).size, myShapeList.get(i).size);
		}		
		//画圆形  draw circle		
		for (int i = shape_maount.get(0)+shape_maount.get(1); i < shape_maount.get(0)+shape_maount.get(1)+shape_maount.get(2); i++){
			g.setColor(myShapeList.get(i).color);
			myShapeList.get(i).x += myShapeList.get(i).speedX;
			if(myShapeList.get(i).x+myShapeList.get(i).size >= getWidth() || myShapeList.get(i).x <= 0) {myShapeList.get(i).speedX = myShapeList.get(i).speedX*-1;}
			myShapeList.get(i).y += myShapeList.get(i).speedY;
			if(myShapeList.get(i).y+myShapeList.get(i).size >= getHeight() || myShapeList.get(i).y <= boradTop) {myShapeList.get(i).speedY = myShapeList.get(i).speedY*-1;}
			g.fillOval(myShapeList.get(i).x, myShapeList.get(i).y, myShapeList.get(i).size, myShapeList.get(i).size);
		}
		
		try{
			Thread.sleep(10);
		} catch (Exception exc){}
		repaint();
	}

	public static void main(String[] args) {
		System.out.print("How many objects do you want to create:");
		int amount_of_objects = console.nextInt();
		int amount_of_star = amount_of_objects/2;
		int amount_of_circle = random.nextInt(amount_of_objects-amount_of_star);
		int amount_of_rectangle = amount_of_objects-amount_of_star-amount_of_circle;
		shape_maount.add(amount_of_star);
		shape_maount.add(amount_of_circle);
		shape_maount.add(amount_of_rectangle);
		data_input(amount_of_star,myShapeList);
		data_input(amount_of_circle, myShapeList);
		data_input(amount_of_rectangle,myShapeList);
		new object_creater();
	}
}
