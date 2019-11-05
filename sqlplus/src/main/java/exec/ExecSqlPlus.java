package exec; /**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: exec.ExecSqlPlus
 * Author:   yuanlin_csu
 * Date:     2019/10/25 13:55
 * Description: 调用sqlplus获取sql执行计划
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import org.apache.commons.io.IOUtils;
import utils.SshConnection;

import java.io.*;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br>
 * 〈调用sqlplus获取sql执行计划〉
 *
 * @author yuanlin_csu
 * @create 2019/10/25
 * @since 1.0.0
 */
public class ExecSqlPlus {


        public static String execCmd(Session session, String cmdStr) throws IOException {

            String resultStr = "";
            InputStream inSuccess = null;
            InputStream inErr = null;

            ChannelExec channelExec = null;
            if (cmdStr != null) {
                try {

                    channelExec = (ChannelExec) session.openChannel("exec");
                    // 设置需要执行的shell命令
                    channelExec.setCommand(cmdStr);
                    System.out.println("linux命令:" + cmdStr);
                    //channelExec.setInputStream(null);
                    //channelExec.setOutputStream(fileOutputStream);
                    channelExec.setErrStream(System.err);
                    channelExec.connect();
                    //读数据
                    /*int status = channelExec.getExitStatus();
                    System.out.println("status : " + status);*/

                    inSuccess = channelExec.getInputStream();
                    resultStr = IOUtils.toString(inSuccess,"UTF-8");

                } catch (JSchException e) {
                    e.printStackTrace();
                } finally {

                    IOUtils.closeQuietly(inSuccess);

                    if (null != channelExec) {
                        channelExec.disconnect();
                    }

                }
            }


            return resultStr;



        }



        public static void main(String [] args) throws IOException, InterruptedException {

        /*    int port = 22;
            String userName = "oracle";
            String passWord = "oracle";
            String host = "192.168.2.198";

            Session session = SshConnection.connect(userName,passWord,host,port);

            String cmdStr1 = "source .bash_profile && sqlplus ";

            String cmdStr2 = "sqlplus /nolog";*/

            //Scanner scanner = new Scanner(System.in);

           // while(scanner.hasNextLine()){

                //String cmd = scanner.nextLine();

                //String resStr = execCmd(session,cmdStr1);

                //System.out.println(resStr);

            //}






            Process process = null;

            Runtime runtime = Runtime.getRuntime();

            //String [] cmdStrArray = {"cmd.exe /c E:\\oracle\\product\\BIN\\","sqlplus ipay/ipay@192.168.2.198:1521/dev_orcl",
             //       "explain plan for select * from t_bui_layout;",
              //      "select * from table(dbms_xplan.display)"};
            /*String cmdStr = "cmd /c sqlplus ipay/ipay@192.168.2.198:1521/dev_orcl @C:\\Users\\yuanlin_csu\\testbat.sql";
            process = runtime.exec(cmdStr,null,new File("C:\\Users\\yuanlin_csu"));
*/

            String cmdStr = "cmd /c sqlplus ipay/ipay@192.168.2.198:1521/dev_orcl";

            process = runtime.exec(cmdStr);

            runtime.exec("explain plan for select * from t_bui_layout;");

            runtime.exec("select * from table(dbms_xplan.display);");

            // process = runtime.exec("C:/Windows/System32/cmd.exe /k sqlplus &pause");
            InputStream in = process.getInputStream();


            InputStream instream = process.getErrorStream();
            String res = IOUtils.toString(in,"GBK");

            String resErr = IOUtils.toString(instream,"GBK");

            int i  = process.waitFor();
            System.out.println("aaa " + i);
           /* BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String buf = null;
            StringBuffer sb = new StringBuffer();
            while((buf = reader.readLine())!=null){
                sb.append(buf);

            }*/


           System.out.println("222 " + resErr );
            System.out.println("1111 " + res);




        }





}
