package test;

public class Practice {

	//计算字符串中的数字、大写字母、小写字母
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
		
		System.out.println("大写英文数为:" + i);
		System.out.println("小写英文数为:" + j);
		System.out.println("非英文数为:" + l);
	}
	
	//计算字符串出现次数
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
		System.out.println("该字符串出现次数为:" + k);
	}
	
	//比较字符串内容是否相等
	public static void JudgeString(String str1,String str2){
		char a;
		char b;
		if(str1.length()==str2.length()){
			for(int i = 0;i < str1.length();i++){
				a = str1.charAt(i);
				b = str2.charAt(i);
				if(a==b){
					if(i==str1.length()-1){
						System.out.println("这两个字符串相等");
					}
					continue;
				}else{
					System.out.println("两个字符串不相等");
					break;
				}
			}
		
		}else{
			System.out.println("两个字符串不相等");
		}

	}
	
	//大写程序
	public static void BigWrite(String str){
		String str1 = str.toUpperCase();
		System.out.println(str1);
		System.out.println(str1.substring(1));
	}
	
	//翻转字符串
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
	//判断字符是否对称
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


