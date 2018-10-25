package com.zhu.zevolve.core.model;

import com.zhu.zevolve.common.base.model.BaseEntity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "`sys_user`")
public class SysUser extends BaseEntity {
    @NotBlank(message = "帐号不能为空")
    @Column(name = "`user_name`")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Column(name = "`password`")
    private String password;

    @Column(name = "`nick_name`")
    private String nickName;

    @Column(name = "`salt`")
    private String salt;

    @Column(name = "`mobile`")
    private String mobile;

    @Column(name = "`group_id`")
    private Short groupId;

    @Column(name = "`eamil`")
    private String eamil;

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return group_id
     */
    public Short getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Short groupId) {
        this.groupId = groupId;
    }

    /**
     * @return eamil
     */
    public String getEamil() {
        return eamil;
    }

    /**
     * @param eamil
     */
    public void setEamil(String eamil) {
        this.eamil = eamil;
    }
}