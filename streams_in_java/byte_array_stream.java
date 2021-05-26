import java.io.*;

class Solution{
    // Does not required close method
    public static void main(String args[]) throws Exception{

        String str = "Hello EveryOne";

        byte arr[] = str.getBytes();

        try(ByteArrayInputStream bais = new ByteArrayInputStream(arr)){

            for(int i=0; i<arr.length; i++){

                if(i==9) bais.mark(i);

                System.out.println((char)bais.read());
            }

            bais.reset();

            byte a[] = bais.readAllBytes();
            
            System.out.println(new String(a));
        }

        str = "Changed";
        arr = str.getBytes();
        byte new_arr[];

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){

            baos.write(arr);
            new_arr = baos.toByteArray();
        }

        System.out.println(new String(new_arr));
        

    }
}
