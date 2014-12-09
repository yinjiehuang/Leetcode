// Leetcode: Read N Characters Given Read4 II
// Author: Yinjie Huang
// Date: 12/07/2014
//
import java.util.*;

public class ReadNCharactersGivenRead4II {
        public static void main(String[] args) {
                System.out.println("Leetcode: Read N Characters Given Read4!!!");
                ReadNCharactersGivenRead4II rncgr = new ReadCharactersGivenRead4II();
        }

        private char[] buffer = new char[4]; 
        int offset = 0, bufsize = 0;
        /*
        * @param buf Destination buffer
        * @param n   Maximum number of characters to read
        * @return    The number of characters read
        */
        
        public int read(char[] buf, int n) { 
                int readBytes = 0;
                boolean eof = false;
                while (!eof && readBytes < n) {
                        if (bufsize == 0) { 
                                bufsize = read4(buffer); 
                                eof = bufsize < 4;
                        }
                        int bytes = Math.min(n - readBytes, bufsize); 
                        System.arraycopy(buffer, offset, buf, readBytes, bytes);
                        offset = (offset + bytes) % 4;
                        bufsize -= bytes;
                        readBytes += bytes;
                }
                return readBytes; 
        }
}

