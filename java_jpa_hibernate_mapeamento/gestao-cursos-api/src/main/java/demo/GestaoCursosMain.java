package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

public class GestaoCursosMain {

    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        List<Aluno> alunoList;
        CursoModel cursoModel = new CursoModel();
        List<Curso> cursoList;

        //____MOCK OBJECTS_____//

        // Endereço 1
        Endereco endereco1 = new Endereco();
        endereco1.setEndereco("Av");
        endereco1.setNumero("1415");
        endereco1.setLogradouro("Catuaba");
        endereco1.setBairro("Jardim Ester");
        endereco1.setCep(5550622);
        endereco1.setCidade("São Paulo");
        endereco1.setEstado("SP");
        // Endereço 2
        Endereco endereco2 = new Endereco();
        endereco1.setEndereco("Rua");
        endereco1.setNumero("415");
        endereco1.setLogradouro("Lins de melo");
        endereco1.setBairro("Jardim Fernandes");
        endereco1.setCep(6665599);
        endereco1.setCidade("São Paulo");
        endereco1.setEstado("SP");
        // Telefone 1
        Telefone tel1 = new Telefone();
        tel1.setDDD("11");
        tel1.setNumero("2122-3344");
        // Telefone 2
        Telefone tel2 = new Telefone();
        tel2.setDDD("21");
        tel2.setNumero("2233-5566");
        // Materiais de estudo 1
        MaterialCurso materialCurso1 = new MaterialCurso();
        materialCurso1.setUrl("www.google.com.br");
        // Materiais de estudo 2
        MaterialCurso materialCurso2 = new MaterialCurso();
        materialCurso1.setUrl("www.fiap.com.br");
        // Professor 1
        System.out.println("####### CADASTRO DE PROFESSOR INICIADO #######");
        Professor professor1 = new Professor();
        professor1.setMatricula("RX1150");
        professor1.setNomeCompleto("Arthur Mendes");
        professor1.setEmail("arthurmendes@gmail.com");
        // Professor 2
        Professor professor2 = new Professor();
        professor1.setMatricula("RX7120");
        professor1.setNomeCompleto("joana Mello");
        professor1.setEmail("joanamello@gmail.com");



        /////// CRUD ALUNO ///////
        // ###### 1 Aluno (com um telefone e um endereço)

        // ----- CADASTRO ALUNO 1
        System.out.println("######## CADASTRO DE ALUNO INICIADO ##########");
        Aluno aluno1 = new Aluno();
        aluno1.setMatricula("MA762");
        aluno1.setNomeCompleto("Bruna Silva");
        aluno1.setNascimento(LocalDate.of(2001, 6, 20));
        aluno1.setEmail("bruncasilva@brunasilva.com.br");
        aluno1.setTelefones(new ArrayList<Telefone>(List.of(tel1)));
        aluno1.setEnderecos(new ArrayList<Endereco>(List.of(endereco1)));

        alunoModel.create(aluno1);

        // ----- CADASTRO ALUNO 2
        Aluno aluno2 = new Aluno();
        aluno2.setMatricula("MA862");
        aluno2.setNomeCompleto("Wesley Bernardo");
        aluno2.setNascimento(LocalDate.of(2000, 7, 24));
        aluno2.setEmail("wesley01@gmail.com");
        aluno2.setTelefones(new ArrayList<Telefone>(List.of(tel2)));
        aluno2.setEnderecos(new ArrayList<Endereco>(List.of(endereco2)));

        alunoModel.create(aluno2);

        // ----- CADASTRO ALUNO 3
        Aluno aluno3 = new Aluno();
        aluno3.setMatricula("MA888");
        aluno3.setNomeCompleto("Jose Bernardo");
        aluno3.setNascimento(LocalDate.of(1995, 2, 10));
        aluno3.setEmail("jose01@gmail.com");
        aluno3.setTelefones(new ArrayList<Telefone>(List.of(tel2)));
        aluno3.setEnderecos(new ArrayList<Endereco>(List.of(endereco2)));

