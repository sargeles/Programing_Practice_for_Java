package io;
import java.io.*;  
public class DataStreamDemo  
{  
  public static void main(String[]args)  
  {  
     Member[] members = {new Member("Justin",90),  
                        new Member("momor",95),  
                        new Member("Bush",88)};  
        try  
     {  
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("C://Users//sargeles//Workspaces//MyEclipse Professional 2014//Coding_practice//src//io//iofile1.txt"));  
   
        for(Member member:members)  
        {  
            //д��UTF�ַ���  
           dataOutputStream.writeUTF(member.getName());  
           //д��int����  
           dataOutputStream.writeInt(member.getAge());  
        }  
   
        //����������Ŀ�ĵ�  
        dataOutputStream.flush();  
        //�ر���  
        dataOutputStream.close();  
   
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("C://Users//sargeles//Workspaces//MyEclipse Professional 2014//Coding_practice//src//io//iofile1.txt"));  
   
        //�������ݲ���ԭΪ����  
        for(int i=0;i<members.length;i++)  
        {  
           //����UTF�ַ���  
           String name =dataInputStream.readUTF();  
           //����int����  
           int score =dataInputStream.readInt();  
           members[i] = new Member(name,score);  
        }  
   
        //�ر���  
        dataInputStream.close();  
   
        //��ʾ��ԭ�������  
        for(Member member : members)  
        {  
           System.out.printf("%s\t%d%n",member.getName(),member.getAge());  
        }  
     }  
     catch(IOException e)  
     {  
            e.printStackTrace();  
     }  
  }  
} 

class Member {  
    private String name;  
    private int age;  
    public Member() {  
    }  
   public Member(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }  
    public void setName(String name){  
        this.name = name;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public String getName() {  
        return name;  
    }  
    public int getAge() {  
        return age;  
    }  
}  