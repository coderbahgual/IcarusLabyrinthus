package br.com.orm.icaruslabyrinthus;

import br.com.orm.icaruslabyrinthus.ferramentas.CenarioPadrao;
import br.com.orm.icaruslabyrinthus.ferramentas.Menu;
import br.com.orm.icaruslabyrinthus.ferramentas.Util;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author orm
 */
public class CenarioMenu extends CenarioPadrao{

    public CenarioMenu(int largura, int altura) {
        super(largura, altura);
    }
    
    private Menu jogar;
    private Menu instrucao;

    @Override
    public void carregar() {
        jogar = new Menu("");
        instrucao = new Menu("");
        
        jogar.addOpcoes("     JOGAR     ");
        instrucao.addOpcoes("INSTRUÇÕES");
        
        Util.centraliza(jogar, largura, altura);
        Util.centraliza(instrucao, largura, altura);
        
        instrucao.setPy(jogar.getPy() + jogar.getAltura());
        
        jogar.setAtivo(true);
        jogar.setSelecionado(true);
        instrucao.setAtivo(true);
        
    }

    @Override
    public void descarregar() {
    }

    @Override
    public void atualizar() {
        if (Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()] || 
                Jogo.controleTecla[Jogo.Tecla.BAIXO.ordinal()]) {
            if (jogar.isSelecionado()) {
                jogar.setSelecionado(false);
                instrucao.setSelecionado(true);
            } else {
                jogar.setSelecionado(true);
                instrucao.setSelecionado(false);
            }
        } else if (Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()] ||
                Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]) {
            jogar.setTrocaOpcao(Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]);
        }
        Jogo.liberarTeclas();
    }

    @Override
    public void desenhar(Graphics2D g) {
        jogar.desenha(g);
        instrucao.desenha(g);
        if (instrucao.isSelecionado()) {
            g.setColor(Color.YELLOW);
            g.drawString("USANDO AS SETAS DO TECLADO", 120, 
                    instrucao.getPy() + 3*instrucao.getAltura());
            g.drawString("FAZER O PONTO AZUL", 160, 
                    instrucao.getPy() + 4*instrucao.getAltura());
            g.drawString("CHEGAR AO PONTO VERDE", 135, 
                    instrucao.getPy() + 5*instrucao.getAltura());
        }
    }
    
}
