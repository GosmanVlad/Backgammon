package com.backgammon.gui;

import com.backgammon.game.Game;
import com.backgammon.game.Table;
import com.backgammon.game.common.Design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.image.ReplicateScaleFilter;
import java.util.ArrayList;

public class GUI extends JPanel implements Design {

    private ArrayList<Integer> topSlots;
    private ArrayList<Integer> bottomSlots;
    private Game game;

    public GUI(Game game) {
        this.game = game;
        game.addDesign(this);
        topSlots = new ArrayList<Integer>();
        bottomSlots = new ArrayList<Integer>();

        createTopSlots();
        createBottomSlots();

        mouseEvent();
    }

    public void mouseEvent() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int mouseX = event.getX();
                int mouseY = event.getY();
                int leftX = 30, rightX = getWidth()/10;
                int checkZone = getHeight()/2;

                ArrayList<Integer> copySlots = new ArrayList<Integer>();

                /* In functie de pozitia click-ului, atribuim sloturile de sus sau de jos pentru a face verificarile */
                if (mouseY < checkZone)
                    copySlots = topSlots;
                else
                    copySlots = bottomSlots;

                checkClickPosition(mouseX, mouseY, rightX, leftX, copySlots, checkZone);
            }
        });
    }

    public void refresh(){
        this.repaint();
    }

    /*
     * Verificam pozitia exacta a mouse-ului pe baza sloturilor copiate
     * */
    public void checkClickPosition(int mouseX, int mouseY, int rightX, int leftX, ArrayList<Integer> copySlots, int checkZone) {
        int index = 0;
        int distance = getWidth()/13-getWidth()/80-1;
        int markerBottomPosition = getHeight()-getHeight()/22;
        int markerTopPosition = getHeight()/21;

        // Slot: 13
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX-2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 12
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX-2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 11
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX-2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 10
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX-2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 9
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX-2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 8
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX-2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 7
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+1, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 6
        index++;
        leftX += distance+3;
        rightX += distance+3;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 5
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 4
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 3
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 2
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 1
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        // Slot: 0
        index++;
        leftX += distance+getWidth()/12/2;
        rightX += distance+getWidth()/12/2;
        if (mouseX > leftX && mouseX < rightX && mouseY > checkZone){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+1, markerBottomPosition, "bottom");
            game.getDesireMove(copySlots.get(index));
        }

        /* Zona oponentului */
        //slot 14
        index = 0;
        leftX = 30;
        rightX = getWidth()/10;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 15
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 16
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 17
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 18
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 19
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 20
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 21
        index++;
        leftX += distance+3;
        rightX += distance+3;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 22
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 23
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 24
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 25
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 26
        index++;
        leftX += distance;
        rightX += distance;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }

        //slot 27
        index++;
        leftX += distance+getWidth()/12/2;
        rightX += distance+getWidth()/12/2;
        if (mouseX > leftX && mouseX < rightX && mouseY < checkZone ){
            System.out.println(copySlots.get(index));
            drawMarker(getGraphics(), leftX+2, markerTopPosition, "top");
            game.getDesireMove(copySlots.get(index));
        }
    }

    public void drawMarker(Graphics graphics, int leftX, int height, String section) {
        graphics.setColor(new Color(255, 255, 204));

        if(section == "bottom")
            graphics.fillOval(leftX+5, height+5, 17, 17);
        else
            graphics.fillOval(leftX+5, height-20, 17, 17);
    }

    public void createTopSlots() {
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
    }

    public void createBottomSlots() {
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
        Table board = new Table();
        for(int pieceID = 0; pieceID < 28; pieceID++) {
            board.getSlots().get(pieceID).setStones(game.getTable().getSlots().get(pieceID).getStones());
            board.getSlots().get(pieceID).setColor(game.getTable().getSlots().get(pieceID).getColor());
        }

        table.setColor(Color.gray);
        table.fillRect(0, 0, width, height);
        table.setColor(new Color(255, 255, 204));
        table.fillRect(30, 30, width - 152, height - 59);
        table.setColor(Color.gray);
        table.fillRect(width / 2 - 76, 30, 60, height - 59);

        table.setColor(new Color(255, 255, 204));//cream color
        table.fillRect(width - 90, 30, 60, height - 59);

        printTable(table, 30, 84, 57, 30, 300, topSlots, 0, board, true, 29);
        printTable(table, 414, 468, 441, 30, 300, topSlots, 7, board, true, 29);
        printTable(table, 30, 84, 57, height - 29, height - 298, bottomSlots, 0, board, false, height-80);
        printTable(table, 414, 468, 441, height - 29, height - 298, bottomSlots, 7, board, false, height-80);

        if (game.getDice().getDiceSize() == 1) {
            printDice(table, 0, game.getDice().getDiceNumbers().get(0));
        }
        else if (game.getDice().getDiceSize() == 2) {
            printDice(table, 0, game.getDice().getDiceNumbers().get(0));
            printDice(table, 80, game.getDice().getDiceNumbers().get(1));
        }
        else if (game.getDice().getDiceSize() > 2){
            printDice(table, 0, game.getDice().getDiceNumbers().get(0));
            printDice(table, 80, game.getDice().getDiceNumbers().get(1));
        }

        table.setFont(new Font("font", Font.BOLD, 20));
        table.setColor(Color.black);

        if(!game.isMoveDone()) {
            if(game.getCurrentPlayer() == "BLACK")
                table.drawString("Black's turn'", 330, 25);
            else if(game.getCurrentPlayer() == "WHITE")
                table.drawString("White's turn", 330, 25);
        }
    }

    public void printDice(Graphics table, int distance, int diceIndex) {
        int width = 360;
        int height = 265 + distance;
        table.setColor(Color.WHITE);
        table.fillRect(width, height, 46, 46);
        table.setColor(Color.BLACK);
        if (diceIndex == 1){
            printPoint1(table, distance);
        }
        else if (diceIndex == 2){
            printPoint2(table, distance);
        }
        else if (diceIndex == 3){
            printPoint3(table, distance);
        }
        else if (diceIndex == 4){
            printPoint4(table, distance);
        }
        else if (diceIndex == 5){
            printPoint5(table, distance);
        }
        else if (diceIndex == 6){
            printPoint6(table, distance);
        }
    }

    public void printPoint1(Graphics table, int distance) {
        table.fillOval(378, 284 + distance, 10, 10);
    }

    public void printPoint2(Graphics table, int distance) {
        table.fillOval(390, 270 + distance, 10, 10);
        table.fillOval(365, 295 + distance, 10, 10);
    }

    public void printPoint3(Graphics table, int distance) {
        printPoint2(table, distance);
        printPoint1(table, distance);
    }

    public void printPoint4(Graphics table, int distance) {
        printPoint2(table, distance);
        table.fillOval(365, 270+ distance, 10, 10);
        table.fillOval(390, 295+ distance, 10, 10);
    }

    public void printPoint5(Graphics table, int distance) {
        printPoint1(table, distance);
        printPoint4(table, distance);
    }

    public void printPoint6(Graphics table, int distance) {
        printPoint4(table, distance);
        table.fillOval(365, 283+ distance, 10, 10);
        table.fillOval(390, 283+ distance, 10, 10);
    }

    public void printTable(Graphics table, int leftX, int rightX, int highX, int leftY, int highY, ArrayList<Integer> slot, int index, Table board, boolean opponent, int startPosition) {
        for (int triangleNumber = 0; triangleNumber < 7; triangleNumber++) {
            printTriangles(table, leftX, rightX, highX, leftY, highY, slot.get(index));
            leftX += 54;
            rightX += 54;
            highX += 54;
            index++;
        }

        for (int w = 0; w < 7; w++) {
            printPieces(table, slot.get(index-7), leftX-(54*7), board.getSlots().get(slot.get(index-7)).getColor() , board, opponent, startPosition);
            leftX += 54;
            index++;
        }
    }

    public void printPieces(Graphics table, int slot, int posX, String color, Table board, boolean opponent, int startPosition) {
        Color pieceColor;
        int index = 0;
        int startX = posX, startY = startPosition;

        if (color == "BLACK") {
            pieceColor = new Color(42, 41, 41);
        } else {
            pieceColor = Color.WHITE;
        }

        while (board.getSlots().get(slot).getStones() != 0) {
            if (index == 5 || index == 10){
                posX = startX + 4;
                startX += 4;
                if (opponent) {
                    startPosition = startY + 4;
                    startY += 4;
                }
                else{
                    startPosition = startY -4;
                    startY -= 4;
                }
            }
            table.setColor(Color.BLACK);
            table.fillOval(posX, startPosition, 54, 54);
            table.setColor(pieceColor);
            table.fillOval(posX+2, startPosition+2, 50, 50);
            if (opponent) {
                startPosition += 54;
            }
            else{
                startPosition -= 54;
            }
            board.getSlots().get(slot).removeSlot();
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
