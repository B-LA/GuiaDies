package sv.edu.udb.www.entities;
// Generated 10-24-2019 06:58:52 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Libros generated by hbm2java
 */
@Entity
@Table(name="libros"
    ,catalog="inventario_libros"
)
public class Libros  implements java.io.Serializable {


     private String codigoLibro;
     private Autores autores;
     private Editoriales editoriales;
     private Generos generos;
     private String nombreLibro;
     private int existencias;
     private BigDecimal precio;
     private String descripcion;

    public Libros() {
    }

	
    public Libros(String codigoLibro, Autores autores, Editoriales editoriales, Generos generos, String nombreLibro, int existencias, BigDecimal precio) {
        this.codigoLibro = codigoLibro;
        this.autores = autores;
        this.editoriales = editoriales;
        this.generos = generos;
        this.nombreLibro = nombreLibro;
        this.existencias = existencias;
        this.precio = precio;
    }
    public Libros(String codigoLibro, Autores autores, Editoriales editoriales, Generos generos, String nombreLibro, int existencias, BigDecimal precio, String descripcion) {
       this.codigoLibro = codigoLibro;
       this.autores = autores;
       this.editoriales = editoriales;
       this.generos = generos;
       this.nombreLibro = nombreLibro;
       this.existencias = existencias;
       this.precio = precio;
       this.descripcion = descripcion;
    }
   
     @Id 

    
    @Column(name="codigo_libro", unique=true, nullable=false, length=9)
    public String getCodigoLibro() {
        return this.codigoLibro;
    }
    
    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_autor", nullable=false)
    public Autores getAutores() {
        return this.autores;
    }
    
    public void setAutores(Autores autores) {
        this.autores = autores;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_editorial", nullable=false)
    public Editoriales getEditoriales() {
        return this.editoriales;
    }
    
    public void setEditoriales(Editoriales editoriales) {
        this.editoriales = editoriales;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_genero", nullable=false)
    public Generos getGeneros() {
        return this.generos;
    }
    
    public void setGeneros(Generos generos) {
        this.generos = generos;
    }

    
    @Column(name="nombre_libro", nullable=false, length=50)
    public String getNombreLibro() {
        return this.nombreLibro;
    }
    
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    
    @Column(name="existencias", nullable=false)
    public int getExistencias() {
        return this.existencias;
    }
    
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    
    @Column(name="precio", nullable=false, precision=10)
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    
    @Column(name="descripcion", length=65535)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}

