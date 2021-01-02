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
	public static ArrayList<Star> myStar = new ArrayList<>();  //����mystar�б�
	static int width = 800; //����Ŀ��
	static int height = 600; //����ĸ߶�
	static int howMany = 50; //ͼ������

	public cs210Star() {     // Constructor (Ch08)
        super("Your Title");  //�ļ�����ʱ������
        setBounds(100, 100, width, height);  //��Ļ����ʾ��λ��
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
	public static void createStar(){
		Random random = new Random();
		int R, G, B;
		for(int i=0; i<howMany; i++){
        	Star s = new Star();  //����x,y,speed�Ķ���
            R = random.nextInt(256); //���R����ɫ
            G = random.nextInt(256); //���G����ɫ
            B = random.nextInt(256); //���B����ɫ
            s.color = new Color(R, G, B); //��ͼ����ɫ
            s.x = random.nextInt(width-29)+29;  //ͼ�����ֵ�x�ᣬ��Χ��29-�����ֵ�� 29Ϊ�Ϸ�bar�Ŀ��
            s.y = random.nextInt(height-29)+29; //ͼ�����ֵ�Y�ᣬ��Χ��29-�����ֵ
            s.size = random.nextInt(10)+10;  //ͼ���Ĵ�С��20-10
            s.speedX = random.nextInt(5)+1;  //ͼ����x���ϵ��ƶ��ٶ�
            s.speedY = random.nextInt(5)+1;  //ͼ����y���ϵ��ƶ��ٶ�
            myStar.add(s);  //��ͼ�������ݵ���mystar�б���
            }
	}
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);  //�������ɫ����Ϊ��ɫ
		g.fillRect(0, 0, width, height);
		int boradTop = height-getContentPane().getSize().height;  //��ȡ����bar�ĸ߶�
			for (int i = 0; i < myStar.size(); i++){   // mystar�б�ĳ��ȵ���howmany,��ͼ��������
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
