package br.com.digitalhouse.desafio

data class Curso(val nome: String, val codCurso: Int) {
    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (codCurso == other.codCurso)
    }
}