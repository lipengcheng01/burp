package burp;

import javax.swing.*;
import java.io.PrintWriter;
public class BurpExtender implements IBurpExtender {

    public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {

        //插件的名称
        callbacks.setExtensionName("My Extension");
        PrintWriter stdout = new PrintWriter(callbacks.getStdout(), true);
        PrintWriter stderr  = new PrintWriter(callbacks.getStderr(),true);

        // 将消息写入Burp的输出流
        stdout.println("正常输出");
        // 将消息写入Burp的错误流
        stderr.println("异常输出");

        // 将消息写入 Burp 警报选项卡
        callbacks.issueAlert("警报");
        SwingUtilities.invokeLater(()->
        {
            //插件状态发生改变的事件
            callbacks.registerExtensionStateListener(new ExtensionStateListenerImpl(callbacks));
        });

    }

}
