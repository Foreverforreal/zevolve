package com.zhu.zevolve.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /*
    realm相当于一个数据源，shiro从此方法获取所要验证用户信息，交由securityManager进行验证，如果返回空或抛出异常，
    说明没有找到该principal用户信息
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        //根据用户名去数据库查找相关用户，此处暂时为空

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();

        return authenticationInfo;
    }
}
