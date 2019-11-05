/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: SshConnection
 * Author:   yuanlin_csu
 * Date:     2019/10/25 13:57
 * Description: ��ȡĿ�������ssh����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package utils;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

/**
 * ��һ�仰���ܼ�����<br> 
 * ����ȡĿ�������ssh���ӡ�
 *
 * @author yuanlin_csu
 * @create 2019/10/25
 * @since 1.0.0
 */
public class SshConnection {




    //���ӷ�����
    public static Session connect(String username, String passwd, String host, int port) {
        Session session = null;
        try {
            JSch jsch = new JSch();
            //��ȡsshSession
            session = jsch.getSession(username, host, port);
            //�������
            session.setPassword(passwd);
            Properties sshConfig = new Properties();
            //�ϸ�������Կ���
            sshConfig.put("StrictHostKeyChecking", "no");
            session.setConfig(sshConfig);
            //����sshSession����
            session.connect();
            System.out.println("Server connection successful.");

        } catch (JSchException e) {

            e.printStackTrace();
        }

        return session;

    }


}
