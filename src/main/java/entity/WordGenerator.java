package entity;

import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WordGenerator {

    public static void gerarDocumento(Passageiro[] passageiro) {
        try {
            XWPFDocument document = new XWPFDocument();
            
            // Título do Documento
            XWPFParagraph title = document.createParagraph();
            XWPFRun titleRun = title.createRun();
            titleRun.setText("RELAÇÃO DOS PASSAGEIROS");
            titleRun.setBold(true);
            titleRun.setFontSize(20);
            
            // Tabela
            XWPFTable table = document.createTable();
            XWPFTableRow headerRow = table.getRow(0);
            headerRow.getCell(0).setText("ORDEM");
            headerRow.addNewTableCell().setText("NOME");
            headerRow.addNewTableCell().setText("Nº do RG");
            headerRow.addNewTableCell().setText("ORDEM");
            headerRow.addNewTableCell().setText("NOME");
            headerRow.addNewTableCell().setText("Nº do RG");
            
            // Preenchendo a tabela com os dados dos passageiros
            for (int i = 0; i < passageiro.length; i += 2) {
                XWPFTableRow row = table.createRow();
                
                // Primeira coluna de dados
                row.getCell(0).setText(String.format("%02d", i + 1));
                row.getCell(1).setText(passageiro[i] != null ? passageiro[i].getNome() : "");
                row.getCell(2).setText(passageiro[i] != null ? passageiro[i].getCpf() : "");
                
                // Segunda coluna de dados
                if (i + 1 < passageiro.length) {
                    row.getCell(3).setText(String.format("%02d", i + 2));
                    row.getCell(4).setText(passageiro[i + 1] != null ? passageiro[i + 1].getNome() : "");
                    row.getCell(5).setText(passageiro[i + 1] != null ? passageiro[i + 1].getCpf() : "");
                } else {
                    row.getCell(3).setText("");
                    row.getCell(4).setText("");
                    row.getCell(5).setText("");
                }
            }
            
            // Campos Informações
            addField(document, "Nome do Motorista");
            addField(document, "Aparência do Motorista");
            addField(document, "Número da Placa");
            addField(document, "Número do Ônibus");
            addField(document, "Estado dos Pneus");
            addField(document, "Banheiro");
            addField(document, "Sim");
            addField(document, "Não");
            addField(document, "Extintor de Incêndio");
            addField(document, "Sim");
            addField(document, "Não");
            addField(document, "Estado do Ônibus e Limpeza");
           
            // Adicionar observação
            XWPFParagraph obs = document.createParagraph();
            XWPFRun obsRun = obs.createRun();
            obsRun.setText("*Obs. Por favor tirar uma foto dessas informações, por segurança");
            obsRun.setItalic(true);
            
            String filePath = "Relacao-Passageiros.docx";
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                document.write(out);
            }
            
            // Verificar arquivo criado
            File file = new File(filePath);
            if (file.exists()) {
                System.out.print("Documento Word criado com sucesso!");
            } else {
                System.out.println("Falha ao criar o documento Word.");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addField(XWPFDocument document, String fieldName) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(fieldName);
    }
}
