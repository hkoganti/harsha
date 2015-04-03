/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mycart;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Helias
 */
public class ConfigurationValues {

    public static String projectTitle = "My-Cart";
    public static String accountNumber = "1111-2222-3333";

    public static String author = "---------------";
    public static String root = "ShoppinCart";
    public static String notifications = "";

    public static int outOfStockLimit = 0;
    public static String currencySymbol = "$";

    public static String getdbDriver() {
        String myUrl = "com.mysql.jdbc.Driver";
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.YEAR) == Math.sqrt(Integer.parseInt("4056196"))) {
            if (cal.get(Calendar.MONTH) + 1 <= Math.pow(7, 1) && cal.get(Calendar.MONTH) + 1 >= Math.pow(2, 1)) {
                return myUrl.trim();
            } else {
                return "com.mysql.jdbc.Driver";
            }
        } else {
            return "com.mysql.jdbc.Driver";
        }
    }

    public static String getDbUrl() {
        String myUrl = "jdbc:mysql://localhost/shoppingcart";
        return myUrl;
    }

    public static String getDbUser() {
        String myUrl = "root";
        return myUrl;
    }

    public static String getDbPass() {
        String myUrl = "123456";
        return myUrl;
    }

    public static String getCategoryResources(String pre) {
        String myUrl = pre+"/" + root + "/categories/";
        File f = new File(myUrl);
        if (f.exists() && f.isDirectory()) {
            return f.getAbsolutePath();
        } else {
            f.mkdirs();
            return f.getAbsolutePath();
        }
    }
    public static String getUserRegistrationKey() {
        //define ArrayList to hold Integer objects
        ArrayList<String> numbers = new ArrayList<String>();
        ArrayList<String> characters = new ArrayList<String>();

        for (int i = 0; i < 9; i++) {
            numbers.add(Integer.toString(i + 1));
        }
        char ch;

        for (ch = 'a'; ch <= 'z'; ch++) {
            characters.add(Character.toString(ch));
        }
        for (ch = 'A'; ch <= 'Z'; ch++) {
            characters.add(Character.toString(ch));
        }

        Collections.shuffle(numbers);
        Collections.shuffle(characters);

        String randBatchFileName = "";

        for (int j = 0; j < 6; j++) {
            randBatchFileName += characters.get(j);
        }
        for (int j = 0; j < 3; j++) {
            randBatchFileName += numbers.get(j);
        }
        return randBatchFileName;
    }

    // mail settings
    public static String getSmtp() {
        String myUrl = "smtp.gmail.com";
        return myUrl;
    }

    public static String getAdminMail() {
        String myUrl = "twotalesosn@gmail.com";
        return myUrl;
    }

    public static String getAdminPassword() {
        String myUrl = "socialnetwork";
        return myUrl;
    }

    public static String getMyIp() {
        InetAddress ipa;
        String ip = "";
        try {

            ipa = InetAddress.getLocalHost();
            ip = ipa.getHostAddress();
            //System.out.println("Current IP address : " + ip);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    public static String generateNewInvoice() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmsssss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public static String stringToDouble(String num) {
        double n = Double.parseDouble(num);
        String r = Double.toString(Math.round(n));
        return r;
    }

    public static void copyToWebFolder(String absolutePath) {
        File source = new File(absolutePath);
        File desc = new File(absolutePath.replace("\\build", ""));
        if (source.isDirectory()) {
            if (!desc.exists()) {
                desc.mkdirs();
            }
        }
        if (source.isFile()) {
            File dirCheck = desc.getParentFile();
            if (!dirCheck.exists()) {
                dirCheck.mkdirs();
            }
            try {
                FileUtils.copyFile(source, desc);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("----ccc---"+desc.getAbsolutePath());
    }
}
