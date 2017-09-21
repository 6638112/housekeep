package com.tls.sigcheck;

import com.connxun.util.properties.OpeProperties;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-21 17:09
 * @Comments：tls生成Sig和验证Sig工具类
 */
public class TlsSigUtil {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger("tlsLog");

    /*tls私钥*/
	private static File priKeyFile;
	/*tls公钥*/
	private static File pubKeyFile;;
	/*tls验证实体*/
	private static tls_sigcheck sigcheck;
	/*sdkAppid*/
	private static String sdkAppid;

	/*静态初始化*/
	static {
        priKeyFile=new File(OpeProperties.GetValueByKey("","tls.private_key").trim());

        pubKeyFile=new File(OpeProperties.GetValueByKey("","tls.public_key").trim());;

        sigcheck = new tls_sigcheck();

//        sdkAppid=OpeProperties.GetValueByKey("","tls.sdkappid").trim();
        sdkAppid=TlsConstantAPI.SDKAPPID;

        String os = OpeProperties.GetValueByKey("","os.name").trim();

        /*判断操作系统类型*/
        if(os.toLowerCase().startsWith("windows")){
            /*加载dll运行库*/
            sigcheck.loadJniLib(OpeProperties.GetValueByKey("","tls.dll").trim());
        }else{
            sigcheck.loadJniLib(OpeProperties.GetValueByKey("","tls.so").trim());
        }
    }

//	public TlsSigUtil() {
//        sigcheck = new tls_sigcheck();
//
//        String os = OpeProperties.GetValueByKey("","os.name").trim();
//
//        /*判断操作系统类型*/
//        if(os.toLowerCase().startsWith("windows")){
//            /*加载dll运行库*/
//        	sigcheck.loadJniLib(OpeProperties.GetValueByKey("","tls.dll").trim());
//        }else{
//        	sigcheck.loadJniLib(OpeProperties.GetValueByKey("","tls.so").trim());
//        }
//        sdkAppid = OpeProperties.GetValueByKey("","tls.so").trim();
//
//	}

	/**
	 * 使用prikey生成sig
	 * @param identifier 用户ID
	 * @return
	 * @throws Exception
	 */
	public static CheckResultEntity genSig(String identifier ) throws Exception {

        CheckResultEntity resultEntity = new CheckResultEntity();
        StringBuilder strBuilder = new StringBuilder();
        String s = "";

        BufferedReader br = new BufferedReader(new FileReader(priKeyFile));
        while ((s = br.readLine()) != null) {
            strBuilder.append(s + '\n');
        }
        br.close();
        String priKey = strBuilder.toString();
        int ret = sigcheck.tls_gen_signature_ex2(sdkAppid, identifier, priKey);
        resultEntity.setRet(ret);
        if (0 != ret) {
            logger.error("identifier "+identifier+"  ret " + ret + " " + sigcheck.getErrMsg());
            resultEntity.setOk(false);
            resultEntity.setErrMsg(sigcheck.getErrMsg());
        }
        else
        {
            logger.info("sig:\n" + sigcheck.getSig());
            resultEntity.setOk(true);
            resultEntity.setSig(sigcheck.getSig());
        }

        return resultEntity;
	}

	/**
	 * 使用pubkey验证sig
	 * @param identifier 用户ID
	 * @param sig 私钥加密sig
	 * @return
	 * @throws Exception
	 */
	public static CheckResultEntity checkSig(String identifier, String sig) throws Exception {
        CheckResultEntity resultEntity = new CheckResultEntity();
        StringBuilder strBuilder = new StringBuilder();
        String s = "";
        BufferedReader br = new BufferedReader(new FileReader(pubKeyFile));
        strBuilder.setLength(0);
        while ((s = br.readLine()) != null) {
            strBuilder.append(s + '\n');
        }
        br.close();
        String pubKey = strBuilder.toString();
        int ret = sigcheck.tls_check_signature_ex2(sig, pubKey, sdkAppid, identifier);
        if (0 != ret) {
            logger.error("identifier "+identifier+"  ret " + ret + " " + sigcheck.getErrMsg());
            resultEntity.setOk(false);
            resultEntity.setErrMsg(sigcheck.getErrMsg());
        }
        else
        {
            logger.info("--\nverify ok -- expire time " + sigcheck.getExpireTime() + " -- init time " + sigcheck.getInitTime());
            resultEntity.setOk(true);
            resultEntity.setSig(sig);
            resultEntity.setExpireTime(sigcheck.getExpireTime());
            resultEntity.setInitTime(sigcheck.getInitTime());
        }
        return resultEntity;
	}

	public static void main(String[] args) throws Exception {
		try {
//			String sig = JsonKit.toJson(new TlsSigUtil().genSin("wyl123456"));
			CheckResultEntity resultEntity= genSig("wyl123456");
//			System.out.println(resultEntity.getSig());
			resultEntity = checkSig("wyl123456", resultEntity.getSig());
//			System.out.println(JsonKit.toJson(resultEntity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

