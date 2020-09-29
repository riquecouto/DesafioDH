package br.com.digitalhouse.desafio

abstract class Professor (
    val codigoProfessor: Int,
    val nome: String,
    val sobrenome: String,
    val tempoDeCasa: Int) {

    override fun equals(other: Any?): Boolean {
        return (other is Professor) && (codigoProfessor == other.codigoProfessor)
    }
}