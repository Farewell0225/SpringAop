/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: SshConnection
 * Author:   yuanlin_csu
 * Date:     2019/10/25 13:57
 * Description: 获取目标服务器ssh连接
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package utils;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈获取目标服务器ssh连接〉
 *
 * @author yuanlin_csu
 * @create 2019/10/25
 * @since 1.0.0
 */
public class SshConnection {




    //连接服务器
    public static Session connect(String username, String passwd, String host, int port) {
        Session session = null;
        try {
            JSch jsch = new JSch();
            //获取sshSession
            session = jsch.getSession(username, host, port);
            //添加密码
            session.setPassword(passwd);
            Properties sshConfig = new Properties();
            //严格主机密钥检查
            sshConfig.put("StrictHostKeyChecking", "no");
            session.setConfig(sshConfig);
            //开启sshSession连接
            session.connect();
            System.out.println("Server connection successful.");

        } catch (JSchException e) {

            e.printStackTrace();
        }

        return session;

    }


}
