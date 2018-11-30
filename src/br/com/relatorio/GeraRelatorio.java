package br.com.relatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.dao.ClassConecta;
import br.com.model.AssistidoVO;
import br.com.util.MissaoCenaUtil;

public class GeraRelatorio {

	private static final String fileName = "/home/julio/arquivos/planilha_excel_hoje.xls";

	private static ArrayList<AssistidoVO> getAssistidosHojeSQL() {
		ArrayList<AssistidoVO> listaAssitidos = new ArrayList<>();
		Statement stmt = null;
		try {
			// ClassDiaria CDiaria = new ClassDiaria();
			ClassConecta conexao = new ClassConecta();
			conexao.conecta();
			stmt = conexao.con.createStatement();

			ResultSet rs = stmt.executeQuery("Select * from assistido " + "inner join dia_assistido "
					+ "on assistido.id = dia_assistido.idAssistido " + "and dia_assistido.dataVisita = '"
					+ MissaoCenaUtil.getDataHojeString() + "'");
			int count = 0;
			while (rs.next()) {
				count++;
				AssistidoVO vo = new AssistidoVO();
				vo.setId(count);//Integer.parseInt(rs.getString(1)));
				vo.setNome(rs.getString(2));
				listaAssitidos.add(vo);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return listaAssitidos;
	}
	
	public static void geraRelatorioPlanilhaExcel() {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheetAlunos = workbook.createSheet("Alunos");

        ArrayList<AssistidoVO> listaAssitidos = getAssistidosHojeSQL();///new ArrayList<AssistidoVO>();
        int rownum = 0;
        for (AssistidoVO aluno : listaAssitidos) {
        	Row row = sheetAlunos.createRow(rownum++);
            int cellnum = 0;
            // celula para o id
            Cell cellNome = row.createCell(cellnum++);
            cellNome.setCellValue(aluno.getId());
            // celula para o nome
            Cell cellRa = row.createCell(cellnum++);
            cellRa.setCellValue(aluno.getNome());
       }

		try {
			FileOutputStream out = new FileOutputStream(new File(GeraRelatorio.fileName));
			workbook.write(out);
			out.close();
			System.out.println("Arquivo Excel criado com sucesso!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro na edição do arquivo!");
		}

	}

	public static void main(String[] args) throws IOException {
		geraRelatorioPlanilhaExcel();
	}

}
