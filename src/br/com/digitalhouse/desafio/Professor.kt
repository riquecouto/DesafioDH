package br.com.digitalhouse.desafio

class Professor(val nome: String, val sobrenome: String, val codProfessor: Int) {
    override fun equals(other: Any?): Boolean {
        return (other is Professor) && (codProfessor == other.codProfessor)
    }
}