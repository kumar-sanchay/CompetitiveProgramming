import java.io.*;


class Solution{

    public static void main(String args[]) throws IOException{

        String str = "Hello World"; 
        byte arr[] = str.getBytes();

        ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        int c;
        boolean a = false;
        try(PushbackInputStream pis = new PushbackInputStream(bais)){

            while((c=pis.read())!=-1){

                if(a){
                    // pis.skip(c);
                    // a = false;
                    continue;
                }
                if((char)c=='W'){
                    System.out.println('w');
                    pis.unread(c);
                    a = true;
                }else{
                    System.out.println((char)c);
                }
            }
        }
    }

}