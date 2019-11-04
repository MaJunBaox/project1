package com.majunbao.demo.bean;


/**
 * author : Majunbao
 * date : 2019/8/16 9:04
 * description : 基础bean
 */
public class BaseResBean<K> {
    //状态描述desc	string
    protected String msg;
    //状态码	status	number
    protected String status;

    private String phone;
    //长青公海需要
    protected int uid;
    protected String token;

    //object 数据
    protected K data;

    public K getOut_data() {
        return data;
    }

    public void setOut_data(K out_data) {
        this.data = out_data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public K getData() {
        return data;
    }

    public void setData(K data) {
        this.data = data;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 判断请求结果是否正常
     *
     * @return
     */
    public boolean isOK() {
        return this.status.equals("1");
    }

    @Override
    public String toString() {
        return "BaseResBean{" +
                "msg='" + msg + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}

