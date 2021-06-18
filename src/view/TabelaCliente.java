package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TabelaCliente extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList linhas = null;
	private String[] colunas = null;
	
	public TabelaCliente(ArrayList dados, String[] col) {
		setLinhas(dados);
		setColunas(col);
	}
	
	public ArrayList<Object[]> getLinhas() {
		return linhas;
	}

	public void setLinhas(ArrayList dados) {
		this.linhas = dados;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	public String getColumnName(int numCol) {
		return colunas[numCol];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object[] linha = (Object[]) getLinhas().get(rowIndex);
		
		return linha[columnIndex];
	}

}
