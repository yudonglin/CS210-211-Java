
public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number3 = {15, 56, 24, 5, 39, -4, 27, 10};
		selectionSort(number3);
	}
	public static void selectionSort(int[] arr) {
        System.out.println("����֮ǰ��");
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
        //ѡ��������Ż�
        for(int i = 0; i < arr.length - 1; i++) {// ����i������
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// ѡ��С�ļ�¼
                if(arr[j] < arr[k]){ 
                    k = j; //����Ŀǰ�ҵ�����Сֵ���ڵ�λ��
                }
            }
            //���ڲ�ѭ��������Ҳ�����ҵ�����ѭ������С�����Ժ��ٽ��н���
            if(i != k){  //����a[i]��a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
            System.out.print("{");
            for(int num:arr){
                System.out.print(num+", ");
            }
            System.out.print("}");
            System.out.println();
        }
	}
}
