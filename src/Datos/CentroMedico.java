package Datos;
//Cespedes Torres Pedro Fabian

import Logic.Funcionario;
import Logic.Pacientes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CentroMedico {

    private static CentroMedico instance = null;
    private Map<String, Pacientes> pacientes;
    private Map<String, Funcionario> funcionarios;

    //constructor
    private CentroMedico() {

        pacientes = new HashMap<String, Pacientes>();
        funcionarios = new HashMap<String, Funcionario>();
    }

    public static CentroMedico getInstance() {
        if (instance == null) {
            instance = new CentroMedico();
        }
        return instance;
    }

    public void addPacientes(Pacientes x) throws Exception {

        Pacientes p = pacientes.get(x.getDni());
        if (p == null) {
            pacientes.put(x.getDni(), x);
        } else {
            throw new Exception("Paciente ya existente");

        }
    }

    public void addFuncionario(Funcionario x) throws Exception {

        Funcionario p = funcionarios.get(x.getUsername());
        if (p == null) {
            funcionarios.put(x.getUsername(), x);
        } else {
            throw new Exception("Funcionario ya existente");
        }
    }

    public List<Pacientes> getPacientes() {
        List<Pacientes> li = new ArrayList<>();
        for (Map.Entry<String, Pacientes> entry : pacientes.entrySet()) {
            li.add(entry.getValue());
        }
        return li;
    }

    public List<Funcionario> getFuncionario() {
        List<Funcionario> li = new ArrayList<>();
        for (Map.Entry<String, Funcionario> entry : funcionarios.entrySet()) {
            li.add(entry.getValue());
        }
        return li;
    }

    public List<Pacientes> getPacientePorDni(String dni) throws Exception {
        List<Pacientes> li = new ArrayList<>();
        Pacientes p = pacientes.get(dni);
        if (p != null) {
            li.add(p);
            return li;
        } else {
            throw new Exception("El paciente no existe");
        }

    }

    public List<Funcionario> getFuncionarioPorUser(String user) throws Exception {
        List<Funcionario> li = new ArrayList<>();
        Funcionario p = funcionarios.get(user);
        if (p != null) {
            li.add(p);
            return li;
        } else {
            throw new Exception("El funcionario no existe");
        }

    }
}
