package com.connxun.app.jsonBean;

/**
 * Created by anna on 2017-09-18.
 */
public class ChannelListBean {

    private String errmsg;
    //错误描述
    private String message;
    //消息内容
    private Output output;
    //错误码   0表示成功；其他值表示失败
    private int ret;
    private int retcode;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }
}
