package br.com.digitalhouse.desafio

data class Aluno(val nome: String, val sobrenome: String, val codigoAluno: Int) {
    override fun equals(other: Any?): Boolean {
        return (other is Aluno) && (codigoAluno == other.codigoAluno)
    }
}