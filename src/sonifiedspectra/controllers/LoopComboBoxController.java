package sonifiedspectra.controllers;

import jm.music.data.Part;
import sonifiedspectra.model.Project;
import sonifiedspectra.view.Sonify;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

/**
 * Created by Hvandenberg on 6/4/15.
 */
public class LoopComboBoxController implements ItemListener {

    private Sonify app;
    private Project project;
    private JComboBox loopComboBox;

    public LoopComboBoxController(Sonify app, Project project, JComboBox loopComboBox) {
        this.app = app;
        this.project = project;
        this.loopComboBox = loopComboBox;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        app.getLoopDialog().getLoopPlayer().reset();
        app.getLoopDialog().getLoopPlayer().updateLoopPlayer( (Part) app.getLoopDialog().getLoopsArray()
                .get(loopComboBox.getSelectedIndex()));
    }
}
