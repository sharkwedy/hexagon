package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.ColorInt;

import java.util.ArrayList;
import java.util.List;

public class HexagonView extends View {
    private Paint hexagonPaint;
    private Paint skillLinePaint;

    private int centerScreenX;
    private int centerScreenY;

    public HexagonView(Context context) {
        super(context);
        init();
    }

    public HexagonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        centerScreenX = getWidth() / 2;
        centerScreenY = getHeight() / 2;
        hexagonPaint = new Paint();
        hexagonPaint.setStyle(Paint.Style.FILL);
        hexagonPaint.setColor(Color.BLACK);
        hexagonPaint.setStrokeWidth(5);

        skillLinePaint = new Paint();
        skillLinePaint.setStyle(Paint.Style.FILL);
        skillLinePaint.setColor(Color.RED);
        skillLinePaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Ajuste esses valores conforme necessário
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int hexagonRadius = 500;

        drawHexagon(canvas, centerX, centerY, hexagonRadius);
        hexagonPaint.setStrokeWidth(1);


        float angle = (float) Math.PI / 3; // Ângulo de 60 graus entre os pontos do hexágono
        float x, y;

        // Desenha as linhas conectando os pontos do hexágono
        for (int i = 0; i < 6; i++) {
            x = centerY + hexagonRadius * (float) Math.cos(i * angle);
            y = centerX + hexagonRadius * (float) Math.sin(i * angle);
            canvas.drawLine(y, x, centerX, centerY, hexagonPaint);
        }

        hexagonPaint.setStrokeWidth(2);


        // Desenha o hexágono
        for (int i=0; i<10; i++) {
            drawHexagon(canvas, centerX, centerY, hexagonRadius-(i*hexagonRadius/10));
        }

        drawHexagon(canvas, centerX, centerY, 1);


        List<Float> responses = new ArrayList<>();

        // Adicione valores à lista
        responses.add(.72f); //HS4
        responses.add(.5f); //HS3
        responses.add(1f); //HS2
        responses.add(1f); //HS1
        responses.add(1f); //HS6
        responses.add(1f); //HS5

