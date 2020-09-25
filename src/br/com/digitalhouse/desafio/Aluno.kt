package br.com.digitalhouse.desafio

data class Aluno(val nome: String, val sobrenome: String, val codAluno: Int) {
    override fun equals(other: Any?): Boolean {
        return (other is Aluno) && (codAluno == other.codAluno)
    }
}