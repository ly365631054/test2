package org.ini;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

/**
 * @Author yong.li_1
 **/
public class Demo01 {

    @Test
    public void test() {
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        defaultSecurityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        subject.login(new UsernamePasswordToken("username", "password"));

    }
}
