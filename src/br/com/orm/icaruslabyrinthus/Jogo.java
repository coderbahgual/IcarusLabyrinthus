package br.com.orm.icaruslabyrinthus;

import br.com.orm.icaruslabyrinthus.ferramentas.CenarioPadrao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
    atw == Abstract Windowing Toolkit -> FORNECE CLASSES PARA OPERAÇÕES GRÁFICAS
    swing == 
*/
/**
 *
 * @author orm
 */
public class Jogo extends JFrame{
    private static final long serialVersionUID = 1L;//IDENTIFICAÇÃO EX.: VERSÃO 1.0
    
    private static final int FPS = 1000 / 20;//50ms == 20 QUADROS POR SEGUNDO
    
    private static final int JANELA_LARGURA = 450;
    private static final int JANELA_ALTURA = 450;
    
    private JPanel tela;
    private Graphics2D g2d;
    private BufferedImage buffer;
    
    private CenarioPadrao cenario;
    /*
    public static final Texto textoPausa = 
            new Texto(new Font("Tahoma", Font.PLAIN, 40));
    */
    
    public enum Tecla{
        CIMA, BAIXO, ESQUERDA, DIREITA, ESC, ENTER
    }
    /*
        O enum É UMA CONSTANTE COM MAIS RECURSOS
        values() == RETORNA UMA MATRIZ(VETOR)
        ordinal() == RETORNA O NÚMERO DA ORDEM EM O OBJETO SE ENCONTRA
    */
    public static boolean[] controleTecla = new boolean[Tecla.values().length];
    public static void liberarTeclas(){
        for (int i = 0; i < controleTecla.length; i++) {
            controleTecla[i] = false;
        }
    }
    private void setaTecla(int tecla, boolean pressionada){
        switch(tecla){
            case KeyEvent.VK_UP: // case KeyEvent.VK_W:
                controleTecla[Tecla.CIMA.ordinal()] = pressionada;
                break;
            case KeyEvent.VK_DOWN: // case KeyEvent.VK_S:
                controleTecla[Tecla.BAIXO.ordinal()] = pressionada;
                break;
            case KeyEvent.VK_LEFT: // case KeyEvent.VK_A:
                controleTecla[Tecla.ESQUERDA.ordinal()] = pressionada;
                break;
            case KeyEvent.VK_RIGHT: // case KeyEvent.VK_D:
                controleTecla[Tecla.DIREITA.ordinal()] = pressionada;
                break;
            case KeyEvent.VK_ESCAPE:
                controleTecla[Tecla.ESC.ordinal()] = pressionada;
                break;
            case KeyEvent.VK_ENTER: // case KeyEvent.VK_SPACE:
                controleTecla[Tecla.ENTER.ordinal()] = pressionada;
                break;
        }//FIM switch
    }//FIM setaTecla
    
    public static int nivel;
    public static int velocidade;
    //public static boolean pausado;
    
    public Jogo(){//METODO CONSTRUTOR
        this.addKeyListener(new KeyListener() {
            @Override//EVENTO PARA TECLA APERTADA
            public void keyTyped(KeyEvent ke) {
            }

            @Override//EVENTO PARA TECLA PRESSIONADA
            public void keyPressed(KeyEvent ke) {
                setaTecla(ke.getKeyCode(), true);
            }

            @Override//EVENTO PARA TECLA LIBERADA
            public void keyReleased(KeyEvent ke) {
                setaTecla(ke.getKeyCode(), false);
            }
        });
        
        buffer = new BufferedImage(JANELA_LARGURA, JANELA_ALTURA, 
                BufferedImage.TYPE_INT_RGB);
        /*
            CRIAÇÃO DE UMA IMAGEM RGB SEM TRANSPARÊNCIA COM 
            COMPONENTES DE COR RGB DE 8 bits DENTRO DE UM PIXEL INTEIRO
        */
        g2d = buffer.createGraphics();//OBTENÇÃO DO OBJETO Graphics2D
        
        tela = new JPanel(){
            private static final long serialVersionUID = 1L;
            
            //O METODO paintComponent(Graphics g) FAZ A PINTURA NO JPanel 
            @Override
            public void paintComponent(Graphics g){
                g.drawImage(buffer, 0, 0, null);
            }
            /*
            Chama tanto a imagem especificada como está atualmente disponível. 
            A imagem é desenhada com o seu canto superior esquerdo em ( x ,  y )
            */
            @Override//NAO PODE PERDE ESPACO PARA AS BORDAS
            public Dimension getPreferredSize(){
                return new Dimension(JANELA_LARGURA, JANELA_ALTURA);
            }
            
            @Override//AQUI O TAMANHO MININO tela
            public Dimension getMinimumSize(){
                return getPreferredSize();
            }
        };
        
        getContentPane().add(tela);//ADICIONANDO A TELA NA MOLDURA
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//FECHAR JANELA
        //setSize(400, 400);//TAMANHO DA JANELA
        setTitle("Icarus Labyrintos");//TITUTLO DA JANELA
        setVisible(true);//MOSTRAR JANELA
        setResizable(false);//NAO DEIXA A JANELA SER REDIMENSIONADA
        setLocation(458, 159);//LOCALIZAÇÃO DA JANELA A SER GERADA
        pack();/*ESTE METODO DIZ A JANELA QUE O ESPACO QUE SE PRECISA É DE ACORDO
        AOS TAMANHOS DOS ELEMENTOS QUE ESTAO NELA*/
        tela.repaint();//FAZ OS COMPONENTES DE tela SE REPINTAREM EM ms
    }
    
