package io.atasc.intellij.tcptunnel.tunnellij.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import io.atasc.intellij.tcptunnel.tunnellij.ui.Icons;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author boruvka
 * @since
 */
public class AboutAction extends AnAction {

  public AboutAction() {
    super("Show About dialog", "Show About dialog", Icons.ICON_HELP);
  }

  public void actionPerformed(AnActionEvent event) {
    InputStream is = getClass().getClassLoader().getResourceAsStream(
        "readme.txt");
    if (is != null) {
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      StringBuffer sb = new StringBuffer();
      String s;
      try {
        while ((s = br.readLine()) != null) {
          sb.append(s);
          sb.append("\n");
        }
        TextArea area = new TextArea(20, 80);
        area.setEditable(false);
        area.append(sb.toString());
        JOptionPane.showMessageDialog(null, area);
        // Messages.showMessageDialog(sb.toString(), "About TunnelliJ",
        // Messages.getInformationIcon());
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("stream is null!");
    }
  }
}