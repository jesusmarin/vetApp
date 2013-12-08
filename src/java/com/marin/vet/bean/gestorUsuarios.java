package com.marin.vet.bean;

import com.marin.vet.controller.util.JsfUtil;
import com.marin.vet.entidad.Telefono;
import com.marin.vet.entidad.Usuario;
import com.marin.vet.facade.TelefonoFacade;
import com.marin.vet.facade.UsuarioFacade;
import com.marin.vet.util.ControlLetras;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jboss.weld.logging.messages.JsfMessage;

/**
 *
 * @author JesusMarin
 */
@ManagedBean(name = "gestorUsuariosBean")
@SessionScoped
public class gestorUsuarios implements Serializable {

    private Usuario usuario;
    private Telefono telefono;
    private String docId;
    private int elDiv;
    @EJB
    private UsuarioFacade usuarioEjb;
    @EJB
    private TelefonoFacade telefonoEjb;

    public gestorUsuarios() {
    }

    public String buscarUsuario() {
        elDiv = 0;
        iniciarUsuario();
        try {
            usuario = getUsuarioEjb().buscarUsuarioPorId(docId);
            JsfUtil.addSuccessMessage("Consultó a la base de datos");
            if (usuario == null) {
                elDiv = 2;// si el suaurio existe es 2
                iniciarUsuario();
            }else{
                elDiv = 1;
            }
        } catch (Exception e) {
            elDiv = 1;// si el suaurio existe es 1
            usuario = new Usuario();
            iniciarUsuario();
            JsfUtil.addErrorMessage("doi Catch a la base de datos");
        }
        return "usuarios";
    }

    private void iniciarUsuario() {
         ControlLetras cl = new ControlLetras();  
        usuario = new Usuario();
        usuario.setApellidos("apellido");
        usuario.setNombres("Nombre");
        usuario.setIdUsuario(-1);
        usuario.setEmail("mail@host.com");
        docId = cl.quitaEspaciosPuntosComas(docId);
        usuario.setDocId(docId);
    }

    public String guardarUsuario() {
        elDiv = 1;
        usuario=verifiqueLetras();
        try {
            getUsuarioEjb().create(usuario);
             JsfUtil.addSuccessMessage("Usuario se guardo corectamente");
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Error al guardar usuario");
        }
        return "usuarios";
    }
    

    private Usuario verifiqueLetras() {
        ControlLetras cl = new ControlLetras();        
        usuario.setApellidos(cl.pasaMayuscula(usuario.getApellidos()));
        usuario.setNombres(cl.pasaMayuscula(usuario.getNombres()));
        usuario.setDocId(cl.quitaEspaciosPuntosComas(docId));
        return usuario;
    }

    public UsuarioFacade getUsuarioEjb() {
        return usuarioEjb;
    }

    public TelefonoFacade getTelefonoEjb() {
        return telefonoEjb;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public int getElDiv() {
        return elDiv;
    }

    public void setElDiv(int elDiv) {
        this.elDiv = elDiv;
    }

}
