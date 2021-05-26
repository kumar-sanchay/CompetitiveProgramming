import java.io.*;

class Solution{

    public static void main(String args[]) throws Exception{ 

        try(FileInputStream fis = new FileInputStream("example.txt")){
            
            int size = fis.available();

            for(int i=0; i<size; i++){

                System.out.println((char)fis.read());
            }
        }

        String str = "My World";

        byte arr[] = str.getBytes();

        try(FileOutputStream fos = new FileOutputStream("example.txt")){

            fos.write(arr);
        }
    }
}