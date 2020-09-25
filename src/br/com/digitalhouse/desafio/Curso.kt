package br.com.digitalhouse.desafio

data class Curso(val nome: String, val codigoCurso: Int) {
    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (codigoCurso == other.codigoCurso)
    }
}