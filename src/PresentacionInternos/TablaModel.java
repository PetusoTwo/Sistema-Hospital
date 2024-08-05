package PresentacionInternos;

import Logic.Pacientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TablaModel extends AbstractTableModel {

    private List<Pacientes> row;
    private int[] col;
    private String[] colsName = {"Nombre", "Apellido paterno", "Apellido materno", "DNI",
         "Patologia", "Fecha de entrada"};

    public TablaModel(List<Pacientes> row, int[] col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int getRowCount() {
        return row.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Pacientes p = row.get(i);
        switch(i1){
            case 0: return p.getNombre(); 
            case 1: return p.getApellido1(); 
            case 2: return p.getApellido2(); 
            case 3: return p.getDni(); 
            case 4: return p.getPatologia(); 
            case 5: return p.getFecha(); 
            default: return ""; 
        }
    }

    @Override
    public String getColumnName(int i) {
        
        return colsName[i]; 

    }
}
