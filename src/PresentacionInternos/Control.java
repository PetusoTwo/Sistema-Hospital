package PresentacionInternos;

import Logic.Pacientes;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Control {

    private View view;
    private Model model;
//contructor

    public Control(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setControl(this);
        view.setModel(model);

    }

    public void agregar(boolean editar, String name, String apellidoP, String apellidoM, String dni, Date fecha, String patologia) {
        Pacientes x = new Pacientes(name, apellidoP, apellidoM, dni, fecha, patologia);
        try {
            if (!editar) {
                Datos.CentroMedico.getInstance().addPacientes(x);
                List<Pacientes> li = Datos.CentroMedico.getInstance().getPacientes();
                model.setLis(li);
            } else {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        model.setP(new Pacientes());
        model.setEditar(false);

    }

    void cancelar() {
        model.setP(new Pacientes());

    }

    public void buscarPorDni(String str) {

        try {
            List<Pacientes> li = Datos.CentroMedico.getInstance().getPacientePorDni(str);
            model.setLis(li);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        model.setP(new Pacientes());

    }

    public void CargarTodos() {
        List<Pacientes> li = Datos.CentroMedico.getInstance().getPacientes();
        model.setLis(li);

    }
}
