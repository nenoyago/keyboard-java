/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.sun.glass.events.KeyEvent;
import java.util.Random;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Yago Neno
 */
public class Pangram {

    private final String WORD[];

    // Constutor do Pangrama.
    public Pangram() {
        this.WORD = new String[17];

        this.WORD[0] = "Jane quer LP, fax, CD, giz, TV e bom whisky.";
        this.WORD[1] = "TV faz quengo explodir com whisky JB.";
        this.WORD[2] = "Bancos fúteis pagavam-lhe queijo e whisky xadrez.";
        this.WORD[3] = "Jovem ex-quenga picha frase da Blitz.";
        this.WORD[4] = "Blitz prende ex-vesgo com cheque fajuto.";
        this.WORD[5] = "Jovem craque belga prediz falhas no xote.";
        this.WORD[6] = "Um pequeno jabuti xereta viu dez cegonhas felizes.";
        this.WORD[7] = "Gazeta publica hoje breve nota de faxina na quermesse.";
        this.WORD[8] = "Juiz faz com que whisky de malte baixe logo preço de venda.";
        this.WORD[9] = "Zebras caolhas de Java querem mandar fax para moça gigante de New York.";
        this.WORD[10] = "Pangramas à beça jazem no sótão da memória-dervixe do faquir helênico.";
        this.WORD[11] = "Grave e cabisbaixo, o filho justo zelava pela querida mãe doente.";
        this.WORD[12] = "Marta foi à cozinha pois queria ver belo jogo de xícaras.";
        this.WORD[13] = "Hoje à noite, sem luz, decidi xeretar a quinta gaveta de vovô: achei lingüiça, pão e fubá.";
        this.WORD[14] = "Gafanhotos azuis celebram a pequena terra das jovens bruxas.";
        this.WORD[15] = "Um pequeno jabuti xereta viu dez cegonhas felizes.";
        this.WORD[16] = "Luís argüia à Júlia que brações, fé, chá, óxido, pôr, zângão eram palavras do português.";
    }

    // Gerador aleatória de 17 pangramas pré-definidos no vetor acima.
    public String generatePangrams() {
        Random generator = new Random();

        int i = generator.nextInt(WORD.length);
        return this.WORD[i];
    }

    public void setTextKeys(javax.swing.JTextArea textArea) {
        InputMap inputMap = textArea.getInputMap();

        // Quando teclar 'ENTER' vai ao final da linha sem apagar nada.
        KeyStroke key = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0, false);
        inputMap.put(key, DefaultEditorKit.endLineAction);
    }

    // Comparação do texto digitado com o pangrama gerado.
    public void compareText(javax.swing.JLabel lblPangram, javax.swing.JTextArea TextArea, javax.swing.JComponent component, java.awt.event.KeyEvent evt) {
        String textPangram = lblPangram.getText();
        String textArea = TextArea.getText();
        int totError = 0, backSpace = 0, space = 0, character = 0, result = 0;
        String number = "1234567890";
        float percent = 0f;

        if (textArea.equals(textPangram)) {
            JOptionPane.showMessageDialog(component, "Parabéns!!\nDigitação Correta", "Message", JOptionPane.INFORMATION_MESSAGE);

        } else if (!textArea.equals(textPangram)) {
            for (int j = 0; j < textPangram.length(); j++) {
                if (textArea.charAt(j) == ' ') {
                    space++;
                } else if (!textArea.contains(number)) {
                    character++;
                }
            }
            for (int i = 0; i < textPangram.length(); i++) {
                if ((textArea.charAt(i) != textPangram.charAt(i))) {
                    totError++;
                } else if (evt.getKeyCode() == KeyEvent.VK_BACKSPACE) {
                    backSpace++;
                }

                result = character - space;
                percent = (float) ((totError * 100) / result);
            }
            JOptionPane.showMessageDialog(component, "Digitação Incorreta\n\nErro(s): " + (totError + backSpace) + "\nPorcentagem de Erro(s): "
                    + String.format("%.1f%%", percent), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
