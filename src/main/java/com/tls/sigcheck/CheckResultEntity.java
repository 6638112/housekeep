package com.tls.sigcheck;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-20 18:30
 * @Comments：tls检查结果实体类
 */
public class CheckResultEntity {
	//验证结果
	private boolean isOk = false;
	//加密Sig
	private String sig=null;
	//过期时间
	private int expireTime;
	//有效时间
	private int initTime;
	//错误信息
	private String errMsg;
	//错误编码
	private int ret;
	
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public int getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
	public int getInitTime() {
		return initTime;
	}
	public void setInitTime(int initTime) {
		this.initTime = initTime;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public int getRet() {
		return ret;
	}
	public void setRet(int ret) {
		this.ret = ret;
	}
	@Override
	public String toString() {
		return "CheckResultEntity [isOk=" + isOk + ", sig=" + sig
				+ ", expireTime=" + expireTime + ", initTime=" + initTime
				+ ", errMsg=" + errMsg + ", ret=" + ret + "]";
	}

	
	
	
	
}
