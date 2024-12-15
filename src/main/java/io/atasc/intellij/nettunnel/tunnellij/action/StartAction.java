package io.atasc.intellij.nettunnel.tunnellij.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import io.atasc.intellij.nettunnel.tunnellij.TunnelPlugin;
import io.atasc.intellij.nettunnel.tunnellij.ui.Icons;
import io.atasc.intellij.nettunnel.tunnellij.ui.TunnelPanel;

/**
 * @author boruvka
 * @since
 */
public class StartAction extends AnAction {

    public StartAction() {
        super("Start tunnellij", "Start tunnellij", Icons.ICON_START);
    }

    public void actionPerformed(AnActionEvent event) {
        Project project = (Project) event.getDataContext().getData("project");
        TunnelPanel tunnelPanel = TunnelPlugin.getTunnelPanel(project);
        try {
            tunnelPanel.start();
        } catch (Exception e) {
            Messages.showMessageDialog("Error when starting server: "
                    + e.getMessage(), "Error", Messages.getErrorIcon());
        }

    }

    public void update(AnActionEvent event) {
        Project project = (Project) event.getDataContext().getData("project");
        TunnelPanel tunnelPanel = TunnelPlugin.getTunnelPanel(project);
        Presentation p = event.getPresentation();
        p.setEnabled(!tunnelPanel.isRunning());
        p.setVisible(true);
    }
}
