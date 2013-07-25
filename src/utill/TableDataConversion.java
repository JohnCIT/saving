package utill;

/**
 * @author john
 * version 1
 */

import java.math.BigDecimal;

import javax.swing.table.DefaultTableModel;

public class TableDataConversion {
	
	/**
	 * Convert the table data model into a 2D array
	 * @param dtm Data table model
	 * @return 2D array
	 */
	public static Object[][] getTableDataAsArray(DefaultTableModel dtm)
	{
		int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
		Object[][] tableData = new Object[nRow][nCol];
		for (int i = 0 ; i < nRow ; i++)
			for (int j = 0 ; j < nCol ; j++)
				tableData[i][j] = dtm.getValueAt(i,j);
		return tableData;
	}
	
	
	/**
	 * Get the second row of the table data model as big decimal format
	 * @param dtm Data table model
	 * @return a single array of the second row the table data model
	 */
	public static BigDecimal[] getTableModelAsBigDecimalArray(DefaultTableModel dtm)
	{
		int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
		BigDecimal[] tableData = new BigDecimal[nRow];
		for (int i = 0 ; i < nRow ; i++)
			for (int j = 0 ; j < nCol ; j++)
				tableData[i] = (BigDecimal) dtm.getValueAt(i,j);
		return tableData;
	}
	

}
