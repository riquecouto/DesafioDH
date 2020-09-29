package br.com.digitalhouse.desafio

class DigitalHouseManager{

    val listaDeAlunos = mutableListOf<Aluno>()
    val listaDeProfessores = mutableListOf<Professor>()
    val listaDeCursos = mutableListOf<Curso>()
    val listaDeMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        val novoCurso = Curso(codigoCurso, nome, quantidadeMaximaDeAlunos)
        if (listaDeCursos.contains(novoCurso)) {
            println("Curso já existe")
            return
        }
        listaDeCursos.add(novoCurso)
    }

    fun excluirCurso(codigoCurso: Int) {
        val curso = Curso(codigoCurso, "", 0)
        if (!listaDeCursos.contains(curso)) {
            println("Curso não existe")
            return
        }
        listaDeCursos.remove(curso)
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val novoProfessor = ProfessorAdjunto(codigoProfessor, nome, sobrenome, 0, quantidadeDeHoras)
        if (listaDeProfessores.contains(novoProfessor)) {
            println("Professor já existe")
            return
        }
        listaDeProfessores.add(novoProfessor)
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val novoProfessor = ProfessorTitular(codigoProfessor, nome, sobrenome, 0, especialidade)
        if (listaDeProfessores.contains(novoProfessor)) {
            println("Professor já existe")
            return
        }
        listaDeProfessores.add(novoProfessor)
    }

    fun excluirProfessor(codigoProfessor: Int) {
        if (listaDeProfessores.find {it.codigoProfessor == codigoProfessor} == null) {
            println("Professor não existe")
            return
        }
        listaDeProfessores.removeAll {it.codigoProfessor == codigoProfessor}
        println("Professor excluído")
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno:Int) {
        val novoAluno = Aluno(codigoAluno, nome, sobrenome)
        if (listaDeAlunos.contains(novoAluno)) {
            println("Aluno já existe")
            return
        }
        listaDeAlunos.add(novoAluno)
    }
}