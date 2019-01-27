package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/** SpringBoot 2.0 cambia la libreria de NotEmpty e Email.
 * import org.hibernate.validator.constraints.Email;
 * import org.hibernate.validator.constraints.NotEmpty;
 * Por:
 * import javax.validation.constraints.Email;
 * import javax.validation.constraints.NotEmpty;
 **/
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty /* obligatorio añadir el campo */
	private String nombre;

	@NotEmpty /* obligatorio añadir el campo */
	private String apellido;

	@NotEmpty /* obligatorio añadir el campo */
	@Email /* con formato de email */
	private String email;

	@NotNull /* con formato no nulo */
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd") /* formato de fecha */
	private Date createAt;

	/*Un cliente muchas facturas, Lazy= única consulta, cascade= relación con sus elemtos hijos*/
	@OneToMany(mappedBy= "cliente", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Factura> facturas;
	
	public Cliente() {
		facturas = new ArrayList<Factura>();
	}

	private String foto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public void addFactura(Factura factura) {
		facturas.add(factura);
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}
	
	
}
