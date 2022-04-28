package burp;

import java.io.PrintWriter;

public class ExtensionStateListenerImpl implements IExtensionStateListener {

    private IBurpExtenderCallbacks callbacks;

    ExtensionStateListenerImpl(IBurpExtenderCallbacks callbacks){
        super();
        this.callbacks = callbacks;
    }
    //IExtensionStateListener  当插件的状态发生改变时，监视器会接到通知
    public void extensionUnloaded() {

        PrintWriter stdout = new PrintWriter(callbacks.getStdout(), true);

        stdout.println("卸载成功");
    }
}
