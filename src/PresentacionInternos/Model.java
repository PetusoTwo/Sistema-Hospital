package PresentacionInternos;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;
import Logic.Pacientes;
import java.util.ArrayList;

public class Model extends Observable {

    private DefaultTableModel tabla;
    private final String[] colNames = {"Nombre", "Apellido Paterno", "Apellido Materno", "DNI", "Fecha", "Patologia"};
    private Pacientes p;
    private List<Pacientes> lis;
    private boolean editar;

    public Model() {
        p = new Pacientes();
        lis = new ArrayList<>();
        tabla = new DefaultTableModel(colNames, 0); // Inicializar con columnas vacías
        editar = false;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public DefaultTableModel getTabla() {
        return tabla;
    }

    public void setTabla(List<Pacientes> l) {
        lis = l;
        refresh();
    }

    public Pacientes getP() {
        return p;
    }

    public void setP(Pacientes p) {
        this.p = p;
        refresh();
    }

    public List<Pacientes> getLis() {
        return lis;
    }

    public void setLis(List<Pacientes> lis) {
        this.lis = lis;
        refresh();
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        refresh();
    }

    private void refresh() {
        // Limpiar modelo de tabla
        while (tabla.getRowCount() > 0) {
            tabla.removeRow(0);
        }

        // Rellenar tabla con datos actualizados
        for (Pacientes paciente : lis) {
            Object[] rowData = {paciente.getNombre(), paciente.getApellido1(), paciente.getApellido2(), paciente.getDni(), paciente.getFecha(), paciente.getPatologia()};
            tabla.addRow(rowData);
        }

        setChanged();
        notifyObservers();
    }
}
