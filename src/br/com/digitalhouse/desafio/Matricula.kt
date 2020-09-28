package br.com.digitalhouse.desafio

import java.time.LocalDate

class Matricula(
    val aluno: Aluno,
    val curso: Curso) {

        val matricula = LocalDate.now()
}