        alunoModel.create(aluno3);

        ////// BUSCA ALUNO POR ID /////
        System.out.println("######## BUSCA ALUNO POR ID INICIADO ##########");
        Aluno findByIdAluno1 = new Aluno();
        findByIdAluno1.setId(1L);
        findByIdAluno1 = alunoModel.findById(findByIdAluno1);
        System.out.println("RESULTADO: "+findByIdAluno1);


        ////// BUSCA TODOS ALUNOS /////
        System.out.println("######## BUSCA TODOS ALUNOS INICIADO ##########");
        alunoList = alunoModel.findAll();
        System.out.println("RESULTADO: "+alunoList);

        ////// ATUALIZAR UM ALUNO /////
        System.out.println("######## ATUALIZAÇÃO DE ALUNO FOI INICIADO ##########");
        Aluno updateAlunoId3 = aluno3;
        updateAlunoId3.setId(3L);
        updateAlunoId3 = alunoModel.findById(updateAlunoId3);
        updateAlunoId3.setNomeCompleto("Marcos Silva");

        alunoModel.update(updateAlunoId3);

        // --- EXCLUSÃO ALUNO 3
        System.out.println("######## EXLUSÃO DE ALUNO INICIADO ##########");
        Aluno deleteAlunoId3 = new Aluno();
        deleteAlunoId3.setId(3L);

        alunoModel.delete(deleteAlunoId3);


        /////// CRUD CURSOS ///////
        // 1 curso (com um professor e um aluno)

        // -------- CURSO 1
        System.out.println("######## CADASTRO DE CURSOS INICIADO ##########");
        Curso curso1 = new Curso();
        curso1.setNome("Análise e Desenvolvimento de Sistemas");
        curso1.setSigla("ADS");
        curso1.setProfessor(professor1);
        curso1.setAlunos(new ArrayList<Aluno>(List.of(aluno1)));
        curso1.setMaterialCurso(materialCurso1);

        cursoModel.create(curso1);

        // -------- CURSO 2
        Curso curso2 = new Curso();
        curso2.setNome("Gestão de Marketing");
        curso2.setSigla("GM");
        curso2.setProfessor(professor2);
        curso2.setAlunos(new ArrayList<Aluno>(List.of(aluno2)));
        curso2.setMaterialCurso(materialCurso2);

        cursoModel.create(curso2);

        // -------- CURSO 3
        Curso curso3 = new Curso();
        curso3.setNome("Administração de Empresas");
        curso3.setSigla("ADM");
        curso3.setProfessor(professor1);
        curso3.setAlunos(new ArrayList<Aluno>(List.of(aluno1)));
        curso3.setMaterialCurso(materialCurso2);

        cursoModel.create(curso3);



        ////// BUSCA CURSO POR ID /////
        System.out.println("######## BUSCA CURSO POR ID INICIADO ##########");
        Curso findByIdCurso1 = new Curso();
        findByIdCurso1.setId(1L);
        findByIdCurso1 = cursoModel.findById(findByIdCurso1);

        System.out.println("RESULTADO: "+findByIdCurso1);


        ////// BUSCA TODOS OS CURSOS /////
        System.out.println("######## BUSCA TODOS OS CURSOS INICIADO ##########");
        cursoList = cursoModel.findAll();
        System.out.println("RESULTADO: "+cursoList);

        ////// ATUALIZAR UM CURSO /////
        System.out.println("######## ATUALIZAÇÃO DE CURSO FOI INICIADO ##########");
        Curso updateCursoId3 = curso3;
        updateCursoId3.setId(3L);
        updateCursoId3 = cursoModel.findById(updateCursoId3);
        updateCursoId3.setNome("ADMIN");

        cursoModel.update(updateCursoId3);

        // --- EXCLUSÃO CURSO 3
        System.out.println("######## EXLUSÃO DE CURSO INICIADO ##########");
        Curso deleteCursoId3 = new Curso();
        deleteCursoId3.setId(3L);

        cursoModel.delete(deleteCursoId3);

    }
}
