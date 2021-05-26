import java.io.*;

class Solution{


    public static void main(String args[]) throws Exception{
        
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("example.txt"))){
            
            dos.writeInt(12);
            dos.writeChars("Hello World");
        }


        FileInputStream fos = new FileInputStream("example.txt");
        try(DataInputStream dis = new DataInputStream(fos)){


            System.out.println(dis.readInt());
            System.out.println(dis.readChar());
        }
    }
}