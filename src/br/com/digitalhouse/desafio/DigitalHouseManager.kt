package br.com.digitalhouse.desafio

class DigitalHouseManager{

    val listaDeAlunos = mutableListOf<Aluno>()
    val listaDeProfessores = mutableListOf<Professor>()
    val listaDeCursos = mutableListOf<Curso>()
    val listaDeMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        if (listaDeCursos.find {it.codigoCurso == codigoCurso} != null) {
            println("Curso $codigoCurso já existe")
            return
        }
        listaDeCursos.add(Curso(codigoCurso, nome, quantidadeMaximaDeAlunos))
        println("Curso $codigoCurso registrado com sucesso")
    }

    fun excluirCurso(codigoCurso: Int) {
        if (listaDeCursos.find {it.codigoCurso == codigoCurso} == null) {
            println("Curso $codigoCurso não existe")
            return
        }
        listaDeCursos.removeAll {it.codigoCurso == codigoCurso}
        println("Curso $codigoCurso excluído")
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        if (listaDeProfessores.find {it.codigoProfessor == codigoProfessor} != null) {
            println("Professor $codigoProfessor já existe")
            return
        }
        listaDeProfessores.add(ProfessorAdjunto(codigoProfessor, nome, sobrenome, 0, quantidadeDeHoras))
        println("Professor adjunto $codigoProfessor registrado com sucesso")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        if (listaDeProfessores.find {it.codigoProfessor == codigoProfessor} != null) {
            println("Professor $codigoProfessor já existe")
            return
        }
        listaDeProfessores.add(ProfessorTitular(codigoProfessor, nome, sobrenome, 0, especialidade))
        println("Professor titular $codigoProfessor registrado com sucesso")
    }

    fun excluirProfessor(codigoProfessor: Int) {
        if (listaDeProfessores.find {it.codigoProfessor == codigoProfessor} == null) {
            println("Professor $codigoProfessor não existe")
            return
        }
        listaDeProfessores.removeAll {it.codigoProfessor == codigoProfessor}
        println("Professor $codigoProfessor excluído")
    }

    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        if (listaDeAlunos.find {it.codigoAluno == codigoAluno} != null) {
            println("Aluno $codigoAluno já existe")
            return
        }
        listaDeAlunos.add(Aluno(codigoAluno, nome, sobrenome))
        println("Aluno $codigoAluno registrado com sucesso")
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val aluno = listaDeAlunos.find {it.codigoAluno == codigoAluno}
        val curso = listaDeCursos.find {it.codigoCurso == codigoCurso}

        if (aluno == null) {
            println("Aluno $codigoAluno não existe")
            return
        }
        if (curso == null) {
            println("Curso $codigoCurso não existe")
            return
        }
        if (curso.listaDeAlunos.size == curso.quantidadeMaximaDeAlunos) {
            println("Não há vagas disponíves no curso $codigoCurso")
            return
        }
        if (curso.adicionarUmAluno(aluno))
            println("Matrícula do aluno $codigoAluno no curso $codigoCurso efetuada com sucesso")
        else
            println("Aluno $codigoAluno já está matriculado no no curso $codigoCurso")
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val professorTitular = listaDeProfessores.find {it is ProfessorTitular && it.codigoProfessor == codigoProfessorTitular}
        val professorAdjunto = listaDeProfessores.find {it is ProfessorAdjunto && it.codigoProfessor == codigoProfessorAdjunto}
        val curso = listaDeCursos.find {it.codigoCurso == codigoCurso}

        if (professorTitular == null) {
            println("Professor titular $codigoProfessorTitular não existe")
            return
        }
        if (professorAdjunto == null) {
            println("Professor adjunto $codigoProfessorAdjunto não existe")
            return
        }
        if (curso == null) {
            println("Curso $codigoCurso não existe")
            return
        }

        curso.professorTitular = professorTitular as ProfessorTitular
        curso.professorAdjunto = professorAdjunto as ProfessorAdjunto
        println("Professores $codigoProfessorTitular e $codigoProfessorAdjunto alocados ao curso $codigoCurso")
    }
}