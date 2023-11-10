
package DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CFuncionarios {
    
    private String id;
    private String tipoDocumento;
    private String nombres;
    private String apellidos;
    private String estadoCivil;
    private String sexo;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private String universidad;
    private String nivelEstudio;
    private String titulo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void MostrarFuncionario(JTable paramTablaTotalFuncionario){
    
    Conexion objetoConexion = new Conexion();
    
        DefaultTableModel modelo  = new DefaultTableModel();
        
        
        String sql="";
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("TipoDocumento");
        modelo.addColumn("EstadoCivil");
        modelo.addColumn("Sexo");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("FechaNacimiento");
        modelo.addColumn("NivelEstudio");
        modelo.addColumn("Universidad");
        modelo.addColumn("Titulo");
        
        paramTablaTotalFuncionario.setModel(modelo);
        
        sql = "Select* from Funcionarios";
        
        String [] datos  = new String [12];
        Statement st;
        
        try {
            
            st = objetoConexion.getConnection().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
            
               datos[0] = rs.getString(1);
               datos[1] = rs.getString(2);
               datos[2] = rs.getString(3);
               datos[3] = rs.getString(4);
               datos[4] = rs.getString(5);
               datos[5] = rs.getString(6);
               datos[6] = rs.getString(7);
               datos[7] = rs.getString(8);
               datos[8] = rs.getString(9);
               datos[9] = rs.getString(10);
               datos[10] = rs.getString(11);
               datos[11] = rs.getString(12);
               
               modelo.addRow(datos);
                
            }
            
            paramTablaTotalFuncionario.setModel(modelo);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:"+e.toString());
        }
    }
     
    public void insertarFuncionario(JTextField paramId, JTextField paramNombres, JTextField paramApellidos, JTextField paramTipoDocumento,  JTextField paramEstadoCivil,JTextField  paramSexo, JTextField paramDireccion, JTextField paramTelefono, JTextField paramFechaNacimiento, JTextField paramNivelEstudio, JTextField paramUniversidad, JTextField paramTitulo){
        setId(paramId.getText());
        setNombres(paramNombres.getText());
        setApellidos(paramApellidos.getText());
        setTipoDocumento(paramTipoDocumento.getText());
        setEstadoCivil(paramEstadoCivil.getText());
        setSexo(paramSexo.getText());
        setDireccion(paramDireccion.getText());
        setTelefono(paramTelefono.getText());
        setFechaNacimiento(paramFechaNacimiento.getText());
        setUniversidad(paramUniversidad.getText());
        setNivelEstudio(paramNivelEstudio.getText());
        setTitulo(paramTitulo.getText());
        
        Conexion objetoConexion = new Conexion();
        
        String consulta  = "insert into Funcionarios (id, tipoDocumento, nombres, apellidos, estadoCivil, sexo, direccion, telefono, fechaNacimiento, universidad, nivelEstudio,titulo) values (?,?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            
            CallableStatement cs  = objetoConexion.getConnection().prepareCall(consulta);
            cs.setString(1, getId());
            cs.setString(2, getTipoDocumento());
            cs.setString(3, getNombres());
            cs.setString(4, getApellidos());
            cs.setString(5, getEstadoCivil());
            cs.setString(6, getSexo());
            cs.setString(7, getDireccion());
            cs.setString(8, getTelefono());
            cs.setString(9, getFechaNacimiento());
            cs.setString(10, getUniversidad());
            cs.setString(11, getNivelEstudio());
            cs.setString(12, getTitulo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        
    }
    
    public void SeleccionarAlumno(JTable paramTablaFuncionario, JTextField paramCodigo, JTextField paramId, JTextField paramNombres, JTextField paramApellidos, JTextField paramTipoDocumento,  JTextField paramEstadoCivil,JTextField  paramSexo, JTextField paramDireccion, JTextField paramTelefono, JTextField paramFechaNacimiento, JTextField paramNivelEstudio, JTextField paramUniversidad, JTextField paramTitulo){
        
        try {
            int fila = paramTablaFuncionario.getSelectedRow();
            
            if (fila>=0) {
                paramCodigo.setText(paramTablaFuncionario.getValueAt(fila, 0).toString());
                paramId.setText(paramTablaFuncionario.getValueAt(fila, 1).toString());
                paramNombres.setText(paramTablaFuncionario.getValueAt(fila, 2).toString());
                paramApellidos.setText(paramTablaFuncionario.getValueAt(fila, 3).toString());
                paramTipoDocumento.setText(paramTablaFuncionario.getValueAt(fila, 4).toString());
                paramEstadoCivil.setText(paramTablaFuncionario.getValueAt(fila, 5).toString());
                paramSexo.setText(paramTablaFuncionario.getValueAt(fila, 6).toString());
                paramDireccion.setText(paramTablaFuncionario.getValueAt(fila, 7).toString());
                paramTelefono.setText(paramTablaFuncionario.getValueAt(fila, 8).toString());
                paramFechaNacimiento.setText(paramTablaFuncionario.getValueAt(fila, 9).toString());
                paramNivelEstudio.setText(paramTablaFuncionario.getValueAt(fila, 10).toString());
                paramUniversidad.setText(paramTablaFuncionario.getValueAt(fila, 11).toString());
                paramTitulo.setText(paramTablaFuncionario.getValueAt(fila, 12).toString());
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Fila no Seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
    }

    void SeleccionarFuncionarios(JTable TBFuncionarios, JTextField JTApellido, JTextField JTApellido0, JTextField JTNombre, JTextField JTApellido1, JTextField JTNumeroDoc, JTextField JTNumeroDoc0, JTextField JTApellido2, JTextField JTDireccion, JTextField JTTelefono, JTextField JTDireccion0, JTextField JTUniversidad, JTextField JTUniversidad0, JTextField JTApellido3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void ModificarFuncionario(JTextField paramCodigo, JTextField paramId, JTextField paramNombres, JTextField paramApellidos, JTextField paramTipoDocumento,  JTextField paramEstadoCivil,JTextField  paramSexo, JTextField paramDireccion, JTextField paramTelefono, JTextField paramFechaNacimiento, JTextField paramNivelEstudio, JTextField paramUniversidad, JTextField paramTitulo){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setId(paramId.getText());
        setNombres(paramNombres.getText());
        setApellidos(paramApellidos.getText());
        setTipoDocumento(paramTipoDocumento.getText());
        setEstadoCivil(paramEstadoCivil.getText());
        setSexo(paramSexo.getText());
        setDireccion(paramDireccion.getText());
        setTelefono(paramTelefono.getText());
        setFechaNacimiento(paramFechaNacimiento.getText());
        setUniversidad(paramUniversidad.getText());
        setNivelEstudio(paramNivelEstudio.getText());
        setTitulo(paramTitulo.getText());
        
        Conexion objetoConexion = new Conexion();
        
        String consulta  = "UPDATE  Funcionarios set id= ?, tipoDocumento = ?, nombres = ?, apellidos= ?, estadoCivil=?, sexo=?, direccion=?, telefono=?, fechaNacimiento=?, universidad=?, nivelEstudio=?,titulo=?, WHERE.id=?) values (?,?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            
            CallableStatement cs  = objetoConexion.getConnection().prepareCall(consulta);
            cs.setString(1, getId());
            cs.setString(2, getTipoDocumento());
            cs.setString(3, getNombres());
            cs.setString(4, getApellidos());
            cs.setString(5, getEstadoCivil());
            cs.setString(6, getSexo());
            cs.setString(7, getDireccion());
            cs.setString(8, getTelefono());
            cs.setString(9, getFechaNacimiento());
            cs.setString(10, getUniversidad());
            cs.setString(11, getNivelEstudio());
            cs.setString(12, getTitulo());
            cs.setString(13, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        
        
        
        
    }
    public void EliminarFuncionario(JTextField paramCodigo){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        
        
        Conexion objetoConexion = new Conexion();
        
        String consulta  = "DELETE  FROM Funcionarios WHERE id= ?, tipoDocumento = ?, nombres = ?, apellidos= ?, estadoCivil=?, sexo=?, direccion=?, telefono=?, fechaNacimiento=?, universidad=?, nivelEstudio=?,titulo=?, WHERE.id=?) values (?,?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            
            CallableStatement cs  = objetoConexion.getConnection().prepareCall(consulta);
        
            cs.setString(1, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:"+ e.toString());
        }
        
    }


    private void setCodigo(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    }
    
    



