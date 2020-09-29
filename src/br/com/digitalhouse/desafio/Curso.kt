package br.com.digitalhouse.desafio

data class Curso(
    val codigoCurso: Int,
    val nome: String,
    val quantidadeMaximaDeAlunos: Int) {

    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null
    var listaDeAlunos = mutableListOf<Aluno>()

    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (codigoCurso == other.codigoCurso)
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        if (!listaDeAlunos.contains(umAluno) && listaDeAlunos.size < quantidadeMaximaDeAlunos) {
            listaDeAlunos.add(umAluno)
            return true
        }
        return false
    }

    fun excluirAluno(umAluno: Aluno) {
        if (listaDeAlunos.contains(umAluno))
            listaDeAlunos.remove(umAluno)
    }
}