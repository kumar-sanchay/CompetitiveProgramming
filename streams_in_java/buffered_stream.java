import java.io.*;

class Solution{

    public static void main(String args[]) throws Exception{

        String str = "Hello World";

        byte arr[] = str.getBytes();

        ByteArrayInputStream bais = new ByteArrayInputStream(arr);

        try(BufferedInputStream bis = new BufferedInputStream(bais)){

            for(int i=0; i<arr.length; i++)
                System.out.print((char)bis.read());
        }
    }
}
