package entities;

import javax.persistence.*;
import java.util.List;

public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long id;

    @Column(name = "nomeCompleto")
    private String nomeCompleto;

    @Column(name = "nomeCompleto")
    private String matricula;

    @Column(name = "nomeCompleto")
    private String email;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", foreignKey = @ForeignKey(name = "fk_curso"))
    private List<Curso> cursos;



    public Professor(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
