package se233.camelot.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class AnimatedSprite extends ImageView {
    int count, columns, rows, offsetX, offsetY, width, height, curIndex, curColumnIndex = 0, curRowIndex = 0;
    public AnimatedSprite(Image image, int count, int columns, int rows, int offsetX, int offsetY, int width, int height) {
        this.setImage(image);
        this.count = count;
        this.columns = columns;
        this.rows = rows;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
    }
    public void tick() {
        curColumnIndex = curIndex % columns;
        curRowIndex = curIndex / columns;
        curIndex = (curIndex+1) % (columns * rows);
        interpolate();
    }
    protected void interpolate() {
        final int x = curColumnIndex * width + offsetX;
        final int y = curRowIndex * height + offsetY;
        this.setViewport(new Rectangle2D(x, y, width, height));
    }

    int jumpCols ;
    int curJumpRowsIndex ;
    int jumpIndex ;
    int curJumpColsIndex ;
    public void jump() {
        jumpCols = 8 ;
        curJumpColsIndex = jumpIndex % jumpCols ;
        curJumpRowsIndex = jumpIndex / jumpCols ;
        jumpIndex = (jumpIndex+1)% (jumpCols*1);

        final int x = curJumpColsIndex * width + offsetX;
        final int y = curJumpRowsIndex * height + 60;
        this.setViewport(new Rectangle2D(x, y, width, height));

    }

    public void landing() {
        this.setViewport(new Rectangle2D(0, 0, width, height));
    }
}