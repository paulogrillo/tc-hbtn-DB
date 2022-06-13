package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "dataDeNascimento")
    private Integer dataDeNascimento;

    @OneToMany
    @JoinTable(name = "produto_id")
    private List<Produto> produto;
}