        drawHexagonResponse(canvas, centerX, centerY, hexagonRadius, responses);
    }

    private void drawHexagon(Canvas canvas, int centerY, int centerX, int radius) {
        float angle = (float) Math.PI / 3; // Ângulo de 60 graus entre os pontos do hexágono
        float stopX, stopY, startX, startY;

        stopX = centerX + radius * (float) Math.cos(angle * 0);
        stopY = centerY + radius * (float) Math.sin(angle * 0);
        startX = centerX + radius * (float) Math.cos(angle * 1);
        startY = centerY + radius * (float) Math.sin(angle * 1);
        canvas.drawLine(startY, startX, stopY, stopX, hexagonPaint);

        stopX = centerX + radius * (float) Math.cos(angle * 1);
        stopY = centerY + radius * (float) Math.sin(angle * 1);
        startX = centerX + radius * (float) Math.cos(angle * 2);
        startY = centerY + radius * (float) Math.sin(angle * 2);
        canvas.drawLine(startY, startX, stopY, stopX, hexagonPaint);

        stopX = centerX + radius * (float) Math.cos(angle * 2);
        stopY = centerY + radius * (float) Math.sin(angle * 2);
        startX = centerX + radius * (float) Math.cos(angle * 3);
        startY = centerY + radius * (float) Math.sin(angle * 3);
        canvas.drawLine(startY, startX, stopY, stopX, hexagonPaint);

        stopX = centerX + radius * (float) Math.cos(angle * 3);
        stopY = centerY + radius * (float) Math.sin(angle * 3);
        startX = centerX + radius * (float) Math.cos(angle * 4);
        startY = centerY + radius * (float) Math.sin(angle * 4);
        canvas.drawLine(startY, startX, stopY, stopX, hexagonPaint);

        stopX = centerX + radius * (float) Math.cos(angle * 4);
        stopY = centerY + radius * (float) Math.sin(angle * 4);
        startX = centerX + radius * (float) Math.cos(angle * 5);
        startY = centerY + radius * (float) Math.sin(angle * 5);
        canvas.drawLine(startY, startX, stopY, stopX, hexagonPaint);

        stopX = centerX + radius * (float) Math.cos(angle * 5);
        stopY = centerY + radius * (float) Math.sin(angle * 5);
        startX = centerX + radius * (float) Math.cos(angle * 6);
        startY = centerY + radius * (float) Math.sin(angle * 6);
        canvas.drawLine(startY, startX, stopY, stopX, hexagonPaint);
    }

    private void drawHexagonResponse(Canvas canvas, int centerY, int centerX, int radius, List<Float> responses) {
        float angle = (float) Math.PI / 3; // Ângulo de 60 graus entre os pontos do hexágono
        float stopX, stopY, startX, startY;
        Path path = new Path();
        int inicialX = getWidth() / 2;
        int inicialY = getHeight() / 2;

        stopX = centerX + (float) (radius * responses.get(0)) * (float) Math.cos(angle * 0);
        stopY = centerY + (float) (radius * responses.get(0)) * (float) Math.sin(angle * 0);
        startX = centerX + (float) (radius * responses.get(1)) * (float) Math.cos(angle * 1);
        startY = centerY + (float) (radius * responses.get(1)) * (float) Math.sin(angle * 1);
        canvas.drawLine(startY, startX, stopY, stopX, skillLinePaint);
        drawTringule(canvas, stopX, stopY, startX, startY, path, inicialX, inicialY, Color.argb(128, 255, 0, 0));


        stopX = centerX + (float) (radius * responses.get(1)) * (float) Math.cos(angle * 1);
        stopY = centerY + (float) (radius * responses.get(1)) * (float) Math.sin(angle * 1);
        startX = centerX + (float) (radius * responses.get(2)) * (float) Math.cos(angle * 2);
        startY = centerY + (float) (radius * responses.get(2)) * (float) Math.sin(angle * 2);
        canvas.drawLine(startY, startX, stopY, stopX, skillLinePaint);
        drawTringule(canvas, stopX, stopY, startX, startY, path, inicialX, inicialY, Color.argb(128, 0, 255, 0));


        stopX = centerX + (float) (radius * responses.get(2)) * (float) Math.cos(angle * 2);
        stopY = centerY + (float) (radius * responses.get(2)) * (float) Math.sin(angle * 2);
        startX = centerX + (float) (radius * responses.get(3)) * (float) Math.cos(angle * 3);
        startY = centerY + (float) (radius * responses.get(3)) * (float) Math.sin(angle * 3);
        canvas.drawLine(startY, startX, stopY, stopX, skillLinePaint);
        drawTringule(canvas, stopX, stopY, startX, startY, path, inicialX, inicialY, Color.argb(128, 0, 0, 255));

        stopX = centerX + (float) (radius * responses.get(3)) * (float) Math.cos(angle * 3);
        stopY = centerY + (float) (radius * responses.get(3)) * (float) Math.sin(angle * 3);
        startX = centerX + (float) (radius * responses.get(4)) * (float) Math.cos(angle * 4);
        startY = centerY + (float) (radius * responses.get(4)) * (float) Math.sin(angle * 4);
        canvas.drawLine(startY, startX, stopY, stopX, skillLinePaint);
        drawTringule(canvas, stopX, stopY, startX, startY, path, inicialX, inicialY, Color.argb(128, 255, 255, 0));

        stopX = centerX + (float) (radius * responses.get(4)) * (float) Math.cos(angle * 4);
        stopY = centerY + (float) (radius * responses.get(4)) * (float) Math.sin(angle * 4);
        startX = centerX + (float) (radius * responses.get(5)) * (float) Math.cos(angle * 5);
        startY = centerY + (float) (radius * responses.get(5)) * (float) Math.sin(angle * 5);
        canvas.drawLine(startY, startX, stopY, stopX, skillLinePaint);
        drawTringule(canvas, stopX, stopY, startX, startY, path, inicialX, inicialY, Color.argb(128, 128, 0, 128));

        //HS1
        stopX = centerX + (float) (radius * responses.get(5)) * (float) Math.cos(angle * 5);
        stopY = centerY + (float) (radius * responses.get(5)) * (float) Math.sin(angle * 5);
        startX = centerX + (float) (radius * responses.get(0)) * (float) Math.cos(angle * 6);
        startY = centerY + (float) (radius * responses.get(0)) * (float) Math.sin(angle * 6);
        canvas.drawLine(startY, startX, stopY, stopX, skillLinePaint);
        drawTringule(canvas, stopX, stopY, startX, startY, path, inicialX, inicialY, Color.argb(128, 0, 255, 255));
    }

    private void drawTringule(Canvas canvas, float stopX, float stopY, float startX, float startY, Path path, int inicialX, int inicialY, int color) {
        path.reset();
        path.moveTo(inicialX, inicialY); // Ponto inicial
        path.lineTo(startY, startX); // Terceiro ponto
        path.lineTo(stopY, stopX); // Terceiro ponto
        path.close(); // Fecha o caminho, formando um triângulo

        skillLinePaint.setColor(color);
        // Desenha o triângulo preenchido no Canvas
        canvas.drawPath(path, skillLinePaint);
    }

    private void drawSkillLines(Canvas canvas, int centerX, int centerY, int radius) {
        // Suponha que você tenha níveis de habilidade em um array
        int[] skillLevels = {3, 4, 2, 5, 1, 4}; // Exemplo de níveis de habilidade

        float angle = (float) Math.PI / 3;
        float x, y;

        // Desenha as linhas radiais representando os níveis de habilidade
        for (int i = 0; i < 6; i++) {
            float length = radius * (skillLevels[i] / 5.0f); // Normaliza para 0-1 e multiplica pelo raio
            x = centerX + length * (float) Math.cos(i * angle);
            y = centerY + length * (float) Math.sin(i * angle);
            canvas.drawLine(centerX, centerY, x, y, skillLinePaint);
        }
    }
}