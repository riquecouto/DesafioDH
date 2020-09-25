package br.com.digitalhouse.desafio

data class Curso(
    val codigoCurso: Int,
    val nome: String,
    val professorTitular: ProfessorTitular,
    val professorAdjunto: ProfessorAdjunto,
    val quantidadeMaximaAlunos: Int,
    val listaDeAlunos: MutableList<Aluno>) {

    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (codigoCurso == other.codigoCurso)
    }
}