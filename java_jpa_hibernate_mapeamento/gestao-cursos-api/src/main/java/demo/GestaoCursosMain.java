package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) {

        CursoModel cursoModel = new CursoModel();
        List<Curso> cursos;

        AlunoModel alunoModel = new AlunoModel();
        List<Aluno> alunos;

        //=========== CADASTRO MOCK TELEFONE =============
        Telefone tel1 = new Telefone();
        tel1.setDdd("11");
        tel1.setNumero("0000-0000");

        Telefone tel2 = new Telefone();
        tel2.setDdd("11");
        tel2.setNumero("1111-1111");

        Telefone tel3 = new Telefone();
        tel3.setDdd("21");
        tel3.setNumero("9999-9999");

        //=========== CADASTRO MOCK ENDEREÇO =============
        Endereco end1 = new Endereco();
        end1.setLogradouro("Av");
        end1.setEndereco("Dos Campanellas");
        end1.setNumero("2000");
        end1.setBairro("Itaquera");
        end1.setCidade("São Paulo");
        end1.setEstado("SP");
        end1.setCep(00000000);

        Endereco end2 = new Endereco();
        end2.setLogradouro("Rua");
        end2.setEndereco("Jose Almeida");
        end2.setNumero("1020");
        end2.setBairro("Centro");
        end2.setCidade("São Paulo");
        end2.setEstado("SP");
        end2.setCep(00000000);

        //=========== CRUD ALUNO =============
        System.out.println("--> Criando Aluno-1 e Aluno 2");
        Aluno aluno1 = new Aluno();
        aluno1.setNomeCompleto("Paulo Grillo");
        aluno1.setMatricula("RM171");
        aluno1.setNascimento(LocalDate.of(1994,06,8));
        aluno1.setEmail("pgrillo@pgrillo.com");
        aluno1.setTelefones(new ArrayList<Telefone>(List.of(tel1)));
        aluno1.setEnderecos(new ArrayList<Endereco>(List.of(end1)));
        alunoModel.create(aluno1);

        Aluno aluno2 = new Aluno();
        aluno2.setNomeCompleto("Afonso Soares");
        aluno2.setMatricula("RM002");
        aluno2.setNascimento(LocalDate.of(1996,8,10));
        aluno2.setEmail("afon012@gmail.com");
        aluno2.setTelefones(new ArrayList<Telefone>(List.of(tel2)));
        aluno2.setEnderecos(new ArrayList<Endereco>(List.of(end2)));

        alunoModel.create(aluno2);

        // ---> Buscando Todos os Alunos
        System.out.println("--> findAll Alunos");
        alunos = alunoModel.findAll();
        System.out.println(alunos);

        // ---> Buscando Aluno id (1)
        System.out.println("--> findById (1)");
        Aluno searchAlunoId1 = new Aluno();

        searchAlunoId1.setId(1L);
        searchAlunoId1 = alunoModel.findById(searchAlunoId1);
        System.out.println(searchAlunoId1);


        // ---> Deletando Aluno id (2)
        System.out.println("--> Deletando Aluno id (2)");
        Aluno deleteAlunoId2 = new Aluno();
        deleteAlunoId2.setId(2L);
        alunoModel.delete(deleteAlunoId2);

        // 5: Buscando Todos os Alunos
        System.out.println("--> findAll Alunos");
        alunos = alunoModel.findAll();
        System.out.println(alunos);

        // ---> Autalizando Nome do Aluno-1
        System.out.println("--> Atualizando Aluno id (1)");
        Aluno updateAlunoId1 = new Aluno();
        updateAlunoId1.setId(1L);
        updateAlunoId1 = alunoModel.findById(updateAlunoId1);
        updateAlunoId1.setNomeCompleto("Jose Almeida");
        alunoModel.update(updateAlunoId1);

        // 5: Buscando Todos os Alunos
        System.out.println("--> findAll Alunos");
        alunos = alunoModel.findAll();
        System.out.println(alunos);



        // =========== CRUD PROFESSORES =============
        Professor prof1 = new Professor();
        prof1.setNomeCompleto("Elvis Antonio");
        prof1.setMatricula("RMA001");
        prof1.setEmail("elvis@fiap.com");

        Professor prof2 = new Professor();
        prof2.setNomeCompleto("Marcos Silva");
        prof2.setMatricula("RMA002");
        prof2.setEmail("marcos@fiap.com");

        Professor prof3 = new Professor();
        prof3.setNomeCompleto("Jose Almeida");
        prof3.setMatricula("RMA001");
        prof3.setEmail("jose@fiap.com");


        MaterialCurso material1 = new MaterialCurso();
        material1.setUrl("www.google.com");

        MaterialCurso material2 = new MaterialCurso();
        material2.setUrl("www.fiap.com");

        // ---> Criando Curso-1 com Professor-1 e MaterialCurso-1
        System.out.println("\n---> Criando Cursos");
        Curso curso1 = new Curso();
        curso1.setNome("Sistemas de Informação");
        curso1.setSigla("SI");
        curso1.setProfessor(prof1);
        curso1.setMaterialCurso(material1);
        cursoModel.create(curso1);

        Curso curso2 = new Curso();
        curso2.setNome("Analise e Desenvolvimento de Sistemas");
        curso2.setSigla("ADS");
        curso2.setProfessor(prof2);
        curso2.setMaterialCurso(material2);
        cursoModel.create(curso2);

        // ---> Buscando Todos os Cursos
        System.out.println("\n---> Buscando Todos os Cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);

        // ---> Buscando Curso id (1)
        System.out.println("\n---> Buscando Curso id (1)");
        Curso searchCursoId1 = new Curso();
        searchCursoId1.setId(1L);
        searchCursoId1 = cursoModel.findById(searchCursoId1);
        System.out.println(searchCursoId1);

        // ---> Deletando Curso id (2)
        System.out.println("\n---> Deletando Curso id (2)");
        Curso deleteCursoId2 = new Curso();
        deleteCursoId2.setId(2L);
        cursoModel.delete(deleteCursoId2);

        // ---> Buscando Todos os Cursos
        System.out.println("\n---> Buscando Todos os Cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);


        // ---> Autalizando Nome do Curso 1
        System.out.println("\n---> Autalizando Nome do Curso id (1)");
        Curso updateCursoId1 = new Curso();
        updateCursoId1.setId(1L);
        updateCursoId1 = cursoModel.findById(updateCursoId1);
        updateCursoId1.setNome("CURSO ATUALIZADO PARA -->  Engenharia da Computação");
        cursoModel.update(updateCursoId1);

        // ---> Buscando Todos os Cursos
        System.out.println("\n---> Buscando Todos os Cursos");
        cursos = cursoModel.findAll();
        System.out.println(cursos);

    }
}