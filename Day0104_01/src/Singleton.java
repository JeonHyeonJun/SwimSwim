//�̱������� : � Ŭ������ ��ü�� �Ѱ��� �����ǵ��� �ϴ� ���� ����

//1. �����ڸ� private���� �����
//2. ���������� �ڱ��ڽ� �������� Ÿ���� �غ��Ѵ�.
//3. �ڱ��ڽ��� ��ü�� ������ִ� �����޼ҵ带 �ۼ��ϵ�(2�� ���� ����)
//	2���� ���� ������ ��ü�� �������� �������� �����
//	2���� ���� ������ �����ϸ� �� ��ü�� �����Ѵ�
public class Singleton {
	private static Singleton instance;
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
}