    private void carregarJogo(){
        cenario = new CenarioMenu(tela.getWidth(), tela.getHeight());
        cenario.carregar();
    }
    
    public void iniciarJogo(){
        long prxAtualizacao = 0;
        
        while(true){
            if (System.currentTimeMillis() >= prxAtualizacao) {
                g2d.setColor(Color.BLACK);
                g2d.fillRect(0, 0, JANELA_LARGURA, JANELA_ALTURA);
                if (controleTecla[Tecla.ENTER.ordinal()]) {
                    //PRESSIONOU ENTER
                    if (cenario instanceof CenarioMenu) {
                        cenario.descarregar();
                        cenario = null;
                        
                        if (Jogo.nivel < Nivel.fases.length) {//PASSANDO DE FASE
                            cenario = new CenarioJogo(tela.getWidth(), tela.getHeight());
                        }
                        
                        cenario.carregar();
                        
                    }else{
                        //Jogo.pausado = !Jogo.pausado;
                        cenario.descarregar();
                        //cenario = null;
                        cenario = new CenarioJogo(tela.getWidth(), tela.getHeight());
                        cenario.carregar();
                    }
                    
                    liberarTeclas();
                    
                }else if (controleTecla[Tecla.ESC.ordinal()]) {
                    //PRESSIONOU ESC
                    if (!(cenario instanceof CenarioMenu)) {
                        cenario.descarregar();
                        cenario = null;
                        cenario = new CenarioMenu(tela.getWidth(), tela.getHeight());
                        cenario.carregar();
                    }
                    
                    liberarTeclas();
                    
                }
                
                if (cenario == null) {
                    g2d.setColor(Color.WHITE);
                    g2d.drawString("Carregando...", 20, 20);
                }else{
                    //if (!Jogo.pausado) {
                        cenario.atualizar();
                    //}
                    cenario.desenhar(g2d);
                }
                
                tela.repaint();
                prxAtualizacao = System.currentTimeMillis() + FPS;
            }//FIM if(System.currentTimeMillis() >= prxAtualizacao)
        }//FIM while
    }//FIM METODO iniciarJogo
    
    public static void main(String[] args){
        Jogo jogoNovo = new Jogo();
        jogoNovo.carregarJogo();
        jogoNovo.iniciarJogo();
    }
    /*Dentro do método iniciaAnimacao, usamos
System.currentTimeMillis para obter o tempo corrente em milésimos
de segundo, e quando esse tempo for maior ou igual ao valor
armazenado na variável prxAtualizacao, atualizamos o contador e
pintamos a tela novamente.
Depois, passamos o valor atualizado para executarmos a próxima atualização
e, assim, mantemos uma constância de frames por segundo até que o
contador chegue a 100. Manter a constância de tempo é muito importante, e
existem técnicas sofisticadas para isso
    a medida de
velocidade que usamos nos jogos é a de pixels por frame, ou Pixels per frame
(PPF).
    */
    
}
