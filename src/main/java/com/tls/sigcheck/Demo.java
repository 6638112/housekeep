package com.tls.sigcheck;

import com.connxun.util.properties.OpeProperties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

// 由于生成 sig 和校验 sig 的接口使用方法类似，故此处只是演示了生成 sig 的接口调用

// 使用的编译命令是
// javac -encoding utf-8 Demo.java
// 使用的运行命令是
// java Demo

public class Demo {
    InputStream ins = this.getClass().getResourceAsStream("/application.properties");

    public static void main(String args[]) throws Exception {

//        Properties pps = new Properties();
//        try {
//
//            // 利用文件流方式获取路径————
////            InputStream in = new BufferedInputStream(new FileInputStream("D:\\IdeaProjects\\housekeep\\target\\classes\\application.properties"));
////            pps.load(in);
//
//            // 利用反射的方式获取路径————
//            // 原本是要用this，这里是tatic所以取父类Object.class或者换成int.class同理
//            // 带 / 是读取classpath的根目录，不带读取当前类所在同一文件夹下.properties
//            InputStream in = Object.class.getResourceAsStream("/application.properties");
//            pps.load(in);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

        tls_sigcheck demo = new tls_sigcheck();
        
        // 使用前请修改动态库的加载路径
//         demo.loadJniLib(pps.getProperty("tls.dll").trim());
        demo.loadJniLib(OpeProperties.GetValueByKey("","tls.dll").trim());
//        demo.loadJniLib("/home/tls/tls_sig_api/src/jnisigcheck.so");
        
        File priKeyFile = new File(OpeProperties.GetValueByKey("","tls.private_key").trim());
        StringBuilder strBuilder = new StringBuilder();
        String s = "";
        
        BufferedReader br = new BufferedReader(new FileReader(priKeyFile));
        while ((s = br.readLine()) != null) {
            strBuilder.append(s + '\n');
        }
        br.close();
        String priKey = strBuilder.toString();        
		int ret = demo.tls_gen_signature_ex2("1400019251", "admin", priKey);
        
        if (0 != ret) {
            System.out.println("ret " + ret + " " + demo.getErrMsg());
        }
        else
        {
            System.out.println("sig:\n" + demo.getSig());
        }      

        File pubKeyFile = new File(OpeProperties.GetValueByKey("","tls.public_key").trim());
        br = new BufferedReader(new FileReader(pubKeyFile));
		strBuilder.setLength(0);
        while ((s = br.readLine()) != null) {
            strBuilder.append(s + '\n');
        }
        br.close();
        String pubKey = strBuilder.toString();        
		ret = demo.tls_check_signature_ex2(demo.getSig(), pubKey, "1400019251", "admin");
        if (0 != ret) {
            System.out.println("ret " + ret + " " + demo.getErrMsg());
        }
        else
        {
//            System.out.println("--\nverify ok -- expire time " + demo.getExpireTime() + " -- init time " + demo.getInitTime());
        }      
    }
}
