package vista;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;

public class RegistrarCapitan extends JFrame implements IDatosParticipantes {

    private final JTextField txtName;
    private final JTextField txtCedula;
    private final JTextField txtAge;
    private final JTextField txtAñosExperiencia;
    private final JLabel textoDeIngreso;
    private final JButton btnSave;

    public RegistrarCapitan() {
        setTitle("Registro del capitán");
        setSize(400, 300); // Aumentamos el tamaño
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializamos los JTextField
        txtName = new JTextField(15);
        txtCedula = new JTextField(15);
        txtAge = new JTextField(15);
        txtAñosExperiencia = new JTextField(15);

        // Aplicamos filtros para restringir las entradas
        ((AbstractDocument) txtCedula.getDocument()).setDocumentFilter(new NumericFilter());
        ((AbstractDocument) txtAge.getDocument()).setDocumentFilter(new NumericFilter());
        ((AbstractDocument) txtAñosExperiencia.getDocument()).setDocumentFilter(new NumericFilter());

        btnSave = new JButton("Registrar capitán");
        btnSave.setBackground(new Color(79, 41, 41));
        btnSave.setForeground(Color.WHITE);

        // Creamos el JLabel con el texto deseado
        textoDeIngreso = new JLabel("> Ingrese los datos del capitán");
        textoDeIngreso.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiamos el tamaño y estilo de la fuente
        textoDeIngreso.setForeground(Color.BLACK);

        JPanel panel = new JPanel(new GridBagLayout()); // Usamos GridBagLayout para mejor organización
        panel.setBackground(new Color(198, 139, 139));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Añadimos espacio entre los componentes

        // Añadimos el JLabel en la parte superior del formulario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Hacemos que el JLabel ocupe dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centramos el texto
        panel.add(textoDeIngreso, gbc);

        // Añadimos los demás componentes
        gbc.gridwidth = 1; // Restauramos el valor de gridwidth
        gbc.anchor = GridBagConstraints.WEST; // Alineamos a la izquierda
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        panel.add(txtName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Cédula:"), gbc);
        gbc.gridx = 1;
        panel.add(txtCedula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Edad:"), gbc);
        gbc.gridx = 1;
        panel.add(txtAge, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Años Experiencia:"), gbc);
        gbc.gridx = 1;
        panel.add(txtAñosExperiencia, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(btnSave, gbc);

        this.add(panel);
    }

    // Método para agregar ActionListener a btnSave
    public void setRegistrarCapitan(ActionListener listener) {
        btnSave.addActionListener(listener);
    }

    //Método para obtener el valor de los TextField
    @Override
    public String obtenerNombrePersona() {
        return txtName.getText();
    }

    @Override
    public int obtenerCedulaPersona() {
        return Integer.parseInt(txtCedula.getText());
    }

    @Override
    public int obtenerEdadPersona() {
        return Integer.parseInt(txtAge.getText());
    }

    public int obtenerExperienciaCapitan() {
        return Integer.parseInt(txtAñosExperiencia.getText());
    }
    
    public void limpiarCampos() {
        txtName.setText("");
        txtCedula.setText("");
        txtAge.setText("");
        txtAñosExperiencia.setText("");
    }

    // Filtro para permitir solo números en los campos
    class NumericFilter extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) {
            if (string.matches("\\d*")) {
                try {
                    super.insertString(fb, offset, string, attr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) {
            if (text.matches("\\d*")) {
                try {
                    super.replace(fb, offset, length, text, attrs);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
