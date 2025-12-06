package edu.supmti.hadoop;

import java.io.IOException;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;

public class WriteHDFS {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: WriteHDFS <filepath> <message>");
            System.exit(1);
        }
        
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
        Path nomcomplet = new Path(args[0]);
        
        if (!fs.exists(nomcomplet)) {
            FSDataOutputStream outStream = fs.create(nomcomplet);
            outStream.writeUTF("Bonjour tout le monde !\n");
            outStream.writeUTF(args[1] + "\n");
            outStream.close();
            System.out.println("File created successfully: " + args[0]);
        } else {
            System.out.println("File already exists: " + args[0]);
        }
        
        fs.close();
    }
}