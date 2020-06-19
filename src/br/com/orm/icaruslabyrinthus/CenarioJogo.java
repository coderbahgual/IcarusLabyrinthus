package br.com.orm.icaruslabyrinthus;

import br.com.orm.icaruslabyrinthus.ferramentas.CenarioPadrao;
import br.com.orm.icaruslabyrinthus.ferramentas.Elemento;
import br.com.orm.icaruslabyrinthus.ferramentas.Texto;
import br.com.orm.icaruslabyrinthus.ferramentas.Util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author orm
 */
public class CenarioJogo extends CenarioPadrao{

    enum Estado {
        JOGANDO, GANHOU, PERDEU, INICIO_ANIMACAO, FIM_ANIMACAO
    }
    
    private static final int LARG = 25;
    private int dx, dy;
    private int temporizador = 0;
    private Elemento saida;
    private Elemento ponto;
    private Elemento[] nivel;
    private int contadorNivel;
    private Estado estado = Estado.JOGANDO;
    private Texto texto = new Texto(new Font("Arial", Font.PLAIN, 25));
    //ANIMACAO
    private int duracaoAnimacao = 2;
    private int iniAnimacao = 0;
    private int fimAnimacao = Nivel.fases[0].length + duracaoAnimacao;
    
    public CenarioJogo(int largura, int altura) {
        super(largura, altura);
    }

    @Override
    public void carregar() {
        //System.out.println("carregar"+fimAnimacao);
        //define direcao inicial
        dx = -1;
        contadorNivel = 0;
        
        saida = new Elemento(0, 0, LARG, LARG);
        saida.setAtivo(true);
        saida.setCor(Color.GREEN);

        ponto = new Elemento(0, 0, LARG, LARG);
        ponto.setAtivo(true);
        ponto.setCor(Color.BLUE);
        ponto.setVel(4);

        char[][] nivelSelecionado = Nivel.fases[Jogo.nivel];

        int total = 0;

        for (int linha = 0; linha < nivelSelecionado.length; linha++) {
            for (int coluna = 0; coluna < nivelSelecionado[0].length; coluna++) {
                if (nivelSelecionado[linha][coluna] == '0') {
                    total++;
                } else if (nivelSelecionado[linha][coluna] == '1') {
                    ponto.setPx(LARG * coluna);
                    ponto.setPy(LARG * linha);
                } else if (nivelSelecionado[linha][coluna] == '2') {
                    saida.setPx(LARG * coluna);
                    saida.setPy(LARG * linha);
                }
            }
        }

        nivel = new Elemento[total];

        for (int linha = 0; linha < nivelSelecionado.length; linha++) {
            for (int coluna = 0; coluna < nivelSelecionado[0].length; coluna++) {
                if (nivelSelecionado[linha][coluna] == '0') {
                    Elemento e = new Elemento();
                    e.setAtivo(true);
                    e.setCor(Color.RED);

                    e.setPx(LARG * coluna);
                    e.setPy(LARG * linha);

                    e.setAltura(LARG);
                    e.setLargura(LARG);

                    nivel[contadorNivel++] = e;
                }
            }
        }
    }

    @Override
    public void descarregar() {
    }

    @Override
    public void atualizar() {
        if (estado == Estado.GANHOU || estado == Estado.PERDEU) {
            return;
        }
        if (estado == Estado.INICIO_ANIMACAO || estado == Estado.FIM_ANIMACAO) {
            if (estado == Estado.INICIO_ANIMACAO) {
                iniAnimacao++;
                if (iniAnimacao == fimAnimacao) {
                    descarregar();
                    carregar();
                    estado = Estado.FIM_ANIMACAO;
                }
            } else {
                iniAnimacao--;
                if (iniAnimacao == 0) estado = Estado.JOGANDO;
            }
            return;
        }
        
        if (Jogo.controleTecla[Jogo.Tecla.ESQUERDA.ordinal()]) {
            dx = -1;
        } else if (Jogo.controleTecla[Jogo.Tecla.DIREITA.ordinal()]) {
            dx = 1;
        }
        if (dx != 0) {
            dy = 0;
        }
        if (Jogo.controleTecla[Jogo.Tecla.CIMA.ordinal()]) {
            dy = -1;
        } else if (Jogo.controleTecla[Jogo.Tecla.BAIXO.ordinal()]) {
            dy = 1;
        }
        if (dy != 0) {
            dx = 0;
        }
        
        if (temporizador >= 20) {
            temporizador = 0;
            
            ponto.setPx(ponto.getPx() + LARG * dx);//POSIÇÃO ponto EIXO X
            ponto.setPy(ponto.getPy() + LARG * dy);//POSIÇÃO ponto EIXO Y

            if (Util.saiu(ponto, largura, altura)) {
                ponto.setAtivo(false);
                estado = Estado.PERDEU;
            } else {
                //COLISÃO COM CENÁRIO
                for (int i = 0; i < contadorNivel; i++) {
                    if (Util.colide(ponto, nivel[i])) {
                        ponto.setAtivo(false);
                        nivel[i].setCor(Color.YELLOW);
                        estado = Estado.PERDEU;
                        break;
                    }
                }
                if (Util.colide(ponto, saida)) {
                    //PAUSA DA MOVIMNETAÇÃO
                    temporizador = -10;
                    if (Jogo.nivel + 1 == Nivel.fases.length) {
                        //+1 PARA SER MAIOR QUE O NÚMERO DE FASES
                        estado = Estado.GANHOU;
                    } else {
                        Jogo.nivel++;
                        estado = Estado.INICIO_ANIMACAO;
                    }
                }
            }           
        } else {
            temporizador += ponto.getVel();
        }//FIM if (temporizador >= 20) {
        
    }

    @Override
    public void desenhar(Graphics2D g) {
        for (Elemento e : nivel) {
            if (e == null) break;
		e.desenhaRect(g);
	}
        saida.desenhaOval(g);
        ponto.desenhaOval(g);

        if (estado == Estado.INICIO_ANIMACAO || estado == Estado.FIM_ANIMACAO) {
            char[][] nivelSelecionado = Nivel.fases[Jogo.nivel];
            int limite = 0;
            g.setColor(Color.LIGHT_GRAY);
            for (int linha = 0; linha < nivelSelecionado.length; linha++) {
                limite++;
                if (limite >= iniAnimacao) break;
                for (int coluna = 0; coluna < nivelSelecionado[0].length; coluna++) {
                    g.fillRect(LARG * coluna, LARG * linha, LARG, LARG);
                }
            }
        } else if (estado == Estado.GANHOU || estado == Estado.PERDEU) {
                if (estado == Estado.GANHOU){
                    g.setColor(Color.YELLOW);
                    texto.desenha(g, "DESAFIO COMPLETO!", 110, 160);
                }else{
                    g.setColor(Color.BLACK);
                    g.fillRect(ponto.getPx() + LARG * 2, ponto.getPy() + LARG * 2, 450, 450);
                    g.fillRect(ponto.getPx() - 450 - LARG, ponto.getPy() - 450 - LARG, 450, 450);
                    g.fillRect(ponto.getPx() + LARG * 2, ponto.getPy() - 450 - LARG, 450, 450);
                    g.fillRect(ponto.getPx() - 450 - LARG, ponto.getPy() + LARG * 2, 450, 450);
                    g.setColor(Color.YELLOW);
                    texto.desenha(g, "GAME OVER!", 160, 160);
                    texto.desenha(g, "PARA REINICIAR APERTE ENTER!", 20, 420);
                }
        }
    }
}
