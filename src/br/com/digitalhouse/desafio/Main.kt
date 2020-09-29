package br.com.digitalhouse.desafio

fun main() {
    val manager = DigitalHouseManager()

    manager.registrarProfessorTitular("Ana", "Silva", 101, "Android")
    manager.registrarProfessorTitular("Paulo", "Souza", 102, "SQL")

    manager.registrarProfessorAdjunto("Célia", "Matos", 201, 500)
    manager.registrarProfessorAdjunto("Heitor", "Rios", 202, 600)

    manager.registrarCurso("Full Stack", 20001, 3)
    manager.registrarCurso("Android", 20002, 2)

    manager.alocarProfessores(20001, 101, 201)
    manager.alocarProfessores(20002, 102, 202)

    manager.registrarAluno("Henrique", "Yang", 301)
    manager.registrarAluno("Maria", "Joaquina", 302)
    manager.registrarAluno("Igor", "Pereira", 303)
    manager.registrarAluno("Joana", "Almeida", 304)

    manager.matricularAluno(301, 20001)
    manager.matricularAluno(302, 20001)

    manager.matricularAluno(302, 20002)
    manager.matricularAluno(303, 20002)
    manager.matricularAluno(304, 20002)

    manager.consultarMatriculasAluno(302)

/*
    println("\n--- TESTES ADICIONAIS ---")

    manager.registrarAluno("Paulo", "Cesar", 304)
    manager.registrarAluno("Paulo", "Cesar", 309)
    manager.consultarMatriculasAluno(309)

    manager.excluirProfessor(202)
    manager.excluirCurso(20002)
*/
}