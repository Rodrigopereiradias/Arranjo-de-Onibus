package aplication;

import javax.swing.*;
import java.awt.*;
import entity.Onibus;
import entity.Passageiro;
import entity.WordGenerator;

public class Main {

    public static void main(String[] args) {
        // Configurar o tamanho da fonte
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 18));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 18));
        UIManager.put("OptionPane.inputFont", new Font("Arial", Font.PLAIN, 18));

        Onibus onibus = new Onibus(46);

        for (int i = 0; i < onibus.getTotalVagas(); i++) {
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Banco " + (i + 1)));

            JTextField nomeField = new JTextField(10);
            panel.add(new JLabel("Nome:"));
            panel.add(nomeField);

            JTextField cpfField = new JTextField(10);
            panel.add(new JLabel("CPF:"));
            panel.add(cpfField);

            JTextField idadeField = new JTextField(10);
            panel.add(new JLabel("Idade:"));
            panel.add(idadeField);

            JTextField sexoField = new JTextField(10);
            panel.add(new JLabel("Sexo (M/F):"));
            panel.add(sexoField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Relação de Passageiros", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }

            String nome = nomeField.getText();
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.", "Relação de Passageiros", JOptionPane.ERROR_MESSAGE);
                i--;
                continue;
            }

            String cpf = cpfField.getText();
            if (cpf.isEmpty()) {
                JOptionPane.showMessageDialog(null, "CPF não pode ser vazio.", "Relação de Passageiros", JOptionPane.ERROR_MESSAGE);
                i--;
                continue;
            }
            cpf = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

            String idadeStr = idadeField.getText();
            if (idadeStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Idade não pode ser vazia.", "Relação de Passageiros", JOptionPane.ERROR_MESSAGE);
                i--;
                continue;
            }
            int idade;
            try {
                idade = Integer.parseInt(idadeStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Idade deve ser um número.", "Relação de Passageiros", JOptionPane.ERROR_MESSAGE);
                i--;
                continue;
            }

            String sexoStr = sexoField.getText();
            if (sexoStr.isEmpty() || (!sexoStr.equalsIgnoreCase("M") && !sexoStr.equalsIgnoreCase("F"))) {
                JOptionPane.showMessageDialog(null, "Sexo deve ser 'M' ou 'F'.", "Relação de Passageiros", JOptionPane.ERROR_MESSAGE);
                i--;
                continue;
            }
            boolean sexo = sexoStr.equalsIgnoreCase("M");

            Passageiro passageiro = new Passageiro(nome, cpf, idade, sexo);
            onibus.adicionaPassageiro(passageiro, i);

            // Exibir informações da vaga atualizada
            String vagaInfo = "Banco " + (i + 1) + ": Nome: " + passageiro.getNome() + ", CPF: " + passageiro.getCpf() + ", Idade: " + passageiro.getIdade() + ", Sexo: " + (passageiro.isSexo() ? "Masculino" : "Feminino");
            JOptionPane.showMessageDialog(null, vagaInfo, "Relação de Passageiros", JOptionPane.INFORMATION_MESSAGE);
        }

        StringBuilder vagas = new StringBuilder();
        for (int i = 0; i < onibus.getTotalVagas(); i++) {
            if (onibus.getVagas()[i] != null) {
                vagas.append("Vaga ").append(i).append(": ").append(onibus.getVagas()[i].getNome()).append("\n");
            } else {
                vagas.append("Vaga ").append(i).append(": Vazia\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Passageiros no ônibus:\n" + vagas.toString(), "Relação de Passageiros", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "O programa foi criado com sucesso na pasta Documentos com o nome Relacao-Passageiros", "Relação de Passageiros", JOptionPane.INFORMATION_MESSAGE);
        
        // Gerar o documento Word
        WordGenerator.gerarDocumento(onibus.getVagas());
    }
}
