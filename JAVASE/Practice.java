package test;

public class Practice {

	//�����ַ����е����֡���д��ĸ��Сд��ĸ
	public static void OutPut(String str){
		
		int i=0,j=0,l=0;
		char b;
		
		for(int k = 0;k < str.length();k++){
			b = str.charAt(k);
			if(b>=65 && b<=90){
				i++;
			}else if(b>=97&&b<=122){
				j++;
			}else{
				l++;
			}	
		}
		
		System.out.println("��дӢ����Ϊ:" + i);
		System.out.println("СдӢ����Ϊ:" + j);
		System.out.println("��Ӣ����Ϊ:" + l);
	}
	
	//�����ַ������ִ���
	public static void CaculateNum(String str){
		int i = 0;
		int j = 0;
		int k = 0;
		String judge = "ab";
		
		do{
			i=str.indexOf(judge,j);
			if(i!=-1){
				k++;
				j = i+1;
			}	
		}while(i!=-1);
		System.out.println("���ַ������ִ���Ϊ:" + k);
	}
	
	//�Ƚ��ַ��������Ƿ����
	public static void JudgeString(String str1,String str2){
		char a;
		char b;
		if(str1.length()==str2.length()){
			for(int i = 0;i < str1.length();i++){
				a = str1.charAt(i);
				b = str2.charAt(i);
				if(a==b){
					if(i==str1.length()-1){
						System.out.println("�������ַ������");
					}
					continue;
				}else{
					System.out.println("�����ַ��������");
					break;
				}
			}
		
		}else{
			System.out.println("�����ַ��������");
		}

	}
	
	//��д����
	public static void BigWrite(String str){
		String str1 = str.toUpperCase();
		System.out.println(str1);
		System.out.println(str1.substring(1));
	}
	
	//��ת�ַ���
	public static char[] ChangeIndex(String str){
		char a[] = new char[str.length()];
		
		for(int i = 0;i < str.length();i++){
			a[i] = str.charAt(str.length()-i-1);
		}
	
		for(int i = 0;i < str.length();i++){
			System.out.print(a[i]);
		}
		return a;
	}
	//�ж��ַ��Ƿ�Գ�
	public static void JudgeSymmetry(String str){
		
		char a[] = new char[str.length()];
		char b[] = new char[str.length()];
		for(int i = 0;i < str.length();i++){
			a[i] = str.charAt(str.length()-i-1);
		}
		for(int i = 0;i < str.length();i++){
			b[i] = str.charAt(str.length()-1);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String str = "asfJHKJK123KBBBag";
		OutPut(str);*/
		/*String str = "aabbcbcddabababaaaaaaaaaaakkababbbab";
		CaculateNum(str);*/
		/*String str1 = "asdbaaaaa";
		String str2 = "asdbaaaaaa";
		JudgeString(str1,str2);*/
		/*String str = "jdk";
		BigWrite(str);*/
		String a = "abcde";
		char b[] = new char[5];
		b = ChangeIndex(a);
		for(int i = 0;i < b.length;i++){
			System.out.print(b[i]);
		}
	}

}


