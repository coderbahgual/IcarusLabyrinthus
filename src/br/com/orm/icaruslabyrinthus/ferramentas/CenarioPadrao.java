package br.com.orm.icaruslabyrinthus.ferramentas;

import java.awt.Graphics2D;

/**
 *
 * @author orm
 */
public abstract class CenarioPadrao {
    protected int altura;
    protected int largura;

    public CenarioPadrao(int largura, int altura) {
        this.altura = altura;
        this.largura = largura;
    }
    public abstract void carregar();
    
    public abstract void descarregar();
    
    public abstract void atualizar();
    
    public abstract void desenhar(Graphics2D g);
    
}
