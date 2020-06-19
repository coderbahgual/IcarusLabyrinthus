package br.com.orm.icaruslabyrinthus.ferramentas;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author orm
 */
public class Elemento {
    private int px, py, largura, altura, vel;
    private boolean ativo;
    private Color cor;

    public Elemento() {}
    
    public Elemento(int px, int py, int largura, int altura) {
        this.px = px;
        this.py = py;
        this.largura = largura;
        this.altura = altura;
    } 
    
    public void atualiza() {}
    
    public void desenhaRect(Graphics2D g) {
        g.setColor(cor);
        //g.drawRect(px, py, largura, altura);
        g.fillRect(px, py, largura, altura);
    }
    
    public void desenhaOval(Graphics2D g) {
        g.setColor(cor);
        //g.drawOval(px, py, largura, altura);
        g.fillOval(px, py, largura, altura);
    }
    
    public int getLargura() {
        return largura;
    }
    public void setLargura(int largura) {
        this.largura = largura;
    }
    
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPx() {
        return px;
    }
    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }
    public void setPy(int py) {
        this.py = py;
    }

    public int getVel() {
        return vel;
    }
    public void setVel(int vel) {
        this.vel = vel;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Color getCor() {
        return cor;
    }
    public void setCor(Color cor) {
        this.cor = cor;
    }
    
    public void incPx(int x) {
        px = px + x;
    }
    public void incPy(int y) {
        py = py + y;
    }
    
    @Override
    public String toString(){
        return "Elemento [px=" + px + ", py=" + py + "]";
    }
    
}