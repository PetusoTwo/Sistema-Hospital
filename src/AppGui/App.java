package AppGui;
//@Autor: Cespedes Torres Pedro Fabian

public class App {

    public static void main(String[] arg) {
        PresentacionInternos.View v1 = new PresentacionInternos.View();
        PresentacionInternos.Model m1 = new PresentacionInternos.Model();
        PresentacionInternos.Control c1 = new PresentacionInternos.Control(v1, m1);
        v1.setVisible(true);
    }

}
