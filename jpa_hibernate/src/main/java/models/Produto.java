package models;

import javax.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco")
    private double preco;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @Column()
    @JoinTable(name = "pessoa_id")
    private Pessoa pessoa;

}
