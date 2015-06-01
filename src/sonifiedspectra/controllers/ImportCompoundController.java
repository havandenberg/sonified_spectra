package sonifiedspectra.controllers;

import sonifiedspectra.model.Model;
import sonifiedspectra.view.SonifiedSpectra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * Created by Hvandenberg on 5/30/15.
 */
public class ImportCompoundController implements ActionListener, MouseListener {

    private Model model;
    private SonifiedSpectra app;

    public ImportCompoundController(SonifiedSpectra app, Model model) {
        this.app = app;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File file = null;

        File f;

        if ( file == null ) {

            JFileChooser fc = new JFileChooser();
            File directory = new File("compounds/");
            fc.setCurrentDirectory(directory);

            f = null;

            int returnVal = fc.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {

                f = fc.getSelectedFile();

                System.out.println("File: " + f.getName() + ".");

            } else {

                System.out.println("Open command cancelled by user.");

            }

            System.out.println(returnVal);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        app.getImportCompoundButton().setCol(app.getButtonHighlightColor());
        app.getImportCompoundButton().repaint();
        app.getFrame().pack();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        app.getImportCompoundButton().setCol(app.getButtonBackgroundColor());
        app.getImportCompoundButton().repaint();
        app.getFrame().pack();
    }
}