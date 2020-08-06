package com.jas.ext;

import com.alibaba.fastjson.JSON;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/06
 */
public class UserExt {

    private String ext;

    private String remark;

    private String remark1;

    public static class Extension {
        public String remark;
        public String remark1;

        public Extension() {
        }

        public Extension(UserExt userExt) {
            this.remark = userExt.remark;
            this.remark1 = userExt.remark1;
        }
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getExt() {
        return ext;
    }

    public void setRemark(String remark) {
        this.remark = remark;
        this.ext = buildExt();
    }

    public String getRemark() {
        if (null != remark) {
            return remark;
        }
        return parseExt().remark;
    }

    public String getRemark1() {
        if (null != remark1) {
            return remark1;
        }
        return parseExt().remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
        this.ext = buildExt();
    }

    private String buildExt() {
        Extension extension = new Extension(this);
        return JSON.toJSONString(extension);
    }

    private Extension parseExt() {
        if (null != ext) {
            return JSON.parseObject(ext, Extension.class);
        }
        return new Extension();
    }
}
