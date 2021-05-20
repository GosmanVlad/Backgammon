package com.backgammon.gui;

import com.backgammon.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.image.ReplicateScaleFilter;
import java.util.ArrayList;

public class GUI extends JPanel {

    private ArrayList<Integer> topSlots;
    private ArrayList<Integer> bottomSlots;
    private Game game;
    public GUI() {
        topSlots = new ArrayList<Integer>();
        topSlots.add(14);
        topSlots.add(15);
        topSlots.add(16);
        topSlots.add(17);
        topSlots.add(18);
        topSlots.add(19);
        topSlots.add(20);
        topSlots.add(21);
        topSlots.add(22);
        topSlots.add(23);
        topSlots.add(24);
        topSlots.add(25);
        topSlots.add(26);
        topSlots.add(27);

        bottomSlots = new ArrayList<Integer>();
        bottomSlots.add(13);
        bottomSlots.add(12);
        bottomSlots.add(11);
        bottomSlots.add(10);
        bottomSlots.add(9);
        bottomSlots.add(8);
        bottomSlots.add(7);
        bottomSlots.add(6);
        bottomSlots.add(5);
        bottomSlots.add(4);
        bottomSlots.add(3);
        bottomSlots.add(2);
        bottomSlots.add(1);
        bottomSlots.add(0);
    }
    @Override
    public void paint(Graphics table) {
        Image bufferImage = createImage(860, 654);
        paintBoard(bufferImage.getGraphics());
        int width = getWidth();
        int height = getHeight();
        ReplicateScaleFilter crop = new ReplicateScaleFilter(width, height);
        ImageProducer prod = new FilteredImageSource(bufferImage.getSource(), crop);
        FilteredImageSource fis = new FilteredImageSource(prod, crop);
        Image croppedImage = createImage(fis);
        table.drawImage(croppedImage, 0, 0, null);
    }

    public void paintBoard(Graphics table) {

        int width = 860;
        int height = 654;
        table.setColor(Color.gray);
        table.fillRect(0, 0, width, height);
        table.setColor(new Color(255, 255, 204));
        table.fillRect(30, 30, width - 152, height - 59);
        table.setColor(Color.gray);
        table.fillRect(width / 2 - 76, 30, 60, height - 59);

        table.setColor(new Color(255, 255, 204));//cream color
        table.fillRect(width - 90, 30, 60, height - 59);

        printTable(table, 30, 84, 57, 30, 300, topSlots, 0);
        printTable(table, 414, 468, 441, 30, 300, topSlots, 7);
        printTable(table, 30, 84, 57, height - 29, height - 298, bottomSlots, 0);
        printTable(table, 414, 468, 441, height - 29, height - 298, bottomSlots, 7);

        table.setFont(new Font("font", Font.BOLD, 20));
        table.setColor(Color.black);

        table.drawString("Black Wins!", 330, 25);
    }

    public void printTable(Graphics table, int leftX, int rightX, int highX, int leftY, int highY, ArrayList<Integer> slot, int index) {
        for (int triangleNumber = 0; triangleNumber < 6; triangleNumber++) {
            printTriangles(table, leftX, rightX, highX, leftY, highY, slot.get(index));
            leftX += 54;
            rightX += 54;
            highX += 54;
            index++;
        }
    }

    public void printTriangles(Graphics table, int leftX, int rightX, int highX, int leftY, int highY, int slot){

        if (slot != 0 && slot != 7 && slot != 20 && slot != 27) {
            Polygon form = new Polygon();
            form.addPoint(leftX, leftY);
            form.addPoint(rightX, leftY);
            form.addPoint(highX, highY);
            if(slot % 2==0)
            table.setColor(new Color(101,53,53));
            else
                table.setColor(new Color(159,127,127));
            table.fillPolygon(form);
        }
    }




}
