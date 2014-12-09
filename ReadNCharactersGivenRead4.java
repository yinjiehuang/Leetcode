// Leetcode: Read N Characters Given Read4
// Author: Yinjie Huang
// Date: 12/07/2014
//
import java.util.*;

public class ReadNCharactersGivenRead4 {
        public static void main(String[] args) {
                System.out.println("Leetcode: Read N Characters Given Read4!!!");
                ReadNCharactersGivenRead4 rncgr = new ReadCharactersGivenRead4();
        }

        /* The read4 API is defined in the parent class Reader4.
        int read4(char[] buf); */    /*
        * @param buf Destination buffer
        * @param n   Maximum number of characters to read
        * @return    The number of characters read
        */
        public int read(char[] buf, int n) {
                char[] buffer = new char[4];
                int readBytes = 0;
                boolean eof = false;
                while (!eof && readBytes < n) {
                        int sz = read4(buffer);
                        if (sz < 4) {
                                eof = true;
                        }
                        int bytes = Math.min(n - readBytes, sz); 
                        System.arraycopy(buffer, 0, buf, readBytes, bytes);
                        readBytes += bytes;
                }
                return readBytes;
        }
}
