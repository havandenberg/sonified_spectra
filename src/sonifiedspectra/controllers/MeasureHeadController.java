package sonifiedspectra.controllers;

import sonifiedspectra.model.Project;
import sonifiedspectra.view.MeasureHeadView;
import sonifiedspectra.view.SonifiedSpectra;
import sonifiedspectra.view.TrackHeadView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Hvandenberg on 6/2/15.
 */
public class MeasureHeadController implements MouseListener {

    private SonifiedSpectra app;
    private Project project;
    private MeasureHeadView mhv;

    public MeasureHeadController(SonifiedSpectra app, Project project, MeasureHeadView mhv) {
        this.app = app;
        this.project = project;
        this.mhv = mhv;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        mhv.toggleSelected();

        if (!project.isTracksPanelMultipleSelection()) {
            for (MeasureHeadView mhv2 : app.getMeasureHeadViewArray()) {
                if (mhv.getMeasureNumber() != mhv2.getMeasureNumber()) mhv2.setSelected(false);
                mhv2.updatePanel();
            }
        }

        if (mhv.isSelected()) {
            mhv.setBackground(Color.decode("#C9C9C9"));
            mhv.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
            mhv.repaint();
        }
        else {
            mhv.setBackground(app.getButtonBackgroundColor());
            mhv.setBorder(BorderFactory.createLineBorder(Color.decode("#979797"), 1, false));
        }
        app.getFrame().pack();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!mhv.isSelected()) {
            mhv.setBackground(Color.decode("#C9C9C9"));
            mhv.repaint();
            app.getFrame().pack();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (!mhv.isSelected()) {
            mhv.setBackground(app.getButtonBackgroundColor());
            mhv.repaint();
            app.getFrame().pack();
        }
    }
}
