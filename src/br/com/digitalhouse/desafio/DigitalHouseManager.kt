package br.com.digitalhouse.desafio

class DigitalHouseManager{

    val listaDeAlunos = mutableListOf<Aluno>()
    val listaDeProfessores = mutableListOf<Professor>()
    val listaDeCursos = mutableListOf<Curso>()
    val listaDeMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        if (listaDeCursos.find {it.codigoCurso == codigoCurso} != null) {
            println("Curso já existe")
            return
        }
        listaDeCursos.add(Curso(codigoCurso, nome, quantidadeMaximaDeAlunos))
        println("Curso registrado com sucesso")
    }

    fun excluirCurso(codigoCurso: Int) {
        if (listaDeCursos.find {it.codigoCurso == codigoCurso} == null) {
            println("Curso não existe")
            return
        }
        listaDeCursos.removeAll {it.codigoCurso == codigoCurso}
        println("Professor excluído")
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        if (listaDeProfessores.find {it.codigoProfessor == codigoProfessor} != null) {
            println("Professor já existe")
            return
        }
        listaDeProfessores.add(ProfessorAdjunto(codigoProfessor, nome, sobrenome, 0, quantidadeDeHoras))
        println("Professor adjunto registrado com sucesso")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        if (listaDeProfessores.find {it.codigoProfessor == codigoProfessor} != null) {
            println("Professor já existe")
            return
        }
        listaDeProfessores.add(ProfessorTitular(codigoProfessor, nome, sobrenome, 0, especialidade))
        println("Professor titular registrado com sucesso")
    }

    fun excluirProfessor(codigoProfessor: Int) {
        if (listaDeProfessores.find {it.codigoProfessor == codigoProfessor} == null) {
            println("Professor não existe")
            return
        }
        listaDeProfessores.removeAll {it.codigoProfessor == codigoProfessor}
        println("Professor excluído")
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        if (listaDeAlunos.find {it.codigoAluno == codigoAluno} != null) {
            println("Aluno já existe")
            return
        }
        listaDeAlunos.add(Aluno(codigoAluno, nome, sobrenome))
        println("Aluno registrado com sucesso")
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val aluno = listaDeAlunos.find {it.codigoAluno == codigoAluno}
        val curso = listaDeCursos.find {it.codigoCurso == codigoCurso}

        if (aluno == null) {
            println("Aluno não existe")
            return
        }
        if (curso == null) {
            println("Curso não existe")
            return
        }
        if (curso.listaDeAlunos.size == curso.quantidadeMaximaDeAlunos) {
            println("Não há vagas disponíves")
            return
        }
        if (curso.adicionarUmAluno(aluno))
            println("Matrícula efetuada com sucesso")
        else
            println("Aluno já matriculado")
    }

    fun alocarProfessores(codigoCurso: Int,codigoProfessorTitular:  Int, codigoProfessorAdjunto:Int) {
        val professorTitular = listaDeProfessores.find {it.codigoProfessor == codigoProfessorTitular}
        val professorAdjunto = listaDeProfessores.find {it.codigoProfessor == codigoProfessorAdjunto}
        val curso = listaDeCursos.find {it.codigoCurso == codigoCurso}

        if (professorTitular == null) {
            println("Professor titular não existe")
            return
        }
        if (professorAdjunto == null) {
            println("Professor adjunto não existe")
            return
        }
        if (curso == null) {
            println("Curso não existe")
            return
        }
        curso.professorTitular = professorTitular as ProfessorTitular
    }
}