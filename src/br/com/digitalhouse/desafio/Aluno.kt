package br.com.digitalhouse.desafio

data class Aluno(
    val codigoAluno: Int,
    val nome: String,
    val sobrenome: String) {

    override fun equals(other: Any?): Boolean {
        return (other is Aluno) && (codigoAluno == other.codigoAluno)
    }
}