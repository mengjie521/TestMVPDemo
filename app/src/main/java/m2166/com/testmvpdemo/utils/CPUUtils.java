package m2166.com.testmvpdemo.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/**
 * author： mengjie on 2017/8/28.
 * email: weidadajie@163.com
 */

public class CPUUtils {
    //CPU个数
    public static int getNumCores() {
        //Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                //Check if filename is "cpu", followed by a single digit number
                if(Pattern.matches("cpu[0-9]", pathname.getName())) {
                    return true;
                }
                return false;
            }
        }

        try {
            //Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            //Filter to only list the devices we care about
            File[] files = dir.listFiles(new CpuFilter());
            //Return the number of cores (virtual CPU devices)
            return files.length;
        } catch(Exception e) {
            //Print exception
            e.printStackTrace();
            //Default to return 1 core
            return 1;
        }
    }
}
