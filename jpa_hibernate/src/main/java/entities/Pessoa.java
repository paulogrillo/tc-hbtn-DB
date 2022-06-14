package entities;
import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "dataDeNascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataDeNascimento;

    public Pessoa(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Calendar dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
