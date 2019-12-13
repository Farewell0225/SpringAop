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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
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
        // 已获取的日志文件
        private static final String logFileStr = "C:\\Users\\yuanlin_csu\\sqlOutTimeInfo.txt";
        //执行计划输出结果文件
        private static final String resultFileStr = "C:\\Users\\yuanlin_csu\\explanResultFile.html";
        // 为每条sql生成的临时脚本文件
        private static final String execSqlFileStr = "C:\\Users\\yuanlin_csu\\execSql.sql";
        // 远程数据库的sqlplus 连接信息
        private static final String sqlplusConnectInfoStr = "sqlplus ipay/ipay@192.168.2.198:1521/dev_orcl";

        public static void main(String [] args) throws IOException, InterruptedException {


            // 1.0 读取sql日志文件

            File sqlLogFile = new File(logFileStr);

            LineIterator lineIterator = null;

            // 创建输出结果文件
            File explanResultFile = new File(resultFileStr);

            lineIterator = FileUtils.lineIterator(sqlLogFile, "UTF-8");

            while(lineIterator.hasNext()){

                String sqlInfoStr = lineIterator.next();

                String sqlStr = StringUtils.substringBetween(sqlInfoStr,"execQueryBindLimit:[","]");
                sqlStr = StringUtils.trim(sqlStr);
                System.out.println("sql : " + sqlStr);

                // 组装待执行sql脚本
                File tmpFile = new File(execSqlFileStr);
                if(tmpFile.exists() && tmpFile.length()>0){
                    FileUtils.forceDelete(tmpFile);
                }

                String cmd1 = "set markup HTML on spool on pre off entmap off \n";
                String cmd2 = "explain plan for " + sqlStr + ";\n";
                String cmd3 = "select * from table(dbms_xplan.display);\n";
                String cmd4 = "exit";

                FileUtils.writeByteArrayToFile(tmpFile,cmd1.getBytes(),true);
                FileUtils.writeByteArrayToFile(tmpFile,cmd2.getBytes(),true);
                FileUtils.writeByteArrayToFile(tmpFile,cmd3.getBytes(),true);
                FileUtils.writeByteArrayToFile(tmpFile,cmd4.getBytes(),true);

                Process process = null;

                Runtime runtime = Runtime.getRuntime();

                String cmdStr = "cmd /c " + sqlplusConnectInfoStr + " @" +
                        tmpFile.getPath();

                process = runtime.exec(cmdStr);

                InputStream in = process.getInputStream();

                InputStream instream = process.getErrorStream();
                String res = IOUtils.toString(in,"GBK");

                String resErr = IOUtils.toString(instream,"GBK");

                int i  = process.waitFor();
                System.out.println("status " + i);

                System.out.println("ERRINFO " + resErr );
                System.out.println("SUCCESSiNFO " + res);


                String nextStr = "<br><br><br>";
                String headStr = "<span>&nbsp;&nbsp;sql：" + sqlStr + "</span><br>";
                String resHtmlStr = StringUtils.substringBetween(res,"<p>","<p>");

                FileUtils.writeByteArrayToFile(explanResultFile,nextStr.getBytes(),true);
                FileUtils.writeByteArrayToFile(explanResultFile,headStr.getBytes(),true);

                FileUtils.writeByteArrayToFile(explanResultFile,resHtmlStr.getBytes(),true);

                process.destroy();

            }

            LineIterator.closeQuietly(lineIterator);

        }





}
